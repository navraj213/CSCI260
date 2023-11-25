package Garage;

import java.util.LinkedList;

public class part implements Cloneable {
    public String brand;
    public String description;
    public int modelNumber;
    public int quantity;
    public String location;

    public boolean isBorrowed;
    public LinkedList<String[]> history;
    public int numBorrowed; 
    public String uniqueID; 

    public part(String brand, String description, int modelNumber, int quantity, String location) {
        this.brand = brand.toUpperCase();
        this.description = description;
        this.modelNumber = modelNumber;
        this.quantity = quantity;
        this.location = location.toUpperCase();

        this.uniqueID = brand + modelNumber;
        this.isBorrowed = false;
        this.history = new LinkedList<String[]>();
        this.history.add(new String[] { "Created", "System" });
        this.numBorrowed = 0;
    }

    public void addHistory(String[] history) {
        this.history.add(history);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        part p = (part) obj;
        return this.uniqueID.equals(p.uniqueID);
    }

    @Override
    public int hashCode() {
        int result = this.uniqueID.hashCode();
        result = 31 * result + this.modelNumber;
        return result;
    }

    @Override
    public part clone() throws CloneNotSupportedException {
        return (part)super.clone();
    }

    @Override
    public String toString() {
        return "\033[31m" + this.brand + "\033[0m" + "-" + "\033[33m" + this.modelNumber + "\033[0m" + " " + this.description.toUpperCase()
                + " |\033[36m " + this.quantity + "\033[35m " + this.location + "\033[0m";
    }

    public void printHistory() {
        for (String[] history : this.history) {
            String status = history[0].toLowerCase();
            switch (status) {
                case "borrowed":
                    System.out.println("\033[33m" + history[0].toUpperCase() + "\033[0m" + " by " + history[1]);
                    break;
                case "keeping":
                    System.out.println("\033[31m" + history[0].toUpperCase() + "\033[0m" + " by " + history[1]);
                    break;
                case "returned":
                    System.out.println("\033[32m" + history[0].toUpperCase() + "\033[0m" + " by " + history[1]);
                    break;
                default:
                    break;
            }
        }
    }
    
}