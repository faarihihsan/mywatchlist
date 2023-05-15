package com.mfaarihihsan.mywatchlist.controllers;

import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.series.CreateSeriesRequest;
import com.mfaarihihsan.mywatchlist.entities.series.UpdateSeriesRequest;
import com.mfaarihihsan.mywatchlist.services.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("series")
public class SeriesController {
    private final SeriesService seriesService;

    @GetMapping("/list")
    public ResponseEntity GetListSeries(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer itemPerPage
    ) {
        try {
            PaginationRequest paginationRequest = new PaginationRequest(page, itemPerPage);
            return ResponseEntity.ok().body(seriesService.getListSeries(paginationRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity searchSeries(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer itemPerPage
    ) {
        try {
            PaginationRequest paginationRequest = new PaginationRequest(page, itemPerPage);
            return ResponseEntity.ok().body(seriesService.searchSeries(name, paginationRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PostMapping("/create")
    public ResponseEntity createSeries(
            @RequestBody CreateSeriesRequest createSeriesResponse
            ) {
        try {
            return ResponseEntity.ok().body(seriesService.createSeries(createSeriesResponse));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateSeries(
            @RequestBody UpdateSeriesRequest updateSeriesRequest
            ) {
        try {
            return ResponseEntity.ok().body(seriesService.updateSeries(updateSeriesRequest));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity getDetailSeries(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok().body(seriesService.getDetailSeries(id));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
