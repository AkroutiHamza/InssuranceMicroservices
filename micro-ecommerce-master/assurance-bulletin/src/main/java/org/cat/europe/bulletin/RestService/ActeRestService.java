package org.cat.europe.bulletin.RestService;

import java.util.Collection;

import org.cat.europe.bulletin.Repository.ActeRepository;
import org.cat.europe.bulletin.Repository.BulletinRepository;
import org.cat.europe.bulletin.domain.ActeMedicale;
import org.cat.europe.bulletin.domain.ArticleMedicale;
import org.cat.europe.bulletin.domain.BulletinDeSoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ActeMedicale")
public class ActeRestService {

	@Autowired
	private ActeRepository acteRepository;

	@Autowired
	private BulletinRepository bulletinRepository;

	@RequestMapping(value = "/found")
	@ResponseBody
	public Collection<ActeMedicale> getActeBul(Long id) {
		BulletinDeSoin bul = bulletinRepository.findOne(id);
		Collection<ActeMedicale> act = bul.getActeMedicale();
		return act;
	}

	@RequestMapping(value = "/list")
	@ResponseBody

	public Iterable<ActeMedicale> findAll() {
		return acteRepository.findAll();
	}

	@RequestMapping(value = "/find")
	public ActeMedicale read(@RequestParam Long acte_id) {
		ActeMedicale act = acteRepository.findOne(acte_id);
		return act;

	}
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void createActe(@RequestBody ActeMedicale act) {
		acteRepository.save(new ActeMedicale(act.getActe_id(), act.getRef_article(), act.getRef_professionel(),
				act.getMontant_totale(), act.getArticleMedicale(), act.getProfessionelDeSantes(),
				act.getBulletinDeSoin()));
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam Long acte_id) {
		acteRepository.delete(acte_id);
		return "articleMedicale#" + acte_id + "deleted successfully";
	}

	@RequestMapping(value = "/update")
	@ResponseBody

	@ResponseStatus(HttpStatus.NO_CONTENT)

	public void updateActe(@RequestParam Long acte_id, @RequestBody ActeMedicale act) {

		ActeMedicale existingAct = acteRepository.findOne(acte_id);
		existingAct.setRef_article(act.getRef_article());
		existingAct.setRef_professionel(act.getRef_professionel());
		existingAct.setMontant_totale(act.getMontant_totale());
		acteRepository.save(existingAct);
	}

}
