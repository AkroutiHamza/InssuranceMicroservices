package org.cat.europe.bulletin.RestService;

import org.cat.europe.bulletin.Repository.BulletinRepository;
import org.cat.europe.bulletin.domain.BulletinDeSoin;
import org.cat.europe.bulletin.domain.ProfessionelDeSante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Bulletin")

public class BulletinRestService {
	
	@Autowired
	private BulletinRepository bulletinRepository;

	@RequestMapping(value="/list")
	@ResponseBody
	
	public Iterable<BulletinDeSoin> findAll() {
		return bulletinRepository.findAll();
	}

	
	
	
	@RequestMapping(value="/find")
	public BulletinDeSoin read(@RequestParam Long bulletin_id){
		BulletinDeSoin bull = bulletinRepository.findOne(bulletin_id);
		return bull;
	}
	
	
	
	
	@RequestMapping(value="/save")
	@ResponseBody

	@ResponseStatus(HttpStatus.CREATED)
public void createBulletin(@RequestBody BulletinDeSoin bl){
bulletinRepository.save(new BulletinDeSoin(bl.getBulletin_id(),bl.getDate_bulletin(),bl.getDate_prise_charge(),bl.getDate_validation(),bl.getLettre_liaison(),bl.getMontant(),bl.getReference(),bl.getActeMedicale()));
}



	@RequestMapping(value="/delete")
	@ResponseBody 
public String delete(@RequestParam Long bulletin_id){
	bulletinRepository.delete(bulletin_id);
	return "articleMedicale#"+bulletin_id+"deleted successfully";
}
	
	/*
	 *
	public void updateProfessionel(@RequestParam Long professionnel_id,@RequestBody ProfessionelDeSante professionelDeSante){
		ProfessionelDeSante existingProfessionel = professionelRepository.findOne(professionnel_id);
		existingProfessionel.setNom(professionelDeSante.getNom());
		existingProfessionel.setAdresse(professionelDeSante.getAdresse());
		existingProfessionel.setEmail(professionelDeSante.getEmail());
		existingProfessionel.setMontant(professionelDeSante.getMontant());
		existingProfessionel.setTel(professionelDeSante.getTel());
		existingProfessionel.setSpecialite(professionelDeSante.getSpecialite());
		professionelRepository.save(existingProfessionel);
		
		
	}
	
	 */
	
	 @RequestMapping(value ="/update")
		@ResponseBody
		
		@ResponseStatus(HttpStatus.NO_CONTENT)
	
	public void updateBulletin(@RequestParam Long bulletin_id, @RequestBody BulletinDeSoin bul){
	BulletinDeSoin existingBulletin = bulletinRepository.findOne(bulletin_id);
	   existingBulletin.setDate_bulletin(bul.getDate_bulletin());
	   existingBulletin.setDate_prise_charge(bul.getDate_prise_charge());
	   existingBulletin.setDate_validation(bul.getDate_validation());
	   existingBulletin.setLettre_liaison(bul.getLettre_liaison());
	   existingBulletin.setMontant(bul.getMontant());
	   existingBulletin.setReference(bul.getReference());
	   bulletinRepository.save(existingBulletin);
		
		
	}
	


}



