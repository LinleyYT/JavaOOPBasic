package hell.entities.item;

import hell.interfaces.Item;

public abstract class Items implements Item{
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointBonus;
    private int damageBonus;

    protected Items(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int gitPointBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointBonus = gitPointBonus;
        this.damageBonus = damageBonus;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }
}
