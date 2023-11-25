package Garage;

public class partCopy {
    public String uniqueID;
    public String reserverName;
    public boolean isKeeping;

    public partCopy(String uniqueID, String reserverName, boolean isKeeping) {
        this.uniqueID = uniqueID.toUpperCase();
        this.reserverName = reserverName.toUpperCase();
        this.isKeeping = isKeeping;
    }

    public String getBrand() {
        String brand = "";
        for (int i = 0; i < this.uniqueID.length(); i++) {
            if (Character.isDigit(this.uniqueID.charAt(i))) {
                break;
            }
            brand += this.uniqueID.charAt(i);
        }
        return brand;
    }

    public String toString() {
        return this.uniqueID + " " + this.reserverName + " " + this.isKeeping;
    }

    //this.uniqueID.hashCode();

}
