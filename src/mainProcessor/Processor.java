package mainProcessor;

import keywords.KeywordDetection;
import keywords.KeywordTypes;
import storage.ArrayStorage;
import storage.VariableStorage;
import variableComm.ArrayDeclaring;
import variableComm.VariableDeclaring;

import java.util.ArrayList;

public class Processor
{

    private ArrayList<String> process = null;

    public Processor(ArrayList<String> process)
    {

        this.process = process;

        VariableStorage variableStorage = new VariableStorage();
        ArrayStorage arrayStorage = new ArrayStorage();

        int location = 0;

        while (location < process.size())
        {

            ArrayList<String> currentCommand = null;

            while (!process.get(location).equals(";") || !process.get(location).equals("end"))
            {

                currentCommand.add(process.get(location));

                location++;
                if (location >= process.size()) break;

            }

            for (int i = 0; i < currentCommand.size(); i++)
            {

                KeywordDetection keywordDetection = new KeywordDetection();
                KeywordTypes keyword = keywordDetection.keywordDetect(currentCommand.get(i));

                switch (keyword)
                {
                    case VAR:
                        if (currentCommand.get(i).charAt(0) != 'a')
                        {
                            new VariableDeclaring(currentCommand, variableStorage);
                        }

                        else
                        {
                            new ArrayDeclaring(currentCommand, arrayStorage);
                        }


                }

            }

        }

    }


}
