package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.Context;

import javax.sql.DataSource;

/**
 * Servlet implementation class DualTest
 */
public class DualTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DualTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context context = null;
		DataSource ds = null;
		Hashtable env = new Hashtable();
 
		env.put(Context.PROVIDER_URL, "t3://localhost:7001");
		env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		try {
			context = new InitialContext(env);

			ds = (DataSource)context.lookup("JNDI-MySQL");
 
			Connection conn = ds.getConnection();
 
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM test";
            ResultSet rs = stmt.executeQuery(query);
 
            while (rs.next()) {
            	response.getWriter().println("test: " + rs.getString("test") + " foobar: " + rs.getString("foobar") );
            }
            stmt.close();
            conn.close();
            context.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
