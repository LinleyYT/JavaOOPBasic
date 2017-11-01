package onlineRadioDataBase;

import java.util.ArrayList;

 class Radio {
    private ArrayList<SongInformation> songInformations;

    protected Radio() {
        this.songInformations = new ArrayList<>();
    }
    public void addSongInformation(SongInformation songInformation){
        this.songInformations.add(songInformation);
        System.out.println("Song added.");
    }

     @Override
     public String toString() {
         return String.format("Songs added: %d\nPlaylist length: %s",this.songInformations.size(), calculateSongsLength());
     }

     private String calculateSongsLength() {
         Integer length = 0;
         for (SongInformation a : this.songInformations
                 ) {
             length += a.getSongLenght();
         }
         Integer hour = (int)Math.floor((length/60)/60);
         length -= hour * 60 * 60;
         Integer minutes = (int)Math.floor(length/60);
         length -= minutes * 60;
         Integer seconds = length;



         return String.format("%dh %dm %ds", hour, minutes, seconds);
     }
 }
