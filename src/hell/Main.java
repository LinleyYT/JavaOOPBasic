package hell;

import hell.engine.Core;
import hell.entities.hero.Assassin;
import hell.entities.item.CommonItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Core core = new Core();
        core.run();
        }
    }