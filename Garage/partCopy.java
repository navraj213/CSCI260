package Garage;

public class partCopy {
    public String uniqueID;
    public String reserverName;
    public boolean isKeeping;

    public partCopy(String uniqueID, String reserverName, boolean isKeeping) {
        this.uniqueID = uniqueID;
        this.reserverName = reserverName;
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

    //this.uniqueID.hashCode();

}
