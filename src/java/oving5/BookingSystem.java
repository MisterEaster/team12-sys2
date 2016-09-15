package oving5;

import java.util.ArrayList;
import java.util.Date;

public class BookingSystem {

    ArrayList<Booking> listeBookinger = new ArrayList();
    ArrayList<Parkeringsplass> parkeringsplasser = new ArrayList();
    
    public BookingSystem(){
        parkeringsplasser.add(new Parkeringsplass ("Dragvoll", 20, 1));
        parkeringsplasser.add(new Parkeringsplass ("Kalvskinnet", 20, 21));
        parkeringsplasser.add(new Parkeringsplass ("Gløshaugen", 20, 41));
        parkeringsplasser.add(new Parkeringsplass ("Midtbyen", 20, 61));
        parkeringsplasser.add(new Parkeringsplass ("Solsiden", 20, 81));
    }
    
    public int finnParkPlass(String parkNavn){
        switch (parkNavn) {
            case "Dragvoll": return 0;
            case "Kalvskinnet":  return 1;
            case "Gløshaugen":  return 2;
            case "Midtbyen":  return 3;
            case "Solsiden":  return 4;
            default: return -1;
        }
    }
    
    public int bookSykkel(String parkNavn) {
        int parkplass = finnParkPlass(parkNavn);
        Parkeringsplass park = parkeringsplasser.get(parkplass);
        
        for (Sykkel sykkel : park.getOversiktSykler()) {
            if (!sykkel.getErIBruk() && !sykkel.getErBooket()) {
                sykkel.setErBooket(true);
                Booking booking = new Booking(sykkel); 
                return booking.getBookingKode();
            }
        }
        return -1;
    }
    
    public boolean hentSykkel(int kode, int sykkelId, String parkNavn){
        int parkplass = finnParkPlass(parkNavn);
        Parkeringsplass park = parkeringsplasser.get(parkplass);
        for(Booking booking : listeBookinger){
            if(booking.checkSykkelId(sykkelId) && booking.checkKode(kode) && park.finnSykkelPlass(sykkelId)!=-1){
                park.hentSykkel(sykkelId);
                return true;
            }
        } return false;
    }
    
    public boolean leverSykkel(String parkNavn, Sykkel sykkel){
        int parkplass = finnParkPlass(parkNavn);
        Parkeringsplass park = parkeringsplasser.get(parkplass);
        if(park.checkLedigPlass()){
            park.leverSykkel(sykkel);
            return true;
        } return false;
    }
}
    
