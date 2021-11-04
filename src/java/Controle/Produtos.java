/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhess
 */
@Entity
@Table(name = "produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p")
    , @NamedQuery(name = "Produtos.findByIdprodutos", query = "SELECT p FROM Produtos p WHERE p.idprodutos = :idprodutos")
    , @NamedQuery(name = "Produtos.findByTitulo", query = "SELECT p FROM Produtos p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Produtos.findByDescricao", query = "SELECT p FROM Produtos p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Produtos.findByTamanho", query = "SELECT p FROM Produtos p WHERE p.tamanho = :tamanho")
    , @NamedQuery(name = "Produtos.findByCor", query = "SELECT p FROM Produtos p WHERE p.cor = :cor")
    , @NamedQuery(name = "Produtos.findBySabor", query = "SELECT p FROM Produtos p WHERE p.sabor = :sabor")
    , @NamedQuery(name = "Produtos.findByEstoque", query = "SELECT p FROM Produtos p WHERE p.estoque = :estoque")
    , @NamedQuery(name = "Produtos.findByTipo", query = "SELECT p FROM Produtos p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Produtos.findByPreco", query = "SELECT p FROM Produtos p WHERE p.preco = :preco")})
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprodutos")
    private Integer idprodutos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "tamanho")
    private String tamanho;
    @Size(max = 45)
    @Column(name = "cor")
    private String cor;
    @Size(max = 45)
    @Column(name = "sabor")
    private String sabor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estoque")
    private int estoque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco")
    private double preco;
    @JoinColumn(name = "comercio_idcomercio", referencedColumnName = "idcomercio")
    @ManyToOne(optional = false)
    private Comercio comercioIdcomercio;
    

    public Produtos() {
    }

    public Produtos(Integer idprodutos) {
        this.idprodutos = idprodutos;
    }

    public Produtos(Integer idprodutos, String titulo, String descricao, int estoque, String tipo, double preco) {
        this.idprodutos = idprodutos;
        this.titulo = titulo;
        this.descricao = descricao;
        this.estoque = estoque;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Integer getIdprodutos() {
        return idprodutos;
    }

    public void setIdprodutos(Integer idprodutos) {
        this.idprodutos = idprodutos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Comercio getComercioIdcomercio() {
        return comercioIdcomercio;
    }

    public void setComercioIdcomercio(Comercio comercioIdcomercio) {
        this.comercioIdcomercio = comercioIdcomercio;
    }

    

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprodutos != null ? idprodutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.idprodutos == null && other.idprodutos != null) || (this.idprodutos != null && !this.idprodutos.equals(other.idprodutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controle.Produtos[ idprodutos=" + idprodutos + " ]";
    }
    
}
