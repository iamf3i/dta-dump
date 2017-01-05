import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.Pizza;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ETY5 on 05/01/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JTPLDaoTestConfig.class)
public class JTPLDaoTest {

    @Autowired
    PizzaDao jtpl;

    @Test
    public void test() throws PizzaException {

        List<Pizza> p = jtpl.findAllPizzas();

        for (Pizza pizza: p) {
            System.out.println(pizza);
        }

    }

    @Test
    public void testCreate() throws PizzaException {

        Pizza add = new  Pizza();

        add.setNom("SALUTE");
        add.setCode("POP");

        jtpl.saveNewPizza(add);

        List<Pizza> p = jtpl.findAllPizzas();

        for (Pizza pizza: p) {
            System.out.println(pizza);
        }

    }

    @Before
    public void enter() {
        System.out.println("ENTERING TEST --------------");
    }

    @After
    public void out() {
        System.out.println("EXIT TEST --------------");
    }
}
