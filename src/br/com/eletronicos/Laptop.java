package br.com.eletronicos;

import java.util.Objects;

public class Laptop extends Eletronico {

    private String tipoTela;
    private double tamanhotela;
    private int quantArmazenamento;
    private String tipoArmazenamento;
    private String modeloPlacaDeVideo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return tamanhotela == laptop.tamanhotela && quantArmazenamento == laptop.quantArmazenamento && Objects.equals(tipoTela, laptop.tipoTela) && Objects.equals(tipoArmazenamento, laptop.tipoArmazenamento) && Objects.equals(modeloPlacaDeVideo, laptop.modeloPlacaDeVideo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoTela, tamanhotela, quantArmazenamento, tipoArmazenamento, modeloPlacaDeVideo);
    }

    public Laptop(int quantMemoriaRam, String tipoMemoriaRam, String processador, String tipoTela, double tamanhotela, int quantArmazenamento, String tipoArmazenamento, String modeloPlacaDeVideo) {

        super(quantMemoriaRam, tipoMemoriaRam, processador);
        this.tipoTela = tipoTela;
        this.tamanhotela = tamanhotela;
        this.quantArmazenamento = quantArmazenamento;
        this.tipoArmazenamento = tipoArmazenamento;
        this.modeloPlacaDeVideo = modeloPlacaDeVideo;

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

    public void setTamanhotela(int tamanhotela) {
        this.tamanhotela = tamanhotela;
    }

    public double getQuantArmazenamento() {
        return quantArmazenamento;
    }

    public void setQuantArmazenamento(int quantArmazenamento) {
        this.quantArmazenamento = quantArmazenamento;
    }

    public String getTipoArmazenamento() {
        return tipoArmazenamento;
    }

    public void setTipoArmazenamento(String tipoArmazenamento) {
        this.tipoArmazenamento = tipoArmazenamento;
    }

    public String getModeloPlacaDeVideo() {
        return modeloPlacaDeVideo;
    }

    public void setModeloPlacaDeVideo(String modeloPlacaDeVideo) {
        this.modeloPlacaDeVideo = modeloPlacaDeVideo;
    }

    public String toString(){
        return "O produto vem com " + super.getQuantMemoriaRam() + "GB " + super.getTipoMemoriaRam() + ", com um processador "+
                super.getProcessador() + "junto a uma placa de video " + this.getModeloPlacaDeVideo() + "e uma Tela " + this.getTipoTela() + "de "+
                this.getTamanhotela() + "polegadas, e ainda um armazenamento em " + this.getTipoArmazenamento() + "de" + this.getQuantArmazenamento() +" GBs";
    }

}
