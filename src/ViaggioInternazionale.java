import java.math.BigDecimal;

public class ViaggioInternazionale extends Viaggio
{
    /**
     * Viaggio all'estero
     * 
     * @param destinazione destinazione del viaggio
     * @param data data di partenza
     * @param costo costo totale del viaggio
     * @param descrizione note di viaggio
     * @param fusoOrario ore di fuso orario + o - della destinazione rispetto all'Italia
     */
    private int fusoOrario; 

    public ViaggioInternazionale(String destinazione, String data, BigDecimal costo, String descrizione, int fusoOrario){
        super(destinazione, data, costo, descrizione);
        this.fusoOrario=fusoOrario;
    }

     
    public void setFusoOrario(int fusoOrario){
        this.fusoOrario=fusoOrario;
    }

    public int getFusoOrario(){
        return this.fusoOrario;
    }

    public int tempoViaggio(){
        return fusoOrario+10;
    }
}
    


