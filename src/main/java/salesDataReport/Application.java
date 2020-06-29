package salesDataReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;

import services.FileWatcherService;

public class Application {
	@Autowired
	FileWatcherService fileWatcherService;
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).headless(false).run(args);
	}
	
	public void run(String... args) throws Exception {
		fileWatcherService.watch();
	}

}
