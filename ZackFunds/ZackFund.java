
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
public class ZackFund {
    String fundSymbol;
    String fundName;
    String url;
    ArrayList<ZackHolding> zackHoldings = new ArrayList<>();
    public ZackFund(String fundSymbol) throws IOException, BadLocationException {
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
           
            
            if (symbol.equals("") || Test.isNumeric(symbol)){
            float PE = 0;
            float Growth = 0;
            float Yield = 0;
            	ZackHolding zh = new ZackHolding(symbol,numberOfShares,weight,companyName,PE,Growth,Yield);
                sb.append(zh+"\n");
                zackHoldings.add(zh);
            }
            else{
            
            URL u = new URL("https://finviz.com/screener" +".ashx?v=152&t=" + symbol + "&c=0,1,2,7,14,20");
            Table datatable = Finviz.getDataTable(u);
            float PE = Test.getPE(datatable);
            float Growth = Test.getGrowth(datatable);
            float Yield = Test.getYield(datatable);
            
            ZackHolding zh = new ZackHolding(symbol,numberOfShares,weight,companyName,PE,Growth,Yield);
            zh.setPe(PE);
            zh.setYield(Yield);
            zh.setEpsGrowth(Growth);
            sb.append(zh+"\n");
            zackHoldings.add(zh);
            }

        }
        
        return sb.toString();

    }
        
    private String getUrl(String fundSymbol) {
        return "https://www.zacks" +
        ".com/funds/mutual-fund/quote/"+fundSymbol+"/holding";
    }
    public String toString(){
        return fundSymbol+","+fundName+","+ zackHoldings;
    }

    public static void main(String[] args) throws IOException, BadLocationException, JSONException {
        ZackFund zf = new ZackFund("FSDAX");
        System.out.println(zf);
        System.out.println(zf.getZackData());
    }
}