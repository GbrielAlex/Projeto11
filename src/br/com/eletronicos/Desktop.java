package br.com.eletronicos;

import java.util.Objects;

public class Desktop extends Eletronico {

    private int quantArmazenamento;
    private String tipoArmazenamento;
    private String modeloPlacaDeVideo;
    private String modeloPlacaMae;

    public Desktop(int quantMemoriaRam,String tipoMemoriaRam,String processador, int quantArmazenamento, String tipoArmazenamento, String modeloPlacaDeVideo, String modeloPlacaMae) {
        super(quantMemoriaRam, tipoMemoriaRam, processador);
        this.quantArmazenamento = quantArmazenamento;
        this.tipoArmazenamento = tipoArmazenamento;
        this.modeloPlacaDeVideo = modeloPlacaDeVideo;
        this.modeloPlacaMae = modeloPlacaMae;
    }

    public int getQuantArmazenamento() {
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

    public String getModeloPlacaMae() {
        return modeloPlacaMae;
    }

    public void setModeloPlacaMae(String modeloPlacaMae) {
        this.modeloPlacaMae = modeloPlacaMae;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desktop desktop = (Desktop) o;
        return quantArmazenamento == desktop.quantArmazenamento && Objects.equals(tipoArmazenamento, desktop.tipoArmazenamento) && Objects.equals(modeloPlacaDeVideo, desktop.modeloPlacaDeVideo) && Objects.equals(modeloPlacaMae, desktop.modeloPlacaMae);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantArmazenamento, tipoArmazenamento, modeloPlacaDeVideo, modeloPlacaMae);
    }

    public String toString(){
        return "o produto tem " + super.getQuantMemoriaRam() + "GBs de memoria ram "+ super.getTipoMemoriaRam() +
                "com um processador " + super.getProcessador() + " equipado com uma placa de video " + this.getModeloPlacaDeVideo() +
                "junto a uma placa mãe " + this.getModeloPlacaMae() + "e um " + this.getTipoArmazenamento() + " de " + this.getQuantArmazenamento() +
                "GBs";
    }
}
