package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileOperationUtil<T>{
	
	public HashMap<String, T> readinfo(String path) throws Exception{
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
		@SuppressWarnings("unchecked")
		HashMap<String, T> hashMap = (HashMap<String, T>) objectInputStream.readObject();
		objectInputStream.close();
		return hashMap;
		
	}
	
	public void writeinfo(HashMap<String, T> hashMap, String path) throws Exception {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
		objectOutputStream.writeObject(hashMap);
		objectOutputStream.close();
	}
}

