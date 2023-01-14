package SuperClasses;

public class SuperAdmin {
    private static Classes.Admin admin=new Classes.Admin();

    public static String getAdminUser() {
        return admin.getUserName();
    }
    public static String getAdminPass() {
        return admin.getPassword();
    }

    public static void setAdminUser(String User) {
        admin.setUserName(User);
    }
    public static void setAdminPass(String Pass) {
        admin.setPassword(Pass);
    }
}
