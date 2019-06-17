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


import sport.dao.*;
import sport.model.*;

@Path("/shirts")
public class ShirtService {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Set<Shirt> getAllShirts() {
		return ShirtDAO.getAllShirts();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Shirt getShirt(@PathParam("id") int id){
		return ShirtDAO.getShirt(id);
		
	}
	
	@GET
	@Path("/all/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Set <Shirt> getShirtsByUser(@PathParam("id") int id){
		return ShirtDAO.getShirtsByUser(id);
		
	}
	

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Shirt addUser(@FormDataParam("shirt.idUser") int idUser, @FormDataParam("shirt.title") String title,
			             @FormDataParam("shirt.brand") String brand,@FormDataParam("shirt.club") String club,
			             @FormDataParam("shirt.season") String season, @FormDataParam("shirt.version") String version,
			             @FormDataParam("shirt.occasion") String occasion,@FormDataParam("shirt.gk") boolean gk,
			             @FormDataParam("shirt.price") double price,
			             @FormDataParam("pic0") InputStream pic0, @FormDataParam("pic1") InputStream pic1,
			             @FormDataParam("pic2") InputStream pic2, @FormDataParam("pic3") InputStream pic3,
			             @FormDataParam("pic0") FormDataContentDisposition pic0input,
			             @FormDataParam("pic1") FormDataContentDisposition pic1input,
			             @FormDataParam("pic2") FormDataContentDisposition pic2input,
			             @FormDataParam("pic3") FormDataContentDisposition pic3input){
		
	         if(pic0input.getFileName() == null) pic0 = null;
	         if(pic1input.getFileName() == null) pic1 = null;
	         if(pic2input.getFileName() == null) pic2 = null;
	         if(pic3input.getFileName() == null) pic3 = null;
	         
	   return ShirtDAO.addShirt(idUser, title, brand, club, season, version, occasion, gk,price,pic0,pic1,pic2,pic3);
	}
	
	
	@PUT
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Shirt updateShirt(@PathParam("id") int id, @FormDataParam("shirt.title") String title,
            @FormDataParam("shirt.brand") String brand,@FormDataParam("shirt.club") String club,
            @FormDataParam("shirt.season") String season, @FormDataParam("shirt.version") String version,
            @FormDataParam("shirt.occasion") String occasion,@FormDataParam("shirt.gk") boolean gk,
            @FormDataParam("shirt.price") double price,
            @FormDataParam("pic0") InputStream pic0, @FormDataParam("pic1") InputStream pic1,
            @FormDataParam("pic2") InputStream pic2, @FormDataParam("pic3") InputStream pic3,
            @FormDataParam("pic0") FormDataContentDisposition pic0input,
            @FormDataParam("pic1") FormDataContentDisposition pic1input,
            @FormDataParam("pic2") FormDataContentDisposition pic2input,
            @FormDataParam("pic3") FormDataContentDisposition pic3input) {
		
		  if(pic0input.getFileName() == null) pic0 = null;
	      if(pic1input.getFileName() == null) pic1 = null;
	      if(pic2input.getFileName() == null) pic2 = null;
	      if(pic3input.getFileName() == null) pic3 = null;
		
		return ShirtDAO.updateShirt(id, title, brand, club, season, version, occasion, gk, price,pic0,pic1,pic2,pic3);
	}

	

	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deleteShirt(@PathParam("id") int id){
		ShirtDAO.deleteShirt(id);
	}
	
	

}
