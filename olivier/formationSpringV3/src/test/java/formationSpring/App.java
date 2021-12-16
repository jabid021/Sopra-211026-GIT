package formationSpring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.bean.Guitariste;
import formationSpring.bean.Musicien;
import formationSpring.config.AppConfig;

public class App {
	public static void main(String[] args) {
		// lancement spring
		// ClassPathXmlApplicationContext ctx=new
		// ClassPathXmlApplicationContext("application-context.xml");
		// spring qui instancie un guitare
		// spring me donne sa guitare
//		Guitare g=ctx.getBean("uneGuitare",Guitare.class);
//		System.out.println(g.getModele());

		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBean("guitariste",Musicien.class).jouer();		
		ctx.close();
//
//		List<String> list = Arrays.asList("hello", "world");
//
//		list.forEach((String s) -> {
//			System.out.println(s);
//		});

//		list.forEach(s -> {
//
//		});
		
//		list.forEach(System.out::println);
	}
}
