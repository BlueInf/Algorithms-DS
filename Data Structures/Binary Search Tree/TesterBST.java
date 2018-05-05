
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

/**
 * TesterBST Class
 * Tests the add, remove, contain method and the iterator of a BST
 */
public class TesterBST {

    BinarySearchTree<String> binarySearchTree;

    /**
     * Setting the BinarySearchTree
     */
    @Before
    public void setUp(){
        binarySearchTree=new BinarySearchTree<>();
    }

    /**
     * Testing the add method()
     * Adding String to an Empty Tree
     */
    @Test
    public void addOnEmptyTree(){
        binarySearchTree.add("Element");
        assertEquals("String : \"Element\" is not found",true,binarySearchTree.contains("Element"));
    }

    /**
     * Testing the add method()
     * Adding same element to the Tree
     * It should not add duplicate elements
     */
    @Test
    public void addSameElement(){
        BinarySearchTree<String> secondBST=new BinarySearchTree<>();
        secondBST.add("A");
        assertEquals("BST cannot add duplicate elements",false,secondBST.add("A"));
        secondBST=null;
    }

    /**
     * Testing the add method()
     * Adding many elements to Tree
     * Checking if the BST has them
     */
    @Test
    public void addManyElements(){

        String[] listStrings={"John","Declan","Woodhouse","Whittaker","King","Savage"};
        for(String testString:listStrings){
            assertEquals("Successfully added String \""+testString+"\"",true,binarySearchTree.add(testString));
            System.out.println("Successfuly added  String \""+testString+"\"");
        }
    }

    /**
     * Testing the remove method()
     * Removing elements that are already in the tree
     */
    @Test
    public void removeActiveElement(){
        binarySearchTree.add(new String("Whittaker"));
        assertEquals("Binary search tree has not removed the element properly",true,binarySearchTree.remove("Whittaker"));
        assertEquals("Binary search tree has not removed the element properly",false,binarySearchTree.contains("Whittaker"));
    }

    /**
     * Testing the removing method()
     * Removing element that is not in the tree
     * @throws Exception
     */
    @Test
    public void removeInactiveElement() throws Exception{
        assertEquals("Binary search tree removes inactive nodes",false,binarySearchTree.remove("adsa"));
        assertEquals("Binary search tree contains inactive nodes",false,binarySearchTree.contains("adsa"));
    }

    /**
     * Testing the contain method()
     * Adding string to the BST and checking if the contain method contains the added string
     */
    @Test
    public void containOneElement(){
        binarySearchTree.add("John");
        assertEquals("Binary search tree does not contain the string: \"John\"",true,binarySearchTree.contains("John"));
    }

    /**
     * Testing the contain method()
     * Adding array of strings to the BST and checking if it contains them all
     */
    @Test
    public void cointainMoreElements(){

        String[] listStrings={"John","Declan","Woodhouse","Whittaker","King","Savage"};
        for(String testString:listStrings){
            assertEquals("Unsuccessfully added String \""+testString+"\"",true,binarySearchTree.add(testString));
            assertEquals("BST does not contain added strings",true,binarySearchTree.contains(testString));
            System.out.println("BST contains String \""+testString+"\"");
        }
    }

    /**
     * Testing the iterator
     * Testing if it returns the one and only element
     */
    @Test
    public void testIteratorForOneElement(){
        binarySearchTree.add("A");
        Iterator it=binarySearchTree.iterator();
        assertEquals("The iterator does not show that we have an element",true,it.hasNext());
        assertEquals("The iterator does not show the expected element","A",it.next());
    }

    /**
     * Testing the iterator
     * Testing if it returns the many elements
     */
    @Test
    public void testIteratorForManyElements(){

        // Added strings
        String[] listStrings={"A","B","C","D"};
        for(String testString:listStrings){
            binarySearchTree.add(testString);
        }

        // Iterator
        Iterator it=binarySearchTree.iterator();

        for(String testString:listStrings){
            assertEquals("The iterator does not show that we have an element",true,it.hasNext());
            assertEquals("The iterator does not show the expected element",testString,it.next());
        }

        // New BST
        binarySearchTree=new BinarySearchTree<>();

        // Different strings
        String[] newListStrings={"C","A","D","F"};
        for(String testString:newListStrings){
            binarySearchTree.add(testString);
        }

        it=binarySearchTree.iterator();

        // The expected array of strings that the iterator should iterate through
        newListStrings=new String[]{"A","C","D","F"};

        // Asserting that that is the correct order
        for(String testString:newListStrings){
            assertEquals("The iterator does not show that we have an element",true,it.hasNext());
            assertEquals("The iterator does not show the expected element",testString,it.next());
        }

    }

    /**
     * Testing the iterator
     * Removing nothing from the iterator
     */
    @Test(expected = IllegalStateException.class)
    public void testIteratorRemoveNothing(){
        binarySearchTree.add("A");
        Iterator it=binarySearchTree.iterator();
        it.remove();
    }

    /**
     * Testing the iterator
     * Removing one element
     */
    @Test
    public void testIteratorRemoveOneElement(){
        binarySearchTree.add("A");
        Iterator it=binarySearchTree.iterator();
        it.next();
        it.remove();
        assertEquals("The iterator has not removed anything",false,binarySearchTree.contains("A"));
    }


    /**
     * Testing the iterator
     * Removing more elements
     */
    @Test
    public void testIteratorRemoveMoreElements(){

        // Adding the strings
        String[] listStrings={"John","Josh","Cara","Anite"};
        for(String testString:listStrings){
            binarySearchTree.add(testString);
        }

        // Getting the iterator
        Iterator it=binarySearchTree.iterator();

        // Removing the elements
        while(it.hasNext()){
            it.next();
            it.remove();
        }

        for(String testString:listStrings){
           assertEquals("Iterator has not removed any objects",false,binarySearchTree.contains(testString));
        }

    }
}
