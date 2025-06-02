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

public class Domicilio extends Base {
    private String calle;
    private Integer numero;
    private Integer cp;
    private Localidad localidad;
    private Sucursal sucursal;
    @Builder.Default
    private Set<Cliente> clientes = new HashSet<>();
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

}
