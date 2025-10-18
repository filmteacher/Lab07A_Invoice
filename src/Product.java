public class Product
{
    private String name;
    private double unitPrice;

    public Product(String aName, double aUnitPrice)
    {
        name = aName;
        unitPrice = aUnitPrice;
    }

    public String getName()
    {
        return name;
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }
}
