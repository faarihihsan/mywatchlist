package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.models.ActorModel;
import com.mfaarihihsan.mywatchlist.models.ActorSeriesModel;
import com.mfaarihihsan.mywatchlist.models.SeriesModel;
import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.series.CreateSeries;
import com.mfaarihihsan.mywatchlist.entities.series.UpdateSeries;
import com.mfaarihihsan.mywatchlist.entities.PaginationResponse;
import com.mfaarihihsan.mywatchlist.entities.series.SeriesCast;
import com.mfaarihihsan.mywatchlist.entities.series.DetailSeries;
import com.mfaarihihsan.mywatchlist.entities.series.SeriesList;
import com.mfaarihihsan.mywatchlist.entities.series.Series;
import com.mfaarihihsan.mywatchlist.repositories.ActorDb;
import com.mfaarihihsan.mywatchlist.repositories.ActorSeriesDb;
import com.mfaarihihsan.mywatchlist.repositories.SeriesDb;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class SeriesServiceImpl implements SeriesService{
    private final SeriesDb seriesDb;
    private final ActorDb actorDb;
    private final ActorSeriesDb actorSeriesDb;

    @Override
    public SeriesList getListSeries(PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());
        Page<SeriesModel> seriesList = seriesDb.findAll(pageable);
        return getListSeriesResponse(seriesList);
    }

    @Override
    public SeriesList searchSeries(String title, PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());
        Page<SeriesModel> series = seriesDb.findSeriesModelByTitle(title.toLowerCase(), pageable);

        return getListSeriesResponse(series);
    }

    private SeriesList getListSeriesResponse(Page<SeriesModel> seriesModels) {
        List<Series> seriesList = seriesModels.getContent().stream()
                .map(seriesModel -> new Series(
                            seriesModel.getId(),
                            seriesModel.getTitle(),
                            seriesModel.getYear(),
                            seriesModel.getRating(),
                            seriesModel.getEpisodes()
                    )).toList();

        PaginationResponse paginationResponse = new PaginationResponse(
                seriesModels.getNumber(),
                seriesModels.getSize(),
                seriesModels.getTotalPages(),
                seriesModels.getTotalElements()
        );

        return new SeriesList(seriesList, paginationResponse);
    }

    @Override
    public DetailSeries createSeries(CreateSeries createSeries) {
        SeriesModel newSeries = new SeriesModel(
                null,
                createSeries.getTitle(),
                createSeries.getYear(),
                createSeries.getRating(),
                createSeries.getEpisodes(),
                null
        );
        SeriesModel savedSeries = seriesDb.save(newSeries);
        List<ActorSeriesModel> actorSeriesModels = createSeries.getCasts().stream().map(
                cast -> {
                    ActorModel targetActor = actorDb.findById(cast.getActorId())
                            .orElseThrow(() -> new NoSuchElementException(
                                    String.format("Actor with id %s is not found", cast.getActorId())
                            ));
                    return new ActorSeriesModel(
                            null,
                            targetActor,
                            savedSeries,
                            cast.getCharacter(),
                            cast.isMain(),
                            cast.isSupport(),
                            cast.isGuest(),
                            cast.getAppearOnEpisodes()
                    );
                }).toList();
        List<ActorSeriesModel> savedCasts = actorSeriesDb.saveAll(actorSeriesModels);

        return getDetailSeriesResponse(savedSeries, savedCasts);
    }

    @Override
    public DetailSeries updateSeries(UpdateSeries updateSeries) {
        SeriesModel targetSeries = seriesDb.findById(updateSeries.getSeriesId())
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Series with id %s is not found", updateSeries.getSeriesId())
                ));

        targetSeries.setTitle(updateSeries.getTitle());
        targetSeries.setYear(updateSeries.getYear());
        targetSeries.setRating(updateSeries.getRating());
        targetSeries.setEpisodes(updateSeries.getEpisodes());
        SeriesModel savedSeries = seriesDb.save(targetSeries);

        List<ActorSeriesModel> targetCastList = updateSeries.getCasts().stream().map(cast -> {
            ActorModel targetActor = actorDb.findById(cast.getActorId()).orElseThrow(() ->
                    new NoSuchElementException(String.format("Actor with id %s not found", cast.getActorId())));
            ActorSeriesModel targetCast = new ActorSeriesModel();

            if (cast.getCastId() != null) targetCast = actorSeriesDb.findById(cast.getCastId()).orElseThrow(
                    () -> new NoSuchElementException(String.format("Cast with id %s not found", cast.getCastId())));

            targetCast.setActor(targetActor);
            targetCast.setSeries(targetSeries);
            targetCast.setCharacter(cast.getCharacter());
            targetCast.setMain(cast.isMain());
            targetCast.setSupport(cast.isSupport());
            targetCast.setGuest(cast.isGuest());
            targetCast.setAppear_on_episodes(cast.getAppearOnEpisodes());

            return targetCast;
        }).toList();

        List<ActorSeriesModel> savedCast = actorSeriesDb.saveAll(targetCastList);

        return getDetailSeriesResponse(savedSeries, savedCast);
    }

    private DetailSeries getDetailSeriesResponse(SeriesModel savedSeries, List<ActorSeriesModel> savedCast) {
        return new DetailSeries(
                savedSeries.getId(),
                savedSeries.getTitle(),
                savedSeries.getYear(),
                savedSeries.getRating(),
                savedSeries.getEpisodes(),
                savedCast.stream().map(cast -> new SeriesCast(
                        cast.getId(),
                        cast.getActor().getName(),
                        cast.getActor().getId(),
                        cast.getCharacter(),
                        cast.isMain(),
                        cast.isSupport(),
                        cast.isGuest(),
                        cast.getAppear_on_episodes()
                )).toList()
        );
    }

    @Override
    public DetailSeries getDetailSeries(Integer id) {
        SeriesModel seriesModel = seriesDb.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Series with id %s is not found", id)));

        return new DetailSeries(
                seriesModel.getId(),
                seriesModel.getTitle(),
                seriesModel.getYear(),
                seriesModel.getRating(),
                seriesModel.getEpisodes(),
                seriesModel.getCasts().stream()
                        .map(cast -> new SeriesCast(
                                cast.getId(),
                                cast.getActor().getName(),
                                cast.getActor().getId(),
                                cast.getCharacter(),
                                cast.isMain(),
                                cast.isSupport(),
                                cast.isGuest(),
                                cast.getAppear_on_episodes()
                        )).toList()
        );
    }
}
