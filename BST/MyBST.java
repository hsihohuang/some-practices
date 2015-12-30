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
class Node{
	Node leftNode, rightNode;
	List<Data> data = new ArrayList<Data>();
	
	Node(Data d, int index){
		if(index >= 0 && index < Data.D)
			this.data.add(d);
		this.leftNode = null;
		this.rightNode = null;
		this.insert(d, ++index);		
	}
	
	void insert(Data d,int index){
		if(index == (Data.D -1))
			return;
		
		if(d.value[index] <= d.value[index+1])
		{
			if(leftNode == null)
				leftNode = new Node(d, index);
			else
			{
				leftNode.data.add(d);
				leftNode.insert(d, ++index);
			}
		}
		else if(d.value[index] > d.value[index+1])
		{
			if(rightNode == null)
				rightNode = new Node(d, index );
			else
			{
				rightNode.data.add(d);
				rightNode.insert(d, ++index);
			}
		}
	}	
}

public class MyBST {
	Node root;
	static StringBuilder outputStr;
	
	public MyBST(Data[] data){
		root = null;
		
		for(Data d: data)
			insertNode(d);
	}
	
	public void insertNode(Data d){
		if(root == null)
			root = new Node(d,-1); 
	    else
	        root.insert(d,0);
	}
	
	public String search(String[] q){
		outputStr = new StringBuilder();
		searchWay( root, q, 0 );
		return outputStr.toString();
	}
	
	void searchWay(Node node, String[] q, int index)
	{ 
		if(index == (q.length))	
		{
			if(node == null){
				outputStr.append("The number of the data: "+0+"\n");
				outputStr.append("null");
				return ;
			}
			outputStr.append("The number of the data: "+node.data.size()+"\n");
			for(Data d: node.data)
				outputStr.append(d.toString());

			return ;
		}

		if(q[index].equals("0"))
			searchWay( node.leftNode, q, ++index); 
		else
			searchWay( node.rightNode, q, ++index); 
	}
}
