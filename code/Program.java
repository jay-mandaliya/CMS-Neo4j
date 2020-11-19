import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Program{

    public static void main(String[] args){
        
        doTaskOne();
        doTaskTwo();
        doTaskThree();
    }
    
    static void doTaskOne(){
        
        BufferedReader br = null;
        FileWriter fw = null;
        String row = null;
        
        try{
            
            br = new BufferedReader(new FileReader("../data/file.csv"));
            fw = new FileWriter("../data/file1.csv");
            
            fw.append(br.readLine());
            fw.append("\n");
            
            while((row = br.readLine()) != null){
                
                String[] info = row.split(",");
                
                if(info[2].trim().equals("CANADA")){
                    fw.append(row);
                    fw.append("\n");
                }
            }
        
            br.close();
            fw.flush();
            fw.close();
        }catch(Exception e){
            System.out.println("Exception occurred");
        }
    }
    
    
    static void doTaskTwo(){
        
        BufferedReader br = null;
        FileWriter fw = null;
        String row = null;
        
        try{
            
            br = new BufferedReader(new FileReader("../data/file1.csv"));
            fw = new FileWriter("../data/file2.csv");
            
            br.readLine();
            fw.append("ParkName,State,partySize,BookingType,RateType,Equipment");
            fw.append("\n");
            
            while((row = br.readLine()) != null){
                
                String[] info = row.split(",");
                
                fw.append(info[0]+","+info[1]+","+info[5]+","+info[7]+","+info[6]+","+info[8]);
                fw.append("\n");
            }
            
            br.close();
            fw.flush();
            fw.close();
        }catch(Exception e){
            System.out.println("Exception occurred");
        }
    }
    
    
    static void doTaskThree(){
        
        BufferedReader br = null;
        FileWriter fw = null;
        String row = null;
        
        try{
            
            br = new BufferedReader(new FileReader("../data/file2.csv"));
            fw = new FileWriter("../data/file3.csv");
            
            fw.append(br.readLine());
            fw.append("\n");
            
            while((row = br.readLine()) != null){
                
                String[] info = row.split(",");
                
                if(info[5].contains("Less than")){
                    fw.append(info[0]+","+info[1]+","+info[2]+","+info[3]+","+info[4]+","+info[5].replace("Less than","LT"));    
                }else if(info[5].contains("Single Tent")){
                    fw.append(info[0]+","+info[1]+","+info[2]+","+info[3]+","+info[4]+","+info[5].replace("Single Tent","ST"));
                }else{
                    fw.append(row);
                }
                
                fw.append("\n");
            }
            
            br.close();
            fw.flush();
            fw.close();
        }catch(Exception e){
            System.out.println("Exception occurred");
        }
    }
}