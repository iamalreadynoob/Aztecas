package predefinedDatatypes;

public class ExpandedBoolean
{

    private String value;

    public ExpandedBoolean(String value)
    {

        boolean isExpanded = true;

        if (!value.equals("TRUE") || !value.equals("ATRUE") || !value.equals("NEUTRAL") || !value.equals("AFALSE") || !value.equals("FALSE")) isExpanded = false;

        if (isExpanded) this.value = value;
        else this.value = "NEUTRAL";

    }

    public void setValue(String value)
    {

        boolean isExpanded = true;

        if (!value.equals("TRUE") || !value.equals("ATRUE") || !value.equals("NEUTRAL") || !value.equals("AFALSE") || !value.equals("FALSE")) isExpanded = false;

        if (isExpanded) this.value = value;
        else this.value = "NEUTRAL";

    }

    public String getValue()
    {
        return value;
    }
}
