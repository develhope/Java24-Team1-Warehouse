import models.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cliente> clienti = new ArrayList<>();
        ArrayList<Magazziniere> magazzinieri = new ArrayList<>();

        clienti.add(new Cliente("giovanni", "password"));
        magazzinieri.add(new Magazziniere("giovanni2", "pss"));

        Magazzino magazzino = new Magazzino();
        magazzino.popolaMagazzino();


        Scanner scanner = new Scanner(System.in).useDelimiter("\n");


        Utente utenteGenerico = null;

        while (true) {
            clear();
            int isPres = 0;
            System.out.print("Inserisci nome utente già registrato -> ");
            String nomeUtente = scanner.nextLine().trim();

            for (Utente utenteCliente : clienti) {
                if (Objects.equals(utenteCliente.getNomeUtente(), nomeUtente)) {
                    isPres++;
                    utenteGenerico = utenteCliente;
                    while (true) {
                        System.out.print("Inserisci la password -> ");
                        String password = scanner.nextLine().trim();
                        if (!Objects.equals(password, utenteGenerico.getPassword())) {
                            System.out.println("Password errata!");
                            continue;
                        }
                        break;
                    }
                    break;
                }
            }

            if (isPres == 1) {
                break;
            }

            for (Utente utenteCliente : magazzinieri) {
                if (Objects.equals(utenteCliente.getNomeUtente(), nomeUtente)) {
                    isPres++;
                    utenteGenerico = utenteCliente;
                    while (true) {
                        System.out.print("Inserisci la password -> ");
                        String password = scanner.nextLine();
                        if (!Objects.equals(password, utenteGenerico.getPassword())) {
                            System.out.println("Password errata!");
                            continue;
                        }
                        break;
                    }
                    break;
                }
            }

            if (isPres == 1) {
                break;
            } else {
                System.out.println("Utente non trovato!");
            }
        }


        //CLIENTE
        if (utenteGenerico.getClass().toString().equals("class models.Cliente")) {

            Cliente cliente = new Cliente(utenteGenerico.getNomeUtente(), utenteGenerico.getPassword());


            int choice = 0;
            int id = 0;

            clear();
            while (true) {
                System.out.println("*************** BENVENUTI SU AMAZON BY FIERA ***************" + "\n" +
                        "[1] AGGIUNGI PRODOTTO AL CARRELLO" + "\n" +
                        "[2] RUMUOVI PRODOTTO DAL CARRELLO" + "\n" +
                        "[3] MOSTRA PRODOTTI PRESENTI IN CARRELLO" + "\n" +
                        "[4] FINALIZZA SPESA" + "\n" +
                        "[5] ESCI DAL MAGAZZINO" + "\n" +

                        "Inserire un numero corrispondente all'azione -> "
                );

                try {
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            clear();
                            if (magazzino.isEmpty()) {
                                System.out.print("Magazzino vuoto. PREMERE PER CONTINUARE ");
                                scanner.next();
                                clear();
                                break;
                            }

                            System.out.println("PRODOTTI ATTUALMENTE IN MAGAZZINO: ");
                            magazzino.stampaMagazzino();
                            System.out.println("\n\n");
                            System.out.println("Che prodotto vuoi aggiungere al carrello? (inserire id prodotto da aggiungere) -> ");
                            id = scanner.nextInt();
                            if (Objects.equals(magazzino.cercaProdottoPerId(id).getTipoProdotto(), "inesistente")) {
                                System.out.print("NESSUN PRODOTTO CORRISPONDENTE! PREMERE INVIO PER CONTINUARE!");
                                scanner.next();
                                clear();
                                break;
                            }
                            Prodotto prodottoDaAggiungere = magazzino.cercaProdottoPerId(id);
                            cliente.aggiungiAlCarrello(prodottoDaAggiungere);
                            magazzino.rimuoviProdotto(id);
                            clear();
                            break;
                        case 2:
                            clear();
                            if (cliente.isEmpty()) {
                                System.out.print("Carrello vuoto. PREMERE INVIO PER CONTINUARE: ");
                                scanner.next();
                                clear();
                                break;
                            }

                            cliente.mostraCarrello();
                            System.out.print("Che prodotto vuoi rimuovere dal carrello? (inserire id prodotto da aggiungere) -> ");
                            id = scanner.nextInt();
                            if (cliente.cercaProdotto(id).getTipoProdotto() == null) {
                                System.out.print("NESSUN PRODOTTO CORRISPOINDENTE NEL CARRELLO. PREMERE INVIO PER CONTINUARE ");
                                scanner.next();
                                clear();
                                break;
                            }
                            Prodotto prodotto = cliente.cercaProdotto(id);
                            magazzino.aggiungiProdotto(prodotto);
                            cliente.rimuoviDalCarrello(prodotto);
                            clear();
                            break;
                        case 3:
                            clear();
                            if (cliente.isEmpty()) {
                                System.out.print("Nulla da mostrare nel carrello. PREMERE INVIO PER CONTINUARE: ");
                                scanner.next();
                                clear();
                                break;
                            }
                            System.out.println("**** PRODOTTI NEL CARRELLO ****");
                            cliente.mostraCarrello();
                            System.out.println("*******************************\n\n");
                            System.out.print("PREMERE INVIO PER CONTINUARE: ");
                            scanner.next();
                            clear();
                            break;
                        case 4:
                            clear();
                            if (cliente.isEmpty()) {
                                System.out.print("Il carrello è ancora vuoto. PREMERE INVIO PER CONTINUARE: ");
                                scanner.next();
                                clear();
                                break;
                            }

                            System.out.println("Il prezzo finale è: " + cliente.prezzoFinale() + ". PREMERE INVIO PER CONTINUARE: ");
                            cliente.finalizzaAcquisto();
                            scanner.next();
                            clear();
                            break;
                        case 5:
                            System.exit(0);
                    }

                } catch (Exception e) {
                    System.out.println("INSERIRE UN'OPZIONE VALIDA!");
                    scanner.next();
                }
            }
        }


        //MAGAZZINIERE
        if (utenteGenerico.getClass().toString().equals("class models.Magazziniere")) {
            clear();
            while (true) {
                Magazziniere magazziniere = new Magazziniere(utenteGenerico.getNomeUtente(), utenteGenerico.getPassword());

                System.out.print("*************** BENVENUTO IN GESTIONE MAGAZZINO ***************" + "\n" +
                        "[1] AGGIUNGI PRODOTTO AL MAGAZZINO" + "\n" +
                        "[2] RUMUOVI PRODOTTO DAL MAGAZZINO" + "\n" +
                        "[3] MOSTRA PRODOTTI PRESENTI IN MAGAZZINO" + "\n" +
                        "[4] CERCA PRODOTTI IN MAGAZZINO" + "\n" +
                        "[5] ESCI DAL MAGAZZINO" + "\n" +

                        "Inserire un numero corrispondente all'azione -> "
                );


                try {
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            clear();
                            int id = 0;
                            String tipoProdotto;
                            String produttore;
                            String modello;
                            float dimensioneDisplay;
                            float dimensioneMemoria;
                            float prezzoAcquisto;
                            float prezzoVendita;
                            String descrizione;

                            while (true) {
                                System.out.print("ID prodotto: ");
                                try {
                                    id = scanner.nextInt();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire un ID valido");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("Tipo di prodotto: ");
                                try {
                                    tipoProdotto = scanner.next().trim();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire un TIPO DI PRODOTTO valido");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("Produttore: ");
                                try {
                                    produttore = scanner.next().trim();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire un PRODUTTORE valido");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("Modello: ");
                                try {
                                    modello = scanner.next().trim();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire un MODELLO valido");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("Dimensione display: ");
                                try {
                                    dimensioneDisplay = scanner.nextFloat();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire una DIMENSIONE DISPLAY valida");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("Dimensione memoria: ");
                                try {
                                    dimensioneMemoria = scanner.nextFloat();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire una DIMENSIONE MEMORIA valido");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("Prezzo di acquisto: ");
                                try {
                                    prezzoAcquisto = scanner.nextFloat();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire un PREZZO DI ACQUISTO valido");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("Prezzo di vendita: ");
                                try {
                                    prezzoVendita = scanner.nextFloat();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire un PREZZO DI VENDITA valido");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("DESCRIZIONE: ");
                                try {
                                    descrizione = scanner.next().trim();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire una DESCRIZIONE valida");
                                    scanner.next();
                                }
                            }

                            Prodotto prodotto = new Prodotto(id, tipoProdotto, produttore, modello, dimensioneDisplay, dimensioneMemoria, prezzoAcquisto, prezzoVendita, descrizione);
                            magazzino.aggiungiProdotto(prodotto);
                            clear();
                            break;

                        case 2:
                            clear();
                            if (magazzino.isEmpty()) {
                                System.out.print("IL MAGAZZINO é VUOTO! PREMI INVIO PER CONTINUARE");
                                scanner.next();
                                clear();
                                break;
                            }

                            magazzino.stampaMagazzino();
                            while (true) {
                                System.out.print("Inserisci l'ID del prodotto da eliminare -> ");

                                try {
                                    int idDaEliminare = scanner.nextInt();
                                    magazzino.rimuoviProdotto(idDaEliminare);
                                    System.out.print("PREMERE INVIO PER CONTINUARE ");
                                    scanner.next();
                                    clear();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Inserire un ID valido!");
                                }
                            }
                            break;

                        case 3:
                            clear();
                            if (magazzino.isEmpty()) {
                                System.out.println("MAGAZZINO VUOTO! PREMERE INVIO PER CONTINUARE");
                                scanner.next();
                                clear();
                                break;
                            }
                            magazzino.stampaMagazzino();
                            System.out.print("PREMERE INVIO PER CONTINUARE ");
                            scanner.next();
                            clear();
                            break;
                        case 4: //INIZIO MENU RICERCA
                            clear();
                            System.out.print(
                                    "[1] CERCA PER ID" + "\n" +
                                            "[2] CERCA PER MODELLO" + "\n" +
                                            "[3] CERCA PER TIPO DI PRODOTTO" + "\n" +
                                            "[4] CERCA PER PRODUTTORE" + "\n" +
                                            "[5] CERCA PER PREZZO DI VENDITA" + "\n" +
                                            "[6] CERCA PER PREZZO DI ACQUISTO" + "\n" +
                                            "[7] CERCA PER RANGE DI PREZZO" + "\n" +
                                            "[8] TORNA INDIETRO" + "\n");
                            try {
                                choice = scanner.nextInt();
                                switch (choice) {
                                    case 1:
                                        clear();
                                        System.out.print("Inserire ID -> ");
                                        try {
                                            Prodotto prodottoDaCercare = magazzino.cercaProdottoPerId(scanner.nextInt());
                                            if (Objects.equals(prodottoDaCercare.getTipoProdotto(), "inesistente")) {
                                                System.out.println("PRODOTTO CORRISPONDENTE ALL'ID INESISTENTE. PREMERE INVIO PER CONTINUARE");
                                                scanner.next();
                                                clear();
                                                continue;
                                            }
                                            System.out.println(prodottoDaCercare);
                                            System.out.print("PREMERE INVIO PER CONTINUARE!");
                                            scanner.next();
                                            clear();
                                            continue;
                                        } catch (Exception e) {
                                            System.out.println("INSERIRE UN ID VALIDO!");
                                            scanner.next();
                                            continue;
                                        }
                                    case 2:
                                        clear();
                                        System.out.print("Inserire modello del prodotto -> ");
                                        magazzino.cercaProdottoPerModello(scanner.next());
                                        System.out.print("PREMERE INVIO PER CONTINUARE");
                                        scanner.next();
                                        clear();
                                        continue;

                                    case 3:
                                        clear();
                                        System.out.print("Inserire tipo del prodotto -> ");
                                        magazzino.cercaProdottoPerTipo(scanner.next());
                                        System.out.print("PREMERE INVIO PER CONTINUARE");
                                        scanner.next();
                                        clear();
                                        continue;

                                    case 4:
                                        clear();
                                        System.out.print("Inserire produttore del prodotto -> ");
                                        magazzino.cercaProdottoPerProduttore(scanner.next());
                                        System.out.print("PREMERE INVIO PER CONTINUARE");
                                        scanner.next();
                                        clear();
                                        continue;

                                    case 5:
                                        clear();
                                        System.out.print("Inserire prezzo di vendita del prodotto -> ");

                                        try {
                                            double prezzo = Double.parseDouble(scanner.next());
                                            magazzino.cercaProdottoPerPrezzoVendita(prezzo);
                                            System.out.print("PREMERE INVIO PER CONTINUARE");
                                            scanner.next();
                                            clear();
                                            continue;

                                        } catch (Exception e) {
                                            System.out.println("INSERIRE UN PREZZO DI VENDITA VALIDO!" + e.getMessage());
                                            scanner.nextDouble();
                                        }
                                        continue;

                                    case 6:
                                        clear();
                                        System.out.print("Inserire prezzo di acquisto del prodotto -> ");
                                        try {
                                            double prezzo = Double.parseDouble(scanner.next());
                                            magazzino.cercaProdottoPerPrezzoAcquito(prezzo);
                                            System.out.print("PREMERE INVIO PER CONTINUARE");
                                            scanner.next();
                                            clear();
                                            continue;
                                        } catch (Exception e) {
                                            System.out.println("INSERIRE UN PREZZO DI ACQUISTO VALIDO!" + e.getMessage());
                                            scanner.next();
                                        }

                                        continue;

                                    case 7:
                                        clear();
                                        try {
                                            System.out.print("Inserire limite inferiore: ");
                                            double limiteInf = scanner.nextDouble();

                                            System.out.print("Inserire limite superiore: ");
                                            double limiteSup = scanner.nextDouble();


                                            if (limiteSup < limiteInf) {
                                                magazzino.cercaProdottoPerRangePrezzo(limiteSup, limiteInf);
                                                System.out.print("PREMERE INVIO PER CONTINUARE");
                                                scanner.next();
                                                clear();
                                                continue;
                                            }

                                            magazzino.cercaProdottoPerRangePrezzo(limiteInf, limiteSup);
                                            System.out.print("PREMERE INVIO PER CONTINUARE");
                                            scanner.next();
                                            clear();
                                            continue;

                                        } catch (Exception e) {
                                            System.out.println("INSERIRE UN VALORE CORRETTO!");
                                            scanner.next();

                                        }
                                        continue;
                                    case 8:
                                        clear();
                                        continue;

                                    default:
                                        System.out.println("INSERIRE UN'OPZIONE VALIDA!");
                                }
                            } catch (Exception e) {
                                System.out.println("Inserire un'opzione valida!");
                                scanner.next();
                            } //FINE MENU RICERCA

                        case 5:
                            System.exit(0);
                            break;

                        default:
                            System.out.println("INSERIRE UN'OPZIONE VALIDA!");
                    }
                } catch (Exception e) {
                    System.out.println("INSERIRE UN'OPZIONE VALIDA!");
                    scanner.next();
                }
            }
        }
    }

    public static void clear() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}
