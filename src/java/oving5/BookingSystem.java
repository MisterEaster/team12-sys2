package oving5;


import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicole
 */
public class BookingSystem {

    public BookingSystem() {}

    public int finnParkPlass(String parkNavn) {
        switch (parkNavn) {
            case "Dragvoll":
                return 0;
            case "Kalvskinnet":
                return 1;
            case "Gløshaugen":
                return 2;
            case "Midtbyen":
                return 3;
            case "Solsiden":
                return 4;
            default:
                return -1;
        }
    }

    //Funker : printer ut streng med info: sykkelID, parkeringsplass og kode
    public String bookSykkel(String parkNavn, Collection<Parkeringsplass> parks) {
        int parkplass = finnParkPlass(parkNavn);
        Parkeringsplass[] parkeringsplasser = parks.toArray(new Parkeringsplass[parks.size()]);
        Parkeringsplass park = parkeringsplasser[parkplass];
        

        for (Sykkel sykkel : park.getOversiktSykler()) {
            if (!sykkel.getErIBruk() && !sykkel.getErBooket()) {
                sykkel.setErBooket(true);
                Booking booking = new Booking(sykkel, parkNavn);
                return "Du har fått tildelt sykkel " + booking.getSykkelId() + " på " + park.getNavn() + " med kode " + booking.getBookingKode();
            }
        }
        return "Feil oppstod";
    }

    public String hentSykkel(Collection<Booking> bookings, int kode, int sykkelId, String parkNavn, Collection<Parkeringsplass> parks) {
        int parkplass = finnParkPlass(parkNavn);
        Parkeringsplass[] parkeringsplasser = parks.toArray(new Parkeringsplass[parks.size()]);
        Parkeringsplass park = parkeringsplasser[parkplass];
        Booking testBook;
        Sykkel sykkel = new Sykkel(sykkelId);
        for (int i=0; i<bookings.size();i++) {
            testBook = new Booking(sykkel, parkNavn);
            if (bookings.contains(testBook) && park.finnSykkelPlass(sykkelId) != -1) {
                park.hentSykkel(sykkelId);
                return "Sykkel " + sykkelId + " er hentet fra " + parkNavn;
            }
        }
        return "Sykkel er ikke booket, finnes ikke i parkeringsplassen, eller du har brukt feil kode";
    }

    public String leverSykkel(String parkNavn, Sykkel sykkel, Collection<Parkeringsplass> parks) {
        int parkplass = finnParkPlass(parkNavn);
        Parkeringsplass[] parkeringsplasser = parks.toArray(new Parkeringsplass[parks.size()]);
        Parkeringsplass park = parkeringsplasser[parkplass];
        if (park.checkLedigPlass()) {
            park.leverSykkel(sykkel);
            return "Sykkel " + sykkel.getSykkelId() + " er levert på " + parkNavn;
        }
        return "sykkel ble ikke levert";
    }

}
