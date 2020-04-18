package basics.BaseCourse.InterfaceChallenge;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveAble {
    private String name;
    private int health;
    private int strength;

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public Monster(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> values2 = new ArrayList<>();
        values2.add(0, this.name);
        values2.add(1, "" + this.health);
        values2.add(2, "" + this.strength);
        return values2;
    }

    @Override
    public void read(List<String> savedValues2) {
        if(savedValues2 != null && savedValues2.size() == 3) {
            this.name = savedValues2.get(0);
            this.health = Integer.parseInt(savedValues2.get(1));
            this.strength = Integer.parseInt(savedValues2.get(2));
        }
    }
}
