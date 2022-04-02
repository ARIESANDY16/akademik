package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootsample.dao.MatkulRepository;
import bootsample.model.Matkul;

@Service
@Transactional
public class MatkulService {
	
	@Autowired
	MatkulRepository matkulRepository;

	public MatkulService(MatkulRepository matkulRepository) {
		this.matkulRepository = matkulRepository;
	}
	
	public List<Matkul> findAll(){
		List<Matkul> matkuls = new ArrayList<>();
		for(Matkul matkul : matkulRepository.findAll()){
			matkuls.add(matkul);
		}
		return matkuls;
	}
	
	public Matkul findMatkul(int id_matkul){
		return matkulRepository.findOne(id_matkul);
	}
	
	public void save(Matkul matkul){
		matkulRepository.save(matkul);
	}
	
	public void delete(int id_matkul){
		matkulRepository.delete(id_matkul);
	}

}
