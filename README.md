# Algorithms_Submissions

Algorithm Implementations and Performance for algorithms from the __Algorithms and Data Structures (Part 1)__ course from Princeton University. Please see the [Repository Wiki](https://github.com/sreeharshau/Algorithms_Submissions/wiki) for algorithm performance results.

# Repository Structure
Each sub-project (except HelloWorld) comes with full maven support and can be built using __mvn package__. To run the application, refer to the sections below.

## Dependencies
All projects require [Apache Maven](https://maven.apache.org/index.html) and [JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) to be installed and relevant paths set up on the target machine. Some projects have scripts which might require [Python 3.5 or higher](https://www.python.org/downloads/) in order to function correctly.

# Dynamic Connectivity
## Build Steps
  - cd DynamicConnectivity
  - mvn clean && mvn package
  - cd unionfind/
 
## Run Details
The performance testing client can be run using any of the 3 algorithms (QuickFind, QuickUnion or WeightedUnion) to analyze their performance. To change the algorithm used, simply change the object creation line in the client file by commenting and uncommenting the respective 
object initalization lines.

The client takes 2 arguments as inputs - the first is a file containing all the union operations to perform using the algorithm and the second is a file containing all the connection test queries. Sample files have been provided in *largeDataSet_.txt*. under the input directory. A python script has also been provided under inputGenerator.py to create custom sized large random datasets for performance testing.

__Sample client command:__
  - `java -cp target/java -cp ./target/unionfind-1.0-SNAPSHOT.jar algorithms.UnionFind_Client .\input\largeDataSet_UnionInput.txt .\input\largeDataSet_FindInput.txt`
  
__Sample Dataset Generation__
  - `python inputDataGenerator.py <numElements> <numOperations> <Union||Find> <outputFilePath>`
    - __numElements__ - Maximum number of elements in connectivity set
    - __numOperations__ - Number of query / union operations to generate
    - __Union || Find__ - File type (Query vs Union)
    - __outputFilePath__ - Path of output file (will be created if it doesnt exist or will be overwritten if it does)
