package br.com.eletronicos;

import java.util.Objects;

public class DispositivoMovel extends Eletronico {

    private String tipoTela;
    private double tamanhotela;
    private int quantArmazenamento;

    public DispositivoMovel(int quantMemoriaRam, String processador, String tipoTela, double tamanhotela, int quantMemoria) {
        super(quantMemoriaRam,"Mobile",processador);
        this.tipoTela = tipoTela;
        this.tamanhotela = tamanhotela;
        this.quantArmazenamento = quantMemoria;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public double getTamanhotela() {
        return tamanhotela;
    }

    public void setTamanhotela(double tamanhotela) {
        this.tamanhotela = tamanhotela;
    }

    public int getQuantArmazenamento() {
        return quantArmazenamento;
    }

    public void setQuantArmazenamento(int quantMemoria) {
        this.quantArmazenamento = quantMemoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DispositivoMovel that = (DispositivoMovel) o;
        return tamanhotela == that.tamanhotela && quantArmazenamento == that.quantArmazenamento && Objects.equals(tipoTela, that.tipoTela);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoTela, tamanhotela, quantArmazenamento);
    }
    public String toString(){
        return ("O produto tem "+super.getQuantMemoriaRam() + "GB de memoria ram, com uma tela " + this.tipoTela + " de " + this.tamanhotela +
                " polegadas, e vem com um processador " + super.getProcessador() + " , mais "+ this.quantArmazenamento + " GB de amarzenamento");
    }
}
