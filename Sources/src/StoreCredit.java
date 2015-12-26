import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class StoreCredit {
/*
	private static final String PATH = "G:\\ACM_ICPC\\CodeJam\\StoreCredit";
	private static final String SMALL = "A-small-practice.in";
	private static final String LARGE = "A-large-practice.in";
*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		/*
		File inFileSmall = new File(PATH,SMALL);
		File inFileLarge = new File(PATH,LARGE);
		File outFileSmall = new File(PATH,"Out-"+SMALL);
		File outFileLarge = new File(PATH,"Out-"+LARGE);
		*/
			File inFileSmall = new File("/storage/sdcard0/AppProjects/CodeJam/StoreCredit/A-small-practice.in");
			File outFileSmall = new File("/storage/sdcard0/AppProjects/CodeJam/StoreCredit/Out-A-small-practice.in");
			generateOutput ( inFileSmall, outFileSmall );
			File inFileLarge = new File("/storage/sdcard0/AppProjects/CodeJam/StoreCredit/A-large-practice.in");
			File outFileLarge = new File("/storage/sdcard0/AppProjects/CodeJam/StoreCredit/Out-A-large-practice.in");
			generateOutput ( inFileLarge, outFileLarge );
			long end = System.currentTimeMillis ( );
		print(timeTaken(start, end));
	}
	
	private static void generateOutput(File inFile, File outFile) {
		// TODO Auto-generated method stub
		FileInputStream fiStream;
		FileOutputStream foStream;
		StringBuilder outBuilder = new StringBuilder();
		try {
			foStream = new FileOutputStream(outFile);
			fiStream = new FileInputStream(inFile);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(fiStream));
			String line = null;
			int loop=0;
			int caseCount=0;
			int credit = 0;
			while((line=bReader.readLine())!=null){
					if(loop==0){
							caseCount=Integer.parseInt(line);
							System.out.println("No of case: "+caseCount);
					} else{
							if(loop%3==1){
									credit = Integer.parseInt(line);
									System.out.println("Credit : "+credit);
							} else if(loop%3==2){
									int itemCount = Integer.parseInt(line);
									System.out.println("Item count: "+itemCount);
							} else{
									
									String item = line;
									String[] items = item.split(" ");
									System.out.println("Items length: "+items.length+" items: "+item);
									boolean stop=false;
									//System.out.println("#"+credit);
									for(int i=0;i<items.length;i++){
											if(stop) break;
											int a = Integer.parseInt(items[i]);
											for(int j=0;j<items.length;j++){
													if(i!=j){
													int b = Integer.parseInt(items[j]);
													if(((a+b)==credit)){
															String out = "Case #"+(loop/3)+": "+(i+1)+" "+(j+1);
															System.out.println(out);
															stop=true;
															outBuilder.append(out);
															outBuilder.append("\n");
													}
													}
											}
									}
							}
					}
					loop++;
			}
			String outString = outBuilder.toString();
			//outString = outString.substring(0,(outString.length()-2));
			foStream.write(outString.getBytes());
			fiStream.close();
			foStream.flush();
			foStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static String timeTaken(long start, long end) {
		// TODO Auto-generated method stub
		String taken = "Time taken: ";
		long diff = end - start;
		taken += diff+" ms";
		return taken;
	}
	
	private static void print(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
	
}
