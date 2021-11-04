/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;

import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author jhess
 */
@Entity
@Table(name = "comercio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comercio.findAll", query = "SELECT c FROM Comercio c")
    , @NamedQuery(name = "Comercio.findByIdcomercio", query = "SELECT c FROM Comercio c WHERE c.idcomercio = :idcomercio")
    , @NamedQuery(name = "Comercio.findByNomeEmpresa", query = "SELECT c FROM Comercio c WHERE c.nomeEmpresa = :nomeEmpresa")
    , @NamedQuery(name = "Comercio.findByTipoProdutos", query = "SELECT c FROM Comercio c WHERE c.tipoProdutos = :tipoProdutos")
    , @NamedQuery(name = "Comercio.findByEndereco", query = "SELECT c FROM Comercio c WHERE c.endereco = :endereco")
    , @NamedQuery(name = "Comercio.findByAvaliacao", query = "SELECT c FROM Comercio c WHERE c.avaliacao = :avaliacao")})
public class Comercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomercio")
    private Integer idcomercio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeEmpresa")
    private String nomeEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoProdutos")
    private String tipoProdutos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 45)
    @Column(name = "avaliacao")
    private String avaliacao;
    
    @JoinColumn(name = "vendedor_idvendedor", referencedColumnName = "idvendedor")
    @ManyToOne(optional = false)
    private Vendedor vendedorIdvendedor;

    public Comercio() {
    }

    public Comercio(Integer idcomercio) {
        this.idcomercio = idcomercio;
    }

    public Comercio(Integer idcomercio, String nomeEmpresa, String tipoProdutos, String endereco) {
        this.idcomercio = idcomercio;
        this.nomeEmpresa = nomeEmpresa;
        this.tipoProdutos = tipoProdutos;
        this.endereco = endereco;
    }

    public Integer getIdcomercio() {
        return idcomercio;
    }

    public void setIdcomercio(Integer idcomercio) {
        this.idcomercio = idcomercio;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getTipoProdutos() {
        return tipoProdutos;
    }

    public void setTipoProdutos(String tipoProdutos) {
        this.tipoProdutos = tipoProdutos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

   

    public Vendedor getVendedorIdvendedor() {
        return vendedorIdvendedor;
    }

    public void setVendedorIdvendedor(Vendedor vendedorIdvendedor) {
        this.vendedorIdvendedor = vendedorIdvendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomercio != null ? idcomercio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comercio)) {
            return false;
        }
        Comercio other = (Comercio) object;
        if ((this.idcomercio == null && other.idcomercio != null) || (this.idcomercio != null && !this.idcomercio.equals(other.idcomercio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controle.Comercio[ idcomercio=" + idcomercio + " ]";
    }
    
}
