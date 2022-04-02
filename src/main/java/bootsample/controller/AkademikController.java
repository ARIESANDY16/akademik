package bootsample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Akademik;
import bootsample.model.Dosen;
import bootsample.model.Matkul;
import bootsample.model.Mhs;
import bootsample.service.AkademikService;
//import bootsample.service.DosenService;
import bootsample.service.MatkulService;
import bootsample.service.MhsService;
//import bootsample.service.MhsService;

@Controller
public class AkademikController {
	
	@Autowired
	private AkademikService akademikService;
	@Autowired
	private MhsService mhsService;
//	@Autowired
//	private DosenService dosenService;
	@Autowired
	private MatkulService matkulService;
	 	
	@GetMapping("/all-akademik")
	public String allAkademik(HttpServletRequest request){
		request.setAttribute("akademiks", akademikService.findAll());
		request.setAttribute("mode", "MODE_AKADEMIK");
		return "akademik";
	}
	
	@GetMapping("/new-akademik")
	public String newAkademik(@RequestParam int id_matkul, HttpServletRequest request) {
		request.setAttribute("akademiks", akademikService.findAll());
		request.setAttribute("matkuls", matkulService.findMatkul(id_matkul));
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("mode", "MODE_NEW");
		return "akademik";
	}
	@GetMapping("/list-matkul")
	public String listmatkul(HttpServletRequest request) {
		request.setAttribute("akademiks", akademikService.findAll());
		request.setAttribute("mhss", mhsService.findAll());
		return "d_matkul";
	}
	
	@PostMapping("/save-akademik")
	public String saveAkademik(@ModelAttribute Akademik akademik, BindingResult bindingResult, HttpServletRequest request){
		akademikService.save(akademik);
		request.setAttribute("akademiks", akademikService.findAll()); 
		request.setAttribute("matkuls", matkulService.findAll());
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("mode", "MODE_AKADEMIK");
		return "redirect:/all-akademik";
	}
	
	@PostMapping("/save-krs")
	public String saveKrs(@ModelAttribute Akademik akademik, BindingResult bindingResult, HttpServletRequest request){
		akademikService.saves(akademik);
		request.setAttribute("akademiks", akademikService.findAll()); 
		request.setAttribute("matkuls", matkulService.findAll());
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("mode", "MODE_AKADEMIK");
		return "redirect:/all-krs";
	}
	
	@GetMapping("/save-akademik")
	public String saveAkademik(@RequestParam int id_akademik, @RequestParam Mhs mhs, @RequestParam Matkul matkul, @RequestParam Dosen dosen, @RequestParam int quiz, @RequestParam int uts, @RequestParam int uas, @RequestParam String grade) {
		Akademik akademik = new Akademik(id_akademik, mhs, matkul, dosen, quiz, uts, uas, grade);
		akademikService.save(akademik);
		return "redirect:/all-akademik";
	}
	
	@GetMapping("/update-akademik")
	public String updateAkademik(@RequestParam int id_akademik, HttpServletRequest request){
		request.setAttribute("akademiks", akademikService.findAkademik(id_akademik));
		request.setAttribute("mode", "MODE_UPDATE");
		return "akademik";
	}
	
	@GetMapping("/input-akademik")
	public String inputAkademik(@RequestParam int id_akademik, @RequestParam int id_mhs, @RequestParam int id_matkul, HttpServletRequest request){
		request.setAttribute("akademiks", akademikService.findAkademik(id_akademik));
		request.setAttribute("mhss", mhsService.findMhs(id_mhs));
		request.setAttribute("matkuls", matkulService.findMatkul(id_matkul));
		return "d_input";
	}
	
	@PostMapping("/input-akademik")
	public String profile_mhs(@ModelAttribute Akademik akademik, BindingResult bindingResult, HttpServletRequest request) {
		akademikService.save(akademik);
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("akademiks", akademikService.findAll());
		request.setAttribute("matkuls", matkulService.findAll());
		return "redirect:/d_input";
	}
	
	@GetMapping("/delete-akademik")
	public String deleteAkademik(@RequestParam int id_akademik, HttpServletRequest request){
		akademikService.delete(id_akademik);
		request.setAttribute("akademiks", akademikService.findAll());
		request.setAttribute("mode", "MODE_AKADEMIK");
		return "akademik";
	}

}
