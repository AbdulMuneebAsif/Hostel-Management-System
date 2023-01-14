package SuperClasses;


import Classes.Check;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class SuperCheckIn {
    static private Check[] CheckList =new Check[999999];
    static private int count=0;
    static private int EditIndex=0;

    public static int getCheckInIndex()
    {
        return count;
    }
    public static void CheckinCountADD()
    {
        count+=1;
    }
    public static void CheckinCountRemove()
    {
        count-=1;
    }

    public static void setName(String Name, int Index)
    {
        CheckList[Index].setName(Name);
    }
    public static void setStatus(String Status, int Index)
    {
        CheckList[Index].setStatusl(Status);
    }

    public static String getName(int Index)
    {
        return CheckList[Index].getName();
    }
    public static String getStatusl(int Index)
    {
        return CheckList[Index].getStatusl();
    }


    public static void CheckInFill()
    {

        for(int i=0;i<999999;i++) {
            CheckList[i] = new Check();
            CheckList[i].setName("");
            CheckList[i].setStatusl("");
        }
    }

    public static void CheckInsert(int id,String Name, String Status)
    {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Get the "mydb" database
        MongoDatabase database = mongoClient.getDatabase("Hostel");

        // Get the "users" collection
        MongoCollection<Document> collection = database.getCollection("Check");

        // Create a new document
        Document doc = new Document ("ID",id).append("name", Name).append("Status", Status);

        // Insert the document into the "users" collection
        collection.insertOne(doc);

        // Close the MongoClient
        mongoClient.close();

    }
}
