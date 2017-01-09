package fr.dta.pizzeria.dao.ingredient;

import fr.dta.pizzeria.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Fawzi NASSIM on 09/01/2017.
 */
@Qualifier("enabled")
@Repository
public class IngredientDaoRepo implements IngredientDao {

    @Autowired
    IngredientRepository dao;

    @Override
    public List<Ingredient> findAllIngredients() {

        return dao.findAll();
    }

    @Override
    public boolean saveNewIngredient(Ingredient ing) {

        dao.save(ing);
        return true;
    }

    @Override
    public boolean updateIngredient(String codeIng, Ingredient ing) {

        return false;
    }

    @Override
    public boolean deleteIngredient(String codeIng) {

        return false;
    }

    @Override
    public Ingredient getIngredientFromId(int id) {

        return dao.findOne(id);
    }

    @Override
    public Optional<Ingredient> getIngredientIdFromCode(String codeIng) {

        return null;
    }
}
