package com.test.character;

import com.test.game.Color;

import java.util.Scanner;

public class Nelly implements Character, Color {
    private boolean talkedOnce = false;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput(){

        String[] nellyInput = null;

        String[] nellyInput1 = {
                ANSI_CYAN,
                "Nelly: \"To get you started here is a Syringe.  You will need to find the remaining items.\"",
                "Once you have all of the items required, the mix command will become available for you.",
                "Type Start or any other entry if you are ready to get started.",
                ANSI_RESET
        };

        String[] nellyInput2 = {
                ANSI_CYAN,
                "Nelly: How is everything going? I do not have anything to give you.",
                ANSI_RESET
        };

        nellyInput = !talkedOnce ? nellyInput1: nellyInput2;

        try {
            for (String nelly : nellyInput) {
                Thread.sleep(SLEEP_DURATION);
                System.out.println(nelly);
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
        System.out.println(ANSI_CYAN + "Good Luck!" + ANSI_RESET);
        QAEnum result = null;
        if (!talkedOnce){
            result = QAEnum.CORRECT;
            talkedOnce = true;
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
        return "Syringe";
    }
}
