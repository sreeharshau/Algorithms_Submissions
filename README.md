# Algorithms_Submissions
Submissions for Algorithms, Part 1 (Princeton University)

Each sub-project (except HelloWorld) comes with full maven support and can be built using mvn package. To run the application, refer to the text below:

1) Dynamic Connectivity
  - cd DynamicConnectivity
  - mvn clean && mvn package
  - cd unionfind/
 
The performance testing client can be run using any of the 3 algorithms (QuickFind, QuickUnion or WeightedUnion) to analyze their performance. To change the algorithm used, simply change the object creation line in the client file by commenting and uncommenting the respective 
object initalization lines.

The client takes 2 arguments as inputs - the first is a file containing all the union operations to perform using the algorithm and the second is a file containing all the connection test queries. Sample files have been provided in *largeDataSet_.txt*. under the input directory. A python script has also been provided under inputGenerator.py to create custom sized large random datasets for performance testing.

Sample client command:
  - java -cp target/java -cp ./target/unionfind-1.0-SNAPSHOT.jar algorithms.UnionFind_Client .\input\largeDataSet_UnionInput.txt .\input\largeDataSet_FindInput.txt
