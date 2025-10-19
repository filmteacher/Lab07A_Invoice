import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest
{
    Address address = new Address("Ted's Stuff","124 Test Street","Apt. 4","Rhodes","GA","96707");

    @Test
    void testformat()
    {
        String expected = "Ted's Stuff\n124 Test Street\nApt. 4\nRhodes, GA 96707";
        String actual = address.format();
        assertEquals(expected, actual, "They should match.");
    }
}