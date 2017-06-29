package com.cat.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cat.user.Repository.SocieteRepository;
import com.cat.user.domain.Societe;

@RestController
@RequestMapping(value = "/Societe")
public class SocieteRest {

	@Autowired
	private SocieteRepository societeRepository;

	@RequestMapping(value = "/list")
	@ResponseBody
	public Iterable<Societe> findAll() {
		return societeRepository.findAll();
	}

	@RequestMapping(value = "/find")
	public Societe read(@RequestParam Long id_societe) {
		Societe soc = societeRepository.findOne(id_societe);
		return soc;
	}

	@RequestMapping(value = "/save")
	@ResponseBody

	@ResponseStatus(HttpStatus.CREATED)
	public void createSociete(@RequestBody Societe soc) {
		societeRepository.save(new Societe(soc.getId_societe(), soc.getNom(), soc.getAdresse(), soc.getPays(),
				soc.getTel(), soc.getFax(), soc.getDate_creation()));

	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(@RequestParam Long id_societe) {
		societeRepository.delete(id_societe);
		return "societe #" + id_societe + "deleted successfully";
	}

	@RequestMapping(value = "/update")
	@ResponseBody

	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSociete(@RequestParam Long id_societe, @RequestBody Societe societe) {
		Societe existingSociete = societeRepository.findOne(id_societe);
		existingSociete.setNom(societe.getNom());
		existingSociete.setAdresse(societe.getAdresse());
		existingSociete.setPays(societe.getPays());
		existingSociete.setTel(societe.getTel());
		existingSociete.setFax(societe.getFax());
		existingSociete.setDate_creation(societe.getDate_creation());
		societeRepository.save(existingSociete);
	}

}
