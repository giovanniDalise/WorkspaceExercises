package ese8.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDao<T>{
    List<T> read() throws IOException;
    List<T> findForName(String searchText) throws IOException;
    T create(T elemento) throws IOException;
}
