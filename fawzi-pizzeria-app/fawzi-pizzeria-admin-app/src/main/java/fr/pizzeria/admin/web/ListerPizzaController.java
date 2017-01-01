package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dta.pizzeria.model.Pizza;
import fr.pizzeria.admin.service.PizzaServiceEJB;

/**
 * Servlet implementation class ListerPizzaController
 */
@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    PizzaServiceEJB pizzaService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerPizzaController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Pizza> pizzas = pizzaService.findAllPizzas();
        request.setAttribute("pizzaList", pizzas);
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/listerPizzas.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
