package com.test.character;

import com.test.Color;

import java.util.Scanner;

public class Nelly implements Character, Color {
    private boolean talkedOnce = false;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() throws InterruptedException {

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

        if (!talkedOnce){
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
        String result = null;
        talkedOnce = true;
        if (talkedOnce){
            result = QAEnum.CORRECT.name();
        }
        else{
            result = QAEnum.PASS.name();
        }
        //return getItem();
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
