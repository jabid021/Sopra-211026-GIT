package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Planete;
import model.Trajet;
import model.Vaisseau;

public class DAOTrajet implements IDAO<Trajet,Integer>{

	DAOPlanete daoP =new DAOPlanete();
	DAOVaisseau daoV= new DAOVaisseau();
	
	@Override
	public Trajet findById(Integer id) {
		Trajet t = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from trajet where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{

				LocalDate dateDepart=(rs.getString("date_depart")!=null) ?LocalDate.parse(rs.getString("date_depart")): null;
				LocalTime heureDepart=(rs.getString("heure_depart")!=null) ?LocalTime.parse(rs.getString("heure_depart")):null;

				Planete depart=daoP.findById(rs.getInt("depart"));
				Planete arrivee=daoP.findById(rs.getInt("arrivee"));
				Vaisseau vaisseau=daoV.findById(rs.getInt("vaisseau"));

				t=new Trajet(id,dateDepart,heureDepart,depart,arrivee,vaisseau);

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<Trajet> findAll() {
		List<Trajet> trajets = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from trajet ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				LocalDate dateDepart=(rs.getString("date_depart")!=null) ?LocalDate.parse(rs.getString("date_depart")): null;
				LocalTime heureDepart=(rs.getString("heure_depart")!=null) ?LocalTime.parse(rs.getString("heure_depart")):null;

				int id=rs.getInt("id");
				Planete depart=daoP.findById(rs.getInt("depart"));
				Planete arrivee=daoP.findById(rs.getInt("arrivee"));
				Vaisseau vaisseau=daoV.findById(rs.getInt("vaisseau"));

				Trajet t=new Trajet(id,dateDepart,heureDepart,depart,arrivee,vaisseau);
				trajets.add(t);

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return trajets;}

	@Override
	public void insert(Trajet trajet) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO trajet (date_depart,heure_depart, depart, arrivee, vaisseau) VALUES (?,?,?,?,?)");
			ps.setString(1,trajet.getDateDepart().toString());
			ps.setString(2,trajet.getHeureDepart().toString());
			ps.setInt(3,trajet.getDepart().getId());
			ps.setInt(4,trajet.getArrivee().getId());
			ps.setInt(5,trajet.getVaisseau().getId());
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void update(Trajet trajet) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps = conn.prepareStatement("UPDATE trajet set date_depart=?,heure_depart=?, depart=?, arrivee=?, vaisseau=? where id=?");
			ps.setString(1,trajet.getDateDepart().toString());
			ps.setString(2,trajet.getHeureDepart().toString());
			ps.setInt(3,trajet.getDepart().getId());
			ps.setInt(4,trajet.getArrivee().getId());
			ps.setInt(5,trajet.getVaisseau().getId());
			ps.setInt(6,trajet.getId());
			ps.executeUpdate();
			ps.close();
			conn.close();

		}catch(Exception e)
		{e.printStackTrace();}}


	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");

			PreparedStatement ps=conn.prepareStatement("DELETE from trajet where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			conn.close();}catch(Exception e)
		{e.printStackTrace();}

	}
}
