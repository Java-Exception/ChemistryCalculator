import java.util.Scanner;
import java.util.StringTokenizer;


public class AtomFinder
{
    private Finder f = new Finder();
    private gmaConversion gma = new gmaConversion();
    private GetCompounds gc = new GetCompounds();
    private boolean running = true;
    private CalcWindowSetup cws = new CalcWindowSetup();


    AtomFinder() {}
//
//    void findThings()
//    {
//        while (running)
//        {
//            // The scanner below make sure that any input is in the proper format for the if statements
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Would you like to enter research mode or conversion mode? ");
//            String m = sc.nextLine();
//            String w = m.toLowerCase().replaceAll(" ", "");
//
//            switch (w) {
//                case "researchmode":
//                case "research":
//                case "rm":
//                    researchMode();
//                    break;
//                case "conversionmode":
//                case "conversion":
//                case "c":
//                    conversionMode();
//                    break;
//                case "stop":
//                    System.out.println(("\n Stopping . . ."));
//                    running = false;
//                    break;
//                // If the received input is not acceptable they must start over
//                default:
//                    findThings();
//                    break;
//            }
//
//        }
//    }
//
//
//    public void researchMode()
//    {
//        while (running)
//        {
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Would you like the search by atomic number or letter? ");
//            String m = sc.nextLine();
//            String w = m.toLowerCase().replaceAll(" ", "");
//
//            switch (w)
//            {
//                case "letter":
//                case "l":
//                    System.out.print("What element would you like to see? ");
//                    String s = sc.nextLine();
//                    System.out.println(f.getElementName(s));
//                    break;
//                case "number":
//                case "n":
//                    System.out.print("Which element would you like to see? ");
//                    int e = sc.nextInt();
//                    System.out.println(f.getElementNumber(e));
//                    break;
//                case "stop":
//                    System.out.println("\n Stopping . . .");
//                    running = false;
//                    break;
//                case "back":
//                    System.out.println("Going back. . .");
//                    findThings();
//                    break;
//                default:
//                    System.out.println("\nPlease try again");
//                    break;
//            }
//
//        }
//    }
//
//    public void conversionMode()
//    {
//        while (running)
//        {
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Are you doing stoichiometry or GMA conversions ");
//            String m = sc.nextLine();
//            String w = m.toLowerCase().replaceAll(" ", "");
//            switch (w)
//            {
//                case("gma"):
//                    //gramsMolesAtoms();
//                    break;
//                case ("stoich"):
//                case ("stoichiometry"):
//                case "s":
//                    compGMA();
//                    break;
//                case "stop":
//                    System.out.println();
//                    findThings();
//                    break;
//                case "back":
//                    System.out.println("Going back. . .");
//                    findThings();
//                    break;
//                default:
//                    System.out.println("\nPlease enter: \"gma\" or \"stoichiometry\" ");
//                    conversionMode();
//            }
//        }
//
//    }
//                  findThings and researchMode, and conversionMode are for the command line version of this so they can be commented out



                                              /* CONVERSION SECTION */

    // Method to check if an element is diatomic
    private double isDiatomic(String element) {
        String[] diatomics = {"H", "N", "F", "O", "I", "Cl", "B"};
        for(String s : diatomics) {
            if (element.equals(s))
                        // getAtomicMass returns the atomic mass
                        // getAtomicNumber uses the name of the element to return the place in the array
                        // where you will find the atomic mass
                return f.getAtomicMass(f.getAtomicNumber(element)) * 2;
        }

        return f.getAtomicMass(f.getAtomicNumber(element));
    }

                                 /* GMA MODE */


     // all of the functions used such as: gramsToMoles, gramsToAtoms, etc. are from the gmaConversion class
     public double gramsMolesAtoms(String w, String atom, double unit)
     {
         while(running)
         {
//             double grams;
//             double moles;
//             double atoms;
////
//             Scanner sc = new Scanner(System.in);
//             Scanner newScanner = new Scanner(System.in);
//
//             System.out.print("Please enter to and from variables; ex: grams moles ");
//             String m = sc.nextLine();
             w = w.toLowerCase().replaceAll(" ", "");
             double molarMass;
             switch(w)
             {
                 // Grams to moles conversion
                 case "gramsmoles":
                 case "gm":
                 case "gramstomoles":
//                     System.out.print("Please enter atomic letter of the element you're converting ");
//                     atom = sc.nextLine();
//                     System.out.print("Please enter the amount of that substance (in grams) that you have. ");
//                     grams = newScanner.nextDouble();
                     molarMass = isDiatomic(atom);
                     return gma.gramsToMoles(unit, molarMass);
                     //gramsMolesAtoms(w, atom, unit);
                 case "gramsatoms":
                 case "ga":
                 case "gramstoatoms":
//                     System.out.print("Please enter atomic letter of the element you're converting ");
//                     atom = sc.nextLine();
//                     System.out.print("Please enter the amount of that substance (in grams) that you have. ");
//                     grams = newScanner.nextDouble();
                     molarMass = isDiatomic(atom);
                     return gma.gramsToAtoms(unit, molarMass);
//                     gramsMolesAtoms(w, atom, unit);
                 //  Moles to grams conversion
                 case "molesgrams":
                 case "mg":
                 case "molestograms":
//                     System.out.print("Please enter atomic letter of the element you're converting ");
//                     atom = sc.nextLine();
//                     System.out.print("Please enter the amount of that substance (in moles) that you have. ");
//                     moles = newScanner.nextDouble();
                     molarMass = isDiatomic(atom);
                     return gma.molesToGrams(unit, molarMass);
//                     gramsMolesAtoms(w, atom, unit);
                 case "molesatoms":
                 case "ma":
                 case "molestoatoms":
//                     System.out.print("Please enter atomic letter of the element you're converting ");
//                     atom = sc.nextLine();
//                     System.out.print("Please enter the amount of that substance (in moles) that you have. ");
//                     moles = newScanner.nextDouble();
                     return gma.molesToAtoms(unit);
//                     gramsMolesAtoms(w, atom, unit);
                 case "atomsgrams":
                 case "ag":
                 case "atomstograms":
//                     System.out.print("Please enter atomic letter of the element you're converting ");
//                     atom = sc.nextLine();
//                     System.out.print("Please enter the amount of that substance (in atoms) that you have. ");
//                     atoms = newScanner.nextDouble();
                     molarMass = isDiatomic(atom);
                     return gma.atomsToGrams(unit, molarMass);
//                     gramsMolesAtoms(w, atom, unit);

                 case "atomsmoles":
                 case "am":
                 case "atomstomoles":
//                     System.out.print("Please enter atomic letter of the element you're converting ");
//                     atom = sc.nextLine();
//                     System.out.print("Please enter the amount of that substance (in atoms) that you have. ");
//                     atoms = newScanner.nextDouble();
                     return gma.atomsToMoles(unit);
//                     gramsMolesAtoms(w, atom, unit);

//                 case "stop":
//                     System.out.println("Returning to menu. . .");
//                     findThings();
//                     break;
//                 case "back":
//                     System.out.println("Going back. . .");
//                     findThings();
//                     break;

                 default:
//                     System.out.println("An error has occurred, please check spelling or maybe try \"research mode\" ");
//                     gramsMolesAtoms(w, atom, unit);
                     return -2;
             }
         }
         return -1;
     }

        // will be implemented later

    public void compGMA()
    {
        Scanner sc = new Scanner(System.in);
        Scanner getAmounts = new Scanner(System.in);

        double grams;
        double moles;
        double molarMass;
        double atoms;

        molarMass = gc.getCompound();
        System.out.print("What type of conversion are you going to be doing? Ex. grams moles ");
        String w = sc.nextLine().replaceAll(" ", "");

        switch (w)
        {
            case "gramsmoles":
            case "gm":
            case "gramstomoles":
                System.out.print("Please enter the amount of that substance (in grams) that you have. ");
                grams = getAmounts.nextDouble();
                System.out.println(gma.gramsToMoles(grams, molarMass));
                break;
            case "gramsatoms":
            case "ga":
            case "gramstoatoms":
                System.out.print("Please enter the amount of that substance (in grams) that you have. ");
                grams = getAmounts.nextDouble();
                System.out.println(gma.gramsToAtoms(grams, molarMass));
                break;
            case "molesgrams":
            case "mg":
            case "molestograms":
                System.out.print("Please enter the amount of that substance (in moles) that you have. ");
                moles = getAmounts.nextDouble();
                System.out.println(gma.molesToGrams(moles, molarMass));
                break;
            case "molesatoms":
            case "ma":
            case "molestoatoms":
                System.out.print("Please enter the amount of that substance (in moles) that you have. ");
                moles = getAmounts.nextDouble();
                System.out.println(gma.molesToAtoms(moles));
                break;
            case "atomsgrams":
            case "ag":
            case "atomstograms":
                System.out.print("Please enter the amount of that substance (in atoms) that you have. ");
                atoms = getAmounts.nextDouble();
                System.out.println(gma.atomsToGrams(atoms, molarMass));
                break;
            case "atomsmoles":
            case "am":
            case "atomstomoles":
                System.out.print("Please enter the amount of that substance (in atoms) that you have. ");
                atoms = getAmounts.nextDouble();
                System.out.println(gma.atomsToMoles(atoms));
                break;
        }

    }

}