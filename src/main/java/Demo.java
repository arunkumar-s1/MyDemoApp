public class Demo {
	public static void main(String args[]) throws Exception {
		Class.forName ("org.h2.Driver"); 
//		Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa",""); 
		System.out.println("Database created");
//		<ResourceLink name="jdbc/myDb1"
//	             global="jdbc/myDb"
//	              type="javax.sql.DataSource" />
		
	}
}
