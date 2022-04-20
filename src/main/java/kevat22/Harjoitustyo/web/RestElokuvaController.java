package kevat22.Harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kevat22.Harjoitustyo.domain.Elokuva;
import kevat22.Harjoitustyo.domain.ElokuvaRepository;

@RestController
public class RestElokuvaController {
	
	@Autowired
	private ElokuvaRepository erepository;
	
	@GetMapping("elokuvat")
	Iterable<Elokuva> getAll(){
		return erepository.findAll();
	}
	
	@PostMapping("elokuvat")
	Elokuva newElokuva(@RequestBody Elokuva newElokuva) {
		return erepository.save(newElokuva);
	}
	
	@PutMapping("/elokuvat/{id}")
	Elokuva replaceElokuva(@RequestBody Elokuva newElokuva, @PathVariable Long id) {
		newElokuva.setId(id);
		return erepository.save(newElokuva);
	}
	
	@DeleteMapping("/elokuvat/{id}")
	void deleteElokuva(@PathVariable Long id) {
		erepository.deleteById(id);
	}


}
