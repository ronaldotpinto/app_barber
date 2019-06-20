package br.com.app_barber;

public class DataServico {

    private String id;
    private String data, horario,  servico, valor;



    @Override
    public String toString() {
        return this.data + "\n" + this.horario + "\n" + this.servico + "\n" + this.valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getData(String data) {return data;}

    public void setData(String data){this.data = data;}

    public  String getHorario(String horario) {return horario;}

    public void setHorario(String horario){this.horario = horario;}

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {this.servico = servico; }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
