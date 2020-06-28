package services;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileWatcherService {
	
	@Autowired
	DataImporterService dataImporterService;
	private Path monitoredFolder;
	private WatchService watchService;
	
	
	public FileWatcherService() {
		String home = System.getProperty("user.home");
		monitoredFolder = Paths.get(home, "in");
		try {
			Files.createDirectories(monitoredFolder);
			watchService = FileSystems.getDefault().newWatchService();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("System initialization error due to"
					+ " I/O exception with Operational System watcher "
					+ "service");
		}
	}
	
	public void watch() throws IOException {
		processCurrentFiles();
		while(true) {
			WatchKey watchKey;
			try {
				watchKey = monitoredFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
				while ((watchKey = watchService.take()) != null) {
					for (WatchEvent<?> event : watchKey.pollEvents()) {
						String filepath = event.context().toString();
						dataImporterService.importDataFromFile(filepath);
					}
					watchKey.reset();
				}
			} catch (IOException|InterruptedException e) {
					e.printStackTrace();
			}
		}	
	}

	private void processCurrentFiles() throws IOException {
		DirectoryStream<Path> stream = Files.newDirectoryStream(monitoredFolder);
	    for (Path path : stream) {
	    	if (!Files.isDirectory(path)) {
	    		dataImporterService.importDataFromFile(path.toString());
	        }
	    }	
	}
}
