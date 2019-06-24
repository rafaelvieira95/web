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

import sport.sport.model.Short;
import sport.sport.repository.ShortRepository;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/shorts")
public class ShortService {

	@Autowired
	private ShortRepository shorts;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Set<Short>> getAllShorts() {
		return new ResponseEntity<Set<Short>>(new LinkedHashSet<>(shorts.findAll()), HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Short> getShort(@PathVariable("id") Integer id) {

		Optional<Short> shortss = shorts.findById(id);

		if (shortss.isPresent()) {
			return new ResponseEntity<Short>(shortss.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Short>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	public ResponseEntity<Set<Short>> getShortsByUser(@PathVariable("id") Integer id) {

		Set<Short> shortsByUser = shorts.getShortsByUser(id);

		return !shortsByUser.isEmpty() ? new ResponseEntity<Set<Short>>(shortsByUser, HttpStatus.OK)
				: new ResponseEntity<Set<Short>>(HttpStatus.NO_CONTENT);

	}
	
	@GetMapping("/search")
	public ResponseEntity<Set<Short>> getShortsByName(@RequestParam("name") String name){
		
		Set <Short> shortsByName = shorts.findByTitleIgnoreCaseContaining(name);
		return shortsByName.isEmpty()? new ResponseEntity<Set<Short>>(HttpStatus.NO_CONTENT):
		                               new ResponseEntity<Set<Short>>(shortsByName,HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Short> addShort(Integer idUser, String title, String brand, String model, String chooseGender,
			String chooseSize, double price, MultipartFile pic0, MultipartFile pic1, MultipartFile pic2,
			MultipartFile pic3) {

		Short shortss = new Short(idUser, title, brand, model, chooseGender, chooseSize, price);

		Short shortPersist = shorts.save(shortss);

		try {

			if (pic0 != null) 
				uploadFileServer(pic0.getInputStream(), shortPersist.getId()+"_"+ shortPersist.getIdUser()+"-pic0");
			
			if (pic1 != null) 
		
				uploadFileServer(pic1.getInputStream(), shortPersist.getId()+"_"+ shortPersist.getIdUser()+"-pic1");
			
			if (pic2 != null) 
				uploadFileServer(pic2.getInputStream(), shortPersist.getId()+"_"+ shortPersist.getIdUser()+"-pic2");
						
			if (pic3 != null) 
				uploadFileServer(pic3.getInputStream(), shortPersist.getId()+"_"+ shortPersist.getIdUser()+"-pic3");

		} catch (IOException e) {

			throw new RuntimeException(e);
		}

		return new ResponseEntity<Short>(shortPersist, HttpStatus.OK);
	}
	

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Short> updateShort(@PathVariable("id") Integer id, String title, String brand, String model,
			String chooseGender, String chooseSize, double price, MultipartFile pic0, MultipartFile pic1,
			MultipartFile pic2, MultipartFile pic3) {

		Optional<Short> updateShort = shorts.findById(id);

		if (updateShort.isPresent()) {

			try {

				if (pic0 != null) 
					uploadFileServer(pic0.getInputStream(), updateShort.get().getId()+"_"+ updateShort.get().getIdUser()+"-pic0");
					
			    if (pic1 != null) 
					uploadFileServer(pic1.getInputStream(), updateShort.get().getId()+"_"+ updateShort.get().getIdUser()+"-pic1");
						
				if (pic2 != null) 
					uploadFileServer(pic2.getInputStream(), updateShort.get().getId()+"_"+ updateShort.get().getIdUser()+"-pic2");
					
				if (pic3 != null) 
					uploadFileServer(pic3.getInputStream(), updateShort.get().getId()+"_"+ updateShort.get().getIdUser()+"-pic3");

			} catch (IOException e) {

				throw new RuntimeException(e);
			}

			return new ResponseEntity<Short>(updateShort.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Short>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteShort(@PathVariable("id") Integer id) {

		Optional<Short> s = shorts.findById(id);
		
		if (s.isPresent()) {

			shorts.deleteById(id);
			
			deleteAllFilesByProduct(id,s.get().getIdUser());
		
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
