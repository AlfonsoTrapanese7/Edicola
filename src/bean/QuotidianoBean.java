package bean;

import java.util.Scanner;

public class QuotidianoBean {
    private String nome;
    private int cricevute = 0;
    private double prezzo;
    private double aggio;
    private int cvendute = 0;


    public QuotidianoBean() {
    }


    public QuotidianoBean(String nome, int cricevute, double prezzo, double aggio, int cvendute) {
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
                System.out.println("Inserisci il nome della pubblicazione (min 3 caratteri)");
                nomeTemp = readerText.nextLine();
                nomeInserito = nome.length() >= 3;
                if (nomeInserito){
                    this.nome = nomeTemp;
                } else {
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
                System.out.println("Inserisci la quantità di copie ricevute della pubblicazione");
                quantitaRicevuteTemp = readerNumber.nextInt();
                quantitaRicevuteInserito = quantitaRicevuteTemp > 0;
                if (quantitaRicevuteInserito){
                    this.cricevute = quantitaRicevuteTemp;
                } else {
                    System.out.println("Quantità inserita non valida");
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
                System.out.println("Inserisci il prezzo della pubblicazione");
                prezzoTemp = readerNumber.nextDouble();
                prezzoInserito = prezzoTemp > 0;
                if (prezzoInserito){
                    this.prezzo = prezzoTemp;
                } else {
                    System.out.println("Prezzo inserito non valido");
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
                System.out.println("Inserisci l'aggio in percentuale della pubblicazione (valore compreso tra 5 e 20)");
                aggioTemp = readerNumber.nextDouble();
                aggioInserito = aggioTemp >= 5 && aggioTemp <= 20;
                if (aggioInserito){
                    this.aggio = aggioTemp;
                } else {
                    System.out.println("Aggio inserito non valido");
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

}
