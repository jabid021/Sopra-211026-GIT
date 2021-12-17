package test;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import config.AppConfig;
import exception.CompagnonException;
import main.AppSpring;
import model.Compagnon;
import repository.ArmeRepository;
import repository.CompagnonRepository;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();
	}

}
