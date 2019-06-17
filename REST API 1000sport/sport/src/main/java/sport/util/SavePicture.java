package sport.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import sport.connection.DatabaseFactory;

public class SavePicture {

	public synchronized static void uploadFile(InputStream pic, int id,int idUser,int pos) {
		
		try {
			
			InputStream inputStream = DatabaseFactory.class.getClassLoader().getResourceAsStream("upload.properties");
			
			Properties prop = new Properties();
			prop.load(inputStream);
			String folder = prop.getProperty("folder");
			
			String filePath = folder +id+"_"+idUser+"-pic"+pos;	
	
			   saveFile(pic, filePath);
	
		    } catch (Exception e) {
			  e.printStackTrace();
		}
	}

	private synchronized static void saveFile(InputStream uploadedInputStream, String serverLocation) {

		try {
			
			OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			outpuStream = new FileOutputStream(new File(serverLocation));
			
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			   }
		
			outpuStream.flush();
			outpuStream.close();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
}
