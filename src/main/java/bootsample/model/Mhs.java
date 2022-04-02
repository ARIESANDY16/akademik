package bootsample.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;


@Entity(name="md_student")
public class Mhs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_mhs;
	private String npm;
	@ManyToOne
	@JoinColumn(name = "id_jurusan")
	private Jurusan jurusan;
	@ManyToOne
	@JoinColumn(name = "id_kelas")
	private Kelas kelas;
	private String nama_mhs;
	private String tempat_lahir;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tgl_lahir;
	private String alamat_mhs;
	private String agama_mhs;
	private String gender;
	private String no_telp;
	private String password;
	
	public Mhs(){}
	
	public Mhs(int id_mhs, String npm, Jurusan jurusan, Kelas kelas, String nama_mhs, String tempat_lahir, Date tgl_lahir, String alamat_mhs, String agama_mhs, String gender, String no_telp, String password) {
		super();
		this.id_mhs = id_mhs;
		this.npm = npm;
		this.jurusan = jurusan;
		this.kelas = kelas;
		this.nama_mhs = nama_mhs;
		this.tempat_lahir = tempat_lahir;
		this.tgl_lahir = tgl_lahir;
		this.alamat_mhs = alamat_mhs;
		this.agama_mhs = agama_mhs;
		this.gender = gender;
		this.no_telp = no_telp;
		this.password = password;
	}

	public int getId_mhs() {
		return id_mhs;
	}

	public void setId_mhs(int id_mhs) {
		this.id_mhs = id_mhs;
	}

	public String getNpm() {
		return npm;
	}

	public void setNpm(String npm) {
		this.npm = npm;
	}

	public Jurusan getJurusan() {
		return jurusan;
	}

	public void setJurusan(Jurusan jurusan) {
		this.jurusan = jurusan;
	}

	public Kelas getKelas() {
		return kelas;
	}

	public void setKelas(Kelas kelas) {
		this.kelas = kelas;
	}

	public String getNama_mhs() {
		return nama_mhs;
	}

	public void setNama_mhs(String nama_mhs) {
		this.nama_mhs = nama_mhs;
	}

	public String getTempat_lahir() {
		return tempat_lahir;
	}

	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}

	public Date getTgl_lahir() {
		return tgl_lahir;
	}

	public void setTgl_lahir(Date tgl_lahir) {
		this.tgl_lahir = tgl_lahir;
	}

	public String getAlamat_mhs() {
		return alamat_mhs;
	}

	public void setAlamat_mhs(String alamat_mhs) {
		this.alamat_mhs = alamat_mhs;
	}

	public String getAgama_mhs() {
		return agama_mhs;
	}

	public void setAgama_mhs(String agama_mhs) {
		this.agama_mhs = agama_mhs;
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
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Mhs [id_mhs=" + id_mhs + ", npm=" + npm + ", jurusan=" + jurusan + ",kelas=" + kelas + ", nama_mhs=" + nama_mhs + ", tempat_lahir=" + tempat_lahir + ", tgl_lahir=" + tgl_lahir +
				", alamat_mhs=" + alamat_mhs + ", agama_mhs=" + agama_mhs + ", gender=" + gender + ", no_telp=" + no_telp +", password=" + password +"]";
	}	
	

}