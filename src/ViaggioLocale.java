import java.math.BigDecimal;


public class ViaggioLocale extends Viaggio{
    /**
     * Viaggio in Italia
     * 
     * @param destinazione destinazione del viaggio
     * @param data data di partenza
     * @param costo costo totale del viaggio
     * @param descrizione note di viaggio
     * @param regione regione locale
     */

    private String regione;

    public ViaggioLocale(String destinazione, String data, BigDecimal costo, String descrizione, String regione){
        super(destinazione, data, costo, descrizione);
        this.regione=regione;
    }

    public void setRegione(String regione){
        this.regione=regione;
    }

    public String getRegione(){
        return this.regione;
    }

    // @since v0.0.1
    public int tempoViaggio(){
        return 10;
    }

}