package BST;

/**
 * A class to represent a node in a Binary Search Tree (BST) that contains
 * data of a Point object and pointers to two BSTs: left sub-tree and right
 * sub-tree (LST & RST, respectively).
 */
public class Node {
    
    Point data;             //the Point that is contained in the Node
    Node LST;               //pointer to Node that contains the LST
    Node RST;               //pointer to Node that contains the RST
    
    /**
     * A constructor for a Node object
     * @param data the Point to be stored in the Node object
     */
    public Node(Point data){
    this.data = data;
    LST = null;
    RST = null;      
    }
    
    
}
