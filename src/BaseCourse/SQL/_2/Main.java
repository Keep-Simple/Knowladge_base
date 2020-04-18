package BaseCourse.SQL._2;

import java.util.List;
import java.util.Scanner;

import static BaseCourse.SQL._2.SortOrder.ORDER_BY_DESC;
import static BaseCourse.SQL._2.SortOrder.ORDER_BY_NONE;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        if (!dataSource.open()) {
            System.out.println("Cannot open datasource");
            return;
        }

        List<Artist> artists = dataSource.queryArtists(ORDER_BY_NONE);
        if (artists.isEmpty()) {
            System.out.println("No artists!");
            return;
        }

        artists.forEach(artist -> System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName()));

        System.out.println("-----------------------------------------------");

        List<String> list = dataSource.queryAlbumsForArtist("Pink Floyd", ORDER_BY_DESC);
        if (list.isEmpty()) {
            System.out.println("No albums!");
            return;
        }

        list.forEach(System.out::println);

        System.out.println("-----------------------------------------------");

        List<SongArtist> songArtists = dataSource.queryArtistsForSong("Heartless", ORDER_BY_DESC);
        if (songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        songArtists.forEach(songArtist -> System.out.println("Artist name = " + songArtist.getArtistName() +
                "\nAlbum name = " + songArtist.getAlbumName() +
                "\nTrack number = " + songArtist.getTrack()));

        System.out.println("--------------------------------------------------------");
        dataSource.querySongsMetadata();

        System.out.println("------------------------------------------------------");
        dataSource.getCount(DataSource.TABLE_SONGS);

        dataSource.createViewForSongArtists();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title : ");
        String title = scanner.nextLine();

        songArtists = dataSource.querySongInfoView(title);
        if (songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for this song");
            return;
        }

        songArtists.forEach(songArtist -> System.out.println("FROM VIEW - Artist name = " + songArtist.getArtistName() +
                " Album name = " + songArtist.getAlbumName() +
                " Track number = " + songArtist.getTrack()));

        ////////////////////////////////////////////////////////////////////////////////////

        dataSource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark", 1);

        dataSource.close();
    }
}
