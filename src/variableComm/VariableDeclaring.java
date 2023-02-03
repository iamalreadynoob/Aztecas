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

    public VariableDeclaring(ArrayList<String> command, VariableStorage var)
    {

        this.command = command;

        int location = 0;
        String datatype = null;

        if (tryDatatype(command.get(location)))
        {
            datatype = command.get(location);
            location++;
        }
        else new ExceptionOutputter().getOutput(ExceptionList.UNDEFINED_DATATYPE);

        if (isVariable(command.get(location)))
        {
            boolean isDefined = false;

            switch (datatype)
            {
                case "num":
                    if (isUnique(command.get(location), var))
                    {
                        var.addName(command.get(location), 0);
                        location++;
                        isDefined = true;
                    }
                    break;

                case "lnum":
                    if (isUnique(command.get(location), var))
                    {
                        var.addName(command.get(location), 1);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "snum":
                    if (isUnique(command.get(location), var))
                    {
                        var.addName(command.get(location), 2);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "bnum":
                    if (isUnique(command.get(location), var))
                    {
                        var.addName(command.get(location), 3);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "bin":
                    if (isUnique(command.get(location), var))
                    {
                        var.addName(command.get(location), 4);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "truth":
                    if (isUnique(command.get(location), var))
                    {
                        var.addName(command.get(location), 5);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "ltruth":
                    if (isUnique(command.get(location), var))
                    {
                        var.addName(command.get(location), 6);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "sym":
                    if (isUnique(command.get(location), var))
                    {
                        var.addName(command.get(location), 7);
                        location++;
                        isDefined = true;
                    }

                    break;

                case "lsym":
                    if (isUnique(command.get(location), var))
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


        if(location >= command.size()) addValAsNull(datatype, var);

        else if (command.get(location).equals("="))
        {
            location++;

            addValue(datatype, location, var);

        }

        else if (command.get(location).equals(","))
        {
            location++;

            int varAmount = 1;

            while (command.get(location).equals(","))
            {

                if (varAmount != 1) location++;

                if (isVariable(command.get(location)))
                {
                    boolean isDefined = false;

                    switch (datatype)
                    {
                        case "num":
                            if (isUnique(command.get(location), var))
                            {
                                var.addName(command.get(location), 0);
                                location++;
                                isDefined = true;
                            }
                            break;

                        case "lnum":
                            if (isUnique(command.get(location), var))
                            {
                                var.addName(command.get(location), 1);
                                location++;
                                isDefined = true;
                            }
                            break;

                        case "snum":
                            if (isUnique(command.get(location), var))
                            {
                                var.addName(command.get(location), 2);
                                location++;
                                isDefined = true;
                            }
                            break;

                        case "bnum":
                            if (isUnique(command.get(location), var))
                            {
                                var.addName(command.get(location), 3);
                                location++;
                                isDefined = true;
                            }
                            break;

                        case "bin":
                            if (isUnique(command.get(location), var))
                            {
                                var.addName(command.get(location), 4);
                                location++;
                                isDefined = true;
                            }
                            break;

                        case "truth":
                            if (isUnique(command.get(location), var))
                            {
                                var.addName(command.get(location), 5);
                                location++;
                                isDefined = true;
                            }
                            break;

                        case "ltruth":
                            if (isUnique(command.get(location), var))
                            {
                                var.addName(command.get(location), 6);
                                location++;
                                isDefined = true;
                            }
                            break;

                        case "sym":
                            if (isUnique(command.get(location), var))
                            {
                                var.addName(command.get(location), 7);
                                location++;
                                isDefined = true;
                            }
                            break;

                        case "lsym":
                            if (isUnique(command.get(location), var))
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

                varAmount++;
                location++;

            }

            if (location >= command.size())
            {
                for (int i = 0; i < varAmount; i++)
                {
                    addValAsNull(datatype, var);
                }
            }

            else
            {
                int defined = 0;

                while (location >= command.size())
                {
                    addValue(datatype, location, var);
                    location++;
                    defined++;
                }

                if (defined != varAmount)
                {
                    while (defined != varAmount)
                    {
                        addValAsNull(datatype, var);
                        defined++;
                    }
                }
            }

        }

        else new ExceptionOutputter().getOutput(ExceptionList.DECLARETION_ERROR);


    }

    private void addValAsNull(String datatype, VariableStorage var)
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

    private void addValue(String datatype, int location, VariableStorage var)
    {
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
                Integer numericVal = null;
                if (isInteger(command.get(location))) numericVal = Integer.parseInt(command.get(location));
                else new ExceptionOutputter().getOutput(ExceptionList.NOT_INTEGER);
                var.insideAdd(numericVal);
                break;

            case "bin":
                String binaryVal = command.get(location);
                var.insideAdd(binaryVal, 0);
                break;

            case "truth":
                Boolean boolVal = null;
                if (command.get(location).equals("nil")) boolVal = null;
                else if (command.get(location).equals("true") || command.get(location).equals("false")) boolVal = Boolean.parseBoolean(command.get(location));
                else new ExceptionOutputter().getOutput(ExceptionList.NOT_BOOLEAN);
                var.add(boolVal);
                break;

            case "ltruth":
                String expandedVal = command.get(location);
                var.insideAdd(expandedVal, 1);
                break;

            case "sym":
                Character symVal = command.get(location).charAt(0);
                var.add(symVal);
                break;

            case "lsym":
                String strVal = command.get(location);
                var.add(strVal);
                break;

        }
    }

    private boolean tryDatatype(String type)
    {
        String[] datatypes = {"num", "lnum", "snum", "bnum", "bin", "truth", "ltruth", "sym", "lsym"};

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

    private boolean isUnique(String name, VariableStorage var)
    {
        boolean isOkay = true;

        for (int i = 0; i < 9; i++)
        {
            ArrayList<String> temp = var.getVarNames(i);
            if (temp != null)
            {

                for (int j = 0; j < temp.size(); j++)
                {

                    if (name.equals(temp.get(j)))
                    {
                        isOkay = false;
                        break;
                    }

                }

            }

            if (!isOkay) break;

        }

        return isOkay;
    }



}
