package br.com.app_barber;

public class Servico {

    private String id;
    private String servico, valor;



    @Override
    public String toString() {
        return this.servico + "\n" + this.valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.valor = servico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String texto) {
        this.valor = valor;
    }
}
