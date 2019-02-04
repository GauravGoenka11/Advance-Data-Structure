/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads_lab;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cse
 */
public class Hashing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the numbers and 999 to end");
        ArrayList<Integer> data=new ArrayList<>();
        int key;
        while(true){
           key=sc.nextInt();
           if(key==999)
               break;
           data.add(key);
        }  
        System.out.print("*****************LINEAR HASHING********************");
        LinearHashing lh=new LinearHashing();
        lh.linearProbing(data);
        lh.displayTable();
        System.out.print("************QUADRATIC HASHING*******************");
        QuadraticHashing qh=new QuadraticHashing();
        qh.quadraticProbing(data);
        qh.displayTable();
        System.out.print("******************DOUBLE HASHING***************");
        DoubleHashing dh=new DoubleHashing();
        dh.doubleHashing(data);
        dh.displayTable();
    }
}

class LinearHashing{
    int table[][]=new int[11][2];
    int collision;
    double loadFactor;
    LinearHashing(){
        this.collision=0;
        this.loadFactor=0.0;
        for(int i=0;i<11;i++){
            table[i][0]=i;
            table[i][1]=-1;
        }
    }
    void linearProbing(ArrayList<Integer> data){
        int hashValue=0;
        for(int i=0;i<data.size();i++){
            hashValue=data.get(i)%11;
            if(this.table[hashValue][1]==-1)
                table[hashValue][1]=data.get(i);
            else{                
                while(this.table[hashValue][1]!=-1){
                    hashValue++;
                    if(hashValue>10)
                        hashValue=0;
                    collision++;
                }
                table[hashValue][1]=data.get(i);
            }
                
        }
        loadFactor=(double)data.size()/11;
    }
    
    void displayTable(){
        for(int i=0;i<11;i++){
            System.out.println("");
            System.out.print(" "+table[i][0]+"-->");
            if(table[i][1]!=-1)
                System.out.print(table[i][1]);
        }
        System.out.println("");
        System.out.println("Load Factor-->"+this.loadFactor);
        System.out.println("Collision-->"+this.collision);
    }
}
class QuadraticHashing{
    int table[][]=new int[11][2];
    int collision;
    double loadFactor;
    QuadraticHashing(){
        this.collision=0;
        this.loadFactor=0.0;
        for(int i=0;i<11;i++){
            this.table[i][0]=i;
            this.table[i][1]=-1;
        }
    }
    void quadraticProbing(ArrayList<Integer> data){
        int hashValue=0;
        for(int i=0;i<data.size();i++){
            hashValue=data.get(i)%11;
            if(this.table[hashValue][1]==-1)
                this.table[hashValue][1]=data.get(i);
            else{                
                int k=1;
                while(this.table[hashValue][1]!=-1){
                    hashValue=(hashValue+k*k)%11;
                    k++;
                    collision++;
                }
                this.table[hashValue][1]=data.get(i);
            }
                
        }
        loadFactor=(double)data.size()/11;
    }   
    void displayTable(){
        for(int i=0;i<11;i++){
            System.out.println("");
            System.out.print(" "+this.table[i][0]+"-->");
            if(table[i][1]!=-1)
                System.out.print(this.table[i][1]);
        }
        System.out.println("");
        System.out.println("Load Factor-->"+this.loadFactor);
        System.out.println("Collision-->"+this.collision);
    }
    
}
class DoubleHashing{
    int table[][]=new int[11][2];
    int collision;
    double loadFactor;
    DoubleHashing(){
        this.collision=0;
        this.loadFactor=0.0;
        for(int i=0;i<11;i++){
            this.table[i][0]=i;
            this.table[i][1]=-1;
        }
    }
    void doubleHashing(ArrayList<Integer> data){
        int hashValue=0;
        for(int i=0;i<data.size();i++){
            hashValue=data.get(i)%11;
            if(this.table[hashValue][1]==-1)
                this.table[hashValue][1]=data.get(i);
            else{                
                int k=1;
                while(this.table[hashValue][1]!=-1){
                    hashValue=(data.get(i)+(k*(7-(data.get(i)%7))))%11;
                    k++;
                    collision++;
                }
                this.table[hashValue][1]=data.get(i);
            }
                
        }
        loadFactor=(double)data.size()/11;
    }   
    void displayTable(){
        for(int i=0;i<11;i++){
            System.out.println("");
            System.out.print(" "+this.table[i][0]+"-->");
            if(table[i][1]!=-1)
                System.out.print(this.table[i][1]);
        }
        System.out.println("");
        System.out.println("Load Factor-->"+this.loadFactor);
        System.out.println("Collision-->"+this.collision);
    }
}
