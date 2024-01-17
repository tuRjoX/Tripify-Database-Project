import java.sql.*;
public class Transport {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms1", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from transport");
            System.out.println("Transport Details : ");
            System.out.printf("%-7s | %-30s | %-20s | %-15s | %-15s | %-15s\n", "TID", "COST", "Departure Location", "Arrival Location", "Departure Time", "Arrival Time");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-7s | %-30s | %-20s | %-15s | %-15s | %-15s\n",
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
