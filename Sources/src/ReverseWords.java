import java.io.File;
import java.util.Scanner;


public class ReverseWords {

	/**
	 * @param args
	 * pass array
	 */
	public static void main(String[] args) {
			
		long start = System.currentTimeMillis();
		
		File inputFile = new File(args[0]);
		File outFile = new File(args[1]);
		
		FReadWrite inFRW = new FReadWrite(inputFile);
		FReadWrite outFRW = new FReadWrite(outFile);
		
		String outString = "";
		String read = inFRW.readFile();
		String[] reads = read.split("\n");
		
		for (int i = 0; i < reads.length; i++) {
			String string = reads[i];
			if (i>0) {
				String reversedString = reverseWord(string.split(" "));
				outString+=("Case #"+i+": "+reversedString+"\n");
			}
			
		}
		outFRW.writeToFile(outString);
		print("Done");
		long end = System.currentTimeMillis();
		print(timeTaken(start,end));
		
	}

	private static String timeTaken(long start, long end) {
		// TODO Auto-generated method stub
		String taken = "Time taken: ";
		long diff = end - start;
		taken += diff+" ms";
		return taken;
	}

	private static String reverseWord(String[] inputs) {
		String reversed = "";
		for (int i = (inputs.length-1); i >=0; i--) {
			if(i!=0)
			reversed+=(inputs[i]+" ");
			else reversed+=inputs[i];
		}
		if (reversed.equals("")) {
			reversed = "no value";
		}
		return reversed;
	}

	private static void print(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}
