package application.dao;

import java.util.List;

public interface DAOInterface <T>{
    public List<T> getAll();

    public T selectById(String t);

    public boolean insert(T t);

    public boolean update(T t);

    public boolean delete(T t);
}