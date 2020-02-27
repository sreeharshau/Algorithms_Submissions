package algorithms;

public class UnionFind_QuickFind {

    private final Integer[] connectArray;
    private final Integer maxSize;

    // Constructor to initialize class
    public UnionFind_QuickFind(final int maxSize) {
        System.out.println("Creating UnionFind of size: " + maxSize);
        this.connectArray = new Integer[maxSize];
        this.maxSize = maxSize;

        for(int i = 0; i < this.maxSize; i++){
            connectArray[i] = i;
        }

        // DEBUG Only
        /*System.out.println("Connect Array Initial State:");
        for (int i = 0; i < this.maxSize; i++) {
            System.out.print(connectArray[i] + " ");
        }
        System.out.println("");*/
    }

    // Connects 2 objects via a union by making all IDs which are of element2 equal to that of element 1
    public Boolean union(final Integer element1, final Integer element2) {
        // System.out.println("Union called for " + element1 + " " + element2);
        int newValue = connectArray[element1];
        int oldValue = connectArray[element2];

        if(newValue == oldValue)
            return true;

        for(int i = 0; i < this.maxSize; i++){
            if(connectArray[i] == oldValue){
                // System.out.println("Modifying index: " + i + " from " + oldValue + " to " + newValue);
                connectArray[i] = newValue;
            }
        }
        return true;
    }

    // Answers queries as to if 2 objects are connected. Returns true if both are connected i.e. have the same ID else returns False
    public Boolean isConnected(final Integer element1, final Integer element2) {
        
        Boolean returnVal;
        if(connectArray[element1] == connectArray[element2])
            returnVal =  true;
        else
            returnVal = false;
        
        // System.out.println("isConnected called for " + element1 + " " + element2+ ". Returning: " + returnVal.toString());
        return returnVal;
    }
}