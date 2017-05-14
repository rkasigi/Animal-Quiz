package iak.rkasigi.net.quizbinatang;

/**
 * Created by rkasigi on 5/14/17.
 */

public class AnimalQuizModel {

    private AnimalModel animalModel;
    private int answer;
    private String question01;
    private String question02;
    private String question03;
    private String question04;

    public AnimalQuizModel(AnimalModel animalModel, int answer, String question01, String question02, String question03, String question04) {
        this.animalModel = animalModel;
        this.answer = answer;
        this.question01 = question01;
        this.question02 = question02;
        this.question03 = question03;
        this.question04 = question04;
    }

    public AnimalModel getAnimalModel() {
        return animalModel;
    }

    public int getAnswer() {
        return answer;
    }

    public String getQuestion01() {
        return question01;
    }

    public String getQuestion02() {
        return question02;
    }

    public String getQuestion03() {
        return question03;
    }

    public String getQuestion04() {
        return question04;
    }
}
