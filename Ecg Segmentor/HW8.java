package bio.ecg;


import java.io.File;

import futils.Futil;
import futils.ReaderUtil;
import graphics.grapher.Graph;
import math.Mat1;
import math.fourierTransforms.r2.FFT1dDouble;
import sound.scope.OscopePanel;

public class HW8 {
    // program that reads an ECG data from a file, computes its PSD, and shows the graphed ECG and its PSD
    public static void main(String args[]) throws
            InterruptedException {

        psd();

    }

    public static void psd() {
        final File
                readFile =
                Futil.getReadFile(
                        "Select the ecg.csv input file");
        double
                data
                [
                ] =
                getDataFromCsvFile(readFile);
        System.out.println("data from psd file");
        for (int i=0; i < data.length;i++){
            System.out.println(data[i]);
        }
        System.gc();
        double
                psdNotNormalized
                [
                ] =
                computePSD(data);
        OscopePanel.showFrame(data, "ECG");
        Graph.graph(psdNotNormalized,
                "f",
                "p^2",
                "PSD of ECG");
    }

    static double[] getDataFromCsvFile(File f) {
        // method to return the data from a CSV file into a double array
        String
                fileText =
                ReaderUtil.getFileAsOneBigString(f);
        String
                fileTokenized
                [
                ] =
                ReaderUtil.getTokens(fileText);
        fileText = null;
        System.gc();
        int n = fileTokenized.length;
        // since the first line of the CSV file consists of headings,
        // and in each line only one of the three values represent the voltage value,
        // the data array length must be (n-3/3)=(n/3)-1
        double data[] = new double[(n / 3) - 1];
        for (int i = 4; i < n; i += 3) {
            data[(i - 4) / 3] =
                    Double.valueOf(fileTokenized[i]);
        }
        return data;
    }

    static double[] computePSD(double data[]) {
        double truncData[] = data;
        truncData =
                Mat1.truncateToIntegralPowerOfTwo(
                        truncData);
        double
                imag
                [
                ] =
                new double[truncData.length];
        FFT1dDouble fft = new FFT1dDouble();
        fft.computeForwardFFT(truncData, imag);
        return fft.getPSDNotNormalized();
    }
}


