package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import dao.IDAOCompagnon;
import model.Arme;
import model.Compagnon;
import model.Personnage;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOCompagnon daoCompagnon = ctx.getBean(IDAOCompagnon.class);
		Compagnon compagnon = new Compagnon("toto");
		System.out.println(compagnon.getId());
		daoCompagnon.findById(100L);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		// daoCompagnon.save(new Compagnon("toto"));
		// System.out.println(daoCompagnon.findAll());
		ctx.close();

	}
}
