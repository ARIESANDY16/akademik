package bootsample.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="md_jurusan")
public class Jurusan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_jurusan;
	private String kd_jurusan;
	private String nama;
	
	public Jurusan(){}
	
	public Jurusan(int id_jurusan, String kd_jurusan, String nama) {
		super();
		this.id_jurusan = id_jurusan;
		this.kd_jurusan = kd_jurusan;
		this.nama = nama;
	}


	public int getId_jurusan() {
		return id_jurusan;
	}

	public void setId_jurusan(int id_jurusan) {
		this.id_jurusan = id_jurusan;
	}

	public String getKd_jurusan() {
		return kd_jurusan;
	}

	public void setKd_jurusan(String kd_jurusan) {
		this.kd_jurusan = kd_jurusan;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Override
	public String toString() {
		return "Jurusan [id_jurusan=" + id_jurusan + ", kd_jurusan=" + kd_jurusan + ", nama=" + nama +"]";
	}	
	

}