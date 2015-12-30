import java.io.*;
import java.util.*;

public class Main{	
    public static void main(String[] args) throws Exception {
		TopkItem[] topk;
		String getFilePath,line;
		String [] dataStr;
		BufferedReader inputPath = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please Input the file path: ");
		getFilePath = inputPath.readLine();
		try {
			//read the input file (sample/testX.in)
			FileReader testFile= new FileReader(getFilePath);
			BufferedReader BufferedStream = new BufferedReader(testFile);
			line = BufferedStream.readLine();
			dataStr = line.split(" ");
			TopkItem.N = Integer.parseInt(dataStr[0]);
			TopkItem.D = Integer.parseInt(dataStr[1]);
			topk = new TopkItem[TopkItem.N];

			for(int i=0; i<TopkItem.N; i++){
				line = BufferedStream.readLine();
				dataStr = line.split(" ");								
				int score = 0;
				int[] data = new int[TopkItem.D];
				for(int j=0; j<TopkItem.D ; j++) {
					data[j] = Integer.parseInt(dataStr[j]);
					score += data[j];
				}
				topk[i] = new TopkItem(data, score);					
			}		
			line = BufferedStream.readLine();
			dataStr = line.split(" ");
			TopkItem.K = Integer.parseInt(dataStr[0]);
		}catch (FileNotFoundException e1) {
			System.out.println("file not found\n" + e1);
			return;
		}
		
		Arrays.sort(topk);
		
		//output the result (sample outputs are in sample/testX.out)
		BufferedReader outputPath = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please Input the output file path: ");
		getFilePath = outputPath.readLine();
		
		try{
			FileWriter out = new FileWriter(getFilePath,true);
			for(int i=0; i<TopkItem.K ; i++) 
				out.write(topk[i].toString());
			out.close();
		}catch(IOException ioe){
			 System.out.print(ioe);
		}
    }
}
