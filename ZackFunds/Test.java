import java.io.IOException;

import javax.swing.text.BadLocationException;

import org.json.JSONException;


import org.json.JSONException;

import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

public class Test {

	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	
	public static float getPE(Table u){
		String total = u.toString();
		String lines[] = total.split("\\r?\\n");
		String[] parts = lines[2].split(" ", 20);
		
		int x  = 0;
		int y = 2;
		float last = 0;
		
		if (lines[2].equals("----- Table ends")){
		last = 0;
		}
		
			else{
		
		while(!(x==1) || y>20 ){
			String ans = parts[y];
			if(ans.length() > 2){
				y++;
				if(isNumeric(ans.substring(1, ans.length()-1))){
					last = Float.parseFloat(ans.substring(1,ans.length()-1));
					x++;
					}
			
				else if (ans.substring(1,2).equals("-")){
					x++;
					last = 0;
				}
			}
			else{
				y++;
			}
		}
			}
		return last;
			
	}
	
	public static float getGrowth(Table u){
		String total = u.toString();
		String lines[] = total.split("\\r?\\n");
		String[] parts = lines[2].split(" ", 20);
		int x  = 0;
		int y = 2;
		float last = 0;
		
		if (lines[2].equals("----- Table ends")){
			last = 0;
			}
			
				else{
		while(!(x==2) || y>20 ){
			String ans = parts[y];
			if(ans.length() > 2){
				y++;
				if(isNumeric(ans.substring(1, ans.length()-2))){
					x++;
					last = Float.parseFloat(ans.substring(1,ans.length()-2));
					}
			
				else if (ans.substring(1,2).equals("-")){
					last = 0;
					x++;
				}
			}
			else{
				y++;
			}
		}
				}
		return last;
	}
	
	public static float getYield(Table u){
		String total = u.toString();
		String lines[] = total.split("\\r?\\n");
		String[] parts = lines[2].split(" ", 20);
		int x  = 0;
		int y = 2;
		float last = 0;
		
		if (lines[2].equals("----- Table ends")){
			last = 0;
			}
			
				else{
		
		while(!(x==3) || y>20 ){
			String ans = parts[y];
			
			if(ans.length() > 1){
				y++;
				if(isNumeric(ans.substring(1, ans.length()-2))){
					x++;
					last = Float.parseFloat(ans.substring(1,ans.length()-2));
					}
				
				else if (ans.substring(1,2).equals("-")){
					x++;
					last = 0;
				}
			
			}
			else{
				y++;
			}
		}
				}
		return last;
	}
	
	
	public static void main(String[] args) throws IOException, BadLocationException{

		URL u = new URL("https://finviz.com/screener" +".ashx?v=152&t=" + "TXT" + "&c=0,1,2,7,14,20");
        Table datatable = Finviz.getDataTable(u);
        float PE = Test.getPE(datatable);
        float Growth = Test.getGrowth(datatable);
        float Yield = Test.getYield(datatable);
        System.out.println(PE+" "+Growth+" "+Yield);
	}
	
	
}