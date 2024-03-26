package models;

import java.util.Scanner;

public abstract class Utente {
    protected String nomeUtente;
    protected String password;

    public String getNomeUtente() {
        return nomeUtente;
    }

    public String getPassword() {
        return password;
    }
}
