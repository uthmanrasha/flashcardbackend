package com.flashlearn.backend;

public class Flashcard {
    private Long id;
    private String subject;
    private String question;
    private String answer;
    private String difficultyLevel;

    public Flashcard(Long id, String subject, String question, String answer, String difficultyLevel) {
        this.id = id;
        this.subject = subject;
        this.question = question;
        this.answer = answer;
        this.difficultyLevel = difficultyLevel;
    }

    public Long getId() { return id; }
    public String getSubject() { return subject; }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public String getDifficultyLevel() { return difficultyLevel; }
}

