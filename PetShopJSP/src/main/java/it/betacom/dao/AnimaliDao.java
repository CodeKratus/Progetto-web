package it.betacom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import it.betacom.bean.Animali;



public class AnimaliDao {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","Justenioreh97!");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static List<Animali> getAllRecords(){
		List<Animali> list=new ArrayList<Animali>();
		//a join clienti c on a.idC = c.id
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select a.id ,a.tipoAnimale ,a.matricola ,a.nome ,a.dataAcquisto,a.prezzo,a.idC  from animali a");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Animali a=new Animali();
				a.setId(rs.getInt("id"));
				a.setTipoAnimale(rs.getString("tipoAnimale"));
				a.setMatricola(rs.getInt("matricola"));
				a.setNome(rs.getString("nome"));
				a.setDataAcquisto(rs.getDate("dataAcquisto"));
				a.setPrezzo(rs.getInt("prezzo"));
				a.setIdC(rs.getInt("idC"));
				
				list.add(a);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	
	public static int save(Animali u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into animali(tipoAnimale,matricola,nome,dataAcquisto,prezzo,idC) values(?,?,?,?,?,?)");
			ps.setString(1,u.getTipoAnimale());
			ps.setInt(2,u.getMatricola());
			ps.setString(3,u.getNome());
			ps.setDate(4,(Date) u.getDataAcquisto());
			ps.setInt(5,u.getPrezzo());
			ps.setInt(6,u.getIdC());
		
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int update(Animali u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update animali set tipoAnimale=?,matricola=?,nome=?,dataAcquisto=?,prezzo=?,idC=? where id=?");
			ps.setString(1,u.getTipoAnimale());
			ps.setInt(2,u.getMatricola());
			ps.setString(3,u.getNome());
			ps.setDate(4,(Date) u.getDataAcquisto());
			ps.setInt(5,u.getPrezzo());
			ps.setInt(6,u.getIdC());
			ps.setInt(7,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(Animali u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from animali where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
	}
	
	
	
}
