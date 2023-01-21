package variableComm;

import exceptionHandling.ExceptionList;
import output.ExceptionOutputter;
import predefinedDatatypes.Binary;
import predefinedDatatypes.ExpandedBoolean;
import predefinedDatatypes.NumericBoolean;
import storage.ArrayStorage;
import storage.VariableStorage;

import javax.sound.sampled.FloatControl;
import java.util.ArrayList;

public class VariableDeclaring
{

    ArrayList<String> command;

    public VariableDeclaring(ArrayList<String> command, VariableStorage var, ArrayStorage arr)
    {

        this.command = command;

        int location = 0;
        String datatype = null;

        if (tryDatatype(command.get(location)))
        {
            datatype = command.get(location);
            location++;
        }
        else
        {
            ExceptionOutputter out = new ExceptionOutputter();
            out.getOutput(ExceptionList.UNDEFINED_DATATYPE);
        }

        if (isVariable(command.get(location)))
        {
            boolean isDefined = false;

            switch (datatype)
            {
                case "num":
                    if (isUnique(0, command.get(location), var))
                    {
                        var.addName(command.get(location), 0);
                        location++;
                        isDefined = true;
                    }
                    break;

                case "lnum":
                    if (isUnique(1, command.get(location), var))
                    {
                        var.addName(command.get(location), 1);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "snum":
                    if (isUnique(2, command.get(location), var))
                    {
                        var.addName(command.get(location), 2);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "bnum":
                    if (isUnique(3, command.get(location), var))
                    {
                        var.addName(command.get(location), 3);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "bin":
                    if (isUnique(4, command.get(location), var))
                    {
                        var.addName(command.get(location), 4);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "truth":
                    if (isUnique(5, command.get(location), var))
                    {
                        var.addName(command.get(location), 5);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "ltruth":
                    if (isUnique(6, command.get(location), var))
                    {
                        var.addName(command.get(location), 6);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "sym":
                    if (isUnique(7, command.get(location), var))
                    {
                        var.addName(command.get(location), 7);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "lsym":
                    if (isUnique(8, command.get(location), var))
                    {
                        var.addName(command.get(location), 8);
                        location++;
                        isDefined = true;
                    }

                    break;

            }

            if (!isDefined) new ExceptionOutputter().getOutput(ExceptionList.EXIST_VARIABLE_NAME);


        }

        else new ExceptionOutputter().getOutput(ExceptionList.AVOIDED_VARIABLE_NAME);


        if(location >= command.size())
        {

            switch (datatype)
            {
                case "num":
                    var.add((Integer) null);
                    break;

                case "lnum":
                    var.add((Long) null);
                    break;

                case "snum":
                    var.add((Double) null);
                    break;

                case "bnum":
                    var.add((NumericBoolean) null);
                    break;

                case "bin":
                    var.add((Binary) null);
                    break;

                case "truth":
                    var.add((Boolean) null);
                    break;

                case "ltruth":
                    var.add((ExpandedBoolean) null);
                    break;

                case "sym":
                    var.add((Character) null);
                    break;

                case "lsym":
                    var.add((String) null);
            }

        }

        else if (command.get(location).equals("="))
        {
            location++;

            switch (datatype)
            {
                case "num":
                    Integer intVal = null;
                    if (command.get(location).equals("nil")) intVal = null;
                    else if (isInteger(command.get(location))) intVal = Integer.parseInt(command.get(location));
                    else new ExceptionOutputter().getOutput(ExceptionList.NOT_INTEGER);
                    var.add(intVal);
                    break;

                case "lnum":
                    Long longVal = null;
                    if (command.get(location).equals("nil")) longVal = null;
                    else if (isLong(command.get(location))) longVal = Long.parseLong(command.get(location));
                    else new ExceptionOutputter().getOutput(ExceptionList.NOT_LONG);
                    var.add(longVal);
                    break;

                case "snum":
                    Double doubleVal = null;
                    if (command.get(location).equals("nil")) doubleVal = null;
                    else if (isDouble(command.get(location))) doubleVal = Double.parseDouble(command.get(location));
                    else new ExceptionOutputter().getOutput(ExceptionList.NOT_DOUBLE);
                    var.add(doubleVal);
                    break;

                case "bnum":
                    Short shortVal = null;
                    if (command.get(location).equals("nil")) shortVal = null;
                    else if ()

            }

        }


    }


    private boolean tryDatatype(String type)
    {
        String[] datatypes = {"num", "lnum", "snum", "bnum", "bin", "truth", "ltruth", "sym", "lsym", "anum", "alnum", "asnum", "abnum", "abin", "atruth", "altruth", "asym", "alsym"};

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

    private boolean isVariable(String variable)
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

    private boolean isNumericBoolean(String value)
    {
        boolean isOkay = true;

        Short val = null;

        try
        {
            val = Short.parseShort(value);
        }
        catch (Exception e)
        {
            isOkay = false;
        }

        if (isOkay && val != 0 && val != 1) isOkay = false;



        return isOkay;
    }

    private boolean isUnique(int typeCode, String name, VariableStorage var)
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



}
