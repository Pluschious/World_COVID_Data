/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author rjpls
 */
public class Program_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       BufferedReader s = new BufferedReader(new FileReader("owid-covid-data.csv"));      //Reads in file using Bifferedreader
       MinPQ<Data> q = new MinPQ<Data>(4);                                                //new PriorityQueue size 4 
       boolean x = true;                        //x is used to check location from filr
       String tempLocation = "";                //saves to a string
       BST<Long, Data> tree = new BST();        //creates a new Binary Search Tree
       String line = s.readLine();              //reads nex line from file
       while((line = s.readLine()) != null){
           
           String[] arr = line.split(",");      //splits from file on ,
           Data data = new Data(arr);
           

            if(x){                                  //checks if data read in is the same as the previous line read
                q.insert(data);
                tempLocation = data.getLocation();
                x = false;                          //if so returns false
            }
       else if(tempLocation.equals(data.getLocation())){
           q.insert(data);                          //inserts new data into the array
           if(q.size() > 3){                        //if the number of elements in the array is greater than 3
               q.delMin();                          //deletes smallest element from the array
           }
       }
       else{
           while(!q.isEmpty()){                     //check if the array is not empty
               Data newD = q.delMin();              //deletes the saved element
               tree.put(newD.getNewCases(), newD);
           }
           q.insert(data);                          //inserts data
           tempLocation = data.getLocation();       //sets the tempLocation to get next data from the file
       }
       }
       s.close();
       while(!q.isEmpty()){
               Data newD = q.delMin();
               tree.put(newD.getNewCases(), newD);
           }
            for(Long k: tree.OrderedTraversal("In")){
                Data d2 = tree.get(k);
                System.out.println("New cases: " + d2.getNewCases() + " Location: " + d2.getLocation()          //prints the data in the appropriate formatt
                        + " Continent: " + d2.getContinent() + " Date: " + d2.getDate() + " Total Cases: "      //gets the data for each using the called function
                        + d2.getTotalCases() + " Population: " + d2.getPop() );
            }
                }
}
