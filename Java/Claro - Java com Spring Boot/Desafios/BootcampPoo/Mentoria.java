package BootcampPoo;

import java.time.LocalDate;

public class Mentoria extends Conteudo{
    private LocalDate data; 
    
    @Override
    public double calcularXp() {
        // TODO Auto-generated method stub
        return XP_PADRAO + 20d;
    }

    public void setData() {
        this.data = LocalDate.now();
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Mentoria{Nome: " + getTitulo() + ", Descrição: " + getDesc() +
        " Data: " + getData() + "}";
    }

}
