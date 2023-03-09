package LostCause.MonsterFiles;

public class MonsterDragon extends SuperMonster {

    public boolean scales;

    public MonsterDragon(String objectID) {
        name = "Wolf";
        hp = 15;
        attack = 5;
        attackMessage = "The wolf bites you.";
        this.objectID = objectID;

        scales = true;
    }


}
