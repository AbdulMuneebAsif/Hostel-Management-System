package SuperClasses;

import Classes.FoodItems;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class SuperFoodItems {
    static private FoodItems[] foodItems=new FoodItems[999999];
   static private int count=0;
    static private int EditIndex=0;

   public static int getFoodItemCount()
   {
       return count;
   }
    public static void AddFoodItemCount()
    {
        count+=1;
    }
    public static void RemoveFoodItemCount()
    {
         count-=1;
    }

   public static void setFoodItemsName(String Name,int Index)
   {
       foodItems[Index].setItemName(Name);
   }
    public static void setFoodItemsPrice(String Price,int Index)
    {
        foodItems[Index].setPrice(Price);
    }

    public static String getFoodItemsName(int Index)
    {
        return foodItems[Index].getItemName();
    }
    public static String getFoodItemsPrice(int Index)
    {
        return foodItems[Index].getPrice();
    }

    public static void setFoodItemsDate(String Date,int Index)
    {
        foodItems[Index].setDate(Date);
    }
    public static String getFoodItemsDate(int Index)
    {
        return foodItems[Index].getDate();
    }


    public static void FoodItemsFill() {

        for (int i = 0; i < 99999; i++) {
            foodItems[i] = new FoodItems();

            foodItems[i].setItemName("");
            foodItems[i].setPrice("");
        }
    }

    public static void InsertMon(String Name,String Price,String Date)
    {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Get the "mydb" database
        MongoDatabase database = mongoClient.getDatabase("Hostel");

        // Get the "users" collection
        MongoCollection<Document> collection = database.getCollection("Mess");

        // Create a new document
        Document doc = new Document ("ID",count).append("name", Name).append("Price", Price).append("Date", Date);

        // Insert the document into the "users" collection
        collection.insertOne(doc);

        // Close the MongoClient
        mongoClient.close();

    }

}
