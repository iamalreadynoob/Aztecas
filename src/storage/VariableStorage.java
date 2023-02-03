package storage;

import predefinedDatatypes.Binary;
import predefinedDatatypes.ExpandedBoolean;
import predefinedDatatypes.NumericBoolean;

import java.util.ArrayList;

public class VariableStorage
{

    //Values
    private ArrayList<Integer> numV = new ArrayList<>();
    private ArrayList<Long> lnumV = new ArrayList<>();
    private ArrayList<Double> snumV = new ArrayList<>();
    private ArrayList<NumericBoolean> bnumV = new ArrayList<>();
    private ArrayList<Binary> binV = new ArrayList<>();
    private ArrayList<Boolean> truthV = new ArrayList<>();
    private ArrayList<ExpandedBoolean> ltruthV = new ArrayList<>();
    private ArrayList<Character> symV = new ArrayList<>();
    private ArrayList<String> lsymV = new ArrayList<>();

    //Names
    private ArrayList<String> numN = new ArrayList<>();
    private ArrayList<String> lnumN = new ArrayList<>();
    private ArrayList<String> snumN = new ArrayList<>();
    private ArrayList<String> bnumN = new ArrayList<>();
    private ArrayList<String> binN = new ArrayList<>();
    private ArrayList<String> truthN = new ArrayList<>();
    private ArrayList<String> ltruthN = new ArrayList<>();
    private ArrayList<String> symN = new ArrayList<>();
    private ArrayList<String> lsymN = new ArrayList<>();

    //getter methods

    public ArrayList<String> getVarNames(int typeCode)
    {
        ArrayList<String> temp = null;

        switch (typeCode)
        {
            case 0:
                temp = numN;
                break;

            case 1:
                temp = lnumN;
                break;

            case 2:
                temp = snumN;
                break;

            case 3:
                temp = bnumN;
                break;

            case 4:
                temp = binN;
                break;

            case 5:
                temp = truthN;
                break;

            case 6:
                temp = ltruthN;
                break;

            case 7:
                temp = symN;
                break;

            case 8:
                temp = lsymN;
                break;
        }

        return temp;
    }
    public Integer getNum(String name)
    {
        Integer location = locationFinder(name, numN);

        if (location != null) return numV.get(location);
        else return null;
    }

    public Long getLnum(String name)
    {
        Integer location = locationFinder(name, lnumN);

        if (location != null) return lnumV.get(location);
        else return null;
    }

    public Double getSnum(String name)
    {
        Integer location = locationFinder(name, snumN);

        if (location != null) return snumV.get(location);
        else return null;
    }

    public NumericBoolean getBnum(String name)
    {
        Integer location = locationFinder(name, bnumN);

        if (location != null) return bnumV.get(location);
        else return null;
    }

    public Binary getBin(String name)
    {
        Integer location = locationFinder(name, binN);

        if (location != null) return binV.get(location);
        else return null;
    }

    public Boolean getTruth(String name)
    {
        Integer location = locationFinder(name, truthN);

        if (location != null) return truthV.get(location);
        else return null;
    }

    public ExpandedBoolean getLtruth(String name)
    {
        Integer location = locationFinder(name, ltruthN);

        if (location != null) return ltruthV.get(location);
        else return null;
    }

    public Character getSym(String name)
    {
        Integer location = locationFinder(name, symN);

        if (location != null) return symV.get(location);
        else return null;
    }

    public String getLsym(String name)
    {
        Integer location = locationFinder(name, lsymN);

        if (location != null) return lsymV.get(location);
        else return null;
    }

    //setter methods

    public void setNum(String name, Integer value)
    {
        Integer location = locationFinder(name, numN);
        numV.set(location, value);

    }

    public void setLnum(String name, Long value)
    {
        Integer location = locationFinder(name, lnumN);
        lnumV.set(location, value);
    }

    public void setSnum(String name, Double value)
    {
        Integer location = locationFinder(name, snumN);
        snumV.set(location, value);
    }

    public void setBnum(String name, NumericBoolean value)
    {
        Integer location = locationFinder(name, bnumN);
        bnumV.get(location).setValue(value.getValue());
    }

    public void setBin(String name, Binary value)
    {
        Integer location = locationFinder(name, binN);
        binV.get(location).setValue(value.getValue());
    }

    public void setTruth(String name, Boolean value)
    {
        Integer location = locationFinder(name, truthN);
        truthV.set(location, value);
    }

    public void setLtruth(String name, ExpandedBoolean value)
    {
        Integer location = locationFinder(name, ltruthN);
        ltruthV.get(location).setValue(value.getValue());
    }

    public void setSym(String name, Character value)
    {
        Integer location = locationFinder(name, symN);
        symV.set(location, value);
    }

    public void setLsym(String name, String value)
    {
        Integer location = locationFinder(name, lsymN);
        lsymV.set(location, value);
    }

    //adder methods
    public void add(Integer value)
    {
        numV.add(value);
    }

    public void add(Long value)
    {
        lnumV.add(value);
    }

    public void add(Double value)
    {
        snumV.add(value);
    }

    public void add(NumericBoolean value)
    {
        bnumV.add(value);
    }

    public void add(Binary value)
    {
        binV.add(value);
    }

    public void add(Boolean value)
    {
        truthV.add(value);
    }

    public void add(ExpandedBoolean value)
    {
        ltruthV.add(value);
    }

    public void add(Character value)
    {
        symV.add(value);
    }

    public void add(String value)
    {
        lsymV.add(value);
    }

    public void insideAdd(Integer value)
    {
        NumericBoolean newNumeric = new NumericBoolean(value);
        bnumV.add(newNumeric);

    }

    public void insideAdd(String value, int typeCode)
    {

        switch (typeCode)
        {
            case 0:
                Binary newBinary = new Binary(value);
                binV.add(newBinary);
                break;

            case 1:
                ExpandedBoolean newExpanded = new ExpandedBoolean(value);
                ltruthV.add(newExpanded);
                break;
        }

    }

    public void addName(String name, int typeCode)
    {
        switch (typeCode)
        {
            case 0:
                numN.add(name);
                break;

            case 1:
                lnumN.add(name);
                break;

            case 2:
                snumN.add(name);
                break;

            case 3:
                bnumN.add(name);
                break;

            case 4:
                binN.add(name);
                break;

            case 5:
                truthN.add(name);
                break;

            case 6:
                ltruthN.add(name);
                break;

            case 7:
                symN.add(name);
                break;

            case 8:
                lsymN.add(name);
                break;
        }
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
