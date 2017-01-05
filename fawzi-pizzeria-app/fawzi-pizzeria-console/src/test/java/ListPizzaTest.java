import fr.dta.pizzeria.console.PizzeriaAppSpringConfig;
import fr.dta.pizzeria.console.ihm.action.ListPizza;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ETY5 on 05/01/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzeriaAppSpringConfig.class)
public class ListPizzaTest {

    @Autowired
    ListPizza listPizza;

    @Test
    public void test() {
        Assert.assertEquals("1. Lister les pizzas", listPizza.getDescription());

    }
}
