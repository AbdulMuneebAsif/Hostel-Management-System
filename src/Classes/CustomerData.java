package Classes;

public class CustomerData {
    private String Name;
    private String FatherName;
    private String CNICNo;
    private String MobileNo;
    private String EmailAddress;
    private String Address;
    private Rooms room=new Rooms();
    
    public CustomerData()
    {
        Name="lol";
        FatherName="nnn";
        CNICNo="lssd";
        MobileNo="dsd";
        EmailAddress="dld";
        Address="sds";
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

    public String getRoomID() {
        return room.getId();
    }

    public void setRoomID(String ID) {
        room.setId(ID);
    }

    public String getRoomPrice() {
        return room.getPrice();
    }

    public void setRoomPrice(String Price) {
        room.setPrice(Price);
    }
    public String getRoomStartDate() {
        return room.getStartDate();
    }

    public void setRoomStartDate(String Date) {
        room.setStartDate(Date);
    }
    public String getRoomEndDate() {
        return room.getEndDate();
    }

    public void setRoomEndDate(String Date) {
        room.setEndDate(Date);
    }


}
