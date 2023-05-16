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
    public ActorList getListActor(PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());
        Page<ActorModel> actors = actorDb.findAll(pageable);

        return getListActorResponse(actors);
    }

    @Override
    public ActorList searchActor(String name, PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());

        Page<ActorModel> actorsDb = actorDb.findActorModelsByName(name, pageable);

        return getListActorResponse(actorsDb);
    }

    private ActorList getListActorResponse(Page<ActorModel> actorsDb) {
        List<Actor> actorList = actorsDb.getContent().stream().map(actorModel -> new Actor(actorModel.getId(), actorModel.getName())).toList();
        PaginationResponse paginationResponse = new PaginationResponse(
                actorsDb.getNumber(),
                actorsDb.getSize(),
                actorsDb.getTotalPages(),
                actorsDb.getTotalElements()
        );
        ActorList res = new ActorList(actorList, paginationResponse);

        return res;
    }

    @Override
    public Actor createActor(CreateActor createActor) {
        ActorModel newActor = new ActorModel(createActor.getName());
        ActorModel savedActor = actorDb.save(newActor);
        return new Actor(savedActor.getId(), savedActor.getName());
    }

    @Override
    public Actor updateActor(UpdateActor updateActor) {
        ActorModel targetActor = actorDb.findById(updateActor.getId())
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Actor with id %s is not found", updateActor.getId())
                ));
        targetActor.setName(updateActor.getName());
        ActorModel savedActor = actorDb.save(targetActor);
        return new Actor(savedActor.getId(), savedActor.getName());
    }

    @Override
    public DetailActor GetDetailActor(Integer id) {
        ActorModel actorModel = actorDb.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Actor with id %s is not found", id)));

        return new DetailActor(
                actorModel.getId(),
                actorModel.getName(),
                actorModel.getMovies().stream()
                        .map(movie -> new MovieActor(
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
                        .map(series -> new SeriesActor(
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
