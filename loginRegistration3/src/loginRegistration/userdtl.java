package loginRegistration;

import java.sql.*;

public class userdtl {
	String url="jdbc:mysql://localhost:3306/userdtl";
	String username="root";
	String password="45605591";
	String query="select * from userTable where uname=? and pass=?";
	user u=new user();
	public user check(String uname,String pass)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				u.setName(rs.getNString("uname"));
				u.setSchool(rs.getString("school"));
				u.setReg_no(rs.getString("reg_no"));
				return u;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * u.setName("NA1"); u.setSchool("NA1"); u.setReg_no("NA1");
		 */
		return null;
	}	
}
