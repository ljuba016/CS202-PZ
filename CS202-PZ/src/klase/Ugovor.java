/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klase;

import exceptions.NevalidanDatumException;
import exceptions.NevalidanIznosException;
import java.util.Date;

/**
 *
 * @author aleks
 */
public class Ugovor {
    private int ugovorId;
    private String datumNastanka;
    private String datumIsteka;
    private double iznos;
    private double naknadaAgenciji;
    private int redniBroj;
    private int klijentId;
    private int vlasnikId;
    
    private static final String DATUM_PATTERN = "^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";

    public Ugovor(int ugovorId, String datumNastanka, String datumIsteka, double iznos, double naknadaAgenciji, int redniBroj, int klijentId, int vlasnikId) throws NevalidanDatumException, NevalidanIznosException {
        this.ugovorId = ugovorId;
        setDatumNastanka(datumNastanka);
        setDatumIsteka(datumIsteka);
        setIznos(iznos);
        setNaknadaAgenciji(naknadaAgenciji);
        this.redniBroj = redniBroj;
        this.klijentId = klijentId;
        this.vlasnikId = vlasnikId;
    }

    public int getUgovorId() {
        return ugovorId;
    }

    public void setUgovorId(int ugovorId) {
        this.ugovorId = ugovorId;
    }

    public String getDatumNastanka() {
        return datumNastanka;
    }

    public void setDatumNastanka(String datumNastanka) throws NevalidanDatumException {
        if (datumNastanka.matches(DATUM_PATTERN)){
            this.datumNastanka = datumNastanka;
        }else{
            throw new NevalidanDatumException("Datum nije validan.");
        }
    }
    
    public static boolean jeValidanDatumNastanka(Ugovor ugovor){
        return ugovor.datumNastanka != null && ugovor.datumNastanka.matches(DATUM_PATTERN);
    }   
        
    public String getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(String datumIsteka) throws NevalidanDatumException {
        if (datumNastanka.matches(DATUM_PATTERN)){
            this.datumIsteka = datumIsteka;
        }else{
            throw new NevalidanDatumException("Datum nije validnom formatu. Trazeni format je YYYY-MM-DD");
        }
    }

    public static boolean jeValidanDatumIsteka(Ugovor ugovor){
        return ugovor.datumIsteka != null && ugovor.datumIsteka.matches(DATUM_PATTERN);
    }  
    
    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) throws NevalidanIznosException {
        if(iznos >= 0){
            this.iznos = iznos;
        }else{
            throw new NevalidanIznosException("Iznos mora biti veci ili jednak nuli.");
        }
    }
    
    public static boolean jeValidanIznos(Ugovor ugovor){
        return ugovor.iznos >= 0;
    }

    public double getNaknadaAgenciji() {
        return naknadaAgenciji;
    }

    public void setNaknadaAgenciji(double naknadaAgenciji) throws NevalidanIznosException {
        if(iznos >= 1000){
            this.naknadaAgenciji = naknadaAgenciji;
        }else{
            throw new NevalidanIznosException("Iznos mora biti veci ili jednak hiljadu.");
        }
    }
    
    public static boolean jeValidnaNaknada(Ugovor ugovor){
        return ugovor.naknadaAgenciji >= 1000;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getKlijentId() {
        return klijentId;
    }

    public void setKlijentId(int klijentId) {
        this.klijentId = klijentId;
    }

    public int getVlasnikId() {
        return vlasnikId;
    }

    public void setVlasnikId(int vlasnikId) {
        this.vlasnikId = vlasnikId;
    }

    @Override
    public String toString() {
        return "Ugovor{" + "ugovorId=" + ugovorId + ", datumNastanka=" + datumNastanka + ", datumIsteka=" + datumIsteka + ", iznos=" + iznos + ", naknadaAgenciji=" + naknadaAgenciji + ", redniBroj=" + redniBroj + ", klijentId=" + klijentId + ", vlasnikId=" + vlasnikId + '}';
    }

    

    
    
    
    
}
