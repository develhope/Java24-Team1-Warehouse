package models;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Utente implements Serializable {
    protected String nomeUtente;
    protected String password;

    public String getNomeUtente() {
        return nomeUtente;
    }

    public String getPassword() {
        return password;
    }
}
