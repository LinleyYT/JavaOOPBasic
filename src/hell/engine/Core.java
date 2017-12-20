package hell.engine;

import hell.entities.hero.Assassin;
import hell.entities.hero.Barbarian;
import hell.entities.hero.Heroes;
import hell.entities.hero.Wizard;
import hell.entities.item.CommonItem;
import hell.entities.item.RecipeItem;
import hell.interfaces.*;
import hell.io.ConsoleReadLine;
import hell.io.ConsoleWriteLine;

import java.text.Format;
import java.util.*;
import java.util.stream.Collectors;


public class Core implements Runnable{
    InputReader reader;
    OutputWriter writer;
    Map<String, Hero> hero;

    public Core() {
        this.reader = new ConsoleReadLine();
        this.writer = new ConsoleWriteLine();
        this.hero = new LinkedHashMap<>();
    }

    @Override
    public void run() {
        String line = reader.readLine();
        while (!"Quit".equals(line)) {
            String[] commands = line.split("\\s+");
            switch (commands[0]){
                case "Hero":
                    createHero(commands[1], commands[2]);
                    break;
                case "Item":
                    createItem(commands);
                    break;
                case "Recipe":
                    createRecipe(commands);
                    break;
                case "Inspect":
                    hero.get(commands[1]).getName();
                    System.out.print( hero.get(commands[1]).toString());
                    break;
            }
            line = reader.readLine();
        }
       List<Hero> heroes = hero.entrySet().stream().sorted((a, b) -> Heroes.compareTo(a.getValue(), b.getValue())).map(x -> x.getValue()).collect(Collectors.toList());
        int count = 1;
        for (Hero h : heroes) {
            System.out.println(String.format("%s. %s: %s",
                    count, h.getClass().getName().replace("hell.entities.hero.", ""), h.getName()));
            System.out.println("###HitPoints: "+ h.getHitPoints());
            System.out.println("###Damage: " + h.getDamage());
            System.out.println("###Strength: " + h.getStrength());
            System.out.println("###Agility: " + h.getAgility());
            System.out.println("###Intelligence: " + h.getIntelligence());
            try {
                System.out.print("###Items: " + (h.getItems().size() == 0 ? "None" :
                        String.join(", ", h.getItems().stream().map(x->x.getName()).collect(Collectors.toList()))));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println();
            count++;
        }
    }

    private void createRecipe(String[] commands) {
        if (hero.containsKey(commands[2])){
            String[] arr = new String[commands.length-8];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = commands[8+i];
            }
            Recipe item = new RecipeItem(commands[1], Integer.valueOf(commands[3]), Integer.valueOf(commands[4]), Integer.valueOf(commands[5]), Integer.valueOf(commands[6]), Integer.valueOf(commands[7]), arr);
            hero.get(commands[2]).addRecipe(item);
        }
        this.writer.writeLine(String.format("Added recipe - %s to Hero - %s", commands[1], commands[2]));
    }

    private void createItem(String[] commands) {
        if (hero.containsKey(commands[2])){
            Item item = new CommonItem(commands[1], Integer.valueOf(commands[3]), Integer.valueOf(commands[4]), Integer.valueOf(commands[5]), Integer.valueOf(commands[6]), Integer.valueOf(commands[7]));
            hero.get(commands[2]).addItem(item);
        }
        this.writer.writeLine(String.format("Added item - %s to Hero - %s", commands[1], commands[2]));
    }

    private void createHero(String name, String type) {
        switch (type){
            case "Assassin":
                hero.put(name, new Assassin(name));
                break;
            case "Barbarian":
                hero.put(name, new Barbarian(name));
                break;
            case "Wizard":
                hero.put(name, new Wizard(name));
                break;
        }

        this.writer.writeLine(String.format("Created %s - %s",
                type, name));
    }

}
