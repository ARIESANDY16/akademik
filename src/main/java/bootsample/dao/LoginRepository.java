package bootsample.dao;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {
	public Login findByUsernameAndPassword(String username, String password);

}
