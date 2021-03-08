package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

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
	
	System.out.println(libretto); //cosi stampa il riferimento con la @ --> aggiungo metodo ToString in Libretto
	
	}
}
