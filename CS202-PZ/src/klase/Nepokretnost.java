/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klase;

import exceptions.NevalidnaCenaException;
import exceptions.NevalidnaPovrsinaException;

/**
 *
 * @author aleks
 */
public class Nepokretnost {
    private int nepokretnostId;
    private double cena;
    private double povrsina;
    private String tipObjekta;
    private int dodatnoId;
    private int loakcijaId;
    private int vlasnikId;

    public Nepokretnost(int nepokretnostId, double cena, double povrsina, String tipObjekta, int dodatnoId, int loakcijaId, int vlasnikId) throws NevalidnaCenaException, NevalidnaPovrsinaException {
        this.nepokretnostId = nepokretnostId;
        setCena(cena);
        setPovrsina(povrsina);
        this.tipObjekta = tipObjekta;
        this.dodatnoId = dodatnoId;
        this.loakcijaId = loakcijaId;
        this.vlasnikId = vlasnikId;
    }

    public int getNepokretnostId() {
        return nepokretnostId;
    }

    public void setNepokretnostId(int nepokretnostId) {
        this.nepokretnostId = nepokretnostId;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) throws NevalidnaCenaException {
        if(cena > 0){
            this.cena = cena;
        }else{
            throw new NevalidnaCenaException("Cena mora biti veca od nule.");
        }
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) throws NevalidnaPovrsinaException {
        if(povrsina > 10){
            this.povrsina = povrsina;
        }else{
            throw new NevalidnaPovrsinaException("Povrsina mora biti veca od 10.");
        }
    }

    public String getTipObjekta() {
        return tipObjekta;
    }

    public void setTipObjekta(String tipObjekta) {
        this.tipObjekta = tipObjekta;
    }

    public int getDodatno() {
        return dodatnoId;
    }

    public void setDodatno(int dodatnoId) {
        this.dodatnoId = dodatnoId;
    }

    public int getLokacija() {
        return loakcijaId;
    }

    public void setLokacija(int loakcijaId) {
        this.loakcijaId = loakcijaId;
    }

    public int getVlasnik() {
        return vlasnikId;
    }

    public void setVlasnik(int vlasnikId) {
        this.vlasnikId = vlasnikId;
    }

    @Override
    public String toString() {
        return "Nepokretnost{" + "nepokretnostId=" + nepokretnostId + ", cena=" + cena + ", povrsina=" + povrsina + ", tipObjekta=" + tipObjekta + ", dodatnoId=" + dodatnoId + ", loakcijaId=" + loakcijaId + ", vlasnikId=" + vlasnikId + '}';
    }

    

    
    
    
    
    
}
