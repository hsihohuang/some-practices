import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author HsiHo Huang
 * @date 2014/09/15
 * @version 2.0
 */
public class Data implements Comparable<Data>{
	static int N, D;
	int[] value;
	
	Data(int[] v){
		this.value = v;
	}
	
	@Override
	public int compareTo(Data another) {
		for(int i=0; i< D; i++){
			if(this.value[i] == another.value[i]) continue;
			return this.value[i] - another.value[i];
		}
		return 0;
    }
	
	public String toString(){
		StringBuilder dataStr = new StringBuilder();
		for(int v: this.value)
				dataStr.append(v+"\t");	
		dataStr.append("\r\n");
		return dataStr.toString();
	}
}
