
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;public class T9Spelling       
{
		private static final String cAlpha="abcdefghijklmnopqrstuvwxyz ";
		private static final String cKeys="2#22#222#3#33#333#4#44#444#5#55#555#6#66#666#7#77#777#7777#8#88#888#9#99#999#9999#0";
		
		public static void main(String... arg){
				long start=System.currentTimeMillis();
				File inSmallFile=new File("/storage/sdcard0/AppProjects/CodeJam/T9 Spelling/C-small-practice.in"),
				outSmallFile=new File("/storage/sdcard0/AppProjects/CodeJam/T9 Spelling/C-small-practice.out"),
				inLargeFile= new File("/storage/sdcard0/AppProjects/CodeJam/T9 Spelling/C-large-practice.in"),
				outLargeFile=new File("/storage/sdcard0/AppProjects/CodeJam/T9 Spelling/C-large-practice.out");
				generateOutput(inSmallFile,outSmallFile);
				generateOutput(inLargeFile,outLargeFile);
				long end = System.currentTimeMillis();
				print(timeTaken(start,end));
		}

		private static void generateOutput ( File inFile, File outFile ) {
				// TODO: Implement this method
				String[] keys = cKeys.split("#");
				String out = "";
				String outResult="";
				FileInputStream fis;
				FileOutputStream fos;
				try {
						fis = new FileInputStream ( inFile );
						fos= new FileOutputStream(outFile);
						
						BufferedReader br = new BufferedReader(new InputStreamReader(fis));
						String line = null;
						int loop=0;
						int noCase=0;
						while((line=br.readLine())!=null){
								
								if(loop==0){
										noCase=Integer.parseInt(line);
										//print("No of case: "+noCase);
								} else{
										String input = line;
										//System.out.println(input);
										//int max = input.length()>15?15:input.length();
										for(int i = 0;i<input.length();i++){
												char c = input.charAt(i);
												//System.out.println(c);
												int index = cAlpha.indexOf(c);
												//System.out.println(index);
												if(i>0){
														char prv = input.charAt((i-1));
														int pIndex = cAlpha.indexOf(prv);
														if((index/3)==(pIndex/3)){
																out+=" ";
														}
												} 
												out+=keys[index];
										}
										//print("Case #"+loop+": "+out);
										String res = "Case #"+loop+": "+out+"\n";
										outResult+=res;
										out="";
								}
								
								loop++;
								
						}
						print(outResult);
						fos.write(outResult.getBytes());
						fis.close();
						fos.flush();
						fos.close();
				} catch (Exception e) {
						print(e.toString());
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
