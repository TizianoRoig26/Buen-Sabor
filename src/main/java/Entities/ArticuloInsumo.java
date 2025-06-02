package Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class ArticuloInsumo extends Articulo {
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private Boolean esParaElaborar;
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> Manufacturadodetalles = new HashSet<>();

    @Override
    public String toString() {
        return "ArticuloInsumo{" +
                "denominacion='" + denominacion + '\'' +
                ", precioVenta=" + precioVenta + '\'' +
                ", precioCompra=" + precioCompra + '\'' +
                ", stockActual=" + stockActual + '\'' +
                ", stockMaximo=" + stockMaximo + '\'' +
                ", esParaElaborar=" + esParaElaborar + '\'' +
                ", detalles=" + Manufacturadodetalles + '\'' +
                ", unidadMedida=" + super.getUnidadMedida() +
                '}';
    }
}
