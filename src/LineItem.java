public class LineItem
{
    private int quantity;
    private Product theProduct;

    public LineItem(Product aProduct, int aQuantity)
    {
        theProduct = aProduct;
        quantity = aQuantity;
    }

    public double getCalculatedTotal()
    {
        return Math.round(theProduct.getUnitPrice() * quantity * 100.0) / 100.0;
    }

    public String format()
    {
        return String.format("%-30s%-5d%-8.2f%-8.2f",
                theProduct.getName(), quantity, theProduct.getUnitPrice(),
                getCalculatedTotal());
    }
}
