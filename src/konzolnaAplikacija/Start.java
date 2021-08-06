package konzolnaAplikacija;

public class Start {

    public Start() {
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
            //case 1 -> smjerIzbornik();
            //case 2 -> polaznikIzbornik();
            //case 3 -> clanarinaIzbornik();
            //case 4 -> zaposlenikIzbornik();
            //case 5 -> System.out.println("Program je završio, doviđenja!");
        }

    }

    public static void main(String[] args) {

        new Start();
    }
}
