package konzolnaAplikacija;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ulaz {


    public static final String FORMAT_DATUM = "dd.MM.yyyy";

    public static Date ucitajDatum(String poruka) {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATUM);
        while (true) {
            try {
                return df.parse(JOptionPane.showInputDialog(poruka));
            } catch (Exception e) {
                System.out.println("Neispravan format datuma. Primjer unosa: " + df.format(new Date()));
            }
        }
    }

    public static int ucitajInt(String poruka, String greska, int min, int max) {
        int broj = 0;
        while (true) {
            try {
                broj = Integer.parseInt(JOptionPane.showInputDialog(poruka));
                if (broj < min || broj > max) {
                    System.out.println("Broj ne smije biti manji od " + min + " i veći od " + max);
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println(greska);
            }
        }
        return broj;
    }

    public static String ucitajString(String poruka, String greska) {
        String s = "";
        while (true) {
            s = JOptionPane.showInputDialog(poruka);
            if (s.trim().equals("")) {
                System.out.println(greska);
                continue;
            }
            break;
        }
        return s;
    }

    public static double ucitajDouble(String poruka, String greska, double min, double max) {
        double broj = 0;
        while (true) {
            try {
                broj = Double.parseDouble(JOptionPane.showInputDialog(poruka));
                if (broj < min || broj > max) {
                    System.out.println("Broj ne smije biti manji od " + min + " i veći od " + max);
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println(greska);
            }
        }
        return broj;
    }

    public static boolean ucitajBoolean(String poruka, String greska) {
        String s;
        while (true) {
            s = JOptionPane.showInputDialog(poruka);
            if (s.trim().toLowerCase().equals("da")) {
                return true;
            }
            if (s.trim().toLowerCase().equals("ne")) {
                return false;
            }
            System.out.println("Neispravan unos. Morate unijeti \"da\" ili \"ne\".");
        }
    }

}
