package it.betacom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.betacom.bean.PSUser;

public class PSUserDao {
//METODO PER CONNESSIONE DB
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "Justenioreh97!");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
//METODO DI STAMPA LISTA UTENTI
	public static List<PSUser> getAllRecords() {
		List<PSUser> list = new ArrayList<PSUser>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from psuser");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PSUser u = new PSUser();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setEmail(rs.getString("email"));
				u.setCellulare(rs.getString("cellulare"));
				u.setPassword(rs.getString("password"));
				u.setRuolo(rs.getString("Ruolo"));
				u.setStatus(rs.getString("status"));
				list.add(u);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
//METODO CHE ATTRAVERSO IL NOME (USERNAME) RESTITUISCE IL RUOLO
	public static String getRole(String nome) {
		String ruolos = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select ruolo from psuser where nome=?");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ruolos = rs.getString("ruolo");
			} else {
				// do something when no data arrived
				System.out.println("no role data");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return ruolos;
	}
	
	//METODO CHE ATTRAVERSO L'EMAIL (USERNAME) RESTITUISCE IL RUOLO	
	public static String getRoleE(String email) {
		String ruolos = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select ruolo from psuser where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ruolos = rs.getString("ruolo");
			} else {
				// do something when no data arrived
				System.out.println("no role data");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return ruolos;
	}
	//METODO CHE ATTRAVERSO IL NOME (USERNAME) RESTITUISCE LO STATUS
	public static String getStatus(String nome) {
		String status = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select status from psuser where nome=?");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = rs.getString("status");
			} else {
				System.out.println("no status data");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	//METODO CHE ATTRAVERSO L'EMAIL (USERNAME) RESTITUISCE LO STATUS
	public static String getStatusE(String email) {
		String status = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select status from psuser where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = rs.getString("status");
			} else {
				System.out.println("no status data");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	//METODO CHE ATTRAVERSO IL NOME (USERNAME) SETTA LO STATUS
	public static void setStatus(String nome) {
		PSUser u = new PSUser();
		u.setStatus("D");
		u.setNome(nome);
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update psuser set status=? where nome=?");
			ps.setString(1, u.getStatus());
			ps.setString(2, u.getNome());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	//METODO CHE ATTRAVERSO L'EMAIL (USERNAME) SETTA LO STATUS
	public static void setStatusE(String email) {
		PSUser u = new PSUser();
		u.setStatus("D");
	    u.setEmail(email);
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update psuser set status=? where email=?");
			ps.setString(1, u.getStatus());
			ps.setString(2, u.getEmail());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
//METODO CHE ATTRAVERSO L'ID RESTITUISCE L'INTERO CAMPO 
	public static PSUser getRecordById(int id) {
		PSUser u = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from psuser where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new PSUser();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setEmail(rs.getString("email"));
				u.setCellulare(rs.getString("cellulare"));
				u.setPassword(rs.getString("password"));
				u.setRuolo(rs.getString("ruolo"));
				u.setStatus(rs.getString("status"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}
//METODO CHE ATTRAVERSO L'ID PRENDE LO STATUS
	public static PSUser getStatusById(int id) {
		PSUser u = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select status from psuser where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new PSUser();
				u.setStatus(rs.getString("status"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}
//METODO UPDATE
	public static int update(PSUser u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update psuser set nome=?,cognome=?,email=?,cellulare=?,password=?,ruolo=?,status=? where id=?");

			ps.setString(1, u.getNome());
			ps.setString(2, u.getCognome());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getCellulare());
			ps.setString(5, u.getPassword());
			ps.setString(6, u.getRuolo());
			ps.setString(7, u.getStatus());
			ps.setInt(8, u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	//METODO PER AGGIORNARE LA PASSWORD E SETTARE CHANGEPWD SU N
	public static int updPwd(PSUser u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update psuser set password=?,changepwd=? where id=?");

			
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getChangePWD());
			ps.setInt(3, u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
//METODO PER SALVARE I DATI DELLA TABELLA DEL DB
	public static int save(PSUser u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into psuser(nome,cognome,email,cellulare,password,ruolo,status) values(?,?,?,?,?,?,?)");
			ps.setString(1,u.getNome());
			ps.setString(2,u.getCognome());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getCellulare());
			ps.setString(5,u.getPassword());
			ps.setString(6,u.getRuolo());
			ps.setString(7,u.getStatus());
			if(u.getEmail() == null) {
				System.out.println("email non valida , campo non inserito");
				
			}else {
			    status=ps.executeUpdate();
			
			}
		}catch(Exception e){System.out.println(e);}
		return status;
	}
//METODO CHE ATTRAVERESO L'OGGETTO EFFETTUA UN' UPDATE DELLO STATUS 
	//QUESTO METODO MI SERVE PER CAMBIARE STATUS NEL JSP
	public static int upS(PSUser u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update psuser set status=? where id=?");

			ps.setString(1, u.getStatus());
			ps.setInt(2, u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
//PRENDO CHANGEPWD TRAMITE EMAIL
	public static String getPwdStatusE(String email) {
		String status = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select changepwd from psuser where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = rs.getString("changepwd");
			} else {
				System.out.println("no data");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
//PRENDO ID TRAMITE EMAIL
	public static int getIdbyE(String email) {
		int ids = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select id from psuser where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ids = rs.getInt("id");
			} else {
				// do something when no data arrived
				System.out.println("no role data");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return ids;
	}

}
