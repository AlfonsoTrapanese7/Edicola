package bean;

import java.util.Scanner;

public class QuotidianoBean {
    private int id;
    private String nome;
    private int cricevute = 0;
    private double prezzo;
    private double aggio;
    private int cvendute = 0;


    public QuotidianoBean() {
    }

    public QuotidianoBean(int id, String nome, int cricevute, double prezzo, double aggio, int cvendute) {
        this.id = id;
        this.nome = nome;
        this.cricevute = cricevute;
        this.prezzo = prezzo;
        this.aggio = aggio;
        this.cvendute = cvendute;
    }


    public String getNome() {
        return this.nome;
    }


    
    public void setNome(Scanner readerText) {
            boolean nomeInserito = false;
            String nomeTemp; 
            while (!nomeInserito) {
                try{
                System.out.println("Inserisci il nome della pubblicazione (min 3 caratteri)");
                nomeTemp = readerText.nextLine();

                if (nomeTemp.length() < 3) {
                    throw new IllegalArgumentException("Il nome deve avere almeno 3 caratteri.");
                }
    
                if (!nomeTemp.matches(".*[a-zA-Z].*")) {
                    throw new IllegalArgumentException("Il nome deve contenere almeno una lettera.");
                }

                
                    this.nome = nomeTemp;
                    nomeInserito = true;
                } catch (IllegalArgumentException e) {
                    e.getLocalizedMessage();
                    System.out.println("Nome inserito non valido");
                }
            }
    }

    public int getCricevute() {
        return this.cricevute;
    }

    public void setCricevute(Scanner readerNumber) {
            boolean quantitaRicevuteInserito = false;
            int quantitaRicevuteTemp; 
            while (!quantitaRicevuteInserito) {
                try {
                    System.out.println("Inserisci la quantità di copie ricevute della pubblicazione:");
                    String input = readerNumber.nextLine();
        
                    // Prova a convertire in intero
                    quantitaRicevuteTemp = Integer.parseInt(input);
        
                    // Controlla che sia > 0
                    if (quantitaRicevuteTemp > 0) {
                        this.cricevute = quantitaRicevuteTemp;
                        quantitaRicevuteInserito = true;
                        System.out.println("Quantità ricevute inserita correttamente: " + this.cricevute);
                    } else {
                        System.out.println("Errore: la quantità deve essere un numero maggiore di zero.");
                    }
        
                } catch (NumberFormatException e) {
                    System.out.println("Errore: inserisci un numero intero valido.");
                }
            }
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(Scanner readerNumber) {
            boolean prezzoInserito = false;
            double prezzoTemp;
            while (!prezzoInserito) {
                try {
                    System.out.println("Inserisci il prezzo della pubblicazione (numero positivo):");
                    String input = readerNumber.nextLine();
        
                    prezzoTemp = Double.parseDouble(input);
        
                    if (prezzoTemp > 0) {
                        this.prezzo = prezzoTemp;
                        prezzoInserito = true;
                        System.out.println("Prezzo inserito correttamente: " + this.prezzo);
                    } else {
                        System.out.println("Errore: il prezzo deve essere maggiore di zero.");
                    }
        
                } catch (NumberFormatException e) {
                    System.out.println("Errore: inserisci un numero valido (es. 12.50).");
                }
            }
        }

    public double getAggio() {
        return this.aggio;
    }

    public void setAggio(Scanner readerNumber) {
            boolean aggioInserito = false;
            double aggioTemp;
            while (!aggioInserito) {
                try {
                    System.out.println("Inserisci l'aggio in percentuale della pubblicazione (valore compreso tra 5 e 20):");
                    String input = readerNumber.nextLine();
        
                    aggioTemp = Double.parseDouble(input);
        
                    if (aggioTemp >= 5 && aggioTemp <= 20) {
                        this.aggio = aggioTemp;
                        aggioInserito = true;
                        System.out.println("Aggio inserito correttamente: " + this.aggio + "%");
                    } else {
                        System.out.println("Errore: l'aggio deve essere compreso tra 5 e 20.");
                    }
        
                } catch (NumberFormatException e) {
                    System.out.println("Errore: inserisci un numero valido per l'aggio.");
                }
            }
        }

    public int getCvendute() {
        return this.cvendute;
    }

    public boolean incrementCvendute() {
            if (cricevute > cvendute) {
                cvendute++;
                return true;
            } else {
                System.out.println("Errore durante l'incremento delle copie vendute, copie ricevute insufficienti");
                return false;
            } 
    }

    public int getCopieRese() {
        return cricevute - cvendute;
    }

    public double getGuadagnoPubblicazione() {
        return (cvendute * prezzo * aggio / 100);
    }


    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", copie ricevute='" + getCricevute() + "'" +
            ", copie vendute='" + getCvendute() + "'" +
            ", copie rese='" + getCopieRese() + "'" +
            ", guadagno pubblicazione='" + getCopieRese() + "'" +
            "}";
    }
    public void setCvendute(int cvendute) {
        this.cvendute = cvendute;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCricevute(int cricevute) {
        this.cricevute = cricevute;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public void setAggio(double aggio) {
        this.aggio = aggio;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
