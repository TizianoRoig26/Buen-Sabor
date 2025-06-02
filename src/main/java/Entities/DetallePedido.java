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

public class DetallePedido extends Base {
    private int cantidad;
    private double subTotal;
    private Pedido pedido;
    private Articulo articulo;

    @Override
    public String toString() {
        return "DetallePedido{" + "cantidad=" + cantidad + ", subTotal=" + subTotal + '}';
    }
}
