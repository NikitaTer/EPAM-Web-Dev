package by.epam.controller;

import by.epam.action.command.ActionCommand;
import by.epam.action.command.CommandFactory;
import by.epam.action.manager.ConfigurationManager;
import by.epam.action.manager.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.PortableInterceptor.ACTIVE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class ControlServlet extends HttpServlet {

    private final static Logger logger = LogManager.getLogger();

    public ControlServlet() {
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        ActionCommand command = CommandFactory.defineCommand(request);
        page = command.execute(request);

        try {

            if (page!=null) {

                switch ((String) request.getAttribute("action")) {

                    case "forward":
                        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
                        dispatcher.forward(request, response);
                        break;

                    case "redirect":
                        response.sendRedirect(request.getContextPath() + page);
                        break;

                    case "nothing":
                        break;

                    default:
                        page = ConfigurationManager.getProperty("path.page.error");
                        request.getSession().setAttribute("errorMessage", MessageManager.getProperty("message.error.nullPage"));
                        response.sendRedirect(request.getContextPath() + page);
                        break;
                }

            } else {
                page = ConfigurationManager.getProperty("path.page.error");
                request.getSession().setAttribute("errorMessage", MessageManager.getProperty("message.error.nullPage"));
                response.sendRedirect(request.getContextPath() + page);
            }

        } catch (ServletException | IOException e) {
            logger.error(e.getMessage());
        }
    }
}
