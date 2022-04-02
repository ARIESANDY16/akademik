package bootsample.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="md_kelas")
public class Kelas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_kelas;
	private String nama_kelas;
	@ManyToOne
	@JoinColumn(name = "id_jurusan")
	private Jurusan jurusan;
	
	public Kelas(){}
	
	public Kelas(int id_kelas, String nama_kelas, Jurusan jurusan) {
		super();
		this.id_kelas = id_kelas;
		this.nama_kelas = nama_kelas;
		this.jurusan = jurusan;
	}

	
	public int getId_kelas() {
		return id_kelas;
	}

	public void setId_kelas(int id_kelas) {
		this.id_kelas = id_kelas;
	}

	public String getNama_kelas() {
		return nama_kelas;
	}

	public void setNama_kelas(String nama_kelas) {
		this.nama_kelas = nama_kelas;
	}

	public Jurusan getJurusan() {
		return jurusan;
	}

	public void setJurusan(Jurusan jurusan) {
		this.jurusan = jurusan;
	}

	@Override
	public String toString() {
		return "Kelas [id_kelas=" + id_kelas + ", nama_kelas=" + nama_kelas + ", jurusan=" + jurusan +"]";
	}	
	

}