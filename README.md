# Loja de Games
Criação de uma Loja de Games - Backend com Spring para o Bootcamp da Generation patrocinado pela Microsoft - T75.

## Etapas:
1. Criação do Projeto no Spring Initialz;
2. Configuração do arquivo application.properties para criar e acessar o Banco de dados MySQL denominado db_games;
3. Execução da aplicação no STS e verificação da criação do banco de dados no no MySQL Workbench;
4. Criação da Classe Model Produto, Classe Model Categoria e dos seus atributos necessários, incluindo os Métodos Get e Set, e as Anotações;
5. Execução da aplicação no STS e verificação de criação da tabela tb_produtos e tb_categorias no db_games do MySQL Workbench.
6. Criação das Interfaces Repository denominada ProdutoRepository e CategoriaRepository;
7. Criação do Método de Busca Específica, findAllByTituloContainingIgnoreCase(), na Interface ProdutoRepository;
8. Criação do Método de Busca Específica, findAllByGeneroContainingIgnoreCase(), na Interface CategoriaRepository;
9. Criação das Classes Controller denominada ProdutoController e CategoriaController;
10. Criação do endpoint, Método getAll() na Classe ProdutoController e CategoriaController;
11. Criação dos Métodos do CRUD na Classe ProdutoController: getById(), getByTitulo(), post(), put() e delete();
12. Criação dos Métodos do CRUD na Classe CategoriaController: getById(), getByGenero(), post(), put() e delete();
13. Inserção de dados manualmente na tabela através do MySQL Workbench;
14. Criação da Relação OneToMany na Classe Model Categoria com a Classe Model Produto, incluindo os Métodos Get e Set, e as Anotações, incluindo a @JsonIgnoreProperties para inibir a Recursividade no relacionamento;
15. Criação da Relação ManyToOne na Classe Model Produto com a Classe Model Categoria, incluindo os Métodos Get e Set, e as Anotações, incluindo a @JsonIgnoreProperties para inibir a Recursividade no relacionamento;
16. Teste dos métodos através do Insomnia.
