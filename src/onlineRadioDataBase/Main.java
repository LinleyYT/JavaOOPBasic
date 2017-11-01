package onlineRadioDataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Radio radio = new Radio();
        Integer n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] songInfo = reader.readLine().trim().split(";");
            if (songInfo.length == 3){
                try{
                    radio.addSongInformation(new SongInformation(songInfo[0], songInfo[1], songInfo[2]));
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        System.out.println(radio.toString());
    }
}
