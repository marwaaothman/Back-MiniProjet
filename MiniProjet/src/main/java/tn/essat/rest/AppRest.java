
package tn.essat.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.essat.dao.IGestionPfe;
import tn.essat.dao.IGestionType;
import tn.essat.model.Pfe;
import tn.essat.model.TypePfe;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest")

public class AppRest  {
	@Autowired
	IGestionPfe daopfe;
	@Autowired
	IGestionType daotype;
	
	
	@GetMapping("/pfes")
	public List<Pfe> meth1(){
		return daopfe.findAll();
		
		}
	
	@GetMapping("/listpfe/{id}")
	public List<Pfe> meth3(@PathVariable("id") int id){
		return daopfe.getAllPfeByTypePfe(id);
		}
	
	
	@GetMapping("/listetype")
	public List<TypePfe> meth2(){
		return daotype.findAll();
	}
	@GetMapping("/chercher/{titre}")
	public List<Pfe> meth4(@PathVariable("titre") String titre){
		return daopfe.getAllPfeByTitre(titre);
		}
	@GetMapping("/count")
	public Integer meth5(){
		return daopfe.findAll().size();
		}
	 
	@PostMapping("/add")
	public void get3(@RequestBody Pfe pfe ){
	 daopfe.save(pfe);
		
	}
	@DeleteMapping("/delete/{id}")
	public void get4(@PathVariable("id") int id){
		daopfe.deleteById(id);
	}
	
}
