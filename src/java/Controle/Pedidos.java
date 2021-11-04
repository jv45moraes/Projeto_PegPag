/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhess
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByIdpedidos", query = "SELECT p FROM Pedidos p WHERE p.idpedidos = :idpedidos")
    , @NamedQuery(name = "Pedidos.findByValor", query = "SELECT p FROM Pedidos p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pedidos.findByDataRecebido", query = "SELECT p FROM Pedidos p WHERE p.dataRecebido = :dataRecebido")
    , @NamedQuery(name = "Pedidos.findByEstado", query = "SELECT p FROM Pedidos p WHERE p.estado = :estado")
    , @NamedQuery(name = "Pedidos.findByAvalicao", query = "SELECT p FROM Pedidos p WHERE p.avalicao = :avalicao")
    , @NamedQuery(name = "Pedidos.findByTipopagamento", query = "SELECT p FROM Pedidos p WHERE p.tipopagamento = :tipopagamento")
    , @NamedQuery(name = "Pedidos.findByQuantidadeProdutos", query = "SELECT p FROM Pedidos p WHERE p.quantidadeProdutos = :quantidadeProdutos")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpedidos")
    private Integer idpedidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Column(name = "dataRecebido")
    @Temporal(TemporalType.DATE)
    private Date dataRecebido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "avalicao")
    private String avalicao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipopagamento")
    private String tipopagamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidadeProdutos")
    private int quantidadeProdutos;
    @JoinColumn(name = "produtos_idprodutos", referencedColumnName = "idprodutos")
    @ManyToOne(optional = false)
    private Produtos produtosIdprodutos;
    @JoinColumn(name = "produtos_comercio_idcomercio", referencedColumnName = "comercio_idcomercio")
    @ManyToOne(optional = false)
    private Produtos produtosComercioIdcomercio;
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdcliente;

    public Pedidos() {
    }

    public Pedidos(Integer idpedidos) {
        this.idpedidos = idpedidos;
    }

    public Pedidos(Integer idpedidos, double valor, String estado, String tipopagamento, int quantidadeProdutos) {
        this.idpedidos = idpedidos;
        this.valor = valor;
        this.estado = estado;
        this.tipopagamento = tipopagamento;
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public Integer getIdpedidos() {
        return idpedidos;
    }

    public void setIdpedidos(Integer idpedidos) {
        this.idpedidos = idpedidos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataRecebido() {
        return dataRecebido;
    }

    public void setDataRecebido(Date dataRecebido) {
        this.dataRecebido = dataRecebido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAvalicao() {
        return avalicao;
    }

    public void setAvalicao(String avalicao) {
        this.avalicao = avalicao;
    }

    public String getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(String tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public Produtos getProdutosIdprodutos() {
        return produtosIdprodutos;
    }

    public void setProdutosIdprodutos(Produtos produtosIdprodutos) {
        this.produtosIdprodutos = produtosIdprodutos;
    }

    public Produtos getProdutosComercioIdcomercio() {
        return produtosComercioIdcomercio;
    }

    public void setProdutosComercioIdcomercio(Produtos produtosComercioIdcomercio) {
        this.produtosComercioIdcomercio = produtosComercioIdcomercio;
    }

    public Cliente getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(Cliente clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedidos != null ? idpedidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idpedidos == null && other.idpedidos != null) || (this.idpedidos != null && !this.idpedidos.equals(other.idpedidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controle.Pedidos[ idpedidos=" + idpedidos + " ]";
    }
    
}
