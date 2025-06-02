package Entities;

import Entities.Enums.Estado;
import Entities.Enums.FormaPago;
import Entities.Enums.TipoEnvio;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Pedido extends Base{
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    private Cliente cliente;
    private Domicilio domicilio;
    private Factura factura;
    private Sucursal sucursal;

    @Builder.Default
    private List<DetallePedido> detalles = new ArrayList<>();


    @Override
    public String toString() {
        return "Pedido{" +
                "horaEstimadaFinalizacion=" + horaEstimadaFinalizacion +
                ", total=" + total +
                ", totalCosto=" + totalCosto +
                ", Estado=" + estado +
                ", TipoEnvio=" + tipoEnvio +
                ", FormaPago=" + formaPago +
                ", FechaPedido=" + fechaPedido +
                ", cliente=" + cliente +
                "\n," + detalles +
                '}';
    }


}
