package Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Cliente extends Base{

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
    private Imagen imagen;
    private Usuario usuario;

    public void agregarDomicilio(Domicilio domicilio) {
        domicilios.add(domicilio);
    }
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + usuario.getId() +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }


}
