package com.duplxey.nquiz.quiz;

import com.duplxey.nquiz.util.FileUtil;
import com.duplxey.nquiz.util.GsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Quiz {

    private String name;
    private String description;
    private QuizCategory category;
    private QuizDifficulty difficulty;
    private LinkedList<Question> questions;

    // Transient to prevent serialization
    private transient File quizDirectory;
    private transient File file = null;

    public Quiz(QuizManager quizManager, String name, String description, QuizCategory category, QuizDifficulty difficulty, LinkedList<Question> questions) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
        this.questions = questions;

        quizDirectory = quizManager.getQuizDirectory();
    }

    public Quiz(QuizManager quizManager, String name, String description, QuizCategory category, QuizDifficulty difficulty) {
        this(quizManager, name, description, category, difficulty, new LinkedList<Question>() {});
    }

    public Quiz(QuizManager quizManager, String name) {
        this(quizManager, name, "No description given.", QuizCategory.FUN, QuizDifficulty.EASY, new LinkedList<Question>() {});
    }

    private void fileSetup() {
        if (file == null) {
            file = new File(quizDirectory, name + ".json");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save() {
        fileSetup();
        FileUtil.writeToFile(file.getPath(), GsonUtil.getInstance().getGson().toJson(this));
    }

    public void delete() {
        fileSetup();
        file.delete();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public QuizCategory getCategory() {
        return category;
    }

    public QuizDifficulty getDifficulty() {
        return difficulty;
    }

    public LinkedList<Question> getQuestions() {
        return questions;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(QuizCategory category) {
        this.category = category;
    }

    public void setDifficulty(QuizDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(int questionId) {
        questions.remove(questionId);
    }

    public void setQuestions(LinkedList<Question> questions) {
        this.questions = questions;
    }

    public void clearQuestions() {
        questions.clear();
    }

    public String info() {
        return name + " (" + description + ") " + "(" + category + ") " + "(" + difficulty + ")";
    }
}
