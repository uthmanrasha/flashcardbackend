package com.flashlearn.backend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class FlashcardController {

    private final FlashcardRepository flashcardRepository;

    public FlashcardController(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    @GetMapping("/flashcards")
    public List<Flashcard> getFlashcards() {
        return flashcardRepository.findAll();
    }

    @PostMapping("/flashcards")
    public ResponseEntity<Flashcard> createFlashcard(@RequestBody Flashcard flashcard) {
        flashcard.setId(null);
        Flashcard savedFlashcard = flashcardRepository.save(flashcard);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedFlashcard);
    }
}