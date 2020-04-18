package BaseCourse.JavaIO.Second;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location implements Serializable {
    private final String location;
    private final int id;
    private final Map<String, Integer> exits;
    private long serialVersionUID = 1L;

    public Location(int id, String location) {
        this.location = location;
        this.id = id;
        this.exits = new LinkedHashMap<>();
    }

    public Location(int id, String location, Map<String, Integer> exits) {
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
