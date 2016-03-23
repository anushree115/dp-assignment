import java.io.BufferedReader;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
public class MazeGame 
{


	public static void main(String[] args) {
		try {
			//File fileReadMaze = new File("/home/pesit/Desktop/CreateMaze.txt");
			 //Scanner sc1= new Scanner(fileReadMaze);
			
			 //File fileTraverseMaze=new File("/home/pesit/Desktop/TraverseMaze.txt");
			// Scanner sc2= new Scanner(fileTraverseMaze);
			 //Change 15 to bigger no.
			 int [][] maze=new int[15][5];
			 int lines_in_readFile=0;
			 BufferedReader br;
			 br = new BufferedReader(new FileReader("CreateMaze.txt"));
			 BufferedReader br1;
			 br1 = new BufferedReader(new FileReader("TraverseMaze.txt"));

			 //Change both the values to bigger nos. traversalInstructions=new in
			 int [][] traversalInstructions=new int [25][];
			 int lines_in_traverseFile=0;
			 
			/* 
			//FileReader readReadMaze = new FileReader(fileReadMaze);
			BufferedReader bufferedReadMaze = new BufferedReader(fileReadMaze);
			
			FileReader readTraverseMaze = new FileReader(fileTraverseMaze);
			BufferedReader bufferedTraverseMaze = new BufferedReader(readTraverseMaze);
			*/
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			String[] strarr=new String[5];
			String delims="\\s+";
		    BufferedWriter bw = null;
		/*	File file = new File("/home/pesit/Desktop/DestinationMaze.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);*/
			
			// to read the createMaze file
			while ((line = br.readLine()) != null) {
				
				strarr=line.split(delims);
				for(int i=0;i<strarr.length;i++)
				{
					int temp=Integer.parseInt(strarr[i]);
					
					
					maze[lines_in_readFile][i]=temp;
				}
				
				lines_in_readFile++;
				/*for(int i=0; i<maze.length;i++){
					for(int j=0;j<5;j++)
					{
						System.out.println(maze[i][j]);
					}
				}*/
			}
			
			br.close(); 
			int k=0,u=0; 
			// To read the traversal file.
			while ((line = br1.readLine()) != null) {
				k++;
				strarr=line.split(delims);
				traversalInstructions[lines_in_traverseFile]= new int[strarr.length];
				for(int i=0;i<strarr.length;i++)
				{
					int temp=Integer.parseInt(strarr[i]);
					
					
					traversalInstructions[lines_in_traverseFile][i]=temp;
					//System.out.print(traversalInstructions[lines_in_traverseFile][i]);
				}
				
				lines_in_traverseFile++;
				}
			//System.out.println(k);
			br1.close();
			int tp;
			PrintWriter file = new PrintWriter("DestinationMaze.txt", "UTF-8");
		
			for(int i=0;i<k;i++)
			{
				int temp = traversalInstructions[i][0];
				for(int j=1;j<traversalInstructions[i].length;j++)
				{
					tp = temp;
					//System.out.print(temp);
					temp = maze[temp-1][traversalInstructions[i][j]+1];
					if(temp==0)
					{
						temp = tp;
					}
				}
				
				file.println(temp);
				 System.out.println("File written Successfully");

				
				//System.out.println(temp);
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


