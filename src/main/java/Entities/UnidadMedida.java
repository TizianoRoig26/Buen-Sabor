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

public class UnidadMedida extends Base{
    private String denominacion;
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    @Override
    public String toString() {
        return denominacion;
    }

}
