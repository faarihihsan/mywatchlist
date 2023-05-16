package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.show.CreateShow;
import com.mfaarihihsan.mywatchlist.entities.show.DetailShow;
import com.mfaarihihsan.mywatchlist.entities.show.ShowList;
import com.mfaarihihsan.mywatchlist.entities.show.UpdateShow;

public interface ShowService {
    public ShowList getListShow(PaginationRequest paginationRequest);
    public ShowList searchShow(String title, PaginationRequest paginationRequest);
    public DetailShow createShow(CreateShow createShow);
    public DetailShow updateShow(UpdateShow updateShow);
    public DetailShow getDetailShow(Integer id);
}
