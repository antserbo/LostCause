package LostCause.ItemFiles;

import java.util.Objects;

public class SuperItem {

    public String itemID;
    public String type;
    public String name;


    public SuperItem(String itemID, String name) {
        this.itemID = itemID;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        if (!super.equals(o)) return false;
        return itemID.equals(((Weapon) o).itemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), itemID);
    }

}

