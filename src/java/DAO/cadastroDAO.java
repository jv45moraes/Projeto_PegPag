/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 * Momdelo do DAO
 * @author lino
 */
public class cadastroDAO {
    
    private Connection con;

    public FuncionarioDAO() {
        this.con = new ConexaoBancoDados().getConnection();
    }

    // método  para salvar os registros
    public void cadastrarFuncionario(Funcionario funci, Funcao func) {
        try {
    
    //Passo um - criar comando sql
    String sql = "insert into cadastro (nome, cpf, rg, dataNascimento, telefone, sexo, endereco, email)"
            + value ("?, ?, ?, ?, ?, ?, ?");
    
    //Passo dois - conectar o banco de dados e organizar o comando sql
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, funci.getNome());
            stmt.setString(2, funci.getCpf());
            stmt.setString(3, funci.getRg());
            stmt.setString(4, funci.getDataNascimento());
            stmt.setString(5, funci.getTelefone());
            stmt.setString(6, funci.getSexo());
            stmt.setString(7, funci.getEndereco());
            stmt.setString(8, funci.getEmail());
            
    //Terceiro  passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + erro);

        }}
    
    
}
