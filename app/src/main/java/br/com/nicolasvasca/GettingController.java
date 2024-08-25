package br.com.nicolasvasca;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GettingController {
	
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/getting")
	public Getting getting(@RequestParam(value= "name", defaultValue= "World") String name) {
		return new Getting(counter.incrementAndGet(), String.format(template, name));
	};

}
