package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootsample.dao.MhsRepository;
import bootsample.model.Mhs;

@Service
@Transactional
public class MhsService {

	@Autowired
	MhsRepository mhsRepository;

	public MhsService(MhsRepository mhsRepository) {
		this.mhsRepository = mhsRepository;
	}

	public List<Mhs> findAll() {
		List<Mhs> mhss = new ArrayList<>();
		for (Mhs mhs : mhsRepository.findAll()) {
			mhss.add(mhs);
		}
		return mhss;
	}

	public Mhs findMhs(int id_mhs) {
		return mhsRepository.findOne(id_mhs);
	}

	public void save(Mhs mhs) {
		mhsRepository.save(mhs);
	}

	public String saves(Mhs mhs) {
		Mhs npm = mhsRepository.findByNpm(mhs.getNpm());
		if (npm != null) {
			return "redirect:/new-mhs";

		} else {
			mhsRepository.save(mhs);
			return "redirect:/all-mhs";
		}
	}

	public void delete(int id_mhs) {
		mhsRepository.delete(id_mhs);
	}

}
