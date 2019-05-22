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

import sport.dao.BallDAO;
import sport.model.Ball;

@Path("/balls")
public class BallService {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Set<Ball> getAllBalls() {
		 return BallDAO.getAllBalls();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Ball getShort(@PathParam("id") int id) {
		return BallDAO.getBall(id);
	}
	
	@GET
	@Path("/all/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Set <Ball> getBallsByUser(@PathParam("id") int id){
		return BallDAO.getBallsByUser(id);
		
	}
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Ball addBall(@FormDataParam("ball.idUser") int idUser,@FormDataParam("ball.title") String title,
			@FormDataParam("ball.brand")String brand,@FormDataParam("ball.model") String model,@FormDataParam("ball.year") String year,
			@FormDataParam("ball.field") boolean field,@FormDataParam("ball.price") double price,
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
		
		return BallDAO.addBall(idUser, title, brand, model, year, field, price, pic0, pic1, pic2, pic3);
	}
	
	
	@PUT
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Ball updateBall(@PathParam("id") int id,@FormDataParam("ball.title") String title,
			@FormDataParam("ball.brand")String brand,@FormDataParam("ball.model") String model,@FormDataParam("ball.year") String year,
			@FormDataParam("ball.field") boolean field,@FormDataParam("ball.price") double price,
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
		
		return BallDAO.updateBall(id, title, brand, model, year, field, price, pic0, pic1, pic2, pic3);
	} 

	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deleteBall(@PathParam("id") int id) {
		   BallDAO.deleteBall(id);
	}
	
}
