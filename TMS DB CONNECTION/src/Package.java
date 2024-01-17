import java.sql.*;
public class Package {
    public static void main(String[] args) {
        ResultSet rs;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms1", "root", "");
            Statement st = con.createStatement();
            rs = st.executeQuery("select * from package");
            System.out.println("Package Details : ");
            System.out.printf("%-5s | %-30s | %-20s | %-8s \n", "PID", "Name", "Destination", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5s | %-30s | %-20s | %-8s \n",
                        rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " "+ rs.getString(6));
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
