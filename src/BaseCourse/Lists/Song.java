package BaseCourse.Lists;

public class Song {

    private double songDuration;
    private String songName;

    public Song(String songName, double songDuration) {
        this.songDuration = songDuration;
        this.songName = songName;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public String getSongName() {
        return songName;
    }

}
