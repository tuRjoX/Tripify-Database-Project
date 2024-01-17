import java.sql.*;
public class Customer {
    public static void main(String[] args) {
        ResultSet rs;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms1", "root", "");
            Statement st = con.createStatement();
            rs = st.executeQuery("select * from customer");
            System.out.println("Customer Details : ");
            System.out.printf("%-5s | %-25s | %-20s | %-8s | %-11s | %-20s | %-8s | %-15s | %-30s\n", "CusID", "FName", "LName", "NID", "MOB", "EMAIL","HNO","STREET","CITY");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5s | %-25s | %-20s | %-8s | %-11s | %-20s | %-8s | %-15s | %-30s",
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getString(8), rs.getString(9));
                System.out.println();
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
