import java.sql.SQLException;
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

        QuotidianoBean quotidianoTemp = null;

        boolean esciCiclo1;

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
                    System.out.println("Seleziona l'operazione da effettuare");
                    System.out.println("1: Inserimento copie ricevute per nome");
                    System.out.println("2: Incremento copie vendute per nome");
                    System.out.println("3: Modifica prezzo per nome");
                    System.out.println("4: modifica aggio per nome");
                    System.out.println("5: Reset inizio giornata");
                    scelta2 = readerNumber.nextInt();
                    switch (scelta2) {
                        case 1:
                        esciCiclo1 = false;
                        while (esciCiclo1) {
                            
                            try {
                            
                            } catch (Exception e) {
                            
                            }
                        }
                        
                            
                            break;
                        case 2:
                           
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                        case 5:
                            try {
                                mioQuotidianoDao.resetGiornata();
                            } catch (SQLException e) {
                                System.out.println();
                            }
                            break;
                        default:
                            System.out.println("Valore non consentito, ritorno al menu principale");
                            break;
                    }
                    break;
                case 3:
                    
                    break;
                case 4:
                    
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
