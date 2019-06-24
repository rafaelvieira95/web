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

import sport.sport.model.Shirt;
import sport.sport.repository.ShirtRepository;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/shirts")
public class ShirtService {

	@Autowired
	private ShirtRepository shirts;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Set<Shirt>> getAllShirts() {

		return new ResponseEntity<Set<Shirt>>(new LinkedHashSet<>(shirts.findAll()), HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Shirt> getShirt(@PathVariable("id") Integer id) {

		Optional<Shirt> shirt = shirts.findById(id);

		if (shirt.isPresent()) {

			return new ResponseEntity<Shirt>(shirt.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Shirt>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	public ResponseEntity<Set<Shirt>> getShirtsByUser(@PathVariable("id") Integer id) {

		Set<Shirt> shirtsByUser = shirts.getShirtsByUser(id);

		return !shirtsByUser.isEmpty() ? new ResponseEntity<Set<Shirt>>(shirtsByUser, HttpStatus.OK)
				: new ResponseEntity<Set<Shirt>>(HttpStatus.NO_CONTENT);

	}
	
	
	@GetMapping("/search")
	public ResponseEntity<Set<Shirt>> getShirtsByName(@RequestParam("name") String name){
		
		Set <Shirt> shirtsByName = shirts.findByTitleIgnoreCaseContaining(name);
		return shirtsByName.isEmpty()? new ResponseEntity<Set<Shirt>>(HttpStatus.NO_CONTENT):
		                               new ResponseEntity<Set<Shirt>>(shirtsByName,HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Shirt> addUser(int idUser, String title, String brand, String club, String season,
			String version, String occasion, boolean gk, double price, MultipartFile pic0, MultipartFile pic1,
			MultipartFile pic2, MultipartFile pic3) {

		Shirt shirt = new Shirt(idUser, title, brand, club, season, version, occasion, gk, price);

		Shirt shirtPersist = shirts.save(shirt);

		try {

			if (pic0 != null) 
				uploadFileServer(pic0.getInputStream(), shirtPersist.getId()+"_"+ shirtPersist.getIdUser()+"-pic0");

			if (pic1 != null) 
				uploadFileServer(pic1.getInputStream(), shirtPersist.getId()+"_"+ shirtPersist.getIdUser()+"-pic1");
			
			if (pic2 != null) 
				uploadFileServer(pic2.getInputStream(), shirtPersist.getId()+"_"+ shirtPersist.getIdUser()+"-pic2");
				
			
			if (pic3 != null) 
				uploadFileServer(pic3.getInputStream(), shirtPersist.getId()+"_"+ shirtPersist.getIdUser()+"-pic3");
			
			
		} catch (IOException e) {

			throw new RuntimeException(e);
		}

		return new ResponseEntity<Shirt>(shirtPersist, HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Shirt> updateShirt(@PathVariable("id") Integer id, Integer idUser, String title, String brand,
			String club, String season, String version, String occasion, boolean gk, double price, MultipartFile pic0,
			MultipartFile pic1, MultipartFile pic2, MultipartFile pic3) {

		Optional<Shirt> updateShirt = shirts.findById(id);

		if (updateShirt.isPresent()) {

			updateShirt.get().setTitle(title);
			updateShirt.get().setBrand(brand);
			updateShirt.get().setClub(club);
			updateShirt.get().setSeason(season);
			updateShirt.get().setOccasion(occasion);
			updateShirt.get().setGk(gk);
			updateShirt.get().setPrice(price);

			shirts.save(updateShirt.get());

			try {
					
				if (pic0 != null) 
					uploadFileServer(pic0.getInputStream(), updateShirt.get().getId()+"_"+ updateShirt.get().getIdUser()+"-pic0");
					
			    if (pic1 != null) 
					uploadFileServer(pic1.getInputStream(), updateShirt.get().getId()+"_"+ updateShirt.get().getIdUser()+"-pic1");
						
				if (pic2 != null) 
					uploadFileServer(pic2.getInputStream(), updateShirt.get().getId()+"_"+ updateShirt.get().getIdUser()+"-pic2");
					
				if (pic3 != null) 
					uploadFileServer(pic3.getInputStream(), updateShirt.get().getId()+"_"+ updateShirt.get().getIdUser()+"-pic3");
					
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return new ResponseEntity<Shirt>(updateShirt.get(), HttpStatus.OK);

		}

		return new ResponseEntity<Shirt>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteShirt(@PathVariable("id") Integer id) {

		Optional <Shirt> s = shirts.findById(id);
		 
		if (s.isPresent()) {
			
			shirts.deleteById(id);
			
			deleteAllFilesByProduct(id, s.get().getIdUser());
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
