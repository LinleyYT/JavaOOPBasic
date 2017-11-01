package onlineRadioDataBase;

public class ArtistInformation {
  private   String artistName;

    protected String getArtistName() {
        return artistName;
    }

    protected void setArtistName(String artistName) {
        if (artistName.length() <3 || artistName.length() >20){
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    public ArtistInformation(String artist) {
        setArtistName(artist);
    }
}
