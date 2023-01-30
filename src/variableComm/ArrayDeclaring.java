package variableComm;

import exceptionHandling.ExceptionList;
import output.ExceptionOutputter;
import predefinedDatatypes.Binary;
import predefinedDatatypes.ExpandedBoolean;
import predefinedDatatypes.NumericBoolean;
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
        String arrayName = null;

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
                        arrayName = command.get(location);
                        isDefined = true;
                        location++;
                    }
                    break;
                case "alnum":
                    if (isUnique(1, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(1, temp, command.get(location));
                        arrayName = command.get(location);
                        isDefined = true;
                        location++;
                    }
                    break;

                case "asnum":
                    if (isUnique(2, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(2, temp, command.get(location));
                        arrayName = command.get(location);
                        isDefined = true;
                        location++;
                    }
                    break;

                case "abnum":
                    if (isUnique(3, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(3, temp, command.get(location));
                        arrayName = command.get(location);
                        isDefined = true;
                        location++;
                    }
                    break;

                case "abin":
                    if (isUnique(4, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(4, temp, command.get(location));
                        arrayName = command.get(location);
                        isDefined = true;
                        location++;
                    }
                    break;

                case "atruth":
                    if (isUnique(5, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(5, temp, command.get(location));
                        arrayName = command.get(location);
                        isDefined = true;
                        location++;
                    }
                    break;

                case "altruth":
                    if (isUnique(6, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(6, temp, command.get(location));
                        arrayName = command.get(location);
                        isDefined = true;
                        location++;
                    }
                    break;

                case "asym":
                    if (isUnique(7, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(7, temp, command.get(location));
                        arrayName = command.get(location);
                        isDefined = true;
                        location++;
                    }
                    break;

                case "alsym":
                    if (isUnique(8, command.get(location), arr))
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        arr.createArray(8, temp, command.get(location));
                        arrayName = command.get(location);
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

                if (command.get(location).equals("<"))
                {

                    location++;

                    while (!command.get(location).equals(">"))
                    {

                        if (datatype.equals("anum"))
                        {
                            if (isInteger(command.get(location)))
                            {
                                arr.addItem(arrayName, Integer.parseInt(command.get(location)));
                                location++;
                            }
                            else new ExceptionOutputter().getOutput(ExceptionList.NOT_INTEGER);
                        }

                        else if (datatype.equals("alnum"))
                        {
                            if (isLong(command.get(location)))
                            {
                                arr.addItem(arrayName, Long.parseLong(command.get(location)));
                                location++;
                            }
                            else new ExceptionOutputter().getOutput(ExceptionList.NOT_LONG);
                        }

                        else if (datatype.equals("asnum"))
                        {
                            if (isDouble(command.get(location)))
                            {
                                arr.addItem(arrayName, Double.parseDouble(command.get(location)));
                                location++;
                            }
                            else new ExceptionOutputter().getOutput(ExceptionList.NOT_DOUBLE);
                        }

                        else if (datatype.equals("abnum"))
                        {
                            if (isInteger(command.get(location)))
                            {
                                NumericBoolean temp = new NumericBoolean(Integer.parseInt(command.get(location)));
                                arr.addItem(arrayName, temp);
                                location++;
                            }
                            else new ExceptionOutputter().getOutput(ExceptionList.NOT_INTEGER);
                        }

                        else if (datatype.equals("abin"))
                        {
                            Binary temp = new Binary(command.get(location));
                            arr.addItem(arrayName, temp);
                            location++;
                        }

                        else if (datatype.equals("atruth"))
                        {
                            Boolean temp;

                            if (command.get(location).equals("nil")) temp = null;
                            else if (command.get(location).equals("true") || command.get(location).equals("false")) temp = Boolean.parseBoolean(command.get(location));
                            else new ExceptionOutputter().getOutput(ExceptionList.NOT_BOOLEAN);

                            location++;
                        }

                        else if (datatype.equals("altruth"))
                        {
                            ExpandedBoolean temp = new ExpandedBoolean(command.get(location));
                            arr.addItem(arrayName, temp);
                            location++;
                        }

                        else if (datatype.equals("asym"))
                        {

                            Character temp = command.get(location).charAt(0);
                            arr.addItem(arrayName, temp);
                            location++;
                        }

                        else if (datatype.equals("alsym"))
                        {
                            arr.addItem(arrayName, command.get(location));
                            location++;
                        }

                    }

                }
                else new ExceptionOutputter().getOutput(ExceptionList.DECLARETION_ERROR);

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

    private boolean isLong(String value)
    {
        boolean isOkay = true;

        try
        {
            Long val = Long.parseLong(value);
        }
        catch (Exception e)
        {
            isOkay = false;
        }

        return isOkay;
    }

    private boolean isDouble(String value)
    {
        boolean isOkay = true;


        try
        {
            Double val = Double.parseDouble(value);
        }
        catch (Exception e)
        {
            isOkay = false;
        }

        return isOkay;
    }
}
