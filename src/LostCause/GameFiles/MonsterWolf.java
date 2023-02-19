package LostCause.GameFiles;

public class MonsterWolf extends SuperMonster{

    public MonsterWolf(String objectID) {

        name = "Wolf";
        hp = 15;
        attack = 5;
        attackMessage = "The wolf bites you.";
        this.objectID = objectID;

    }
}
