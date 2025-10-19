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
        String r = title +"\n"
                + billingAddress.format() + "\n"
                + "\n================================================================================\n\n"
                + String.format("%-30s%-15s%15s%15s",
                "Item", "Qty", "Price", "Total")
                + "\n";

        for (LineItem item : items)
        {
            r = r + item.format() + "\n";
        }

        r = r + "\n================================================================================\n"
                + String.format("\nAMOUNT DUE: $%-8.2f", getTotalAmountDue());

        return r;
    }

    public double getTotalAmountDue() {
        double totalAmountDue = 0;
        for (LineItem item : items)
        {
            totalAmountDue = totalAmountDue + item.getCalculatedTotal();
        }

        return totalAmountDue;
    }
}
