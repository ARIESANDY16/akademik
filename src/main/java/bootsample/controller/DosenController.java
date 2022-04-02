package bootsample.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Dosen;
import bootsample.service.DosenService;

@Controller
public class DosenController {
	
	@Autowired
	private DosenService dosenService;
	
	@GetMapping("/data-dosen")
	public String dataDosen(HttpServletRequest request){
		request.setAttribute("dosens", dosenService.findAll());
		request.setAttribute("mode", "MODE_DOSEN");
		return "d_dosen";
	}
	
	@GetMapping("/dosen-dashboard")
	public String dosen_dashboard(HttpServletRequest request) {
		request.setAttribute("dosenss", dosenService.findAll());
		return "d_dashboard";
	}
	@PostMapping("/ubahprofile-dosen")
	public String profile_dosen(@ModelAttribute Dosen dosen, BindingResult bindingResult, HttpServletRequest request){
		dosenService.save(dosen);
		request.setAttribute("dosens", dosenService.findAll());
		return "redirect:/dosen-dashboard";
	}
	@GetMapping("/ubahprofile-dosen")
	public String profile_dosen(@RequestParam int id_dosen, @RequestParam String nip, @RequestParam String nik, @RequestParam String nama_dosen,@RequestParam String tl_dosen,@RequestParam Date tgl_dosen,@RequestParam String alamat_dosen,
			@RequestParam String agama_dosen,@RequestParam String gender,@RequestParam String no_telp, @RequestParam String email, @RequestParam String password) {
		Dosen dosen = new Dosen(id_dosen, nip, nik, nama_dosen, tl_dosen, tgl_dosen, alamat_dosen, agama_dosen, gender, no_telp, email, password);
		dosenService.save(dosen);
		return "redirect:/dosen-dashboard";
	}
	
	
	@GetMapping("/all-dosen")
	public String allDosen(HttpServletRequest request){
		request.setAttribute("dosens", dosenService.findAll());
		request.setAttribute("mode", "MODE_DOSEN");
		return "datadosen";
	}
	
	@GetMapping("/new-dosen")
	public String newDosen(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "datadosen";
	}
	
	@PostMapping("/save-dosen")
	public String saveDosen(@ModelAttribute Dosen dosen, BindingResult bindingResult, HttpServletRequest request){
		dosenService.save(dosen);
		request.setAttribute("dosens", dosenService.findAll());
		request.setAttribute("mode", "MODE_DOSEN");
		return "redirect:/all-dosen";
	}
	@GetMapping("/save-dosen")
	public String saveDosen(@RequestParam int id_dosen, @RequestParam String nip, @RequestParam String nik, @RequestParam String nama_dosen,@RequestParam String tl_dosen,@RequestParam Date tgl_dosen,@RequestParam String alamat_dosen,
			@RequestParam String agama_dosen,@RequestParam String gender,@RequestParam String no_telp,@RequestParam String email, @RequestParam String password) {
		Dosen dosen = new Dosen(id_dosen, nip, nik, nama_dosen, tl_dosen, tgl_dosen, alamat_dosen, agama_dosen, gender, no_telp, email, password);
		dosenService.save(dosen);
		return "redirect:/all-dosen";
	}
	
	@GetMapping("/update-dosen")
	public String updateDosen(@RequestParam int id_dosen, HttpServletRequest request){
		request.setAttribute("dosen", dosenService.findDosen(id_dosen));
		request.setAttribute("mode", "MODE_UPDATE");
		return "ubahdosen";
	}
	
	@GetMapping("/delete-dosen")
	public String deleteDosen(@RequestParam int id_dosen, HttpServletRequest request){
		dosenService.delete(id_dosen);
		request.setAttribute("dosens", dosenService.findAll());
		request.setAttribute("mode", "MODE_DOSEN");
		return "redirect:/all-dosen";
	}

}
