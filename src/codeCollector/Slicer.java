package codeCollector;

import java.util.ArrayList;

public class Slicer
{

    private String sliced;

    public Slicer(String sliced)
    {
        this.sliced = sliced;
    }

    public ArrayList<String> slice()
    {
        ArrayList<String> nodes = new ArrayList<>();

        int i = 0;
        while (i < sliced.length())
        {

            if (sliced.charAt(i) != ' ')
            {

                if (sliced.charAt(i) == ';' || sliced.charAt(i) == ',' || sliced.charAt(i) == '<' || sliced.charAt(i) == '>' || sliced.charAt(i) == '{' || sliced.charAt(i) == '}' || sliced.charAt(i) == '=' || sliced.charAt(i) == '.' || sliced.charAt(i) == '\"')
                {
                    nodes.add(Character.toString(sliced.charAt(i)));
                    i++;
                }

                else
                {
                    String newNode = " ";

                    while (sliced.charAt(i) != ' ' && sliced.charAt(i) != ';' && sliced.charAt(i) != ',' && sliced.charAt(i) != '<' && sliced.charAt(i) != '>' && sliced.charAt(i) != '{' && sliced.charAt(i) != '}' && sliced.charAt(i) != '=' && sliced.charAt(i) != '.' && sliced.charAt(i) != '\"')
                    {

                        if (newNode == " ") newNode = Character.toString(sliced.charAt(i));
                        else newNode += Character.toString(sliced.charAt(i));

                        i++;

                        if (i + 1 >= sliced.length()) break;


                    }

                    nodes.add(newNode);

                }

            }

            else
            {
                i++;
            }


        }

        return nodes;
    }


}
