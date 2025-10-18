public class LineItem {
    double quantity;
    double calculatedTotal;

    public LineItem(double quantity, double calculatedTotal) {
        this.quantity = quantity;
        this.calculatedTotal = calculatedTotal;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setCalculatedTotal(double calculatedTotal) {
        this.calculatedTotal = calculatedTotal;
    }

    private double getCalculatedTotal() {}
}
