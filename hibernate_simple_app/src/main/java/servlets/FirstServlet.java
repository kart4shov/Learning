package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

/**
 *
 *
 */
@WebServlet("/")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        request.setAttribute("name", "vasya");
        writer.write("fdf");
        getServletContext().getRequestDispatcher("/views/simplePage.jsp").forward(request, response);
        String str = (String)request.getAttribute("name");
        writer.close();
    }
}
