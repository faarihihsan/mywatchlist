package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.entities.actor.CreateActorRequest;
import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.actor.UpdateActorRequest;
import com.mfaarihihsan.mywatchlist.entities.actor.ActorResponse;
import com.mfaarihihsan.mywatchlist.entities.actor.DetailActorResponse;
import com.mfaarihihsan.mywatchlist.entities.actor.ListActorResponse;

public interface ActorService {
    public DetailActorResponse GetDetailActor(Integer id);
    public ListActorResponse getListActor(PaginationRequest paginationRequest);
    public ListActorResponse searchActor(String name, PaginationRequest paginationRequest);
    public ActorResponse createActor(CreateActorRequest createActorRequest);
    public ActorResponse updateActor(UpdateActorRequest updateActorRequest);
}
