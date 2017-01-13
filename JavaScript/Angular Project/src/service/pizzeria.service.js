export class Pizzeria {

    constructor(recipeService) {
        this.pool = [];
        this.recipeService = recipeService;
    }

    start(time) {

        this.recipeService.getRecipesNames()
            .then((recipes) => {
                const intervalId = setInterval(() => {
                    let rand = recipes[Math.floor(Math.random() * recipes.length)];
                    this.pool.push(rand);
                    console.log('POOL: ', this.pool);

                    if (this.pool.length >= 10) {
                        console.log("GAME OVER");
                        clearInterval(intervalId);
                    }
                }, time);

            })
    }
}