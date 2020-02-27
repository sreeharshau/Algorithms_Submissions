package algorithms;

public class UnionFind_QuickUnion {

    private final Integer[] connectArray;
    private final Integer maxSize;

    // Constructor to initialize class
    public UnionFind_QuickUnion(final int maxSize) {
        System.out.println("Creating UnionFind of size: " + maxSize);
        this.connectArray = new Integer[maxSize];
        this.maxSize = maxSize;

        for (int i = 0; i < this.maxSize; i++) {
            connectArray[i] = i;
        }

    }

    // Finds the root of a particular element by following connectArray entries
    private Integer findRoot(final Integer element){
        int i = element;
        while(i != connectArray[i])
            i = connectArray[i];
        
        return i;
    }

    // Connects 2 objects via a union by changing the root of element 2 to that of element 1
    public Boolean union(final Integer element1, final Integer element2) {
              
        // Get the roots of both elements
        final Integer root1 = findRoot(element1);
        final Integer root2 = findRoot(element2);

        // Set the root of element 2 to be the root of element 1
        connectArray[root2] = root1;   
        
        return true;
    }

    // Answers queries as to if 2 objects are connected. Returns true if both are connected i.e. have the same root else returns False
    public Boolean isConnected(final Integer element1, final Integer element2) {

        Boolean returnVal;

        returnVal = (findRoot(element1) == findRoot(element2));
        
        return returnVal;
    }
}