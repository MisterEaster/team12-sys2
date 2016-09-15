package oving5;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nina
 */
public class Parkeringsplass {
    private String navn;
    private ArrayList<Sykkel> oversiktSykler = new ArrayList<>();

    public Parkeringsplass(String navn, ArrayList <Sykkel> oversiktSykler) {
        this.navn = navn; 
        this.oversiktSykler = oversiktSykler; 
    }
    
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Sykkel> getOversiktSykler() {
        return oversiktSykler;
    }

    public void setOversiktSykler(ArrayList <Sykkel> oversiktSykler) {
        this.oversiktSykler = oversiktSykler;
    }
    
    public void hentSykkel(ArrayList <Sykkel> oversiktSykler, int index){
        for (int i = 0; i < oversiktSykler.size(); i++){
            if(oversiktSykler.get(i) != null){
                oversiktSykler.set(index, null); 
            }
        }
    }
    
    public static ArrayList<Sykkel> createList(int antall, int idStart){
       ArrayList <Sykkel> oversiktSykler = new ArrayList(); 
        for (int i = 0; i < antall; i++){
            oversiktSykler.add(new Sykkel(idStart, false, false, 100)); 
       } 
        return oversiktSykler;
    }
    
     public static void main(String[] args) {
        ArrayList <Sykkel> oversiktSykler1 =  createList(20, 1); 
        Parkeringsplass p1 = new Parkeringsplass ("Dragvoll", oversiktSykler1); 
        
        ArrayList <Sykkel> oversiktSykler2 = createList(20, 21); 
        Parkeringsplass p2 = new Parkeringsplass ("Kalvskinnet", oversiktSykler2);
        
        ArrayList <Sykkel> oversiktSykler3 = createList(20, 41); 
        Parkeringsplass p3 = new Parkeringsplass ("Gløshaugen", oversiktSykler3);
        
        ArrayList <Sykkel> oversiktSykler4 = createList(20, 61); 
        Parkeringsplass p4 = new Parkeringsplass ("Midtbyen", oversiktSykler4);
        
         ArrayList <Sykkel> oversiktSykler5 = createList(20, 81); 
        Parkeringsplass p5 = new Parkeringsplass ("Solsiden", oversiktSykler5);
        
    }
}
