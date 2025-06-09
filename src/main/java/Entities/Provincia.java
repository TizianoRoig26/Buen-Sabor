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

public class Provincia extends Base {
    private String nombre;
    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();
    private Pais pais;

    public void agregarLocalidad(Localidad localidad) {
        localidad.setProvincia(this);
        this.localidades.add(localidad);
    }

}
