import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
* Created by IntelliJ IDEA.
* User: lyon
* Date: 2/27/12
* Time: 6:27 AM
* Copyright 2012, DocJava, Inc.
*/
public class TableHtmlDocument extends HTMLDocument {
    private final StringBuffer sb1 =new StringBuffer(1000);
    final HTMLTableParserMulti htmlTableParserMulti = new HTMLTableParserMulti(sb1);
    public TableHtmlDocument() {
    }
    public Table[] getTables(){
        return htmlTableParserMulti.getTables();
    }
    public HTMLEditorKit.ParserCallback getReader(int pos) {

        return htmlTableParserMulti;
    }
}