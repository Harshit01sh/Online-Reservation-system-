import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;
public class Railway {
    public String user_id;
    private String password;
    String name = "", age = "", gender = "", from = "", to = "", date = "", Class = "", train_no = "", train_nm = "";
    String pnr;
    Scanner sc = new Scanner(System.in);
    public void login() throws SQLException {
        System.out.println("-----------------------------------------");
        System.out.println("Welcome To Online Ticket Booking !");
        System.out.println("-----------------------------------------");
        System.out.println("Enter Your User Name ");
        user_id = sc.next();

        System.out.println("ENter Password");
        password = sc.next();
        if (user_id.equals("RAM") && password.equals("SITA")) {
            System.out.println("!!!!Login Successfully!!!!!!");
            choose();
        } else {
            System.out.println("Invalid Data , Retry");
            login();
        }
    }

    public void choose() throws SQLException {
        System.out.println("For Reservation Press 1 \nFor Cancellation Press 0");
        int ch = sc.nextInt();
        sc.nextLine();
        reservation(ch);
    }

    public void reservation(int choice) throws SQLException {
        if (choice == 1) {
            System.out.println("Enter Passenger Full Name  ");
            name = sc.nextLine();
            System.out.println("Enter Age ");
            age = sc.nextLine();
            System.out.println("Select Gender : Male/Female/Other ");
            gender = sc.nextLine();
            System.out.println("Enter From Station Name ");
            from = sc.nextLine();
            System.out.println("Enter To Destination Station Name  ");
            to = sc.nextLine();
            System.out.println("Enter Date Of Journey  ");
            date = sc.nextLine();
            System.out.println("Choose Class Type : Sleeper/2S/3A/2A ");
            Class = sc.nextLine();
            System.out.println("Available Trains : 145122/20503/321876:\n Choose Train Number ");
            train_no = sc.nextLine();
            train_nm = "Garib Rath";
            Random random = new Random();
            int k = random.nextInt(900000) + 100000;
            pnr = Integer.toString(k);
            Passenger p = new Passenger(name, age, gender, from, to, date, Class, train_no, pnr);
            PassengerDbo.createPassenger(p);
            System.out.println("----------------------------------------------");
            System.out.println("     Ticket Booked Successfully     ");
            System.out.println("----------------------------------------------");
            System.out.print("PNR:" + pnr + "\t" + "Name:" + name + "\t" + "Age:" + age + "\t" + "Gender:" + gender + "\t"
                    + "From " + from + "\t" + "To " + to);
            System.out.println("\nDate Of Journey: " + date + "\t" + "Class Type:" + Class + " " + "Train: "
                    + train_no + "\t" + train_nm);
            System.out.println("*****_______________------_______________*****");

        }

        else if (choice == 0) {
            System.out.println("Enter PNR Number!");
            pnr = sc.nextLine();
            boolean isExist = PassengerDbo.isPNRExist(pnr);
            //System.out.println(isExist);
            if (isExist == true) {
                System.out.println("Are You Sure Wants To Cancel The Ticket?: Yes/No");
                String dc = sc.nextLine();
                if (dc.equalsIgnoreCase("Yes")) {
                    Passenger g = new Passenger(name, age, gender, from, to, date, Class, train_no, pnr);
                    ArrayList<Passenger> List = PassengerDbo.readAllPassenger(g);
                    for (Passenger passenger : List) {
                        System.out.println(passenger);
                    }
                    PassengerDbo.deleteRow(g);
                    System.out.println("X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*");
                    System.out.println("        Tickets Cancelled Successfully          ");
                    System.out.println("******************************************************************");
                }
            } else {
                System.out.println("Wrong PNR! Retry");
                reservation(0);
            }
        }

        else {
            System.out.println("Wrong Choice");
        }

    }

    public static void main(String args[]) throws SQLException {
        Railway t = new Railway();
        t.login();
    }
}
