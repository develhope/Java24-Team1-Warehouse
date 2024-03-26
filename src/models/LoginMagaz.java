package models;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginMagaz implements Serializable {
    private ArrayList<Magazziniere> magazzinieri = new ArrayList<>();

    public void aggiungiMagaz(Magazziniere magazziniere) {
        this.magazzinieri.add(magazziniere);
    }

    public ArrayList<Magazziniere> getMagazzinieri() {
        return magazzinieri;
    }
}
