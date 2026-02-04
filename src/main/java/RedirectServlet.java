import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect") // Changed to lowercase for easier typing
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String query = request.getParameter("query");

        // trim() removes extra spaces; isEmpty() checks if it's blank
        if (query != null && !query.trim().isEmpty()) {
            // This takes the user to a Google search results page
            response.sendRedirect("https://www.google.com/search?q=" + query);
        } else {
            // If no query is provided, just go to Google
            response.sendRedirect("https://www.google.com");
        }
    }
}