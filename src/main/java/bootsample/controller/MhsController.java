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

import bootsample.model.Jurusan;
import bootsample.model.Kelas;
import bootsample.model.Mhs;
import bootsample.service.AkademikService;
import bootsample.service.DosenService;
import bootsample.service.JurusanService;
import bootsample.service.KelasService;
import bootsample.service.MatkulService;
import bootsample.service.MhsService;

@Controller
public class MhsController {

	@Autowired
	private MhsService mhsService;

	@Autowired
	private KelasService kelasService;

	@Autowired
	private AkademikService akademikService;
	
	@Autowired
	private JurusanService jurusanService;

	@Autowired
	private MatkulService matkulService;
	
	@Autowired
	private DosenService dosenService;

	@GetMapping("/all-mhs")
	public String allMhs(HttpServletRequest request) {
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("mode", "MODE_MHS");
		return "datamhs";
	}
	
	@GetMapping("/all-krs")
	public String allKrs(HttpServletRequest request) {
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("mode", "MODE_MHS");
		return "krs";
	}
	
	@GetMapping("/krs")
	public String krs_mhs(@RequestParam int id_mhs, HttpServletRequest request) {
		request.setAttribute("mhs", mhsService.findMhs(id_mhs));
		request.setAttribute("akademiks", akademikService.findAll());
		request.setAttribute("matkuls", matkulService.findAll());
		request.setAttribute("dosens", dosenService.findAll());
		request.setAttribute("mode", "MODE_MHS");
		return "datakrs";
	}

	@GetMapping("/nilai-mhs")
	public String nilaimhs(HttpServletRequest request) {
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("akademiks", akademikService.findAll());
		request.setAttribute("mode", "MODE_MHS");
		return "m_nilai";
	}
	
	@GetMapping("/ipk")
	public float cetakipk(HttpServletRequest request) {
		return akademikService.ipk(request.getParameter("npm"));
	}

	@GetMapping("/cetak-mhs")
	public String cetakmhs(HttpServletRequest request) {
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("mode", "MODE_MHS");
		return "m_cetaknilai";
	}

	@GetMapping("/data-mhs")
	public String allProfile(HttpServletRequest request) {
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("kelass", kelasService.findAll());
		return "m_mhs";
	}

	@GetMapping("/mhs_dashboard")
	public String mhs_dashboard(HttpServletRequest request) {
		request.setAttribute("mhss", mhsService.findAll());
		return "m_dashboard";
	}

	@PostMapping("/ubahprofile-mhs")
	public String profile_mhs(@ModelAttribute Mhs mhs, BindingResult bindingResult, HttpServletRequest request) {
		mhsService.save(mhs);
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("kelass", kelasService.findAll());
		return "redirect:/mhs_dashboard";
	}

	@GetMapping("/ubahprofile-mhs")
	public String profile_mhs(@RequestParam int id_mhs, @RequestParam String npm, @RequestParam Jurusan jurusan, @RequestParam Kelas kelas,
			@RequestParam String nama_mhs, @RequestParam String tempat_lahir, @RequestParam Date tgl_lahir,
			@RequestParam String alamat_mhs, @RequestParam String agama_mhs, @RequestParam String gender,
			@RequestParam String no_telp, @RequestParam String password) {
		Mhs mhs = new Mhs(id_mhs, npm, jurusan, kelas, nama_mhs, tempat_lahir, tgl_lahir, alamat_mhs, agama_mhs, gender, no_telp,
				password);
		mhsService.save(mhs);
		return "redirect:/ubahprofile-mhs";
	}

	@GetMapping("/new-mhs")
	public String newMhs(HttpServletRequest request) {
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("kelass", kelasService.findAll());
		request.setAttribute("jurusans", jurusanService.findAll());
		request.setAttribute("mode", "MODE_NEW");
		return "datamhs";
	}

	@PostMapping("/save-mhs")
	public String saveMhs(@ModelAttribute Mhs mhs, BindingResult bindingResult, HttpServletRequest request) {
		mhsService.saves(mhs);
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("mode", "MODE_MHS");
		return "redirect:/all-mhs";
	}
	
	@PostMapping("/save-update")
	public String savesMhs(@ModelAttribute Mhs mhs, BindingResult bindingResult, HttpServletRequest request) {
		mhsService.save(mhs);
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("mode", "MODE_MHS");
		return "redirect:/all-mhs";
	}

//	@GetMapping("/save-mhs")
//	public String saveMhs(@RequestParam int id_mhs, @RequestParam String npm, @RequestParam Jurusan jurusan, @RequestParam Kelas kelas,
//			@RequestParam String nama_mhs, @RequestParam String tempat_lahir, @RequestParam Date tgl_lahir,
//			@RequestParam String alamat_mhs, @RequestParam String agama_mhs, @RequestParam String gender,
//			@RequestParam String no_telp, @RequestParam String password) {
//		Mhs mhs = new Mhs(id_mhs, npm, jurusan, kelas, nama_mhs, tempat_lahir, tgl_lahir, alamat_mhs, agama_mhs, gender, no_telp,
//				password);
//		mhsService.save(mhs);
//		return "redirect:/all-mhs";
//	}

	@GetMapping("/update-mhs")
	public String updateMhs(@RequestParam int id_mhs, HttpServletRequest request) {
		request.setAttribute("mhs", mhsService.findMhs(id_mhs));
		request.setAttribute("jurusans", jurusanService.findAll());
		request.setAttribute("kelass", kelasService.findAll());
		request.setAttribute("mode", "MODE_UPDATE");
		return "ubahmhs";
	}

	@GetMapping("/delete-mhs")
	public String deleteMhs(@RequestParam int id_mhs, HttpServletRequest request) {
		mhsService.delete(id_mhs);
		request.setAttribute("mhss", mhsService.findAll());
		request.setAttribute("mode", "MODE_MHS");
		return "redirect:/all-mhs";
	}

}
