package LostCause.MonsterFiles;

public class MonsterGiantBat extends SuperMonster {

    public MonsterGiantBat(String objectID) {

        name = "Giant bat";
        hp = 10;
        attack = 3;
        String [] giantBatMessages = {"The giant bat flaps its wings and lunges at you forward and bites you.","The giant bat attacks you with its claws."};
        attackMessage = giantBatMessages[new java.util.Random().nextInt(giantBatMessages.length)];
        this.objectID = objectID;

        // todo: maybe later apply bleed, that will damage the player every 3rd round.
    }
}
