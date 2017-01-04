package fr.dta.pizzeria.console;

import fr.dta.pizzeria.console.ihm.MainMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Level;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {

            java.util.logging.Logger.getLogger("org.springframework").setLevel(Level.SEVERE);

            context.getBean(MainMenu.class).run();

        }
	}
}
