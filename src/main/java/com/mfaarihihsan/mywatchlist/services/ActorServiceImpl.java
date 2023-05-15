package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.entities.actor.*;
import com.mfaarihihsan.mywatchlist.models.ActorModel;
import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.PaginationResponse;
import com.mfaarihihsan.mywatchlist.repositories.ActorDb;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorDb actorDb;

    @Override
    public ListActorResponse getListActor(PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());

        Page<ActorModel> actors = actorDb.findAll(pageable);

        return getListActorResponse(actors);
    }

    @Override
    public ListActorResponse searchActor(String name, PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());

        Page<ActorModel> actorsDb = actorDb.findActorModelsByName(name, pageable);

        return getListActorResponse(actorsDb);
    }

    private ListActorResponse getListActorResponse(Page<ActorModel> actorsDb) {
        List<ActorResponse> actorResponseList = actorsDb.getContent().stream().map(actorModel -> new ActorResponse(actorModel.getId(), actorModel.getName())).toList();
        PaginationResponse paginationResponse = new PaginationResponse(
                actorsDb.getNumber(),
                actorsDb.getSize(),
                actorsDb.getTotalPages(),
                actorsDb.getTotalElements()
        );
        ListActorResponse res = new ListActorResponse(actorResponseList, paginationResponse);

        return res;
    }

    @Override
    public ActorResponse createActor(CreateActorRequest createActorRequest) {
        ActorModel newActor = new ActorModel(createActorRequest.getName());
        ActorModel savedActor = actorDb.save(newActor);
        return new ActorResponse(savedActor.getId(), savedActor.getName());
    }

    @Override
    public ActorResponse updateActor(UpdateActorRequest updateActorRequest) {
        ActorModel targetActor = actorDb.findById(updateActorRequest.getId())
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Actor with id %s is not found", updateActorRequest.getId())
                ));
        targetActor.setName(updateActorRequest.getName());
        ActorModel savedActor = actorDb.save(targetActor);
        return new ActorResponse(savedActor.getId(), savedActor.getName());
    }

    @Override
    public DetailActorResponse GetDetailActor(Integer id) {
        ActorModel actorModel = actorDb.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Actor with id %s is not found", id)));

        return new DetailActorResponse(
                actorModel.getId(),
                actorModel.getName(),
                actorModel.getMovies().stream()
                        .map(movie -> new ActorMovieResponse(
                            movie.getId(),
                            movie.getMovie().getTitle(),
                            movie.getMovie().getId(),
                            movie.getCharacter(),
                            movie.getMovie().getYear(),
                            movie.isMain(),
                            movie.isSupport(),
                            movie.isGuest()
                    )).toList(),
                actorModel.getSeries().stream()
                        .map(series -> new ActorSeriesResponse(
                                series.getId(),
                                series.getSeries().getTitle(),
                                series.getSeries().getId(),
                                series.getCharacter(),
                                series.getSeries().getYear(),
                                series.isMain(),
                                series.isSupport(),
                                series.isGuest()
                        )).toList()
        );
    }
}
