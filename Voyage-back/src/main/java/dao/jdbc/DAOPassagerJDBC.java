package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOCompte;
import dao.IDAOPassager;
import model.Client;
import model.Passager;
import util.Context;

public class DAOPassagerJDBC implements IDAOPassager{

	IDAOCompte daoC = Context.getInstance().getDaoCompte();
	@Override
	public Passager findById(Integer id) {
		Passager p=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from passager JOIN compte on compte.id=passager.client where passager.id=?");
			ps.setInt(1, id);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Client c = new Client(rs.getInt("compte.id"),null,null,rs.getString("compte.nom"),rs.getString("compte.prenom"));
				p=new Passager(id,rs.getString("passager.nom"), rs.getString("passager.prenom"), c);
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Passager> findAll() {
		List<Passager> passagers=new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from passager");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				//Retrouver le client grace au findById de la classe Compte
				Client c = (Client) daoC.findById(rs.getInt("client"));
				Passager p=new Passager(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), c);
				passagers.add(p);
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passagers;
	}

	@Override
	public void insert(Passager p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO passager (nom,prenom,client) VALUES (?,?,?)");
			ps.setString(1,p.getNom());
			ps.setString(2,p.getPrenom());
			ps.setInt(3,p.getClient().getId());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Passager p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("Update passager set nom=?,prenom=?,client=? where id=?");
			ps.setString(1,p.getNom());
			ps.setString(2,p.getPrenom());
			ps.setInt(3,p.getClient().getId());
			ps.setInt(4, p.getId());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("DELETE from passager where id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public List<Passager> findAllByClient(int id) {
		List<Passager> passagers=new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from passager where client=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Client c = (Client) daoC.findById(rs.getInt("client"));
				Passager p=new Passager(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), c);
				passagers.add(p);
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passagers;
	}

}
