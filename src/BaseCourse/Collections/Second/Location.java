package BaseCourse.Collections.Second;

import java.util.HashMap;

public class Location {
    private final String location;
    private final int id;
    private final HashMap<String, Integer> exits;

    public Location(int id, String location) {
        this.location = location;
        this.id = id;
        this.exits = new HashMap<>();
    }

    public String getDescription() {
        return location;
    }

    public int getId() {
        return id;
    }

    public HashMap<String, Integer> getExits() {
        return new HashMap<>(exits);
//        return  this.exits;
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}
