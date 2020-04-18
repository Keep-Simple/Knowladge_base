package basics.BaseCourse.InterfaceChallenge;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveAble {

    private int health;
    private int strength;
    private String name;
    private String weapon;

    public Player(int health, int strength, String name) {
        this.health = health;
        this.strength = strength;
        this.name = name;
        this.weapon = "Sword";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, this.weapon);
        values.add(2, "" + this.health);
        values.add(3, "" + this.strength);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() == 4) {
            this.name = savedValues.get(0);
            this.weapon = savedValues.get(1);
            this.health = Integer.parseInt(savedValues.get(2));
            this.strength = Integer.parseInt(savedValues.get(3));
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "health=" + health +
                ", strength=" + strength +
                ", name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
