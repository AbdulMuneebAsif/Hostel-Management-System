package Classes;

public class FoodItems {
    private String ItemName;
    private String Price;
    private String Date;

   public FoodItems()
    {
        ItemName="LOL";
        Price="232";
        Date="osa";
    }


    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
