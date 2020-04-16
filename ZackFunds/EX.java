

import javax.swing.text.BadLocationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.json.*;
import org.apache.commons.lang3.*;

/**
 * Created by
 * lyon on 4/10/18.
 * Copyright DocJava, Inc.
 */
public class EX {
    String fundSymbol;
    String fundName;
    private float sr3=0;
    private float sr5=0;
    private float sr10=0;
    private float beta=0;
    String url  ;
    ArrayList<ZackHolding> zackHoldings = new ArrayList<>();
    static ArrayList<PEGYHoldings> PEGYhold = new ArrayList<>();
    public EX(String fundSymbol) throws IOException, BadLocationException {
        this.fundSymbol=fundSymbol;
        url =  getUrl(fundSymbol);
        System.out.println(url);
        URL u = new URL(url);

    }
    public String getZackData() throws IOException, JSONException, BadLocationException {
        StringBuffer sb = new StringBuffer();

        Document document = Jsoup.connect(url).get();
        String html = document.toString();
        String tableData = StringUtils.substringBetween(html, "document.table_data   =  ",";");

        JSONArray array = new JSONArray(tableData);
        
        
        for (int i = 0; i < array.length(); i++){
        	JSONArray a = array.getJSONArray(i);
            String link = a.getString(0);
            String symbol = StringUtils.substringBetween(link, "rel=\"","\"");
            if (symbol == null) symbol = "";
            //String asOfDate = a.getString(1);
            long numberOfShares = Long.parseLong(a.getString(2).replace(",",""));
            //String MV = a.getString(3).replace(",","");
            float weight = Float.parseFloat(StringUtils.replace(a.getString(4)," %",""));
            String companyName = a.getString(5);
            //String issue = a.getString(6);
           
            float PE = 0;
            float Growth = 0;
            float Yield = 0;
            
            if (symbol.equals("") || Test.isNumeric(symbol)){            	
            }
            else{
            
            URL u = new URL("https://finviz.com/screener" +".ashx?v=152&t=" + symbol + "&c=0,1,2,7,14,20");
            Table datatable = Finviz.getDataTable(u);
            PE = Test.getPE(datatable);
            Growth = Test.getGrowth(datatable);
            Yield = Test.getYield(datatable);
   
            }
            ZackHolding zh = new ZackHolding(symbol,numberOfShares,weight,companyName,PE,Growth,Yield);
            zh.setPe(PE);
            zh.setYield(Yield);
            zh.setEpsGrowth(Growth);
            
            //finds the weight of share based on number of shares compared to total number of shares
            float ratio = (float) numberOfShares/shares();
            
            // finds weighted pegy and rounds it to 2 decimal places
            float pegy = ((float) Math.round((zh.getPe()*ratio)*100/(zh.getEpsGrowth()*ratio+zh.getYield()*ratio)))/100;
            String name = zh.getCompanyName();
          
            // finds sr3,5,10 and rounds to 2 decimal place
            float srthree = ((float) Math.round(sr3*ratio*100))/100;
            float srfive = ((float) Math.round(sr5*ratio*100))/100;
            float srten = ((float) Math.round(sr10*ratio*100))/100;
            
            float beta1 = 0;
            if (symbol.equals("") || Test.isNumeric(symbol)){
            }
            else{
            	beta1 = betaFinder(symbol);
            }
            
            
            PEGYHoldings peg = new PEGYHoldings(pegy, name, srthree, srfive, srten, beta1);
            sb.append(peg+"\n");
            PEGYhold.add(peg);
            
        }
        
        return sb.toString();
    }
    
    public long shares() throws IOException, JSONException{
    	 Document document = Jsoup.connect(url).get();
    	 String html = document.toString();
         String tableData = StringUtils.substringBetween(html, "document.table_data   =  ",";");

         JSONArray array = new JSONArray(tableData);
         
         long total = 0;
         
    	for (int i = 0; i < array.length(); i++){
    		JSONArray a = array.getJSONArray(i);
    		long numberOfShares = Long.parseLong(a.getString(2).replace(",",""));
    		
    		total = total + numberOfShares;
    	}
    	return total;
    }

    private String getUrl(String fundSymbol) {
        return "https://www.zacks" +
        ".com/funds/mutual-fund/quote/"+fundSymbol+"/holding";
    }
    public String toString(){
        return fundSymbol+","+fundName+","+ zackHoldings+","+beta+","+sr3+","+sr5+","+sr10;
    }


    public float getSr3() {
        return sr3;
    }

    public void setSr3(float sr3) {
        this.sr3 = sr3;
    }

    public float getSr5() {
        return sr5;
    }

    public void setSr5(float sr5) {
        this.sr5 = sr5;
    }

    public float getSr10() {
        return sr10;
    }

    public void setSr10(float sr10) {
        this.sr10 = sr10;
    }

    public float getBeta() {
        return beta;
    }

    public void setBeta(float beta) {
        this.beta = beta;
    }
    private void populateProfile() throws IOException, BadLocationException {
        /*

        has the profile
         */
        URL url = new URL("https://www.zacks.com/funds/mutual-fund/quote/" +
                fundSymbol);
        System.out.println(url);
        Table[] ta= Finviz.getTables(url);
        String data[][]=ta[5].getData();
        
        
        //ta[5].endTable();
        if (data == null) {
            //cppsj
            //System.out.println("null");
            return;
        } 
        else{
            for (int r = 0; r < data.length; r++) {
                for (int c = 0; c < data[r].length; c++) {
                    //System.out.print(" r,c="+r+","+c +"="+ data[r][c] + ")");
                }
                //System.out.println("");
            }
        beta = Float.parseFloat(data[1][1]);
        //System.out.println("beta="+ beta);
        sr3 = Float.parseFloat(data[5][1]);
        sr5 = Float.parseFloat(data[5][2]);
        sr10 = Float.parseFloat(data[5][3]);
        //System.out.println("s3,sr5,sr10="+ sr3 +','+sr5+','+sr10);
        //System.out.println(ta[5]);

        //System.out.println("beta="+data[0][1]);
        }

    }
        public float betaFinder(String symb) throws IOException, BadLocationException{
        	/*

            has the profile
             */
        	URL u = new URL("https://finviz.com/screener" +".ashx?v=152&t=" + symb + "&c=2,48");
            Table datatable = Finviz.getDataTable(u);

            String total = datatable.toString();
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
    				if(Test.isNumeric(ans.substring(1, ans.length()-1))){
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
            
           
    public static void main(String[] args) throws IOException, BadLocationException, JSONException {
        EX zf = new EX("FSDAX");

        zf.populateProfile();
        	
        System.out.println(zf);
        System.out.println(zf.getZackData());
        //System.out.println(PEGYhold);
        


    }
}
