package formationSpring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Spectateur {

	@Pointcut("execution(void formationSpring.bean.Guitariste.jouer())")
	public void pointcut() {

	}

	@Pointcut("execution(String *.*.Guitariste.getInfo())")
	public void pointcutGetInfo() {

	}

	@AfterReturning(pointcut = "pointcutGetInfo()", returning = "resultat")
	public void afficherInfoRecupere(String resultat) {
		System.out.println("valeur recu:" + resultat);
	}

	@Before("pointcut()")
	public void eteindreTelephone() {
		System.out.println("les spectateurs coupent leurs telephone");
	}

	@AfterReturning(pointcut = "pointcut()")
	public void applaudir() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "pointcut()")
	public void pasContent() {
		System.out.println("bouhhhhh");
	}

	@After("pointcut()")
	public void partir() {
		System.out.println("les spectateurs partent");
	}

	@Around("pointcut()")
	public void around(ProceedingJoinPoint pJP) throws Throwable {

		System.out.println("avant le proceed");
		// execution la methode de depart(jouer)
		if (false) {
			pJP.proceed();
		}
		System.out.println("apres proceed");
	}
}
