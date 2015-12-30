import java.io.*;
import java.util.*;


/**
 * @author HsiHo Huang
 * @date 2014/08/20
 * @version 2.0
 */
public class Main{	
    public static void main(String[] args)throws Exception {
		SkylineItem[] sKLItemArray;
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
			dataStr = line.split("\t");
			SkylineItem.N = Integer.parseInt(dataStr[0]);
			SkylineItem.D = Integer.parseInt(dataStr[1]);
			sKLItemArray = new SkylineItem[SkylineItem.N];

			for(int i=0; i<SkylineItem.N; i++){
				line = BufferedStream.readLine();
				dataStr = line.split("\t");								
				int[] data = new int[SkylineItem.D];
				for(int j=0; j<SkylineItem.D ; j++) {
					data[j] = Integer.parseInt(dataStr[j]);
				}
				sKLItemArray[i] = new SkylineItem(data);					
			}		
		}catch (FileNotFoundException e1) {
			System.out.println("file not found\n" + e1);
			return;
		}
		
		SkylineItem.searchSkylineItems(Arrays.asList(sKLItemArray));
		//output the result (sample outputs are in sample/testX.out)
		BufferedReader outputPath = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please Input the output file path: ");
		getFilePath = outputPath.readLine();
		try{
			FileWriter out = new FileWriter(getFilePath,true);
			out.write(SkylineItem.outputStr.toString());
			out.close();
		}catch(IOException ioe){
			 System.out.print(ioe);
		}
	}
}
