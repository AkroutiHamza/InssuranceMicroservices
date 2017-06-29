package org.cat.europe.bulletin.RestService;

import java.io.IOException;
import java.util.Collection;

import org.cat.europe.bulletin.Repository.ActeRepository;
import org.cat.europe.bulletin.Repository.ProfessionelRepository;
import org.cat.europe.bulletin.domain.ActeMedicale;
import org.cat.europe.bulletin.domain.ProfessionelDeSante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Controller
@RequestMapping(value = "/Professionel_De_Sante")
public class ProfessionelRestService {

	@Autowired
	private ProfessionelRepository professionelRepository;

	@Autowired
	public static final String uploadingdir = System.getProperty("user.dir") + "/uploadingdir/";

	/*
	 * public Collection<ProfessionelDeSante> profParActe(Long idAct) { return
	 * professionelRepository.profParActe(idAct); }
	 * 
	 * 
	 * 
	 * 
	 * public Collection<ProfessionelDeSante> proSelectionne() { return
	 * professionelRepository.proSelectionne(); }
	 */
	@Autowired
	private ActeRepository acteRepository;

	
	
	@RequestMapping(value = "/find/{professionnel_id}",
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProfessionelDeSante read(@PathVariable Long professionnel_id) {
		ProfessionelDeSante pro = professionelRepository.findOne(professionnel_id);
		return pro;
	}


	

	/*
	 * 
	 * 
	 */

	@RequestMapping(value = "/list")
	@ResponseBody
	public Iterable<ProfessionelDeSante> findAll() {
		return professionelRepository.findAll();
	}

	/*
	 * @RequestMapping(value="/find/{bordereau_id}",method=RequestMethod.GET,
	 * produces = MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @ResponseBody 
	 * public Bordereau read(@PathVariable Long bordereau_id) {
	 * Bordereau bordereau = bordereauRepository.findOne(bordereau_id); return
	 * bordereau; }
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody

	@ResponseStatus(HttpStatus.CREATED)
	public void createProfessionel(@RequestBody ProfessionelDeSante pr) {
		professionelRepository.save(pr);

	}

	@RequestMapping(value = "/delete/{professionnel_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("professionnel_id") Long professionnel_id) {
		professionelRepository.delete(professionnel_id);
		return "articleMedicale#" + professionnel_id + "deleted successfully";
	}

	@RequestMapping(value = "/update")
	@ResponseBody

	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProfessionel(@RequestParam Long professionnel_id,
			@RequestBody ProfessionelDeSante professionelDeSante) {
		ProfessionelDeSante existingProfessionel = professionelRepository.findOne(professionnel_id);
		existingProfessionel.setNom(professionelDeSante.getNom());
		existingProfessionel.setAdresse(professionelDeSante.getAdresse());
		existingProfessionel.setEmail(professionelDeSante.getEmail());
		existingProfessionel.setMontant(professionelDeSante.getMontant());
		existingProfessionel.setTel(professionelDeSante.getTel());
		existingProfessionel.setSpecialite(professionelDeSante.getSpecialite());
		professionelRepository.save(existingProfessionel);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/upload", consumes = "multipart/form-data")
	public String handleFileUpload(@RequestPart("uploadfile") MultipartFile file) throws IOException {
		try {
			if (!file.isEmpty()) {
				Writer.validateOfficeData(file);
				Writer.saveOfficeContents(file, professionelRepository);
				System.out.println("Upload successful!");
			}
		} catch (MultipartException e) {
			e.printStackTrace();
			System.out.println("Upload failed!" + e);
		}
		return "redirect:/";
	}

}
