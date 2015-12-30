import java.io.*;
import java.util.*;

/**
 * @author HsiHo Huang
 * @date 2014/07/19
 * @version 2.0
 */
public class TopkItem implements Comparable<TopkItem>{
	static int N, D, K; 
	private int score;
	private int[] data;
	
	public TopkItem(int[] data, int score){
		this.score = score;
		this.data = data;		
	}

	@Override
	public int compareTo(TopkItem another) {
		if(this.score == another.score){
			for(int i=0; i< D; i++){
				if(this.data[i] == another.data[i]) continue;
				return this.data[i] - another.data[i];
			}
		}
        return this.score - another.score;
    }
	
	public String toString(){
		StringBuilder dataStr = new StringBuilder();
		dataStr.append(this.score+" ");
		for(int d: this.data)
			dataStr.append(d+" ");
		dataStr.append("\r\n");
		return dataStr.toString();
	}
}
