package reservedIO;

import exceptionHandling.ExceptionList;
import output.ExceptionOutputter;
import storage.ArrayStorage;
import storage.VariableStorage;

import java.util.ArrayList;

public class MethodDetection
{

    public MethodDetection(ArrayList<String> command, VariableStorage var, ArrayStorage arr)
    {
        int location = 1;

        if (command.get(location).equals("oput"))
        {
            location++;
            String output = null;

            while (location < command.size())
            {
                if (command.get(location).equals("\""))
                {
                    location++;

                    while (!command.get(location).equals("\""))
                    {
                        if (output.equals(null)) output = command.get(location);
                        else output = output + " " + command.get(location);

                        location++;
                    }

                    location++;
                }

                else if (command.get(location).equals("+"))
                {
                    location++;

                    String varName = command.get(location);
                    Integer varType = null;
                    Integer varIndex = null;
                    Integer datatype = null;

                    if (command.get(location).equals("\""))
                    {
                        location++;


                        while (!command.get(location).equals("\""))
                        {
                            if (output.equals(null)) output = command.get(location);
                            else output = output + " " + command.get(location);

                            location++;
                        }

                        location++;
                    }

                    else if (isExist(varName, varType, datatype, var, arr))
                    {

                        switch (datatype)
                        {
                            case 0:
                                if (varType == 0)
                                {
                                    Integer value = var.getNum(varName);
                                    output += Integer.toString(value);
                                }

                                else if (varType == 1)
                                {
                                    location++;

                                    if (command.get(location).equals("at"))
                                    {
                                        location++;
                                        Integer arrIndex = Integer.parseInt(command.get(location));
                                        Integer value = arr.getAnumItem(varName, arrIndex);
                                        output += Integer.toString(value);

                                    }

                                    else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                    {
                                        ArrayList temp = arr.getVarNames(0);

                                        for (int i = 0; i < temp.size(); i++)
                                        {
                                            output += arr.getAnumItem(varName, i);
                                        }

                                    }

                                    else new ExceptionOutputter().getOutput(ExceptionList.UNEXPECTED_OPERATOR);

                                }
                                break;

                            case 1:
                                if (varType == 0)
                                {
                                    Long value = var.getLnum(varName);
                                    output += value;
                                }

                                else if (varType == 1)
                                {

                                }


                        }


                    }




                }


            }

        }

        else if (command.get(location).equals("iput"))
        {

        }

        else new ExceptionOutputter().getOutput(ExceptionList.UNDEFINED_RESERVED_METHOD);

    }

    private boolean isExist(String varName, Integer varType, Integer datatype, VariableStorage var, ArrayStorage arr)
    {
        boolean isExist = false;

        for (int i = 0; i < 9; i++)
        {
            ArrayList<String> varTemp = var.getVarNames(i);
            ArrayList<String> arrTemp = arr.getVarNames(i);

            for (int j = 0; j < varTemp.size(); j++)
            {
                if (varName.equals(varTemp.get(j)))
                {
                    isExist = true;
                    varType = 0;
                    datatype = i;

                    break;
                }
            }

            if (!isExist)
            {
                for (int j = 0; j < arrTemp.size(); j++)
                {
                    if (varName.equals(arrTemp.get(j)))
                    {
                        isExist = true;
                        varType = 1;
                        datatype = i;

                        break;
                    }
                }
            }

            if (isExist) break;

        }

        return isExist;
    }

}
