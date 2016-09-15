package oving5;
import java.util.Date;

/**
 *
 * @author Nina
 */
public class Sykkel {

    private int sykkelId;
    private boolean iBruk;
    private Date levdato = new Date();
    private Parkeringsplass p; 
    private boolean erBooket;
    private int battStatus; 

    public Sykkel (int sykkelId, boolean iBruk, boolean reservert, int battStatus) {
        this.sykkelId = sykkelId;
        this.iBruk = iBruk;
        this.erBooket = erBooket;
        this.battStatus = battStatus;  
    }

    public int getBikeId() {
        return sykkelId;
    }

    public void setBikeId(int sykkelId) {
        this.sykkelId = sykkelId;
    }

    public boolean erIBruk() {
        return iBruk;
    }

    public void setErIBruk(boolean iBruk) {
        this.iBruk = iBruk; 
    }

   public boolean erBooket() {
        return erBooket;
    }
   
    public void setErBooket(boolean erBooket) {
        this.erBooket = erBooket; 
    }
    
    public boolean erLevert(){
        return iBruk = false;
    }

    public int getBattStatus() {
        return battStatus;
    }

    public void setBattStatusHent() {
        Date d = new Date(); 
        long antMin = (d.getTime() - levdato.getTime()) / 60000;
        battStatus = battStatus - (int)(antMin / 0.25 / 60); 
    }
    
     public void setBattStatusLev(Date hentedato) {
        Date levering = new Date(); 
        levdato = levering; 
        long antMin = (levering.getTime() - (hentedato.getTime())) / 60000;
        battStatus = battStatus - (int)(antMin * 0.25 / 60);
    }
     
     

    public Date getLevdato() {
        return levdato;
    }

    public void setLevdato(Date levdato) {
        this.levdato = levdato;
    }
    
    
    
    
    
    
}
