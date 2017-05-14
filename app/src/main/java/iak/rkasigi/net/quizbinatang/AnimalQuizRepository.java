package iak.rkasigi.net.quizbinatang;

import java.util.ArrayList;
import java.util.List;

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
        animalQuizModelList.add(
                new AnimalQuizModel(AnimalRepository.getInstance().findByAnimalId(AnimalModel.AnimalId.CAT),
                        1,
                        "Cat", "Cow", "Pig", "Elephant"
                )
        );

        animalQuizModelList.add(
                new AnimalQuizModel(AnimalRepository.getInstance().findByAnimalId(AnimalModel.AnimalId.COCK),
                        3,
                        "Cow", "Duck", "Roaster", "Dog"
                )
        );

        animalQuizModelList.add(
                new AnimalQuizModel(AnimalRepository.getInstance().findByAnimalId(AnimalModel.AnimalId.COW),
                        1,
                        "Cow", "Cat", "Dog", "Lion"
                )
        );

        animalQuizModelList.add(
                new AnimalQuizModel(AnimalRepository.getInstance().findByAnimalId(AnimalModel.AnimalId.DOG),
                        3,
                        "Pig", "Cat", "Dog", "Cow"
                )
        );

        animalQuizModelList.add(
                new AnimalQuizModel(AnimalRepository.getInstance().findByAnimalId(AnimalModel.AnimalId.DUCK),
                        4,
                        "Pig", "Dog", "Cow", "Duck"
                )
        );
    }


    public List<AnimalQuizModel> getAnimalQuizModelList() {
        return animalQuizModelList;
    }
}
