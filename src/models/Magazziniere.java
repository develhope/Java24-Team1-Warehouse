package models;

import java.io.Serializable;

public class Magazziniere extends Utente implements Serializable {
    public Magazziniere (String nomeUtente, String password) {
        this.nomeUtente = nomeUtente;
        this.password = password;
    }
}
