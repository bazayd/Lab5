import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

<<<<<<< HEAD
        Dollar[] dollars = {
=======
        HashFunction hashTable = new HashFunction(29);
        Scanner scanner = new Scanner(System.in);
        
        Currency[] currencies = {
>>>>>>> 1bc1289290674830f24915aa3f09bd326422c096
                new Dollar(57.12),
                new Dollar(23.44),
                new Dollar(87.43),
                new Dollar(68.99),
                new Dollar(111.22),
                new Dollar(44.55),
                new Dollar(77.77),
                new Dollar(18.36),
                new Dollar(543.21),
                new Dollar(20.21),
                new Dollar(345.67),
                new Dollar(36.18),
                new Dollar(48.48),
                new Dollar(101.00),
                new Dollar(11.00),
                new Dollar(21.00),
                new Dollar(51.00),
                new Dollar(1.00),
                new Dollar(251.00),
                new Dollar(151.00)
        };
<<<<<<< HEAD

=======
        
        //add all elements into the 
//        for (int i = 0; i < currencies.length; i++) {
//        	hashTable.HashInsert(currencies[i], i);
//        }
        
        System.out.println("Number of Data Uploaded: ");
        System.out.println("Load Factor: ");
        System.out.println("Number of Collisions: ");
        System.out.println("");
        
        
        boolean end = false;
        
        while(!end) {
        	System.out.println("Search or End? : ");
            System.out.println("(1) Search");
            System.out.println("(2) End");
            
        	int result = scanner.nextInt();
        	
        	switch (result) {
            case 1:
                System.out.println("Enter Dolalr Object to search for: ");
                double dollarObj = scanner.nextDouble();
                scanner.nextLine();
                //hashTable.HashSearch(new Dollar(dollarObj));
                break;
            
            case 2:
            	end = true;
        	
        	
        	}
        }
>>>>>>> 1bc1289290674830f24915aa3f09bd326422c096

        HashTable hashTable = new HashTable(29);


        for (Dollar dollar: dollars) {
            hashTable.hashInsert(dollar);
        }

        hashTable.printHashTable();

    }
}