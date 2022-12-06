/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program_1;

/**
 *
 * @author rjpls
 */
public class Data implements Comparable<Data> {
        private Long newCases;
        private Long totalCases;
        private String continent;
        private Long pop;
        private String location;
        private String date;
        
        
    public Data(String[] string){
    this.newCases = Long.parseLong(string[4]);
    this.continent = string[0];
    this.totalCases = Long.parseLong(string[3]);
    this.pop = Long.parseLong(string[5]);
    this.location = string[1];
    this.date = string[2];
    
}
    public int compareTo(Data x){
        if(this.newCases < x.newCases){
            return -1;
        }
        if(this.newCases > x.newCases){
            return 1;
        }
        return 0;
    }
    public Long getNewCases(){
        return newCases;
    }
    public String getContinent(){
        return this.continent;        
    }
    public Long getTotalCases(){
        return this.totalCases;        
    }
    public Long getPop(){
        return this.pop;        
    }
    public String getLocation(){
        return this.location;        
    }
    public String getDate(){
        return this.date;        
    }
   
    
}




