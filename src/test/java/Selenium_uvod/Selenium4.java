package Selenium_uvod;

public class Selenium4 {
    public static void main(String[] args) {

     /*
     Lokatori:

        Prvo trazimo "id" medju lokatorima zato sto je jedinstven element i nije sklon pomenama
        (u idealnom sistemu)
        Ako nemamo "id" trazimo onda "name"
        Za slucaj da nemamo ni "id" ni "name" onda tek prelazimo na "class" ali obavezno treba proveriti
        da li je element jedinstven tako sto se kopira vrednost klase i ubaci u pretragu (CTRL + F).
         Program ce naci cesto mnogo resenja ali ne znaci da element nije jedinstven.
        Na primer:
        "...
        for="string"
        class="string"
..."
        ovde ce pronaci dva elementa ali ako trazite preko class onda je jedinstven
        8:22
        Ako klasa koju trazite ima vrednost za vise stringova u sebi onda:
        Promenite iz By.ClassName u By.CssSelector
        Obrisete razmake i stavite tacku na njihovo mesto
        Stavite tacku na pocetak vrednosti
        Na primer:
        class = "jedan dva tri"
        onda ne mozete naci kao
        By.ClassName("jedan dva tri");
        nego morate
        By.CssSelector(".jedan.dva.tri");


Thread.sleep(2000);
Morace da se doda exception za ovo cekanje tako sto kliknete na "sleep" i kliknete ALT + ENTER
Videcete u produzetku metode da se dodao exception
U zagradi se pisu milisekunde. Ako hocete da sacekate 2 sekunde onda 2000, ako hocete 5 onda 5000




      */
    }
}
