package equipes;

import java.util.UUID;

public class Equipe {
    private String id;
    private String nome;
    private String cidade;
    private int anoDeCriacao;

    // Necessário para o Jackson montar o objeto a partir do JSON
    public Equipe() {
        this.id = UUID.randomUUID().toString();
    }

    public Equipe(String id, String nome, String cidade, int anoDeCriacao) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.anoDeCriacao = anoDeCriacao;
    }

    public Equipe(String nome, String cidade, int anoDeCriacao) {
        this(UUID.randomUUID().toString(), nome, cidade, anoDeCriacao);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public int getAnoDeCriacao() { return anoDeCriacao; }
    public void setAnoDeCriacao(int anoDeCriacao) { this.anoDeCriacao = anoDeCriacao; }
}
