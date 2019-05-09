package com.duplxey.nquiz.commander.command.commands;

import com.duplxey.nquiz.commander.command.Command;
import com.duplxey.nquiz.constants.Message;
import com.duplxey.nquiz.quiz.*;
import com.duplxey.nquiz.util.EnumUtil;

import java.io.IOException;
import java.util.Scanner;

public class QuizCommand extends Command {

    private QuizManager quizManager;

    private Scanner sc;

    public QuizCommand(QuizManager quizManager) {
        super("quiz", "Quiz management command.", "quiz <name|list|register|unregister|load|save|delete> | <name> | <value>");

        this.quizManager = quizManager;

        sc = new Scanner(System.in);
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("list")) {
                if (quizManager.getQuizzes().size() == 0) {
                    System.out.println("There are currently no quizzes registered. Create or download some!");
                    return;
                }
                System.out.println("The following quizzes are registered: ");
                for (Quiz quiz : quizManager.getQuizzes()) {
                    System.out.println(quiz.info());
                }
                return;
            }
            String quizName = args[0];
            Quiz quiz = quizManager.getQuiz(quizName);
            if (quiz == null) {
                System.out.println("The quiz named '" + quizName + "' does not exist.");
                return;
            }
            new QuizPlay(quiz).play();
            return;
        }
        if (args.length == 2) {
            String quizName = args[1];
            if (args[0].equalsIgnoreCase("register") || args[0].equalsIgnoreCase("create")) {
                if (quizManager.existsQuiz(quizName)) {
                    System.out.println("Quiz named '" + quizName + "' already exists.");
                    return;
                }
                Quiz created = new Quiz(quizManager, quizName);
                quizManager.registerQuiz(created);
                System.out.println("Quiz named '" + quizName + "' has been registered.");
                return;
            }
            if (args[0].equalsIgnoreCase("unregister") || args[0].equalsIgnoreCase("remove")) {
                if (!quizManager.existsQuiz(quizName)) {
                    System.out.println("Quiz named '" + quizName + "' doesn't exist.");
                    return;
                }
                quizManager.unregisterQuiz(quizName);
                System.out.println("Quiz named '" + quizName + "' has been removed.");
                return;
            }
            if (args[0].equalsIgnoreCase("load")) {
                String link = args[1];
                try {
                    Quiz webQuiz = quizManager.getWebQuiz(link);
                    if (quizManager.existsQuiz(webQuiz.getName())) {
                        System.out.println("Quiz named '" + webQuiz.getName() + "' already exists.");
                        return;
                    }
                    quizManager.registerQuiz(webQuiz);
                    System.out.println("Web quiz named '" + webQuiz.getName() + "' has been registered.");
                    return;
                } catch (IOException e) {
                    System.out.println("Failed to parse JSON from that link! Are you sure the quiz is valid?");
                    e.printStackTrace();
                }
                return;
            }
            if (args[0].equalsIgnoreCase("save")) {
                if (!quizManager.existsQuiz(quizName)) {
                    System.out.println("Quiz named '" + quizName + "' doesn't exist.");
                    return;
                }
                Quiz quiz = quizManager.getQuiz(quizName);
                quiz.save();
                System.out.println("Quiz named '" + quizName + "' has been successfully saved.");
                return;
            }
            if (args[0].equalsIgnoreCase("delete")) {
                if (!quizManager.existsQuiz(quizName)) {
                    System.out.println("Quiz named '" + quizName + "' doesn't exist.");
                    return;
                }
                Quiz quiz = quizManager.getQuiz(quizName);
                quiz.delete();
                System.out.println("Quiz named '" + quizName + "' has been successfully deleted.");
                return;
            }
            if (args[0].equalsIgnoreCase("addquestion")) {
                if (!quizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                Quiz quiz = quizManager.getQuiz(args[1]);
                System.out.println("Enter your question:");
                String question = sc.nextLine();
                System.out.println("Enter answer amount:");
                try {
                    Answer[] answers = new Answer[sc.nextInt()];
                    sc.nextLine(); // sc.nextInt() doesn't read the whole line and will submit "" to nextLine(), we want to ignore that!
                    for (int i = 0; i < answers.length; i++) {
                        answers[i] = new Answer(sc.nextLine());
                    }
                    System.out.println("Correct answer's index (starting from 0):");
                    int correct = sc.nextInt();
                    quiz.addQuestion(new Question(question, answers, correct));
                    System.out.println("Successfully added a question.");
                } catch (Exception e) {
                    System.out.println("Wrong input. Cancelled.");
                }
                return;
            }
        }
        if (args.length == 3) {
            if (args[0].equalsIgnoreCase("setdifficulty")) {
                if (!quizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                Quiz quiz = quizManager.getQuiz(args[1]);
                String difficulty = args[2].toUpperCase();
                if (!EnumUtil.isValid(QuizDifficulty.class, difficulty)) {
                    System.out.println("This quiz category doesn't exist!");
                    return;
                }
                quiz.setDifficulty(QuizDifficulty.valueOf(difficulty));
                System.out.println("Quiz difficulty has been set to " + difficulty + ".");
                return;
            }
            if (args[0].equalsIgnoreCase("setcategory")) {
                if (!quizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                Quiz quiz = quizManager.getQuiz(args[1]);
                String category = args[2].toUpperCase();
                if (!EnumUtil.isValid(QuizCategory.class, category)) {
                    System.out.println("This quiz category doesn't exist!");
                    return;
                }
                quiz.setCategory(QuizCategory.valueOf(category));
                System.out.println("Quiz category has been set to " + category + ".");
                return;
            }
            if (args[0].equalsIgnoreCase("removequestion")) {
                if (!quizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                Quiz quiz = quizManager.getQuiz(args[1]);
                quiz.removeQuestion(Integer.parseInt(args[2]));
                System.out.println("Removed question with index " + args[2] + ".");
                return;
            }
        }
        if (args.length >= 3) {
            if (args[0].equalsIgnoreCase("setdescription")) {
                if (!quizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                Quiz quiz = quizManager.getQuiz(args[1]);
                StringBuilder builder = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    builder.append(args[i]).append(" ");
                }
                quiz.setDescription(builder.toString().substring(0, builder.toString().length()-1));
                System.out.println("Quiz named '" + args[1] + "' now has the following description: " + builder.toString());
                return;
            }
        }
        System.out.println(Message.WRONG_SYNTAX.getText() + getSyntax());
    }
}
