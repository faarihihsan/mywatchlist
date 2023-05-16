package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.entities.actor.CreateActor;
import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.actor.UpdateActor;
import com.mfaarihihsan.mywatchlist.entities.actor.Actor;
import com.mfaarihihsan.mywatchlist.entities.actor.DetailActor;
import com.mfaarihihsan.mywatchlist.entities.actor.ActorList;

public interface ActorService {
    public DetailActor GetDetailActor(Integer id);
    public ActorList getListActor(PaginationRequest paginationRequest);
    public ActorList searchActor(String name, PaginationRequest paginationRequest);
    public Actor createActor(CreateActor createActor);
    public Actor updateActor(UpdateActor updateActor);
}
