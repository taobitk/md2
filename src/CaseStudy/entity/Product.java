package CaseStudy.entity;

public class Product extends Sale {
    private int Price;
    private String dateOfManufacture;
    private String expiryDate;

    public Product() {
    }

    public Product(int id, String name, int price, String dateOfManufacture, String expiryDate) {
        super(id, name);
        Price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.expiryDate = expiryDate;
    }


    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Product: " + "id: " + this.getId()+ ", name: " + this.getName() + ", price: " + this.getPrice() + ", ngày sản xuất: " + this.getDateOfManufacture() + ", hạn sử dụng: " + this.getExpiryDate();
    }
}
