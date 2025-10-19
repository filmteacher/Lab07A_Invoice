import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {

    Product product = new Product("Test Stuff", 19.99);
    LineItem lineitem = new LineItem(product, 5);

    @Test
    void testgetCalculatedTotal()
    {
        double expected = 99.95;
        double actual = lineitem.getCalculatedTotal();
        assertEquals(expected, actual, "Calculated total should equal 99.95");
    }

    @Test
    void testformat()
    {
        String expected = "Test Stuff                    5    19.99   99.95   ";
        String actual = lineitem.format();
        assertEquals(expected, actual, "They should match.");

    }
}