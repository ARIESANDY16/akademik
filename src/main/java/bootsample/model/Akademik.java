package bootsample.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="trx_akademik")
public class Akademik implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_akademik;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_mhs")
	private Mhs mhs;
	@ManyToOne
	@JoinColumn(name = "id_matkul")
	private Matkul matkul;
	@ManyToOne
	@JoinColumn(name = "id_dosen")
	private Dosen dosen;
	private int quiz;
	private int uts;
	private int uas;
	private String grade;
	
	public Akademik(){}
	
	public Akademik(int id_akademik, Mhs mhs, Matkul matkul, Dosen dosen, int quiz, int uts, int uas, String grade) {
		super();
		this.id_akademik = id_akademik;
		this.mhs = mhs;
		this.matkul = matkul;
		this.dosen = dosen;
		this.quiz = quiz;
		this.uts = uts;
		this.uas = uas;
		this.grade = grade;
	}
	
	
	public int getId_akademik() {
		return id_akademik;
	}

	public void setId_akademik(int id_akademik) {
		this.id_akademik = id_akademik;
	}

	public Mhs getMhs() {
		return mhs;
	}

	public void setMhs(Mhs mhs) {
		this.mhs = mhs;
	}

	public Matkul getMatkul() {
		return matkul;
	}

	public void setMatkul(Matkul matkul) {
		this.matkul = matkul;
	}

	public Dosen getDosen() {
		return dosen;
	}

	public void setDosen(Dosen dosen) {
		this.dosen = dosen;
	}

	public int getQuiz() {
		return quiz;
	}

	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}

	public int getUts() {
		return uts;
	}

	public void setUts(int uts) {
		this.uts = uts;
	}

	public int getUas() {
		return uas;
	}

	public void setUas(int uas) {
		this.uas = uas;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Akademik [id_akademik=" + id_akademik + ", mhs=" + mhs + ", matkul=" + matkul + ", dosen=" + dosen + ", quiz=" + quiz + " , uts=" + uts + " , uas=" + uas + ", grade =" +grade+"]";
	}	
	

}