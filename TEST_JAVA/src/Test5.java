import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
//5. Napisati program koji racuna potrosnju goriva. Korisnik unosi distancu, tip vozila i tip goriva,
//a program ispisuje koliko ce goriva biti potroseno i koja je ukupna cena.
//Motor trosi 5 litara na 100 km
//Automobil trosi 9 litara na 100 km
//Kamion trosi 15 litara na 100 km
//Tipovi goriva su:
//Benzin kosta 195 dinara po litru
//Dizel kosta 220 dinara po litru
//Zadatak raditi kroz switch i pokriti samo happy flow uz default

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite distancu: ");
        int distanca = sc.nextInt();
        System.out.println("Unesite tip vozila: ");
        String vozilo = sc.next();
        System.out.println("Unesite tip goriva: ");
        String gorivo = sc.next();

        int cena = 0;
        int potrosnja;

    switch(gorivo){
        case "benzin":
             cena = 195;
             break;

        case"dizel":
            cena = 220;
    }
    switch(vozilo) {
        case "motor":                 //5 litara na 100 km //5/100

            potrosnja = distanca * cena * 5 /100;
            System.out.println(potrosnja);
            System.out.println("Potrosnja goriva je: " + potrosnja);
            break;

        case "automobil":      //9 litara na 100 km
            potrosnja = distanca * cena *  9/100;
            System.out.println(potrosnja);
            break;


        case "kamion":
            potrosnja = distanca * cena * 15/100;
            System.out.println(potrosnja);
            break;

        default:
            System.out.println("Pogresan unos");

    }











    }
}
