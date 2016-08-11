package simoncomputing.app.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simoncomputing.app.myapp.model.entity.Abuse;
import simoncomputing.app.myapp.model.entity.Kudo;
import simoncomputing.app.myapp.model.entity.Vote;
import simoncomputing.app.myapp.repository.AbuseRepository;
import simoncomputing.app.myapp.repository.KudoRepository;
import simoncomputing.app.myapp.repository.VoteRepository;

@Service
public class KudoServiceImpl implements KudoService {

	@Autowired
	KudoRepository kudoRepository;
	@Autowired
	VoteRepository voteRepository;
	@Autowired
	AbuseRepository abuseRepository;

	@Override
	public void saveKudo(Kudo kudo) {
		kudoRepository.save(kudo);
	}

	@Override
	public Kudo getKudo(Long kudoId) {
		return kudoRepository.findOneByKudoId(kudoId);
	}

	@Override
	public void addVote(Vote vote) {
		voteRepository.save(vote);
	}

	@Override
	public void addAbuse(Abuse abuse) {
		abuseRepository.save(abuse);
	}

}
