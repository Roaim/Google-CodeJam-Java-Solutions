
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FReadWrite {
	
	private File mFile;
	//private List mList;

	public FReadWrite(File file){
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.mFile = file;
	}
/*	
	public List getList(){
		if (mList==null) {
			readFile();
		}
		return mList;
	}
*/	
	public void writeToFile(String input) {
		FileOutputStream foStream;
		try {
			foStream = new FileOutputStream(mFile);
			foStream.write(input.getBytes());
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

	public String readFile(){
		StringBuilder result = new StringBuilder();
		FileInputStream fis;
		try {
			//mList = new ArrayList();
			fis = new FileInputStream(mFile);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			while ((line=bufferedReader.readLine())!=null) {
				result.append(line);
				result.append("\n");
				//mList.add(line);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();	
	}
}
