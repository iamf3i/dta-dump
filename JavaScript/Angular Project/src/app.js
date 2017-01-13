import {
    RecipesService
} from './services/recipes.service';
import {
    PizzeriaService
} from './services/pizzeria.service';

const recipesService = new RecipesService();
const pizzeriaService = new PizzeriaService(recipesService);

// liste des recettes
recipesService.getRecipesNames()
    .then(recipes => {

        $('#recipes')
            .html(recipes.map(recipe => `<li data-recipe="${ recipe }">${ recipe.toUpperCase() }</li>`).join(''));


        $('#recipes li').on('click', function () {
            console.log($(this).data('recipe'));

            var array = pizzeriaService.pool;
            var i = array.indexOf($(this).data('recipe'));
            if (i != -1) {
                array.splice(i, 1);
            }
            //          $('#otherPizzas').html(this.pool.map(recipe => `<li data-recipe="${ recipe }">${ recipe.toUpperCase() }</li>`));
        });

    });

recipesService.getToppings().then(toppings => {
    console.log(toppings)
    $('#toppings')
        //       .html(toppings.map(topping => `<li data-topping="${ topping }">${ topping.toUpperCase() }</li>`).join(''));
        .html(toppings.map(topping => `<button type="button" data-topping="${ topping }" class="btn btn-warning">${ topping.toUpperCase() }</button>`).join(''));


    $('#toppings button').on('click', function () {
        console.log($(this).data('topping'));

        var array = pizzeriaService.pool;
        var i = array.indexOf($(this).data('topping'));
        if (i != -1) {
            array.splice(i, 1);
        }
        //          $('#otherPizzas').html(this.pool.map(recipe => `<li data-recipe="${ recipe }">${ recipe.toUpperCase() }</li>`));
    });
});



pizzeriaService.start(1000);