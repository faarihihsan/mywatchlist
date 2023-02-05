package com.mfaarihihsan.mywatchlist.controller;

import com.mfaarihihsan.mywatchlist.model.ActorModel;
import com.mfaarihihsan.mywatchlist.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ActorController {
    private final ActorService actorService;

    @GetMapping("/actors")
    public ResponseEntity getListActor() {
        try {
            List<ActorModel> actorModels = actorService.getListActor();
            return ResponseEntity.ok().body(actorModels);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
