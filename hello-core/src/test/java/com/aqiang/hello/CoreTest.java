package com.aqiang.hello;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

@ContextConfiguration(locations = { "classpath:beans.xml", "classpath:beans-jpa-h2.xml" })
public class CoreTest extends AbstractTransactionalTestNGSpringContextTests {
}
