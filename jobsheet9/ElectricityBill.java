package jobsheet9;

public class ElectricityBill implements Payable {
    private int kwh;
    private String category;

    public ElectricityBill(int kwh, String category){
        this.kwh = kwh;
        this.category = category;
    }

    public int getKwh(){
        return kwh;
    }
    public void setKwh(int kwh){
        this.kwh = kwh;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;

    }

    @Override 
    public int getPaymentAmount(){
        return kwh * getBaseprice();
    }

    public int getBaseprice(){
        return switch (category){
            case "R-1" -> 100;
            case "R-2" -> 200;
            default -> 0;
        };
    }

    public String getBillInfo(){
        return "kWH = " + kwh + "\n" +
                "Category = " + category + " (" + getBaseprice() + " per kWH)\n";
    }
    
}
