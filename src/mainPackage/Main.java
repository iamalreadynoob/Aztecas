package mainPackage;

import codeCollector.Collector;
import codeCollector.Slicer;
import mainProcessor.Processor;

import java.util.ArrayList;

public class Main
{

    private static ArrayList<String> nodes = null;

    public static void main(String[] args)
    {
        String test = "bak bugün şimdi bunun çalışması gerekli. <num a, num b> endline; naber başkan";

        Collector collector = new Collector(test);

        nodes = collector.getSlicedCode();

        new Processor(nodes);

    }

}
