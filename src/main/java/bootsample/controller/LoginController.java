package bootsample.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.dao.DosenRepository;
import bootsample.dao.MhsRepository;
import bootsample.model.Dosen;
import bootsample.model.Login;
import bootsample.model.Mhs;
import bootsample.service.LoginService;

@Controller
//@RequestMapping("/login")
public class LoginController {
	
	
	@Autowired
	MhsRepository mhsRepo;
	
	@Autowired
	DosenRepository dosenRepo;
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/home", method= RequestMethod.GET)
	public String homePage(HttpServletRequest request) {
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method= RequestMethod.GET)
	public String loginPage(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public String login(ModelMap model, @RequestParam String username, String password, HttpSession session) {
		Mhs mhs = mhsRepo.findByNpm(username);
		
		
		int id_mhs = mhs.getId_mhs();
		String npm_mhs = mhs.getNpm();
		int id_jurusan = mhs.getJurusan().getId_jurusan();
		int id_kelas = mhs.getKelas().getId_kelas();
		String nama_mhs = mhs.getNama_mhs();
		String tempat_lahir = mhs.getTempat_lahir();
		Date tgl_lahir = mhs.getTgl_lahir();
		String alamat_mhs = mhs.getAlamat_mhs();
		String agama_mhs = mhs.getAgama_mhs();
		String gender = mhs.getGender();
		String no_telp = mhs.getNo_telp();
		String password_mhs = mhs.getPassword();
		
		if(!username.equalsIgnoreCase(npm_mhs))
		{
				model.put("error", "Username tidak terdaftar");
				return "login";
		}
		else if(username.equalsIgnoreCase(npm_mhs) && password.equalsIgnoreCase(password_mhs)) {
		session.setAttribute("id_mhs", id_mhs);
		session.setAttribute("npm_mhs", npm_mhs);
		session.setAttribute("id_jurusan", id_jurusan);
		session.setAttribute("id_kelas", id_kelas);
		session.setAttribute("nama_mhs", nama_mhs);
		session.setAttribute("tempat_lahir", tempat_lahir);
		session.setAttribute("tgl_lahir", tgl_lahir);
		session.setAttribute("alamat_mhs", alamat_mhs);
		session.setAttribute("agama_mhs", agama_mhs);
		session.setAttribute("gender", gender);
		session.setAttribute("no_telp", no_telp);
		session.setAttribute("password_mhs", password_mhs);
		return "redirect:/mhs_dashboard";
		
		}
		
		else {
			model.put("error", "Gagal. Username atau password salah!");
			return "login";
		}
		
	}
	
	@RequestMapping(value = "/dosen-login", method= RequestMethod.GET)
	public String dosenlogin(ModelMap model) {
		return "d_login";
	}
	
	@RequestMapping(value = "/dosen-login", method= RequestMethod.POST)
	public String dosenlogin(ModelMap model, @RequestParam String username, String password, HttpSession session) {
		Dosen dosen = dosenRepo.findByNip(username);
		
		int id_dosen = dosen.getId_dosen();
		String nip_dosen = dosen.getNip();
		String nik_dosen = dosen.getNik();
		String nama_dosen = dosen.getNama_dosen();
		String tl_dosen = dosen.getTl_dosen();
		Date tgl_dosen = dosen.getTgl_dosen();
		String alamat_dosen = dosen.getAlamat_dosen();
		String agama_dosen = dosen.getAgama_dosen();
		String gender_dosen = dosen.getGender();
		String no_telp_dosen = dosen.getNo_telp();
		String email = dosen.getEmail();
		String password_dosen = dosen.getPassword();
		
		if(username.equalsIgnoreCase(nip_dosen) && password.equalsIgnoreCase(password_dosen)) {
		session.setAttribute("id_dosen", id_dosen);
		session.setAttribute("nip_dosen", nip_dosen);
		session.setAttribute("nik_dosen", nik_dosen);
		session.setAttribute("nama_dosen", nama_dosen);
		session.setAttribute("tl_dosen", tl_dosen);
		session.setAttribute("tgl_dosen", tgl_dosen);
		session.setAttribute("alamat_dosen", alamat_dosen);
		session.setAttribute("agama_dosen", agama_dosen);
		session.setAttribute("gender", gender_dosen);
		session.setAttribute("no_telp", no_telp_dosen);
		session.setAttribute("email", email);
		session.setAttribute("password_dosen", password_dosen);
		
		return "redirect:/dosen-dashboard";
		
		}else {
			model.put("error", "Gagal. Username atau password salah!");
			return "d_login";
		}
	}
	
	@RequestMapping(value = "/logout", method= RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/d_logout", method= RequestMethod.GET)
	public String dosenlogout(HttpSession session) {
		session.invalidate();
		return "redirect:/dosen-login";
	}
	
	@RequestMapping("/admin-login")
	public String loginadmin(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "a_login";
	}
	
	@RequestMapping("/dashboard")
	public String loginadmin(@ModelAttribute Login login, HttpServletRequest request) {
		if(loginService.findByUsernameAndPassword(login.getUsername(), login.getPassword())!=null) {
			request.setAttribute("mode", "MODE_LOGIN");
			return "dashboard";
		}
		else {
			request.setAttribute("error", "Invalid username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "a_login";
		}
		
	}
	
	@RequestMapping(value = "/a_logout", method= RequestMethod.GET)
	public String adminlogout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin-login";
	}
}
