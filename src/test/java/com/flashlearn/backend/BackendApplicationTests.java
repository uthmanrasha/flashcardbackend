package com.flashlearn.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BackendApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private FlashcardRepository flashcardRepository;

	@BeforeEach
	void clearDatabase() {
		flashcardRepository.deleteAll();
	}

	@Test
	void getFlashcardsReturnsAnEmptyListAtFirst() throws Exception {
		mockMvc.perform(get("/flashcards"))
				.andExpect(status().isOk())
				.andExpect(content().json("[]"));
	}

	@Test
	void postStoresFlashcardAndGetReturnsIt() throws Exception {
		mockMvc.perform(post("/flashcards")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
                                {
                                  "subject": "Informatik",
                                  "question": "Was ist Polymorphie?",
                                  "answer": "Ein Konzept der objektorientierten Programmierung.",
                                  "difficultyLevel": "Hard"
                                }
                                """))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.subject").value("Informatik"));

		mockMvc.perform(get("/flashcards"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].question").value("Was ist Polymorphie?"));
	}
}
