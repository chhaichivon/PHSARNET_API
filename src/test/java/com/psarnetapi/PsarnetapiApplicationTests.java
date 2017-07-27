package com.psarnetapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.psarnet.api.PsarnetapiApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PsarnetapiApplication.class)
@WebAppConfiguration
public class PsarnetapiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
