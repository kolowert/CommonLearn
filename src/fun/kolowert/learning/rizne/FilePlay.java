package fun.kolowert.learning.rizne;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class FilePlay {

	public static void main(String[] args) {
		String dirName = System.getProperty("user.dir");
		File dir = new File(dirName + File.separator + "resources" + File.separator + "files");
		File textFile = new File(dir, "textFile" + timeMark() + ".txt");

		System.out.println(dirName + "\n" + dir.toString());

		String textUnit1 = "text Unit to Write to File # " + System.currentTimeMillis();
		writeTextToFile(textUnit1, textFile);
		
		File byteFile = new File(dir, "byteFile" + timeMark() + ".byte");
		byte[] bytes = textUnit1.getBytes();
		writeBitesToFile(bytes, byteFile);

	}

	private static void writeTextToFile(String textUnit, File file) {
		Writer wr;
		try (OutputStream os = new FileOutputStream(file)) {
			wr = new OutputStreamWriter(os, StandardCharsets.UTF_8);
			wr.write(textUnit);
			System.out.println("textFile is writen to " + file);
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static void writeBitesToFile(byte[] bytes, File file) {
		try (OutputStream os = new FileOutputStream(file)) {
			os.write(bytes, 0, bytes.length);
			System.out.println("byteFile is writen to " + file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	private static String timeMark() {
		int t = (int) (0.0001 * (System.currentTimeMillis() - 1_600_000_000_000L));
		return "-" + t;
	}
	
}
