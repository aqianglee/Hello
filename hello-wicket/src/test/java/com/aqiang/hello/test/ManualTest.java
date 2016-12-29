package com.aqiang.hello.test;

import com.ttdev.wicketpagetest.WebAppJettyConfiguration;
import com.ttdev.wicketpagetest.WicketAppJettyLauncher;

public class ManualTest {
	public static void main(String[] args) throws Exception {
		WicketAppJettyLauncher launcher = new WicketAppJettyLauncher();
		WebAppJettyConfiguration cfg = new WebAppJettyConfiguration();
		launcher.startAppInJetty(cfg);
	}
}
