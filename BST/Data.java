import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



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
		/*skyline.forEach((item) -> {
			for(int d: item.data)
				dataStr.append(d+" ");
		});*/		
		dataStr.append("\r\n");
		return dataStr.toString();
	}
}
