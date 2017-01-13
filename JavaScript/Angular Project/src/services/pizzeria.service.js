export class PizzeriaService {

    constructor (recipesService) {
        this.pool = [];
        this.recipesService = recipesService;
    }

    start (time) {
        // every time seconds add a new recipe name to the pool
        this.recipesService.getRecipesNames()
        .then(recipesNames => {
            const intervalId = setInterval(() => {
                const index = Math.floor(Math.random() * recipesNames.length);
                const recipeName = recipesNames[index];
                this.pool.push(recipeName);

                $('#otherPizzas').html(this.pool.map(recipe => `<li data-recipe="${ recipe }">${ recipe.toUpperCase() }</li>`));

                if (this.pool.length >= 10) {
                    console.log('GAME OVER');
                    clearInterval(intervalId);
                }
            }, time);

        })
    }

    // { id: 1, toppings: ['', ''] }
    sendPizza (pizzaName) {
        const idx = this.pool.indexOf(pizzaName);
        if (idx !== -1) this.pool.splice(idx, 1);
    }

}