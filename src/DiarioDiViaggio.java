import java.util.Scanner;
import java.math.BigDecimal;

public class DiarioDiViaggio {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Viaggi listViaggi = new Viaggi();

        String uscita = "s";

        while(!uscita.equals("n")){
            listViaggi.aggiungiViaggio(creaViaggio());
            System.out.println("Vuoi creare un nuovo viaggio?  s/n");

            uscita = scanner.nextLine();
        }

        listViaggi.stampaViaggi(listViaggi.ordinaViaggiPerCosto(true));
    }

    // si può fare un metodo per creare un viaggio così poi lo richiamiamo ogni
    // volta

    private static Viaggio creaViaggio() {
        System.out.println("Inserisci destinazione: ");
        String destinazione = scanner.nextLine();

        System.out.println("Inserisci la data ");
        String data = scanner.nextLine();

        System.out.println("Inserisci costo: ");
        BigDecimal costo = scanner.nextBigDecimal();

        scanner.nextLine(); 

        System.out.println("Inserisci descrizione ");
        String descrizione = scanner.nextLine();

        System.out.println("E' un viaggio in Italia o all'estero? (I/E)");
        String estero = scanner.nextLine();

        if (estero.equals("I")) {
            System.out.println("Indicare la regione: ");
            String regione = scanner.nextLine();
            ViaggioLocale vlLocale = new ViaggioLocale(destinazione, data, costo, descrizione, regione);
            return vlLocale;
        } else {
            System.out.println("Indicare il fuso orario: ");
            int fusoOrario = scanner.nextInt();

            scanner.nextLine(); 

            ViaggioInternazionale vi = new ViaggioInternazionale(destinazione, data, costo, descrizione, fusoOrario);
            return vi;
        }
    }

}