import java.util.Scanner;

public class QuotidianoMain {
    public static void main(String[] args) {
        Scanner readerNumber = new Scanner(System.in);
        Scanner readerText = new Scanner(System.in);
        boolean exit = false;

        int scelta;

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
                    
                    break;
                case 2:
                    
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
