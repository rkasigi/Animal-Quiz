package iak.rkasigi.net.quizbinatang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private ArrayList<Integer> excludeRandomQuestion = new ArrayList<>();
    private List<AnimalModel> quizList = AnimalRepository.getInstance().getAnimalList();

    public AnimalQuizModel(AnimalModel animalModel) {
        this.animalModel = animalModel;
        this.question01 = getRandomAnimal();
        this.question02 = getRandomAnimal();
        this.question03 = getRandomAnimal();
        this.question04 = getRandomAnimal();


        Random r = new Random();
        answer = r.nextInt(4-1) + 1;

        switch (answer) {
            case 1:
                this.question01 = animalModel.getNameEN();
                break;

            case 2:
                this.question02= animalModel.getNameEN();
                break;

            case 3:
                this.question03 = animalModel.getNameEN();
                break;

            case 4:
                this.question04 = animalModel.getNameEN();
                break;

        }

    }

    private String getRandomAnimal() {
        return quizList.get(getRandomAnimalNumber()).getNameEN();
    }

    public int getRandomAnimalNumber() {
        ArrayList<Integer> excludes = (ArrayList) excludeRandomQuestion.clone();

        Random r = new Random();
        int random = r.nextInt(quizList.size());
        for (int ex : excludes) {
            if (random == ex) {
                random = getRandomAnimalNumber();
            } else if(quizList.get(random).getNameEN().equals(animalModel.getNameEN())) {
                excludeRandomQuestion.add(random);
                random = getRandomAnimalNumber();
            }
        }

        excludeRandomQuestion.add(random);
        return random;
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
