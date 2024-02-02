/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klase;

/**
 *
 * @author aleks
 */
public class Dodatno {
    private int dodatnoId;
    private boolean grejanje;
    private boolean kablovska;
    private boolean klima;
    private boolean parkingMesto;
    private boolean terasa;

    public Dodatno(int dodatnoId, boolean grejanje, boolean kablovska, boolean klima, boolean parkingMesto, boolean terasa) {
        this.dodatnoId = dodatnoId;
        this.grejanje = grejanje;
        this.kablovska = kablovska;
        this.klima = klima;
        this.parkingMesto = parkingMesto;
        this.terasa = terasa;
    }

    public int getDodatnoId() {
        return dodatnoId;
    }

    public void setDodatnoId(int dodatnoId) {
        this.dodatnoId = dodatnoId;
    }

    public boolean isGrejanje() {
        return grejanje;
    }

    public void setGrejanje(boolean grejanje) {
        this.grejanje = grejanje;
    }

    public boolean isKablovska() {
        return kablovska;
    }

    public void setKablovska(boolean kablovska) {
        this.kablovska = kablovska;
    }

    public boolean isKlima() {
        return klima;
    }

    public void setKlima(boolean klima) {
        this.klima = klima;
    }

    public boolean isParkingMesto() {
        return parkingMesto;
    }

    public void setParkingMesto(boolean parkingMesto) {
        this.parkingMesto = parkingMesto;
    }

    public boolean isTerasa() {
        return terasa;
    }

    public void setTerasa(boolean terasa) {
        this.terasa = terasa;
    }

    @Override
    public String toString() {
        return "Dodatno{" + "dodatnoId=" + dodatnoId + ", grejanje=" + grejanje + ", kablovska=" + kablovska + ", klima=" + klima + ", parkingMesto=" + parkingMesto + ", terasa=" + terasa + '}';
    }
    
    
}
