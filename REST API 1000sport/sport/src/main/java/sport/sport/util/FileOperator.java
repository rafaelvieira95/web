package sport.sport.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


public class FileOperator {

	private static final String PATH ="/public_html/_img/";
	
	public synchronized static void uploadFile(InputStream pic, int id,int idUser,int pos) {
		
		try {
			
			InputStream inputStream = FileOperator.class.getClassLoader().getResourceAsStream("upload.properties");
			Properties prop = new Properties();
			prop.load(inputStream);
			String folder = prop.getProperty("folder");
			
			String filePath = folder +id+"_"+idUser+"-pic"+pos;	
	
			   saveFile(pic, filePath);
	
		    } catch (Exception e) {
			  e.printStackTrace();
		}
	}

	public synchronized static void uploadFileServer(InputStream pic,String fileName) {
		
		 try {
			 
			 InputStream inputStream = FileOperator.class.getClassLoader().getResourceAsStream("uploads.properties");
			 
	            Properties prop = new Properties();
	            prop.load(inputStream);
	            String url = prop.getProperty("url");
	            String username = prop.getProperty("username");
	            String password = prop.getProperty("password");
	 
	            FTPClient ftp = new FTPClient();
	            ftp.connect(url);
	            ftp.login(username, password);
	            System.out.println(ftp.getReplyString());
	            ftp.setFileType(FTP.BINARY_FILE_TYPE);
	            ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
	            ftp.enterLocalPassiveMode();
	     
	           
	            ftp.storeFile("/public_html/_img/" + fileName, pic);
	            System.out.println(ftp.getReplyString());
	            ftp.logout();
	            
	        } catch (Exception e) {
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
	
	
	public synchronized static void deleteFile(String path) {
	
		  try {
			  
		 InputStream inputStream = FileOperator.class.getClassLoader().getResourceAsStream("uploads.properties");
		 
         Properties prop = new Properties();
       
			prop.load(inputStream);
	
         String url = prop.getProperty("url");
         String username = prop.getProperty("username");
         String password = prop.getProperty("password");

         FTPClient ftp = new FTPClient();
         ftp.connect(url);
         ftp.login(username, password);
         ftp.deleteFile(path);
         
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
	}

	
	public synchronized static void deleteAllFilesByProduct(int id, int userId) {

		String[] photos = {PATH + id + "_" + userId + "-pic0", PATH + id + "_" + userId + "-pic1",
				           PATH + id + "_" + userId + "-pic2", PATH + id + "_" + userId + "-pic3" };

		try {
			
	     InputStream inputStream = FileOperator.class.getClassLoader().getResourceAsStream("uploads.properties");
		 
         Properties prop = new Properties();
      	
		 prop.load(inputStream);
			
         String url = prop.getProperty("url");
         String username = prop.getProperty("username");
         String password = prop.getProperty("password");

         FTPClient ftp = new FTPClient();
         ftp.connect(url);
         ftp.login(username, password);
		
         
         for (FTPFile path : ftp.listDirectories()) {
 			   ftp.deleteFile(path.getName());
 		}
         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

		
	 public synchronized static void deleteAllFilesByUser(int id) {

		String mask = "[0-9]+[0-9]*_" + id + "-pic+" + "[0|1|2|3]";
	
		 try {
			 
		     InputStream inputStream = FileOperator.class.getClassLoader().getResourceAsStream("uploads.properties");
			 
	         Properties prop = new Properties();
	      	
			
			prop.load(inputStream);
			
				
	         String url = prop.getProperty("url");
	         String username = prop.getProperty("username");
	         String password = prop.getProperty("password");
	         FTPClient ftp = new FTPClient();
	         ftp.connect(url);
	         ftp.login(username, password);
	         
	         FTPFile arr [] = ftp.listDirectories();
	         
              for(FTPFile file : arr) {
            	  
            	  if(file.getName().matches(mask))
            		  ftp.deleteFile(file.getName());
      	  
            }
	         
	         
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	 	
}
