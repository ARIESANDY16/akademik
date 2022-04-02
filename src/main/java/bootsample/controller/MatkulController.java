package bootsample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Dosen;
import bootsample.model.Jurusan;
import bootsample.model.Kelas;
import bootsample.model.Matkul;
import bootsample.service.DosenService;
import bootsample.service.JurusanService;
import bootsample.service.KelasService;
import bootsample.service.MatkulService;

@Controller
public class MatkulController {
	
	@Autowired
	private MatkulService matkulService;
	@Autowired
	private KelasService kelasService;
	@Autowired
	private DosenService dosenService;
	@Autowired
	private JurusanService jurusanService;
	
	
	@GetMapping("/all-matkul")
	public String allMatkul(HttpServletRequest request){
		request.setAttribute("matkuls", matkulService.findAll());
		request.setAttribute("mode", "MODE_MATKUL");
		return "datamatkul";
	}
	
	@GetMapping("/new-matkul")
	public String newMatkul(HttpServletRequest request){
		request.setAttribute("matkuls", matkulService.findAll());
		request.setAttribute("dosens", dosenService.findAll());
		request.setAttribute("kelass", kelasService.findAll());
		request.setAttribute("jurusans", jurusanService.findAll());
		request.setAttribute("mode", "MODE_NEW");
		return "datamatkul";
	}
	
	@PostMapping("/save-matkul")
	public String saveMatkul(@ModelAttribute Matkul matkul, BindingResult bindingResult, HttpServletRequest request){
		matkulService.save(matkul);
		request.setAttribute("matkuls", matkulService.findAll());
		request.setAttribute("mode", "MODE_MATKUL");
		return "redirect:/all-matkul";
	}
	
//	@GetMapping("/save-matkul")
//	public String saveMatkul(@RequestParam int id_matkul, @RequestParam String kd_matkul, @RequestParam String nama_matkul, @RequestParam int sks, @RequestParam Jurusan jurusan, @RequestParam Kelas kelas, @RequestParam Dosen dosen) {
//		Matkul matkul = new Matkul(id_matkul, kd_matkul, nama_matkul, sks, jurusan, kelas, dosen);
//		matkulService.save(matkul);
//		return "redirect:/all-matkul";
//	}
	
	@GetMapping("/update-matkul")
	public String updateMatkul(@RequestParam int id_matkul, HttpServletRequest request){
		request.setAttribute("matkul", matkulService.findMatkul(id_matkul));
		request.setAttribute("dosens", dosenService.findAll());
		request.setAttribute("kelass", kelasService.findAll());
		request.setAttribute("mode", "MODE_UPDATE");
		return "datamatkul";
	}
	
	@GetMapping("/delete-matkul")
	public String deleteMatkul(@RequestParam int id_matkul, HttpServletRequest request){
		matkulService.delete(id_matkul);
		request.setAttribute("matkuls", matkulService.findAll());
		request.setAttribute("mode", "MODE_MATKUL");
		return "redirect:/all-matkul";
	}

}
