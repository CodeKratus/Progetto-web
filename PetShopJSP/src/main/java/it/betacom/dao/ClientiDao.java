package it.betacom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import it.betacom.bean.Animali;
import it.betacom.bean.Clienti;


public class ClientiDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","Justenioreh97!");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static List<Clienti> getAllRecords(){
		List<Clienti> list=new ArrayList<Clienti>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from clienti");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Clienti u=new Clienti();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setCitta(rs.getString("citta"));
				u.setCellulare(rs.getString("cellulare"));
				u.setIndirizzo(rs.getString("indirizzo"));
				list.add(u);
				
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static int save(Clienti u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into clienti(nome,cognome,citta,cellulare,indirizzo) values(?,?,?,?,?)");
			ps.setString(1,u.getNome());
			ps.setString(2,u.getCognome());
			ps.setString(3,u.getCitta());
			ps.setString(3,u.getCellulare());
			ps.setString(4,u.getIndirizzo());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int update(Clienti u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update clienti set nome=?,cognome=?,citta=?,cellulare=?,indirizzo=? where id=?");
			ps.setString(1,u.getNome());
			ps.setString(2,u.getCognome());
			ps.setString(3,u.getCitta());
			ps.setString(4,u.getCellulare());
			ps.setString(4,u.getIndirizzo());
			ps.setInt(5,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(Clienti u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from clienti where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
	}
	public static List<Animali> getAllComp(int x){
		List<Animali> list=new ArrayList<Animali>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from animali a  join clienti c "
					                                + "on a.idC = c.id "
					                                 + "where a.idC = "+x);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Animali u=new Animali();
				u.setId(rs.getInt("id"));
				u.setTipoAnimale(rs.getString("tipoAnimale"));
				u.setMatricola(rs.getInt("matricola"));
				u.setNome(rs.getString("nome"));
				u.setDataAcquisto(rs.getDate("dataAcquisto"));
				u.setPrezzo(rs.getInt("prezzo"));
				u.setIdC(rs.getInt("idC"));
				
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
}
