package oving5;


import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Stateless
@Path("/bike")
public class BikeResource {
    private static Map<Integer,Booking> bookingmap = new HashMap<>();
    private static Map<String,Parkeringsplass> parkmap = new HashMap<>();
    BookingSystem bookingSystem;

    public BikeResource() {
        this.bookingSystem = new BookingSystem();
        parkmap.put("Dragvoll", new Parkeringsplass("Dragvoll", 20, 1));
        parkmap.put("Kalvskinnet", new Parkeringsplass("Kalvskinnet", 20, 21));
        parkmap.put("Gløshaugen", new Parkeringsplass("Gløshaugen", 20, 41));
        parkmap.put("Midtbyen", new Parkeringsplass("Midtbyen", 20, 61));
        parkmap.put("Solsiden", new Parkeringsplass("Solsiden", 20, 81));
    }

    @POST
    @Path("/reserve")
    @Produces("text/html")
    public Response reserve(@QueryParam("parkNavn") String parkNavn) {
        //if reserveBike returns code when successful and null when fails
        String reservationCode = bookingSystem.bookSykkel(parkNavn);
        
        if (reservationCode != null) {
            return Response.ok(reservationCode).build(); // it was successful
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    //@GET
    //@Path("/somethingElse")
    //@Produces("text/html")
    //public String getSomethingElse() {
    //    return "Something else!";
    //}
    
    @GET
    @Path("/getBookings")
    @Produces("text/html")
    public Collection<Booking> getBookingCollection(){
        return bookingmap.values();
    }

    @POST
    @Path("/release")
    @Produces("text/html")
    public Response releaseBike(
            @QueryParam("kode") int kode,
            @QueryParam("sykkelId") int sykkelId,
            @QueryParam("parkNavn") String parkNavn ) 
    {
        
        
        
        
        
        System.out.println("-------------------------------------------------");
        System.out.println(kode);
        System.out.println(sykkelId);
        System.out.println(parkNavn);
        System.out.println("-------------------------------------------------");
        String returnValue = bookingSystem.hentSykkel(kode, sykkelId, parkNavn);
        if (returnValue != null) {
            return Response.ok(returnValue).build(); // it was successful
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
