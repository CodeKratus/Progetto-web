package it.betacom.bean;

import java.util.Date;

public class Animali {
private int id;
private String tipoAnimale;
private int matricola;
private String nome;
private Date dataAcquisto;	
private int prezzo;
private int idC;

public String getTipoAnimale() {
	return tipoAnimale;
}
public void setTipoAnimale(String tipoAnimale) {
	this.tipoAnimale = tipoAnimale;
}
public int getMatricola() {
	return matricola;
}
public void setMatricola(int matricola) {
	this.matricola = matricola;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdC() {
	return idC;
}
public void setIdC(int idC) {
	this.idC = idC;
}
public Date getDataAcquisto() {
	return dataAcquisto;
}
public void setDataAcquisto(Date dataAcquisto) {
	this.dataAcquisto = dataAcquisto;
}
public int getPrezzo() {
	return prezzo;
}
public void setPrezzo(int prezzo) {
	this.prezzo = prezzo;
}
}
