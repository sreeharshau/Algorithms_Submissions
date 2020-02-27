package algorithms;

public class UnionFind_WeightedUnion {

    private final Integer[] connectArray;
    private final Integer[] treeSizes;
    private final Integer maxSize;

    // Constructor to initialize class
    public UnionFind_WeightedUnion(final int maxSize) {
        System.out.println("Creating UnionFind of size: " + maxSize);
        this.connectArray = new Integer[maxSize];
        this.treeSizes = new Integer[maxSize];
        this.maxSize = maxSize;

        for (int i = 0; i < this.maxSize; i++) {
            connectArray[i] = i;
            treeSizes[i] = 1;
        }

    }

    // Finds the root of a particular element by following connectArray entries
    // Also uses path compression to reduce future find times
    private Integer findRoot(final Integer element) {
        int i = element;
        while (i != connectArray[i]){
            i = connectArray[i];
            connectArray[i] = connectArray[connectArray[i]];
        }
            
        return i;
    }

    // Connects 2 objects via a union by changing the root of element 2 to that of
    // element 1. Weighted modifs include checking sizes of both trees and trying
    // to fit the smaller tree under the larger tree
    public Boolean union(final Integer element1, final Integer element2) {

        // Get the roots of both elements
        final Integer root1 = findRoot(element1);
        final Integer root2 = findRoot(element2);
        final Integer tree1Size = treeSizes[element1];
        final Integer tree2Size = treeSizes[element2];

        // Set the root of element 2 to be the root of element 1
        
        if(tree1Size > tree2Size){
            connectArray[root2] = root1;
            treeSizes[element1] += tree2Size;
        }
        else{
            connectArray[root1] = root2;
            treeSizes[element2] += tree1Size;
        }

        return true;
    }

    // Answers queries as to if 2 objects are connected. Returns true if both are
    // connected i.e. have the same root else returns False
    public Boolean isConnected(final Integer element1, final Integer element2) {

        Boolean returnVal;

        returnVal = (findRoot(element1) == findRoot(element2));

        return returnVal;
    }
}