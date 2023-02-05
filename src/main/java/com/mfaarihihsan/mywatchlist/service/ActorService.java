package com.mfaarihihsan.mywatchlist.service;

import com.mfaarihihsan.mywatchlist.model.ActorModel;

import java.util.List;

public interface ActorService {
    public List<ActorModel> getListActor();
    public List<ActorModel> searchActor(String name);
}
