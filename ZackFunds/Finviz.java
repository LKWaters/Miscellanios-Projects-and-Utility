
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
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by
 * lyon on 4/17/18.
 * Copyright DocJava, Inc.
 */

public class Finviz {


     public static Table getDataTable(URL u)
            throws IOException, BadLocationException {
        Table[] tables = getTables(u);
        return tables[9];
    }

    public static Table[] getTables(URL u)
            throws IOException, BadLocationException {
        InputStream bais = new ByteArrayInputStream(
                getOneBigString(u).getBytes());
        EditorKit ek = new HTMLEditorKit();
        final TableHtmlDocument
                tableHtmlDocument
                = getTableHtmlDocument();
        ek.read(bais, tableHtmlDocument, 0);
        return tableHtmlDocument.getTables();
    }
    static class TableHtmlDocument extends HTMLDocument {
        private final StringBuffer sb1 =new StringBuffer(1000);
        final HTMLTableParserMulti
                htmlTableParserMulti = new HTMLTableParserMulti(sb1);
        public TableHtmlDocument() {
        }
        public Table[] getTables(){
            return htmlTableParserMulti.getTables();
        }
        public HTMLEditorKit.ParserCallback getReader(int pos) {

            return htmlTableParserMulti;
        }
    }
    public static TableHtmlDocument getTableHtmlDocument() {
        final TableHtmlDocument tableHtmlDocument = new TableHtmlDocument();
        tableHtmlDocument.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        return tableHtmlDocument;
    }

    private static String getOneBigString(URL u) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                u.openStream()));
        Vector v1 = new Vector();
        String line;
        while (null != (line = br.readLine()))
            v1.addElement(line);

        String s[] = new String[v1.size()];
        v1.copyInto(s);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length; i++)
            sb.append(s[i] + '\n');
        return sb.toString();
    }


    private static void printData(String tick1)
            throws IOException, BadLocationException {
        URL u = new URL("https://finviz.com/screener" +
                ".ashx?v=152&t=" + tick1 + "&c=0,1,2,7,14,20");
        //https://finviz.com/screener.ashx?v=152&t=BLK,CBOE,MS,SPGI,SCHW,AMTD,STT,IVZ,EV,AMG,LPLA,APO,BGCP,LM,BK,ICE,SF,HLI,PJT,MCO,MSCI,CNS,LAZ,BX,MKTX,WETF,MC&c=0,1,2,7,14,20
        System.out.println(u);
        Table dataTable = getDataTable(u);
        System.out.println(dataTable);
    }
    public static void main(String[] args)
            throws IOException, BadLocationException, JSONException {
        ZackFund zf = new ZackFund("FSDAX");
        zf.getZackData();
        //System.out.println(());
        populate(zf.zackHoldings);

    }

    private static void test() throws IOException, BadLocationException {
        String tick1 = "BLK,CBOE,MS,SPGI,SCHW,AMTD,STT,IVZ,EV,AMG," +
                "LPLA,APO,BGCP,LM," +
                "BK,ICE,SF,HLI,PJT,MCO" ;
        String tick2 = "MSCI,CNS,LAZ,BX,MKTX," +
                "WETF,MC";
        printData(tick1);
        printData(tick2);
    }

    static void populate(ArrayList<ZackHolding> zackHoldings) throws IOException, BadLocationException {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < zackHoldings.size(); i++){
            sb.append(zackHoldings.get(i).getSymbol()+",");
            if (i%20==0){
                String tick1 = sb.toString();
                System.out.println(tick1);
                printData(tick1);
                sb=new StringBuffer();
            }
        }
    }
}