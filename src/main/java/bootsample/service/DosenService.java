package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootsample.dao.DosenRepository;
import bootsample.model.Dosen;

@Service
@Transactional
public class DosenService {
	
	@Autowired
	DosenRepository dosenRepository;

	public DosenService(DosenRepository dosenRepository) {
		this.dosenRepository = dosenRepository;
	}
	
	public List<Dosen> findAll(){
		List<Dosen> dosens = new ArrayList<>();
		for(Dosen dosen : dosenRepository.findAll()){
			dosens.add(dosen);
		}
		return dosens;
	}
	
	public Dosen findDosen(int id_dosen){
		return dosenRepository.findOne(id_dosen);
	}
	
	public void save(Dosen dosen){
		dosenRepository.save(dosen);
	}
	
	public String saves(Dosen dosen) {
		Dosen nip = dosenRepository.findByNip(dosen.getNip());
		Dosen nik = dosenRepository.findByNik(dosen.getNik());
		if (nip != null) {
			return "redirect:/new-dosen";

		} else if (nik != null) {
			return "redirect:/new-dosen";
		} else {
			dosenRepository.save(dosen);
			return "redirect:/all-dosen";
		}
	}
	
	public void delete(int id_dosen){
		dosenRepository.delete(id_dosen);
	}
	
	
}
