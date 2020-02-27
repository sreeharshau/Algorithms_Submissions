package unionfind;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.FileNotFoundException;

import unionfind.UnionFind_QuickFind;
import unionfind.UnionFind_QuickUnion;
import unionfind.UnionFind_WeightedUnion;

public class UnionFind_Client {
    // Usage: java unionfind.UnionFind_Client <inputFileForConnections>
    public static void main(final String args[]) {
        // Read connections and queries from file
        final String inputFilePath = args[0];
        final File inputFile = new File(inputFilePath);
        final BufferedReader fileLines;
        try{
            fileLines = new BufferedReader(new FileReader(inputFile));
        }
        catch (FileNotFoundException f){
            System.out.println("Input File not found");
            return;
        }
        
        String fileLine = readLineFromFileReader(fileLines);

        // Handles invalid input files
        if (fileLine == null) {
            System.out.println("Invalid Input File");
            cleanupResources(fileLines);
            return;
        }

        // Instantiate a UnionFind object based on QuickFind or QuickUnion
        // final UnionFind_QuickFind unionObj = new UnionFind_QuickFind(Integer.parseInt(fileLine));
        // final UnionFind_QuickUnion unionObj = new UnionFind_QuickUnion(Integer.parseInt(fileLine));
        final UnionFind_WeightedUnion unionObj = new UnionFind_WeightedUnion(Integer.parseInt(fileLine));        

        // Read and call union for remaining lines in file
        while (true) {
            fileLine = readLineFromFileReader(fileLines);

            // Handle file closure
            if (fileLine == null)
                break;

            final String[] connectElements = fileLine.split(" ");

            final Integer element1 = Integer.parseInt(connectElements[0]);
            final Integer element2 = Integer.parseInt(connectElements[1]);
            
            unionObj.union(element1, element2);
        }

        // Testing connections
        System.out.println("Connectivity check between 1 and 9. Expected: True. Actual: " + unionObj.isConnected(1, 9));
        System.out.println("Connectivity check between 2 and 7. Expected: True. Actual: " + unionObj.isConnected(2, 7));
        System.out.println("Connectivity check between 0 and 3. Expected: False. Actual: " + unionObj.isConnected(0, 3));
        System.out.println("Connectivity check between 5 and 4. Expected: False. Actual: " + unionObj.isConnected(5, 4));

        // Resource cleanup
        cleanupResources(fileLines);
        
    }

    private static final String readLineFromFileReader(final BufferedReader fileLines) {
        try {
            final String fileLine = fileLines.readLine();
            return fileLine;
        } catch (final IOException i) {
            System.out.println("Error reading from input file");
            return null;
        }
    }

    private static final void cleanupResources(final BufferedReader fileLines) {
        try {
            fileLines.close();
        } catch (final IOException i) {
            System.out.println("Unable to close input file");
        }
    }
}

