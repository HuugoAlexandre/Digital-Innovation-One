package BootcampPoo;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso de slaoq");
        curso1.setDesc("ja falei q o curso eh bom");
        curso1.setCargaHoraria(80);
        
        Curso curso2 = new Curso();
        curso2.setTitulo("curso de criatividade");
        curso2.setDesc("to precisando");
        curso2.setCargaHoraria(60);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("MENTORIA BOA DIMAIZI");
        mentoria1.setDesc("EH A MIO QUE TA TENDDO");
        mentoria1.setData();
        
        Bootcamp bootcamp1 = new Bootcamp();
        bootcamp1.setNome("Bootcamp RANDOM");
        bootcamp1.setDescricao("Descrição do bootcamp RANDOM");
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(curso2);
        bootcamp1.getConteudos().add(mentoria1);

        Dev robson = new Dev();
        robson.setNome("eduardokkkk");
        robson.inscreverBootcamp(bootcamp1);
        robson.pregredir();
        System.out.println("Conteúdos do robson: " + robson.getConteudosInscritos());
        System.out.println("Conteúdos CONCLUÍDOS do robson : " + robson.getConteudosConcluidos());
        System.out.println("XP: " + robson.calcularTotalXp());
        System.out.println("=================");

        Dev joao = new Dev();
        joao.setNome("matheuskkkkk");
        joao.inscreverBootcamp(bootcamp1);
        joao.pregredir();
        System.out.println("Conteúdos do jao: " + joao.getConteudosInscritos());
        System.out.println("Conteúdos CONCLUÍDOS do jao : " + joao.getConteudosConcluidos());
        System.out.println("XP: " + joao.calcularTotalXp());
        joao.pregredir();
        System.out.println("Conteúdos do jao: " + joao.getConteudosInscritos());
        System.out.println("Conteúdos CONCLUÍDOS do jao : " + joao.getConteudosConcluidos());
        System.out.println("XP: " + joao.calcularTotalXp());
    }
}
