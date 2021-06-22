package it.k8s.restms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/item/v1")
public class ItemController {

    @GetMapping("/get")
    public ResponseEntity<String> getItem() {
        log.info("############ work!!");
        return ResponseEntity.ok("ciao");
    }

}
