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
                        isDefined = true;
                        location++;
                    }
                    break;
                case "alnum":
                    if (isUnique(1, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(1, temp, command.get(location));
                        isDefined = true;
                        location++;
                    }
                    break;

                case "asnum":
                    if (isUnique(2, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(2, temp, command.get(location));
                        isDefined = true;
                        location++;
                    }
                    break;

                case "abnum":
                    if (isUnique(3, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(3, temp, command.get(location));
                        isDefined = true;
                        location++;
                    }
                    break;

                case "abin":
                    if (isUnique(4, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(4, temp, command.get(location));
                        isDefined = true;
                        location++;
                    }
                    break;

                case "atruth":
                    if (isUnique(5, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(5, temp, command.get(location));
                        isDefined = true;
                        location++;
                    }
                    break;

                case "altruth":
                    if (isUnique(6, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(6, temp, command.get(location));
                        isDefined = true;
                        location++;
                    }
                    break;

                case "asym":
                    if (isUnique(7, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(7, temp, command.get(location));
                        isDefined = true;
                        location++;
                    }
                    break;

                case "alsym":
                    if (isUnique(8, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(8, temp, command.get(location));
                        isDefined = true;
                        location++;
                    }
                    break;

            }

            if (!isDefined) new ExceptionOutputter().getOutput(ExceptionList.EXIST_VARIABLE_NAME);
        }
        else new ExceptionOutputter().getOutput(ExceptionList.AVOIDED_VARIABLE_NAME);

        if (location < command.size())
        {
            if (command.get(location).equals("="))
            {

                location++;

            }

            else new ExceptionOutputter().getOutput(ExceptionList.DECLARETION_ERROR);
        }

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
