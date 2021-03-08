package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	

private List<Voto>listaVoti;  //ATTENZIONE all'import suggerito che non è il primo
	                         //dichiaro subito List e poi dopo decido nel costruttore se ARRAYLIST o LINKEDLIST

 public Libretto() {
 this.listaVoti= new ArrayList<>();  //con NEW inizializzo la variabile
	                              //this. significa che la variabile è un'istanza e non è variabile locale del metodo
 }
	
 
 public void add(Voto v) {   //CREO METODO ADD --> delego un metodo per usarlo nel testLibretto
	 this.listaVoti.add(v);
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
 
 public Libretto votiUguali(int punteggio) {
		 Libretto risultato = new Libretto();   //creo un nuovo libretto che chiamo risultato
		 for(Voto v: this.listaVoti) {
			 if(v.getVoto()==punteggio) {
				 risultato.add(v);  //uso il metodo add senza problemi perchè ho creato il metodo add in Libretto!!!
			 }
		 }
		 return risultato;
	 }
	 
	 
	 
 }

