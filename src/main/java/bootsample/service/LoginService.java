package bootsample.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootsample.dao.DosenRepository;
import bootsample.dao.LoginRepository;
import bootsample.dao.MhsRepository;
import bootsample.dao.RoleRepository;
import bootsample.model.Login;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	MhsRepository mhsRepo;
	
	@Autowired
	DosenRepository dosenRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	/*
	 * public Boolean login(String npm, String nip, String password){ Mhs mhs =
	 * mhsRepo.findByNpm(npm); Dosen dosen = dosenRepo.findByNip(nip);
	 * 
	 * String npm_mhs = mhs.getNpm(); int id_kelas = mhs.getKelas().getId_kelas();
	 * String nama_mhs = mhs.getNama_mhs(); String tempat_lahir =
	 * mhs.getTempat_lahir(); String tgl_lahir = mhs.getTgl_lahir(); String
	 * alamat_mhs = mhs.getAlamat_mhs(); String agama_mhs = mhs.getAgama_mhs();
	 * String jk_mhs = mhs.getJk_mhs(); String no_telp = mhs.getNo_telp(); int
	 * role_mhs = mhs.getRole().getRole_id(); String password_mhs =
	 * mhs.getPassword();
	 * 
	 * String nip_dosen = dosen.getNip(); String nama_dosen = dosen.getNama_dosen();
	 * String tl_dosen = dosen.getTl_dosen(); String tgl_dosen =
	 * dosen.getTgl_dosen(); String alamat_dosen = dosen.getAlamat_dosen(); String
	 * agama_dosen = dosen.getAgama_dosen(); String jk_dosen = dosen.getJk_dosen();
	 * String no_telp_dosen = dosen.getNo_telp(); int role_dosen =
	 * dosen.getRole().getRole_id(); String password_dosen = dosen.getPassword(); }
	 */
	
	
	private LoginRepository loginRepository;
	
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	public Login findByUsernameAndPassword(String username, String password) {
		return loginRepository.findByUsernameAndPassword(username, password);
	}
	

}
