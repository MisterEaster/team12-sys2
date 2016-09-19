package oving5;

import java.util.ArrayList;

public class Parkeringsplass extends Object {
    private final String navn;
    private ArrayList<Sykkel> oversiktSykler = new ArrayList();

    public Parkeringsplass(String navn, int antall, int idStart) {
        this.navn = navn; 
        for (int i = 0; i < antall; i++){
            Sykkel sykkel = new Sykkel(idStart+i);
            oversiktSykler.add(sykkel); 
        } 
    }
    
    public String getNavn() {
        return navn;
    }

    public ArrayList<Sykkel> getOversiktSykler() {
        return oversiktSykler;
    }

    public int finnSykkelPlass(int id){
        for(int i=0; i<oversiktSykler.size(); i++){
            if(oversiktSykler.get(i).getSykkelId() == id){
                return i;
            }
        }return -1;
    }
    
    public void hentSykkel(int id){
        for(int i=0; i<oversiktSykler.size(); i++){
            if(oversiktSykler.get(i).getSykkelId() == id){
                oversiktSykler.set(i, null);
            }
        }
    }
    public void leverSykkel(Sykkel sykkel){
        int i = 0;
        while(oversiktSykler.get(i) != null){
            i++;
        }oversiktSykler.set(i, sykkel);
    }
    public void revoke(int sykkelId){
        for(int i=0;i<oversiktSykler.size();i++){
            if(oversiktSykler.get(i).getSykkelId()==sykkelId){
                oversiktSykler.get(i).setErBooket(false);
            }
        }
    }
    
    public boolean checkLedigPlass(){
        for(Sykkel sykkel:oversiktSykler){
            if(sykkel == null){
                return true;
            }
        }return false;
    }
    
}
