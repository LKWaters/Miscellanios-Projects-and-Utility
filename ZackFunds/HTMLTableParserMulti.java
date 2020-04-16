
import futils.WriterUtil;
import utils.StringUtils;

import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;

public class HTMLTableParserMulti extends HTMLEditorKit.ParserCallback {
    private StringBuffer sb;

    private Tables tabs = new Tables();

    private Table tab = new Table();
    private MutableAttributeSet a;

    public String getString(){
        return sb.toString();
    }

    public HTMLTableParserMulti(StringBuffer buf) {
        this.sb = buf;

    }
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos){
        super.handleStartTag(t,a,pos);
    }
    public void handleEndTag(HTML.Tag t,  int pos) {
        //System.out.println(t+":"+pos);
        if (t.equals(HTML.Tag.TABLE))  {
            tab.endTable();
            tabs.addTable(tab);
            tab = new Table();
            sb = new StringBuffer(1000);
        }
        if (t.equals(HTML.Tag.TR)){
            tab.endRow();
            sb = new StringBuffer(1000);
        }
        if (t.equals(HTML.Tag.TD)) {
            tab.addTableData(sb.toString());
            sb = new StringBuffer(1000);

        }

    }
    public Table[] getTables(){
        return tabs.getTables();
    }



    // some numbers have commas already, so remove them.
    public void handleText(char[] data, int pos) {
        sb.append(new String(data).replaceAll(",", ""));
    }


    public static Table[] getTables(InputStream inputStream) throws
                                                        IOException, BadLocationException {
        BufferedReader br = new BufferedReader(new
                InputStreamReader(inputStream));
        Vector v1 = new Vector();
        String line;
        while (null != (line = br.readLine()))
            v1.addElement(line);

        String s[] = new String[v1.size()];
        v1.copyInto(s);
        String html = StringUtils.getOneBigString(s);
        return Tables.getTables(html);
    }
    public static Table getSicCodes()
            throws IOException, BadLocationException {
        String s2 = "https://www.sec.gov/info/edgar/siccodes.htm";
        URL u = new URL(s2);
        final InputStream inputStream = u.openStream();
        Table[] tables = getTables(inputStream);
        return tables[2];
    }

    private static void printTables(InputStream inputStream)
            throws IOException, BadLocationException {
        Table[] tables = getTables(inputStream);
        //PrintUtils.print(tables);
        StringBuffer sb = new StringBuffer();
        if (Table.getString(tables, sb)) return;
        System.out.println(sb);

        // WriterUtil.writeString(Futil.getWriteFile("select an output .txt"),sb.toString());
        System.out.println("done");
    }


    private static void test1()
            throws IOException, BadLocationException {
        //File f = new File("C:\\lyon\\Main.html");
        String s1 = "http://www.docjava.com/comput_1/table.htm";
        String su= "http://etfdb.com/issuer/vanguard/";


        String s2 = "https://www.sec.gov/info/edgar/siccodes.htm";
        URL u = new URL(s2);
        final InputStream inputStream = u.openStream();

        //FileInputStream inputStream = new FileInputStream(f);
        printTables(inputStream);
    }
    public static void main(String[] args) throws IOException, BadLocationException {
        Table t = getSicCodes();
        String csv = t.getCsv();
        System.out.println(csv);
        File f = new File("/home/lyon/attachments/foo.csv");
        WriterUtil.writeString(f,csv);
    }
}