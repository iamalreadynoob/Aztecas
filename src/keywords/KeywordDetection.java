package keywords;

import java.util.ArrayList;

public class KeywordDetection
{

    private ArrayList<String> var_keywords;

    public KeywordDetection()
    {
        Variables variables = new Variables();
        var_keywords = variables.getVar_keywords();
    }

    public KeywordTypes keywordDetect(String node)
    {

        KeywordTypes type = null;

        for (int i = 0; i < var_keywords.size(); i++)
        {
            if (node.equals(var_keywords.get(i)))
            {
                type = KeywordTypes.VAR;
                break;
            }
        }

        if (type == null)
        {

            if (node.equals("create") || node.equals("obtain")) type = KeywordTypes.FUN;
            else if (node.equals("situ") || node.equals("okay") || node.equals("ifdo") || node.equals("not") || node.equals("end")) type = KeywordTypes.CON;
            else if (node.equals("loop")) type = KeywordTypes.LOOP;
            else if (node.equals("nil")) type = KeywordTypes.VAL;

        }

        return type;
    }

}
