package br.com.eletronicos;

import java.util.Objects;

public class Eletronico {

   private int quantMemoriaRam;
   private String tipoMemoriaRam;
   private String processador;

   public Eletronico(int quantMemoriaRam,String tipoMemoriaRam,String processador) {
      this.quantMemoriaRam = quantMemoriaRam;
      this.tipoMemoriaRam = tipoMemoriaRam;
      this.processador = processador;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Eletronico that = (Eletronico) o;
      return quantMemoriaRam == that.quantMemoriaRam && Objects.equals(tipoMemoriaRam, that.tipoMemoriaRam) && Objects.equals(processador, that.processador);
   }

   @Override
   public int hashCode() {
      return Objects.hash(quantMemoriaRam, tipoMemoriaRam, processador);
   }

   public String getTipoMemoriaRam() {
      return tipoMemoriaRam;
   }

   public void setTipoMemoriaRam(String tipoMemoriaRam) {
      this.tipoMemoriaRam = tipoMemoriaRam;
   }

   public String getProcessador() {
      return processador;
   }

   public void setProcessador(String processador) {
      this.processador = processador;
   }

   public int getQuantMemoriaRam() {
      return quantMemoriaRam;
   }

   public void setQuantMemoriaRam(int quantMemoriaRam) {
      this.quantMemoriaRam = quantMemoriaRam;
   }

   @Override
   public String toString() {
      return "br.com.eletronicos.Eletronico{" +
              "quantMemoriaRam=" + quantMemoriaRam +
              ", tipoMemoriaRam='" + tipoMemoriaRam + '\'' +
              ", processador='" + processador + '\'' +
              '}';
   }
}
