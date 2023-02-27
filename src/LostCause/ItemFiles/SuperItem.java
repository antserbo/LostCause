package LostCause.ItemFiles;

import java.util.Objects;

public class SuperItem {

    public String itemID;
    public String type;
    public String name;


    public SuperItem(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemWeaponLongSword)) return false;
        if (!super.equals(o)) return false;
        return itemID.equals(((ItemWeaponLongSword) o).itemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), itemID);
    }

}

