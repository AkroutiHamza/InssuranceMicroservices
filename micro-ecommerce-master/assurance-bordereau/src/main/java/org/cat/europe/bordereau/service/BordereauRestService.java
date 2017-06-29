package org.cat.europe.bordereau.service;


import org.cat.europe.bordereau.dao.BordereauRepository;
import org.cat.europe.bordereau.domain.Bordereau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/bordereau")
public class BordereauRestService {

	
	@Autowired
	private BordereauRepository bordereauRepository;


	@RequestMapping(value = "/list",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

	@ResponseBody
	public Iterable<Bordereau> findAll() {
		System.out.println("tes");

		return bordereauRepository.findAll();
	}

	@RequestMapping(value = "/save",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)

	@ResponseBody

	@ResponseStatus(HttpStatus.CREATED)
	public void createBordereau(@RequestBody Bordereau bordereau) {
		System.out.println("test");
		System.out.println( bordereau.getDate_bordereau().toString());
		
		
		bordereauRepository.save(
				new Bordereau(bordereau.getBordereau_id(), bordereau.getReference(), bordereau.getDate_bordereau(),
						bordereau.getDate_bordereau(), bordereau.getNombre_piece(), bordereau.getMontant()));
						
						
	}

	@RequestMapping(value="/find/{bordereau_id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Bordereau read(@PathVariable Long bordereau_id) {
		Bordereau bordereau = bordereauRepository.findOne(bordereau_id);
		return bordereau;
	}

	@RequestMapping(value="/delete/{bordereau_id}",method=RequestMethod.DELETE)
	
	public ResponseEntity<Bordereau> delete(@PathVariable("bordereau_id") Long bordereau_id) {
		System.out.println("supprimmerrr");
		bordereauRepository.delete(bordereau_id);
		//return "bordereau #" + bordereau_id + "deleted successfully";
		
		return new ResponseEntity<Bordereau>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/update",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateBordereau(@RequestParam Long bordereau_id, @RequestBody Bordereau bordereau) {
		System.out.println(bordereau_id);
		Bordereau existingBordereau = bordereauRepository.findOne(bordereau_id);
		
		existingBordereau.setReference(bordereau.getReference());

		existingBordereau.setNombre_piece(bordereau.getNombre_piece());
		existingBordereau.setDate_bordereau(bordereau.getDate_bordereau());
		existingBordereau.setDate_creation(bordereau.getDate_creation());
		bordereauRepository.save(existingBordereau);

	}

}
