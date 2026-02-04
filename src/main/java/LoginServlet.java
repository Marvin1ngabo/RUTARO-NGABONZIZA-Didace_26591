import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// I changed this to "/login" to make the URL easier
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // 1. This handles the browser URL (GET)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Login Page</h2>");
        out.println("<form method='POST' action='login'>");
        out.println("Name: <input type='text' name='username'><br>");
        out.println("Password: <input type='password' name='password'><br>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    // 2. This handles the form submission (POST)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (pass != null && pass.length() < 8) {
            out.println("<h3>Hello " + user + ", your password is weak. Try a strong one.</h3>");
        } else {
            out.println("<h3>Welcome " + user + "</h3>");
        }
        out.println("<br><a href='login'>Back to Login</a>");
    }
}