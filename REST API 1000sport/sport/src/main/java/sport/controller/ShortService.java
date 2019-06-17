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

import sport.dao.ShortDAO;
import sport.model.Short;

@Path("/shorts")
public class ShortService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	public Set<Short> getAllShorts() {
		return ShortDAO.getAllShorts();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Short getShort(@PathParam("id") int id) {
		return ShortDAO.getShort(id);
	}
	
	@GET
	@Path("/all/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Set <Short> getShortsByUser(@PathParam("id") int id){
		return ShortDAO.getShortsByUser(id);
		
	}
	

	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Short addShort(@FormDataParam("short.idUSer")  int idUser,@FormDataParam("short.title") String title,
			              @FormDataParam("short.brand") String brand,@FormDataParam("short.model") String model, 
			              @FormDataParam("short.chooseGender") String chooseGender,@FormDataParam("short.chooseSize") String chooseSize,
			              @FormDataParam("short.price") double price,
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
		
		return ShortDAO.addShort(idUser, title, brand, model, chooseGender, chooseSize, price, pic0, pic1, pic2, pic3);
	}
	
	@PUT
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Short updateShort(@PathParam("id") int id,@FormDataParam("short.title") String title,
            @FormDataParam("short.brand") String brand,@FormDataParam("short.model") String model, 
            @FormDataParam("short.chooseGender") String chooseGender,@FormDataParam("short.chooseSize") String chooseSize,
            @FormDataParam("short.price") double price,
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
		
		return ShortDAO.updateShort(id, title, brand, model, chooseGender, chooseSize, price, pic0, pic1, pic2, pic3);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deleteShort(@PathParam("id") int id) {
		ShortDAO.deleteShort(id);
	}

}
