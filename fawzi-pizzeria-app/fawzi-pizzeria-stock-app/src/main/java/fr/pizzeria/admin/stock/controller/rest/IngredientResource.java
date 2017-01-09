package fr.pizzeria.admin.stock.controller.rest;

import fr.dta.pizzeria.dao.ingredient.IngredientDao;
import fr.dta.pizzeria.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Fawzi NASSIM on 09/01/2017.
 */
@RestController
@RequestMapping("/rest/ingredients")
public class IngredientResource {

    @Autowired
    @Qualifier("enabled")
    IngredientDao dao;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Ingredient> ingredientList() {

        // Generate some data
//        Ingredient test = new Ingredient();
//        test.setNom("aaa");
//        test.setPrix(2.2);
//        test.setQte(3);
//        Ingredient test2 = new Ingredient();
//        test2.setNom("bbb");
//        test2.setPrix(2.2);
//        test2.setQte(3);
//        Ingredient test3 = new Ingredient();
//        test3.setNom("ccc");
//        test3.setPrix(new Double(2.2));
//        test3.setQte(new Integer(3));
//
//        dao.saveNewIngredient(test);
//        dao.saveNewIngredient(test2);
//        dao.saveNewIngredient(test3);

        return dao.findAllIngredients();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Ingredient getIngredientById(@PathVariable int id) {

        return dao.getIngredientFromId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createIngredient(@RequestBody Ingredient ing) {

        dao.saveNewIngredient(ing);
    }
}
