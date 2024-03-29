import java.util.ArrayList;

public class Magazzino {
    private ArrayList<Prodotto> magazzino = new ArrayList<Prodotto>();
    public void aggiungiProdotto(Prodotto prodottoDaAggiungere){
        this.magazzino.add(prodottoDaAggiungere);
    }
    public void rimuoviProdotto(int id){
        Prodotto prodottoTemp=cercaProdottoPerId(id);
        if(!prodottoTemp.getTipoProdotto().equalsIgnoreCase("inesistente")){
            this.magazzino.remove(prodottoTemp);
        }else{
            System.out.println("Non è stato trovato nessun prodotto da eliminare");
        }
    }
    public Prodotto cercaProdottoPerId(int id){
        Prodotto prodottoNull = new Prodotto("inesistente");
        for(Prodotto prodotto:this.magazzino){
            if (prodotto.getId() == id) {
                System.out.println(prodotto);
                return prodotto;
            }
        }
        return prodottoNull;
    }
    public void cercaProdottoPerModello(String modello){
        int counter=0;
        for(Prodotto prodotto:this.magazzino){
            if (prodotto.getModello().equalsIgnoreCase(modello)) {
                System.out.println(prodotto);
                counter ++;
            }
        }
        if(counter == 0){
            System.out.println("Nessun prodotto trovato");
        }
    }
    public void cercaProdottoPerTipo(String tipoDispositivo){
        int counter=0;
        for(Prodotto prodotto:this.magazzino){
            if (prodotto.getTipoProdotto().equalsIgnoreCase(tipoDispositivo)) {
                System.out.println(prodotto);
                counter ++;
            }
        }
        if(counter == 0){
            System.out.println("Nessun prodotto trovato");
        }
    }
    public void cercaProdottoPerProduttore(String produttore){
        int counter=0;
        for(Prodotto prodotto:this.magazzino){
            if (prodotto.getProduttore().equalsIgnoreCase(produttore)) {
                System.out.println(prodotto);
                counter ++;
            }
        }
        if(counter == 0){
            System.out.println("Nessun prodotto trovato");
        }
    }
    public void cercaProdottoPerPrezzoVendita(double prezzoVendita){
        int counter=0;
        for(Prodotto prodotto:this.magazzino){
            if (prodotto.getPrezzoVendita() == prezzoVendita) {
                System.out.println(prodotto);
                counter ++;
            }
        }
        if(counter == 0){
            System.out.println("Nessun prodotto trovato");
        }
    }
    public void cercaProdottoPerPrezzoAcquito(double prezzoAcquito){
        int counter=0;
        for(Prodotto prodotto:this.magazzino){
            if (prodotto.getPrezzoAcquisto() == prezzoAcquito) {
                System.out.println(prodotto);
                counter ++;
            }
        }
        if(counter == 0){
            System.out.println("Nessun prodotto trovato");
        }
    }
    public void cercaProdottoPerRangePrezzo(double prezzoInferiore, double prezzoMaggiore){
        int counter=0;
        for(Prodotto prodotto:this.magazzino){
            if (prodotto.getPrezzoVendita() > prezzoInferiore && prodotto.getPrezzoVendita() < prezzoMaggiore) {
                System.out.println(prodotto);
                counter ++;
            }
        }
        if(counter == 0){
            System.out.println("Nessun prodotto trovato");
        }
    }
    public void mediaPrezzoAcquisto(){
        double prezzoAcquistoTotale = 0;
        for (Prodotto prodotto:magazzino){
            prezzoAcquistoTotale += prodotto.getPrezzoAcquisto();
        }
        double mediaPrezzoAcquisto = prezzoAcquistoTotale/magazzino.size();
    }
    public void stampaMagazzino(){
        for (Prodotto prodotto:this.magazzino){
            System.out.println(prodotto);
        }
    }
}
