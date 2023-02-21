package LostCause.GameFiles;

public class MonsterWolf extends SuperMonster{

    public MonsterWolf(String objectID) {

        name = "Wolf";
        hp = 15;
        attack = 5;
        String [] wolfMessages = {"The wolf rushes forward and bites you.","The wolf attacks you with its claws."};
        attackMessage = wolfMessages[new java.util.Random().nextInt(wolfMessages.length)];
        this.objectID = objectID;

        // todo: maybe later apply bleed, that will damage the player every 3rd round.
    }
}
