package bootsample.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="md_matkul")
public class Matkul implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_matkul;
	private String kd_matkul;
	private String nama_matkul;
	private int sks;
	@ManyToOne
	@JoinColumn(name = "id_jurusan")
	private Jurusan jurusan;
	@ManyToOne
	@JoinColumn(name = "id_kelas")
	private Kelas kelas;
	@ManyToOne
	@JoinColumn(name = "id_dosen")
	private Dosen dosen;
	
	public Matkul(){}
	
	public Matkul(int id_matkul, String kd_matkul, String nama_matkul, int sks, Jurusan jurusan, Kelas kelas, Dosen dosen) {
		super();
		this.id_matkul = id_matkul;
		this.kd_matkul = kd_matkul;
		this.nama_matkul = nama_matkul;
		this.sks = sks;
		this.jurusan = jurusan;
		this.kelas = kelas;
		this.dosen = dosen;
	}
	
//	@JoinTable(
//	        schema = "HR",
//	        name = "GROUPS",
//	        joinColumns = {@JoinColumn(table = "GROUPS", name = "GROUP_ID", insertable = false, updatable = false)},
//	        inverseJoinColumns = {@JoinColumn(table = "USERS", name = "GROUP_ID", insertable = false, updatable = false)}
//	    )
//	    @WhereJoinTable(clause = "GROUP_ACTIVE='Y'")
//	    private List<Akademik> akademik;
	
	public int getId_matkul() {
		return id_matkul;
	}

	public void setId_matkul(int id_matkul) {
		this.id_matkul = id_matkul;
	}

	public String getKd_matkul() {
		return kd_matkul;
	}

	public void setKd_matkul(String kd_matkul) {
		this.kd_matkul = kd_matkul;
	}

	public String getNama_matkul() {
		return nama_matkul;
	}

	public void setNama_matkul(String nama_matkul) {
		this.nama_matkul = nama_matkul;
	}

	public int getSks() {
		return sks;
	}

	public void setSks(int sks) {
		this.sks = sks;
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

	public Dosen getDosen() {
		return dosen;
	}

	public void setDosen(Dosen dosen) {
		this.dosen = dosen;
	}

	@Override
	public String toString() {
		return "Matkul [id_matkul=" + id_matkul + ", kd_matkul=" + kd_matkul + ", nama_matkul=" + nama_matkul +", sks=" + sks +", jurusan=" + jurusan +", kelas=" +kelas+", dosen=" +dosen +"]";
	}	
	

}