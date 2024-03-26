package models;

import java.io.Serializable;
import java.util.Scanner;

public class Cliente extends Utente implements Serializable {
    private Carrello carrello = new Carrello();

    public Cliente (String nomeUtente, String password) {
        this.nomeUtente = nomeUtente;
        this.password = password;
    }



    public void  aggiungiAlCarrello(Prodotto prodotto) {
        this.carrello.aggiungiProdottoAlCarrello(prodotto);
    }

    public void rimuoviDalCarrello(Prodotto prodotto) {
        this.carrello.rimuoviProdottoDalCarrello(prodotto);
    }

    public void mostraCarrello() {
        this.carrello.mostraCarrello();
    }

    public void finalizzaAcquisto() {
        this.carrello.finalizzaAcquisto();
    }
    public Prodotto cercaProdotto(int id) {
        return this.carrello.cercaNelCarrello(id);
    }

    public double prezzoFinale() {
        return this.carrello.prezzoTotaleCarrello();
    }

    public boolean isEmpty() {
        return this.carrello.isEmpty();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeUtente='" + nomeUtente + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
