package BaseCourse.Collections.First;

import java.util.HashSet;
import java.util.Set;

/**
 * Creating program to simulate solar system :
 * Static Inner class Key is needed to provide distinct keys for Map solarSystem in the SetChallenge class
 * Used enum class to handle type of the HeavenlyBody, quite useful)
 * Overriding hash code and equals in both outer and inner class. Outer class simply used inner class methods
 * Created subclasses to implement abstract HeavenlyBody class
 * Only Planet and Star can have satellites
 * Finally tested code in SetChallenge class
 */

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Key key;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        MOON,
        STAR,
        PLANET
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes type) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, type);
    }

    public String getName() {
        return key.getName();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyTypes getBodyType() {
        return key.getType();
    }

    public static Key makeKey(String name, BodyTypes type) {
        return new Key(name, type);
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public Key getKey() {
        return key;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody) {
            return ((HeavenlyBody) obj).getKey().equals(this.key);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + key.name + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", bodyType=" + key.type +
                '}';
    }

    public static class Key {
        private final String name;
        private final BodyTypes type;

        private Key(String name, BodyTypes type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getType() {
            return type;
        }

        @Override
        public boolean equals(Object o) {
            Key key = (Key) o;
            return name.equals(key.name) &&
                    type == key.type;
        }

        @Override
        public int hashCode() {
            return type.hashCode() + 57 + name.hashCode();
        }

        @Override
        public String toString() {
            return "Key{" +
                    "name='" + name + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}