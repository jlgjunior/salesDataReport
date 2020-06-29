package repositories;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.Report;
import services.FileSystemManagerService;

@Repository
public class ReportRepository implements IRepository<Report> {

	@Autowired
	private FileSystemManagerService fileSystemManagerService;
	
	@Override
	public Report save(Report entity) {
		return entity;
	}

	public Report saveToFile(Report entity, String filename) {
		String data = entity.toString();
		String format = "yyyyMMddHHmmssSSS'.txt'";
		filename += new SimpleDateFormat(format).format(new Date());
		Path fileFullPath = fileSystemManagerService
									.getOutputFolder();
		fileFullPath = fileSystemManagerService
				            .combinePath(fileFullPath.toString(), filename);
		fileSystemManagerService
		        .writeTextFile(fileFullPath.toString(), data);
		return save(entity);
		
	}
	
	@Override
	public SortedSet<Report> findAll() {
		return null;
	}

	@Override
	public void clear() {
		
	}

}
