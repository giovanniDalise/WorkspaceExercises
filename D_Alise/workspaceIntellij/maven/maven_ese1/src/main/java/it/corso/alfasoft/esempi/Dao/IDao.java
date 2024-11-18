package it.corso.alfasoft.esempi.Dao;

import java.io.IOException;
import java.util.List;

public interface IDao<T,I>{
    T create(T t) throws IOException;
    List<T> read()throws IOException;
    List<T> findByTitle(I element)throws IOException;
    void delete(I element)throws IOException;
    void update(T t)throws IOException;
}
