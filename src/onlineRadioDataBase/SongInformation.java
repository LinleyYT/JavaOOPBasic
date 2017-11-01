package onlineRadioDataBase;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;

public class SongInformation extends ArtistInformation{
 private String songName;
 private Integer songMinutes;
 private Integer songSeconds;
 private Integer songLenght;

    public Integer getSongLenght() {
        return songLenght;
    }

    public SongInformation(String artist, String songName, String songLenght) {
        super(artist);
        setSongName(songName);
        setSongLenght(songLenght);
    }

    protected void setSongName(String songName) {
        if (songName.length() <3 || songName.length()>30){
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setSongMinutes(Integer songMinutes) {
        if (songMinutes<0 || songMinutes > 14)
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        this.songMinutes = songMinutes;
    }

    private void setSongSeconds(Integer songSeconds) {
        if (songSeconds < 0 || songSeconds > 59){
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
        this.songSeconds = songSeconds;
    }

    public void setSongLenght(String songLenght) {
        String[] splitedSongLenght = songLenght.trim().split(":");
        Integer lenght = 0;
        try{
            lenght += 60* Integer.parseInt(splitedSongLenght[0]);
            lenght+= Integer.parseInt(splitedSongLenght[1]);
        }catch (Exception ex){
            throw new IllegalArgumentException("Invalid song length.");
        }
        setSongMinutes(Integer.parseInt(splitedSongLenght[0]));
        setSongSeconds(Integer.parseInt(splitedSongLenght[1]));
        this.songLenght = lenght;
    }
}
