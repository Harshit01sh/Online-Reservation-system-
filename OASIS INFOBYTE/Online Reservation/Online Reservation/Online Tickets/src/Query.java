public class Query {
    static String insert = "INSERT INTO passenger(pname, page, pgender, pfrom, pto, pdate, pclas, pname2, ppnr) VALUES (?,?,?,?,?,?,?,?,?)";
    static String select = "SELECT * FROM passenger WHERE ppnr = ?";
    static String delete = "DELETE FROM passenger WHERE ppnr = ?";

}
