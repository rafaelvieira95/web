package sport.sport.controller;

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

import sport.sport.model.Boot;
import sport.sport.repository.BootRepository;
import static sport.sport.util.FileOperator.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/boots")
public class BootService {

	@Autowired
	BootRepository boots;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Set<Boot>> getAllBoots() {
		return new ResponseEntity<Set<Boot>>(new LinkedHashSet<>(boots.findAll()), HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Boot> getBoot(@PathVariable("id") Integer id) {

		Optional<Boot> boot = boots.findById(id);

		if (boot.isPresent()) {
			return new ResponseEntity<Boot>(boot.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Boot>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/all/{id}")
	public ResponseEntity<Set<Boot>> getBootsByUser(@PathVariable("id") Integer id) {

		Set<Boot> bootsByUser = boots.getBootsByUser(id);

		return !bootsByUser.isEmpty() ? new ResponseEntity<Set<Boot>>(bootsByUser, HttpStatus.OK)
				: new ResponseEntity<Set<Boot>>(HttpStatus.NO_CONTENT);

	}
	
	@GetMapping("/search")
	public ResponseEntity<Set<Boot>> getBootsByName(@RequestParam("name") String name){
		
		Set <Boot> bootsByName = boots.findByTitleIgnoreCaseContaining(name);
		return bootsByName.isEmpty()? new ResponseEntity<Set<Boot>>(HttpStatus.NO_CONTENT):
		                               new ResponseEntity<Set<Boot>>(bootsByName,HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Boot> addBoot(Integer idUser, String title, String brand, String model, String bootsGender,
			int bootSize, String version, boolean field, double price, MultipartFile pic0, MultipartFile pic1,
			MultipartFile pic2, MultipartFile pic3) {

		Boot boot = new Boot(idUser, title, brand, model, bootsGender, bootSize, version, field, price);

		Boot bootPersist = boots.save(boot);

		try {

			if (pic0 != null) 
				uploadFileServer(pic0.getInputStream(), bootPersist.getId()+"_"+ bootPersist.getIdUser()+"-pic0");
			
			if (pic1 != null) 
		
				uploadFileServer(pic1.getInputStream(), bootPersist.getId()+"_"+ bootPersist.getIdUser()+"-pic1");
			
			if (pic2 != null) 
				uploadFileServer(pic2.getInputStream(), bootPersist.getId()+"_"+ bootPersist.getIdUser()+"-pic2");
						
			if (pic3 != null) 
				uploadFileServer(pic3.getInputStream(), bootPersist.getId()+"_"+ bootPersist.getIdUser()+"-pic3");

		} catch (IOException e) {

			throw new RuntimeException(e);
		}

		return new ResponseEntity<Boot>(bootPersist, HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Boot> updateBoot(@PathVariable("id") Integer id, String title, String brand, String model,
			String bootsGender, int bootSize, String version, boolean field, double price, MultipartFile pic0,
			MultipartFile pic1, MultipartFile pic2, MultipartFile pic3) {

		Optional<Boot> updateBoot = boots.findById(id);

		if (updateBoot.isPresent()) {

			updateBoot.get().setTitle(title);
			updateBoot.get().setBrand(brand);
			updateBoot.get().setModel(model);
			updateBoot.get().setBootsGender(bootsGender);
			updateBoot.get().setBootSize(bootSize);
			updateBoot.get().setVersion(version);
			updateBoot.get().setField(field);
			updateBoot.get().setPrice(price);

			try {

				if (pic0 != null) 
					uploadFileServer(pic0.getInputStream(), updateBoot.get().getId()+"_"+ updateBoot.get().getIdUser()+"-pic0");
					
			    if (pic1 != null) 
					uploadFileServer(pic1.getInputStream(), updateBoot.get().getId()+"_"+ updateBoot.get().getIdUser()+"-pic1");
						
				if (pic2 != null) 
					uploadFileServer(pic2.getInputStream(), updateBoot.get().getId()+"_"+ updateBoot.get().getIdUser()+"-pic2");
					
				if (pic3 != null) 
					uploadFileServer(pic3.getInputStream(), updateBoot.get().getId()+"_"+ updateBoot.get().getIdUser()+"-pic3");

			} catch (IOException e) {

				throw new RuntimeException(e);
			}

			return new ResponseEntity<Boot>(boots.save(updateBoot.get()), HttpStatus.OK);

		} else {

			return new ResponseEntity<Boot>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBoot(@PathVariable("id") Integer id) {

		Optional <Boot> b = boots.findById(id);
		
		if (b.isPresent()) {

			boots.deleteById(id);
			
			deleteAllFilesByProduct(id, b.get().getIdUser());
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
