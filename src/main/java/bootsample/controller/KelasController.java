package bootsample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Kelas;
import bootsample.service.JurusanService;
import bootsample.service.KelasService;

@Controller
public class KelasController {
	
	@Autowired
	private KelasService kelasService;
	@Autowired
	private JurusanService jurusanService;
	
	@GetMapping("/all-kelas")
	public String allKelas(HttpServletRequest request){
		request.setAttribute("kelass", kelasService.findAll());
		request.setAttribute("jurusans", jurusanService.findAll());
		request.setAttribute("mode", "MODE_KELAS");
		return "datakelas";
	}
	
	@GetMapping("/new-kelas")
	public String newKelas(HttpServletRequest request){
		request.setAttribute("jurusans", jurusanService.findAll());
		request.setAttribute("mode", "MODE_NEW");
		return "datakelas";
	}
	
	@PostMapping("/save-kelas")
	public String saveKelas(@ModelAttribute Kelas kelas, BindingResult bindingResult, HttpServletRequest request){
		kelasService.save(kelas);
		request.setAttribute("kelass", kelasService.findAll());
		request.setAttribute("mode", "MODE_KELAS");
		return "redirect:/all-kelas";
	}
	
	@GetMapping("/update-kelas")
	public String updateKelas(@RequestParam int id_kelas, HttpServletRequest request){
		request.setAttribute("kelas", kelasService.findKelas(id_kelas));
		request.setAttribute("mode", "MODE_UPDATE");
		return "datakelas";
	}
	
	@GetMapping("/delete-kelas")
	public String deleteKelas(@RequestParam int id_kelas, HttpServletRequest request){
		kelasService.delete(id_kelas);
		request.setAttribute("kelass", kelasService.findAll());
		request.setAttribute("mode", "MODE_KELAS");
		return "redirect:/all-kelas";
	}

}
