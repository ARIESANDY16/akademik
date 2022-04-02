package bootsample.dao;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.Mhs;

public interface MhsRepository extends CrudRepository<Mhs, Integer>{
	
	Mhs findByNpm(String npm);
	

}
