package codeCollector;

import java.util.ArrayList;

public class Collector
{

    private String code;
    private ArrayList<String> slicedCode;

    public Collector(String code)
    {
        this.code = code;

        Slicer slicer = new Slicer(code);
        slicedCode = slicer.slice();

    }

    public ArrayList<String> getSlicedCode()
    {
        return slicedCode;
    }

}
