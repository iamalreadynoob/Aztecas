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
        String test = "num sayi = 10; io oput sayi;";

        Collector collector = new Collector(test);

        nodes = collector.getSlicedCode();

        System.out.println(nodes);

        new Processor(nodes);

    }

}
