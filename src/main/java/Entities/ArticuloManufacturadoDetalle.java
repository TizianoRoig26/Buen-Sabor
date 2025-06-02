package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class ArticuloManufacturadoDetalle extends Base {
    private int cantidad;
    private ArticuloInsumo articuloInsumo;
    private ArticuloManufacturado articuloManufacturado;

    @Override
    public String toString() {
        return "ArticuloManufacturadoDetalle{" +
                "cantidad=" + cantidad +
                ", articuloInsumo=" + articuloInsumo +
                ", articuloManufacturado=" + articuloManufacturado +
                '}';
    }
}
