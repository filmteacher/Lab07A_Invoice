import java.util.ArrayList;

public class Invoice
{
    private String title = "INVOICE\n";
    private double totalAmountDue;

    private ArrayList<LineItem> items;
    private Address billingAddress;


    public Invoice(Address anAddress)
    {
        items = new ArrayList<LineItem>();
        billingAddress = anAddress;
    }

    public void add(Product aProduct, int quantity)
    {
        LineItem anItem = new LineItem(aProduct, quantity);
        items.add(anItem);
    }

    public String format()
    {
        String r = title
                + billingAddress.format()
                + String.format("\n\n%-30s%8s%5s%8s \n",
                "Description", "Price", "Qty", "Total");

        for (LineItem item : items)
        {
            r = r + item.format() + "\n";
        }

        r = r + String.format("\nAMOUNT DUE: $%8.2f", getTotalAmountDue());

        return r;
    }

    public double getTotalAmountDue() {
        double totalAmountDue = 0;
        for (LineItem item : items)
        {
            totalAmountDue = totalAmountDue = item.getCalculatedTotal();
        }

        return totalAmountDue;
    }

    public void setTotalAmountDue(double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

}
