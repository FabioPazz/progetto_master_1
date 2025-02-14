import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public abstract class Viaggio {
    private String destinazione; 
    private String data;
    private BigDecimal costo;
    private String descrizione;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        private static final Pattern datePattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");


    public Viaggio(String destinazione, String data, BigDecimal costo, String descrizione){
        //Errore se qualche campo viene lasciato vuoto
        if (destinazione==null || data==null || costo==null ||descrizione==null){
            throw new IllegalArgumentException("Nessun campo può essere null");
        }
        //Errore se viene inserito un costo negativo
        if (costo.compareTo(BigDecimal.ZERO)<0){
            throw new IllegalArgumentException("Il costo non può essere negativo!!!");
        }

        // Verifica che la data rispetti il formato "dd/MM/yyyy"
        if (!datePattern.matcher(data).matches()) {
            throw new IllegalArgumentException("Formato della data non valido, usa dd/MM/yyyy");
        }

        // Verifica che la data sia effettivamente valida
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(data);  // Controllo che la data sia valida
        } catch (ParseException e) {
            throw new IllegalArgumentException("Data non valida: " + data);
        }

        this.destinazione = destinazione;
        this.data =data;
        this.costo = costo;
        this.descrizione=descrizione;
    }

    public String getDestinazione(){
        return destinazione;
    }       

    public String getData(){
        return data;
    }

    public BigDecimal getCosto(){
        return costo;
    }

    public String getDescrizione(){
        return descrizione;
    }

    @Override 
    public String toString(){
        return "Viaggio{" + "destinazione="+destinazione+", data= "+data+", costo= "+costo+", descrizione= "+descrizione+"}";
    }

    public abstract int tempoViaggio();
}
