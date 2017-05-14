package iak.rkasigi.net.quizbinatang;



public class AnimalModel {

    private AnimalId animalId;
    private String nameID;
    private String nameEN;
    private int image;
    private int voice;


    public AnimalModel(AnimalId animalId, String nameID, String nameEN, int image, int voice) {
        this.animalId = animalId;
        this.nameID = nameID;
        this.nameEN = nameEN;
        this.image = image;
        this.voice = voice;
    }

    public AnimalId getAnimalId() {
        return animalId;
    }

    public String getNameID() {
        return nameID;
    }

    public String getNameEN() {
        return nameEN;
    }

    public int getImage() {
        return image;
    }

    public int getVoice() {
        return voice;
    }

    public enum AnimalId {
        CAT, COCK, COW, DOG, DUCK, ELEPHANT, HORSE, LION, PIG
    }
}
