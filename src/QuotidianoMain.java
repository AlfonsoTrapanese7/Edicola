import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import bean.QuotidianoBean;
import dao.QuotidianoDao;

public class QuotidianoMain {
    public static void main(String[] args) {
        Scanner readerNumber = new Scanner(System.in);
        Scanner readerText = new Scanner(System.in);
        boolean exit = false;

        int scelta;
        int scelta2;
        
        QuotidianoDao mioQuotidianoDao = new QuotidianoDao();
        boolean quotidianoVuoto = true;

        QuotidianoBean quotidianoTemp = null;

        boolean esciCiclo;
        int numeroCopieTemp;
        String nomeTemp;
        double prezzoTemp;
        double aggioTemp;
        List<QuotidianoBean> listaTemp = null;
        System.out.println("--- Edicola ---");
        while(!exit) {
            System.out.println("Seleziona l'operazione da effettuare");
            System.out.println("1: Inserimento pubblicazione");
            System.out.println("2: Modifica pubblicazione");
            System.out.println("3: Stampa resoconto");
            System.out.println("4: Rimozione pubblicazione");
            System.out.println("5: Esci");
            scelta = readerNumber.nextInt();
            switch (scelta) {
                case 1:
                    quotidianoTemp = new QuotidianoBean();
                    quotidianoTemp.setNome(readerText);
                    quotidianoTemp.setPrezzo(readerNumber);
                    quotidianoTemp.setAggio(readerNumber);
                    try {
                        mioQuotidianoDao.aggiungiPubblicazione(quotidianoTemp);
                        System.out.println("Inserimento effettuato correttamente");
                    } catch (SQLException e) {
                        System.out.println("Errore durante l'inserimento della pubblicazione");
                    }
                    
                    break;
                case 2:
                    readerNumber.nextLine();
                    System.out.println("Seleziona l'operazione da effettuare");
                    System.out.println("1: Inserimento copie ricevute per nome");
                    System.out.println("2: Incremento copie vendute per nome");
                    System.out.println("3: Modifica prezzo per nome");
                    System.out.println("4: modifica aggio per nome");
                    System.out.println("5: Reset inizio giornata");
                    scelta2 = readerNumber.nextInt();
                    switch (scelta2) {
                        case 1:
                            try {
                                quotidianoVuoto = !mioQuotidianoDao.isNotEmpty();
                            } catch (SQLException e) {
                                System.out.println("Errore durante l'interrogazione del DB");
                            }
                            if (quotidianoVuoto) {
                                System.out.println("Nessun quotidiano trovato");
                                break;
                            }
                        esciCiclo = false;
                        while (!esciCiclo) {
                            
                            try {
                                System.out.println("Inserisci il nome del quotidiano da aggiornare");
                                nomeTemp = readerText.nextLine();
                                System.out.println("Inserisci il numero di copie ricevuto da aggiornare");
                                numeroCopieTemp = readerNumber.nextInt();
                                esciCiclo = mioQuotidianoDao.inserisciCopieRicevute(nomeTemp, numeroCopieTemp);
                                if (!esciCiclo) {
                                    System.out.println("Nome errato oppure numero di copie non valido");
                                } else {
                                    System.out.println("Operazione eseguita correttamente");
                                }
                                
                            } catch (SQLException e) {
                                System.out.println("Errore durante l'interrogazione del DB");
                            } catch (InputMismatchException e) {
                                System.out.println("Numero di copie non valido");
                                readerNumber.nextLine();
                            }
                        }
                        
                            
                            break;
                        case 2:
                            try {
                                quotidianoVuoto = !mioQuotidianoDao.isNotEmpty();
                            } catch (SQLException e) {
                                System.out.println("Errore durante l'interrogazione del DB");
                            }
                            if (quotidianoVuoto) {
                                System.out.println("Nessun quotidiano trovato");
                                break;
                            }
                            esciCiclo = false;
                            while (!esciCiclo) {
                            
                                try {
                                    System.out.println("Inserisci il nome del quotidiano da aggiornare");
                                    nomeTemp = readerText.nextLine();
                                    esciCiclo = mioQuotidianoDao.incrementaCopieVendute(nomeTemp);
                                    if (!esciCiclo) {
                                        System.out.println("Quotidiano non trovato oppure incremento non consentito");
                                    } else {
                                        System.out.println("Operazione eseguita correttamente");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Errore durante l'interrogazione del DB");
                                } 
                            }
                           
                            break;
                        case 3:
                            try {
                                quotidianoVuoto = !mioQuotidianoDao.isNotEmpty();
                            } catch (SQLException e) {
                                System.out.println("Errore durante l'interrogazione del DB");
                            }
                            if (quotidianoVuoto) {
                                System.out.println("Nessun quotidiano trovato");
                                break;
                            }
                            esciCiclo = false;
                            while (!esciCiclo) {
                            
                                try {
                                    System.out.println("Inserisci il nome del quotidiano da aggiornare");
                                    nomeTemp = readerText.nextLine();
                                    System.out.println("Inserisci il nuovo prezzo");
                                    prezzoTemp = readerNumber.nextDouble();
                                    esciCiclo = mioQuotidianoDao.modificaPrezzo(nomeTemp, prezzoTemp);
                                    if (!esciCiclo) {
                                        System.out.println("Quotidiano non trovato oppure modifica prezzo non consentita");
                                    } else {
                                        System.out.println("Operazione eseguita correttamente");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Errore durante l'interrogazione del DB");
                                } catch (InputMismatchException e) {
                                    System.out.println("Prezzo non valido");
                                    readerNumber.nextLine();
                                }
                            }
                            break;
                        case 4:
                            try {
                                quotidianoVuoto = !mioQuotidianoDao.isNotEmpty();
                            } catch (SQLException e) {
                                System.out.println("Errore durante l'interrogazione del DB");
                            }
                            if (quotidianoVuoto) {
                                System.out.println("Nessun quotidiano trovato");
                                break;
                            }
                            esciCiclo = false;
                            while (!esciCiclo) {
                            
                                try {
                                    System.out.println("Inserisci il nome del quotidiano da aggiornare");
                                    nomeTemp = readerText.nextLine();
                                    System.out.println("Inserisci il nuovo aggio");
                                    aggioTemp = readerNumber.nextDouble();
                                    esciCiclo = mioQuotidianoDao.modificaAggio(nomeTemp, aggioTemp);
                                    if (!esciCiclo) {
                                        System.out.println("Quotidiano non trovato oppure modifica aggio non consentita");
                                    } else {
                                        System.out.println("Operazione eseguita correttamente");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Errore durante l'interrogazione del DB");
                                } catch (InputMismatchException e) {
                                    System.out.println("Aggio non valido");
                                    readerNumber.nextLine();
                                }
                            }
                            break;
                        case 5:
                            try {
                                mioQuotidianoDao.resetGiornata();
                                System.out.println("Operazione eseguita correttamente");
                            } catch (SQLException e) {
                                System.out.println("Errore durante l'interrogazione del DB");
                            }
                            break;
                        default:
                            System.out.println("Valore non consentito, ritorno al menu principale");
                            break;
                    }
                    break;
                case 3:
                    try {
                        listaTemp = mioQuotidianoDao.getRendiconto();
                    } catch (SQLException e) {
                        System.out.println("Errore durante l'interrogazione del DB");
                    }
                    for (QuotidianoBean quotidiano : listaTemp) {
                        System.out.println(quotidiano);
                    }
                    break;
                case 4:
                    try {
                        quotidianoVuoto = !mioQuotidianoDao.isNotEmpty();
                    } catch (SQLException e) {
                        System.out.println("Errore durante l'interrogazione del DB");
                    }
                    if (quotidianoVuoto) {
                        System.out.println("Nessun quotidiano trovato");
                        break;
                    }
                    esciCiclo = false;
                    while (!esciCiclo) {
                    
                        try {
                            System.out.println("Inserisci il nome del quotidiano da eliminare");
                            nomeTemp = readerText.nextLine();
                            esciCiclo = mioQuotidianoDao.eliminaPubblicazione(nomeTemp);
                            if (!esciCiclo) {
                                System.out.println("Quotidiano non trovato");
                            } else {
                                System.out.println("Operazione eseguita correttamente");
                            }
                        } catch (SQLException e) {
                            System.out.println("Errore durante l'interrogazione del DB");
                        } 
                    }
                    break;
                case 5:
                    System.out.println("Grazie per aver utilizzato il mio programma");
                    exit = true;
                    break;
            
                default:
                    System.out.println("Operazione non consentita");
                    break;
            }
        }
        readerNumber.close();
        readerText.close();
    }
}
