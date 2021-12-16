package formationSpring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import formationSpring.bean.Musicien;

@Component
@Aspect
public class Spectateur {
	
	@Autowired
	@Qualifier("pianiste")
	private Musicien pianiste;

	@Pointcut("execution(void formationSpring.bean.Guitariste.jouer())")
	public void jouerGuitariste() {

	}
	@Pointcut("execution(void formationSpring.bean.Musicien.jouer())")
	public void jouerMusicien() {
		
	}
	
	@Pointcut("execution(void formationSpring.bean.Pianiste.jouer())")
	public void jouerPianiste() {
		
	}

	@Pointcut("execution(String *.*.Guitariste.getInfo())")
	public void pointcutGetInfo() {

	}

	@AfterReturning(pointcut = "pointcutGetInfo()", returning = "resultat")
	public void afficherInfoRecupere(String resultat) {
		System.out.println("valeur recu:" + resultat);
	}

	@Before("jouerGuitariste()")
	public void publicInstallation() {
		System.out.println("les spectateurs s'installent");
	}

	@AfterReturning(pointcut = "jouerMusicien()")
	public void applaudir() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "jouerMusicien()")
	public void pasContent() {
		System.out.println("bouhhhhh");
	}

	@After("jouerGuitariste()")
	public void demandeAuPianisteDeJouer() {
		pianiste.jouer();
	}

	
	@After("jouerPianiste()")
	public void depart() {
		System.out.println("les spectateurs quittent la salle");
	}
//	@Around("pointcut()")
//	public void around(ProceedingJoinPoint pJP) throws Throwable {
//
//		System.out.println("avant le proceed");
//		// execution la methode de depart(jouer)
//			//try {
//			pJP.proceed();
//			//}catch(Throwable t) {
//				
//			//}
//		
//		System.out.println("apres proceed");
//	}
}
