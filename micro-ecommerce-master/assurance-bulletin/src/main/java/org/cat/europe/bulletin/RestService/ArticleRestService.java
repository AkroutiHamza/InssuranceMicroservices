package org.cat.europe.bulletin.RestService;



import java.util.Collection;

import org.cat.europe.bulletin.Repository.ActeRepository;
import org.cat.europe.bulletin.Repository.ArticleRepository;
import org.cat.europe.bulletin.domain.ActeMedicale;
import org.cat.europe.bulletin.domain.ArticleMedicale;
import org.cat.europe.bulletin.domain.ProfessionelDeSante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Article")
public class ArticleRestService {
	
	@Autowired
	private ArticleRepository articleRepository;

	
	
	
	
	
	@Autowired
	private ActeRepository acteRepository;

	

	@RequestMapping(value="/found")
	@ResponseBody
public Collection<ArticleMedicale> getArticlelActe(Long id){
	ActeMedicale acte = acteRepository.findOne(id);
	Collection<ArticleMedicale> arti  = acte.getArticleMedicale();
	return arti;
}

	/*
	 * 
	  
	 * 
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	
	public Iterable<ArticleMedicale> findAll() {
		return articleRepository.findAll();
	}
	
	
	
	@RequestMapping(value="/find")
	
	
	public ArticleMedicale read(@RequestParam Long article_id) {
		ArticleMedicale article = articleRepository.findOne(article_id);
		return article;
	}

	
	




@RequestMapping(value = "/save",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
@ResponseStatus(HttpStatus.CREATED)
public void createArticle(@RequestBody ArticleMedicale articleMedicale){
	articleRepository.save(new ArticleMedicale(articleMedicale.getArticle_id(),articleMedicale.getLibelle(),articleMedicale.getDescription(),articleMedicale.getPrix(),articleMedicale.getQuantite(),articleMedicale.getActeMedicales()));
	
}



@RequestMapping(value="/delete/{article_id}",method=RequestMethod.DELETE)

public String delete(@PathVariable("article_id") Long article_id) {
	articleRepository.delete(article_id);
	return "articleMedicale#"+article_id+"deleted successfully";
}





@RequestMapping(value="/update")
@ResponseBody

@ResponseStatus(HttpStatus.NO_CONTENT)
public void updateArticle(@RequestParam Long article_id,@RequestBody ArticleMedicale articleMedicale){
	ArticleMedicale existingArticle = articleRepository.findOne(article_id);
	existingArticle.setLibelle(articleMedicale.getLibelle());
	existingArticle.setDescription(articleMedicale.getDescription());
	existingArticle.setPrix(articleMedicale.getPrix());
	existingArticle.setQuantite(articleMedicale.getQuantite());
	articleRepository.save(existingArticle);
	
}




}
