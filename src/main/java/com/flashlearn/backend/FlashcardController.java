package com.flashlearn.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class FlashcardController {

    @GetMapping("/flashcards")
    public List<Flashcard> getFlashcards() {
        Flashcard card1 = new Flashcard(1L, "Informatik", "Was ist Polymorphie?", "Ein Konzept in der objektorientierten Programmierung...", "Hard");
        Flashcard card2 = new Flashcard(2L, "Biologie", "Was ist die Aufgabe der Mitochondrien?", "Mitochondrien sind die Kraftwerke der Zelle.", "Medium");

        return Arrays.asList(card1, card2);
    }
}
