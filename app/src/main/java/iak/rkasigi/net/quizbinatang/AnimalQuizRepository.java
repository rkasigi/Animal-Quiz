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

        for(AnimalModel.AnimalId id: AnimalModel.AnimalId.values()) {
            animalQuizModelList.add(
                    new AnimalQuizModel(AnimalRepository.getInstance().findByAnimalId(id))
            );

        }
    }


    public List<AnimalQuizModel> getAnimalQuizModelList() {
        return animalQuizModelList;
    }
}
