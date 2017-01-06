import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Fawzi NASSIM on 05/01/2017.
 */
@Configuration
@ComponentScan("fr.dta.pizzeria.dao")
@EnableTransactionManagement
public class DaoTestConfig {

    @Bean
    public PlatformTransactionManager txManager() {
        return new JpaTransactionManager();
    }

    public DataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeria?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public DataSource getAnotherDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("redump.sql")
                .build();

        return db;
    }

    @Bean
    public LocalEntityManagerFactoryBean getEMF() {

        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();

        emf.setPersistenceUnitName("JPAUNIT");
        return emf;
    }
}
