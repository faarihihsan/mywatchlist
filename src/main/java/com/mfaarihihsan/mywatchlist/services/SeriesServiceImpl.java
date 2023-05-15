package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.models.ActorModel;
import com.mfaarihihsan.mywatchlist.models.ActorSeriesModel;
import com.mfaarihihsan.mywatchlist.models.SeriesModel;
import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.series.CreateSeriesRequest;
import com.mfaarihihsan.mywatchlist.entities.series.UpdateSeriesRequest;
import com.mfaarihihsan.mywatchlist.entities.PaginationResponse;
import com.mfaarihihsan.mywatchlist.entities.series.CastSeriesResponse;
import com.mfaarihihsan.mywatchlist.entities.series.DetailSeriesResponse;
import com.mfaarihihsan.mywatchlist.entities.series.ListSeriesResponse;
import com.mfaarihihsan.mywatchlist.entities.series.SeriesResponse;
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
    public ListSeriesResponse getListSeries(PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());
        Page<SeriesModel> seriesList = seriesDb.findAll(pageable);
        return getListSeriesResponse(seriesList);
    }

    @Override
    public ListSeriesResponse searchSeries(String title, PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());
        Page<SeriesModel> series = seriesDb.findSeriesModelByTitle(title.toLowerCase(), pageable);

        return getListSeriesResponse(series);
    }

    private ListSeriesResponse getListSeriesResponse(Page<SeriesModel> seriesModels) {
        List<SeriesResponse> seriesResponseList = seriesModels.getContent().stream()
                .map(seriesModel -> new SeriesResponse(
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

        return new ListSeriesResponse(seriesResponseList, paginationResponse);
    }

    @Override
    public DetailSeriesResponse createSeries(CreateSeriesRequest createSeriesRequest) {
        SeriesModel newSeries = new SeriesModel(
                null,
                createSeriesRequest.getTitle(),
                createSeriesRequest.getYear(),
                createSeriesRequest.getRating(),
                createSeriesRequest.getEpisodes(),
                null
        );
        SeriesModel savedSeries = seriesDb.save(newSeries);
        List<ActorSeriesModel> actorSeriesModels = createSeriesRequest.getCasts().stream().map(
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
    public DetailSeriesResponse updateSeries(UpdateSeriesRequest updateSeriesRequest) {
        SeriesModel targetSeries = seriesDb.findById(updateSeriesRequest.getSeriesId())
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Series with id %s is not found", updateSeriesRequest.getSeriesId())
                ));

        targetSeries.setTitle(updateSeriesRequest.getTitle());
        targetSeries.setYear(updateSeriesRequest.getYear());
        targetSeries.setRating(updateSeriesRequest.getRating());
        targetSeries.setEpisodes(updateSeriesRequest.getEpisodes());
        SeriesModel savedSeries = seriesDb.save(targetSeries);

        List<ActorSeriesModel> targetCastList = updateSeriesRequest.getCasts().stream().map(cast -> {
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

    private DetailSeriesResponse getDetailSeriesResponse(SeriesModel savedSeries, List<ActorSeriesModel> savedCast) {
        return new DetailSeriesResponse(
                savedSeries.getId(),
                savedSeries.getTitle(),
                savedSeries.getYear(),
                savedSeries.getRating(),
                savedSeries.getEpisodes(),
                savedCast.stream().map(cast -> new CastSeriesResponse(
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
    public DetailSeriesResponse getDetailSeries(Integer id) {
        SeriesModel seriesModel = seriesDb.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Series with id %s is not found", id)));

        return new DetailSeriesResponse(
                seriesModel.getId(),
                seriesModel.getTitle(),
                seriesModel.getYear(),
                seriesModel.getRating(),
                seriesModel.getEpisodes(),
                seriesModel.getCasts().stream()
                        .map(cast -> new CastSeriesResponse(
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
