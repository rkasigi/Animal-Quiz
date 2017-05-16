package iak.rkasigi.net.quizbinatang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rkasigi on 5/14/17.
 */

public class AnimalQuizRepository {

    private List<AnimalQuizModel> animalQuizModelList = new ArrayList<>();
    private static AnimalQuizRepository instance = new AnimalQuizRepository();

    public static AnimalQuizRepository getInstance()
    {
        return instance;
    }

    public AnimalQuizRepository() {

        List<AnimalModel> animalGenerator = new ArrayList<>(AnimalRepository.getInstance().getAnimalList());
        generateQuiz(animalGenerator);
    }

    private void generateQuiz(List<AnimalModel> animalGenerator) {
        if(animalGenerator.size() > 0) {
            Random r = new Random();
            int random = r.nextInt(animalGenerator.size());
            AnimalModel animal = animalGenerator.get(random);


            ArrayList<String> choicesAnswer = new ArrayList<>();
            int answer = generateQuizOptions(animal, choicesAnswer);

            animalQuizModelList.add(new AnimalQuizModel(animal, (answer + 1), choicesAnswer));
            animalGenerator.remove(random);
            generateQuiz(animalGenerator);

        }

    }

    private int generateQuizOptions(AnimalModel animal, ArrayList<String> choicesAnswer) {

        int choicesAnswerCount = 4;

        Random r = new Random();
        int answer = r.nextInt(choicesAnswerCount-1) + 1;

        ArrayList<Integer> excludeRandomAnimal = new ArrayList<Integer>();

        for(int i=0; i<choicesAnswerCount; i++) {
            if(answer != i) {
                int randomAnimal = getRandomAnimalNumber(animal, excludeRandomAnimal);
                choicesAnswer.add(AnimalRepository.getInstance().getAnimalList().get(randomAnimal).getNameEN());

            } else {
                choicesAnswer.add(animal.getNameEN());

            }
        }

        return answer;

    }


    private int getRandomAnimalNumber(AnimalModel animal, ArrayList<Integer> excludeRandomAnimal) {
        Random r = new Random();
        int random = r.nextInt(AnimalRepository.getInstance().getAnimalList().size());
        ArrayList<Integer> excludes = new ArrayList<>(excludeRandomAnimal);

        if(AnimalRepository.getInstance().getAnimalList().get(random).getNameEN().equals(animal.getNameEN())) {
            excludeRandomAnimal.add(random);
            random = getRandomAnimalNumber(animal, excludeRandomAnimal);
            
        } else {
            for (int ex : excludes) {

                if (random == ex) {
                    random = getRandomAnimalNumber(animal, excludeRandomAnimal);
                    break;

                }
            }

        }



        excludeRandomAnimal.add(random);

        return random;

    }


    public List<AnimalQuizModel> getAnimalQuizModelList() {
        return animalQuizModelList;
    }
}
