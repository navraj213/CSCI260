        // Object[] myList = new Object[2];
        // myList[0] = (String)"Hello";
        // myList[1] = new ArrayList<Integer>();

        // ((ArrayList<Integer>) myList[1]).add(1);
        // ((ArrayList<Integer>) myList[1]).add(2);
        // System.out.println(((ArrayList<Integer>) myList[1]).get(0));

        // System.out.println(myList[0]);
        // System.out.println(myList[1]);
package Garage;

import java.util.*;

/* Class BT */
public class BT
{
    private BTnode root;
    /* Constructor */
    public BT()
    {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Functions to insert data */
    public void insert(String brand, ArrayList<LinkedList<partCopy>> details)
    {
        root = insert(root, brand, details);
    }
    /* Function to insert data recursively */
    private BTnode insert(BTnode node, String brand, ArrayList<LinkedList<partCopy>> details)
    {
        if (node == null)
            node = new BTnode(brand, details);
        else
        {
            int compareResult = brand.compareTo(node.getDataBrand());
            if (compareResult >= 0)
                node.right = insert(node.right, brand, details);
            else
                node.left = insert(node.left, brand, details);
        }
        return node;
    }
    /* Function to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(BTnode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
    /* Function to search for an element */
    public boolean doesExist(String targetVal)
    {
        if (countNodes() <= 0) {
            return false;
        }
        return search(targetVal) != null;
    }

    /* Function to search for an element */
    public BTnode search(String targetVal)
    {
        return search(root, targetVal);
    }
    /* Function to search for an element recursively */
    private BTnode search(BTnode r, String targetVal)
    {
        if (r == null) {
            return null;
        }
        if (r.getDataBrand().equals(targetVal) && r.getDataDetails() != null) {
            return r;
        }
        BTnode leftResult = search(r.getLeft(), targetVal);
        if (leftResult != null) {
            return leftResult;
        }
        return search(r.getRight(), targetVal);
    }

    //make a function called printTree that prints it in the fashion that its organized in in the terminal all formated with spacing and arrows an dstuff
    public void printTree() {
        printTree(root, 0);
    }
    private void printTree(BTnode root2, int i) {
        if (root2 == null) {
            return;
        }
        printTree(root2.getRight(), i + 1);
        for (int j = 0; j < i; j++) {
            System.out.print("    ");
        }
        System.out.println(root2.getDataBrand());
        printTree(root2.getLeft(), i + 1);
    }
}
