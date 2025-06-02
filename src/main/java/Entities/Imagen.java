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

public class Imagen extends Base {
    private String denominacion;
    private Cliente cliente;
    private Promocion promocion;
    private Articulo articulo;
    @Override
    public String toString() {
        return "Imagen{" +
                ", denominacion='" + denominacion + '\'' +
                ", cliente=" + cliente +
                ", promocion=" + promocion +
                ", articulo=" + articulo +
                '}';
    }
}
