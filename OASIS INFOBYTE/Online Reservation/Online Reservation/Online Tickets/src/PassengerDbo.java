import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PassengerDbo {

    public static void createPassenger(Passenger passenger) throws SQLException {
        Connection con = DataBase.connect();
        String query = Query.insert;
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, passenger.getName());
        preparedStatement.setString(2, passenger.getAge());
        preparedStatement.setString(3, passenger.getGender());
        preparedStatement.setString(4, passenger.getFrom());
        preparedStatement.setString(5, passenger.getTo());
        preparedStatement.setString(6, passenger.getDate());
        preparedStatement.setString(7, passenger.getClas());
        preparedStatement.setString(8, passenger.getName2());
        preparedStatement.setString(9, passenger.getPnr());
        preparedStatement.execute();
        // System.out.println("data inserted successfully");

    }

    public static boolean isPNRExist(String pnr) throws SQLException {
        Connection con = DataBase.connect();
        String query = "SELECT * FROM passenger WHERE ppnr = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, pnr);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public static ArrayList<Passenger> readAllPassenger(Passenger passenger) throws SQLException {
        ArrayList<Passenger> plist = new ArrayList<Passenger>();
        Connection con = DataBase.connect();
        String query = Query.select;
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, passenger.getPnr());
        ResultSet rs = stmt.executeQuery();

        Statement statement = con.createStatement();
       
        while (rs.next()) {
            Passenger psn = new Passenger(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            plist.add(psn);
        }
        statement.close();
        return plist;
    }

    public static void deleteRow(Passenger passenger) {
        try {
            Connection con = DataBase.connect();
            String query = Query.delete;
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, passenger.getPnr());

            stmt.executeUpdate();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
