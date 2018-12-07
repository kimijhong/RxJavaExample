package comm;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;
import java.util.stream.IntStream;

public class CommUtil {
	
public static final String GITHUB_ROOT = "https://raw.githubusercontent.com/yudong80/reactivejava/master/";
	
	public static final String API_KEY =  
			"5712cae3137a8f6bcbebe4fb35dfb434";
//	"e7681f2ac93cbdf1bc3952e30ab80533"; 
//	"fe6edeb30e2b9ee7848e4ded0491d8d1";
			
	public static final String ERROR_CODE = "-500";
	
	public static long startTime;

	public static void exampleStart() {
		startTime = System.currentTimeMillis();
	}
	
	public static void exampleStart(Object obj) {
		startTime = System.currentTimeMillis();
		Log.it(obj);
	}

	public static void sleep(int mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void exampleComplete() { 
		System.out.println("-----------------------");
	}
	

	public static String getShape(String obj) {
		if (obj == null || obj.equals(""))
			return "NO-SHAPE";
		if (obj.endsWith("-H"))
			return "H";
		if (obj.endsWith("-O"))
			return "O";
		if (obj.endsWith("-R"))
			return "R";
		if (obj.endsWith("-T"))
			return "T";
		if (obj.endsWith("-<>"))
			return "<>";

		return "BALL";

	}

	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String numberToAlphabet(long x) {
		return Character.toString(ALPHABET.charAt((int) x % ALPHABET.length()));
	}

	public static boolean isNetworkAvailable() {
		try {
			return InetAddress.getByName("www.google.com").isReachable(1000);
		} catch (IOException e) {
			Log.v("Network is not available");
		}
		return false;
	}

	public static int toInt(String val) {
		return Integer.parseInt(val);
	}
	
	
	
	

	public static void doSomething() { 
		try { 
			Thread.sleep(new Random().nextInt(100));
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}		
	}
	

	public static Integer[] toIntegerArray(int[] intArray) {
		return IntStream.of(intArray).boxed().toArray(Integer[]::new);
	}
	

}
