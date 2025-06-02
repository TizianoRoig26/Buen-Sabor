package Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Sucursal extends Base{

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Empresa empresa;
    private Domicilio domicilio;
    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();
    @Builder.Default
    private Set<Categoria> categorias = new HashSet<>();
    @Builder.Default
    private Set<Pedido> Pedidos = new HashSet<>();


    @Override
    public String toString() {
        return "Sucursal{" +
                ", nombre='" + nombre + '\'' +
                ", horarioApertura=" + horarioApertura +
                ", horarioCierre=" + horarioCierre +
                '}';
    }
}
