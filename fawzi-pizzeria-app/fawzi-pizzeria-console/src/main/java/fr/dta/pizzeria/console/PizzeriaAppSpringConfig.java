package fr.dta.pizzeria.console;

import fr.dta.pizzeria.console.ihm.action.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Fawzi NASSIM on 04/01/2017.
 */
@Configuration
@ComponentScan({"fr.dta.pizzeria.console", "fr.dta.pizzeria.dao"})
@EnableTransactionManagement
@EnableJpaRepositories("fr.dta.pizzeria.dao")
@EnableAspectJAutoProxy
public class PizzeriaAppSpringConfig {

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

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeria?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public Map<Integer, Action> getActionList(ApplicationContext context) {

        Map<Integer, Action> menu = new HashMap<Integer, Action>();

        menu.put(1, context.getBean(ListPizza.class));
        menu.put(2, context.getBean(AddPizza.class));
        menu.put(3, context.getBean(UpdatePizza.class));
        menu.put(4, context.getBean(DeletePizza.class));
        menu.put(5, context.getBean(ListPizzaFromCat.class));
        menu.put(6, context.getBean(ShowMostExpensivePizza.class));
        menu.put(7, context.getBean(MigrateFilesToDB.class));
        menu.put(8, context.getBean(ExitMenu.class));

        return menu;
    }
}
