import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestMySql {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/ksh?serverTimezone=UTC&useSSL=false&verifyServerCertificate=false";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "test", "test");
 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ksh.testdb where phone='5678'");
 
            while (rs.next()) {
                System.out.println(String.format("%-20s %-20s", rs.getString(1), rs.getString(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (con != null)
                try { con.close(); } catch(Exception ex) { };
        }
	}

}
