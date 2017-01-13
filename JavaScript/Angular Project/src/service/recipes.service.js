export class RecipeService {

    constructor() {
        this.recipeList = null;
    }

    getRecipes() {

        if (this.recipeList !== null) return Promise.resolve(this.recipeList);

        return fetch('http://localhost:3000/recipes')
            .then(response => response.json())
            .then(recipes => {
                this.recipeList = recipes;
                return recipes;
            });
    }

    isRecipeCompliant(recipe, pizza) {

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
            .then(recipes => recipes.filter(recipe => recipe.name.includes(query)))
    }

    handleError(err) {
        alert('Une erreur est survenue')
    }

}
