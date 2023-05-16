package com.mfaarihihsan.mywatchlist.controllers;

import com.mfaarihihsan.mywatchlist.entities.actor.CreateActor;
import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.actor.UpdateActor;
import com.mfaarihihsan.mywatchlist.entities.actor.Actor;
import com.mfaarihihsan.mywatchlist.entities.actor.ActorList;
import com.mfaarihihsan.mywatchlist.services.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("actor")
public class ActorController {
    private final ActorService actorService;

    @GetMapping("/list")
    public ResponseEntity getListActor(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer itemPerPage) {
        try {
            ActorList actorModels = actorService.getListActor(new PaginationRequest(page, itemPerPage));
            return ResponseEntity.ok().body(actorModels);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity SearchActor(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer itemPerPage
    ) {
        try {
            ActorList actorResponse = actorService.searchActor(name, new PaginationRequest(page, itemPerPage));
            return ResponseEntity.ok().body(actorResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity createActor(
            @RequestBody CreateActor createActor
            ) {
        try {
            Actor actor = actorService.createActor(createActor);
            return ResponseEntity.ok().body(actor);
        } catch (NoSuchElementException e) {
          e.printStackTrace();
          return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateActor(
            @RequestBody UpdateActor updateActor
            ) {
        try {
            Actor actor = actorService.updateActor(updateActor);
            return ResponseEntity.ok().body(actor);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity getDetailActor(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok().body(actorService.GetDetailActor(id));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
