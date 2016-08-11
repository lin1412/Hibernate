package simoncomputing.app.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import simoncomputing.app.myapp.model.domain.AbuseReport;
import simoncomputing.app.myapp.model.entity.Abuse;
import simoncomputing.app.myapp.model.entity.Kudo;
import simoncomputing.app.myapp.model.entity.User;
import simoncomputing.app.myapp.model.entity.Vote;
import simoncomputing.app.myapp.service.KudoService;

@RestController
public class KudoController {

	@Autowired
	private KudoService kudoService;

	@RequestMapping(method = RequestMethod.POST, value = "/kudo")
	public ResponseEntity<Kudo> saveKudo(@RequestBody Kudo kudo) {

		kudoService.saveKudo(kudo);

		return new ResponseEntity<Kudo>(kudo, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/kudo/{kudoId}")
	public ResponseEntity<Kudo> getKudo(@PathVariable Long kudoId) {

		Kudo kudo = kudoService.getKudo(kudoId);

		return kudo == null ? new ResponseEntity<Kudo>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Kudo>(kudo, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/vote/{kudoId}")
	public ResponseEntity<Vote> addVote(@PathVariable Long kudoId) {

		Kudo kudo = kudoService.getKudo(kudoId);

		if (kudo == null) {
			return new ResponseEntity<Vote>(HttpStatus.NOT_FOUND);
		}
		Vote vote = new Vote();
		vote.setKudo(kudo);
		// use actual user once it's set up
		vote.setEntryUser(new User());
		kudoService.addVote(vote);

		return new ResponseEntity<Vote>(vote, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/report-abuse")
	public ResponseEntity<Abuse> addAbuse(@RequestBody AbuseReport abuseReport) {

		Kudo kudo = kudoService.getKudo(abuseReport.getKudoId());

		if (kudo == null) {
			return new ResponseEntity<Abuse>(HttpStatus.NOT_FOUND);
		}
		Abuse abuse = new Abuse();
		abuse.setKudo(kudo);
		abuse.setComment(abuseReport.getReason());
		// use actual user once it's set up
		abuse.setEntryUser(new User());

		kudoService.addAbuse(abuse);

		return new ResponseEntity<Abuse>(abuse, HttpStatus.OK);
	}
}
