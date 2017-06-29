package com.cat.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cat.user.Repository.CaracteristiqueRepository;
import com.cat.user.domain.Caracteristique;

@RestController
@RequestMapping(value = "/Caracteristique")
public class CaracteristiqueRest {

	@Autowired
	private CaracteristiqueRepository caracteristiqueRepository;

	@RequestMapping(value = "/find")

	public Caracteristique read(@RequestParam Long id_caracteristique) {
		Caracteristique car = caracteristiqueRepository.findOne(id_caracteristique);
		return car;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public Iterable<Caracteristique> findAll() {
		return caracteristiqueRepository.findAll();
	}

	@RequestMapping(value = "/save")
	@ResponseBody

	@ResponseStatus(HttpStatus.CREATED)
	public void createCaracteristique(@RequestBody Caracteristique car) {
		caracteristiqueRepository.save(new Caracteristique(car.getId_caracteristique(), car.getPoste(),
				car.getPlafond(), car.getAssuranceEmployes()));

	}

	public String delete(@RequestParam Long id_caracteristique) {
		caracteristiqueRepository.delete(id_caracteristique);
		return "societe #" + id_caracteristique + "deleted successfully";
	}

	@RequestMapping(value = "/update")
	@ResponseBody

	@ResponseStatus(HttpStatus.NO_CONTENT)

	public void updateCaracteristique(@RequestParam Long id_caracteristique, @RequestBody Caracteristique car) {
		Caracteristique existingCaracteristique = caracteristiqueRepository.findOne(id_caracteristique);
		existingCaracteristique.setPoste(car.getPoste());
		existingCaracteristique.setPlafond(car.getPlafond());
		caracteristiqueRepository.save(existingCaracteristique);
	}

}
