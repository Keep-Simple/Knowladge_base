package basics.BaseCourse.JavaIO.First;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location {
    private final String location;
    private final int id;
    private final HashMap<String, Integer> exits;

    public Location(int id, String location) {
        this.location = location;
        this.id = id;
        this.exits = new LinkedHashMap<>();
    }

    public Location(int id, String location, HashMap<String, Integer> exits) {
        this.location = location;
        this.id = id;
        this.exits = exits;
    }

    public String getDescription() {
        return location;
    }

    public int getId() {
        return id;
    }

    public Map<String, Integer> getExits() {
        // return new HashMap<>(exits);
        return Collections.unmodifiableMap(exits);
//        return  this.exits;
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}
