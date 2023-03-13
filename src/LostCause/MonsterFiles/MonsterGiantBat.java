package LostCause.MonsterFiles;

public class MonsterGiantBat extends SuperMonster {

    public MonsterGiantBat(String objectID) {

        name = "Giant bat";
        hp = 10;
        attack = 3;
        messages = new String[]{"The giant bat flaps its wings and lunges at you.", "The giant bat attacks you with its claws."};
        attackMessage = messages[new java.util.Random().nextInt(messages.length)];
        this.objectID = objectID;
        specialAttack = false;

        // todo: maybe later apply bleed, that will damage the player every 3rd round.
    }

}
