package simoncomputing.app.myapp.service.reference;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import simoncomputing.app.myapp.model.entity.reference.RefRole;

public interface ReferenceService {

	public Map<String, List<? extends Serializable>> getRefEntities(List<String> entityNames);

	public RefRole getRole(String code);

	public List<RefRole> getAllRoles();

}
