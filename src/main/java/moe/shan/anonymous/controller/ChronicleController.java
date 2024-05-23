package moe.shan.anonymous.controller;

import moe.shan.anonymous.model.chronicle.Chronicle;
import moe.shan.anonymous.service.chronicle.ChronicleService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChronicleController {
    private ChronicleService chronicleService;

    public ChronicleController(ChronicleService chronicleService) {
        this.chronicleService = chronicleService;
    }

    @GetMapping("/chronicle")
    public ResponseEntity<Page<Chronicle>> getAllChronicle(){
        return ResponseEntity.ok(chronicleService.findAll());
    }

}
