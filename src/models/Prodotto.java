package models;

public class Prodotto {
    private Integer id;
    private String tipoProdotto;
    private String produttore;
    private String modello;
    private float dimensioniDisplay;
    private float dimensioneMemoria;
    private double prezzoAcquisto;
    private double prezzoVendita;
    private String descrizione;

    public Prodotto(String tipoProdotto) {
        this.tipoProdotto = tipoProdotto;
    }

    public Prodotto(Integer id, String tipoProdotto, String produttore, String modello, float dimensioniDisplay,
                    float dimensioneMemoria, double prezzoAcquisto, double prezzoVendita, String descrizione) {
        this.id = id;
        this.tipoProdotto = tipoProdotto;
        this.produttore = produttore;
        this.modello = modello;
        this.dimensioniDisplay = dimensioniDisplay;
        this.dimensioneMemoria = dimensioneMemoria;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.descrizione = descrizione;
    }

    public int getId() {
        return id;
    }

    public String getTipoProdotto() {
        return tipoProdotto;
    }

    public String getProduttore() {
        return produttore;
    }

    public String getModello() {
        return modello;
    }

    public double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    @Override
    public String toString() {
        return "models.Prodotto{" +
                "id=" + id +
                ", tipoProdotto='" + tipoProdotto + '\'' +
                ", produttore='" + produttore + '\'' +
                ", modello='" + modello + '\'' +
                ", dimensioniDisplay=" + dimensioniDisplay +
                ", dimensioneMemoria=" + dimensioneMemoria +
                ", prezzoAcquisto=" + prezzoAcquisto +
                ", prezzoVendita=" + prezzoVendita +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
