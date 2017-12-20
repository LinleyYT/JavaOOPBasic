package hell.entities.hero;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.*;

public abstract class Heroes implements Hero{
    private String name;
    private Long strength;
    private Long agility;
    private Long intelligence;
    private Long hitPoints;
    private Long damage;
    private HeroInventory inventory;

    protected Heroes(String name, Long strength, Long agility, Long intelligence, Long hitPoints, Long damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() throws IllegalAccessException {
        Map<String, Item> itemMap = new LinkedHashMap<>();
        Field[] fields = this.inventory.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)){
                field.setAccessible(true);
                field.get(this.inventory);
                itemMap = (Map<String, Item>) field.get(this.inventory);
            }
        }
        Collection<Item> items = new ArrayList<>(itemMap.values());
        return items;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }
    @Override
    public String toString() {
        System.out.println( String.format("Hero: %s, Class: %s\n" +
                "HitPoints: %s, Damage: %s\n" +
                "Strength: %s\nAgility: %s\n" +
                "Intelligence: %s",
                this.name, this.getClass().getName().replace("hell.entities.hero.", "")
                ,this.getHitPoints(),this.getDamage(),this.getStrength(), this.getAgility(),
                this.getIntelligence()));
        try {
            System.out.println("Items:" + (this.getItems().size() == 0 ? " None" : ""));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            this.getItems().forEach(x ->{ System.out.println("###Item: " + x.getName());
                System.out.println(String.format("###+%d Strength", x.getStrengthBonus()));
                System.out.println(String.format("###+%d Agility", x.getAgilityBonus()));
                System.out.println(String.format("###+%d Intelligence", x.getIntelligenceBonus()));
                System.out.println(String.format("###+%d HitPoints", x.getHitPointsBonus()));
                System.out.println(String.format("###+%d Damage", x.getDamageBonus()));
            });
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static int compareTo(Hero o, Hero l) {
        Long thisHero =l.getAgility()+l.getIntelligence()+l.getStrength();
        Long oHero = o.getAgility()+o.getIntelligence()+o.getStrength();
        int result =thisHero.compareTo(oHero);
        if (result == 0) {
            thisHero = l.getHitPoints() + l.getDamage();
            oHero = o.getHitPoints() + o.getDamage();
            result = thisHero.compareTo(oHero);
        }
        return result;
    }
}
