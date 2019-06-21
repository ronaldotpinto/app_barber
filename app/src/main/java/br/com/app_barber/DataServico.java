package br.com.app_barber;

public class DataServico {

    private String id;
    private String nome;
    private String data;
    private String horario;
    private String servico;



    @Override
    public String toString() {
        return this.nome + "\n" + this.servico +"\n"+ this.data + "\n" + this.horario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getNome() {return nome;}

    public void setNome(String nome){this.nome = nome;}

    public  String getData() {return data;}

    public void setData(String data){this.data = data;}

    public  String getHorario() {return horario;}

    public void setHorario(String horario){this.horario = horario;}

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {this.servico = servico; }


}
