package bootsample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Jurusan;
import bootsample.service.JurusanService;

@Controller
public class JurusanController {
	
	@Autowired
	private JurusanService jurusanService;
	
	
	@GetMapping("/all-jurusan")
	public String allJurusan(HttpServletRequest request){
		request.setAttribute("jurusans", jurusanService.findAll());
		request.setAttribute("mode", "MODE_JURUSAN");
		return "datajurusan";
	}
	
	@GetMapping("/new-jurusan")
	public String newJurusan(HttpServletRequest request){
		request.setAttribute("jurusans", jurusanService.findAll());
		request.setAttribute("mode", "MODE_NEW");
		return "datajurusan";
	}
	
	@PostMapping("/save-jurusan")
	public String saveJurusan(@ModelAttribute Jurusan jurusan, BindingResult bindingResult, HttpServletRequest request){
		jurusanService.save(jurusan);
		request.setAttribute("jurusans", jurusanService.findAll());
		request.setAttribute("mode", "MODE_JURUSAN");
		return "redirect:/all-jurusan";
	}
	
	@GetMapping("/update-jurusan")
	public String updateJurusan(@RequestParam int id_jurusan, HttpServletRequest request){
		request.setAttribute("jurusan", jurusanService.findJurusan(id_jurusan));
		request.setAttribute("mode", "MODE_UPDATE");
		return "datajurusan";
	}
	
	@GetMapping("/delete-jurusan")
	public String deleteJurusan(@RequestParam int id_jurusan, HttpServletRequest request){
		jurusanService.delete(id_jurusan);
		request.setAttribute("jurusans", jurusanService.findAll());
		request.setAttribute("mode", "MODE_JURUSAN");
		return "redirect:/all-jurusan";
	}

}
