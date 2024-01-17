import java.sql.*;
public class Hotel {
    public static void main(String[] args) {
        ResultSet rs;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms1", "root", "");
            Statement st = con.createStatement();
            rs = st.executeQuery("select * from hotel");
            System.out.println("Hotel Details : ");
            System.out.printf("%-5s | %-30s | %-20s | %-15s | %-20s | %-6s\n", "HID", "Name", "Location", "Price", "Contact", "License No");
            System.out.println("------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5s | %-30s | %-20s | %-15s | %-20s | %-6s\n",
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
