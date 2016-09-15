package oving5;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nina
 */
public class BookingSystem {

    ArrayList<Booking> listeBookinger = new ArrayList<Booking>();
    ArrayList<Parkeringsplass> parkeringsplass = new ArrayList<Parkeringsplass>();
    
    public BookingSystem(){ 
    }
    
    public int bookSykkel(Parkeringsplass parkeringsplass) {
        for (Sykkel s : parkeringsplass.getOversiktSykler()) {
            if (!s.erIBruk() && !s.erBooket()) {
                s.setErBooket(true);
                Booking booking = new Booking(new Date()); 
                return booking.genererKode();
            }
        }
        return -1;
    }
    
    public boolean hentSykkel(int bookingKode, Booking booking, Sykkel sykkel, Parkeringsplass parkeringsplass){
        if(booking.getBookingKode() == bookingKode){
            Date d = new Date(); 
            if(d.getTime() < booking.getHentefrist().getTime()){
            sykkel.setErIBruk(true); 
            //parkeringsplass.hentSykkel(sykkel, index);  
            return true; 
            }
        }
        return false; 
    }
    
    public void leverSykkel(Parkeringsplass parkeringsplass, Sykkel sykkel){
        //parkeringsplass.setOversiktSykler(oversiktSykler);
        sykkel.setErLevert(true);
    }
}
    
