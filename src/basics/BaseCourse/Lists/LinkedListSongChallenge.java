package basics.BaseCourse.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListSongChallenge {
    /**
     * Created Class Album to hold instances of Class Song
     * In this class we create ArrayList to hold created Albums
     * And LinkedList playlist that holds Songs
     * Using ListIterator to go trough the playlist and commit command like:
     * Forward, Back, Delete, Current
     */
    private ArrayList<Album> albums = new ArrayList<>();
    private LinkedList<Song> playList = new LinkedList<>();
    private boolean forward = true;
    private static Scanner scanner = new Scanner(System.in);
    private boolean quit = false;

    private void getPlayListString() {
        System.out.println("=================");
        for(Song i : playList)
            System.out.println(i.getSongName());
        System.out.println("=================");
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public LinkedList<Song> getPlayList() {
        return playList;
    }

    //using menu to operate playlist
    public void start() {
        ListIterator<Song> iterate = playList.listIterator();
        while (!quit) {
            String str = scanner.nextLine();
            switch (str) {

                case "Quit" :
                    System.out.println("Thanks, for listening. Bye!");
                    quit = true;
                    break;

                case "View" :
                    getPlayListString();
                    break;

                case "Forward" :
                    if(!forward && iterate.hasNext()) {
                            iterate.next();
                            forward = true;
                    }
                    if(iterate.hasNext())
                        System.out.println("Playing next song : " + iterate.next().getSongName());
                    else {
                        System.out.println("Playlist has ended");
                        forward = false;
                    }
                    break;

                case "Back" :
                    if(forward && iterate.hasPrevious()) {
                        iterate.previous();
                        forward = false;
                    }
                    if(iterate.hasPrevious())
                        System.out.println("Playing previous song : " + iterate.previous().getSongName());
                    else {
                        System.out.println("Reached the start of the Playlist");
                        forward = true;
                    }
                    break;

                case "Current" :
                    if(!iterate.hasPrevious()) {
                        System.out.println("Playing current song : " + iterate.next().getSongName());
                        break;
                    }
                    if(forward && iterate.hasPrevious())
                        System.out.println("Playing current song : " + iterate.previous().getSongName());
                    if(!forward && iterate.hasNext())
                        System.out.println("Playing current song : " + iterate.next().getSongName());
                    break;

                case "Delete" :
                    if(!iterate.hasPrevious()) {
                        System.out.println("Deleted current song : " + iterate.next().getSongName());
                        iterate.remove();
                        break;
                    }
                    if(!iterate.hasNext()) {
                        System.out.println("Deleting current song : " + iterate.previous().getSongName());
                        iterate.remove();
                        break;
                    }
                    if(forward && iterate.hasPrevious()) {
                        System.out.println("Deleted current song : " + iterate.previous().getSongName());
                        iterate.remove();
                        break;
                    }
                    if(!forward && iterate.hasNext()) {
                        System.out.println("Deleted current song : " + iterate.next().getSongName());
                        iterate.remove();
                        break;
                    }
                    break;

                 default :
                    System.out.println("Undefined command, try again");
            }
        }
    }

    public static void main(String[] args) {
        LinkedListSongChallenge go = new LinkedListSongChallenge();
        Album album1 = new Album("SPB");
        album1.addSong("School", 3.45);
        album1.addSong("Sweeper", 5.93);
        Album album2 = new Album("Brockhapmton");
        album2.addSong("Bump", 2.12);
        album2.addSong("Cash", 3.71);
        go.getAlbums().add(album1);
        go.getAlbums().add(album2);
        album1.addToPlayList(go.getPlayList(), "School");
        album1.addToPlayList(go.getPlayList(), "Sweeper");
        album2.addToPlayList(go.getPlayList(), 1);
        album2.addToPlayList(go.getPlayList(), 2);
        go.start();
    }

}
