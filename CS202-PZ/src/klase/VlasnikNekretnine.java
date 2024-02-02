/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klase;

import exceptions.NevalidanBrojGodinaException;
import exceptions.NevalidanTelefonException;

/**
 *
 * @author aleks
 */
public class VlasnikNekretnine {
    private int vlasnikId;
    private String adresa;
    private int godine;
    private String ime;
    private String telefon;
    private static final String SRPSKI_TELEFON_REGEX = "^\\+3816([0-5]|[9])[0-9]{7,8}$";

    public VlasnikNekretnine(int vlasnikId, String adresa, int godine, String ime, String telefon) throws NevalidanTelefonException, NevalidanBrojGodinaException {
        this.vlasnikId = vlasnikId;
        this.adresa = adresa;
        setGodine(godine);
        this.ime = ime;
        setTelefon(telefon);
    }

    public int getVlasnikId() {
        return vlasnikId;
    }

    public void setVlasnikId(int vlasnikId) {
        this.vlasnikId = vlasnikId;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) throws NevalidanBrojGodinaException {
        if(godine > 18){
            this.godine = godine;
        }else{
            throw new NevalidanBrojGodinaException("Broj godina mora biti veci od 18");
        }
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) throws NevalidanTelefonException {
        if (telefon.matches(SRPSKI_TELEFON_REGEX)){
            this.telefon = telefon;
        }else {
            throw new NevalidanTelefonException("Broj telefona nije validan");
        }
        
    }
    
    public static boolean jeValidanTelefonVlasnika(VlasnikNekretnine vlasnik){
        return vlasnik.telefon != null && vlasnik.telefon.matches(SRPSKI_TELEFON_REGEX);
    }

    @Override
    public String toString() {
        return "VlasnikNekretnine{" + "vlasnikId=" + vlasnikId + ", adresa=" + adresa + ", godine=" + godine + ", ime=" + ime + ", telefon=" + telefon + '}';
    }
    
    
}
