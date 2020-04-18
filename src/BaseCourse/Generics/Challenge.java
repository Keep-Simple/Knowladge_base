package BaseCourse.Generics;

public class Challenge {
    /**
     * Abstract Class Player is generic, implements Comparable interface
     * FootballTeam and GamingTeam extends Player(they are Player<T>)
     * Class League is also Generic <U extends Player>. It holds ArrayList of Players and manipulate with them
     */
    public static void main(String[] args) {
        League<GamingTeam> league1 = new League<>("Top");
        GamingTeam team1 = new GamingTeam("GG", 12);
        GamingTeam team2 = new GamingTeam("DUCK", 10);
        FootballTeam team3 = new FootballTeam("Man", 9);
        league1.addTeam(team1);
        league1.addTeam(team2);
//        league1.addTeam(team3);
        league1.printLeague();

    }
}
