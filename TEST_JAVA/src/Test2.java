import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {

//2. Napraviti program koji nalazi najveci broj u listi
// i vraca informaciju da li je taj najveci broj paran

        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(2);
        lista.add(8);
        lista.add(142);
        lista.add(71);
        lista.add(103);

        //   System.out.println(lista); proveravamo da li su uneti  clanovi liste
        int i = 0;
        //Prvom clanu dodeljujemo maksimalnu vrednost i onda ga poredimo sa sledecim
        int max = lista.get(i);
        for (i = 0; i < lista.size(); i++) {
            if(lista.get(i)>max){
                max = lista.get(i);
            }
        }
        System.out.print("Maksimalan broj je " + max);
        if(max%2==0){
            System.out.print(" i paran je");
        }                                               //provera za parne i neparne unose je uradjena
        else{
            System.out.print(" i neparan je");
        }

    }
}
