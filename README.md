# CMS-Neo4j

### Project Definition
-----
This project covers concepts related to	 Graph Database, and	visualization	of a management	project. The project can be consider as a	visualization	&	marketing	phase	of an industry	project.

### Exploring and Understanding the Dataset
-----
For the present project, the provided dataset is available at https://data.novascotia.ca/Lands-Forests-and-Wildlife/DNR-Camping-Parks-Reservation-Data2016/4zt7-x443. The dataset prescribes information related to the campaign parks reservation details useful for common people. The dataset is collected from the campaign parks reservation system within provisional parks season (May – October) for year 2016. The parks mentioned in the dataset are mainly from Canada or USA, while few of them are from other countries. Dataset contains total 13 columns and 34941 rows.

### Data Extraction / Transformation
-----
I have written program using Java for the extraction and filtration of data. The original file with downloaded data is in file named “file.csv” and processed files are named as “file1.csv”, “file2.csv” and “file3.csv”. The source code is placed under java source file named “Program.java”.

### Installing the required tools
-----
I have downloaded the Neo4j software from the official website and installed on my system. As a additional dependency I need to install Analytics and Visualization inside Neo4j for the analysis purpose.

### Graph Building & Query
-----
* As first task, I have inserted 20 unique parks as nodes in a graph using following query 'LOAD CSV WITH HEADERS FROM "file:///file4.csv" AS line MERGE (park:Park {name: line.ParkName})'. All the parks are in Nova Scotia which requires creating relationships between all the 20 parks. To create relationship between all the parks, I have used following cypher query "MATCH (a:Park),(b:Park) CREATE (a)-[r:NS]->(b) RETURN r". The output result from this query is as below:
![alt text](/images/7.png)

* Now for the parks with same “rate-type”, I have created relationship named “NeighbourByRate” using following cypher query. 'MATCH (a:Park), (b:Park) WHERE a.RateType = b.RateType CREATE (a)-[r:NeighbourByRate]->(b) RETURN r;'. After creating relationship between same rate-type parks the graph will look like:
![alt text](/images/4.png)

* Now for the parks with identical “equipment”, I have created relationship named “NeighbourByEquipment” using following cypher query. 'MATCH (a:Park), (b:Park) WHERE a.Equipment = b.Equipment CREATE (a)-[r:NeighbourByEquipment]->(b) RETURN r;'. After creating relationship between same rate-type parks the graph will look like:
![alt text](/images/5.png)

* Now after creating relationships between nodes, I have installed the Analytic and Visualization plugin in Neo4j. This could be used to filter and analyze complex data.

### References
-----
“Neo4j Graph Platform – The Leader in Graph Databases”. Available: https://neo4j.com/.
