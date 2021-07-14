import java.util.Scanner;
import java.util.ArrayList;

public class GetCompounds
{
    /*
    *   todo:
    *    - GOTTA FIGURE OUT THE WHOLE STOICH THING, HOW TO PROCESS REACTIONS
    *    - SEEMS LIKE MOST BUGS ARE SQUASHED RIGHT NOW SO YAY!
    *    - Diatomic ions
    *
    *
    * */



    Finder f = new Finder();

    protected ArrayList<String> compList = new ArrayList<String>();
    protected ArrayList<Integer> numElementsList = new ArrayList<Integer>();

    public double getCompound() {
        boolean isRunning = true;
        Scanner gsc = new Scanner(System.in);


        while (true) {
            try {
                String compound = "";
                System.out.print("List the elements in your starting compound one by one: ");
                compound = gsc.nextLine();

                if (f.isElement(compound)) {
                    compList.add(compound);
                    // Call get Numbers to get the amount of that element in the compound ex:  H 2 O 1
                    // But ONLY if a valid input is entered
                    numElementsList.add(getNumbers());
                } else if (compound.equals("fin")) {
                    break;
                } else {
                    System.out.println("Please enter a valid element (one at a time)");
                }
                
            } catch(Exception e) {
                System.out.println("Please do not enter a number at this step");
            }
            // End of while loop
        }


        double mass = 0.0;
        for(int i = 0; i < numElementsList.size(); i++) {
            mass += f.getAtomicMass(f.getAtomicNumber(compList.get(i))) * (double) numElementsList.get(i);
            System.out.print(compList.get(i));
            if(numElementsList.get(i) > 1)
                System.out.print(numElementsList.get(i));
        }

        compList.clear();
        numElementsList.clear();

        System.out.println(" Molar mass of the compound (g) " + mass);
        return mass;
    }




    public int getNumbers()
    {
        Scanner getNum = new Scanner(System.in);
        int num = 0;

        while (true)
        {
            try {
                System.out.print("Please enter the moles of your element  ");
                num = getNum.nextInt();

                if (num > 0)
                    return num;
                else {
                    System.out.println("Please enter a number >= 1");
                    numElementsList.add(getNumbers());
                    break;
                }
            } catch(Exception e) {
                System.out.println("Please do not enter a number <= 1 at this step");
                numElementsList.add(getNumbers());
                break;
            }

         // end of while loop
        }
        return num;
    }

}





