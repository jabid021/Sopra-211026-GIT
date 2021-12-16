package test;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import config.AppConfig;
import exception.CompagnonException;
import model.Compagnon;
import repository.CompagnonRepository;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		CompagnonRepository compagnonRepo = ctx.getBean(CompagnonRepository.class);

		// compagnonRepo.save(new Compagnon("milou"));
		// compagnonRepo.saveAll(Arrays.asList(new Compagnon("lassi"), new
		// Compagnon("alcor")));

		// System.out.println(compagnonRepo.findAll());

//		Optional<Compagnon> opt = compagnonRepo.findById(1000000L);
//		if (opt.isPresent()) {
//			System.out.println(opt.get());
//		} else {
//			System.out.println("pas de resultat");
//		}
//
//		opt = compagnonRepo.findById(100L);
//		if (opt.isPresent()) {
//			System.out.println(opt.get());
//		} else {
//			System.out.println("pas de resultat");
//		}
//
//		Compagnon compagnon = compagnonRepo.findById(100L).orElse(null);
//		System.out.println("--------------");
//		compagnon = compagnonRepo.findById(100L).orElseThrow(CompagnonException::new);
//		System.out.println(compagnon);

//		compagnonRepo.findAll(Sort.by("nom")).forEach(System.out::println);

//		Pageable pageable = PageRequest.of(0, 2);
//		Page<Compagnon> page = compagnonRepo.findAll(pageable);
//		System.out.println("page" + page.getNumber() + ",elements:" + page.getContent());
//		page = compagnonRepo.findAll(page.nextOrLastPageable());
//		System.out.println("page" + page.getNumber() + ",elements:" + page.getContent());
//		page = compagnonRepo.findAll(page.nextOrLastPageable());
//		System.out.println("page" + page.getNumber() + ",elements:" + page.getContent());

		
		System.out.println(compagnonRepo.findByNomContaining("ix"));
		
		ctx.close();

	}
}
