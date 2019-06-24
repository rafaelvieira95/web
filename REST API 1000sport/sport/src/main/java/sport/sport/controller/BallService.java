package sport.sport.controller;

import static sport.sport.util.FileOperator.*;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import sport.sport.model.Ball;
import sport.sport.repository.BallRepository;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/balls")
public class BallService {

	@Autowired
	private BallRepository balls;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Set<Ball>> getAllBalls() {
		return new ResponseEntity<Set<Ball>>(new LinkedHashSet<>(balls.findAll()), HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Ball> getShort(@PathVariable("id") Integer id) {

		Optional<Ball> ball = balls.findById(id);

		if (ball.isPresent()) {
			return new ResponseEntity<Ball>(ball.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Ball>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	public ResponseEntity<Set<Ball>> getBallsByUser(@PathVariable("id") Integer id) {

		Set<Ball> ballsByUser = balls.getBallsByUser(id);

		return !ballsByUser.isEmpty() ? new ResponseEntity<Set<Ball>>(ballsByUser, HttpStatus.OK)
				: new ResponseEntity<Set<Ball>>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/search")
	public ResponseEntity<Set<Ball>> getballsByName(@RequestParam("name") String name){
		
		Set <Ball> ballsByName = balls.findByTitleIgnoreCaseContaining(name);
		return ballsByName.isEmpty()? new ResponseEntity<Set<Ball>>(HttpStatus.NO_CONTENT):
		                               new ResponseEntity<Set<Ball>>(ballsByName,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Ball> addBall(Integer idUser, String title, String brand, String model, String year,
			boolean field, double price, MultipartFile pic0, MultipartFile pic1, MultipartFile pic2,
			MultipartFile pic3) {

		Ball ball = new Ball(idUser, title, brand, model, year, field, price);

		Ball ballPersist = balls.save(ball);

		try {

			if (pic0 != null) 
				uploadFileServer(pic0.getInputStream(), ballPersist.getId()+"_"+ ballPersist.getIdUser()+"-pic0");

			
			if (pic1 != null) 
		
				uploadFileServer(pic1.getInputStream(), ballPersist.getId()+"_"+ ballPersist.getIdUser()+"-pic1");
			
			if (pic2 != null) 
				uploadFileServer(pic2.getInputStream(), ballPersist.getId()+"_"+ ballPersist.getIdUser()+"-pic2");
				
			
			if (pic3 != null) 
				uploadFileServer(pic3.getInputStream(), ballPersist.getId()+"_"+ ballPersist.getIdUser()+"-pic3");
			

		} catch (IOException e) {

			throw new RuntimeException(e);
		}

		return new ResponseEntity<Ball>(ballPersist, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ball> updateBall(@PathVariable("id") Integer id, String title, String brand, String model,
			String year, boolean field, double price, MultipartFile pic0, MultipartFile pic1, MultipartFile pic2,
			MultipartFile pic3) {

		Optional<Ball> updateBall = balls.findById(id);

		if (updateBall.isPresent()) {

			updateBall.get().setTitle(title);
			updateBall.get().setBrand(brand);
			updateBall.get().setModel(model);
			updateBall.get().setYear(year);
			updateBall.get().setField(field);
			updateBall.get().setPrice(price);

			try {

				if (pic0 != null) 
					uploadFileServer(pic0.getInputStream(), updateBall.get().getId()+"_"+ updateBall.get().getIdUser()+"-pic0");
					
			    if (pic1 != null) 
					uploadFileServer(pic1.getInputStream(), updateBall.get().getId()+"_"+ updateBall.get().getIdUser()+"-pic1");
						
				if (pic2 != null) 
					uploadFileServer(pic2.getInputStream(), updateBall.get().getId()+"_"+ updateBall.get().getIdUser()+"-pic2");
					
				if (pic3 != null) 
					uploadFileServer(pic3.getInputStream(), updateBall.get().getId()+"_"+ updateBall.get().getIdUser()+"-pic3");

			} catch (IOException e) {

				throw new RuntimeException(e);
			}

			return new ResponseEntity<Ball>(balls.save(updateBall.get()), HttpStatus.OK);
		}

		return new ResponseEntity<Ball>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBall(@PathVariable("id") Integer id) {

		Optional <Ball> b = balls.findById(id);
		
		if (b.isPresent()) {
			
			balls.deleteById(id);

			deleteAllFilesByProduct(id, b.get().getIdUser());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
}
