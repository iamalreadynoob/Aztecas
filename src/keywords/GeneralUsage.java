package keywords;

import java.util.ArrayList;

public class GeneralUsage
{

    private static ArrayList<String> gen_keywords;

    protected GeneralUsage()
    {
        gen_keywords.add("create");
        gen_keywords.add("obtain");
        gen_keywords.add("situ");
        gen_keywords.add("okay");
        gen_keywords.add("ifdo");
        gen_keywords.add("not");
        gen_keywords.add("loop");
        gen_keywords.add("nil");
        gen_keywords.add("end");
    }

    protected ArrayList<String> getGen_keywords()
    {
        return gen_keywords;
    }

}
