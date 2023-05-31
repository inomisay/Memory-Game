import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean flag = true;
		
		while(flag) {
			
			// Read a text file of animals
			SingleLinkedList animalSLL = new SingleLinkedList();
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader("animals.txt"));
				String line = reader.readLine();
				while(line != null) {
			        line = line.trim(); // remove spaces from beginning and end of the line
					animalSLL.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch(IOException e) {
				System.out.println("An error occurred while reading the file.");
				e.printStackTrace();
			}
			/***********************************************/
			System.out.println("\nWelcome to the Memory Game");
			System.out.println("---------------------------");
			
			// show animalSLL from the file
			System.out.print("\nAnimal SLL: ");
			Node animal_current = animalSLL.head;
			while (animal_current != null) {
			    System.out.print(animal_current.getData() + " ");
			    animal_current = animal_current.getLink();
			}
			/***********************************************/
			// Getting the value n from the user
			Scanner sc = new Scanner(System.in);
			int n = 0;
			// controlling the value n
			do {
				System.out.print("\n\nPlease give us a number: "); // card value
				
		        //Prevent string input crashing the program.
		        while (!sc.hasNextInt()) {
		            System.out.printf("\nInput doesn't match specifications. Try again.\n");
					System.out.print("\nPlease give us a number: "); // card value
		            sc.next(); 
		        }
		        //Set the number.
		        n = sc.nextInt();

		        //If the number is outside range (the cards can't be negative) print an error message.
		        if (n < 1)
		            System.out.printf("\nInput doesn't match specifications. Try again.\n");
		    } while (n < 1);
			/***********************************************/
			// Game ...
			System.out.println("\n************************************************");
			System.out.println("");
			System.out.println("Let the Game Begin\n");
			/***********************************************/
			int score = 0, step = 1;
			/***********************************************/
			Random rand = new Random();
			// Create the game board SLL1
			SingleLinkedList SLL1 = new SingleLinkedList();
			SingleLinkedList SLL2 = new SingleLinkedList(); // contains the matches of tiles in the SLL1

			// Randomly select n animals from animalSLL
			int animalCount = animalSLL.size();
			int[] selectedAnimals = new int[animalCount];
			for (int i = 0; i < animalCount; i++) {
			    selectedAnimals[i] = -1;
			}	
			// make sure n doesn't exceed the number of available animals
			if(n > animalCount)
			    n = animalCount;

			for (int i = 0; i < n; i++) {
			    int animalIndex = rand.nextInt(animalCount);

			    // Ensure that animalIndex is not already used in SLL1
			    while (selectedAnimals[animalIndex] != -1)
			        animalIndex = rand.nextInt(animalCount);

			    // Get the selected animal from animalSLL
			    String animal = "";
			    int index = 0;
			    Node current = animalSLL.head;
			    while (current != null) {
			        if (index == animalIndex) {
			            animal = (String) current.getData();
			            break;
			        }
			        current = current.getLink();
			        index++;
			    }

			    // Add the animal to SLL1 and add the corresponding match to SLL2 (The second SLL contains the matches of tiles in the first SLL.)
			    SLL1.add(animal);
			    SLL2.add(animal);

			    // Shuffle SLL2 
			    int listSize = SLL2.size();
			    for (int a = listSize - 1; a > 0; a--) {
			        int b = rand.nextInt(a + 1);
			        
			        // Swap the nodes at index i and j in SLL2
			        Node nodeI = SLL2.head;
			        Node nodeJ = SLL2.head;

			        // Move nodeI to index a
			        for (int c = 0; c < a; c++) {
			            nodeI = nodeI.getLink();
			        }

			        // Move nodeJ to index b
			        for (int d = 0; d < b; d++) {
			            nodeJ = nodeJ.getLink();
			        }

			        // Swap the node data
			        Object temp = nodeI.getData();
			        nodeI.setData(nodeJ.getData());
			        nodeJ.setData(temp);
			    }

			    // Mark the selected animal as used
			    selectedAnimals[animalIndex] = i;
			}	

			/***********************************************/
			while(SLL1.head != null || SLL2.head != null) {

				// Display the contents of SLL1
				System.out.print("\nSLL1: ");
				SLL1.display();
				// Score
				System.out.print("		Score: " + score);
				// Display the contents of SLL2
				System.out.print("\nSLL2: ");
				SLL2.display();
				System.out.print("		Step: " + step);
				System.out.print("\n");
				/***********************************************/
		        // Randomly select one tile from SLL1 and one tile from SLL2
		        int tileIndex1 = rand.nextInt(SLL1.size());
		        int tileIndex2 = rand.nextInt(SLL2.size());

		        // Get the data values of the selected tiles
		        String animal1 = "";
		        Node current_SLL1 = SLL1.head;
		        for (int i = 0; i < tileIndex1; i++) {
		            current_SLL1 = current_SLL1.getLink();
		        }
		        animal1 = (String) current_SLL1.getData();

		        String animal2 = "";
		        Node current_SLL2 = SLL2.head;
		        for (int i = 0; i < tileIndex2; i++) {
		            current_SLL2 = current_SLL2.getLink();
		        }
		        animal2 = (String) current_SLL2.getData();

		        // Get the nodes at the selected indices
		        Node prev1 = null;
		        Node current__SLL1 = SLL1.head;
		        for (int i = 0; i < tileIndex1; i++) {
		            prev1 = current__SLL1;
		            current__SLL1 = current__SLL1.getLink();
		        }

		        Node prev2 = null;
		        Node current__SLL2 = SLL2.head;
		        for (int i = 0; i < tileIndex2; i++) {
		            prev2 = current__SLL2;
		            current__SLL2 = current__SLL2.getLink();
		        }

		        // Check if the tiles are the same
		        if (current__SLL1.getData().equals(current__SLL2.getData())) {
		            // Remove the nodes from the lists
		            if (prev1 == null) {
		                SLL1.head = current__SLL1.getLink();
		            } else {
		                prev1.setLink(current__SLL1.getLink());
		            }
		            
		            if (prev2 == null) {
		                SLL2.head = current__SLL2.getLink();
		            } else {
		                prev2.setLink(current__SLL2.getLink());
		            }
		            score += 20;
		        } else {
		            score--;
		        }
		        
		        step++;
				System.out.print("\n");
		        System.out.print("Randomly generated numbers: " + tileIndex1 + " " + tileIndex2);
		        System.out.println("\n--------------------------------");
				
		    }
			if(SLL1.head == null || SLL2.head == null) {
				// Display the contents of SLL1
				System.out.print("\nSLL1: ");
				// Display the contents of SLL2
				System.out.print("\nSLL2: ");
				System.out.print("\n");
			}
			
			/***********************************************/
			// Game over
		    System.out.println("\nThe Game is over! Final score: " + score + "\n");
			/***********************************************/
			// Read from the file.txt; show the HighScore and update it write it to the file.txt
		    
		    // Creating two queues Q1 for names and Q2 for scores
		 	SingleLinkedList SLL3 = new SingleLinkedList();
		 	SingleLinkedList SLL4 = new SingleLinkedList();
		 	
		 	// Reading the unsorted file using the BufferedReader class
 			BufferedReader br = null;
		 	try {
	            br = new BufferedReader(new FileReader("highscoretable.txt"));
	            String line = br.readLine().trim();
	            while (line != null) {
	            	// Splitting each line into name and score
	                String[] parts = line.split(" ");
	                if (parts.length != 2) {
	                    System.out.println("Invalid file format!");
	                    return;
	                }
	                SLL3.add(parts[0]); // names
	                SLL4.add(Integer.parseInt(parts[1]));  // scores
	                line = br.readLine();
	            }
	            br.close();
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	            return;
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid file format: " + e.getMessage());
	            return;
	        }finally {
	        	if(br != null) {
	        		try {
	        			br.close();
	        		} catch(IOException e) {
	        			System.out.println("We encouner an Error: " + e.getMessage());
		 	          }
	        	}
	        }
			/***********************************************/
		 	// Add the new score to the list
		 	System.out.print("\nEnter your name: ");
			String newWinner = sc.next();
		 	SLL3.add(newWinner);
	        SLL4.add(score);
	        System.out.println("");
	        
	        // Sort the list in descending order
	        highscoreSort(SLL3, SLL4);

	        // Control the size
	        if (SLL3.size() > 12) {
	            // Remove the last element
	            Node temp = SLL3.head;
	            Node prev = null;
	            while (temp.getLink() != null) {
	                prev = temp;
	                temp = temp.getLink();
	            }
	            prev.setLink(null);
	            
	            temp = SLL4.head;
	            prev = null;
	            while (temp.getLink() != null) {
	                prev = temp;
	                temp = temp.getLink();
	            }
	            prev.setLink(null);
	        }

	        // Display the top 12 scores with names
	        System.out.println("Top 12 high scores:");
	        System.out.println("-------------------");
	        int count = 0;
	        Node temp1 = SLL3.head;
	        Node temp2 = SLL4.head;
	        while(temp1 != null && temp2 != null && count < 12) {
	            String names = (String) temp1.getData();
	            int scores = (Integer) temp2.getData();
	            System.out.println(names + " " + scores);
	            temp1 = temp1.getLink();
	            temp2 = temp2.getLink();
	            count++;
	        }
	        if (count == 0) {
	            System.out.println("There are no more scores to display.");
	        }
			/***********************************************/
	        // Write the updated scores to the file
	        BufferedWriter bw = null;
	        try {
	            bw = new BufferedWriter(new FileWriter("highscoretable.txt"));
	            Node current_SLL3 = SLL3.head;
	            Node current_SLL4 = SLL4.head;
	            while (current_SLL3 != null && current_SLL4 != null) {
	            	String names = (String) current_SLL3.getData();
	            	int scores = (Integer) current_SLL4.getData();
	            	bw.write(names + " " + scores);
	            	bw.newLine();
	            	current_SLL3 = current_SLL3.getLink();
	            	current_SLL4 = current_SLL4.getLink();
	            }
	            bw.close();
	            System.out.println("Data written to file successfully.");
	        } catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	        } finally {
	            if (bw != null) {
	                try {
	                    bw.close();
	                } catch (IOException e) {
	                    System.out.println("We encountered an error: " + e.getMessage());
	                }
	            }
	        }  
			/***********************************************/
			System.out.println("");
	        // ask the user to play again or quit
		    System.out.print("Play again? (Y/N): ");
		    String input = sc.next();
		    if (input.equalsIgnoreCase("N")) {
		        flag = false;
		    }
		}
	}
	
	/***********************************************/
    /*HighScore Sort*/
	public static void highscoreSort(SingleLinkedList names, SingleLinkedList scores) {
	    int size = scores.size();

	    // Create arrays to store names and scores
	    String[] name = new String[size];
	    int[] score = new int[size];

	    // add the names and scores into the arrays
	    Node namesNode = names.head;
	    Node scoresNode = scores.head;
	    int i = 0;
	    while (namesNode != null && scoresNode != null) {
	        name[i] = (String) namesNode.getData();
	        score[i] = (int) scoresNode.getData();
	        namesNode = namesNode.getLink();
	        scoresNode = scoresNode.getLink();
	        i++;
	    }

	    // Sort the arrays in descending order based on the scores
	    for (int j = 0; j < size - 1; j++) {
	        for (int k = j + 1; k < size; k++) {
	            if (score[j] < score[k]) {
	                // Swap the scores
	                int tempScore = score[j];
	                score[j] = score[k];
	                score[k] = tempScore;

	                // Swap the names to keep them in sync with the scores
	                String tempName = name[j];
	                name[j] = name[k];
	                name[k] = tempName;
	            }
	        }
	    }

	    // add the sorted names and scores back into the list
	    Node namesNode2 = names.head;
	    Node scoresNode2 = scores.head;
	    int j = 0;
	    while (namesNode2 != null && scoresNode2 != null) {
	        namesNode2.setData(name[j]);
	        scoresNode2.setData(score[j]);
	        namesNode2 = namesNode2.getLink();
	        scoresNode2 = scoresNode2.getLink();
	        j++;
	    }
	}

}
