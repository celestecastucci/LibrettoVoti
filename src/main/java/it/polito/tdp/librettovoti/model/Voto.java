package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

//POJO - Plain Old Java Object
//Java Bean --> classe con costruttore e getter/setter degli elementi

//LA CLASSE VOTO E' UN SEMPLICE CONTENITORE DI DATI -- non ha logica

//PER GENERARE IL COMMENTO BLU : /** invio e genera questo blocco 
//serve perchè se vado sul nome della classe/metodo sopra cui ho generato il commento
//fa vedere la documentazione appena scritta per ricordare cosa ho fatto

/**
 * Memorizza risultato di un esame singolo 
 * 
 * @author celes
 *
 */
public class Voto {
	
	private String nome;
	private int voto; //30L come lo rappresento??
	private LocalDate data; //data superamento esame (è nel formato anno,mese,gionro) --> importo java.time.LocalDate 
	
	
	//genero costruttore come al solito
	
	/**
	 * Costruttore classe Voto
	 * @param nome Nome del corso
	 * @param voto Voto ottenuto
	 * @param data Data superamento
	 */
	public Voto(String nome, int voto, LocalDate data) {
		super();
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}

	//genero setter e getter 
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}

	
	//GENERO METODO TO STRING PER IL VOTO che noi possiamo "personalizzare" nel return come voglio ottenerlo
	@Override
	public String toString() {

	return "Esame "+ nome + " superato con "+ voto + " il " +data;  //metto parole mie e variabili della classe
	//adesso se runno testLibretto mi viene questo return degli esami che ho creato!
	
	}
	
	
	
	
	
	

}
