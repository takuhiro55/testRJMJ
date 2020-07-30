package com.test.character;

//import com.rjmj.capstone.engines.MovementEngine;

import com.test.Color;

import java.util.Scanner;

public class John implements Character, Color {
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() throws InterruptedException {
        String[] johnInput = {
                ANSI_CYAN,
                "John: \"What is AWS' DNS Service?\"",
                "A. S3",
                "B. EC2",
                "C. Route 53",
                "D. Lambda",
                ANSI_RESET
        };

        for (String john : johnInput) {
            Thread.sleep(sleep);
            System.out.println(john);
        }

        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    @Override
    public String processQuestionAnswer(String questionAnswer) {
//        MovementEngine movementEngine = new MovementEngine();
        String result = "";
//        if (questionAnswer.toUpperCase().equals("C")) {
//            movementEngine.clearScreen();
//            System.out.println("Correct");
//            result = getItem();
//        } else {
//            movementEngine.clearScreen();
//            System.out.println("Incorrect, please try again.");
//        }
        return result;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getItem() {
        return "Key";
    }
}
