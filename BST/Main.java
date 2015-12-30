import java.io.*;
import java.util.*;

/**
 * @author HsiHo Huang
 * @date 2014/09/15
 * @version 2.0
 */
public class Main{	
    public static void main(String[] args) throws Exception{
		int Q = 0;
		String getFilePath,line;
		String [] dataStr, query;
		Data[] dataArray;
		int[] data;
		StringBuilder outputResult = new StringBuilder();
		BufferedReader inputPath = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please Input the file path: ");
		getFilePath = inputPath.readLine();
		try {
			//read the input file (sample/testX.in)
			FileReader testFile= new FileReader(getFilePath);
			BufferedReader BufferedStream = new BufferedReader(testFile);
			line = BufferedStream.readLine();
			dataStr = line.split(" ");
			Data.N = Integer.parseInt(dataStr[0]);
			Data.D = Integer.parseInt(dataStr[1]);
			dataArray = new Data[Data.N];
			
			for(int i=0; i<=Data.N; i++){
				data = new int[Data.D];
				line = BufferedStream.readLine();
				dataStr = line.split("\t");
				if(i<Data.N){
					for(int j=0; j<Data.D ; j++) 
						data[j] = Integer.parseInt(dataStr[j]);
					
					dataArray[i] = new Data(data);
				}
				else
					Q = Integer.parseInt(dataStr[0]);
			}
			
			query = new String[Q];
			for(int i=0; i<Q ; i++)
				query[i] = BufferedStream.readLine();
			
			Arrays.sort(dataArray);
			
			MyBST myBST = new MyBST(dataArray);
			for(int i=0; i<Q; i++){
				outputResult.append("Query " +(i+1)+":\n");
				String[] q = query[i].split(" ");
				outputResult.append(myBST.search(q)+"\n");
			}
		}catch (FileNotFoundException e1) {
			System.out.println("file not found\n" + e1);
			return;
		}
		//output the result (sample outputs are in sample/testX.out)
		BufferedReader outputPath = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please Input the output file path: ");
		getFilePath = outputPath.readLine();
		try{
			FileWriter out = new FileWriter(getFilePath,true);
			out.write(outputResult.toString());
			out.close();
		}catch(IOException ioe){
			 System.out.print(ioe);
		}
	}
}
