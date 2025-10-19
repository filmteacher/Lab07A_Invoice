import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest
{
    Product product = new Product("Test Stuff", 19.99);

    @Test
    void testgetName()
    {
        String expected = "Test Stuff";
        String actual = product.getName();
        assertEquals(expected, actual, "Name should be Test Stuff");

    }

    @Test
    void testgetUnitPrice()
    {
        double expected = 19.99;
        double actual = product.getUnitPrice();
        assertEquals(expected, actual, "Unit price should be 19.99");
    }
}