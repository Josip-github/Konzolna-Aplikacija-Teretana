package konzolnaAplikacija;

import java.util.ArrayList;
import java.util.List;

public class Start {

    private List<Smjer> smjerovi;
    private List<Polaznik> polaznici;
    private List<Clanarina> clanarine;
    private List<Zaposlenik> zaposlenici;

    public Start() {
        clanarine = new ArrayList<Clanarina>();
        smjerovi = new ArrayList<Smjer>();
        polaznici = new ArrayList<Polaznik>();
        zaposlenici = new ArrayList<Zaposlenik>();
        glavniIzbornik();
    }

    private void glavniIzbornik() {
        System.out.println("*** Teretana konzolna aplikacija ***");
        System.out.println(" Izbornik ");
        System.out.println(" 1. Smjerovi ");
        System.out.println(" 2. Polaznici ");
        System.out.println(" 3. Članarine ");
        System.out.println(" 4. Zaposlenici ");
        System.out.println(" 5. Izlaz iz programa ");
        ucitajGlavnuAkciju();
    }

    private void ucitajGlavnuAkciju() {
        switch (Ulaz.ucitajInt("Odaberite stavku", "Greška unosa. Niste unijeli cijeli broj.", 1, 5)) {
            case 1 -> smjerIzbornik();
            case 2 -> polaznikIzbornik();
            case 3 -> clanarinaIzbornik();
            case 4 -> zaposlenikIzbornik();
            case 5 -> System.out.println("Program je završio, doviđenja!");
        }
    }

    private void zaposlenikIzbornik() {
        System.out.println(" \nPodizbornik 4. Zaposlenici ");
        System.out.println(" Odaberite akciju: ");
        System.out.println(" 1. Pregled unesenih zaposlenika ");
        System.out.println(" 2. Unos novog zaposlenika ");
        System.out.println(" 3. Promjena postojeceg zaposlenika ");
        System.out.println(" 4. brisanje zaposlenika ");
        System.out.println(" 5. Povratak u prethodni izbornik ");
        zaposlenikUcitajAkciju();
    }

    private void zaposlenikUcitajAkciju() {
        switch (Ulaz.ucitajInt("Odaberite akciju", "Neispravan unos. Unos mora biti cijeli broj", 1, 5)) {
            case 1 -> zaposlenikPregled();
            case 2 -> zaposlenikUnosNovog();
            case 3 -> zaposlenikPromjenaPostojeceg();
            case 4 -> zaposlenikBrisanje();
            case 5 -> glavniIzbornik();
        }

    }

    private void zaposlenikPregled() {
        zaposlenikStavke("\nTrenutno dostupno u aplikaciji");
        zaposlenikIzbornik();
    }

    private void zaposlenikStavke(String naslov) {
        System.out.println(naslov);
        if (zaposlenici.isEmpty()) {
            System.out.println("Nema unesenih zaposlenika");
        } else {
            Zaposlenik z;
            for (int i = 0; i < zaposlenici.size(); i++) {
                z = zaposlenici.get(i);
                System.out.println((i + 1) + ". " + z.getIme() + " " + z.getPrezime());
            }
        }
    }

    private void zaposlenikUnosNovog() {
        Zaposlenik z = new Zaposlenik();
        z = zaposlenikPostaviVrijednosti(z);
        zaposlenici.add(z);
        zaposlenikIzbornik();
    }

    private Zaposlenik zaposlenikPostaviVrijednosti(Zaposlenik z) {
        z.setSifra(Ulaz.ucitajInt("Unesite šifru zaposlenik", "Neispravan unos. Unos mora biti cijeli broj.", 1,
                Integer.MAX_VALUE));
        z.setIme(Ulaz.ucitajString("Unesite ime zaposlenika", "Neispravan unos"));
        z.setPrezime(Ulaz.ucitajString("Unesite prezime zaposlenika", "Neispravan unos"));
        z.setOib(Ulaz.ucitajString("Unesite OIB zaposlenika", "Neispravan unos"));
        z.setEmail(Ulaz.ucitajString("Unesite email zaposlenika", "Neispravan unos"));
        z.setIban(Ulaz.ucitajString("Unesite iban zaposlenika", "Neispravan unos"));
        return z;
    }

    private void zaposlenikPromjenaPostojeceg() {
        zaposlenikStavke("\nTrenutno dostupno u aplikaciji");
        int redniBroj = Ulaz.ucitajInt("Odaberite redni broj zaposlenika kojeg zelite promijeniti",
                "Neispravan unos. Unos mora biti cijeli broj.", 1, zaposlenici.size());
        Zaposlenik zaposlenikZaPromjenu = zaposlenici.get(redniBroj - 1);
        zaposlenikZaPromjenu = zaposlenikPostaviVrijednosti(zaposlenikZaPromjenu);
        zaposlenici.set(redniBroj - 1, zaposlenikZaPromjenu);
        zaposlenikIzbornik();
    }

    private void zaposlenikBrisanje() {
        zaposlenikStavke("\nTrenutno dostupno u aplikaciji");
        int redniBroj = Ulaz.ucitajInt("Odaberite redni broj zaposlenika kojeg želite izbrisati",
                "Neispravan unos. Unos mora biti cijeli broj.", 1, zaposlenici.size());
        zaposlenici.remove(redniBroj - 1);
        zaposlenikIzbornik();
    }

    /*
     * OVDJE ZAVRŠAVAJU ZAPOSLENICI
     *
     *
     * OVDJE POCINJU CLANARINE
     */

    private void clanarinaIzbornik() {
        System.out.println(" \nPodizbornik 3. Članarine ");
        System.out.println(" Odaberite akciju: ");
        System.out.println(" 1. Pregled unesenih članarina ");
        System.out.println(" 2. Unos nove članarine ");
        System.out.println(" 3. Promjena postojece članarine ");
        System.out.println(" 4. Brisanje članarine ");
        System.out.println(" 5. Povratak u prethodni izbornik ");
        clanarinaUcitajAkciju();
    }

    private void clanarinaUcitajAkciju() {
        switch (Ulaz.ucitajInt("Odaberite akciju", "Neispravan unos. Unos mora biti cijeli broj", 1, 5)) {
            case 1 -> {
                clanarinaPregled();
                clanarinaIzbornik();
            }
            case 2 -> clanarinaUnosNove();
            case 3 -> clanarinaPromjenaPostojece();
            case 4 -> clanarinaBrisanje();
            case 5 -> glavniIzbornik();
        }

    }

    private void clanarinaPregled() {
        clanarinaStavke("\nTrenutno dostupno u aplikaciji");
        System.out.println("-------");
    }

    private void clanarinaStavke(String naslov) {
        System.out.println(naslov);
        if (clanarine.isEmpty()) {
            System.out.println("Nema unesenih članarina");
        } else {
            Clanarina c;
            for (int i = 0; i < clanarine.size(); i++) {
                c = clanarine.get(i);
                System.out.println((i + 1) + ". " + "- " + c.getPolaznik().getIme() + ", " + c.getSmjer().getNaziv()
                        + ", " + c.getDatumPocetka() + ", uplaćeno: " + c.isUplata());
            }
        }
    }

    private void clanarinaUnosNove() {
        Clanarina c = new Clanarina();
        c = clanarinaPostaviVrijednosti(c);
        clanarine.add(c);
        clanarinaIzbornik();
    }

    private Clanarina clanarinaPostaviVrijednosti(Clanarina c) {
        c.setSifra(Ulaz.ucitajInt("Unesite šifru članarine", "Neispravan unos. Unos mora biti cijeli broj.", 1,
                Integer.MAX_VALUE));

        polaznikPregled();
        System.out.println("Odaberite polaznika");
        c.setPolaznik(polaznici.get(Ulaz.ucitajInt("Odaberite polaznika",
                "Neispravan unos. Morate unijeti cijeli broj.", 1, polaznici.size()) - 1));

        smjerPregled();
        System.out.println("Odaberite redni broj smjera");
        c.setSmjer(smjerovi.get(Ulaz.ucitajInt("Odaberite redni broj smjera",
                "Neispravan unos. Morate unijeti cijeli broj.", 1, smjerovi.size()) - 1));

        c.setDatumPocetka(Ulaz.ucitajDatum("Unesite datum od kad vrijedi članarina."));
        c.setUplata(Ulaz.ucitajBoolean("Je li polaznik uplatio članarinu", "Neispravan unos."));

        return c;
    }

    private void clanarinaPromjenaPostojece() {
        clanarinaStavke("Trenutno dostupno u aplikaciji");
        int redniBroj = Ulaz.ucitajInt("Odaberite redni broj članarine koju želite promijeniti",
                "Neispravan unos. Morate unijeti cijeli broj", 1, clanarine.size());
        Clanarina clanarinaZaPromjenu = clanarine.get(redniBroj - 1);
        clanarinaZaPromjenu = clanarinaPostaviVrijednosti(clanarinaZaPromjenu);
        clanarine.set(redniBroj - 1, clanarinaZaPromjenu);
        clanarinaIzbornik();
    }

    private void clanarinaBrisanje() {
        clanarinaStavke("Trenutno dostupno u aplikaciji");
        int redniBroj = Ulaz.ucitajInt("Odaberite redni broj članarine koju želite promijeniti",
                "Neispravan unos. Morate unijeti cijeli broj", 1, clanarine.size());
        clanarine.remove(redniBroj - 1);
        clanarinaIzbornik();
    }

    /*
     * OVDJE ZAVRŠAVAJU CLANARINE
     *
     *
     *
     * OVDJE POČINJU POLAZNICI
     */

    private void polaznikIzbornik() {
        System.out.println(" \nPodizbornik 2. Polaznici ");
        System.out.println(" Odaberite akciju: ");
        System.out.println(" 1. Pregled unesenih polaznika ");
        System.out.println(" 2. Unos novog polaznika ");
        System.out.println(" 3. Promjena postojeceg polaznika ");
        System.out.println(" 4. Brisanje polaznika ");
        System.out.println(" 5. Povratak u prethodni izbornik ");
        polaznikUcitajAkciju();
    }

    private void polaznikUcitajAkciju() {
        switch (Ulaz.ucitajInt("Odaberite stavku", "Greška unosa. Niste unijeli cijeli broj.", 1, 5)) {
            case 1 -> {
                polaznikPregled();
                polaznikIzbornik();
            }
            case 2 -> polaznikUnosNovog();
            case 3 -> polaznikPromjenaPostojeceg();
            case 4 -> polaznikBrisanje();
            case 5 -> glavniIzbornik();
        }
    }

    private void polaznikPregled() {
        polaznikStavke("\nPregled unesenih polaznika");
        System.out.println("-------");
    }

    private void polaznikStavke(String naslov) {
        System.out.println(naslov);
        System.out.println("-------");
        if (polaznici.isEmpty()) {
            System.out.println("Nema unesenih polaznika.");
        } else {
            Polaznik p;
            for (int i = 0; i < polaznici.size(); i++) {
                p = polaznici.get(i);
                System.out.println((i + 1) + ". " + p.getIme() + " " + p.getPrezime());
            }
        }
    }

    private void polaznikUnosNovog() {
        Polaznik p = new Polaznik();
        p = polaznikPostaviVrijednosti(p);
        polaznici.add(p);
        polaznikIzbornik();
    }

    private Polaznik polaznikPostaviVrijednosti(Polaznik p) {
        p.setSifra(Ulaz.ucitajInt("Unesite šifru polaznika", "Neispravan unos. Šifra mora biti cijeli broj", 1,
                Integer.MAX_VALUE));
        p.setIme(Ulaz.ucitajString("Unesite ime polaznika", "Neispravan unos. Ponovite"));
        p.setPrezime(Ulaz.ucitajString("Unesite prezime polaznika", "Neispravan unos. Ponovite"));
        p.setOib(Ulaz.ucitajString("Unesite oib polaznika", "Neispravan unos. Ponovite"));
        p.setEmail(Ulaz.ucitajString("Unesite email polaznika", "Neispravan unos. Ponovite"));
        return p;
    }

    private void polaznikPromjenaPostojeceg() {
        polaznikStavke("Trenutno dostupno u aplikaciji");
        int redniBroj = Ulaz.ucitajInt("Odaberite broj polaznika kojeg želite promijeniti",
                "Neispravan unos. Unos mora biti cijeli broj.", 1, polaznici.size());
        Polaznik polaznikZaPromjenu = polaznici.get(redniBroj - 1);
        polaznikZaPromjenu = polaznikPostaviVrijednosti(polaznikZaPromjenu);
        polaznici.set(redniBroj - 1, polaznikZaPromjenu);
        polaznikIzbornik();
    }

    private void polaznikBrisanje() {
        polaznikStavke("Trenutno dostupno u aplikaciji");
        int redniBroj = Ulaz.ucitajInt("Odaberite broj polaznika kojeg želite izbrisati",
                "Neispravan unos. Unos mora biti cijeli broj.", 1, polaznici.size());
        polaznici.remove(redniBroj - 1);
        polaznikIzbornik();

    }

    /*
     * OVDJE ZAVRŠAVAJU POLAZNICI
     *
     *
     * OVDJE POČINJU SMJEROVI
     */

    private void smjerIzbornik() {
        System.out.println(" \nPodizbornik 1: Smjerovi ");
        System.out.println(" Odaberite akciju: ");
        System.out.println(" 1. Pregled unesenih smjerova ");
        System.out.println(" 2. Unos novog smjera ");
        System.out.println(" 3. Promjena postojeceg smjera ");
        System.out.println(" 4. Brisanje smjera ");
        System.out.println(" 5. Povratak u prethodni izbornik ");
        smjerUcitajAkciju();
    }

    private void smjerUcitajAkciju() {
        switch (Ulaz.ucitajInt("Odaberite stavku", "Greška unosa. Niste unijeli cijeli broj.", 1, 5)) {
            case 1 -> {
                smjerPregled();
                smjerIzbornik();
            }
            case 2 -> smjerUnosNovog();
            case 3 -> smjerPromjena();
            case 4 -> smjerBrisanje();
            case 5 -> glavniIzbornik();
        }

    }

    private void smjerPregled() {
        smjerStavke("\nPregled unesenih smjerova");
        System.out.println("-------");

    }

    private void smjerStavke(String naslov) {
        System.out.println(naslov);
        System.out.println("--------");
        if (smjerovi.size() == 0) {
            System.out.println("Nema unesenih smjerova");
        } else {
            Smjer s;
            for (int i = 0; i < smjerovi.size(); i++) {
                s = smjerovi.get(i);
                System.out.println((i + 1) + ". " + s.getNaziv());
            }
        }
    }

    private void smjerUnosNovog() {
        Smjer s = new Smjer();
        s = smjerPostaviVrijednosti(s);
        smjerovi.add(s);
        smjerIzbornik();
    }

    private Smjer smjerPostaviVrijednosti(Smjer s) {
        s.setSifra(
                Ulaz.ucitajInt("Unesite šifru", "Neispravan unos. Šifra mora biti cijeli broj", 1, Integer.MAX_VALUE));
        s.setNaziv(Ulaz.ucitajString("Unesite naziv smjera", "Neispravan unos. Ponovite."));
        s.setCijena(Ulaz.ucitajDouble("Postavite cijenu smjera", "Neispravan unos", 0, Double.MAX_VALUE));
        s.setTrajanje(Ulaz.ucitajInt("Unesite trajanje smjera", "Neispravan unos.", 1, 200));
        return s;
    }

    private void smjerPromjena() {
        smjerStavke(" trenutno dostupno u aplikaciji ");
        int redniBroj = Ulaz.ucitajInt("Odaberite redni broj za promjenu", "Niste unijeli cijeli broj", 1,
                smjerovi.size());
        Smjer smjerZaPromjenu = smjerovi.get(redniBroj - 1);
        smjerZaPromjenu = smjerPostaviVrijednosti(smjerZaPromjenu);
        smjerovi.set(redniBroj - 1, smjerZaPromjenu);
        smjerIzbornik();
    }

    private void smjerBrisanje() {
        smjerStavke(" trenutno dostupno u aplikaciji ");
        int redniBroj = Ulaz.ucitajInt("Odaberite redni broj smjera koji želite izbrisati", "Neispravan unos", 1,
                smjerovi.size());
        smjerovi.remove(redniBroj - 1);
        smjerIzbornik();
    }

    /*
     *
     * OVDJE ZAVRŠAVAJU SMJEROVI
     *
     */

    public static void main(String[] args) {

        new Start();
    }
}
