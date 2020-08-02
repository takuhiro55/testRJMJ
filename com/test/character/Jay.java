package com.test.character;

import com.test.game.Color;

import java.util.Scanner;

public class Jay implements Character, Color {
    private boolean talkedOnce = false;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() {
        String[] jayInput = {
                ANSI_CYAN,
                "Jay: \"What band is Jay playing in this video?\"",
                "A. Aerosmith",
                "B. Daft Punk",
                "C. Queen",
                "D. Judas Priest",
                ANSI_RESET
        };

        try {
            String url_open = "https://www.youtube.com/watch?v=hyctW2abkY4";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Look for \"java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));\"");
        }

        try{
            for (String jay : jayInput) {
                Thread.sleep(SLEEP_DURATION);
                System.out.println(jay);
            }
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Look for \"Thread.sleep(sleep);\"");
        }
        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }


    @Override
    public QAEnum processQuestionAnswer(String questionAnswer) {
        QAEnum result = null;
        if (!talkedOnce) {
            if (questionAnswer.toUpperCase().equals("C")) {
                result = QAEnum.CORRECT;
                talkedOnce = true;
            } else {
                result = QAEnum.INCORRECT;
            }
        }
        else{
            result = QAEnum.PASS;
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
