public class Address
{
    private static String name;
    private static String street;
    private static String apt;
    private static String city;
    private static String state;
    private static String zip;

    public Address(String aName, String aStreet, String anApt, String aCity, String aState, String aZip)
    {
        name = aName;
        street = aStreet;
        apt = anApt;
        city = aCity;
        state = aState;
        zip = aZip;
    }

    public static String format()
    {
        if (apt == "")
        {
            return name + "\n"
                    + street + "\n"
                    + city + "\n"
                    + state + "\n"
                    + zip;
        } else {
            return name + "\n"
                    + street + "\n"
                    + apt + "\n"
                    + city + "\n"
                    + state + "\n"
                    + zip;
        }
    }
}