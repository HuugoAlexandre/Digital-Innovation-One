package BootcampPoo;

public class Curso extends Conteudo {
    private int cargaHoraria;

    @Override
    public double calcularXp() {
        // TODO Auto-generated method stub
        return XP_PADRAO * cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Curso{Nome: " + getTitulo() + ", Descrição: " + getDesc() +
        " Carga: " + getCargaHoraria() + "}";
    }
}
