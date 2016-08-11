package simoncomputing.app.myapp.service.reference;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simoncomputing.app.myapp.model.entity.reference.RefRole;
import simoncomputing.app.myapp.repository.reference.RoleRepository;

@Service
public class ReferenceServiceImpl implements ReferenceService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Map<String, List<? extends Serializable>> getRefEntities(List<String> entityNames) {
		Map<String, List<? extends Serializable>> resultMap = new HashMap<String, List<? extends Serializable>>();

		for (String name : entityNames) {
			switch (name) {
			case "REF_ROLE":
				resultMap.put("REF_ROLE", getAllRoles());
				break;
			}
		}
		return resultMap;
	}

	@Override
	public RefRole getRole(String code) {
		return roleRepository.findOne(code);
	}

	@Override
	public List<RefRole> getAllRoles() {
		return roleRepository.findAll();
	}

}
