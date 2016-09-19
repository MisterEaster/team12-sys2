package oving5;

import java.util.Date;

public class Sykkel {
    
    private final int sykkelId;
    private boolean erBooket;
    private int battStatus; 
    private Date levdato;
    private Date henteDato;

    public Sykkel (int sykkelId) {
        this.sykkelId = sykkelId;
        erBooket = false;
        battStatus = 100;
        levdato = new Date();
    }

    public int getSykkelId() {
        return sykkelId;
    }

    public boolean getErBooket() {
        return erBooket;
    }
    public void setErBooket(boolean erBooket) {
        this.erBooket = erBooket; 
    }

    public int getBattStatus() {
        return battStatus;
    }
    public void setBattStatusHent(Date d) {
        long antMin = (d.getTime() - levdato.getTime()) / 60000;
        battStatus = battStatus + (int)(antMin / 0.25 / 60); 
    }
    public void setBattStatusLev(Date hentedato) {  //Status ved innlevering
        Date levert = new Date(); 
        levdato = levert; 
        long antMin = (levert.getTime() - (hentedato.getTime())) / 60000;
        battStatus = battStatus - (int)(antMin * 0.25 / 60);
    }
     
    public Date getLevdato() {
        return levdato;
    }
    public void setLevdato(Date levdato) {
        this.levdato = levdato;
    }

    public Date getHenteDato() {
        return henteDato;
    }
    public void setHenteDato(Date henteDato) {
        this.henteDato = henteDato;
    }
}

