package teste.gateways.output.http.store.jsons;

import lombok.Data;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Data
public class StoreProduct {

    private String sku;
    private String nome;
    private String descricao;
    private String departamento;
    private String tipoDeProduto;
    private String marca;
    private String cor;
    private String sabor;
    private String ean;
    private Long alturaEmCentimetros;
    private Long larguraEmCentimetros;
    private Long profundidadeEmCentimetros;
    private Double pesoEmGramas;
    private String tamanho;
    private Set<StoreProvider> lojistas;

    public StoreProduct()
    {}

    public StoreProduct(final Product product) {
        this.sku = product.getSku();
        this.nome = product.getName();
        this.descricao = product.getDescription();
        this.departamento = product.getDepartment();
        this.tipoDeProduto = product.getProductType();
        this.marca = product.getBrand();
        this.cor = product.getColor();
        this.sabor = product.getFlavor();
        this.ean = product.getEan();
        this.alturaEmCentimetros = product.getHeight();
        this.larguraEmCentimetros = product.getWidtht();
        this.profundidadeEmCentimetros = product.getDeptht();
        this.pesoEmGramas = product.getWeight();
        this.tamanho = product.getSize();
        this.lojistas = product.getProviders().stream().map(provider -> new StoreProvider(provider)).collect(toSet());
    }

    public Product toDomain() {
        Product product = new Product();

        product.setSku(this.sku);
        product.setName(this.nome);
        product.setDescription(this.descricao);
        product.setDepartment(this.departamento);
        product.setProductType(this.tipoDeProduto);
        product.setBrand(this.marca);
        product.setColor(this.cor);
        product.setFlavor(this.sabor);
        product.setEan(this.ean);
        product.setHeight(this.alturaEmCentimetros);
        product.setWidtht(this.larguraEmCentimetros);
        product.setDeptht(this.profundidadeEmCentimetros);
        product.setWeight(this.pesoEmGramas);
        product.setSize(this.tamanho);
        product.setSku(this.tamanho);
        product.setProviders(this.lojistas.stream().map(lojista -> lojista.toDomain()).collect(toSet()));
        //this.lojistas = product.getProviders().stream().map(provider -> new StoreProvider(provider)).collect(toSet());
        return product;
    }
}
