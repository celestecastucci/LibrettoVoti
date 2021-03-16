package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {
	
	//1) è il TestLibretto che crea 10 voti e li aggiunge
	public static void main(String[] args) {          //CREO IL METODO MAIN E GESTISCO QUI

	System.out.println("TEST METODI DI LIBRETTO"); //per verificare che stampa qualcosa--> run as di TestLibretto
	Libretto libretto= new Libretto(); //creo un libretto nuovo
	
	Voto voto1= new Voto("Analisi 1",30,LocalDate.of(2012,2,15)); //creo un voto nuovo
	
	//aggiungo un metodo add nella classe Libretto per aggiungere il voto al libretto
	libretto.add(voto1);
	libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 15))); //cosi creo direttamente il nuovo voto e lo aggiungo insieme
	libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 9, 15)));
	libretto.add(new Voto("Chimica", 25, LocalDate.of(2019, 9, 15)));
	
	System.out.println(libretto); //cosi stampa il riferimento con la @ --> aggiungo metodo ToString in Libretto
	
	
	//per il test creo una lista di voti che è data dalla listaVotiUguali in Libretto e ha come punteggio 25:
	//TEST VOTI UGUALI AL PUNTEGGIO PASSATO
	List<Voto>venticinque= libretto.listaVotiUguali(25);  //stampa arrayList
	System.out.println(venticinque);
	
	Libretto librettoVenticinque= libretto.votiUguali(25); //stampa il libretto 
	System.out.println(librettoVenticinque);
	
	
	//TEST RICERCA CORSO
	Voto analisi1= libretto.ricercaCorso("Analisi 1");
	System.out.println(analisi1);
	
	Voto analisi3= libretto.ricercaCorso("Analisi 3");
	System.out.println(analisi3);
	
	//TEST CONFLITTO E DOPPIONE
	Voto chimica=libretto.ricercaCorso("Chimica");
	Voto chimica_doppio= new Voto("Chimica", 25, LocalDate.of(2019, 9, 15));
	Voto chimica_conflitto= new Voto("Chimica", 29, LocalDate.of(2019, 9, 15));
System.out.println(chimica + " doppione di " + chimica_doppio + "? -> "+libretto.esisteDuplicato(chimica_doppio));
System.out.println(chimica + " doppione di " + chimica_conflitto + "? -> "+ libretto.esisteDuplicato(chimica_conflitto));
System.out.println(chimica + " conflitto di " + chimica_doppio + "? -> "+libretto.esisteConflitto(chimica_doppio));
System.out.println(chimica + " conflitto di " + chimica_conflitto + "? -> "+libretto.esisteConflitto(chimica_conflitto));

	}
	
}
