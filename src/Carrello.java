import java.util.ArrayList;

public class Carrello {
    private ArrayList<Prodotto> prodottiNelCarrello = new ArrayList<>();

    public void aggiungiProdottoAlCarrello(int id, Magazzino magazzino){
        Prodotto prodottoDaAggiungere = magazzino.cercaProdottoPerId(id);
        if(!prodottoDaAggiungere.getTipoProdotto().equalsIgnoreCase("Inesistente")){
            prodottiNelCarrello.add(prodottoDaAggiungere);
            magazzino.rimuoviProdotto(prodottoDaAggiungere);
        }else{
            System.out.println("Prodotto non trovato");
        }
    }
    public void rimuoviProdottoDalCarrello(int id, Magazzino magazzino){
        Prodotto prodottoDaRimuovere = magazzino.cercaProdottoPerId(id);
        if(!prodottoDaRimuovere.getTipoProdotto().equalsIgnoreCase("Inesistente")){
            prodottiNelCarrello.remove(prodottoDaRimuovere);
            magazzino.aggiungiProdotto(prodottoDaRimuovere);
        }else {
            System.out.println("Prodotto non trovato");}
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