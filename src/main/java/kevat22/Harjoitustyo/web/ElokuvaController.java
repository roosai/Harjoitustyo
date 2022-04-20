package kevat22.Harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kevat22.Harjoitustyo.domain.Elokuva;
import kevat22.Harjoitustyo.domain.ElokuvaRepository;
import kevat22.Harjoitustyo.domain.KategoriaRepository;
import kevat22.Harjoitustyo.domain.TilaRepository;

@Controller
public class ElokuvaController {
	
	@Autowired
	private ElokuvaRepository erepository;
	
	@Autowired
	private KategoriaRepository krepository;
	
	@Autowired
	private TilaRepository trepository;
	
	@RequestMapping(value= {"/", "/elokuvalistaus"})
	public String elokuvalistaus (Model model) {
		for (Elokuva elokuva : erepository.findAll()) {
			System.out.println(elokuva.toString());
	}model.addAttribute("elokuvat" , erepository.findAll());
	return "elokuvalistaus";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')") 
	@RequestMapping(value="/add")
	public String lisaaElokuva(Model model) {
		model.addAttribute("elokuva", new Elokuva());
		model.addAttribute("kategoriat", krepository.findAll());
		model.addAttribute("tilat", trepository.findAll());
		return "lisaaelokuva";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String tallenna(Elokuva elokuva) {
		erepository.save(elokuva);
		return "redirect:elokuvalistaus";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
	public String poistaElokuva(@PathVariable("id")Long elokuvaId, Model model) {
		erepository.deleteById(elokuvaId);
		return "redirect:../elokuvalistaus";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String lisaaElokuva(@PathVariable("id") Long elokuvaId, Model model) {
		model.addAttribute("elokuva", erepository.findById(elokuvaId));
		model.addAttribute("kategoriat", krepository.findAll());
		model.addAttribute("tilat", trepository.findAll());
		return "muokkaaelokuva";
	}
	
	
}
