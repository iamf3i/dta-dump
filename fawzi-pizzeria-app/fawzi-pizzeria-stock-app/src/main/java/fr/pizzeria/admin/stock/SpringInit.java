package fr.pizzeria.admin.stock;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Fawzi NASSIM on 09/01/2017.
 */
public class SpringInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(PizzeriaSpringConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
        dispatcher.setLoadOnStartup(1);

        dispatcher.addMapping("/mvc/*");
        servletContext.addListener(new ContextLoaderListener(webContext));
    }
}
