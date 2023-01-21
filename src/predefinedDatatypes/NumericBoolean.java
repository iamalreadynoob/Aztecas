package predefinedDatatypes;

public class NumericBoolean
{

    private Integer value;

    public NumericBoolean(Integer value)
    {

        if (value == 0 || value == 1) this.value = value;
        else this.value = null;

    }

    public void setValue(Integer value)
    {
        if(value == 0 || value == 1) this.value = value;
        else this.value = null;
    }

    public Integer getValue()
    {
        return value;
    }
}
