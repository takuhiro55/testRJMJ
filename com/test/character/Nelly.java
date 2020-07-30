package com.test.character;

import com.test.Color;

import java.util.Scanner;

public class Nelly implements Character, Color {
    private int numCountTalked = 0;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() throws InterruptedException {

        numCountTalked++;
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

        if (numCountTalked == 1){
            nellyInput = nellyInput1;
        }
        else{
            nellyInput = nellyInput2;
        }

        for (String nelly : nellyInput) {
            Thread.sleep(sleep);
            System.out.println(nelly);
        }

        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    @Override
    public String processQuestionAnswer(String questionAnswer) {
        System.out.println(ANSI_CYAN + "Good Luck!" + ANSI_RESET);
        return getItem();
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
