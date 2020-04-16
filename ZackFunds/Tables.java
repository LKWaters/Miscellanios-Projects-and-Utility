import net.web.UrlUtils;
import utils.PrintUtils;

import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: lyon
 * Date: 2/26/12
 * Time: 4:49 PM
 * This is a Table container used by HTMLTableParserMulti
 */
public class Tables{
    private Vector v = new Vector();
    public Tables(){};

    /**
     *
     * @param html  raw html goes in
     * @return  and Table[] goes out
     * @throws java.io.IOException
     * @throws javax.swing.text.BadLocationException
     */
    public static Table[] getTables(String html) throws IOException, BadLocationException {
        InputStream bais = new ByteArrayInputStream(html.getBytes());
        return getTables(bais);
    }

    /**
     * This will convert all the data contained by the tables into
     * String data[][]. The array can have a ragged edge.
     * Interpreting the string is up to the programmer.
     * @param inputStream  an input stream with raw html
     * @return table[]
     * @throws javax.swing.text.BadLocationException
     * @throws java.io.IOException
     */
    public static Table[] getTables(InputStream inputStream) throws BadLocationException, IOException {
        EditorKit ek = new HTMLEditorKit();
        final TableHtmlDocument tableHtmlDocument = new TableHtmlDocument();
        tableHtmlDocument.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        ek.read(inputStream, tableHtmlDocument, 0);
        return tableHtmlDocument.getTables();
    }

    public static void testHtml2Table() throws IOException, BadLocationException {
        String html = getHtmlData();
        Table[] tables = getTables(html);
        //PrintUtils.print(tables);
        for (int i=0; i < tables.length;i++){
            System.out.println("Table#"+i);

            PrintUtils.print(tables[i].getData());
            System.out.println("----- Table ends");
        }
        System.out.println("done");
    }

    public static String getHtmlData() throws IOException {
        URL u = new URL("http://www.sec.gov/Archives/edgar/data/320351/000032035112000003/main.htm");
        return UrlUtils.getOneBigUrlString(u);
    }

    public void addTable(Table t){
        v.addElement(t);
    }
    public Table[] getTables(){
        Table t[] = new Table[v.size()];
        v.copyInto(t);
        return t;
    }

    public static void main(String[] args) throws IOException, BadLocationException {
        //File f = Futil.getReadFile("select html data");
        //String html = ReaderUtil.getFileAsOneBigString(f);
        String html = getHtmlData();
        System.out.println(html);
        Table[] tables = getTables(html);
        //PrintUtils.print(tables);
        for (int i=0; i < tables.length;i++){
            System.out.println("Table#"+i);

            PrintUtils.print(tables[i].getData());
            System.out.println("----- Table ends");
        }
        System.out.println("done");
    }
}