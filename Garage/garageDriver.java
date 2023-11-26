package Garage;

import java.util.*;

public class garageDriver {
    public static HashSet<part> inventory = new HashSet<part>();
    public static BT binaryTree = new BT();
    public static Queue<part> orders = new LinkedList<>();
    public static Hashtable<String, ArrayList<part>> locationTable = new Hashtable<String, ArrayList<part>>();

    public static void getOption() {
        clearScreen();
        System.out.println("\033[32m" + "Welcome to the Garage Inventory System\n" + "\033[0m");
        System.out.println("Please select an option:");
        System.out.println("\033[31m" + " 1. " + "\033[0m" + "Add a part");
        System.out.println("\033[31m" + " 2. " + "\033[0m" + "Remove a part");
        System.out.println("\033[31m" + " 3. " + "\033[0m" + "Update a part");
        System.out.println("\033[31m" + " 4. " + "\033[0m" + "Borrow a part");
        System.out.println("\033[31m" + " 5. " + "\033[0m" + "Return a part");
        System.out.println("\033[31m" + " 6. " + "\033[0m" + "List all parts");
        System.out.println("\033[31m" + " 7. " + "\033[0m" + "List all borrowed parts");
        System.out.println("\033[31m" + " 8. " + "\033[0m" + "List all history of a part");
        System.out.println("\033[31m" + " 9. " + "\033[0m" + "List all parts of a brand");
        System.out.println("\033[31m" + "10. " + "\033[0m" + "List Quantity of a part");
        System.out.println("\033[31m" + "11. " + "\033[0m" + "List parts that need to be ordered");
        System.out.println("\033[31m" + "12. " + "\033[0m" + "List parts in a location");
        System.out.println("\033[31m" + "13. " + "\033[0m" + "Exit");

        Scanner input = new Scanner(System.in);
        int option = -1;
        while(true) {
            try {
                option = input.nextInt();
                if(option < 1 || option > 13) {
                    throw new InputMismatchException();
                }
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("\033[31m" + "ENTER A VALID NUMBER!!!" + "\033[0m");
                input.nextLine();
                continue;
            }
        }

        clearScreen();
        switch (option) {
            case 1:
                addPart();
                break;
            case 2:
                removePart();
                break;
            case 3:
                updatePart();
                break;
            case 4:
                borrowPart();
                break;
            case 5:
                returnPart();
                break;
            case 6:
                System.out.println("\033[31m" + "BRAND" + "\033[0m" + "-" + "\033[33m" + "MODEL#" + "\033[0m" + " " + "DESCRIPTION"
                    + " |\033[36m " + "QUANTITY" + "\033[35m " + "LOCATION" + "\033[0m");
                System.out.println("\033[32m" + "All Parts:" + "\033[0m\n");
                for (part p : inventory) {
                    System.out.println(p);
                }
                break;
            case 7:
                listAllBorrowed();
                break;
            case 8:
                System.out.println("Enter the " + "\033[31m" + "brand" + "\033[0m" + " of the part: ");
                input.nextLine();
                String brand = input.nextLine().strip();

                System.out.println("Enter the " + "\033[31m" + "model number" + "\033[0m" + " of the part: ");
                int modelNumber = input.nextInt();

                part currPart = new part(brand, "", modelNumber, 0, "");

                if (!inventory.contains(currPart)) {
                    System.out.println("\033[31m" + "Part does not exist"+ "\033[0m");
                    break;
                }
                else {
                    for (part p : inventory) {
                        if (p.equals(currPart)) {
                            System.out.println("Part: " + p + "\033[32m" + "\n\nHistory of Part: " + "\033[0m");
                            p.printHistory();
                            break;
                        }
                    }
                }
                System.out.println();
                break;
            case 9:
                listAllPartsOfBrand();
                break;
            case 10:
                System.out.println("Enter the " + "\033[31m" + "brand" + "\033[0m" + " of the part: ");
                input.nextLine();
                String brand2 = input.nextLine().strip();

                System.out.println("Enter the " + "\033[31m" + "model number" + "\033[0m" + " of the part: ");
                int modelNumber2 = input.nextInt();

                part currPart2 = new part(brand2, "", modelNumber2, 0, "");

                if (!inventory.contains(currPart2)) {
                    System.out.println("\033[31m" + "Part does not exist"+ "\033[0m");
                    break;
                }
                else {
                    for (part p : inventory) {
                        if (p.equals(currPart2)) {
                            System.out.println("Part: " + p + "\033[32m" + "\n\nQuantity of Part: " + "\033[0m");
                            System.out.println(p.quantity);
                            break;
                        }
                    }
                }
                System.out.println();
                break;
            case 11:
                printQueue();
                break;
            case 12:
                System.out.println("Enter the " + "\033[31m" + "location" + "\033[0m" + " of the part: ");
                input.nextLine();
                String location = input.nextLine().strip().toUpperCase();

                if(!locationTable.containsKey(location)) {
                    System.out.println("\033[31m" + "Location does not exist" + "\033[0m");
                    break;
                }
                else {
                    System.out.println("Parts in location: " + location);
                    for(part p : locationTable.get(location)) {
                        System.out.println(p);
                    }
                }
                break;
            default:
                break;
        }
        input.nextLine();
        System.out.println("Press enter to continue");
        input.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void addPart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the " + "\033[31m" + "brand" + "\033[0m" + " of the part: ");
        String brand = input.nextLine().strip();

        System.out.println("Enter the " + "\033[31m" + "description" + "\033[0m" + " of the part: ");
        String description = input.nextLine();

        System.out.println("Enter the " + "\033[31m" + "model number" + "\033[0m" + " of the part: ");
        int modelNumber = input.nextInt();

        if (inventory.contains(new part(brand, description, modelNumber, 0, ""))) {
            System.out.println("\033[34m" + "Part already exists!" + "\033[0m" + "\nWould you like to add to the quantity? (y/n)");
            String option = input.next();
            if (option.toLowerCase().equals("y")) {
                System.out.println("Enter the " + "\033[31m" + "quantity" + "\033[0m" + " of the part: ");
                int quantity = input.nextInt();
                for (part p : inventory) {
                    if (p.equals(new part(brand, description, modelNumber, 0, ""))) {
                        p.quantity += quantity;
                        System.out.println("\033[32m" + "Part Quantity Updated" + "\033[0m");
                        return;
                    }
                }
                
            }
            return;
        }

        System.out.println("Enter the " + "\033[31m" + "quantity" + "\033[0m" + " of the part: ");
        int quantity = input.nextInt();

        System.out.println("Enter the " + "\033[31m" + "location" + "\033[0m" + " of the part: ");
        input.nextLine();
        String location = input.nextLine().toUpperCase().strip();

        part newPart = new part(brand, description, modelNumber, quantity, location);
        inventory.add(newPart);

        if(!orders.contains(newPart) && newPart.quantity <= 0) {
            orders.add(newPart);
        }

        BTnode myBTNODE;
        if(!binaryTree.doesExist(newPart.brand)) {
            binaryTree.insert(newPart.brand, new ArrayList<LinkedList<partCopy>>());
        }
        myBTNODE = binaryTree.search(newPart.brand);
        ArrayList<LinkedList<partCopy>> details = (ArrayList<LinkedList<partCopy>>) myBTNODE.data[1];
        details.add(new LinkedList<partCopy>());
        LinkedList<partCopy> addCopy = new LinkedList<partCopy>();
        addCopy.add(new partCopy(newPart.uniqueID, "", false));
        details.set(details.size() - 1, addCopy);

        if(locationTable.containsKey(newPart.location)) {
            locationTable.get(newPart.location).add(newPart);
        }
        else {
            ArrayList<part> newLocation = new ArrayList<part>();
            newLocation.add(newPart);
            locationTable.put(location, newLocation);
        }

        System.out.println("\033[32m" + "Part Added" + "\033[0m");
    }

    public static void removePart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the " + "\033[31m" + "brand" + "\033[0m" + " of the part: ");
        String brand = input.nextLine().strip();

        System.out.println("Enter the " + "\033[31m" + "model number" + "\033[0m" + " of the part: ");
        int modelNumber = input.nextInt();

        part currPart = new part(brand, "", modelNumber, 0, "");

        if (!inventory.contains(currPart)) {
            System.out.println("\033[31m" + "Part does not exist"+ "\033[0m");
        }
        else {
            for(part p : inventory) {
                if(p.equals(currPart)) {
                    BTnode myBTNODE = binaryTree.search(brand.toUpperCase());
                    ArrayList<LinkedList<partCopy>> details = (ArrayList<LinkedList<partCopy>>) myBTNODE.data[1];
                    for(LinkedList<partCopy> partCopies : details) {
                        if(partCopies.getFirst().uniqueID.equals(currPart.uniqueID)) {
                            details.remove(partCopies);
                            break;
                        }
                    }

                    if(locationTable.containsKey(p.location)) {
                        locationTable.get(p.location).remove(p);
                    }
                    break;
                }
            }
            inventory.remove(currPart);
            System.out.println("\033[32m" + "Part removed" + "\033[0m");
            if(orders.contains(currPart)) {
                orders.remove(currPart);
            }
            
        }
    }

    public static void updatePart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the " + "\033[31m" + "brand" + "\033[0m" + " of the part: ");
        String brand = input.nextLine().strip();

        System.out.println("Enter the " + "\033[31m" + "model number" + "\033[0m" + " of the part: ");
        int modelNumber = input.nextInt();

        part currPart = new part(brand, "", modelNumber, 0, "");

        if (!inventory.contains(currPart)) {
            System.out.println("\033[31m" + "Part does not exist"+ "\033[0m");
            return;
        }
        else {
            System.out.println("Enter new details: ");
            System.out.println("Enter the " + "\033[31m" + "description" + "\033[0m" + " of the part: ");
            input.nextLine();
            String description = input.nextLine();
            System.out.println("Enter the " + "\033[31m" + "quantity" + "\033[0m" + " of the part: ");
            int quantity = input.nextInt();
            System.out.println("Enter the " + "\033[31m" + "location" + "\033[0m" + " of the part: ");
            input.nextLine();
            String location = input.nextLine().toUpperCase().strip();

            for (part p : inventory) {
                if (p.equals(currPart)) {
                    if(locationTable.containsKey(p.location)) {
                        locationTable.get(p.location).remove(p);
                    }
                    p.description = description;
                    p.quantity = quantity;
                    if(p.quantity <= 0 && !orders.contains(p)) {
                        orders.add(p);
                    }
                    else if(p.quantity > 0 && orders.contains(p)) {
                        orders.remove(p);
                    }
                    p.location = location;
                }
                if(locationTable.containsKey(p.location)) {
                    locationTable.get(p.location).add(p);
                }
                else {
                    ArrayList<part> newLocation = new ArrayList<part>();
                    newLocation.add(p);
                    locationTable.put(p.location, newLocation);
                }
                System.out.println("\033[32m" + "Part Updated" + "\033[0m");
                return;
            }
        }
    }

    public static void borrowPart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the " + "\033[31m" + "brand" + "\033[0m" + " of the part: ");
        String brand = input.nextLine().strip();

        System.out.println("Enter the " + "\033[31m" + "model number" + "\033[0m" + " of the part: ");
        int modelNumber = input.nextInt();

        part currPart = new part(brand, "", modelNumber, 0, "");

        if (!inventory.contains(currPart)) {
            System.out.println("\033[31m" + "Part does not exist"+ "\033[0m");
            return;
        }
        else {
            String uniqueID = brand.toUpperCase() + modelNumber;
            System.out.println("Enter the " + "\033[31m" + "name" + "\033[0m" + " of the borrower: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.println("Is the borrower keeping the item" + "\033[31m" + " (y/n):" + "\033[0m");
            String selection = input.next().toLowerCase();
            boolean isKeeping = selection.equals("y");

            for (part p : inventory) {
                if (p.equals(currPart)) {
                    if ((p.quantity - p.numBorrowed) <= 0) {
                        System.out.println("\033[31m" + "Part is out of stock" + "\033[0m");
                        return;
                    }
                    else {
                        if(isKeeping) {
                            p.quantity--;
                            p.addHistory(new String[] {"Kept", name});
                            System.out.println("\033[32m" + "Part Kept" + "\033[0m");
                        }
                        else {
                            p.numBorrowed++;
                            p.addHistory(new String[] { "Borrowed", name });
                            System.out.println("\033[32m" + "Part Borrowed" + "\033[0m");
                        }
                        if(p.quantity <= 0) {
                            if(!orders.contains(p)) {
                                orders.add(p);
                            }
                        }

                        BTnode myBTNODE = binaryTree.search(brand.toUpperCase());
                        ArrayList<LinkedList<partCopy>> details = (ArrayList<LinkedList<partCopy>>) myBTNODE.data[1];
                        for(LinkedList<partCopy> partCopies : details) {
                            if(partCopies.getFirst().uniqueID.equals(uniqueID)) {
                                partCopies.add(new partCopy(uniqueID, name, isKeeping));
                                break;
                            }
                        }

                        
                        return;
                    }
                }
            }
        }
    }

    public static void returnPart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the " + "\033[31m" + "brand" + "\033[0m" + " of the part: ");
        String brand = input.nextLine().strip();

        System.out.println("Enter the " + "\033[31m" + "model number" + "\033[0m" + " of the part: ");
        int modelNumber = input.nextInt();

        part currPart = new part(brand, "", modelNumber, 0, "");

        if (!inventory.contains(currPart)) {
            System.out.println("\033[31m" + "Part does not exist"+ "\033[0m");
            return;
        }
        else {
            String uniqueID = brand.toUpperCase() + modelNumber;
            System.out.println("Enter the " + "\033[31m" + "name" + "\033[0m" + " of the borrower: ");
            input.nextLine();
            String name = input.nextLine();

            for (part p : inventory) {
                if (p.equals(currPart)) {
                    if (p.numBorrowed <= 0) {
                        System.out.println("\033[31m" + "No instances of Part being borrowed" + "\033[0m");
                        return;
                    }
                    else {
                        boolean actualyReturned = false;
                        partCopy myPartCopy = new partCopy(uniqueID, name, false);

                        BTnode myBTNODE = binaryTree.search(brand.toUpperCase());
                        ArrayList<LinkedList<partCopy>> details = (ArrayList<LinkedList<partCopy>>) myBTNODE.data[1];
                        for(LinkedList<partCopy> partCopies : details) {
                            if(partCopies.getFirst().uniqueID.equals(uniqueID)) {
                                for(partCopy partCopy : partCopies) {
                                    if(partCopy.equals(myPartCopy)) {
                                        actualyReturned = true;
                                        partCopies.remove(partCopy);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if(!actualyReturned) {
                            System.out.println("\033[31m" + "Error part was not borrowed by " + name + "\033[0m");
                            return;
                        }
                        p.numBorrowed--;

                        p.addHistory(new String[] { "Returned", name });
                        System.out.println("\033[32m" + "Part Returned" + "\033[0m");
                        return;
                    }
                }
            }
        }
    }

    public static void listAllBorrowed() {
        boolean didPrint = false;
        for(part p : inventory) {
            if(p.numBorrowed > 0) {
                partCopy mPartCopy = new partCopy(p.uniqueID, "", false);
                BTnode myBTNODE = binaryTree.search(p.brand.toUpperCase());
                ArrayList<LinkedList<partCopy>> details = (ArrayList<LinkedList<partCopy>>) myBTNODE.data[1];
                for(LinkedList<partCopy> partCopies : details) {
                    if(partCopies.getFirst().equals(mPartCopy)){
                        System.out.println("Part: \033[31m" + mPartCopy.getBrand() + "\033[0m-\033[33m" + p.uniqueID.substring(mPartCopy.getBrand().length()) + "\033[0m is borrowed by:");
                        for(int i = 1; i < partCopies.size(); i++) {
                            System.out.println("\033[3m" + partCopies.get(i).reserverName + "\033[0m");
                        }
                    }
                }
                didPrint = true;
            }
        }
        if(!didPrint) {
            System.out.println("\033[31m" + "No parts are borrowed yet" + "\033[0m");
        }
        System.out.println();
    }

    public static void listAllPartsOfBrand() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the " + "\033[31m" + "brand" + "\033[0m" + " of the part: ");
        String brand = input.nextLine().strip().toUpperCase();

        BTnode myBTNODE = binaryTree.search(brand);
        if(myBTNODE == null) {
            System.out.println("\033[31m" + "Brand does not exist" + "\033[0m");
            return;
        }
        ArrayList<LinkedList<partCopy>> details = (ArrayList<LinkedList<partCopy>>) myBTNODE.data[1];
        System.out.println("Parts of brand: \033[31m" + brand + "\033[0m");
        for(LinkedList<partCopy> partCopies : details) {
            System.out.println("\033[31m" + brand + "\033[0m-\033[33m" + partCopies.getFirst().uniqueID.substring(brand.length()) + "\033[0m");
        }
        System.out.println();
    }

    public static void printQueue() {
        System.out.println("Parts that need to be ordered: ");
        for(part p : orders) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        //part p1 = (new part("bmw", "taillight", 123, 1, "A1"));
        //inventory.add(p1);
        while (true) {
            getOption();
        }
        // partCopy myPartCopy = new partCopy("bmw123", "nav", true);

        // BT bt = new BT();
        // bt.insert("bmw", new ArrayList<partCopy>());
        // bt.insert("bmw", new ArrayList<partCopy>());

        // BTnode myBTNODE = bt.search("bmw");
        // ((ArrayList<partCopy>) myBTNODE.data[1]).add(myPartCopy);

        


        // System.out.println( bt.search("bmw").getDataDetails() );


    }
}
