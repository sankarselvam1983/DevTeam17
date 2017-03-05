package gui;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import static org.opencv.imgproc.Imgproc.rectangle;
import org.opencv.objdetect.CascadeClassifier;

class DetectFace {
	public void run() {
		System.out.println("\nRunning DetectFaceDemo");
		// Create a face detector from the cascade file in the resources
		// directory.
		CascadeClassifier faceDetector = new CascadeClassifier(
				"C:\\opencv\\sources\\data\\lbpcascades\\lbpcascade_frontalface.xml");
		Mat image = imread("C:\\Users\\akila\\Desktop\\gp_image1.jpg");
		// Detect faces in the image.
		// MatOfRect is a special container class for Rect.
		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(image, faceDetections);
		System.out.println(String.format("Detected %s faces",
				faceDetections.toArray().length));
		// Draw a bounding box around each face.
		for (Rect rect : faceDetections.toArray()) {
			rectangle(image, new Point(rect.x, rect.y), new Point(rect.x
					+ rect.width, rect.y + rect.height), new Scalar(0, 255, 0),
					3);
		}
		// Save the visualized detection.
		String filename = "faceDetection.png";
		System.out.println(String.format("Writing %s", filename));
		imwrite(filename, image);
	}
}

public class DetectPhotoFace {
	public static void main(String[] args) {
		System.out.println("Detect Photo Faces");
		System.load("C:\\opencv\\build\\java\\x64\\opencv_java320.dll");
		new DetectFace().run();
	}
}