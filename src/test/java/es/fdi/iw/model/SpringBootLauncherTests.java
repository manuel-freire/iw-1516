package es.fdi.iw.model;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.fdi.iw.SpringBootLauncher;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringBootLauncher.class)
@WebAppConfiguration
public class SpringBootLauncherTests {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testHome() throws Exception {
		this.mvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void testBadBook() throws Exception {
		this.mvc.perform(get("/book/100000")).andExpect(status().isNotFound());
	}

	@Test
	public void testGoodBook() throws Exception {
		this.mvc.perform(get("/book/1")).andExpect(status().isOk());
	}
}
