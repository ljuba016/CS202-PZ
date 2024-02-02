/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klase;

import exceptions.NevalidanTelefonException;

/**
 *
 * @author aleks
 */
public class Klijent {
    private int klijentId;
    private String adresa;
    private String ime;
    private String telefon;
    private static final String SRPSKI_TELEFON_REGEX = "^\\+3816([0-5]|[9])[0-9]{7,8}$";

    public Klijent(int klijentId, String adresa, String ime, String telefon) throws NevalidanTelefonException {
        this.klijentId = klijentId;
        this.adresa = adresa;
        this.ime = ime;
        setTelefon(telefon);
    }

    public int getKlijentId() {
        return klijentId;
    }

    public void setKlijentId(int klijentId) {
        this.klijentId = klijentId;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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
    
    public static boolean jeValidanTelefonKlijenta(Klijent klijent){
        return klijent.telefon != null && klijent.telefon.matches(SRPSKI_TELEFON_REGEX);
    }

    @Override
    public String toString() {
        return "Klijent{" + "klijentId=" + klijentId + ", adresa=" + adresa + ", ime=" + ime + ", telefon=" + telefon + '}';
    }
    
    
}
