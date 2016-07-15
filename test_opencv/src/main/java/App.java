import java.util.Arrays;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfFloat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class App {

    public static void main (String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat base = Highgui.imread("/media/willian/Seagate Expansion Drive/xbi-data-07-2016/201308.13.html.7.0.resized.png"),
            target = Highgui.imread("/media/willian/Seagate Expansion Drive/xbi-data-07-2016/201308.13.html.7.1.resized.png"),
            hist_base = new Mat(), hist_target = new Mat();
        MatOfInt histSize = new MatOfInt(256, 256, 256),
                 channels = new MatOfInt(0, 1, 2);
        MatOfFloat ranges = new MatOfFloat(0.0f, 256.0f, 0.0f, 256.0f, 0.0f, 256.0f);
        Imgproc.calcHist(Arrays.asList(base), channels, new Mat(), hist_base, histSize, ranges);
        Imgproc.calcHist(Arrays.asList(target), channels, new Mat(), hist_target, histSize, ranges);
        System.out.println(Imgproc.compareHist(hist_base, hist_target, Imgproc.CV_COMP_CHISQR));
    }

}
