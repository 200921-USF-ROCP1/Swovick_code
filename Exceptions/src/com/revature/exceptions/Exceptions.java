package com.revature.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions {
	public void checkedExceptionTryCatch() {
		FileReader fr = null;
		try {
			fr = new FileReader("");
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		finally {
			//fr.close();
		}
	}
	public void checkedExceptionThrows() throws FileNotFoundException{
		FileReader fr = new FileReader("file.txt");
	}
	public void moreTryCatch() {
		try {
			FileReader fr = new FileReader("file.txt");
			fr.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//could also use inheritance property of Exception
		//to catch all exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	// We can also throw exceptions
		public void throwAnException(int i) throws Exception {
			if (i > 10) {
				throw new Exception("i is too big.");
			}
		}
}