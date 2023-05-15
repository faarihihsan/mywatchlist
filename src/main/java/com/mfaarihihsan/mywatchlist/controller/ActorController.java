package com.mfaarihihsan.mywatchlist.controller;

import com.mfaarihihsan.mywatchlist.payload.request.actor.CreateActorRequest;
import com.mfaarihihsan.mywatchlist.payload.request.PaginationRequest;
import com.mfaarihihsan.mywatchlist.payload.request.actor.UpdateActorRequest;
import com.mfaarihihsan.mywatchlist.payload.response.actor.ActorResponse;
import com.mfaarihihsan.mywatchlist.payload.response.actor.ListActorResponse;
import com.mfaarihihsan.mywatchlist.service.ActorService;
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
            ListActorResponse actorModels = actorService.getListActor(new PaginationRequest(page, itemPerPage));
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
            ListActorResponse actorResponse = actorService.searchActor(name, new PaginationRequest(page, itemPerPage));
            return ResponseEntity.ok().body(actorResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity createActor(
            @RequestBody CreateActorRequest createActorRequest
            ) {
        try {
            ActorResponse actorResponse = actorService.createActor(createActorRequest);
            return ResponseEntity.ok().body(actorResponse);
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
            @RequestBody UpdateActorRequest updateActorRequest
            ) {
        try {
            ActorResponse actorResponse = actorService.updateActor(updateActorRequest);
            return ResponseEntity.ok().body(actorResponse);
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
