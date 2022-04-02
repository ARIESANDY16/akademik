package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bootsample.dao.AkademikRepository;
import bootsample.model.Akademik;
import bootsample.model.Values;

@Service
@Transactional
public class AkademikService {

	private final AkademikRepository akademikRepository;
	String grade = "";

	public AkademikService(AkademikRepository akademikRepository) {
		this.akademikRepository = akademikRepository;
	}

	public List<Akademik> findAll() {
		List<Akademik> akademiks = new ArrayList<>();
		for (Akademik akademik : akademikRepository.findAll()) {
			akademiks.add(akademik);
		}

		return akademiks;

	}

	public float ipk(String npm) {
		List<Values> values = akademikRepository.findValues(npm);
		int nilai = 0;
		int sks = 0;
		int total = 0;
		int totalnilai;
		
		for(Values value : values) {
			if (value.getGrade().equals("A")) {
				nilai = 4;
			} else if (value.getGrade().equals("B")) {
				nilai = 3;
			} else if (value.getGrade().equals("C")) {
				nilai = 2;
			} else if (value.getGrade().equals("D")) {
				nilai = 1;
			} else {
				nilai = 0;
			}
			totalnilai = nilai*value.getSks();
			total = total + totalnilai;
			sks = sks + value.getSks();
		}
		
		float hasil = total / sks;
		return hasil;
	}

	public Akademik findAkademik(int id_akademik) {
		return akademikRepository.findOne(id_akademik);
	}

//	public Akademik findAkademik(String npm){
//		return akademikRepository.findByNpm(npm);
//	}

	public void save(Akademik akademik) {
		if ((akademik.getQuiz() + akademik.getUts() + akademik.getUas()) / 3 >= 90) {
			grade = "A";
			akademik.setGrade(grade);
		} else if ((akademik.getQuiz() + akademik.getUts() + akademik.getUas()) / 3 >= 80) {
			grade = "B";
			akademik.setGrade(grade);
		} else if ((akademik.getQuiz() + akademik.getUts() + akademik.getUas()) / 3 >= 70) {
			grade = "C";
			akademik.setGrade(grade);
		} else if ((akademik.getQuiz() + akademik.getUts() + akademik.getUas()) / 3 >= 60) {
			grade = "D";
			akademik.setGrade(grade);
		} else {
			grade = "E";
			akademik.setGrade(grade);
		}

		akademikRepository.save(akademik);
	}
	
	public String saves(Akademik akademik) {
		Akademik matkul = akademikRepository.findByMatkul(akademik.getMatkul());
		if (matkul != null) {
			return "redirect:/krs";

		} else {
			akademikRepository.save(akademik);
			return "redirect:/all-krs";
		}
	}

	public void delete(int id_akademik) {
		akademikRepository.delete(id_akademik);
	}

}
