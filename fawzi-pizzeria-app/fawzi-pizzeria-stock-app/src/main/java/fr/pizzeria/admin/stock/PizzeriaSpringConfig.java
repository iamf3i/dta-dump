package fr.pizzeria.admin.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Fawzi NASSIM on 09/01/2017.
 */
@Configuration
@ComponentScan({"fr.pizzeria.admin.stock", "fr.dta.pizzeria.dao"})
@EnableTransactionManagement
@EnableJpaRepositories("fr.dta.pizzeria.dao")
@EnableAspectJAutoProxy
@EnableWebMvc
public class PizzeriaSpringConfig {

    @Bean
    public PlatformTransactionManager transactionManager() {

        return new JpaTransactionManager();
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {

        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("JPAUNIT");
        return emf;
    }
}