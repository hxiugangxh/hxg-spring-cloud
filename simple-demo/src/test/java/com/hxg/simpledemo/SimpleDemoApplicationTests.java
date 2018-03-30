package com.hxg.simpledemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/*@TestPropertySource("classpath:application-test.yml")*/
@Profile("test")
public class SimpleDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
