package models;

import java.util.ArrayList;

public class Carrello {
    private ArrayList<Prodotto> prodottiNelCarrello = new ArrayList<>();

    public void aggiungiProdottoAlCarrello(Prodotto prodottoDaAggiungere) {
        this.prodottiNelCarrello.add(prodottoDaAggiungere);
        System.out.println(prodottoDaAggiungere.toString());
    }

    public void rimuoviProdottoDalCarrello(Prodotto prodottoDaRimuovere) {
        this.prodottiNelCarrello.remove(prodottoDaRimuovere);
    }

    public void finalizzaAcquisto() {
        prodottiNelCarrello.clear();
    }

    public double prezzoTotaleCarrello() {
        double totale = 0;
        for (int i = 0; i < prodottiNelCarrello.size(); i++) {
            totale += prodottiNelCarrello.get(i).getPrezzoVendita();

        }
        return totale;

    }

    public void mostraCarrello() {
        for (Prodotto prodotto : prodottiNelCarrello) {
            System.out.println(prodotto);
        }
    }

    public Prodotto cercaNelCarrello (int id) {
        for (Prodotto prodotto: this.prodottiNelCarrello) {
            if(prodotto.getId() == id) {
                return prodotto;
            }
        }
        return new Prodotto(null);
    }

    public boolean isEmpty() {
        if(this.prodottiNelCarrello.isEmpty()) {
            return true; //se è vuoto, ritorna vero...
        }
        return false; //... altrimenti false
    }
}