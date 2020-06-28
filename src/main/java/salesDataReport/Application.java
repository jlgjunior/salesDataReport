package salesDataReport;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).headless(false).run(args);
	}
	
	public void run(String... args) throws Exception {
	
	}

}
