package simoncomputing.app.myapp.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import simoncomputing.app.myapp.model.entity.Kudo;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class KudoServiceIT {

	@Autowired
	private KudoService kudoService;

	@Test
	public void test() {

		Kudo kudo = new Kudo();

		kudoService.saveKudo(kudo);

		assertNotNull(kudo.getKudoId());
	}

}
