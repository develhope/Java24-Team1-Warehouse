import java.util.ArrayList;

public class Magazzino {
    ArrayList<Prodotto> magazzino = new ArrayList<Prodotto>();//l'oggetto magazzino vuoto verrà istanziato allo startup del programma
    public void aggiungiProdotto(Prodotto prodottoDaAggiungere){
        magazzino.add(prodottoDaAggiungere);//metodo richiamato nella classe magazziniere
    }
    public void rimuoviProdotto(Prodotto prodottoDaRimuovere){
        magazzino.remove(prodottoDaRimuovere);//quando nel carrello viene ultimata la vendita dovrà essere richiamato questo metodo per ogni articolo
    }
    public void cercaProdottoPerTipo(String tipoDispositivo){//cicla tutto il magazzino stampando solo i tipo di dispositivi cercati
        for(Prodotto prodotto:magazzino){
            if (prodotto.getTipoProdotto().equalsIgnoreCase(tipoDispositivo)) {
                System.out.println(prodotto);
            }
        }
    }
    public void cercaProdottoPerModello(String modello){//cicla tutto il magazzino stampando solo i modelli cercati
        for(Prodotto prodotto:magazzino){
            if (prodotto.getModello().equalsIgnoreCase(modello)) {
                System.out.println(prodotto);
            }
        }
    }
    public void stampaMagazzino(){
        for (Prodotto prodotto:magazzino){
            System.out.println(prodotto);
        }
    }
}
