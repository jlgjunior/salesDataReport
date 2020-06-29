package repositories;

import java.util.SortedSet;


public interface IRepository<T> {

	public T save(T entity);
	public T saveToFile(T entity, String fileName);
	public SortedSet<T> findAll();
	public void reset();
}
