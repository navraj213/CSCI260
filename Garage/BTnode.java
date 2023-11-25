package Garage;
import java.util.*;
public class BTnode
{
    BTnode left, right;
    public Object[] data;

    /* Constructor */
    public BTnode(String brand, ArrayList<LinkedList<partCopy>> details)
    {
        left = null;
        right = null;
        data = new Object[]{brand, details};
    }
    /* Function to set left node */
    public void setLeft(BTnode n)
    {
        left = n;
    }
    /* Function to set right node */
    public void setRight(BTnode n)
    {
        right = n;
    }
    /* Function to get left node */
    public BTnode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public BTnode getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setData(String brand, ArrayList<LinkedList<partCopy>> details)
    {
        data = new Object[]{brand, details};
    }
    /* Function to get data from node */
    public String getDataBrand()
    {
        if (data[0] == null) {
            return "";
        }
        return (String) data[0];
    }
    public ArrayList<LinkedList<partCopy>> getDataDetails()
    {
        return (ArrayList<LinkedList<partCopy>>) data[1];
    }
}