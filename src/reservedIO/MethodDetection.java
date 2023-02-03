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
            int plus = 0;

            while (location < command.size())
            {
                String varName = command.get(location);
                Integer[] varType = new Integer[1];
                Integer[] datatype = new Integer[1];

                if (command.get(location).equals("\""))
                {
                    location++;

                    String soutput = null;

                    while (!command.get(location).equals("\""))
                    {
                        if (soutput.equals(null)) output = command.get(location);
                        else soutput = soutput + " " + command.get(location);

                        location++;
                    }

                    if (plus == 0) output = soutput;
                    else if (plus == 1) output += soutput;
                    else if (plus == 2) output = output + " " + soutput;

                    location++;
                }

                else if (isExist(varName, varType, datatype, var, arr))
                {

                    switch (datatype[0])
                    {
                        case 0:
                            if (varType[0] == 0)
                            {
                                Integer value = var.getNum(varName);

                                if (plus == 0) output = Integer.toString(value);
                                else if (plus == 1) output += Integer.toString(value);
                                else if (plus == 2) output = output + " " + Integer.toString(value);
                            }

                            else if (varType[0] == 1)
                            {
                                location++;

                                if (command.get(location).equals("at"))
                                {
                                    location++;
                                    Integer arrIndex = Integer.parseInt(command.get(location));
                                    Integer value = arr.getAnumItem(varName, arrIndex);

                                    if (plus == 0) output = Integer.toString(value);
                                    else if (plus == 1)  output += Integer.toString(value);
                                    else if (plus == 2) output = output + " " + Integer.toString(value);

                                }

                                else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                {
                                    Integer length = arr.getLength(varName);

                                    for (int i = 0; i < length; i++)
                                    {
                                        if (plus == 0 || plus == 2) output = output + " " + Integer.toString(arr.getAnumItem(varName, i));
                                        else if (plus == 1) output += Integer.toString(arr.getAnumItem(varName, i));
                                    }

                                }

                                else new ExceptionOutputter().getOutput(ExceptionList.UNEXPECTED_OPERATOR);

                            }
                            break;

                        case 1:
                            if (varType[0] == 0)
                            {
                                Long value = var.getLnum(varName);

                                if (plus == 0) output = Long.toString(value);
                                else if (plus == 1) output += Long.toString(value);
                                else if (plus == 2) output = output + " " + Long.toString(value);
                            }

                            else if (varType[0] == 1)
                            {
                                location++;

                                if (command.get(location).equals("at"))
                                {
                                    location++;
                                    Integer arrIndex = Integer.parseInt(command.get(location));
                                    Long value = arr.getAlnumItem(varName, arrIndex);

                                    if (plus == 0) output = Long.toString(value);
                                    else if (plus == 1) output += Long.toString(value);
                                    else if (plus == 2) output = output + " " + Long.toString(value);
                                }

                                else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                {
                                    Integer length = arr.getLength(varName);

                                    for (int i = 0; i < length; i++)
                                    {
                                        if (plus == 0 || plus == 2) output = output + " " + Long.toString(arr.getAlnumItem(varName, i));
                                        else if (plus == 1) output += Long.toString(arr.getAlnumItem(varName, i));
                                    }
                                }
                            }

                            break;

                        case 2:
                            if (varType[0] == 0)
                            {
                                Double value = var.getSnum(varName);

                                if (plus == 0) output = Double.toString(value);
                                else if (plus == 1) output += Double.toString(value);
                                else if (plus == 2) output = output + " " + Double.toString(value);
                            }

                            else if (varType[0] == 1)
                            {
                                location++;

                                if (command.get(location).equals("at"))
                                {
                                    location++;
                                    Integer arrIndex = Integer.parseInt(command.get(location));
                                    Double value = arr.getAsnumItem(varName, arrIndex);

                                    if (plus == 0) output = Double.toString(value);
                                    else if (plus == 1) output += Double.toString(value);
                                    else if (plus == 2) output = output + " " + Double.toString(value);
                                }

                                else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                {
                                    Integer length = arr.getLength(varName);

                                    for (int i = 0; i < length; i++)
                                    {
                                        if (plus == 0 || plus == 2) output = output + " " + Double.toString(arr.getAsnumItem(varName, i));
                                        else if (plus == 1) output += Double.toString(arr.getAsnumItem(varName, i));
                                    }
                                }
                            }

                            break;

                        case 3:
                            if (varType[0] == 0)
                            {
                                Integer value = var.getBnum(varName).getValue();

                                if (plus == 0) output = Integer.toString(value);
                                else if (plus == 1) output += Integer.toString(value);
                                else if (plus == 2) output = output + " " + Integer.toString(value);
                            }

                            else if (varType[0] == 1)
                            {
                                location++;

                                if (command.get(location).equals("at"))
                                {
                                    location++;
                                    Integer arrIndex = Integer.parseInt(command.get(location));
                                    Integer value = arr.getAbnumItem(varName, arrIndex).getValue();

                                    if (plus == 0) output = Integer.toString(value);
                                    else if (plus == 1) output += Integer.toString(value);
                                    else if (plus == 2) output = output + " " + Integer.toString(value);
                                }

                                else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                {
                                    Integer length = arr.getLength(varName);

                                    for (int i = 0; i < length; i++)
                                    {
                                        if (plus == 0 || plus == 2) output = output + " " + Integer.toString(arr.getAnumItem(varName, i));
                                        else if (plus == 1) output += Integer.toString(arr.getAbnumItem(varName, i).getValue());
                                    }
                                }
                            }

                            break;

                        case 4:
                            if (varType[0] == 0)
                            {
                                String value = var.getBin(varName).getValue();

                                if (plus == 0) output = value;
                                else if (plus == 1) output += value;
                                else if (plus == 2) output = output + " " + value;
                            }

                            else if (varType[0] == 1)
                            {
                                location++;

                                if (command.get(location).equals("at"))
                                {
                                    location++;
                                    Integer arrIndex = Integer.parseInt(command.get(location));
                                    String value = arr.getAbinItem(varName, arrIndex).getValue();

                                    if (plus == 0) output = value;
                                    else if (plus == 1) output += value;
                                    else if (plus == 2) output = output + " " + value;
                                }

                                else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                {
                                    Integer length = arr.getLength(varName);

                                    for (int i = 0; i < length; i++)
                                    {
                                        if (plus == 0 || plus == 2) output = output + " " + arr.getAbinItem(varName, i).getValue();
                                        else if (plus == 1) output += arr.getAbinItem(varName, i).getValue();
                                    }
                                }
                            }

                            break;

                        case 5:
                            if (varType[0] == 0)
                            {
                                Boolean value = var.getTruth(varName);

                                if (plus == 0) output = Boolean.toString(value);
                                else if (plus == 1) output += Boolean.toString(value);
                                else if (plus == 2) output = output + " " + Boolean.toString(value);
                            }

                            else if (varType[0] == 1)
                            {
                                location++;

                                if (command.get(location).equals("at"))
                                {
                                    location++;
                                    Integer arrIndex = Integer.parseInt(command.get(location));
                                    Boolean value = arr.getAtruthItem(varName, arrIndex);

                                    if (plus == 0) output = Boolean.toString(value);
                                    else if (plus == 1) output += Boolean.toString(value);
                                    else if (plus == 2) output = output + " " + Boolean.toString(value);
                                }

                                else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                {
                                    Integer length = arr.getLength(varName);

                                    for (int i = 0; i < length; i++)
                                    {
                                        if (plus == 0 || plus == 2) output = output + " " + Boolean.toString(arr.getAtruthItem(varName, i));
                                        else if (plus == 1) output += Boolean.toString(arr.getAtruthItem(varName, i));
                                    }
                                }
                            }

                            break;

                        case 6:
                            if (varType[0] == 0)
                            {
                                String value = var.getLtruth(varName).getValue();

                                if (plus == 0) output = value;
                                else if (plus == 1) output += value;
                                else if (plus == 2) output = output + " " + value;
                            }

                            else if (varType[0] == 1)
                            {
                                location++;

                                if (command.get(location).equals("at"))
                                {
                                    location++;
                                    Integer arrIndex = Integer.parseInt(command.get(location));
                                    String value = arr.getAltruthItem(varName, arrIndex).getValue();

                                    if (plus == 0) output = value;
                                    else if (plus == 1) output += value;
                                    else if (plus == 2) output = output + " " + value;
                                }

                                else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                {
                                    Integer length = arr.getLength(varName);

                                    for (int i = 0; i < length; i++)
                                    {
                                        if (plus == 0 || plus == 2) output = output + " " + arr.getAltruthItem(varName, i).getValue();
                                        else if (plus == 1) output += arr.getAltruthItem(varName, i).getValue();
                                    }
                                }
                            }

                            break;

                        case 7:
                            if (varType[0] == 0)
                            {
                                Character value = var.getSym(varName);

                                if (plus == 0) output = Character.toString(value);
                                else if (plus == 1) output += Character.toString(value);
                                else if (plus == 2) output = output + " " + Character.toString(value);
                            }

                            else if (varType[0] == 1)
                            {
                                location++;

                                if (command.get(location).equals("at"))
                                {
                                    location++;
                                    Integer arrIndex = Integer.parseInt(command.get(location));
                                    Character value = arr.getAsymItem(varName, arrIndex);

                                    if (plus == 0) output = Character.toString(value);
                                    else if (plus == 1) output += Character.toString(value);
                                    else if (plus == 2) output = output + " " + Character.toString(value);
                                }

                                else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                {
                                    Integer length = arr.getLength(varName);

                                    for (int i = 0; i < length; i++)
                                    {
                                        if (plus == 0 || plus == 2) output = output + " " + Character.toString(arr.getAsymItem(varName, i));
                                        else if (plus == 1) output += Character.toString(arr.getAsymItem(varName, i));
                                    }
                                }
                            }

                            break;

                        case 8:
                            if (varType[0] == 0)
                            {
                                String value = var.getLsym(varName);

                                if (plus == 0) output = value;
                                else if (plus == 1) output += value;
                                else if (plus == 2) output = output + " " + value;
                            }

                            else if (varType[0] == 1)
                            {
                                location++;

                                if (command.get(location).equals("at"))
                                {
                                    location++;
                                    Integer arrIndex = Integer.parseInt(command.get(location));
                                    String value = arr.getAlsymItem(varName, arrIndex);

                                    if (plus == 0) output = value;
                                    else if (plus == 1) output += value;
                                    else if (plus == 2) output = output + " " + value;
                                }

                                else if (location >= command.size() || command.get(location).equals("+") || command.get(location).equals("++"))
                                {
                                    Integer length = arr.getLength(varName);

                                    for (int i = 0; i < length; i++)
                                    {
                                        if (plus == 0 || plus == 2) output = output + " " + arr.getAlsymItem(varName, i);
                                        else if (plus == 1) output += arr.getAlsymItem(varName, i);
                                    }
                                }
                            }

                            break;
                    }

                    if (varType[0] == 0) location++;

                }

                else if (command.get(location).equals("+"))
                {
                    location++;
                    plus = 1;
                }

                else if (command.get(location).equals("++"))
                {
                    location++;
                    plus = 2;
                }

            }

        }

        else if (command.get(location).equals("iput"))
        {

        }

        else new ExceptionOutputter().getOutput(ExceptionList.UNDEFINED_RESERVED_METHOD);

    }

    private boolean isExist(String varName, Integer[] varType, Integer[] datatype, VariableStorage var, ArrayStorage arr)
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
                    varType[0] = 0;
                    datatype[0] = i;

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
                        varType[0] = 1;
                        datatype[0] = i;

                        break;
                    }
                }
            }

            if (isExist) break;

        }

        return isExist;
    }

    private boolean isExist(String varName, VariableStorage var, ArrayStorage arr)
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
                        break;
                    }
                }
            }

            if (isExist) break;

        }

        return isExist;
    }

}
