package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.IDAOCompte;
import dao.IDAOPassager;
import dao.IDAOPlanete;
import dao.IDAOTrajet;
import dao.IDAOVaisseau;
import model.Admin;
import model.Client;
import model.Compte;
import model.Coordonnees;
import model.Passager;
import model.Planete;
import model.Reservation;
import model.Trajet;
import model.TypePlanete;
import model.Vaisseau;
import util.Context;

public class App {

	static Compte connected;
	
	static IDAOCompte daoC = Context.getInstance().getDaoCompte();
	static IDAOPlanete daoP =Context.getInstance().getDaoPlanete();
	static IDAOTrajet daoT = Context.getInstance().getDaoTrajet();
	static IDAOVaisseau daoV = Context.getInstance().getDaoVaisseau();
	static IDAOPassager daoPassager = Context.getInstance().getDaoPassager();

	
	
	
	public static String saisieString(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		String valeur= sc.nextLine();
		return valeur;
	}

	public static int saisieInt(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int valeur= sc.nextInt();
		return valeur;
	}

	public static double saisieDouble(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		double valeur= sc.nextDouble();
		return valeur;
	}


	public static void main(String[] args) {
		menuPrincipal();
	}

	public static void menuPrincipal() {
		System.out.println("Appli Voyage");
		System.out.println("Choisir un menu : ");
		System.out.println("1 - Connexion");
		System.out.println("2 - Inscription");
		System.out.println("3 - Stop" );

		int choix = saisieInt("");
		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : inscription();break;
		case 3 : System.exit(0);break;
		}
		menuPrincipal();
	}

	public static void seConnecter()
	{
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		connected = daoC.connect(login, password);
		if(connected instanceof Admin) 
		{
			menuAdmin();
		}
		else if(connected instanceof Client) 
		{
			menuClient();
		}
		else if(connected == null) {System.out.println("Identifiants invalides");}


		menuPrincipal();
	}
	public static void inscription() 
	{
		System.out.println("Creation d'un compte client :");
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		String nom = saisieString("Saisir votre nom");
		String prenom = saisieString("Saisir votre prenom");
		Compte c = new Client(login,password,nom,prenom);
		daoC.insert(c);

	}

	public static void menuAdmin() 
	{
		System.out.println("-----Menu Admin-----");
		System.out.println("1 - Gestion des planetes");
		System.out.println("2 - Gestion des vaisseaux");
		System.out.println("3 - Gestion des trajets");
		System.out.println("4 - Se deconnecter");

		int choix = saisieInt("Choisir un menu : ");
		switch(choix) 
		{
		case 1  : gestionPlanetes();break;
		case 2 : gestionVaisseaux();break;
		case 3 : gestionTrajets();break;
		case 4 : connected=null;menuPrincipal();break;
		}
		menuAdmin();
	}


	public static void menuClient() 
	{
		System.out.println("-----Menu client-----");
		System.out.println("1 - Gestion des passagers");
		System.out.println("2 - Gestion des reservations");
		System.out.println("3 - Se deconnecter");

		int choix = saisieInt("Choisir un menu : ");
		switch(choix) 
		{
		case 1  : gestionPassagers();break;
		case 2 : gestionReservations();break;
		case 3 : connected=null;menuPrincipal();break;
		}
		menuClient();
	}

	public static void gestionPassagers() 
	{
		System.out.println("-----Gestion de vos passagers-----");
		System.out.println("1 - Afficher mes passagers");
		System.out.println("2 - Creer un nouveau passager");
		System.out.println("3 - Modifier un passager");
		System.out.println("4 - Supprimer un passager");
		//System.out.println("5 - Sauvegarder fichier passagers");
		//System.out.println("6 - Charger fichier passager");
		System.out.println("7 - Retour menu client");
		int choix = saisieInt("Choisir un menu : ");
		switch(choix) 
		{
		case 1  : showPassagers();break;
		case 2 : addPassager();break;
		case 3 : updatePassager();break;
		case 4 : deletePassager();break;
		//case 5 : ecrirePassagers();break;
		//case 6 : lirePassagers();break;
		case 7 : menuClient();break;
		}
		gestionPassagers();
	}


	public static void gestionReservations() 
	{
		System.out.println("-----Gestion de vos reservations-----");
		System.out.println("1 - Afficher mes reservations");
		System.out.println("2 - Faire une reservation");
		System.out.println("3 - Retour menu client");

		int choix = saisieInt("Choisir un menu : ");
		switch(choix) 
		{
		case 1  : showReservations();break;
		case 2 : addReservation();break;
		case 3 : menuClient();break;
		}
		gestionReservations();
	}

	//Detail des methodes : 
	//show => foreach qui affiche chaque element
	//add => faire les saisies puis creer un objet
	//update => lister les elements (avec show()), choisir l'element à modifier, faire les saisies
	//delete => lister les elements (avec show()), choisir l'element à supprimer


	//Reservation//

	public static void showReservations() 
	{
		List<Reservation> mesReservations = new ArrayList(); // select bdd
		for(Reservation r : mesReservations) {System.out.println(r);}
	}

	public static void addReservation() 
	{
		/*System.out.println("Voici les trajets disponibles : ");
		showTrajets();
		int id = saisieInt("Choisir votre trajet aller :");
		Trajet aller = findTrajet(id);
		Trajet retour=null;
		String avecRetour = saisieString("Voulez vous un retour ? (y/n)");
		if(avecRetour.equals("y")) 
		{
			System.out.println("Voici les trajets disponibles : ");
			showTrajets();
			id = saisieInt("Choisir votre trajet retour :");
			retour = findTrajet(id);
		}

		System.out.println("Ajout des passagers : ");
		List<Voyageur> voyageurs=new ArrayList();
		String suivant = "n";
		do 
		{
			showPassagers();
			id=saisieInt("Saisir l'id un passager existant (-1 pour en creer un nouveau)");
			if(id==-1) {addPassager();}
			else 
			{
				Passager p = daoPassager.findById(id);
				voyageurs.add(p);
			}
			suivant = saisieString("Ajouter un autre passer ? (y/n)");
		}while(suivant.equals("y"));


		Reservation  r = new Reservation(passagers,aller,(Client) connected);
		r.setRetour(retour);
		//insert bdd;*/
	}

	//Passagers///

	public static void showPassagers() 
	{
		for(Passager p : daoPassager.findAllByClient(connected.getId())) 
		{
			System.out.println(p);
		}
	}
	public static void addPassager() 
	{
		System.out.println("Voici les passagers existants : ");
		showPassagers();
		System.out.println("Ajout d'un nouveau passager :");
		String nom = saisieString("Saisir le nom du passager");
		String prenom = saisieString("Saisir le prenom du passager");
		Passager passager = new Passager(nom,prenom,(Client) connected);
		daoPassager.insert(passager);


	}
	public static void updatePassager() 
	{
		System.out.println("Voici les passagers existants : ");
		showPassagers();
		int id = saisieInt("Saisir l'id du passager à modifier");
		System.out.println("Modifier le passager "+id);
		String nom = saisieString("Saisir le nom du passager");
		String prenom = saisieString("Saisir le prenom du passager");
		Passager passager = new Passager(id,nom,prenom,(Client) connected);
		daoPassager.update(passager);
	}
	public static void deletePassager() 
	{
		System.out.println("Voici les passagers existants : ");
		showPassagers();
		int id = saisieInt("Saisir l'id du passager à supprimer");
		daoPassager.delete(id);
	}

	/*public static void ecrirePassagers() 
	{
		File f = new File("passagers.txt");
		try(FileOutputStream fos = new FileOutputStream(f);ObjectOutputStream oos=new ObjectOutputStream(fos);)
		{
			oos.writeObject(passagers);
		}catch(Exception e) {e.printStackTrace();}
	}*/
	/*public static void lirePassagers() 
	{
		File f = new File("passagers.txt");
		try(FileInputStream fis = new FileInputStream(f);ObjectInputStream ois=new ObjectInputStream(fis);)
		{
			passagers=(List<Passager>) ois.readObject();
		}catch(Exception e) {e.printStackTrace();}
	}*/

	///Groupe Planete///

	public static void gestionPlanetes() {

        System.out.println("-----Gestion des planètes-----");
        System.out.println("1 - Afficher les planètes");
        System.out.println("2 - Creer une nouvelle planète");
        System.out.println("3 - Modifier une planète");
        System.out.println("4 - Supprimer une planète");
        //        System.out.println("5 - Sauvegarder fichier planète");
        //        System.out.println("6 - Charger fichier planète");
        System.out.println("5 - Retour menu admin");
        int choix = saisieInt("Choisir un menu : ");
        switch(choix) 
        {
        case 1 : showPlanetes();break;
        case 2 : addPlanete();break;
        case 3 : updatePlanete();break;
        case 4 : deletePlanete();break;
        //        case 5 : ecrirePlanetes();break;
        //        case 6 : lirePlanetes();break;
        case 5 : menuAdmin();break;
        }
        gestionPlanetes();

    }
    
	public static void showPlanetes() 
	{
		for(Planete p : daoP.findAll()) 
		{
			System.out.println(p);
		}
	}
    public static void addPlanete() {

        System.out.println("Voici les planètes existants : ");
        System.out.println(daoP.findAll());
        System.out.println("Ajout d'une nouvelle planète :");
        String nom = saisieString("Saisir le nom de le planète");
        System.out.println(" Voici la liste de types de planètes possibles :");
        System.out.println(Arrays.toString(TypePlanete.values()));
        String typePlanete = saisieString("Saisir le type de planète");
        int x = saisieInt("Saisir la coordonnée x de la Planète");
        int y = saisieInt("Saisir la coordonnée y de la Planète");
        int z = saisieInt("Saisir la coordonnée z de la Planète");
        Coordonnees cood = new Coordonnees(x,y,z);
        Planete planete = new Planete(nom, TypePlanete.valueOf(typePlanete), cood);
        daoP.insert(planete);
        
    }
    public static void updatePlanete() {

        System.out.println("Voici les planetes existantes : ");
        System.out.println(daoP.findAll());
        int id = saisieInt("Saisir l'id de la planete à modifier");
        System.out.println("Modifier la planète "+id);
        String nom = saisieString("Saisir le nouveau nom de la planete");
        String type = saisieString("Saisir le type de planete (Gazeuse/Tellurique)");
        int x = saisieInt("Saisir la nouvelle coordonnée x de la Planète");
        int y = saisieInt("Saisir la nouvelle coordonnée y de la Planète");
        int z = saisieInt("Saisir la nouvelle coordonnée z de la Planète");
        Coordonnees cood = new Coordonnees(x,y,z);
        Planete planete = new Planete(id, nom, TypePlanete.valueOf(type), cood);
        daoP.update(planete);    

    }

    public static void deletePlanete() {
        
        
        System.out.println("Voici les planètes existantes : ");
        System.out.println(daoP.findAll());
        int id = saisieInt("Saisir l'id de la planète à supprimer");
        daoP.delete(id);        
        
        
    }

	/*public static void ecrirePlanetes() 
	{ 

		File Planetes1 = new File("planetes.txt");  //Création du fichier
		try(
				FileOutputStream fos = new FileOutputStream(Planetes1);  //Création du lien pour exportation de l'objet
				ObjectOutputStream oos = new ObjectOutputStream(fos);  //Création de l'objet pour la serialisation 
				) 
		{
			oos.writeObject(planetes);  //Serialisation de la liste parc dans le dossier monFichier

		}
		catch(Exception e) {e.printStackTrace();}  

	}

	public static void lirePlanetes() {
		File f = new File("planetes.txt");
		try(FileInputStream fis = new FileInputStream(f);ObjectInputStream ois=new ObjectInputStream(fis);)
		{
			planetes=(List<Planete>) ois.readObject();
		}catch(Exception e) {e.printStackTrace();}
	}*/


	//Groupe Trajet///
	public static void gestionTrajets() 
	{
		System.out.println("Gestion des trajets ");
		System.out.println("1- Trouver un trajet");
		System.out.println("2- Montrer l'ensemble des trajets");
		System.out.println("3- Ajouter un trajet");
		System.out.println("4- Modifier un trajet");
		System.out.println("5- Supprimer un trajet");
		//System.out.println("6- Sauvegarder un trajet");
		//System.out.println("7- Lire un trajet");
		System.out.println("8 - Retour menu admin" );

		int choix = saisieInt("");
		switch(choix) 
		{
		case 1 : int id= saisieInt("Quel trajet voulez-vous ?");System.out.println( findTrajet(id));break;
		case 2 : showTrajets();break;
		case 3 : addTrajet(); break;
		case 4 : updateTrajet();break;
		case 5 : deleteTrajet(); break;
		//case 6 : ecrireTrajets(); break;
		//case 7 : lireTrajets(); break;
		case 8 : menuAdmin(); break;
		}
		gestionTrajets();
	}

	public static Trajet findTrajet(int id) {
		return daoT.findById(id);
	}
	public static void showTrajets() 
	{
		for(Trajet t : daoT.findAll()) 
		{
			System.out.println(t);
		}
	}

	public static void addTrajet() 
	{

		System.out.println("Ajout d'un nouveau trajet :");
		String dateDepartString = saisieString("Saisir la date de depart (yyyy-mm-jj)");
		String heureDepartString = saisieString("Saisir l'heure de depart (hh:mm:ss)");
		LocalDate dateDepart=LocalDate.parse(dateDepartString);
		LocalTime heureDepart=LocalTime.parse(heureDepartString);
		System.out.println("Choisir la planete de départ : ");
		showPlanetes();
		int idDepart = saisieInt("id depart : ");
		int idArrivee = saisieInt("id arrivee");


		Planete PlaneteDepart = daoP.findById(idDepart);
		Planete PlaneteArrivee= daoP.findById(idArrivee);

		System.out.println("Choisir un des vaisseaux : ");
		showVaisseaux();
		int idVaisseau=saisieInt("id du vaisseau");

		Vaisseau vaisseau= daoV.findById(idVaisseau);

		Trajet trajet = new Trajet(dateDepart,heureDepart,PlaneteDepart,PlaneteArrivee,vaisseau);
		//insert bdd
		daoT.insert(trajet);

	}
	public static void updateTrajet() 
	{
		System.out.println("Voici les trajets existantes : ");
		showTrajets();
		int id = saisieInt("Saisir l'id du trajet à modifier");
		System.out.println("Modifier le trajet "+id);
		String dateDepartString = saisieString("Saisir la date de depart (yyyy-mm-jj)");
		String heureDepartString = saisieString("Saisir la date de depart (hh:mm:ss)");
		LocalDate dateDepart=LocalDate.parse(dateDepartString);
		LocalTime heureDepart=LocalTime.parse(heureDepartString);

		System.out.println("Choisir la planete de départ : ");
		showPlanetes();
		int idDepart = saisieInt("id depart : ");
		int idArrivee = saisieInt("id arrivee");


		Planete PlaneteDepart = daoP.findById(idDepart);
		Planete PlaneteArrivee= daoP.findById(idArrivee);

		System.out.println("Choisir un des vaisseaux : ");
		showVaisseaux();
		int idVaisseau=saisieInt("id du vaisseau");

		Vaisseau vaisseau= daoV.findById(idVaisseau);

		Trajet trajet = new Trajet(id,dateDepart,heureDepart,PlaneteDepart,PlaneteArrivee,vaisseau);
		daoT.update(trajet);
		//update bdd
	}
	public static void deleteTrajet() 
	{
		System.out.println("Voici les trajets existants : ");
		showTrajets();
		int id = saisieInt("Saisir l'id du trajet à supprimer");
		daoT.delete(id);
	}
	
	/*public static void ecrireTrajets()
	{
		File f = new File("fichierTrajets.txt");
		try(FileOutputStream fos = new FileOutputStream(f);ObjectOutputStream oos=new ObjectOutputStream(fos);)
		{
			oos.writeObject(trajets);
		}catch(Exception e) {e.printStackTrace();}
	}
	public static void lireTrajets()
	{
		File f = new File("fichierTrajets.txt");
		try(FileInputStream fis = new FileInputStream(f);ObjectInputStream ois=new ObjectInputStream(fis);)
		{
			trajets=(List<Trajet>) ois.readObject();
		}catch(Exception e) {e.printStackTrace();}
	}
	 */


	//Groupe Vaisseau//
	public static void gestionVaisseaux() {

		System.out.println("-----Gestion de vos vaisseaux-----");
		System.out.println("1 - Afficher mes vaisseaux");
		System.out.println("2 - Creer un nouveau vaisseau");
		System.out.println("3 - Modifier un vaisseau");
		System.out.println("4 - Supprimer un vaisseau");
		System.out.println("5 - Sauvegarder fichier vaisseaux");
		System.out.println("6 - Charger fichier vaisseaux");
		System.out.println("7 - Retour menu admin");
		int choix = saisieInt("Choisir un menu : ");
		switch(choix) 
		{
		case 1 : showVaisseaux();break;
		case 2 : addVaisseau();break;
		case 3 : updateVaisseau();break;
		case 4 : deleteVaisseau();break;
//		case 5 : ecrireVaisseaux();break;
//		case 6 : lireVaisseaux();break;
		case 7 : menuAdmin();break;
		}
		gestionVaisseaux();
	}

	
	public static void showVaisseaux() {

		for (Vaisseau e : daoV.findAll()) {System.out.println(e);}
	}
	public static void addVaisseau() {
		System.out.println("Ajout d'un vaisseau :");
		String nom = saisieString("Saisir le nom du vaisseau ");
		double vitesse = saisieDouble("Saisir la vitesse du vaisseau ");
		int capacite = saisieInt("Saisir la capacité du vaisseau ");
		double distance = saisieDouble("Saisir la distance max que peut parcourir le vaisseau ");
		Vaisseau v = new Vaisseau(nom, vitesse, capacite, distance);
		//insert bdd
		daoV.insert(v);

	}
	public static void updateVaisseau() {
		System.out.println("Voici les vaisseaux existants : ");
		showVaisseaux();
		int id = saisieInt("Saisir l'id du vaisseau à modifier");
		String nom = saisieString("Saisir le nom du vaisseau ");
		System.out.println("Modifier le vaisseau "+id);
		double vitesse = saisieDouble("Saisir la vitesse du vaisseau");
		int capacite = saisieInt("Saisir la capacite du vaisseau");
		double distance = saisieDouble("Saisir la distance du vaisseau");
		Vaisseau vaisseau = new Vaisseau(id,nom,vitesse,capacite,distance);
		daoV.update(vaisseau);
		//update en bdd
	}
	public static void deleteVaisseau() 
	{
		System.out.println("Voici les vaisseaux existants : ");
		showVaisseaux();
		int id = saisieInt("Saisir l'id du vaisseau à supprimer");
		daoV.delete(id);
		//delete en bdd
	}

/*
	public static void ecrireVaisseaux() 
	{
		File f = new File("vaisseaux.txt");
		try(FileOutputStream fos = new FileOutputStream(f);ObjectOutputStream oos=new ObjectOutputStream(fos);)
		{
			oos.writeObject(daoV);
		}catch(Exception e) {e.printStackTrace();}
	}
	public static void lireVaisseaux() {
		File f = new File("vaisseaux.txt");
		try(FileInputStream fis = new FileInputStream(f);ObjectInputStream ois=new ObjectInputStream(fis);)
		{
			vaisseaux=(List<DAOVaisseau>)ois.readObject();
		}catch(Exception e) {e.printStackTrace();}
	}
*/


}
