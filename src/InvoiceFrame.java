import javax.swing.*;

public class InvoiceFrame extends JFrame
{
    public InvoiceFrame()
    {
        Address custAddress = new Address("Sam's Small Appliances", "100 Main Street", "", "Anytown", "CA", "98765");

        Invoice custInvoice = new Invoice(custAddress);

        custInvoice.add(new Product("Toaster", 29.95), 3);
        custInvoice.add(new Product("Hair Dryer", 24.95), 1);
        custInvoice.add(new Product("Car vaccum", 19.95), 2);

        System.out.println(custInvoice.format());

    }

}
