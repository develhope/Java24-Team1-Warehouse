package models;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginClienti implements Serializable {

    private ArrayList<Cliente> magazzinieri = new ArrayList<>();

    public void aggiungiClienti(Cliente cliente) {
        this.magazzinieri.add(cliente);
    }

    public ArrayList<Cliente> getClienti() {
        return magazzinieri;
    }
}
