package com.duplxey.nquiz.quiz;

public enum QuizCategory {
    TRIVIA("Random questions."),
    MATH("Math related questions."),
    ENGLISH("English related questions."),
    FUN("Are these even fun?"),
    TECH("Computers, programming, net?"),
    ;

    private String description;

    QuizCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
