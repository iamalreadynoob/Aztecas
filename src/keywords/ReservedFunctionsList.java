package keywords;

import java.util.ArrayList;

public class ReservedFunctionsList
{

    private ArrayList<String> reserved;

    public ReservedFunctionsList()
    {
        reserved.add("io");
        reserved.add("math");
    }

    public ArrayList<String> getReserved()
    {
        return reserved;
    }

}
