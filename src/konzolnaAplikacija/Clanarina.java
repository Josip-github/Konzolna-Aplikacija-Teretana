package konzolnaAplikacija;

import java.util.Date;

public class Clanarina {

    private int sifra;
    private Smjer smjer;
    private Date datumPocetka;
    private boolean uplata;
    private Polaznik polaznik;

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public Smjer getSmjer() {
        return smjer;
    }

    public void setSmjer(Smjer smjer) {
        this.smjer = smjer;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public boolean isUplata() {
        return uplata;
    }

    public void setUplata(boolean uplata) {
        this.uplata = uplata;
    }
}
