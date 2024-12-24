package data_html_JDBC;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Test {
  public static void main(String[] args) {
	  Connection con = null;
      Statement st =null;
      ResultSet rs = null;
      FileOutputStream fos = null;
      try {
     	 Class.forName("oracle.jdbc.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Shivam");
			st = con.createStatement();
			rs = st.executeQuery("select * from EMP1");
			String data = "";
			data = data+"<html><body><table align='center' border='1'>";
			data = data+"<tr><th>ENO</th><th>ENAME</th><th>ESAL</th><th>EADDR</th></tr>";
			while(rs.next()) {
				data = data+"<tr>";
				data = data+"<td>"+rs.getInt("ENO")+"</td>";
				data = data+"<td>"+rs.getString("ENAME")+"</td>";
				data = data+"<td>"+rs.getFloat("ESAL")+"</td>";
				data = data+"<td>"+rs.getString("EADDR")+"</td>";
				data = data+"</tr>";
			}
			data =data+"</table></body></html>";
			fos = new FileOutputStream("G:/advJava/emp.html");
			byte [] b = data.getBytes();
			fos.write(b);
			System.out.println("Data are Proivded Success fully to target file");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				con.close();// close the Connection  resource is here
				fos.close();// CLose the file resource here
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
       
  }
}
