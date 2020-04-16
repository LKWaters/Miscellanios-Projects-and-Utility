import finance.bond.GetCsvData;

import java.util.Vector;

public class Table {
    private String data[][];
    private Vector rowVector = new Vector();
    private Vector stringVector = new Vector();

    public Table(){

    }

    public static boolean getString(Table[] tables, StringBuffer sb) {
        for (int i=0; i < tables.length;i++){
            sb.append("Table#"+i);

            String[][] strings = tables[i].getData();
            if (strings==null){
                System.out.println("null");
                return true;
            } else
                for (int r=0; r<strings.length; r++) {
                    for (int c=0; c<strings[r].length; c++) {
                        final String s = (strings[r][c].replace("(", "")).replace(")", "");
                        sb.append(" (" +s+")");
                    }
                    sb.append("\n");
                }
            sb.append("----- Table ends");
        }
        return false;
    }

    public String[][] getData(){
        return data;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        String[][] strings = getData();
        if (strings==null){
            System.out.println("null");
            return "";
        } else
            for (int r=0; r<strings.length; r++) {
                for (int c=0; c<strings[r].length; c++) {
                    final String s = (strings[r][c].replace("(", "")).replace(")", "");
                    sb.append(" (" +s+")");
                }
                sb.append("\n");
            }
        sb.append("----- Table ends");
        return sb.toString();
    }
    public void addTableData(String s){
        stringVector.addElement(s);
    }
    public void endRow(){
        rowVector.addElement(stringVector);
       
        stringVector = new Vector();
    }

    /**
     * Always call endTable when you are done or your strings
     * will be null. <b>This is important!</b>
     */
    public void endTable(){
        int rows = rowVector.size();
        data = new String[rows][];
        for (int r=0; r < rows; r++){
            Vector v = (Vector)rowVector.elementAt(r);
            final int cols = v.size();
            data[r] = new String[cols];
            for (int c=0; c< cols;c++){
                data[r][c]=v.elementAt(c).toString();
            }
        }
    }

    public static void main(String[] args) {
        Table t = new Table();
        //make 10 rows of random width
        for (int i=0; i < 10; i++){
            for (int j=0; j < Math.random()*500;j++){
                t.addTableData("-");
            }
            t.endRow();
        }
        t.endTable();
        String[][] tri = t.getData();
        for (int r=0; r< tri.length; r++) {
            for (int c=0; c< tri[r].length; c++) {
                System.out.print( tri[r][c]);
            }
            System.out.println("");
        }
    }

    public String getCsv(){
        return GetCsvData.getCsv(getData());
    }

}