package simoncomputing.app.myapp.service;

import simoncomputing.app.myapp.model.entity.Abuse;
import simoncomputing.app.myapp.model.entity.Kudo;
import simoncomputing.app.myapp.model.entity.Vote;

public interface KudoService {

	public void saveKudo(Kudo kudo);

	public Kudo getKudo(Long kudoId);

	public void addVote(Vote vote);

	public void addAbuse(Abuse abuse);

}
