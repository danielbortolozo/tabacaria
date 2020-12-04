
package relatoriosView;

/**
 *
 * @author daniel
 */
public class ProdutosEstoque {
    
    
    private String estoque;
    private String descricao;
    private String idProduto;
    private String custo;
    private String venda;
    private String custo_estoq;
    private String lucro;
    private String venda_estoq;
    private String lucro_total;

    public ProdutosEstoque(String idProduto, String descricao, String estoque, String custo, String venda, String custo_estoq, String lucro, String venda_estoq, String lucro_total) {
        this.idProduto = idProduto;
        this.estoque = estoque;
        this.descricao = descricao;        
        this.custo = custo;
        this.venda = venda;
        this.custo_estoq = custo_estoq;
        this.lucro = lucro;
        this.venda_estoq = venda_estoq;
        this.lucro_total = lucro_total;
    }

    public ProdutosEstoque() {
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public String getVenda() {
        return venda;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }

    public String getCusto_estoq() {
        return custo_estoq;
    }

    public void setCusto_estoq(String custo_estoq) {
        this.custo_estoq = custo_estoq;
    }

    public String getLucro() {
        return lucro;
    }

    public void setLucro(String lucro) {
        this.lucro = lucro;
    }

    public String getVenda_estoq() {
        return venda_estoq;
    }

    public void setVenda_estoq(String venda_estoq) {
        this.venda_estoq = venda_estoq;
    }

    public String getLucro_total() {
        return lucro_total;
    }

    public void setLucro_total(String lucro_total) {
        this.lucro_total = lucro_total;
    }
    
    
    
    
    
    
}
