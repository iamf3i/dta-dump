export class RecipesService {
    constructor(){
        this.recipes = null;
    }

    // return Promise<[recipe]>
    getRecipes() {
        if (this.recipes) return Promise.resolve(this.recipes);

        return fetch('http://localhost:3000/recipes')
        .then(response => response.json())
        .then(recipes => this.recipes = recipes);
    }

    isRecipeCompliant(recipe, pizza) {
        if (recipe.toppings.length !== pizza.toppings.length) return false;

        return pizza.toppings.reduce((acc, topping) =>
            acc 
            && recipe.toppings.indexOf(topping) !== -1 
            && pizza.toppings.indexOf(topping) === pizza.toppings.lastIndexOf(topping)
            , true);
    }

    getPizzaRecipeName (pizza) {
        return this.getRecipes()
        .then(recipes => {
            return recipes.reduce(
                (acc, recipe) => 
                acc 
                || (this.isRecipeCompliant(recipe, pizza) ? recipe.name : false), 
            false);
        })
    }

    getRecipe(name) {
        return this.getRecipes()
        .then(recipes => recipes.find(recipe => recipe.name === name))
        .catch(this.handleError)
    }

    getRecipesNames() {
        return this.getRecipes()
        .then(recipes => recipes.map(recipe => recipe.name))
        .catch(this.handleError)
    }

    queryRecipes(query) {
        return this.getRecipes()
        .then(recipes =>
            recipes
            .filter(recipe => 
                recipe.name.toLowerCase().includes(query.toLowerCase())
            )
        );
    }

    handleError(err) {
        alert('Une erreur est survenue')
    }
}