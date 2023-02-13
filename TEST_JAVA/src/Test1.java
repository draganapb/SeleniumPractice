import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {


//1. Napraviti program koji, koristeci DO WHILE petlju,
// racuna proizvod unetih brojeva sve dok korisnik ne unese 0.
// Na kraju ispisati koliki je proizvod samo ako je veci od 10




        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite brojeve");
        int broj = sc.nextInt();                //istestirano s pozitivnim i negativnim vrednostima
        int proizvod = 1;
        int i = 1;
        do{
             broj = sc.nextInt();
             proizvod = proizvod * broj;
             System.out.println(proizvod);

            i++;
            if(proizvod>10) System.out.println("Proizvod je " + proizvod);
        }

        while(broj!=0);
























    }
}
