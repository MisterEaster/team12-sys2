
package oving5;
import java.util.Date; 
import java.util.Random;
import java.text.DecimalFormat;
/**
 *
 * @author Nina
 */
public class Booking {
    private int bookingKode;
    private Date tidspunktBooking = new Date();
    private Date hentefrist; 
    
    public Booking(Date tidspunktBooking){
        
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
    
    public int genererKode(){
       Random random = new Random(); 
       bookingKode = 1000 + random.nextInt(8999);
       return bookingKode; 
    }
    
    
    public static void main (String[] args){
        
        
    }
    
    
    
    
}
