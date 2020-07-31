package com.test.character;

import com.test.Color;

import java.io.IOException;
import java.util.Scanner;

public class Jay implements Character, Color {
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() throws IOException, InterruptedException {
        String[] jayInput = {
                ANSI_CYAN,
                "Jay: \"What band is Jay playing in this video?\"",
                "A. Aerosmith",
                "B. Daft Punk",
                "C. Queen",
                "D. Judas Priest",
                ANSI_RESET
        };

        String url_open = "https://www.youtube.com/watch?v=hyctW2abkY4";
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));

        for (String jay : jayInput) {
            Thread.sleep(sleep);
            System.out.println(jay);
        }

        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    @Override
    public String processQuestionAnswer(String questionAnswer) {
        String result = "";
        if (questionAnswer.toUpperCase().equals("C")) {
            System.out.println("Correct");
            result = "Correct";
        } else {
            System.out.println("Incorrect, please try again.");
            result = "Incorrect";
        }
        return result;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getItem() {
        return ANSI_RED +"Red Liquid" + ANSI_CYAN;
    }
}
