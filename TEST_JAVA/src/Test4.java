import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {

//4. Napraviti program koji racuna koliko puta se neki broj pojavljuje u nizu.
// Korisnik preko skenera unosi koji broj zeli da prebroji u nizu.


Scanner sc = new Scanner(System.in);
int niz[] = {0,4,8,10,0,0,4,0,4,9,4};
        System.out.println("Unesite broj: ");
        int broj = sc.nextInt();
        int brojac = 0;
                                     //treba da prodjemo kroz niz da vidimo da li se clan niza i unos podudaraju
        for(int i = 0; i< niz.length; i++){
            if(broj==niz[i]){
                brojac = brojac+1;        // //proveravamo na ovaj nacin koliko puta se unet broj pojavljuje u nizu
            }
        }

        System.out.println("Broj " + broj + " pojavljuje se " + brojac + " puta");





















    }
}
