import { RecipeService } from './service/recipes.service';
import { Pizzeria } from './service/pizzeria.service';

const recipesService = new RecipeService();
const pizzeriaService = new Pizzeria(recipesService);

pizzeriaService.start(1000);