package basics.BaseCourse.Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<U extends Player>{
    private String leagueName;
    private List<U> list = new ArrayList<>();

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    public boolean addTeam(U team) {
        if(!list.contains(team)) {
            list.add(team);
            return true;
        } else {
            System.out.println(team.getName() + " Already in the list");
            return false;
        }
    }

    public void printLeague() {
        Collections.sort(list);
        for(U i : list) {
            System.out.println(i.getName());
        }
    }
}

