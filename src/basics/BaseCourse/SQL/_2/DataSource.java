package basics.BaseCourse.SQL._2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static final String DB_NAME = "music.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Professional\\" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final String COLUMN_ARTIST_ID = "_id";

    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_ALBUM = "album";

    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TITLE = 2;
    public static final int INDEX_SONG_TRACK = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final String QUERY_ARTIST_FOR_SONG_START =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK + " FROM " +
                    TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " +
                    TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS
                    + "." + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS +
                    " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " +
                    TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " WHERE " +
                    TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            "\" ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
            " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS +
            "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " ORDER BY " +
            TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK;

    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = \"";

    //USING ? and Prepared statement to prevent injection attacks
    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            '(' + COLUMN_ARTIST_NAME + ") VALUES(?)";
    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS +
            '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";
    public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS +
            '(' + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM +
            ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";
    public static final String QUERY_SONG = "SELECT " + COLUMN_SONG_TITLE + " FROM " +
            TABLE_SONGS + " WHERE " + COLUMN_SONG_TITLE + " = ?";

    private Connection conn;

    private PreparedStatement querySongInfoView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement querySong;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONG);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);
            querySong = conn.prepareStatement(QUERY_SONG);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            if (querySongInfoView != null)
                querySongInfoView.close();
            if (insertIntoAlbums != null)
                insertIntoAlbums.close();
            if (insertIntoArtists != null)
                insertIntoArtists.close();
            if (insertIntoSongs != null)
                insertIntoSongs.close();
            if (queryAlbum != null)
                queryAlbum.close();
            if (queryArtist != null)
                queryArtist.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Artist> queryArtists(SortOrder order) {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (order != SortOrder.ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ALBUM_NAME);
            sb.append(" COLLATE NOCASE ");
            sb.append((order == SortOrder.ORDER_BY_DESC) ? "DESC" : "ASC");
        }
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<Artist> artists = new ArrayList<>();
            while (results.next()) {
                Artist artist = new Artist();
                artist.setId(results.getInt(INDEX_ARTIST_ID));
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> queryAlbumsForArtist(String artistName, SortOrder order) {

        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(TABLE_ALBUMS).append('.').append(COLUMN_ALBUM_NAME).append(" FROM ");
        sb.append(TABLE_ALBUMS).append(" INNER JOIN ").append(TABLE_ARTISTS);
        sb.append(" ON ").append(TABLE_ALBUMS).append('.').append(COLUMN_ALBUM_ARTIST);
        sb.append(" = ").append(TABLE_ARTISTS).append('.').append(COLUMN_ARTIST_ID).append(" WHERE ");
        sb.append(TABLE_ARTISTS);
        sb.append('.');
        sb.append(COLUMN_ALBUM_NAME);
        sb.append(" = ");
        sb.append("\"" + artistName + "\"");
        sb.append(" ORDER BY ");
        sb.append(TABLE_ALBUMS);
        sb.append('.');
        sb.append(COLUMN_ALBUM_NAME);
        sb.append(" COLLATE NOCASE ");
        sb.append(order.value);

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<String> albums = new ArrayList<>();
            while (results.next()) {
                Album album = new Album();
                album.setName(results.getString(1));
                albums.add(album.getName());
            }
            return albums;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SongArtist> queryArtistsForSong(String songName, SortOrder order) {

        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        sb.append(songName);
        sb.append((order != SortOrder.ORDER_BY_NONE) ? QUERY_ARTIST_FOR_SONG_SORT + order.value : "");

        System.out.println(sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<SongArtist> songArtists = new ArrayList<>();

            while (results.next()) {
                SongArtist i = new SongArtist();
                i.setArtistName(results.getString(1));
                i.setAlbumName(results.getString(2));
                i.setTrack(results.getInt(3));
                songArtists.add(i);
            }
            return songArtists;
        } catch (SQLException e) {
            System.out.println("Failed" + e.getMessage());
            return null;
        }
    }

    public void querySongsMetadata() {
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i < numColumns; i++) {
                System.out.format("Column %d in the songs table is names %s\n",
                        i, meta.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCount(String table) {
        String sql = "SELECT COUNT(*) AS count FROM " + table;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {
            System.out.println("Values count = " + results.getInt("count"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean createViewForSongArtists() {
        try (Statement statement = conn.createStatement()) {
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SongArtist> querySongInfoView(String title) {
        try {
            //precompiled statement that fills ? - with values passed
            //Prevents sql injection attack
            querySongInfoView.setString(1, title); //is index of needed ? (starting with 1)
            ResultSet results = querySongInfoView.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int insertArtist(String name) throws SQLException {

        queryArtist.setString(1, name);
        ResultSet resultSet = queryArtist.executeQuery();
        if (resultSet.next())
            //getting id, if already exists
            return resultSet.getInt(1);
        else {
            //inserting
            insertIntoArtists.setString(1, name);
            //using instead of boolean execute(), because this returns int affectedRows
            int affectedRows = insertIntoArtists.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert artist!");
            }
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {

        queryAlbum.setString(1, name);
        ResultSet resultSet = queryAlbum.executeQuery();
        if (resultSet.next())
            //getting id, if already exists
            return resultSet.getInt(1);
        else {
            //inserting
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            //using instead of boolean execute(), because this returns int affectedRows
            int affectedRows = insertIntoAlbums.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert album!");
            }
            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }

    public void insertSong(String title, String artist, String album, int track) {
        //using previous two methods to get generated / existing id of album and artist
        //performing transaction with setting autoCommit to false
        //catching all exception thrown by previous methods too
        //in finally block setting autoCommit back to true

        try {
            //checking if already exists
            querySong.setString(1, title);
            ResultSet res = querySong.executeQuery();
            if(res.next()) {
                System.out.println("Song already exists");
                return;
            }
            //starting transaction if song doesn't exist
            conn.setAutoCommit(false);
            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);

            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);

            int affectedRows = insertIntoSongs.executeUpdate();
            if (affectedRows == 1) {
                conn.commit();
            } else {
                throw new SQLException();
            }

        } catch (Exception e1) {
            System.out.println("Insert song exception : " + e1.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("Oh boy!" + e2.getMessage());
            }
        } finally {
            System.out.println("Resetting default commit behavior");
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e3) {
                System.out.println("Couldn't reset autoCommit" + e3.getMessage());
            }
        }
    }

}
