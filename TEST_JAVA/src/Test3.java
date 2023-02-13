public class Test3 {
    public static void main(String[] args) {
        //3. Kreirati dva niza brojeva
//Proveriti da li je suma parnih brojeva veca od sume neparnih brojeva u odnosu na drugi niz

        int niz[] = {3,14,25,100,50};
        int niz2[] = {3,34,39,63,2};
        int suma = 0;
        //ispitujemo koji su to parni brojevi u listi
        for(int i = 0; i<niz.length; i++){
            if(niz[i]%2==0){
                suma = suma +niz[i];
              //  System.out.println(suma);   //provera da li stampa dobru sumu

            }
        }
        System.out.println("Suma parnih brojeva prvog niza je " + suma);

        int suma2 = 0;
        //ispitujemo koji su to neparni brojevi u listi
        for(int i=0; i< niz2.length; i++){
            if(niz2[i]%2!=0){
                suma2 = suma2 + niz2[i];
            }

        }
        System.out.println("Suma neparnih brojeva drugog niza je " + suma2);

        if(suma>suma2){
            System.out.println("Veca je suma prvog niza");
        }

        else{
            System.out.println("Suma drugog niza je veca");
        }

























    }
}
