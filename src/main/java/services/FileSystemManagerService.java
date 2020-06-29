package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class FileSystemManagerService {

	public FileSystemManagerService() {
		
	}

	public String getHome() {
		return System.getProperty("user.home");
	}
	
	public Path combinePath(String prefix, String suffix) {
		return Paths.get(prefix, suffix);
	}
	
	public Path createDirectories(Path path) throws IOException{
		return Files.createDirectories(path);
	}

	public DirectoryStream<Path> getFilePathsIn(Path folderPath) throws IOException {
		return Files.newDirectoryStream(folderPath);
		
	}
	
	public boolean isDirectory(Path directory) {
		return Files.isDirectory(directory);
	}
	
	public boolean writeTextFile(String fileName, String data) {
		Writer writer;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
		    writer.write(data);
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void deleteFile() {
		
	}
}
