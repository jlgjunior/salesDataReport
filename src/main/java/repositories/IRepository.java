package repositories;

import java.util.SortedSet;


public interface IRepository<T> {

	public T save(T entity);
	public SortedSet<T> findAll();
	public void clear();
}
