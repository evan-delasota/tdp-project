#Catalog Comparison Program
CLI-based application built using OpenJDK-11

## Behaviors
This program accepts single or multiple inputs from the user as books, parses the given data into book objects, 
stores these book objects into an author's book catalog, 
and returns the oldest book of the author with the most 'book' entries

## How to Run
1. Install [OpenJDK](https://openjdk.java.net/projects/jdk/11/) onto your system
2. From the project directory, change directories to `./out/artifacts/tdp_jar/`
3. Enter `java -jar .\tdp.jar` to run the jar file
4. From the program menu, enter blocks of data formatted as</br>`"TITLE,DATE,AUTHOR,LENGTH"` with dates formatted as `"mm/dd/yyyy"`
    </br>e.g. `Carrie,06/13/1982,Steven King,762`
5. Once data entry is complete, press enter twice
6. The program should output information of the oldest book from the author with the most book entries</br>
   e.g. `Firestarter, written by Horror writer Steven King on 04/01/1982 is 597 pages long.`
