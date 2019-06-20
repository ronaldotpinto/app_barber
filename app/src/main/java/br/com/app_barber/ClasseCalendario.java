package br.com.app_barber;

import java.util.Date;

public class ClasseCalendario {

    public boolean horarioDisp; //marca se o horario foi agendado
    public Date dataAgendamento; //armazena a data do solicitado pelo usuario

    public boolean isHorarioDisp() {
        return horarioDisp;
    }

    public void setHorarioDisp(boolean horarioDisp) {
        this.horarioDisp = horarioDisp;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
}
