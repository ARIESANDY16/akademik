package bootsample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import bootsample.model.Akademik;
import bootsample.model.Matkul;
import bootsample.model.Values;

public interface AkademikRepository extends CrudRepository<Akademik, Integer>{
	
//	Akademik findByNpm(String npm);
//	
//	@Query(value= "select * from master_mhs a join master_kelas b on b.id_kelas=a.id_kelas join master_matkul c on c.id_kelas=a.id_kelas join akademik d on d.id_matkul=c.id_matkul where c.id_matkul =)
//	List<Listakademik> findByIdMatkul(@Param("id_matkul") int id_matkul);
	
	@Query(value = "SELECT ak.grade, mk.sks FROM trx_akademik ak JOIN md_matkul mk ON mk.id_matkul = ak.id_matkul WHERE ak.id_mhs = ?1", nativeQuery = true)
	List<Values> findValues(String npm);
	
	Akademik findByMatkul(Matkul matkul);
}
