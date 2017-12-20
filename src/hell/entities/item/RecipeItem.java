package hell.entities.item;


import hell.interfaces.Recipe;

import java.util.*;

public class RecipeItem extends Items implements Recipe{
    private List<String> requiredItems;

    public RecipeItem(String name, Integer strengthBonus, Integer agilityBonus, Integer intelligenceBonus, Integer gitPointBonus, Integer damageBonus, String... requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, gitPointBonus, damageBonus);
        this.requiredItems =  Arrays.asList(requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return this.requiredItems;
    }
}
