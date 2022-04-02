package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bootsample.dao.RoleRepository;
import bootsample.model.Role;

@Service
@Transactional
public class RoleService {

	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public List<Role> findAll(){
		List<Role> roles = new ArrayList<>();
		for(Role role : roleRepository.findAll()){
			roles.add(role);
		}
		return roles;
	}
	
	public Role findRole(int role_id){
		return roleRepository.findOne(role_id);
	}
	
	public void save(Role role){
		roleRepository.save(role);
	}
	
	public void delete(int role_id){
		roleRepository.delete(role_id);
	}
}
