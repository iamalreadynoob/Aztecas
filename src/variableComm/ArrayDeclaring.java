package variableComm;

import exceptionHandling.ExceptionList;
import output.ExceptionOutputter;
import storage.ArrayStorage;
import storage.VariableStorage;

import java.util.ArrayList;

public class ArrayDeclaring
{

    ArrayList<String> command = null;

    public ArrayDeclaring(ArrayList<String> command, ArrayStorage arr)
    {

        this.command = command;

        int location = 0;
        String datatype = null;

        if (isDatatype(command.get(location)))
        {
            datatype = command.get(location);
            location++;
        }
        else new ExceptionOutputter().getOutput(ExceptionList.UNDEFINED_DATATYPE);

        if (isArray(command.get(location)))
        {
            boolean isDefined = false;

            switch (datatype)
            {
                case "anum":
                    if (isUnique(0, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(0, temp, command.get(location));
                    }

            }

            if (!isDefined) new ExceptionOutputter().getOutput(ExceptionList.EXIST_VARIABLE_NAME);
        }
        else new ExceptionOutputter().getOutput(ExceptionList.AVOIDED_VARIABLE_NAME);

    }


    private boolean isDatatype(String type)
    {
        String[] datatypes = {"anum", "alnum", "asnum", "abnum", "abin", "atruth", "altruth", "asym", "alsym"};

        boolean isDatatype = false;

        for (int i = 0; i < datatypes.length; i++)
        {

            if (type.equals(datatypes[i]))
            {
                isDatatype = true;
                break;
            }

        }


        return isDatatype;
    }

    private boolean isArray(String variable)
    {
        char[] avoidedCharacters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ';', ',', '<', '>', '=', '.', '\"'};

        boolean isOkay = true;


        for (int i = 0; i < variable.length(); i++)
        {

            for (int j = 0; j < avoidedCharacters.length; j++)
            {
                if (variable.charAt(i) == avoidedCharacters[j])
                {
                    isOkay = false;
                    break;
                }
            }

            if (!isOkay) break;

        }


        return isOkay;
    }

    private boolean isUnique(int typeCode, String name, ArrayStorage var)
    {
        boolean isOkay = true;

        ArrayList<String> temp = var.getVarNames(typeCode);

        for (int i = 0; i < temp.size(); i++)
        {

            if (name.equals(temp.get(i)))
            {
                isOkay = false;
                break;
            }

        }


        return isOkay;
    }

    private boolean isInteger(String value)
    {
        boolean isOkay = true;

        try
        {
            Integer val = Integer.parseInt(value);
        }
        catch (Exception e)
        {
            isOkay = false;
        }

        return isOkay;
    }
}
