package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOCompte;
import dao.IDAOReservation;
import dao.IDAOTrajet;
import model.Client;
import model.Reservation;
import model.Trajet;
import util.Context;

public class DAOReservationJDBC implements IDAOReservation{

	
	IDAOCompte daoC = Context.getInstance().getDaoCompte();
	IDAOTrajet daoT = Context.getInstance().getDaoTrajet();
	@Override
	public Reservation findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation save(Reservation objet) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public List<Reservation> findAllByClient(int id) {
		List<Reservation> reservations=new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from reservation where client=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Client client = (Client) daoC.findById(rs.getInt("client"));
				Trajet aller = daoT.findById(rs.getInt("trajet_aller"));
				Trajet retour = daoT.findById(rs.getInt("trajet_retour"));
				Reservation r =new Reservation(rs.getInt(id),aller, client,LocalDate.parse(rs.getString("date_reservation")));
				r.setRetour(retour);
				reservations.add(r);
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservations;
	}

}
