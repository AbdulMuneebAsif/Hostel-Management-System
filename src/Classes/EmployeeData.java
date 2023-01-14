package Classes;

public class EmployeeData {
    private String Name;
    private String FatherName;
    private String CNICNo;
    private String MobileNo;
    private String EmailAddress;
    private String Address;
    private String Age;
    private String Post;
    private String Passward;
    private String UserName;
    private Payment Salary=new Payment();

    public String getSalary() {
        return Salary.getCash();
    }

    public void setSalary(String salary) {
        Salary.setCash(salary);
    }

    public String getPassward() {
        return Passward;
    }

    public void setPassward(String passward) {
        Passward = passward;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public EmployeeData()
    {
        Name="lol";
        FatherName="nnn";
        CNICNo="lssd";
        MobileNo="dsd";
        EmailAddress="dld";
        Address="sds";
        Age="lol";
        Post="sd";
        UserName="lol";
        Passward="123";
        Salary.setCash("");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getCNICNo() {
        return CNICNo;
    }

    public void setCNICNo(String CNICNo) {
        this.CNICNo = CNICNo;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }


}
