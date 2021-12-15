package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		//lancement spring
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
		//spring qui instancie un guitare 
		//spring me donne sa guitare
//		Guitare g=ctx.getBean("uneGuitare",Guitare.class);
//		System.out.println(g.getModele());
		
		ctx.getBean(Musicien.class).jouer();
		
		
		ctx.close();
	}
}
