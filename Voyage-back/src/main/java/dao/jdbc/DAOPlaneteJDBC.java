package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOPlanete;
import model.Coordonnees;
import model.Planete;
import model.TypePlanete;

public class DAOPlaneteJDBC implements IDAOPlanete{

	@Override
	public Planete findById(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM planete WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next(); //toujours mettre ça pour ne pas avoir valeur null (dans notre cas erreur)
			Coordonnees c = new Coordonnees(rs.getInt("x"), rs.getInt("y"), rs.getInt("z"));
			Planete p = new Planete(rs.getInt("id"), rs.getString("nom"), TypePlanete.valueOf(rs.getString("type_planete")), c);

			rs.close();
			ps.close();
			conn.close();

			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public List<Planete> findAll() {
		List<Planete> planetes = new ArrayList<Planete>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from planete");
			//Statement st = conn.createStatement();
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Coordonnees c = new Coordonnees(rs.getInt("x"), rs.getInt("y"), rs.getInt("z"));
				Planete p = new Planete(rs.getInt("id"), rs.getString("nom"), TypePlanete.valueOf(rs.getString("type_planete")), c);

				planetes.add(p);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return planetes;
	}

	@Override
	public void insert(Planete p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO planete (nom,x,y,z,type_planete) VALUES (?,?,?,?,?)");
			ps.setString(1,p.getNom());
			ps.setInt(2, p.getCoordonnees().getX());
			ps.setInt(3, p.getCoordonnees().getY());
			ps.setInt(4, p.getCoordonnees().getZ());
			ps.setString(5, p.getType().toString());

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Planete p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("UPDATE planete set nom=?, x=?,y=?,z=?,type_planete=? WHERE id=?");
			ps.setString(1,p.getNom());
			ps.setInt(2, p.getCoordonnees().getX());
			ps.setInt(3, p.getCoordonnees().getY());
			ps.setInt(4, p.getCoordonnees().getZ());
			ps.setString(5, p.getType().toString());
			ps.setInt(6, p.getId());


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

			PreparedStatement ps = conn.prepareStatement("delete from planete where id =?");
			//Statement st = conn.createStatement();
			ps.setInt(1,id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
