package storage;

import predefinedDatatypes.Binary;
import predefinedDatatypes.ExpandedBoolean;
import predefinedDatatypes.NumericBoolean;

import java.util.ArrayList;

public class ArrayStorage
{

    private ArrayList<ArrayList<Integer>> anumV = null;
    private ArrayList<ArrayList<Long>> alnumV = null;
    private ArrayList<ArrayList<Double>> asnumV = null;
    private ArrayList<ArrayList<NumericBoolean>> abnumV = null;
    private ArrayList<ArrayList<Binary>> abinV = null;
    private ArrayList<ArrayList<Boolean>> atruthV = null;
    private ArrayList<ArrayList<ExpandedBoolean>> altruthV = null;
    private ArrayList<ArrayList<Character>> asymV = null;
    private ArrayList<ArrayList<String>> alsymV = null;

    //array name
    private ArrayList<String> anumN = null;
    private ArrayList<String> alnumN = null;
    private ArrayList<String> asnumN = null;
    private ArrayList<String> abnumN = null;
    private ArrayList<String> abinN = null;
    private ArrayList<String> atruthN = null;
    private ArrayList<String> altruthN = null;
    private ArrayList<String> asymN = null;
    private ArrayList<String> alsymN = null;


    public void createArray(int typeCode, ArrayList array, String name)
    {
        switch (typeCode)
        {
            case 0:
                anumV.add(array);
                anumN.add(name);
                break;

            case 1:
                alnumV.add(array);
                alnumN.add(name);
                break;

            case 2:
                asnumV.add(array);
                asnumN.add(name);
                break;

            case 3:
                abnumV.add(array);
                abnumN.add(name);
                break;

            case 4:
                abinV.add(array);
                abinN.add(name);
                break;

            case 5:
                atruthV.add(array);
                atruthN.add(name);
                break;

            case 6:
                altruthV.add(array);
                altruthN.add(name);
                break;

            case 7:
                asymV.add(array);
                asymN.add(name);
                break;

            case 8:
                alsymV.add(array);
                alsymN.add(name);
                break;
        }
    }

    public void addItem(String name, Integer value)
    {
        Integer location = locationFinder(name, anumN);

        anumV.get(location).add(value);
    }

    public void addItem(String name, Long value)
    {
        Integer location = locationFinder(name, alnumN);

        alnumV.get(location).add(value);
    }

    public void addItem(String name, Double value)
    {
        Integer location = locationFinder(name, asnumN);

        asnumV.get(location).add(value);
    }

    public void addItem(String name, NumericBoolean value)
    {
        Integer location = locationFinder(name, abnumN);

        abnumV.get(location).add(value);
    }

    public void addItem(String name, Binary value)
    {
        Integer location = locationFinder(name, abinN);

        abinV.get(location).add(value);
    }


    public void addItem(String name, Boolean value)
    {
        Integer location = locationFinder(name, atruthN);

        atruthV.get(location).add(value);
    }


    public void addItem(String name, ExpandedBoolean value)
    {
        Integer location = locationFinder(name, altruthN);

        altruthV.get(location).add(value);
    }


    public void addItem(String name, Character value)
    {
        Integer location = locationFinder(name, asymN);

        asymV.get(location).add(value);
    }


    public void addItem(String name, String value)
    {
        Integer location = locationFinder(name, alsymN);

        alsymV.get(location).add(value);
    }


    public void setItem(String name, int index, Integer value)
    {
        Integer location = locationFinder(name, anumN);

        anumV.get(location).set(index, value);
    }


    public void setItem(String name, int index, Long value)
    {
        Integer location = locationFinder(name, alnumN);

        alnumV.get(location).set(index, value);
    }


    public void setItem(String name, int index, Double value)
    {
        Integer location = locationFinder(name, asnumN);

        asnumV.get(location).set(index, value);
    }

    public void setItem(String name, int index, NumericBoolean value)
    {
        Integer location = locationFinder(name, abnumN);

        abnumV.get(location).set(index, value);
    }


    public void setItem(String name, int index, Binary value)
    {
        Integer location = locationFinder(name, abinN);

        abinV.get(location).set(index, value);
    }



    public void setItem(String name, int index, Boolean value)
    {
        Integer location = locationFinder(name, atruthN);

        atruthV.get(location).set(index, value);
    }



    public void setItem(String name, int index, ExpandedBoolean value)
    {
        Integer location = locationFinder(name, altruthN);

        altruthV.get(location).set(index, value);
    }


    public void setItem(String name, int index, Character value)
    {
        Integer location = locationFinder(name, asymN);

        asymV.get(location).set(index, value);
    }



    public void setItem(String name, int index, String value)
    {
        Integer location = locationFinder(name, alsymN);

        alsymV.get(location).set(index, value);
    }


    //getter functions

    public ArrayList<String> getVarNames(int typeCode)
    {
        ArrayList<String> temp = null;

        switch (typeCode)
        {
            case 0:
                temp = anumN;
                break;

            case 1:
                temp = alnumN;
                break;

            case 2:
                temp = asnumN;
                break;

            case 3:
                temp = abnumN;
                break;

            case 4:
                temp = abinN;
                break;

            case 5:
                temp = atruthN;
                break;

            case 6:
                temp = altruthN;
                break;

            case 7:
                temp = asymN;
                break;

            case 8:
                temp = alsymN;
                break;
        }

        return temp;
    }

    public Integer getAnumItem(String name, int index)
    {
        Integer value = null;

        Integer location = locationFinder(name, anumN);

        if (location != null) value = anumV.get(location).get(index);

        return value;
    }

    public Long getAlnumItem(String name, int index)
    {
        Long value = null;

        Integer location = locationFinder(name, alnumN);

        if (location != null) value = alnumV.get(location).get(index);

        return value;
    }


    public Double getAsnumItem(String name, int index)
    {
        Double value = null;

        Integer location = locationFinder(name, asnumN);

        if (location != null) value = asnumV.get(location).get(index);

        return value;
    }


    public NumericBoolean getAbnumItem(String name, int index)
    {
        NumericBoolean value = null;

        Integer location = locationFinder(name, abnumN);

        if (location != null) value = abnumV.get(location).get(index);

        return value;
    }


    public Binary getAbinItem(String name, int index)
    {
        Binary value = null;

        Integer location = locationFinder(name, abinN);

        if (location != null) value = abinV.get(location).get(index);

        return value;
    }


    public Boolean getAtruthItem(String name, int index)
    {
        Boolean value = null;

        Integer location = locationFinder(name, atruthN);

        if (location != null) value = atruthV.get(location).get(index);

        return value;
    }


    public ExpandedBoolean getAltruthItem(String name, int index)
    {
        ExpandedBoolean value = null;

        Integer location = locationFinder(name, altruthN);

        if (location != null) value = altruthV.get(location).get(index);

        return value;
    }


    public Character getAsymItem(String name, int index)
    {
        Character value = null;

        Integer location = locationFinder(name, asymN);

        if (location != null) value = asymV.get(location).get(index);

        return value;
    }

    public String getAlsymItem(String name, int index)
    {
        String value = null;

        Integer location = locationFinder(name, alsymN);

        if (location != null) value = alsymV.get(location).get(index);

        return value;
    }


    private Integer locationFinder(String name, ArrayList namelist)
    {
        Integer location = null;

        for (int i = 0; i < namelist.size(); i++)
        {
            if (namelist.get(i).equals(name))
            {
                location = i;
                break;
            }

        }

        return location;
    }

}
