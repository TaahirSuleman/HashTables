import java.util.*;
import java.io.*;

class findWeights{
   String[] elements = new String[40];
   int count = 0;
   //int[][] weights = new int[Math.pow(5,9)][9];
   public void read(){
      try{
         Scanner sc = new Scanner(new FileReader("names36.txt"));
         while(sc.hasNext()){
            elements[count] = sc.next();
            count++;
         }
      }
      catch(FileNotFoundException e){
         System.out.println("File was not found.\n" + e);
      }
   }
   
   public void populate(){
      
   }
   public int[] bestWeights(){
      int weights[] = new int[9];
         for(int i = 0; i < 5; i++){
            weights[0] = i;
            for(int i2 = 0; i2 < 5; i2++){
               weights[1] = i2;
               for(int i3 = 0; i3 < 5; i3++){
                  weights[2] = i3;
                  for(int i4 = 0; i4 < 5; i4++){
                     weights[3] = i4;
                     for(int i5 = 0; i5 < 5; i5++){
                        weights[4] = i5;
                        for(int i6 = 0; i6 < 5; i6++){
                           weights[5] = i6;
                           for(int i7 = 0; i7 < 5; i7++){
                              weights[6] = i7;
                              for(int i8 = 0; i8 < 5; i8++){
                                 weights[7] = i8;
                                 inner: for(int i9 = 0; i9 < 5; i9++){
                                    weights[8] = i9;
                                    HashTable h = new HashTable();
                                       
                                    for(int k = 0; k < count; k++){
                                       h.insert(elements[k], weights);
                                       if(h.getCollisions()>0)
                                          continue inner; 
                                          // every time a collision is present it immediately goes to the next weight combination.
                                    }
                                 return weights; 
                                 // if it gets to this return statement it means there were no collisions. Thus, this returns the weights immediately after a perfect combination is found to avoid redundant work.
                                 }        
                              }     
                           }  
                        }           
                     }
                  }
               }
            }
         }
      return null;
   }
   
   public static void main(String[] args){
    findWeights fw = new findWeights();
    fw.read();
    int[] weights = fw.bestWeights();
    for(int i =0; i < 9; i++){
      System.out.println(weights[i]);
    }
   }
   
}