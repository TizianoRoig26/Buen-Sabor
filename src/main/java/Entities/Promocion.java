package Entities;

import Entities.Enums.TipoPromocion;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Promocion extends Base{
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private double precionPromocinal;
    private TipoPromocion tipoPromocion;
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();


    @Override
    public String toString() {
        return "Promocion{" +
                "denominacion='" + denominacion + '\'' +
                "\n, fechaDesde=" + fechaDesde +
                "\n, fechaHasta=" + fechaHasta +
                "\n, horaDesde=" + horaDesde +
                "\n, horaHasta=" + horaHasta +
                "\n, descripcionDescuento='" + descripcionDescuento + '\'' +
                "\n, precionPromocinal=" + precionPromocinal +
                "\n, tipoPromocion=" + tipoPromocion +
                "\n, articulos=" + articulos +
                "\n, sucursales=" + sucursales +
                '}';
    }

}
