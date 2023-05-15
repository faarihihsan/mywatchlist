package com.mfaarihihsan.mywatchlist.controller;

import com.mfaarihihsan.mywatchlist.payload.request.PaginationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("show")
public class ShowController {
    @GetMapping("/list")
    public ResponseEntity GetListShow(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer itemPerPage
    ) {
        try {
            PaginationRequest paginationRequest = new PaginationRequest(page, itemPerPage);
            return ResponseEntity.ok().body("belumg manggil service");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity searchShow(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer itemPerPage
    ) {
        try {
            PaginationRequest paginationRequest = new PaginationRequest(page, itemPerPage);
            return ResponseEntity.ok().body("belum manggil service");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity createShow() {
        try {
            return ResponseEntity.ok().body("belum manggil service");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateShow() {
        try {
            return ResponseEntity.ok().body("belum manggil service");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity getDetailShow(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok().body("belum manggil service");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
