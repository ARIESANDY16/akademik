package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bootsample.dao.KelasRepository;
import bootsample.model.Kelas;

@Service
@Transactional
public class KelasService {

	private final KelasRepository kelasRepository;

	public KelasService(KelasRepository kelasRepository) {
		this.kelasRepository = kelasRepository;
	}
	
	public List<Kelas> findAll(){
		List<Kelas> kelass = new ArrayList<>();
		for(Kelas kelas : kelasRepository.findAll()){
			kelass.add(kelas);
		}
		return kelass;
	}
	
	public Kelas findKelas(int id_kelas){
		return kelasRepository.findOne(id_kelas);
	}
	
	public void save(Kelas kelas){
		kelasRepository.save(kelas);
	}
	
	public void delete(int id_kelas){
		kelasRepository.delete(id_kelas);
	}

}
