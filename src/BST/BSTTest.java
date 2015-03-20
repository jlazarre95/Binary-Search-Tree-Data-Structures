package BST;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * I certify that this whole program is completely a work of mine and of no
 * other person(s).
 *
 * @author Jahkell Lazarre
 *
 * COP 3530 - Data Structures (Section U01) 
 * Assignment #3 - Binary Search Tree 
 * Completed: March 2nd, 2015
 */
public class BSTTest {

    public static void main(String[] args) throws Exception {
        //new Binary Search Tree 
        BinarySearchTree bst = new BinarySearchTree();
        //user input for file
        String input = JOptionPane.showInputDialog("Type the directory path or "
                + "filename of your input file that contains your "
                + "Binary Search Tree data here.");

        Scanner scan = new Scanner(new File(input));
        final PrintWriter out = new PrintWriter(new File("output.txt"));

        //while there are more characters to be read...
        while (scan.hasNext()) {
            //get the next operation
            String operation = scan.next();
            //if input...
            if (operation.equalsIgnoreCase("I")) {
                //append node to BST
                int x = Integer.parseInt(scan.next());
                int y = Integer.parseInt(scan.next());
                Point p = new Point(x, y);
                if (bst.appendNode(new Node(p)) == true){ 
                    out.println("Point " + p + "has been appended to the Binary Search Tree.");
                    System.out.println("Point " + p + "has been appended to the Binary Search Tree.");
                }
                else {
                    out.println("Point " + p + "already exists in the Binary Search Tree! Cannot append.");
                    System.out.println("Point " + p + "already exists in the Binary Search Tree! Cannot append.");
                }
            } //if search...
            else if (operation.equalsIgnoreCase("S")) {
                //perform a rectangular search with the specified points
                int x1 = Integer.parseInt(scan.next());
                int y1 = Integer.parseInt(scan.next());
                Point p1 = new Point(x1, y1);

                int x2 = Integer.parseInt(scan.next());
                int y2 = Integer.parseInt(scan.next());
                Point p2 = new Point(x2, y2);
                
                out.println("========================================================================================================================================\r\n"
                        + "RECTANGULAR SEARCH w/ Boundaries: " + p1 + p2 + "\r\nResults:"
                        + "\r\n========================================================================================================================================");
                out.println(bst.rectangularSearch(p1, p2) + "\r\n");
                System.out.println("========================================================================================================================================\n"
                        + "RECTANGULAR SEARCH w/ Boundaries: " + p1 + p2 + "\r\nResults:"
                        + "\n========================================================================================================================================");
                System.out.println(bst.rectangularSearch(p1, p2) + "\n");
            } //otherwise, output...
            else {
                out.println("========================================================================================================================================\r\n"
                        + "Binary Search Tree Printed in In-Order:"
                        + "\r\n========================================================================================================================================");
                out.println(bst.toStringInOrder() + "\r\n");
                System.out.println("========================================================================================================================================\n"
                        + "Binary Search Tree Printed in In-Order:"
                        + "\n========================================================================================================================================");
                System.out.println(bst.toStringInOrder() + "\n");
            }

        }
        out.flush();
        out.close();
        System.out.println("Your output has successively been generated "
                + "in an output file: output.txt");
    }

}
