package BST;

/**
 * A class to represent a Binary Search Tree (BST) that contains Nodes that
 * point their left and right sub-trees (LSTs and RSTs, respectively).
 */
public class BinarySearchTree {

    Node root;                      //root of BST

    /**
     * A constructor for a BST that initializes its root to null
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * A constructor for a BST that initializes its root to a given Node
     * @param p Point that serves as the root of the BST
     */
    public BinarySearchTree(Point p) {
        this.root = new Node(p);
    }

    /**
     * Appends a node to a Binary Search Tree
     * @param n node to append to BST
     * @return whether the node has been successfully added or not
     */
    public boolean appendNode(Node n) {
        Boolean added;
        int level = 0;
        if(this.root == null){
        root = n;
        added = true;
        }
        else{
        added = recAppendNode(this.root, n, level);
        }
        return added;
    }

    /**
     * Outputs a String of all the Points in the BST by using In-Order Traversal
     * @return a String of all the Points in the BST in In-Order
     */
    public String toStringInOrder() {
        String string = recToStringIO(root);
        if(string.equals("")){
        return "There are no points in this Binary Search Tree!";
        }
        return string;
    }

    /**
     * Performs a search and outputs all the points within the boundaries
     * of the specified rectangle (defined by its endpoints of one of its
     * diagonals
     * @param p1 endpoint 1 of one of the rectangle's diagonals
     * @param p2 endpoint 2 of the same diagonal used by p1
     * @return String of points that lie within the boundaries of the
     * specified rectangle
     */
    public String rectangularSearch(Point p1, Point p2) {    
        int minX = p1.xIsGreaterThan(p2) ? p2.getX() : p1.getX();
        int maxX = p1.xIsGreaterThan(p2) ? p1.getX() : p2.getX(); 
        int minY = p1.yIsGreaterThan(p2) ? p2.getY() : p1.getY();
        int maxY = p1.yIsGreaterThan(p2) ? p1.getY() : p2.getY();
        String string = recRectSrch(root, minX, maxX, minY, maxY);
        if(string.equals("")){
        return "No points that exist in this Binary Search Tree fits within "
                + "your specified boundaries.";
        }
        return string;
    }
    
    //recursive helper method for appendNode
    private boolean recAppendNode(Node root, Node n, int level) {
        //if the level is even, then compare x-coordinates of root and node to 
        //be added    
        if (level % 2 == 0) {
            //if the Node to be added belongs to the LST...    
            if (n.data.xIsGreaterThan(root.data) == false) {
                //append the Node to the left sub-tree
                Node LST = root.LST;
                if (root.data.equals(n.data)) {
                        return false;
                    } 
                if (LST == null) {                  
                        root.LST = n;
                } else {
                    int nextLevel = level + 1;
                    recAppendNode(LST, n, nextLevel);
                }
            } //otherwise, the Node belongs to the RST...
            else {
                //append the Node to the right sub-tree
                Node RST = root.RST;
                if (root.data.equals(n.data)) {
                        return false;
                    } 
                if (RST == null) {
                        root.RST = n;     
                } else {
                    int nextLevel = level + 1;
                    recAppendNode(RST, n, nextLevel);
                }
            }
        } //otherwise, the level is odd, so compare the y-coordinates of root 
        //and node to be added
        else {
            //if the Node to be added belongs to the LST...
            if (n.data.yIsGreaterThan(root.data) == false) {
                //append the Node to the left sub-tree
                Node LST = root.LST;
                if (root.data.equals(n.data)) {
                        return false;
                    } 
                if (LST == null) {           
                        root.LST = n;
                } else {
                    int nextLevel = level + 1;
                    recAppendNode(LST, n, nextLevel);
                }
            } //otherwise, the the Node belonds to the RST...
            else {
                //append the Node the right sub-tree
                Node RST = root.RST;
                if (root.data.equals(n.data)) {
                        return false;
                    } 
                if (RST == null) {               
                        root.RST = n;
                } else {
                    int nextLevel = level + 1;
                    recAppendNode(RST, n, nextLevel);
                }
            }
        }
        return true;
    }
    
    //recursive helper method for toStringInOrder
     private String recToStringIO(Node root) {
        //if this BST is not empty...      
        if (!(root == null)) {
            String string = "";
            //output the String of the LST
            string = string + recToStringIO(root.LST);
            //output the String of the root of the tree
            string = string + root.data.toString();
            //and finally, output the String of the RST
            string = string + recToStringIO(root.RST);
            return string;
        }
        //otherwise, return nothing because the tree is empty
        return "";
    }
     
    //recursive helper method for rectangularSearch 
    private String recRectSrch(Node root, int minX, int maxX, int minY, int maxY) {
        //if this BST is not empty...      
        if (!(root == null)) {
            String string = "";
            //output the String of the LST
            string = string + recRectSrch(root.LST, minX, maxX, minY, maxY);
            //output the String of the root of the tree
            //if it is within boundaries of the rectangle
            if(!((root.data.getX() > maxX) || (root.data.getX() < minX) || 
            (root.data.getY() > maxY) || (root.data.getY() < minY))){
            string = string + root.data.toString();
            }
            //and finally, output the String of the RST
            string = string + recRectSrch(root.RST, minX, maxX, minY, maxY);
            return string;
        }
        //otherwise, return nothing because the tree is empty
        return "";
    }

}
