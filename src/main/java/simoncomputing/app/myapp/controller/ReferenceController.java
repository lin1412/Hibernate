package simoncomputing.app.myapp.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import simoncomputing.app.myapp.service.reference.ReferenceService;

@RestController
public class ReferenceController {
	@Autowired
	private ReferenceService referenceService;

	@RequestMapping(method = RequestMethod.GET, value = "/reference")
	public Map<String, List<? extends Serializable>> getRefEntities(
			@RequestParam(value = "names", required = true) List<String> entityNames) {

		return referenceService.getRefEntities(entityNames);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public String getTest() {
		System.out.println("Hello");
		return "Hello";
	}

}
