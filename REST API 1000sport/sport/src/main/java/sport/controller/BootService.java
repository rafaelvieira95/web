package sport.controller;

import java.io.InputStream;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import sport.dao.BootDAO;
import sport.model.Boot;

@Path("/boots")
public class BootService {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Set<Boot> getAllBoots(){
		return BootDAO.getAllBoots();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Boot getBoot(@PathParam("id") int id) {
		return BootDAO.getBoot(id);
	}
	
	@GET
	@Path("/all/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Set <Boot> getBootsByUser(@PathParam("id") int id){
		return BootDAO.getBootsByUser(id);
		
	}
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Boot addBoot(@FormDataParam("boot.idUser") int idUser,@FormDataParam("boot.title") String title,@FormDataParam("boot.brand") String brand,
			@FormDataParam("boot.model") String model,@FormDataParam("boot.bootsGender") String bootsGender,@FormDataParam("boot.bootSize") int bootSize,
			@FormDataParam("boot.version") String version,@FormDataParam("boot.field") boolean field,@FormDataParam("boot.price") double price,
			@FormDataParam("pic0") InputStream pic0,@FormDataParam("pic1") InputStream pic1,
			@FormDataParam("pic2") InputStream pic2,@FormDataParam("pic3") InputStream pic3,
			@FormDataParam("pic0") FormDataContentDisposition pic0input,
	        @FormDataParam("pic1") FormDataContentDisposition pic1input,
	        @FormDataParam("pic2") FormDataContentDisposition pic2input,
	        @FormDataParam("pic3") FormDataContentDisposition pic3input) {
		 
		  if(pic0input.getFileName() == null) pic0 = null;
	      if(pic1input.getFileName() == null) pic1 = null;
	      if(pic2input.getFileName() == null) pic2 = null;
	      if(pic3input.getFileName() == null) pic3 = null;
		
		return BootDAO.addBoot(idUser, title, brand, model, bootsGender, bootSize, version, field, price, pic0, pic1, pic2, pic3);
	}
	
	@PUT
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Boot updateBoot(@PathParam("id") int id,@FormDataParam("boot.title") String title,@FormDataParam("boot.brand") String brand,
			@FormDataParam("boot.model") String model,@FormDataParam("boot.bootsGender") String bootsGender,@FormDataParam("boot.bootSize") int bootSize,
			@FormDataParam("boot.version") String version,@FormDataParam("boot.field") boolean field,@FormDataParam("boot.price") double price,
			@FormDataParam("pic0") InputStream pic0,@FormDataParam("pic1") InputStream pic1,
			@FormDataParam("pic2") InputStream pic2,@FormDataParam("pic3") InputStream pic3,
			@FormDataParam("pic0") FormDataContentDisposition pic0input,
	        @FormDataParam("pic1") FormDataContentDisposition pic1input,
	        @FormDataParam("pic2") FormDataContentDisposition pic2input,
	        @FormDataParam("pic3") FormDataContentDisposition pic3input) {
		
		  if(pic0input.getFileName() == null) pic0 = null;
	      if(pic1input.getFileName() == null) pic1 = null;
	      if(pic2input.getFileName() == null) pic2 = null;
	      if(pic3input.getFileName() == null) pic3 = null;
		
		return BootDAO.updateBoot(id, title, brand, model, bootsGender, bootSize, version, field, price, pic0, pic1, pic2, pic3);
	}
	

	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deleteBoot(@PathParam("id") int id) {
		BootDAO.deleteBoot(id);
	}
	
}
