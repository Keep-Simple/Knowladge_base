package basics.BaseCourse.Generics;

public abstract class Player <T extends Player> implements Comparable<Player<T>>{
    private String name;
    private int rank;

    public Player(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Player<T> team) {
        if (this.getRank() > team.getRank()) {
            return 1;
        } else if (this.getRank() < team.getRank()) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }
}
