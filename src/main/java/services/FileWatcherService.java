package services;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileWatcherService {
	
	@Autowired
	ReportService reportService;
	@Autowired
	FileSystemManagerService fileSystemManagerService;
	private WatchService watchService;
	
	
	public FileWatcherService() {
		watchService = getDefaultWatcher();
	}
	
	private WatchService getDefaultWatcher() {
		try {
			return FileSystems.getDefault().newWatchService();
		}
		catch (IOException e) {
				e.printStackTrace();
				System.out.println("System initialization error due to"
						+ " I/O exception with Operational System watcher "
						+ "service. error in filewatcher");
		}
		return null;
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
						reportService.generateReport(filepath);
					}
					watchKey.reset();
				}
			} catch (IOException|InterruptedException e) {
					e.printStackTrace();
			}
		}	
	}

	private void processCurrentFiles() throws IOException {
		for (Path path : fileSystemManagerService.getFilePathsIn(monitoredFolder)) {
	    	if (!fileSystemManagerService.isDirectory(path)) {
	    		reportService.generateReport(path.toString());
	        }
	    }	
	}
}
