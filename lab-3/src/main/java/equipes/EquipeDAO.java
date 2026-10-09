package equipes;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO implements IDAO<Equipe> {

    @Override
    public void salvar(Equipe equipe) {
        String sql = "INSERT INTO equipe (id, nome, cidade, ano_de_criacao) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, equipe.getId());
            ps.setString(2, equipe.getNome());
            ps.setString(3, equipe.getCidade());
            ps.setInt(4, equipe.getAnoDeCriacao());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar equipe", e);
        }
    }

    @Override
    public List<Equipe> listar() {
        String sql = "SELECT id, nome, cidade, ano_de_criacao FROM equipe ORDER BY nome";
        List<Equipe> equipes = new ArrayList<>();
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                equipes.add(new Equipe(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("cidade"),
                        rs.getInt("ano_de_criacao")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar equipes", e);
        }
        return equipes;
    }

    public Equipe buscarPorId(String id) {
        String sql = "SELECT id, nome, cidade, ano_de_criacao FROM equipe WHERE id = ?";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Equipe(
                            rs.getString("id"),
                            rs.getString("nome"),
                            rs.getString("cidade"),
                            rs.getInt("ano_de_criacao"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar equipe", e);
        }
        return null;
    }

    @Override
    public void atualizar(String id, Equipe equipe) {
        String sql = "UPDATE equipe SET nome = ?, cidade = ?, ano_de_criacao = ? WHERE id = ?";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, equipe.getNome());
            ps.setString(2, equipe.getCidade());
            ps.setInt(3, equipe.getAnoDeCriacao());
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar equipe", e);
        }
    }

    @Override
    public void deletar(String id) {
        String sql = "DELETE FROM equipe WHERE id = ?";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar equipe", e);
        }
    }
}
