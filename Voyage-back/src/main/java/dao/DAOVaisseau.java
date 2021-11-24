package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Vaisseau;

public class DAOVaisseau implements IDAO<Vaisseau,Integer>{

	@Override
	public Vaisseau findById(Integer id) {
		Vaisseau v = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from vaisseau where id=? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				v = new Vaisseau(rs.getInt("id"), rs.getString("nom"), rs.getDouble("vitesse"), rs.getInt("capacite"),rs.getDouble("distance"));


			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}



		return v;
	}

	@Override
	public List<Vaisseau> findAll() {
		List<Vaisseau> vaisseaux = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from vaisseau");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Vaisseau v = new Vaisseau(rs.getInt("id"), rs.getString("nom"), rs.getDouble("vitesse"), rs.getInt("capacite"),rs.getDouble("distance"));
				vaisseaux.add(v);

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vaisseaux;
	}

	@Override
	public void insert(Vaisseau v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO vaisseau (nom,vitesse,distance,capacite) VALUES (?,?,?,?)");
			ps.setString(1, v.getNom());
			ps.setDouble(2, v.getVitesse());
			ps.setDouble(3, v.getDistance());
			ps.setInt(4, v.getCapacite());


			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Vaisseau v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("UPDATE vaisseau SET nom=?, vitesse=?, capacite=?, distance=? where id=?  ");
			ps.setString(1, v.getNom());
			ps.setDouble(2, v.getVitesse());
			ps.setInt(3, v.getCapacite());
			ps.setDouble(4, v.getDistance());
			ps.setInt(5,v.getId());


			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("DELETE from vaisseau where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
