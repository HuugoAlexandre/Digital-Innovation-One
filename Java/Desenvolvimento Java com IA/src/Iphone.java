import interfaces.AparelhoTelefonico;
import interfaces.NavegadorInternet;
import interfaces.ReprodutorMusical;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {
    private String marca = "Iphone";
    private String modelo = "X";

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    
    @Override
    public void tocar() {
        System.out.println("Tocando musica via iphone...");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando musica via iphone...");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Selecionado " + musica + " via iphone...");
    }

    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para o numero " + numero + " via iphone...");
    }

    @Override
    public void atender() {
        System.out.println("Atendendo ligacao via iphone...");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz via iphone...");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo pagina com url " + url + " via iphone...");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba via iphone...");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando pagina via iphone...");
    }

    public static void main(String[] args) {
        Iphone novoIphone = new Iphone();

        novoIphone.tocar();
        novoIphone.pausar();
        novoIphone.selecionarMusica("Lugar ao Sol");
        novoIphone.ligar("82999999999");
        novoIphone.atender();
        novoIphone.iniciarCorreioVoz();
        novoIphone.exibirPagina("google.com");
        novoIphone.atualizarPagina();
        novoIphone.adicionarNovaAba();
    }
}
