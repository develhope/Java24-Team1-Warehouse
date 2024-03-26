package models;

public class Magazziniere extends Utente {

    public Magazziniere (String nomeUtente, String password) {

        this.nomeUtente = nomeUtente;
        this.password = password;
    }

    @Override
    public String getNomeUtente() {
        return super.getNomeUtente();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }
}
