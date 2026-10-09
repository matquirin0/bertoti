package equipes;

import java.util.List;

public interface IDAO<T> {
    void salvar(T t);
    List<T> listar();
    void deletar(String id);
    void atualizar(String id, T t);
}