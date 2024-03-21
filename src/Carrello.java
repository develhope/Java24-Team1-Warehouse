import java.util.ArrayList;

public class Carrello {
    private ArrayList<Prodotto> prodottiNelCarrello = new ArrayList<>();

    public void aggiungiProdottoAlCarrello(int id, Magazzino magazzino){
        Prodotto prodottoDaAggiungere = magazzino.cercaProdottoPerId(id);
        prodottiNelCarrello.add(prodottoDaAggiungere);
        magazzino.rimuoviProdotto(prodottoDaAggiungere);

    }
    public void rimuoviProdottoDalCarrello(int id, Magazzino magazzino){
        Prodotto prodottoDaRimuovere = magazzino.cercaProdottoPerId(id);
        prodottiNelCarrello.remove(prodottoDaRimuovere);
        magazzino.aggiungiProdotto(prodottoDaRimuovere);

    }
    public void finalizzaAcquisto(){
        prodottiNelCarrello.clear();
    }
    public double prezzoTotaleCarrello(){
        double totale = 0;
        for(int i = 0; i < prodottiNelCarrello.size(); i++){
            totale += prodottiNelCarrello.get(i).getPrezzoVendita();

    }
        return totale;

    }
}