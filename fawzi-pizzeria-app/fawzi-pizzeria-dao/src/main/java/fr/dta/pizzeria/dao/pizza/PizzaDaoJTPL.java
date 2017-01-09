package fr.dta.pizzeria.dao.pizza;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by ETY5 on 05/01/2017.
 */
public class PizzaDaoJTPL implements PizzaDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PizzaDaoJTPL(DataSource datasource) {

        this.jdbcTemplate = new JdbcTemplate(datasource);

    }

    @Override
    public List<Pizza> findAllPizzas() throws PizzaException{

        String sql = "SELECT * FROM pizza";

        return this.jdbcTemplate.query(sql, new PizzaMapper());
    }

    @Override
    public boolean saveNewPizza(Pizza pizza) throws PizzaException {
        String sql = "INSERT INTO PIZZA (ID,NOM,CODE) VALUES(?,?,?)";

        this.jdbcTemplate.update(sql, pizza.getId(), pizza.getNom(), pizza.getCode());
        return true;
    }

    @Override
    public boolean updatePizza(String codePizza, Pizza pizza) throws PizzaException {
        return false;
    }

    @Override
    public boolean deletePizza(String codePizza) throws PizzaException {
        return false;
    }

    @Override
    public Optional<Pizza> getPizzaIdFromCode(String codePizza) {
        return null;
    }

    public class PizzaMapper implements RowMapper<Pizza> {

        public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {

            Pizza p = new Pizza();
            p.setId(rs.getInt("id"));
            p.setNom(rs.getString("nom"));
            p.setCode(rs.getString("code"));
            p.setPrix(rs.getDouble("prix"));
            return p;
        }

    }
}
