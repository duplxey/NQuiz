package com.duplxey.nquiz.quiz;

import java.net.URL;

public class Question {

    private String text;
    private Answer[] answers;
    private URL imageURL;
    private int correct;

    public Question(String text, Answer[] answers, URL imageURL, int correct) {
        this.text = text;
        this.answers = answers;
        this.imageURL = imageURL;
        this.correct = correct;
    }

    public Question(String text, Answer[] answers, int correct) {
        this(text, answers, null, correct);
    }

    public boolean isCorrect(int i) {
        return i == correct;
    }

    public String getText() {
        return text;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public URL getImageURL() {
        return imageURL;
    }

    public int getCorrect() {
        return correct;
    }
}
