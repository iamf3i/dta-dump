package fr.dta.pizzeria.console;

import fr.dta.pizzeria.dao.DaoFactory;
import fr.dta.pizzeria.dao.JDBCDaoFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

/**
 * Created by ETY5 on 04/01/2017.
 */
@Configuration
@ComponentScan("fr.dta.pizzeria.console")
public class PizzeriaAppSpringConfig {

    @Bean
    public DaoFactory getDao(){
        return new JDBCDaoFactory();
    }

    @Bean
    public Scanner getScanner(){
        return new Scanner(System.in);
    }
}
