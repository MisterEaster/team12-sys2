
package oving5;
import java.util.Date; 

/**
 *
 * @author Nina
 */
public class Booking {
    private int bookingKode;
    private Date tidspunktBooking = new Date();
    private Date hentefrist; 
    
    public Booking(int bookingKode, Date tidspunktBooking){
        
        this.bookingKode = bookingKode;
        this.tidspunktBooking = tidspunktBooking; 
        this.hentefrist = new Date(tidspunktBooking.getTime() + 30*60000);
    }

    public int getBookingKode() {
        return bookingKode;
    }

    public Date getTidspunktBooking() {
        return tidspunktBooking;
    }

    public Date getHentefrist() {
        return hentefrist;
    }
    
    
    
    
}
