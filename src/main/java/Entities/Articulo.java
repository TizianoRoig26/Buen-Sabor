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
public abstract class Articulo extends Base {
    protected String denominacion;
    protected double precioVenta;
    private Categoria categoria;
    private ArticuloInsumo articuloInsumo;
    private UnidadMedida unidadMedida;
    @Builder.Default
    private Set<Promocion> Promociones = new HashSet<>();
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();
    @Builder.Default
    private Set<DetallePedido> detalles = new HashSet<>();

}
