package output;

import exceptionHandling.ExceptionList;

public class ExceptionOutputter
{

    public void getOutput(ExceptionList exception)
    {

        switch (exception)
        {
            case UNDEFINED_DATATYPE:
                System.out.println("There is an undefined datatype");
                break;

            case AVOIDED_VARIABLE_NAME:
                System.out.println("There is an avoided variable name");
                break;

            case EXIST_VARIABLE_NAME:
                System.out.println("There is a variable which its name is already used");
                break;

            case NOT_INTEGER:
                System.out.println("Variable does not have an Integer value as excepted");
                break;

            case NOT_LONG:
                System.out.println("Variable does not have a Long value as excepted");
                break;

            case NOT_DOUBLE:
                System.out.println("Variable does not have a Double value as excepted");
                break;

            case NOT_BOOLEAN:
                System.out.println("Variable does not have a Boolean value as excepted");
                break;

            case DECLARETION_ERROR:
                System.out.println("There is a problem in declaretion");

        }

        System.exit(1);

    }

}
