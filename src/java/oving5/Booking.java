package oving5;

import java.util.Date;
import java.util.Random;

public class Booking {
    
private final Random random = new Random(); 
    private final int bookingKode;
    private final Sykkel sykkel;
    private String parkNavn;
    private final Date tidspunktBooking;
    private final Date hentefrist; 
    
    public Booking(Sykkel sykkel, String parkNavn){
        this.sykkel = sykkel;
        this.parkNavn = parkNavn;
        tidspunktBooking = new Date();
        hentefrist = new Date(tidspunktBooking.getTime() + 30 *60000);
        bookingKode = 1000 + random.nextInt(8999);
    }

    public Sykkel getSykkel() {
        return sykkel;
    }
    public int getSykkelId(){
        return sykkel.getSykkelId();
    }
    public void setSykkelHenteTid(){
        sykkel.setHenteDato(new Date());
    }
    public void setSykkelLevTid(){
        sykkel.setLevdato(new Date());
    }
    public void setSykkelBatteriStatHent(){
        sykkel.setBattStatusHent(sykkel.getHenteDato());
    }
    public void setSykkelBatteriStatLev(){
        sykkel.setBattStatusLev(sykkel.getLevdato());
    }
    public int getSykkelBatteriStat(){
        return sykkel.getBattStatus();
    }
    public void setSykkelStat(){
        sykkel.setErBooket(false);
    }

    public String getParkNavn() {
        return parkNavn;
    }
    
    public int getBookingKode() {
        return bookingKode;
    }
    public boolean checkKode(int bookingKode){
        if(this.bookingKode == bookingKode){
            return true;
        } return false;
    }

    /*public Date getTidspunktBooking() {   //ubrukt
        return tidspunktBooking;
    }
    public Date getHentefrist() {
        return hentefrist;
    }*/                                     //ubrukt
}
