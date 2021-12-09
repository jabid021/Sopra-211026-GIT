package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.IDAOCompte;
import model.Admin;
import model.Client;
import model.Compte;

public class DAOCompteJDBC implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte save(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,nom,prenom,type_compte) VALUES (?,?,?,?,?)");
			if(compte instanceof Client) 
			{
				Client c = (Client) compte;
				ps.setString(1, c.getLogin());
				ps.setString(2, c.getPassword());
				ps.setString(3,c.getNom());
				ps.setString(4,c.getPrenom());
				ps.setString(5,"client");
			}
			else 
			{
				Admin a = (Admin) compte;
				ps.setString(1, a.getLogin());
				ps.setString(2, a.getPassword());
				ps.setString(3,null);
				ps.setString(4,null);
				ps.setString(5,"admin");
			}
			
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
	public Compte connect(String login,String password) 
	{
		Compte c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("client")) 
				{
					c = new Client(rs.getInt("id"), rs.getString("login"),rs.getString("password"), rs.getString("nom"), rs.getString("prenom"));
				}
				else 
				{
					c = new Admin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return null;
	}


}
