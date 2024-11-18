package ese7.dao;

import ese7.dto.Spesa;

import java.io.IOException;
import java.util.List;

public interface IDao<T> {
    T create(T elemento) throws IOException;
    List<T> read()throws IOException;
    List<T> findForType(String searchText)throws IOException;

    List<T> findForLocation(String searchText)throws IOException;
}
