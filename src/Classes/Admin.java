package Classes;

public class Admin {
  private String UserName;
  private String Password;

   public Admin()
    {
       UserName="admin" ;
       Password ="123";
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }
}
