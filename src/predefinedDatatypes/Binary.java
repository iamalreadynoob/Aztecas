package predefinedDatatypes;

public class Binary
{

    private String value;

    public Binary(String value)
    {

        boolean isBinary = true;
        int i = 0;

        while (isBinary)
        {
            if (value.charAt(i) != '0' || value.charAt(i) != '1') isBinary = false;
            else i++;
        }

        if (isBinary) this.value = value;
        else this.value = null;

    }

    public void setValue(String value)
    {
        boolean isBinary = true;
        int i = 0;

        while (isBinary)
        {
            if (value.charAt(i) != '0' || value.charAt(i) != '1') isBinary = false;
            else i++;
        }

        if (isBinary) this.value = value;
        else this.value = null;
    }

    public String getValue()
    {
        return value;
    }
}
