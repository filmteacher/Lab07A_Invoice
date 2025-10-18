import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvoiceFrame extends JFrame
{
    JPanel mainPnl;
    JPanel headerPnl;
    JPanel entryPnl;
    JPanel customerPnl;
    JPanel custBtnsPnl;
    JPanel itemsPnl;
    JPanel itemBtnsPnl;
    JPanel invoicePnl;
    JPanel footerPnl;

    JLabel title;

    JTextField nameFld;
    JTextField addressFld;
    JTextField aptFld;
    JTextField cityFld;
    JTextField stateFld;
    JTextField zipFld;

    JLabel nameLbl;
    JLabel addressLbl;
    JLabel aptLbl;
    JLabel cityLbl;
    JLabel stateLbl;
    JLabel zipLbl;

    String name;
    String address;
    String apt;
    String city;
    String state;
    String zip;

    JButton addCustBtn;
    JButton clearCustBtn;

    JTextField itemFld;
    JTextField qtyFld;
    JTextField priceFld;

    JLabel itemLbl;
    JLabel qtyLbl;
    JLabel priceLbl;

    JButton addItemBtn;
    JButton clearItemBtn;

    JTextArea invoiceArea;

    JLabel quitMsg;
    JButton quitBtn;

    JFrame frame = new JFrame();

    String order = "";
    Invoice custInvoice;
    Address custAddress;

    public InvoiceFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BoxLayout(mainPnl, BoxLayout.Y_AXIS));

        createHeaderPanel();
        createEntryPanel();
        createInvoicePanel();
        createFooterPanel();

        add(mainPnl);
        setTitle("Lab 07A - Invoice");
        setSize(720,850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createHeaderPanel()
    {
        headerPnl = new JPanel();
        headerPnl.setPreferredSize(new Dimension(720,40));
        headerPnl.setBackground(Color.BLACK);
        title = new JLabel("Create Your Invoice Below");
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        title.setForeground(Color.WHITE);
        headerPnl.add(title);

        mainPnl.add(headerPnl);
    }

    private void createEntryPanel()
    {
        entryPnl = new JPanel();
        entryPnl.setLayout(new BoxLayout(entryPnl, BoxLayout.X_AXIS));

        customerPnl= new JPanel();
        customerPnl.setPreferredSize(new Dimension(360, 270));
        customerPnl.setBorder(new TitledBorder(new EtchedBorder(), "Customer Info:"));
        customerPnl.setBackground(Color.LIGHT_GRAY);

        nameFld = new JTextField(20);
        addressFld = new JTextField(20);
        aptFld = new JTextField(20);
        cityFld = new JTextField(20);
        stateFld = new JTextField(20);
        zipFld = new JTextField(20);

        nameLbl = new JLabel("       Name:");
        addressLbl = new JLabel("   Address:");
        aptLbl = new JLabel("Apartment:");
        cityLbl = new JLabel("         City:");
        stateLbl = new JLabel("        State:");
        zipLbl = new JLabel("           Zip:");

        addCustBtn = new JButton("Add Cust. Info");
        addCustBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    String name = nameFld.getText();
                    String address = addressFld.getText();
                    String apt = aptFld.getText();
                    String city = cityFld.getText();
                    String state = stateFld.getText();
                    String zip = zipFld.getText();

                    custAddress = new Address(name, address, apt, city, state, zip);
                    custInvoice = new Invoice(custAddress);
                    order = custInvoice.format();
                });

        clearCustBtn = new JButton("Clear Cust. Info");
        clearCustBtn.addActionListener(
                (ActionEvent ae) ->
                {

                });

        customerPnl.add(nameLbl);
        customerPnl.add(nameFld);

        customerPnl.add(addressLbl);
        customerPnl.add(addressFld);

        customerPnl.add(aptLbl);
        customerPnl.add(aptFld);

        customerPnl.add(cityLbl);
        customerPnl.add(cityFld);

        customerPnl.add(stateLbl);
        customerPnl.add(stateFld);

        customerPnl.add(zipLbl);
        customerPnl.add(zipFld);

        custBtnsPnl = new JPanel();
        custBtnsPnl.setBackground(Color.LIGHT_GRAY);
        custBtnsPnl.add(addCustBtn);
        custBtnsPnl.add(clearCustBtn);
        customerPnl.add(custBtnsPnl);

        entryPnl.add(customerPnl);

        itemsPnl = new JPanel();
        itemsPnl.setPreferredSize(new Dimension(360, 270));
        itemsPnl.setBorder(new TitledBorder(new EtchedBorder(), "Items Info:"));
        itemsPnl.setBackground(Color.LIGHT_GRAY);

        itemFld = new JTextField(20);
        qtyFld = new JTextField(20);
        priceFld = new JTextField(20);

        itemLbl = new JLabel(" Product:");
        qtyLbl = new JLabel("Quantity:");
        priceLbl = new JLabel("     Price:");

        addItemBtn = new JButton("Add Line Item");
        addItemBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    String item = itemFld.getText();
                    String qtyStr = qtyFld.getText();
                    String priceStr = priceFld.getText();

                    int qty = Integer.parseInt(qtyStr);
                    double price = Double.parseDouble(priceStr);

                    custInvoice.add(new Product(name, price), qty);
//
//        custInvoice.add(new Product("Toaster", 29.95), 3);
//        custInvoice.add(new Product("Hair Dryer", 24.95), 1);
//        custInvoice.add(new Product("Car Vaccum", 19.95), 2);
//
                });

        clearItemBtn = new JButton("Clear Items");
        clearItemBtn.addActionListener(
                (ActionEvent ae) ->
                {

                });

        itemsPnl.add(itemLbl);
        itemsPnl.add(itemFld);

        itemsPnl.add(qtyLbl);
        itemsPnl.add(qtyFld);

        itemsPnl.add(priceLbl);
        itemsPnl.add(priceFld);

        itemBtnsPnl = new JPanel();
        itemBtnsPnl.setBackground(Color.LIGHT_GRAY);
        itemBtnsPnl.add(addItemBtn);
        itemBtnsPnl.add(clearItemBtn);
        itemsPnl.add(itemBtnsPnl);

        entryPnl.add(itemsPnl);

        mainPnl.add(entryPnl);
    }


    private void createInvoicePanel()
    {
        invoicePnl = new JPanel();
        invoicePnl.setBorder(new TitledBorder(new EtchedBorder(), "Your Invoice:"));
        invoicePnl.setBackground(Color.WHITE);
        invoicePnl.setPreferredSize(new Dimension(720, 500));

        invoiceArea = new JTextArea(30,50);
        invoiceArea.setFont(new Font("Verdana", Font.PLAIN, 14));
        invoiceArea.setEditable(false);

        invoiceArea.setText(order);

        mainPnl.add(invoicePnl);
    }

    private void createFooterPanel()
    {
        footerPnl = new JPanel();
        footerPnl.setBackground(Color.BLACK);
        quitMsg = new JLabel("When you are finished, click Quit!");
        quitMsg.setFont(new Font("Verdana", Font.PLAIN, 16));
        quitMsg.setForeground(Color.WHITE);
        footerPnl.add(quitMsg);

        quitBtn = new JButton("Quit!");
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            frame = new JFrame("Confirmation");

            int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
            else
            {
                frame.dispose();
            }
        });
        footerPnl.add(quitBtn);

        mainPnl.add(footerPnl);
    }

}
