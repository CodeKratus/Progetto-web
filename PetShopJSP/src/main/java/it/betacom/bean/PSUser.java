package it.betacom.bean;

public class PSUser {
private int id;
private String nome;
private String cognome;
private String email;
private String cellulare;
private String password;
private String ruolo;
private String status;
private String changePWD;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCellulare() {
	return cellulare;
}
public void setCellulare(String cellulare) {
	this.cellulare = cellulare;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRuolo() {
	return ruolo;
}
public void setRuolo(String ruolo) {
	this.ruolo = ruolo;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "PSUser [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", cellulare="
			+ cellulare + ", password=" + password + ", ruolo=" + ruolo + ", status=" + status + "]";
}
public String getChangePWD() {
	return changePWD;
}
public void setChangePWD(String changePWD) {
	this.changePWD = changePWD;
}
}
