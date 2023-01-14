package Classes;

public class Rooms {
    private String Id;
    private Payment Price = new Payment();
    private String StartDate;
    private String EndDate;

    public Rooms() {
        Id = "";
        Price.setCash("");
        StartDate = "";
        EndDate = "";
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPrice() {
        return Price.getCash();
    }

    public void setPrice(String price) {
        Price.setCash(price);
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }


}
