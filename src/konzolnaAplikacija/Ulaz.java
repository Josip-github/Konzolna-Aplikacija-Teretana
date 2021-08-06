package konzolnaAplikacija;

import java.util.Scanner;

public class Ulaz {

    public static int ucitajInt(String poruka, String greska, int min, int max) {
        Scanner input = new Scanner(System.in);
        int broj = 0;
        while (true) {
            try {
                System.out.println(poruka);
                broj = input.nextInt();
                if (broj < min || broj > max) {
                    System.out.println("Broj ne smije biti manji od " + min + " i veći od " + max);
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println(greska);
            }
        }
        input.close();
        return broj;
    }
}
