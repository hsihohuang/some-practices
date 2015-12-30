import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * @author HsiHo Huang
 * @date 2014/08/20
 * @version 2.0
 */
public class SkylineItem implements Comparable<SkylineItem>{
	static int N, D, numsOfSKL = 0;
	static List<SkylineItem> skyline = new ArrayList<SkylineItem>();
	static StringBuilder outputStr = new StringBuilder();
	int[] data;
	
	public SkylineItem(int[] data){
		this.data = data;		
	}

	@Override
	public int compareTo(SkylineItem another) {
		for(int i=0; i< D; i++){
			if(this.data[i] == another.data[i]) continue;
			return this.data[i] - another.data[i];
		}
		return 0;
    }
	
	public String toString(){
		StringBuilder dataStr = new StringBuilder();
		for(int d: this.data)
				dataStr.append(d+"\t");
		/*skyline.forEach((item) -> {
			for(int d: item.data)
				dataStr.append(d+" ");
		});*/		
		dataStr.append("\r\n");
		return dataStr.toString();
	}
		
	public static void searchSkylineItems(List<SkylineItem> itemList){
		List<SkylineItem> restSKLItems = new ArrayList<SkylineItem>();
		skyline.clear();
		skyline.add(new SkylineItem((itemList.get(0)).data));
		
		for(int i=1; i<itemList.size(); i++){
			for(int j=0; j<skyline.size();j++){
				int dominateTimes = 0, beDominatedTimes = 0, equalTimes = 0;  
				for(int k =0; k< D; k++){
					if(itemList.get(i).data[k] == skyline.get(j).data[k]) equalTimes++;
					else if(itemList.get(i).data[k] < skyline.get(j).data[k]) dominateTimes++;
					else if(itemList.get(i).data[k] > skyline.get(j).data[k]) beDominatedTimes++;
				}
				
				if(equalTimes==D){
					skyline.add(new SkylineItem(itemList.get(i).data));
					j++;
					break;
				}else if((dominateTimes + equalTimes)== D ){
					restSKLItems.add(new SkylineItem(skyline.get(j).data));
					skyline.remove(j--);
				}else if((beDominatedTimes + equalTimes) == D){
					restSKLItems.add(new SkylineItem(itemList.get(i).data));
					break;
				}
				
				if(j == (skyline.size()-1)){
					skyline.add(new SkylineItem(itemList.get(i).data));
					break;
				}
			}		
		}
		Collections.sort(skyline);
		outputSkylineItems();
		
		if(restSKLItems.size() == 0) return;
		else searchSkylineItems(restSKLItems);	
	}
	
	public static void outputSkylineItems(){
		outputStr.append("No."+ (++numsOfSKL) +" skyline: total "+ skyline.size()+" points\r\n");
		skyline.forEach(i -> outputStr.append(i.toString()));
	}
}
