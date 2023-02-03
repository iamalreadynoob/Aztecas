package keywords;

import java.util.ArrayList;

public class Variables
{
    private static ArrayList<String> var_keywords = new ArrayList<>();

    protected Variables()
    {
        var_keywords.add("num");
        var_keywords.add("anum");
        var_keywords.add("lnum");
        var_keywords.add("alnum");
        var_keywords.add("snum");
        var_keywords.add("asnum");
        var_keywords.add("bnum");
        var_keywords.add("abnum");
        var_keywords.add("bin");
        var_keywords.add("abin");
        var_keywords.add("truth");
        var_keywords.add("atruth");
        var_keywords.add("ltruth");
        var_keywords.add("altruth");
        var_keywords.add("sym");
        var_keywords.add("asym");
        var_keywords.add("lsym");
        var_keywords.add("alsym");
    }

    protected ArrayList<String> getVar_keywords()
    {
        return var_keywords;
    }

}
