package com.felixalguzman.raeapi.controllers;

import com.felixalguzman.raeapi.models.*;
import com.felixalguzman.raeapi.services.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @GetMapping(value = "exact")
    public ResponseEntity<BaseResponse> getExactWord(String word) {

        return ResponseEntity.ok(service.getExactWord(word));
    }

    @GetMapping(value = "anagram")
    public ResponseEntity<AnagramResponse> getAnagram(String word) {

        return ResponseEntity.ok(service.getAnagram(word));
    }

    @GetMapping(value = "startingWith")
    public ResponseEntity<BaseResponse> getWordStartingWith(String word) {

        return ResponseEntity.ok(service.getWordStartingWith(word));
    }

    @GetMapping(value = "containing")
    public ResponseEntity<BaseResponse> getWordContaining(String word) {

        return ResponseEntity.ok(service.getWordContaining(word));
    }

    @GetMapping(value = "ending")
    public ResponseEntity<BaseResponse> getWordEnding(String word) {

        return ResponseEntity.ok(service.getWordEnding(word));
    }

    @GetMapping(value = "definition")
    public ResponseEntity<String> getWordDefinition(String id) {

        return ResponseEntity.ok(service.getDefinitionById(id));
    }

    @GetMapping(value = "header")
    public ResponseEntity<HeaderResponse> getHeader(String id) {

        return ResponseEntity.ok(service.getHeaderResponse(id));
    }

    @GetMapping(value = "ids")
    public ResponseEntity<IdResponse> getIds(String word) {

        return ResponseEntity.ok(service.getIds(word));
    }

    @GetMapping(value = "random")
    public ResponseEntity<String> getRandom() {

        return ResponseEntity.ok(service.getRandomWord());
    }

    @GetMapping(value = "search")
    public ResponseEntity<BaseResponse> getWordSearch(String word) {

        return ResponseEntity.ok(service.getWordSearchResults(word));
    }

    @GetMapping(value = "word/day")
    public ResponseEntity<WOTDResponse> getWordSearch() {

        return ResponseEntity.ok(service.getWordOfTheDay());
    }

    @GetMapping(value = "matching/words")
    public ResponseEntity<String> getMatchingWords(String word) {

        return ResponseEntity.ok(service.getSomeMatchingWords(word));
    }


}
