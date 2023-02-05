package com.mfaarihihsan.mywatchlist.service;

import com.mfaarihihsan.mywatchlist.model.ActorModel;
import com.mfaarihihsan.mywatchlist.repository.ActorDb;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService{
    private final ActorDb actorDb;

    @Override
    public List<ActorModel> getListActor() {
        return actorDb.findAll();
    }

    @Override
    public List<ActorModel> searchActor(String name) {
        List<ActorModel> actors = actorDb.findActorModelsByName(name).orElse(actorDb.findAll());
        return actors;
    }


}
