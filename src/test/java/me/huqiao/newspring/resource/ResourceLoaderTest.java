package me.huqiao.newspring.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;

public class ResourceLoaderTest {

	@Test
	public void testResourceLoader() throws IOException {
		DefaultResourceLoader loader = new DefaultResourceLoader();
		InputStream is = loader.getResource("classpath:application.properties").getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = br.readLine();
		while(line!=null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
}
