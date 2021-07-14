class Finder extends AtomicInfo
{

    String getElementName(String element)
    {
        for(int i = 0; i < elements.length; i++)
        {
            if(element.equals(elements[i].substring(elements[i].length() - element.length())))
            {
                return "Element " + (i + 1) + ", MM: "+ atomicMass[i];
            }
        }
        return "Element not found check spelling or capitalization. . .";
    }

    boolean isElement(String element)
    {
        for (String s : elements) {
            if (element.equals(s.substring(s.length() - element.length()))) {
                return true;
            }
        }
        return false;
    }

    String elementName(String element)
    {
        for (String s : elements) {
            String atomicSymbol = s.substring(s.length() - element.length());
            if (element.equals(atomicSymbol)) {
                return atomicSymbol;
            }
        }
        return "Enter a valid element";
    }

    String getElementNumber(int e)
    {
        if (e < elements.length)
        {
            return (elements[e - 1]+ " MM: " +atomicMass[e - 1]);
        }
        else
            return "Element not found please check your number. . .";
    }


    int getAtomicNumber(String element)
    {
        for(int i = 0; i < atomicMass.length; i++)
        {
            if(element.equals(elements[i].substring(elements[i].length() - element.length())))
            {
                return i;
            }
        }
        return 1;
    }


    double getAtomicMass(int atomicNumber)
    {
        return atomicMass[atomicNumber];
    }


}
