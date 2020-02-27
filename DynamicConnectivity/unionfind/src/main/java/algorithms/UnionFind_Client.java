package algorithms;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.FileNotFoundException;

import algorithms.UnionFind_QuickFind;
import algorithms.UnionFind_QuickUnion;
import algorithms.UnionFind_WeightedUnion;

import java.util.concurrent.TimeUnit;

public class UnionFind_Client {
    // Usage: java unionfind.UnionFind_Client <inputFileForConnections>
    public static void main(final String args[]) {
        // Read connections and queries from file
        final String inputFilePath = args[0];
        final String queryFilePath = args[1];
        final File inputFile = new File(inputFilePath);

        final BufferedReader fileLines;
        try{
            fileLines = new BufferedReader(new FileReader(inputFile));
        }
        catch (final FileNotFoundException f){
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
        
        final UnionFind_QuickFind unionObj = new UnionFind_QuickFind(Integer.parseInt(fileLine));
        // final UnionFind_QuickUnion unionObj = new UnionFind_QuickUnion(Integer.parseInt(fileLine));
        // final UnionFind_WeightedUnion unionObj = new UnionFind_WeightedUnion(Integer.parseInt(fileLine));
        Integer opCounter = 0;
        
        long startTime = System.nanoTime();

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
            opCounter += 1;
        }

        long endTime = System.nanoTime();
        long timeDiff = endTime - startTime;

        Float timeDiffMs = ((float)timeDiff/1000000);

        System.out.println("Total time taken for unions (ms): " + (timeDiffMs));
        System.out.println("Time per union operation (ns): " + (timeDiff/opCounter));

        // Testing connections
        final BufferedReader queryFileLines;
        final Integer numQueries;
        final File queryFile = new File(queryFilePath);
        try{
            queryFileLines = new BufferedReader(new FileReader(queryFile));
        }
        catch (final FileNotFoundException f){
            System.out.println("Input File not found");
            return;
        }
        
        fileLine = readLineFromFileReader(queryFileLines);

        // Handles invalid query files
        if (fileLine == null) {
            System.out.println("Invalid Input File");
            cleanupResources(fileLines);
            cleanupResources(queryFileLines);
            return;
        }
        else
            numQueries = Integer.parseInt(fileLine);

        startTime = System.nanoTime();
        for(Integer i = 0; i < numQueries; i++) {
            fileLine = readLineFromFileReader(queryFileLines);

            final String[] connectElements = fileLine.split(" ");

            final Integer element1 = Integer.parseInt(connectElements[0]);
            final Integer element2 = Integer.parseInt(connectElements[1]);
            
            unionObj.isConnected(element1, element2);
        }
        endTime = System.nanoTime();
        timeDiff = endTime - startTime;

        timeDiffMs = ((float) timeDiff / 1000000);

        System.out.println("Total time taken for finds (ms): " + (timeDiffMs));
        System.out.println("Time per union operation (ns): " + (timeDiff / numQueries));



        /* Manual Debugging Stuff (Can be used with SmallDataSet.txt) - To be Ported Later
        System.out.println("Connectivity check between 1 and 9. Expected: True. Actual: " + unionObj.isConnected(1, 9));
        System.out.println("Connectivity check between 2 and 7. Expected: True. Actual: " + unionObj.isConnected(2, 7));
        System.out.println("Connectivity check between 0 and 3. Expected: False. Actual: " + unionObj.isConnected(0, 3));
        System.out.println("Connectivity check between 5 and 4. Expected: False. Actual: " + unionObj.isConnected(5, 4));*/

        // Resource cleanup
        cleanupResources(fileLines);
        cleanupResources(queryFileLines);
        
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

