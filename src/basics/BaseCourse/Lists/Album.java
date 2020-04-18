package basics.BaseCourse.Lists;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
    private SongList songs;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songs = new SongList();
    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs= new ArrayList();
        }

        public boolean addSong(String title, double duration) {
            if(findTitle(title) == null) {
                this.songs.add(new Song(title, duration));
                return true;
            }
            return false;
        }

        private Song findTitle(String title) {
            for(Song i : this.songs) {
                if(i.getSongName().equals(title))
                    return i;
            }
            return null;
        }

        public ArrayList<Song> getAlbum() {
            return this.songs;
        }
    }


    public boolean addSong(String title, double duration) {
        return this.songs.addSong(title,duration);
    }

    public boolean addToPlayList(LinkedList<Song> playList, int index) {
        int track = index - 1;
        if(track >=0 && track <= this.songs.getAlbum().size()) {
            playList.add(this.songs.getAlbum().get(track));
            return true;
        }
        System.out.println("No track found in album, or provided with wrong index");
        return false;
    }
    //overloading
    public boolean addToPlayList(LinkedList<Song> playlist, String title) {
        Song song = this.songs.findTitle(title);
        if(song != null) {
            playlist.add(song);
            return true;
        }
        else {
            System.out.println("Track not found");
            return false;
        }
    }
}
