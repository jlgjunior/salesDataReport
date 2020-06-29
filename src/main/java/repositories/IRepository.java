package repositories;

import java.util.List;

public interface IRepository<T> {

	public T save(T entity);
	public List<T> findAll();
	public void clear();
}
