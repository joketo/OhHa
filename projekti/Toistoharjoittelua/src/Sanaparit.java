
import java.util.HashMap;

public class Sanaparit {

    HashMap<String, String> sanasto1To2; //avaimina esim. sanat englanniksi, arvoina käännökset suomeksi
    HashMap<String, String> sanasto2To1; //sama toistepäin (avaimina suomeksi, arvoina enkuksi)

    public Sanaparit(HashMap<String, String> sanasto1To2, HashMap<String, String> sanasto2To1) {
        this.sanasto1To2 = sanasto1To2;
        this.sanasto2To1 = sanasto2To1;
    }
    

    public boolean onkoParitSanasto1To2(String eka, String toka) {
        if (sanasto1To2.get(eka).equals(toka)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onkoParitSanasto2To1(String eka, String toka) {
        if (sanasto2To1.get(eka).equals(toka)) {
            return true;
        } else {
            return false;
        }
    }

    public String getPariSanasto1To2(String sana) {
        return sanasto1To2.get(sana);
    }

    public String getPariSanasto2To1(String sana) {
        return sanasto2To1.get(sana);
    }
    public HashMap<String, String> getSanasto1To2(){
        return sanasto1To2;
    }
    public HashMap<String, String> getSanasto2To1(){
        return sanasto2To1;
    }
}
