#!python3

import os, sys, random

def generateDataSet(numElements,numOperations, generationMode, outFilePath):
    random.seed()
    with open(outFilePath, 'w') as outFile:
        if(generationMode == "Union"):
            outFile.write(str(numElements) + "\n")
        elif(generationMode == "Find"):
            outFile.write(str(numOperations) + "\n")
        else:
            print("Invalid Generation Mode. Please use Union/Find.")
            sys.exit(1)
            
        for i in range(numOperations):
            element1 = random.randrange(0, numElements)
            element2 = random.randrange(0, numElements)
            outFile.write(str(element1) + " " + str(element2) + "\n")
    
    print("Data set generated and written to file: ", outFilePath)
            

if(__name__ == "__main__"):
    if(len(sys.argv) != 5):
        print("Usage: ./inputDataGenerator.py <numElements> <numOperations> <Union||Find> <outputFilePath>")
        sys.exit(1);
    numElements = int(sys.argv[1])
    numOperations = int(sys.argv[2])
    generationMode = sys.argv[3]
    outFilePath = sys.argv[4]

    generateDataSet(numElements, numOperations, generationMode, outFilePath)


