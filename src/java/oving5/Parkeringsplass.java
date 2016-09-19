package oving5;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicole
 */
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
    
    public boolean checkLedigPlass(){
        for(Sykkel sykkel:oversiktSykler){
            if(sykkel == null){
                return true;
            }
        }return false;
    }
    
}
