package mainProcessor;

import keywords.KeywordDetection;
import keywords.KeywordTypes;
import reservedIO.MethodDetection;
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

            ArrayList<String> currentCommand = new ArrayList<>();

            while (!process.get(location).equals(";"))
            {

                currentCommand.add(process.get(location));

                location++;
                if (location >= process.size()) break;

            }

            System.out.println(currentCommand);

            for (int i = 0; i < currentCommand.size(); i++)
            {

                KeywordDetection keywordDetection = new KeywordDetection();
                KeywordTypes keyword = keywordDetection.keywordDetect(currentCommand.get(i));
                boolean done = false;

                switch (keyword)
                {
                    case VAR:
                        if (currentCommand.get(i).charAt(0) != 'a')
                        {
                            new VariableDeclaring(currentCommand, variableStorage);
                            done = true;
                        }

                        else
                        {
                            new ArrayDeclaring(currentCommand, arrayStorage);
                            done = true;
                        }

                    case RESF:
                        if (currentCommand.get(i).equals("io"))
                        {
                            new MethodDetection(currentCommand, variableStorage, arrayStorage);
                            done = true;
                        }


                }

                if (done == true)
                {
                    location ++;
                    break;
                }

            }

        }

    }


}
