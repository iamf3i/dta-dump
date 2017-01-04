package fr.dta.pizzeria.console;

import fr.dta.pizzeria.console.ihm.MainMenu;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ResourceBundle;
import java.util.logging.Level;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        ResourceBundle bundle = ResourceBundle.getBundle("application");
        String daoConfig = bundle.getString("dao.impl");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(daoConfig, "application-config.xml")) {

            java.util.logging.Logger.getLogger("org.springframework").setLevel(Level.SEVERE);
            context.getBean(MainMenu.class).run();

        }
	}
}
