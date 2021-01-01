import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Derby {
    private final String DbUrl= "jdbc:derby:./db/db";
   /// private static Derby connectToDb = new Derby();
    //Derby(){
      //  Properties property = new Properties();
       /// property.put("create", "true");
    //    property.put("user", "book");
      //  property.put("password", "psw");

        //try {
         //   Connection connect = DriverManager.getConnection(DbUrl, property);
           // if (connect != null) System.out.println("Successfully connected to database.");

        //} catch (SQLException exception) {
          //  exception.printStackTrace();
        //}
   // }

    public static void main(String[] args) throws Exception{
        Properties property = new Properties();
       // property.put("create", "true");
///        property.put("AddressID", "AddressID");
        Connection connect ;
        //= DriverManager.getConnection("jdbc:derby:./db/addressbook; create=true", "user", "pass");
       // if (connect != null) System.out.println("Successfully connected to database.");
        //PreparedStatement getAllStart= connect.prepareStatement("SELECT * FROM Addresses");
       // PreparedStatement getStmt= connect.prepareStatement("SELECT * FROM Addresses WHERE AddressID=?");
        //PreparedStatement addStmt= connect.prepareStatement("INSERT INTO Addresses(FirstNAme, LastName, Email, PhoneNumber) VALUES(?,?,?,?)");
       // PreparedStatement delete= connect.prepareStatement("DELETE  FROM Addresses WHERE AddressID=?");

        try {
            connect = DriverManager.getConnection("jdbc:derby:./db/addressbook", "user", "pass");
          //  String com = "CREATE TABLE Addresses ( AddressID INT NOT NULL GENERATED ALWAYS AS IDENTITY, FirstName VARCHAR (15) NOT NULL, LastName VARCHAR (30) NOT NULL, Email VARCHAR (30) NOT NULL,  PhoneNumber VARCHAR (15) NOT NULL)";
          //  PreparedStatement st = connect.prepareStatement(com);
            //st.execute();
           // st.close();
           // System.out.println("OK!");
            PreparedStatement getAllStart= connect.prepareStatement("SELECT * FROM Addresses");
            PreparedStatement getStmt= connect.prepareStatement("SELECT * FROM Addresses WHERE AddressID=104");
            PreparedStatement delete= connect.prepareStatement("DELETE  FROM Addresses WHERE AddressID=?");

            ResultSet res=null;
       //     getStmt.setString(01, "AddressID");
            res=getAllStart.executeQuery();
            while (res.next()){
                System.out.println(res.getString("AddressID"));
                System.out.println(res.getString("LastName"));
                System.out.println(res.getString("Email"));
                System.out.println(res.getString("PhoneNumber"));

            }
            System.out.println("Enter details:\nFirst name: ");
            String firstName= new Scanner(System.in).nextLine();
            System.out.println("Last name: ");
            String lastName= new Scanner(System.in).nextLine();
            System.out.println("Email: ");
            String email= new Scanner(System.in).nextLine();
            System.out.println("Phone number: ");
            String phoneNumber= new Scanner(System.in).nextLine();
            PreparedStatement addStmt= connect.prepareStatement("INSERT INTO Addresses(FirstNAme, LastName, Email, PhoneNumber) VALUES('"+firstName+"','"+lastName+"','"+email+"','"+phoneNumber+"')");
            addStmt.execute();
            res=getAllStart.executeQuery();
            //while ()
            while (res.next()){
                System.out.println(res.getString("FirstName"));
                System.out.println(res.getString("LastName"));
                System.out.println(res.getString("Email"));
                System.out.println(res.getString("PhoneNumber"));

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
           // connect.close();
        }
        //ResultSet res=null;
       ////// getStmt.setString(1, "AddressID");
        //res=getStmt.executeQuery();
       // if(res.next()){
           // System.out.println(res.getString("AddressID"));

      //  }

    }
}