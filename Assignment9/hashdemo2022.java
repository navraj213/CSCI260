package Assignment9;

import java.util.Enumeration;
import java.util.Hashtable;
public class hashdemo2022 {
    public static void main(String args[]) {
        Hashtable<String, String> companies = new Hashtable<String,String>();
        companies.put("Google", "United States");
        companies.put("Nokia", "Finland");
        companies.put("Sony", "Japan");
        companies.get("Google");

        System.out.println("Does hashtable contains Google as key: " + companies.containsKey("Google"));
        System.out.println("Does hashtable contains Japan as value: " + companies.containsValue("Japan"));
        
        Enumeration<String> enumeration = companies.elements();
        
        while (enumeration.hasMoreElements()) {
            System.out.println("hashtable values: " + enumeration.nextElement());
        }
        
        System.out.println("Is companies hashtable empty: " + companies.isEmpty());
        System.out.println("Size of hashtable in Java: " + companies.size());
        
        companies.clear();
    }
}

