package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libretto {
	

private List<Voto>listaVoti;  //ATTENZIONE all'import suggerito che non è il primo
	private Map<String,Voto>mappaVoti;                      //dichiaro subito List e poi dopo decido nel costruttore se ARRAYLIST o LINKEDLIST

 public Libretto() {
 this.listaVoti= new ArrayList<>();  //con NEW inizializzo la variabile
 this.mappaVoti= new HashMap<>();                           //this. significa che la variabile è un'istanza e non è variabile locale del metodo
 }
	
 
 public void add(Voto v) {   //CREO METODO ADD --> delego un metodo per usarlo nel testLibretto
	 this.listaVoti.add(v);
	 this.mappaVoti.put(v.getNome(),v);
 }
 
 public String toString() {  //CREO METODO TO STRING --> la lista si stampa cosi con le virgole che separano
	                         //creo anche il metodo in VOTO perchè è sua responsabilita come stmparsi 
	String s="";
	 for(Voto v: this.listaVoti) {
		 s=s+v.toString()+"\n";  //per applicare il metodo toString e andare a capo alla fine della riga
	 }
	 return s;
	 //return this.listaVoti.toString(); //--> non va bene perchè li stampa tutti su una riga cosi
 }
 
	 //2) STAMPA TUTTI I CORSI CON I VOTI UGUALI A 25
 //ho vari modi es. public void, public string , public List , public Libretto
 
 //public List --> restituisce l'arraylist, espone cosa è fatto ed è più difficile se dovessi modificare in futuro
 
 public List<Voto>listaVotiUguali(int punteggio) {
	 
	 List<Voto>risultato= new ArrayList<>(); //creo nuova lista vuota che chiamo risultato
	 for(Voto v: this.listaVoti) {
		 if(v.getVoto()==punteggio) {
			 risultato.add(v);
		 }
	 }
	 return risultato;
 }
 
//public Libretto --> restituisce l'intero oggetto libretto che soddisfa il requisito 
 /**
  * Creo un nuovo oggetto Libretto 
  * Se il punteggio è uguale al voto nella listaVoti allora aggiungo il voto al libretto
  * @param punteggio
  * @return
  */
 public Libretto votiUguali(int punteggio) {
		 Libretto risultato = new Libretto();   //creo un nuovo libretto che chiamo risultato
		 for(Voto v: this.listaVoti) {
			 if(v.getVoto()==punteggio) {
				 risultato.add(v);  //uso il metodo add senza problemi perchè ho creato il metodo add in Libretto!!!
			 }
		 }
		 return risultato;
	 }
 
 //3) restituisce voto corrispondente al nome del corso passato --> quindi restituisce L'OGGETTO VOTO
 /**
  * Ricerca un Voto del corso di cui ho specificato il nome
  * Se il corso non esiste restituisce null
  * @param nomeCorso
  * @return
  */
 
 public Voto ricercaCorso(String nomeCorso) {
	 /**
	  * MODIFICO IL METODO CON LA MAPPA
	  */
	/* Voto risultato=null;  //inizializzo a null 
	 for(Voto v: this.listaVoti) {
		 if(v.getNome().equals(nomeCorso)) {  //METTERE SEMPRE EQUALS PER LE STRING E NON COMPARETO
			 risultato=v;	
			 break;  //una volta trovato un nomeCorso uguale interrompo il ciclo!
			 }
	 } 
	 return risultato; */
	 
	 return mappaVoti.get(nomeCorso);   
	 
 }
	/**
	 * inizia da qui la parte con MODEL
	 * 
	 */
          /**
          * Verifica se nel libretto c'è un voto con STESSO ESAME MA VOTAZIONE DIVERSA
          * prima con la lista, mi accorgo che è un processo lungo --> CREO IN PARALLELO MAPPA
          */ 

 
 public boolean esisteDuplicato(Voto v) {
	 
	 /*boolean trovato=false;
	 for(Voto voto: this.listaVoti) {
		 if(voto.getNome().equals(v.getNome()) && voto.getVoto()==v.getVoto()) {
			 trovato=true;
		 break ;
	 }
 }
  return trovato; */
	 
	 /**
	  * METODO ESISTE DUPLICATO CON LA MAPPA
	  */
	 Voto trovato= mappaVoti.get(v.getNome());
	 if(trovato==null)
		 return false;
	 if(trovato.getVoto()==v.getVoto())
		 return true;
	 else 
		 return false;
 }

 

 /**
 * Verifica se nel libretto c'è un voto con STESSO ESAME E VOTAZIONE UGUALE
 * prima con la lista, mi accorgo che è un processo lungo --> CREO IN PARALLELO MAPPA
 */ 
 
 public boolean esisteConflitto(Voto v) {
	 /*boolean trovato=false;
	 for(Voto voto: this.listaVoti) {
		 if(voto.getNome().equals(v.getNome()) && voto.getVoto()!=v.getVoto()) {
			 trovato=true;
		 break ;
	 }
 }
  return trovato;
 } */
	 /**
	  * METODO ESISTE CONFLITTO CON LA MAPPA
	  */
	 Voto trovato= mappaVoti.get(v.getNome());
	 if(trovato==null)
		 return false;
	 if(trovato.getVoto()!=v.getVoto())
		 return true;
	 else 
		 return false;
 }
}
