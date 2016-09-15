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
     
     public BookingSystem(){ }

   

    public int bookBike(Parkeringsplass parkeringsplass) {
        
    
        for (Sykkel sykkel : parkeringsplass.getOversiktSykler()) {
            if (!sykkel.erIBruk() && !sykkel.erBooket()) {
                sykkel.setErBooket(true);
                Booking booking = new Booking(new Date()); 
                return booking.genererKode();
            }
        }
        return -1;
    }

    public void releaseBike(String kode){
    }
    
}
