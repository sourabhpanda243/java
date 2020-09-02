package employeeDetail;

import java.sql.*;
import java.util.*;


public class Employee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/empdb";
		String username="root";
		String password="45605591";
		Connection con = DriverManager.getConnection(url,username,password);
		String query;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int id,age;
		String name;
		PreparedStatement st=null;
		int n=0;
		while(n<1)
		{
			System.out.println("What do you want to do with the database ?");
			System.out.println("\n 1:insert employee \n 2:update employee \n 3:delete employee \n 4:get all employee \n 5:find employee \n 6:exit");
			int a=sc.nextInt();
			if(a==1)
			{
				System.out.println("Enter employee id, employee name,employee age");
				query="insert into employee values(?,?,?)";
				st=con.prepareStatement(query);
				System.out.println("enter id");
				id=sc.nextInt();
				sc.nextLine();
				System.out.println("enter name");
				name=sc.nextLine();
				System.out.println("enter age");
				age=sc.nextInt();
				st.setInt(1, id);
				st.setString(2, name);
				st.setInt(3, age);
				int i=st.executeUpdate();  
				System.out.println(i+" records inserted");  
			}
			else if(a==2)
			{
				System.out.println("\n which employee detail you want to update ? Enter his id .");
				id=sc.nextInt();
				System.out.println("what do you want to update ? \n 1:id \n 2:name \n 3:age");
				int temp=sc.nextInt();
				if(temp==1)
				{
					query="update employee set id=? where id=?";
					st=con.prepareStatement(query);
					System.out.println("\n enter the updated id : ");
					int updid=sc.nextInt();
					st.setInt(1, updid);
					st.setInt(2, id);
				}
				else if(temp==2)
				{
					sc.nextLine();
					query="update employee set Emname= ? where id= ?";
					st=con.prepareStatement(query);
					System.out.println("enter the name : ");
					name=sc.nextLine();
					st.setString(1,name);// 1 means Emname(as it comes first in query),2 means id
					st.setInt(2, id);
				}
				else if(temp==3)
				{
					query="UPDATE employee set EmpAge=? WHERE id=?";
					st=con.prepareStatement(query);
					System.out.println("\n enter the age : ");
					age=sc.nextInt();
					st.setInt(1, age);
					st.setInt(2, id);
				}
				int i=st.executeUpdate();  
				System.out.println(i+" records update");
			}
			else if(a==3)
			{
				System.out.println("\n which employee detail you want to delete ? Enter his id .");
				id=sc.nextInt();
				st=con.prepareStatement("delete from employee where id=?");
				st.setInt(1, id);
				int i=st.executeUpdate();  
				System.out.println(i+" records deleted");
			}
			else if(a==4)
			{
				st=con.prepareStatement("select * from employee");
				ResultSet rs=st.executeQuery();
				while(rs.next())
					System.out.println("Employee id = "+rs.getInt(1)+" Employee name "+rs.getNString(2)+" Employee age "+rs.getInt(3));
			}
			else if(a==5)
			{
				System.out.println("\n which employee detail you want to find ? Enter his id .");
				id=sc.nextInt();
				sc.nextLine();
				st=con.prepareStatement("select * from employee");
				ResultSet rs=st.executeQuery();
				while(rs.next())
					if(rs.getInt(1)==id) 
					{
						System.out.println("Employee id = "+rs.getInt(1)+" Employee name "+rs.getNString(2)+" Employee age "+rs.getInt(3));
						break;
					}
			}
			else if(a==6) n=1;
		}
		System.out.println("thank you for your patience");
		st.close();									
		con.close();
	}
}
