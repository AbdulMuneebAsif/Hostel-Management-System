package SuperClasses;

import Classes.CustomerData;
import Classes.EmployeeData;

import java.sql.*;

public class SuperEmployeeData {
    public static EmployeeData[] employeeData = new EmployeeData[9999];
    private static int Counter = 0;
    private static boolean EmployeeLogin = false;

    public static boolean isEmployeeLogin() {
        return EmployeeLogin;
    }

    public static void setEmployeeLogin(boolean employeeLogin) {
        EmployeeLogin = employeeLogin;
    }

    private static int Editindex = 0;

    public static int getEditindex() {
        return Editindex;
    }

    public static void setEditindex(int editindex) {
        Editindex = editindex;
    }

    public static int getcounter() {
        return Counter;
    }

    public static void addCounter() {
        Counter += 1;
    }

    public static void DeleteCounter() {
        Counter -= 1;
    }

    public static void setEmployeeUserName(String UserName, int Index) {
        employeeData[Index].setUserName(UserName);
    }

    public static String getEmployeeUserName(int Index) {
        return employeeData[Index].getUserName();
    }

    public static void setEmployeePassward(String Passward, int Index) {
        employeeData[Index].setPassward(Passward);
    }

    public static String getEmployeePassward(int Index) {
        return employeeData[Index].getPassward();
    }


    public static void setEmployeeName(String Name, int Index) {
        employeeData[Index].setName(Name);
    }

    public static String getEmployeeName(int Index) {
        return employeeData[Index].getName();
    }

    public static void setEmployeeFatherName(String Name, int Index) {
        employeeData[Index].setFatherName(Name);
    }

    public static String getEmployeeFatherName(int Index) {
        return employeeData[Index].getFatherName();
    }

    public static void setEmployeeAddress(String Name, int Index) {
        employeeData[Index].setAddress(Name);
    }

    public static String getEmployeeAddress(int Index) {
        return employeeData[Index].getAddress();
    }

    public static void setEmployeeCNICNo(String Name, int Index) {
        employeeData[Index].setCNICNo(Name);
    }

    public static String getEmployeeCNICNo(int Index) {
        return employeeData[Index].getCNICNo();
    }

    public static void setEmployeeMobileNo(String Name, int Index) {
        employeeData[Index].setMobileNo(Name);
    }

    public static String getEmployeeMobileNo(int Index) {
        return employeeData[Index].getMobileNo();
    }

    public static void setEmployeeEmailAddress(String Name, int Index) {
        employeeData[Index].setEmailAddress(Name);
    }

    public static String getEmployeeEmailAddress(int Index) {
        return employeeData[Index].getEmailAddress();
    }


    public static void setEmployeeAge(String Name, int Index) {
        employeeData[Index].setAge(Name);
    }

    public static String getEmployeeAge(int Index) {
        return employeeData[Index].getAge();
    }

    public static void setEmployeePost(String Name, int Index) {
        employeeData[Index].setPost(Name);
    }

    public static String getEmployeePost(int Index) {
        return employeeData[Index].getPost();
    }

    public static String getEmployeeSalary(int Index) {
        return employeeData[Index].getSalary();
    }

    public static void setEmployeeSalary(String Salary, int Index) {
        employeeData[Index].setSalary(Salary);
    }


    public static void DeleteEmployee(int Index) {
        employeeData[Index].setName("");
        employeeData[Index].setFatherName("");
        employeeData[Index].setCNICNo("");
        employeeData[Index].setAddress("");
        employeeData[Index].setEmailAddress("");
        employeeData[Index].setAge("");
        employeeData[Index].setPost("");
        employeeData[Index].setUserName("");
        employeeData[Index].setPassward("");
        employeeData[Index].setSalary("");

        int j = 0;
        // Replace these values with your own
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hostel";
        String password = "admin";

        String DeleteSql = "delete from employee where E_ID = " + Index;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a statement and set the value for the placeholder parameter
            PreparedStatement statement = connection.prepareStatement(DeleteSql);
            // Execute the select statement
            int rowsDeleted = statement.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = Index; i < getcounter(); i++) {
            // Replace these values with your own


            String UPDateSql = "update customer set C_ID = " + i + " where C_ID = " + (i + 1);

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                // Create a statement and set the value for the placeholder parameter
                PreparedStatement statement = connection.prepareStatement(UPDateSql);
                // Execute the select statement
                int updateRecord = statement.executeUpdate();
                System.out.println(updateRecord + " row(s) updated");

            } catch (SQLException e) {
                e.printStackTrace();
            }


                employeeData[i].setName(getEmployeeName(i + 1));
                employeeData[i].setFatherName(getEmployeeFatherName(i + 1));
                employeeData[i].setCNICNo(getEmployeeCNICNo(i + 1));
                employeeData[i].setAddress(getEmployeeAddress(i + 1));
                employeeData[i].setEmailAddress(getEmployeeEmailAddress(i + 1));
                employeeData[i].setAge(getEmployeeAge(i + 1));
                employeeData[i].setPost(getEmployeePost(i + 1));
                employeeData[i].setUserName(getEmployeeUserName(i + 1));
                employeeData[i].setPassward(getEmployeePassward(i + 1));
                employeeData[i].setSalary(getEmployeeSalary(i + 1));

        }
        DeleteCounter();
    }

        public static void EmployeeFill ()
        {
            int j = 0;
            // Replace these values with your own
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "hostel";
            String password = "admin";

            String selectSql = "SELECT * FROM employee";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                // Create a statement and set the value for the placeholder parameter
                PreparedStatement statement = connection.prepareStatement(selectSql);


                // Execute the select statement and process the result set
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String ID = resultSet.getString("e_id");
                        String e_name = resultSet.getString("e_name");
                        String father_name = resultSet.getString("father_name");
                        String cnic_no = resultSet.getString("cnic_no");
                        String mobile_no = resultSet.getString("mobile_no");
                        String email = resultSet.getString("email");
                        String address = resultSet.getString("address");
                        String age = resultSet.getString("age");
                        String post = resultSet.getString("post");
                        String salary = resultSet.getString("salary");


                        System.out.println("ID : " + ID + ", Name : " + e_name + ", FatherName : " + father_name + ", CNIC NO : " + cnic_no + ", Mobile No : " + mobile_no + ", Email : " + email + ", Address : " + address + ", age : " + age + ", post : " + post + ", salary : " + salary);
                        int IDD=Integer.parseInt(ID);
                        employeeData[IDD] = new EmployeeData();
                        employeeData[IDD].setName(e_name);
                        employeeData[IDD].setFatherName(father_name);
                        employeeData[IDD].setCNICNo(cnic_no);
                        employeeData[IDD].setMobileNo(mobile_no);
                        employeeData[IDD].setEmailAddress(email);
                        employeeData[IDD].setAddress(address);
                        employeeData[IDD].setAge(age);
                        employeeData[IDD].setPost(post);
                        employeeData[IDD].setUserName("");
                        employeeData[IDD].setPassward("");
                        employeeData[IDD].setSalary(salary);
                        addCounter();
                        j++;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (int i = j; i < 9999; i++) {
                employeeData[i] = new EmployeeData();

                employeeData[i].setName("");
                employeeData[i].setFatherName("");
                employeeData[i].setCNICNo("");
                employeeData[i].setMobileNo("");
                employeeData[i].setEmailAddress("");
                employeeData[i].setAddress("");
                employeeData[i].setAge("");
                employeeData[i].setPost("");
                employeeData[i].setUserName("");
                employeeData[i].setPassward("");
                employeeData[i].setSalary("");

            }
        }

       public static void RegisterEmployee(String Name,String CNIC,String MobileNo,String Email,String Address,String Age,String Post,String Salary,String FatherName)
        {
            Name="'"+Name+"'";
            CNIC="'"+CNIC+"'";
            MobileNo="'"+MobileNo+"'";
            Email="'"+Email+"'";
            Address="'"+Address+"'";
            Age="'"+Age+"'";
            Post="'"+Post+"'";
            Salary="''";
            FatherName="'"+FatherName+"'";

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "hostel";
            String password = "admin";

                String insertSql = "INSERT INTO employee(" +
                        "e_id, " +
                        "e_name, " +
                        "father_name, " +
                        "cnic_no, " +
                        "mobile_no, " +
                        "email, " +
                        "address, " +
                        "age, " +
                        "post, " +
                        "salary) " +
                        "VALUES ("
                        + getcounter() + "," + Name + "," + FatherName + "," + CNIC+ "," + MobileNo + "," + Email + "," + Address + "," + Age + "," + Post + "," + Salary+ ")";

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

   public static void UpdateEmployee(int ID,String Name,String CNIC,String MobileNo,String Email,String Address,String Age,String Post,String Salary,String FatherName)
    {
        Name="'"+Name+"'";
        CNIC="'"+CNIC+"'";
        MobileNo="'"+MobileNo+"'";
        Email="'"+Email+"'";
        Address="'"+Address+"'";
        Age="'"+Age+"'";
        Post="'"+Post+"'";
        Salary="''";
        FatherName="'"+FatherName+"'";

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hostel";
        String password = "admin";

        String insertSql = "UPDATE employee set " +
                "e_name = " + Name + "," +
                "father_name = " + FatherName + "," +
                "cnic_no = " + CNIC+ "," +
                "mobile_no = " + MobileNo + "," +
                "email = " + Email + "," +
                "address = " + Address + "," +
                "age = " + Age + "," +
                "post = " + Post + "," +
                "salary = " + Salary+
                "where E_ID = " + ID ;

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
    public static void UpdateEmployeeSalary(int ID,String Salary)
    {

        Salary="'"+Salary+"'";


        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hostel";
        String password = "admin";

        String insertSql = "UPDATE employee set " +
                "salary = " + Salary+
                "where E_ID = " + ID ;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a statement and set the values for the placeholder parameters
            PreparedStatement statement = connection.prepareStatement(insertSql);

            // Execute the insert statement
            int rowsUpdate = statement.executeUpdate();
            System.out.println(rowsUpdate + " row(s) inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}




