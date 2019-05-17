package threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class FilePrnt {
private FileWriter fileWriter;
private File file;
private Semaphore sem;

public FilePrnt(String filename, Semaphore sem) {
	this.sem=sem;
	file=new File(filename);
	
	try {
		fileWriter = new FileWriter(file, true);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
//	if(!file.exists()) {
//		try {
//			file.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}



public void writeInFile(String string) {
	try {
		//System.out.println("write in file");
		fileWriter.write(string);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public synchronized void closeFilePrnt() {
	try {
		fileWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public Semaphore getSem() {
	return sem;
}



}
