package oving5;

import java.util.Date; 
import java.util.Random;

public class Booking {
    private final Random random = new Random(); 
    private final int bookingKode;
    private final Sykkel sykkel;
    private final Date tidspunktBooking;
    private final Date hentefrist; 
    
    public Booking(Sykkel sykkel){
        this.sykkel = sykkel;
        tidspunktBooking = new Date();
        hentefrist = new Date(tidspunktBooking.getTime() + 30 *60000);
        bookingKode = 1000 + random.nextInt(8999);
    }

    public int getSykkelId(){
        return sykkel.getSykkelId();
    }
    public boolean checkSykkelId(int sykkelId){
        if(sykkel.getSykkelId() == sykkelId){
            return true;
        }return false;
    }
    
    public int getBookingKode() {
        return bookingKode;
    }
    public boolean checkKode(int bookingKode){
        if(this.bookingKode == bookingKode){
            return true;
        } return false;
    }

    public Date getTidspunktBooking() {
        return tidspunktBooking;
    }

    public Date getHentefrist() {
        return hentefrist;
    }
}
