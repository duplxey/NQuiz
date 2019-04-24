package com.duplxey.nquiz.quiz;

import java.util.Scanner;

public class QuizPlay {

    private Quiz quiz;

    private Scanner sc;
    private int current = 0;
    private int[] results = new int[] {0, 0}; // 0 = correct, 1 = wrong
    private long startTime;

    public QuizPlay(Quiz quiz) {
        this.quiz = quiz;

        sc = new Scanner(System.in);
    }

    public void play() {
        System.out.println("-*-*-*-*-*-*- NQuiz -*-*-*-*-*-*-");
        System.out.println("Quiz name: '" + quiz.getName());
        System.out.println("Description: " + quiz.getDescription());
        System.out.println("Category: " + quiz.getCategory());
        System.out.println("Difficulty: " + quiz.getDifficulty());
        System.out.println("Number of questions: " + quiz.getQuestions().size());
        startTime = System.currentTimeMillis();
        for (Question question : quiz.getQuestions()) {
            System.out.println("---------------------------------");
            System.out.println("#" + current + " " + question.getText());
            for (int i = 0; i < question.getAnswers().length; i++) {
                System.out.println(i + ") " + question.getAnswers()[i].getText());
            }
            int answer = sc.nextInt();
            if (question.isCorrect(answer)) {
                System.out.println("Correct!");
                results[0]++;
            } else {
                System.out.println("Wrong!");
                results[1]++;
            }
            current++;
        }
        double correctPercentage = (100*results[0])/quiz.getQuestions().size();
        double wrongPercentage = 100 - correctPercentage;

        System.out.println("-*-*-*-*-*-*- NQuiz -*-*-*-*-*-*-");
        System.out.println("You've completed the quiz!");
        System.out.println();
        System.out.println("Results");
        System.out.println("Correct: " + results[0] + " (" + correctPercentage + "%)");
        System.out.println("Wrong: " + results[1] + " (" + wrongPercentage + "%)");
        System.out.println("Time needed: " + (System.currentTimeMillis() - startTime)/1000 + "s");
        System.out.println("---------------------------------");
    }
}
