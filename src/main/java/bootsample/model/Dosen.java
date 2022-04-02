package bootsample.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity(name="md_dosen")
public class Dosen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_dosen;
	private String nip;
	private String nik;
	private String nama_dosen;
	private String tl_dosen;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date tgl_dosen;
	private String alamat_dosen;
	private String agama_dosen;
	private String gender;
	private String no_telp;
	private String email;
	private String password;
	
	
	public Dosen(){}
	
	public Dosen(int id_dosen, String nip, String nik, String nama_dosen, String tl_dosen, Date tgl_dosen, String alamat_dosen,
			String agama_dosen, String gender, String no_telp,String email, String password) {
		super();
		this.id_dosen = id_dosen;
		this.nip = nip;
		this.nik = nik;
		this.nama_dosen = nama_dosen;
		this.tl_dosen = tl_dosen;
		this.tgl_dosen = tgl_dosen;
		this.alamat_dosen = alamat_dosen;
		this.agama_dosen = agama_dosen;
		this.gender = gender;
		this.no_telp = no_telp;
		this.email = email;
		this.password = password;
	}

	public int getId_dosen() {
		return id_dosen;
	}

	public void setId_dosen(int id_dosen) {
		this.id_dosen = id_dosen;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNama_dosen() {
		return nama_dosen;
	}

	public void setNama_dosen(String nama_dosen) {
		this.nama_dosen = nama_dosen;
	}

	public String getTl_dosen() {
		return tl_dosen;
	}

	public void setTl_dosen(String tl_dosen) {
		this.tl_dosen = tl_dosen;
	}

	public Date getTgl_dosen() {
		return tgl_dosen;
	}

	public void setTgl_dosen(Date tgl_dosen) {
		this.tgl_dosen = tgl_dosen;
	}

	public String getAlamat_dosen() {
		return alamat_dosen;
	}

	public void setAlamat_dosen(String alamat_dosen) {
		this.alamat_dosen = alamat_dosen;
	}

	public String getAgama_dosen() {
		return agama_dosen;
	}

	public void setAgama_dosen(String agama_dosen) {
		this.agama_dosen = agama_dosen;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNo_telp() {
		return no_telp;
	}

	public void setNo_telp(String no_telp) {
		this.no_telp = no_telp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Dosen [id_dosen=" + id_dosen + ", nip=" + nip + " , nik=" + nik + ", nama_dosen=" + nama_dosen + ", tl_dosen=" + tl_dosen + ", tgl_dosen=" + tgl_dosen + 
				", alamat_dosen=" + alamat_dosen + ", gender=" + gender + ", no_telp=" + no_telp +", email=" + email +", password=" + password +"]";
	}	
	
}
