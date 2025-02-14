import java.util.ArrayList;

public class Viaggi{

    private ArrayList<Viaggio> viaggi=new ArrayList<Viaggio>();

    public Viaggi(){
    }

    /*metodi per inserisere viaggi in base al tipo*/
    public void aggiungiViaggio(Viaggio v){        
        viaggi.add(v);
    }    

    //metodo che rimuove un viaggio dalla lista cercandolo in base alla destinazione
    //se lo trova e lo elimina resstituisce true altrimenti false
    public boolean rimuoviViaggio(String destinazione){
        for (Viaggio v  : viaggi) {
            if (v.getDestinazione().equals(destinazione))//ho messo .equals perche == mi diceva che non funzionava
                viaggi.remove(v);   
                return true;   
        }
        return false;
    }

    //metodo per la ricerca di un viaggio per destinazione
    //se non trova niente restitusice null
    public Viaggio getViaggio(String destinazione){
        for (Viaggio v  : viaggi) {
            if (v.getDestinazione().equals(destinazione))//ho messo .equals perche == mi diceva che non funzionava
                return v;           
        }
        return null;
    }

    public ArrayList<Viaggio> ordinaViaggiPerCosto(boolean asc){
        ArrayList<Viaggio> viaggiOrdinati=new ArrayList<Viaggio>();

        for (Viaggio v: viaggi){
            Boolean inserito=false;
            for (int i=0;i<viaggiOrdinati.size();i++){
                //inserisco un viaggio nella lista di quelli ordinati soltanto se ha un costo inferiore a quello che già c'è
                if (v.getCosto().compareTo(viaggiOrdinati.get(i).getCosto())<=0){
                    viaggiOrdinati.add(i,v);
                    inserito=true;
                    break;
                }
            }
            //se non è stato mai inserito lo aggiungo come ultimo
            if (!inserito){
                viaggiOrdinati.add(v);
            }
        }
        return viaggiOrdinati;
    }

    public void stampaViaggi(ArrayList<Viaggio> par_viaggi){
        System.out.println("Lista dei viaggi: ");
        for (Viaggio v:par_viaggi){
            System.out.println(v.toString());
        }

        System.out.println("Stampa conclusa. Buona giornata");
    }
}