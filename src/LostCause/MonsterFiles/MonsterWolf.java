package LostCause.MonsterFiles;

public class MonsterWolf extends SuperMonster{

    public MonsterWolf(String objectID) {

        name = "Wolf";
        hp = 15;
        attack = 5;
        messages = new String[]{"The wolf rushes forward and bites you.", "The wolf attacks you with its claws."};
        this.objectID = objectID;
        hasSpecialAttack = false;

        // todo: maybe later apply bleed, that will damage the player every 3rd round.
    }

}
