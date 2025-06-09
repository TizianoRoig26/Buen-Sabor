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
    private UnidadMedida unidadMedida;
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();

}
