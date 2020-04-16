package bio.ecg;

import futils.ReaderUtil;
import sound.DoubleAudio;
import sound.scope.OscopePanel;
import sound.ulaw.UlawCodec;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: lyon
 * Date: 10/21/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class EkgReader {
    public static void main(String[] args)
            throws FileNotFoundException {
        //File f = Futil.getReadFile("select ecg file");
        //System.out.println(f);
        File f = new File("C:\\lyon\\j4p\\data\\ecg.csv");
        String s[] = ReaderUtil.getFileAsStringArray(f);
        //PrintUtils.println(s);
        double d[] = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            double v = Double.parseDouble(s[i]);
            d[i] = v;
        }

        DoubleAudio da = new DoubleAudio(d);
        da.normalize();

        System.out.println("max=" + da.getMax());
        System.out.println("min=" + da.getMin());
        double id[] = new double[80000];
        double od[] = da.getData();
        int idx = 0;
        out:
        for (int i = 0; i < id.length; i++) {
            for (int k = 0; k < 30; k++) {
                id[idx] = od[i];
                idx++;
                if (idx >= id.length) break out;
            }
        }
        OscopePanel.showFrame(id);
        UlawCodec ulc = new UlawCodec(id);
        ulc.play();
    }
}
