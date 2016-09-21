package oving5;

import java.util.*;
import javax.ejb.Stateless;
import javax.ws.rs.*;
//import javax.ws.rs.core.Response;

@Stateless
@Path("/bike")
public class BikeResource {
    private static Map<Integer,Booking> bookingmap = new HashMap<>();
    private static Map<String,Parkeringsplass> parkmap = new HashMap<>();
    static {
    parkmap.put("Dragvoll", new Parkeringsplass("Dragvoll", 20, 1));
    parkmap.put("Kalvskinnet", new Parkeringsplass("Kalvskinnet", 20, 21));
    parkmap.put("Gløshaugen", new Parkeringsplass("Gløshaugen", 20, 41));
    parkmap.put("Midtbyen", new Parkeringsplass("Midtbyen", 20, 61));
    parkmap.put("Solsiden", new Parkeringsplass("Solsiden", 20, 81));
    }

    @POST
    @Path("/reserve")
    @Produces("text/html")
    public String reserve(@QueryParam("parkNavn") String parkNavn) {
        Parkeringsplass park = parkmap.get(parkNavn);
        ArrayList<Sykkel> arr = park.getOversiktSykler();

        return park.printIds();
        
        /*for (Sykkel sykkel : arr) {
            if (!sykkel.getErBooket()) {
                sykkel.setErBooket(true);
                Booking booking = new Booking(sykkel, parkNavn);
                bookingmap.put(sykkel.getSykkelId(), booking);
                parkmap.put(parkNavn, park);
                if(bookingmap.containsValue(booking)&& parkmap.containsValue(park)){
                    return "Du har fått tildelt sykkel " + booking.getSykkelId() 
                        + " på " + park.getNavn() + " med kode " + booking.getBookingKode();
                }
                
            }
        }return "Feil oppstod";*/
    }
    
    @POST
    @Path("/release")
    @Produces("text/html")
    public String releaseBike(@QueryParam("kode") int kode,
            @QueryParam("sykkelId") int sykkelId,
            @QueryParam("parkNavn") String parkNavn ){
        Parkeringsplass park = parkmap.get(parkNavn);
        ArrayList<Booking> bookings = getBookingArr();
        Booking booking;
        
        for (int i=0; i<bookings.size();i++) {
            booking = bookings.get(i);
            if (booking.getSykkelId()==sykkelId && booking.checkKode(kode) && park.finnSykkelPlass(sykkelId)!=-1) {
                park.hentSykkel(sykkelId);                                              //fjern sykkel fra liste
                parkmap.put(parkNavn, park);                                            //oppdater parkmap
                booking.setSykkelHenteTid();                                            //oppdater hentetiden
                booking.setSykkelBatteriStatHent();                                     //oppdater batteri status !!! SKAL VEKK !!!
                bookingmap.put(sykkelId, booking);                                      //oppdater bookingmap
                return "Sykkel "+sykkelId+" er hentet fra "+parkNavn+" den har "
                        +booking.getSykkelBatteriStat()+"% batteri igjen";
            }
        }return "Sykkel er ikke booket, finnes ikke i parkeringsplassen, eller du har brukt feil kode"; 
    }
    
    @POST
    @Path("/return")
    @Produces("text/html")
    public String returnBike(@QueryParam("parkNavn") String parkNavn, 
            @QueryParam("sykkelId") int sykkelId){
        Parkeringsplass park = parkmap.get(parkNavn);
        ArrayList<Booking> bookings = getBookingArr();
        Booking booking;
        
        for (int i=0; i<bookings.size();i++) {
            booking = bookings.get(i);
            if(booking.getSykkelId()==sykkelId  && park.checkLedigPlass()){
                booking.setSykkelLevTid();                                              //oppdater leveringstid
                booking.setSykkelBatteriStatLev();                                      //oppdater batteristatus !!! SKAL FJERNES !!!
                booking.setSykkelStat();                                                //oppdater bookingsStatus
                park.leverSykkel(booking.getSykkel());                                  //sett inn sykkel i parkering
                parkmap.put(parkNavn, park);                                            //oppdater liste
                bookingmap.remove(sykkelId);                                            //fjern booking fra liste
            }return "Sykkelen ble levert på " + parkNavn;
        }return "sykkel ble ikke levert";
    }
    
    @POST
    @Path("/revoke")
    @Produces("text/html")
    public String revoke(@QueryParam("sykkelId") int sykkelId, 
            @QueryParam("kode") int kode){
        ArrayList<Booking> bookings = getBookingArr();
        Parkeringsplass park;
        Booking booking;
        
        for (int i=0; i<bookings.size();i++) {
            booking = bookings.get(i);
            park = parkmap.get(booking.getParkNavn());
            if(booking.getSykkelId()==sykkelId  && park.finnSykkelPlass(sykkelId)!=-1 && booking.checkKode(kode)){
                park.revoke(sykkelId);
                bookingmap.remove(sykkelId);
                parkmap.put(booking.getParkNavn(), park);
                return "Your booking has been revoked";
            }
        } return "feil";
    }
    
    public void always(){
        //check Booking times
        //update BatteriStat
    }
    
    public ArrayList<Booking> getBookingArr(){
        return new ArrayList(bookingmap.values());
    }
}
