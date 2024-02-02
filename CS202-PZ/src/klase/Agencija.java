/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klase;

import exceptions.NevalidanNazivException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class Agencija {
    private String naziv;
    List<Ugovor> ugovori;
    List<Nepokretnost> nepokretnosti;

    public Agencija(String naziv, List<Ugovor> ugovori, List<Nepokretnost> nepokretnost) throws NevalidanNazivException {
        setNaziv(naziv);
        this.ugovori = ugovori;
        this.nepokretnosti = nepokretnosti;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) throws NevalidanNazivException{
        if(Character.isUpperCase(naziv.charAt(0))){
            this.naziv = naziv;
        }else {
            throw new NevalidanNazivException("Prvo slovo naziva nije veliko");
        }
    }

    public List<Ugovor> getUgovori() {
        return ugovori;
    }

    public void setUgovori(List<Ugovor> ugovori) {
        this.ugovori = ugovori;
    }

    public List<Nepokretnost> getNepokretnost() {
        return nepokretnosti;
    }

    public void setNepokretnost(List<Nepokretnost> nepokretnost) {
        this.nepokretnosti = nepokretnosti;
    }

    public void dodajUgovor(Ugovor ugovor){
        if (ugovori == null){
            ugovori = new ArrayList<>();
        }
        ugovori.add(ugovor);
    }
    
    public void dodajNepokretnost(Nepokretnost nepokretnost){
        if (nepokretnosti == null){
            nepokretnosti = new ArrayList<>();
        }
        nepokretnosti.add(nepokretnost);
    }
    
    @Override
    public String toString() {
        return "Agencija{" + "naziv=" + naziv + ", ugovori=" + ugovori + ", nepokretnost=" + nepokretnosti + '}';
    }
    
    
    
}
