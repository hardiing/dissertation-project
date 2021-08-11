import java.sql.*;

public class Connector {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root"; // set username/password/connection path
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/dissertation";
    
    public static void main(String[] args) {
        Connection conn = null; // new connection
        
        try {
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD); // connect with constant details
            System.out.println("Connected!"); // confirm connection
            String query = "SELECT * FROM schools WHERE MS_BAND = 'Yes' "
                            + "AND `COURSE ENROLLMENT` < 50;"; // query example
            Statement st = conn.createStatement(); // statement
            ResultSet rs = st.executeQuery(query); // get result set from query
            
            while(rs.next()) {
                String districtName = rs.getString("DISTRICTNAME"); // set types/etc for results
                
                System.out.format("%s\n", districtName); // print formatted results
            }
            
            st.close(); // close statement
        } catch (SQLException e) {
            System.err.println(e); // throw error if connection fails
        }
    }
    
}
