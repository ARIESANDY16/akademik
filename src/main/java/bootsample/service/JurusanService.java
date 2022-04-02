package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootsample.dao.JurusanRepository;
import bootsample.model.Jurusan;

@Service
@Transactional
public class JurusanService {
	
	@Autowired
	JurusanRepository jurusanRepository;

	public JurusanService(JurusanRepository jurusanRepository) {
		this.jurusanRepository = jurusanRepository;
	}
	
	public List<Jurusan> findAll(){
		List<Jurusan> jurusans = new ArrayList<>();
		for(Jurusan jurusan : jurusanRepository.findAll()){
			jurusans.add(jurusan);
		}
		return jurusans;
	}
	
	public Jurusan findJurusan(int id_jurusan){
		return jurusanRepository.findOne(id_jurusan);
	}
	
	public void save(Jurusan jurusan){
		jurusanRepository.save(jurusan);
	}
	
	public void delete(int id_jurusan){
		jurusanRepository.delete(id_jurusan);
	}

}
