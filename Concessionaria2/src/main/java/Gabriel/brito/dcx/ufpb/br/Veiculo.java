package Gabriel.brito.dcx.ufpb.br;

import java.io.Serializable;

public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Veiculo(String marca, String modelo, int ano, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + ano + ") - R$ " + preco;
    }
}
