package iak.rkasigi.net.quizbinatang;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by rkasigi on 5/14/17.
 */

public class AnimalRepository {

    private static AnimalRepository instance = new AnimalRepository();
    private List<AnimalModel> animalList = new ArrayList<AnimalModel>();

    public static AnimalRepository getInstance()
    {
        return instance;
    }

    public AnimalRepository() {
        animalList.add(new AnimalModel(AnimalModel.AnimalId.CAT, "Kucing", "Cat", R.drawable.cat, R.raw.cat));
        animalList.add(new AnimalModel(AnimalModel.AnimalId.COCK, "Ayam Jantan", "Rooster", R.drawable.cock, R.raw.chicken));
        animalList.add(new AnimalModel(AnimalModel.AnimalId.COW, "Sapi", "Cow", R.drawable.cow, R.raw.cow));
        animalList.add(new AnimalModel(AnimalModel.AnimalId.DOG, "Anjing", "Dog", R.drawable.dog, R.raw.dog));
        animalList.add(new AnimalModel(AnimalModel.AnimalId.DUCK, "Bebek", "Duck", R.drawable.duck, R.raw.duck));
        animalList.add(new AnimalModel(AnimalModel.AnimalId.ELEPHANT, "Gajah", "Elephant", R.drawable.elephant, R.raw.elephant));
        animalList.add(new AnimalModel(AnimalModel.AnimalId.HORSE, "Kuda", "Horse", R.drawable.horse, R.raw.horse));
        animalList.add(new AnimalModel(AnimalModel.AnimalId.LION, "Singa", "Lion", R.drawable.lion, R.raw.lion));
        animalList.add(new AnimalModel(AnimalModel.AnimalId.PIG, "Babi", "Pig", R.drawable.pig, R.raw.pig));

    }

    public List<AnimalModel> getAnimalList() {
        return animalList;
    }

    public AnimalModel findByAnimalId(AnimalModel.AnimalId animalId) {
        ListIterator<AnimalModel> iterator = animalList.listIterator();

        for(AnimalModel animal: animalList) {
            if(animal.getAnimalId().equals(animalId)) {
                return animal;
            }
        }

        return null;
    }
}
