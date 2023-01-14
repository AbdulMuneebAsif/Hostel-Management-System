package SuperClasses;

import Classes.CustomerData;
import java.sql.*;

public class SuperCustomerData {

    private static CustomerData customerData[] = new CustomerData[9999];
    private static int NumberofCustomer = 0;

    private static int EditeNo = 0;

    public static int getEditeNo() {
        return EditeNo;
    }

    public static void setEditeNo(int editeNo) {
        EditeNo = editeNo;
    }

    public static int getcounter() {
        return NumberofCustomer;
    }

    public static void AddCustomer() {
        NumberofCustomer += 1;
    }

    public static void DeleteCustomer() {
        NumberofCustomer -= 1;
    }

    public static void setCustomerName(String Name, int Index) {
        customerData[Index].setName(Name);
    }

    public static String getCustomerName(int Index) {
        return customerData[Index].getName();
    }

    public static void setCustomerFatherName(String FatherName, int Index) {
        customerData[Index].setFatherName(FatherName);
    }

    public static String getCustomerFatherName(int Index) {
        return customerData[Index].getFatherName();
    }

    public static void setCustomerAddress(String Address, int Index) {
        customerData[Index].setAddress(Address);
    }

    public static String getCustomerAddress(int Index) {
        return customerData[Index].getAddress();
    }

    public static void setCustomerCNICNo(String CNICNo, int Index) {
        customerData[Index].setCNICNo(CNICNo);
    }

    public static String getCustomerCNICNo(int Index) {
        return customerData[Index].getCNICNo();
    }

    public static void setCustomerMobileNo(String MobileNo, int Index) {
        customerData[Index].setMobileNo(MobileNo);
    }

    public static String getCustomerMobileNo(int Index) {
        return customerData[Index].getMobileNo();
    }

    public static void setCustomerEmailAddress(String EmailAddress, int Index) {
        customerData[Index].setEmailAddress(EmailAddress);
    }

    public static String getCustomerEmailAddress(int Index) {
        return customerData[Index].getEmailAddress();
    }

    public static String getCustomerRoomID(int Index) {
        return customerData[Index].getRoomID();
    }

    public static String getCustomerRoomPrice(int Index) {
        return customerData[Index].getRoomPrice();
    }

    public static String getCustomerRoomStartDate(int Index) {
        return customerData[Index].getRoomStartDate();
    }

    public static String getCustomerRoomEndDate(int Index) {
        return customerData[Index].getRoomEndDate();
    }

    public static void setCustomerRoomID(String ID, int Index) {
        customerData[Index].setRoomID(ID);
    }

    public static void setCustomerRoomPrice(String Price, int Index) {
        customerData[Index].setRoomPrice(Price);
    }

    public static void setCustomerRoomStartDate(String Date, int Index) {
        customerData[Index].setRoomStartDate(Date);
    }

    public static void setCustomerRoomEndDate(String Date, int Index) {
        customerData[Index].setRoomEndDate(Date);
    }

    public static void DeleteCustomer(int Index) {
        customerData[Index].setName("");
        customerData[Index].setFatherName("");
        customerData[Index].setCNICNo("");
        customerData[Index].setAddress("");
        customerData[Index].setEmailAddress("");
        customerData[Index].setRoomID("");
        customerData[Index].setRoomPrice("");
        customerData[Index].setRoomStartDate("");
        customerData[Index].setRoomEndDate("");
        int j = 0;
        // Replace these values with your own
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hostel";
        String password = "admin";

        String DeleteSql = "delete from customer";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a statement and set the value for the placeholder parameter
            PreparedStatement statement = connection.prepareStatement(DeleteSql);
            // Execute the select statement
            int rowsDeleted = statement.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = Index; i < NumberofCustomer; i++) {

            customerData[i].setName(getCustomerName(i + 1));
            customerData[i].setFatherName(getCustomerFatherName(i + 1));
            customerData[i].setCNICNo(getCustomerCNICNo(i + 1));
            customerData[i].setAddress(getCustomerAddress(i + 1));
            customerData[i].setEmailAddress(getCustomerEmailAddress(i + 1));
            customerData[i].setRoomID(getCustomerRoomID(i + 1));
            customerData[i].setRoomPrice(getCustomerRoomPrice(i + 1));
            customerData[i].setRoomStartDate(getCustomerRoomStartDate(i + 1));
            customerData[i].setRoomEndDate(getCustomerRoomEndDate(i + 1));
        }

        DeleteCustomer();
        for (int i = 0; i < getcounter(); i++) {
            String insertSql = "INSERT INTO customer(" +
                    "C_ID, " +
                    "c_name, " +
                    "father_name, " +
                    "cnic_no, " +
                    "mobile_no, " +
                    "email, " +
                    "address, " +
                    "room_id, " +
                    "price, " +
                    "start_date, " +
                    "end_date) " +
                    "VALUES ("
                    + i + "," + "'" + getCustomerName(i) + "'" + "," + "'" + getCustomerFatherName(i) + "'" + "," + "'" + getCustomerCNICNo(i) + "'" + "," + "'" + getCustomerMobileNo(i) + "'" + "," + "'" + getCustomerEmailAddress(i) + "'" + "," + "'" + getCustomerAddress(i) + "'" + "," + "'" + getCustomerRoomID(i) + "'" + "," + "'" + getCustomerRoomPrice(i) + "'" + "," + "'" + getCustomerRoomStartDate(i) + "'" + "," + "'" + getCustomerRoomEndDate(i) + "'" + ")";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                // Create a statement and set the values for the placeholder parameters
                PreparedStatement statement = connection.prepareStatement(insertSql);


                // Execute the insert statement
                int rowsInserted = statement.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted");
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }


    public static void CustomerFill() {

        int j = 0;
        // Replace these values with your own
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hostel";
        String password = "admin";

        String selectSql = "SELECT * FROM customer";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a statement and set the value for the placeholder parameter
            PreparedStatement statement = connection.prepareStatement(selectSql);


            // Execute the select statement and process the result set
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String ID = resultSet.getString("C_ID");
                    String c_name = resultSet.getString("c_name");
                    String father_name = resultSet.getString("father_name");
                    String cnic_no = resultSet.getString("cnic_no");
                    String mobile_no = resultSet.getString("mobile_no");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    String room_id = resultSet.getString("room_id");
                    String price = resultSet.getString("price");
                    String start_date = resultSet.getString("start_date");
                    String end_date = resultSet.getString("end_date");


                    System.out.println("ID : " + ID + ", Name : " + c_name + ", FatherName : " + father_name + ", CNIC NO : " + cnic_no + ", Mobile No : " + mobile_no + ", Email : " + email + ", Address : " + address + ", Room ID : " + room_id + ", Price : " + price + ", start_date : " + start_date + ", end_date : " + end_date);
                    int IDD = Integer.parseInt(ID);
                    customerData[IDD] = new CustomerData();
                    customerData[IDD].setName(c_name);
                    customerData[IDD].setFatherName(father_name);
                    customerData[IDD].setCNICNo(cnic_no);
                    customerData[IDD].setMobileNo(mobile_no);
                    customerData[IDD].setEmailAddress(email);
                    customerData[IDD].setAddress(address);
                    customerData[IDD].setRoomID(room_id);
                    customerData[IDD].setRoomPrice(price);
                    customerData[IDD].setRoomStartDate(start_date);
                    customerData[IDD].setRoomEndDate(end_date);
                    AddCustomer();
                    j++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (int i = j; i < 9999; i++) {
            customerData[i] = new CustomerData();
            customerData[i].setName("");
            customerData[i].setFatherName("");
            customerData[i].setCNICNo("");
            customerData[i].setMobileNo("");
            customerData[i].setEmailAddress("");
            customerData[i].setAddress("");
            customerData[i].setRoomID("");
            customerData[i].setRoomPrice("");
            customerData[i].setRoomStartDate("");
            customerData[i].setRoomEndDate("");
        }
    }


    public static void cutomerinsertdata() {
        // Replace these values with your own
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hostel";
        String password = "admin";
        for (int i = 0; i < 25; i++) {


            String insertSql = "INSERT INTO customer(" +
                    "C_ID, " +
                    "c_name, " +
                    "father_name, " +
                    "cnic_no, " +
                    "mobile_no, " +
                    "email, " +
                    "address, " +
                    "room_id, " +
                    "price, " +
                    "start_date, " +
                    "end_date) " +
                    "VALUES ("
                    + i + "," + Names[i] + "," + FatherName[i] + "," + CNICNo[i] + "," + PhoneNo[i] + "," + EmailAddresses[i] + "," + Address[i] + "," + RoomID[i] + "," + Price[i] + "," + StartDate[i] + "," + EndDate[i] + ")";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                // Create a statement and set the values for the placeholder parameters
                PreparedStatement statement = connection.prepareStatement(insertSql);


                // Execute the insert statement
                int rowsInserted = statement.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted");
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }

    public static void Getdata() {
        // Replace these values with your own
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hostel";
        String password = "admin";

        String selectSql = "SELECT * FROM customer";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a statement and set the value for the placeholder parameter
            PreparedStatement statement = connection.prepareStatement(selectSql);


            // Execute the select statement and process the result set
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String ID = resultSet.getString("C_ID");
                    String c_name = resultSet.getString("c_name");
                    String father_name = resultSet.getString("father_name");
                    String cnic_no = resultSet.getString("cnic_no");
                    String mobile_no = resultSet.getString("mobile_no");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    String room_id = resultSet.getString("room_id");
                    String price = resultSet.getString("price");
                    String start_date = resultSet.getString("start_date");
                    String end_date = resultSet.getString("end_date");


                    System.out.println("ID : " + ID + ", Name : " + c_name + ", FatherName : " + father_name + ", CNIC NO : " + cnic_no + ", Mobile No : " + mobile_no + ", Email : " + email + ", Address : " + address + ", Room ID : " + room_id + ", Price : " + price + ", start_date : " + start_date + ", end_date : " + end_date);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void RegisterCustomer(String Name, String FatherName, String CNIC, String Mobile, String Email, String Address) {
        Name = "'" + Name + "'";
        FatherName = "'" + FatherName + "'";
        CNIC = "'" + CNIC + "'";
        Mobile = "'" + Mobile + "'";
        Email = "'" + Email + "'";
        Address = "'" + Address + "'";

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hostel";
        String password = "admin";

        String insertSql = "INSERT INTO customer(" +
                "C_ID, " +
                "c_name, " +
                "father_name, " +
                "cnic_no, " +
                "mobile_no, " +
                "email, " +
                "address " +

                ") VALUES ("
                + getcounter() + "," + Name + "," + FatherName + "," + CNIC + "," + Mobile + "," + Email + "," + Address + ")";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a statement and set the values for the placeholder parameters
            PreparedStatement statement = connection.prepareStatement(insertSql);


            // Execute the insert statement
            int rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateRoom(int ID, String RID, String SDATE, String EDate, String Price) {

        RID = "'" + RID + "'";
        SDATE = "'" + SDATE + "'";
        EDate = "'" + EDate + "'";
        Price = "'" + Price + "'";


        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hostel";
        String password = "admin";

        String insertSql = "UPDATE customer set " +
                "room_id= " + RID +
                ",price =" + Price +
                ",start_date= " + SDATE +
                ",end_date= " + EDate +
                "where C_ID = " + ID;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a statement and set the values for the placeholder parameters
            PreparedStatement statement = connection.prepareStatement(insertSql);

            // Execute the insert statement
            int rowsUpdate = statement.executeUpdate();
            System.out.println(rowsUpdate + " row(s) Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    static String[] Names = new String[]{"'Raymond Kelly'", "'Johnny Evans'", "'Stephen Morgan'", "'Brandon Murphy'", "'Michael Jones'", "'Martin Hernandez'", "'Todd James'", "'Joshua Johnson'", "'Roger Thomas'", "'Anthony Morris'", "'Eric Mitchell'", "'Gerald Rodriguez'", "'Jeffrey Lopez'", "'Terry Martinez'", "'Wayne Simmons'", "'Joe Howard'", "'David Gray'", "'Gary Smith'", "'Keith Clark'", "'Russell Watson'", "'James Hill'", "'Joseph Hall'", "'Howard Turner'", "'Shawn Cook'", "'Harold Thompson'",
    };

    static String[] FatherName = new String[]{"'Raymond Kelly'", "'Johnny Evans'", "'Stephen Morgan'", "'Brandon Murphy'", "'Michael Jones'", "'Martin Hernandez'", "'Todd James'", "'Joshua Johnson'", "'Roger Thomas'", "'Anthony Morris'", "'Eric Mitchell'", "'Gerald Rodriguez'", "'Jeffrey Lopez'", "'Terry Martinez'", "'Wayne Simmons'", "'Joe Howard'", "'David Gray'", "'Gary Smith'", "'Keith Clark'", "'Russell Watson'", "'James Hill'", "'Joseph Hall'", "'Howard Turner'", "'Shawn Cook'", "'Harold Thompson'",
    };

    static String[] CNICNo = new String[]{"'61764560909'", "'14098354566'", "'71304089061'", "'68394841293'", "'54671279466'", "'66160158693'", "'53350232204'", "'90548203140'", "'92506396239'", "'48436716267'", "'23148254845'", "'44954273846'", "'30935619262'", "'61867276877'", "'95125268517'", "'60605135071'", "'55719936476'", "'97902953110'", "'68014000113'", "'73532131665'", "'65291268740'", "'77978207759'", "'47510001842'", "'44961879890'", "'74784488558'",
    };

    static String[] PhoneNo = new String[]{"'+92 8289108'", "'+92 1721897'", "'+92 5369210'", "'+92 9758209'", "'+92 9209699'", "'+92 1523817'", "'+92 3400440'", "'+92 4444325'", "'+92 3944968'", "'+92 0455574'", "'+92 0725351'", "'+92 7589997'", "'+92 0558682'", "'+92 9707441'", "'+92 4561654'", "'+92 4157781'", "'+92 0693231'", "'+92 8035725'", "'+92 5352241'", "'+92 8978583'", "'+92 1793150'", "'+92 9761606'", "'+92 4745102'", "'+92 8282872'", "'+92 0421604'",
    };
    static String[] EmailAddresses = new String[]{"'tbmaddux@yahoo.ca'", "'tamas@icloud.com'", "'mnemonic@msn.com'", "'bowmanbs@comcast.net'", "'gavollink@msn.com'", "'oracle@mac.com'", "'euice@me.com'", "'pmint@gmail.com'", "'birddog@aol.com'", "'sburke@msn.com'", "'agapow@yahoo.ca'", "'eminence@yahoo.com'", "'bruck@aol.com'", "'chlim@outlook.com'", "'snunez@aol.com'", "'dmath@sbcglobal.net'", "'boein@yahoo.ca'", "'hwestiii@mac.com'", "'alhajj@outlook.com'", "'mrobshaw@att.net'", "'yenya@gmail.com'", "'afifi@aol.com'", "'janusfury@outlook.com'", "'murty@optonline.net'", "'jyoliver@comcast.net'",
    };
    static String[] Address = new String[]{"'Room #5, Talpur Road Off. M.A.Jinnah Road,Karachi'", "'29-1,Near Total Pump, Millat Road'", "'Landmark Plaza 5/6 Jail Road, Lahore'", "'2B/1, F-7/1 P.O.Box No.3010 Capital'", "'B-98, Stice ,Nasik'", "'Chowk Yadgar, NWFP, Peshawar'", "'Dhabula P.O.Box: 876, Sialkot'", "'Babar Centre,O/S Akbari Gate, Circular Road'", "'A.Rehman Street, Jodia Bazar, Karachi'", "'LA-2-A/1, F.B. Area, Karachi'", "'Flat #R-15,Semorina Appartment,Block 13-A, Gulshan-e-iqbal'", "'Sony House Chowk Allam Iqbal, Sialkot'", "'Lahore Cantt'", "'23-E/2, Gulberg-ii, Lahore'", "'Ghazi M.B.Q. Masjid, SMCHS,Karachi'", "'Sunny Plaza Hasrat Mohani Road, Karachi'", "'Ratta Mansion, 69-W, Fazal-E-Haq Road, Blue Area'", "'Rabia Palace, Main Rashid Minhas Road, Karachi'", "'43-E,Block 6 PECHS,Opp. Federal Exepress, Shahrah-e-faisal, Karachi'", "'B-15,Spinzar Plaza, University Road, Peshawar'", "'Ocean Centre 40-Talpur Road, P.O.Box:4411, Karachi'", "'1311-12, Chapal PlazaHasrat Mohani Road,Karachi'", "'4 157/A,Mehmoodabad No. 1,Karachi'", "'Plot No.429, Industrial Area, Capital, Islamabad'", "'Saira Mansion Opp:Radio M.A.Jinnah Road, Sindh'",

    };

    static String[] RoomID = new String[]{"'B8KRY'", "'WN1UH'", "'THE5V'", "'829SH'", "'EXO37'", "'UV985'", "'WLTYA'", "'C13PD'", "'3IK3B'", "'GPLSQ'", "'MQX57'", "'2YX4E'", "'B7JT7'", "'0XGD0'", "'0KN5U'", "'XG2CK'", "'NF4EG'", "'NLIHE'", "'2HFY6'", "'J3140'", "'K7E48'", "'QO7KZ'", "'NYPM3'", "'CR8R7'", "'A7OC7'",
    };

    static String[] Price = new String[]{"'11396'", "'11227'", "'11715'", "'10622'", "'11738'", "'11022'", "'11618'", "'10304'", "'10629'", "'11794'", "'10904'", "'10224'", "'11552'", "'10212'", "'11634'", "'10615'", "'10025'", "'11549'", "'11423'", "'11368'", "'10892'", "'11939'", "'10612'", "'10588'", "'10082'",
    };

    static String[] StartDate = new String[]{"'January 1, 2022'", "'January 2, 2022'", "'January 3, 2022'", "'January 4, 2022'", "'January 5, 2022'", "'January 7, 2022'", "'January 8, 2022'", "'January 10, 2022'", "'January 11, 2022'", "'January 12, 2022'", "'January 13, 2022'", "'January 14, 2022'", "'January 15, 2022'", "'January 16, 2022'", "'January 17, 2022'", "'January 18, 2022'", "'January 19, 2022'", "'January 20, 2022'", "'January 21, 2022'", "'January 25, 2022'", "'January 26, 2022'", "'January 28, 2022'", "'January 29, 2022'", "'January 30, 2022'", "'February 1, 2022'",
    };

    static String[] EndDate = new String[]{"'February 1, 2022'", "'February 2, 2022'", "'February 4, 2022'", "'February 5, 2022'", "'February 10, 2022'", "'February 11, 2022'", "'February 16, 2022'", "'February 17, 2022'", "'February 18, 2022'", "'February 19, 2022'", "'February 22, 2022'", "'February 24, 2022'", "'March 2, 2022'", "'March 5, 2022'", "'March 7, 2022'", "'March 8, 2022'", "'March 9, 2022'", "'March 10, 2022'", "'March 11, 2022'", "'March 12, 2022'", "'March 15, 2022'", "'March 17, 2022'", "'March 22, 2022'", "'March 26, 2022'", "'April 1, 2022'",
    };
}

