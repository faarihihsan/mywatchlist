package com.mfaarihihsan.mywatchlist.service;

import com.mfaarihihsan.mywatchlist.payload.request.actor.CreateActorRequest;
import com.mfaarihihsan.mywatchlist.payload.request.PaginationRequest;
import com.mfaarihihsan.mywatchlist.payload.request.actor.UpdateActorRequest;
import com.mfaarihihsan.mywatchlist.payload.response.actor.ActorResponse;
import com.mfaarihihsan.mywatchlist.payload.response.actor.DetailActorResponse;
import com.mfaarihihsan.mywatchlist.payload.response.actor.ListActorResponse;

public interface ActorService {
    public DetailActorResponse GetDetailActor(Integer id);
    public ListActorResponse getListActor(PaginationRequest paginationRequest);
    public ListActorResponse searchActor(String name, PaginationRequest paginationRequest);
    public ActorResponse createActor(CreateActorRequest createActorRequest);
    public ActorResponse updateActor(UpdateActorRequest updateActorRequest);
}
