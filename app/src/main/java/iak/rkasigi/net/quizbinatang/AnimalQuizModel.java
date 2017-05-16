package iak.rkasigi.net.quizbinatang;

import java.util.ArrayList;

/**
 * Created by rkasigi on 5/14/17.
 */

public class AnimalQuizModel {

    private AnimalModel animalModel;
    private int answer;
    private String answerString;
    private ArrayList<String> choicesAnswer;

    public AnimalQuizModel(AnimalModel animalModel, int answer, ArrayList<String> choicesAnswer) {
        this.animalModel = animalModel;
        this.answer = answer;
        this.answerString = choicesAnswer.get(answer-1);
        this.choicesAnswer = choicesAnswer;
    }

    public AnimalModel getAnimalModel() {
        return animalModel;
    }

    public int getAnswer() {
        return answer;
    }

    public String getAnswerString() {
        return answerString;
    }

    public ArrayList<String> getChoicesAnswer() {
        return choicesAnswer;
    }
}
