package config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "dao" })
@EnableTransactionManagement
public class AppConfig {

	// pool de connection à la base
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver"); driver MySql
		// dataSource.setUrl("jdbc:mysql://localhost:3306/middle_earth?serverTimezone=Europe/Paris");
		// dataSource.setUsername("root");
		// dataSource.setPassword("");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/middle_earth");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		// dataSource.setMaxTotal(10);
		// dataSource.setInitialSize(3);
		return dataSource;
	}

	// EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("model");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(hibernateProperties());
		return emf;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		// properties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
		return transactionManager;
	}
}
