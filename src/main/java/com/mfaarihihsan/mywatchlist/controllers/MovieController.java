package com.mfaarihihsan.mywatchlist.controllers;

import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.movie.CreateMovieRequest;
import com.mfaarihihsan.mywatchlist.entities.movie.UpdateMovieRequest;
import com.mfaarihihsan.mywatchlist.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/list")
    public ResponseEntity getListMovie(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer itemPerPage
    ) {
        try {
            PaginationRequest paginationRequest = new PaginationRequest(page, itemPerPage);
            return ResponseEntity.ok().body(movieService.getListMovie(paginationRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity searchMovie(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer itemPerPage
    ) {
        try {
            PaginationRequest paginationRequest = new PaginationRequest(page, itemPerPage);
            return ResponseEntity.ok().body(movieService.searchMovie(name, paginationRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity createMovie(
            @RequestBody CreateMovieRequest createMovieRequest
            ) {
        try {
            return ResponseEntity.ok().body(movieService.createMovie(createMovieRequest));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateMovie(
            @RequestBody UpdateMovieRequest updateMovieRequest
            ) {
        try {
            return ResponseEntity.ok().body(movieService.updateMovie(updateMovieRequest));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity getDetailMovie(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok().body(movieService.getDetailMovie(id));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
