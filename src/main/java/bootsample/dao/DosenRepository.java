package bootsample.dao;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.Dosen;

public interface DosenRepository extends CrudRepository<Dosen, Integer>{
	Dosen findByNip(String nip);
	Dosen findByNik(String nik);

}
