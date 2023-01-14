import Graphics.About;
import Graphics.AdminGUI;
import Graphics.AssignRoomGUI;
import Graphics.ComplainGUI;
import SuperClasses.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import java.sql.*;

public class Main {


    public static void main(String[] args) {


//
       System.out.println("Hello");
       SuperCustomerData.cutomerinsertdata();
        SuperCustomerData.Getdata();
       SuperCustomerData.CustomerFill();
       SuperEmployeeData.EmployeeFill();
       SuperFoodItems.FoodItemsFill();
       SuperComplainData.ComplainFill();
        SuperCheckIn.CheckInFill();
////        new AssignRoomGUI().setVisible(true);
        new AdminGUI().setVisible(true);
////        new ComplainGUI().setVisible(true);
//
//
//
//
//                // Replace these values with your own
////                String url = "jdbc:oracle:thin:@localhost:1521:XE";
////                String username = "hostel";
////                String password = "admin";
////
////                String insertSql = "INSERT INTO TEST_TABLE (id) VALUES ("+40+")";
////
////                try (Connection connection = DriverManager.getConnection(url, username, password)) {
////                    // Create a statement and set the values for the placeholder parameters
////                    PreparedStatement statement = connection.prepareStatement(insertSql);
////
////
////                    // Execute the insert statement
////                    int rowsInserted = statement.executeUpdate();
////                    System.out.println(rowsInserted + " row(s) inserted");
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }




//                // Connect to the MongoDB server
//                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//
//                // Get the "mydb" database
//                MongoDatabase database = mongoClient.getDatabase("Hostel");
//
//                // Get the "users" collection
//                MongoCollection<Document> collection = database.getCollection("Mess");
//
//                // Create a new document
//                Document doc = new Document ("ID",0).append("name", "John Doe").append("age", 30).append("email", "johndoe@example.com");
//
//                // Insert the document into the "users" collection
//                collection.insertOne(doc);
//
//                // Close the MongoClient
//                mongoClient.close();
            }
        }


