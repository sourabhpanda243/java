package loginRegistration;
import java.sql.*;
public class regi_dao {
	public int register(user u) throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/userdtl";
		String username="root";
		String password="45605591";
		String query="insert into userTable values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, u.getName());
			st.setString(2, u.getSchool());
			st.setString(3, u.getReg_no());
			st.setString(4,u.getPass());
			int i=st.executeUpdate();
			return i;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
