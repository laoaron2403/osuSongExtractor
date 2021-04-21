import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Objects containing metadata of the map
 * @author sealnot123
 */
public class Metadata {
    private String audioFileName;   // the name of mp3 file
    private String title;           // the title of the song
    private String unicodeTitle;    // the unicode title
    private String artist;          // the artist of the song
    private String unicodeArtist;   // the unicode artist
    private String bgFileName;      // the name of wallpaper file

    /**
     * Constructor
     * @param osuMap the file of osu map
     */
    public Metadata(File osuMap) throws IOException{
        Scanner in = new Scanner(osuMap); // what is 'delimiter'?
        StringBuilder data = readAll(in);
        String[] sp = data.toString().split("\n\n");
        audioFileName = sp[1].split("\n")[1].split(":")[1].trim();
        title = sp[3].split("\n")[1].split(":")[1].trim();
        unicodeTitle = sp[3].split("\n")[2].split(":")[1].trim();
        artist = sp[3].split("\n")[3].split(":")[1].trim();
        unicodeArtist = sp[3].split("\n")[4].split(":")[1].trim();
        bgFileName = sp[5].split("\n")[2].split(",")[2].replaceAll("\"", "");
    }

    /**
     * Private helper method to read all lines of
     * the file opened by the scanner into a string
     * @param in scanner of the file
     * @return string contains the content of the file
     */
    private StringBuilder readAll(Scanner in){
        StringBuilder data = new StringBuilder("");
        while(in.hasNext()){
            data.append(in.nextLine()).append('\n');
        }
        return data;
    }

    public String getAudioFileName(){
        return audioFileName;
    }

    public String getTitle(){
        return title;
    }
    
    public String getUnicodeTitle(){
        return unicodeTitle;
    }
    
    public String getArtist(){
        return artist;
    }
    
    public String getUnicodeArtist(){
        return unicodeArtist;
    }
    
    public String getBGFileName(){
        return bgFileName;
    }

    public static void main(String[] args){
        try{
            File osuMap = new File("namirin - Sakurairo Time Capsule (Fuccho) [Petal].osu");
            Metadata test = new Metadata(osuMap);
            System.out.println(test.getAudioFileName());
            System.out.println(test.getTitle());
            System.out.println(test.getUnicodeTitle());
            System.out.println(test.getArtist());
            System.out.println(test.getUnicodeArtist());
            System.out.println(test.getBGFileName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}