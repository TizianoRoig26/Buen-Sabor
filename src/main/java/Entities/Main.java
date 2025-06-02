package Entities;

import Entities.DAOs.EmpresaDAO;
import Entities.DAOs.SucursalDAO;
import Entities.Enums.Estado;
import Entities.Enums.FormaPago;
import Entities.Enums.TipoEnvio;
import Entities.Enums.TipoPromocion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empresa";
        String usuario = "root";
        String clave = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) {
            System.out.println("✅ ¡Conexión exitosa!");

            Empresa empresa = Empresa.builder()
                    .nombre("ASD")
                    .razonSocial("SA")
                    .cuil(1345678522)
                    .build();

            Pais pais = Pais.builder()
                    .nombre("Argentina")
                    .build();

            Provincia provincia = Provincia.builder()
                    .nombre("Mendoza")
                    .pais(pais)
                    .build();

            Localidad localidad = Localidad.builder()
                    .nombre("Godoy Cruz")
                    .provincia(provincia)
                    .build();

            Domicilio domicilio = Domicilio.builder()
                    .calle("San Martín")
                    .numero(123)
                    .localidad(localidad)
                    .build();

            Sucursal sucursal1 = Sucursal.builder()
                    .nombre("Sucursal Mendoza Centro")
                    .horarioApertura(LocalTime.of(9, 0))
                    .horarioCierre(LocalTime.of(20, 0))
                    .domicilio(domicilio)
                    .build();
            Sucursal sucursal2 = Sucursal.builder()
                    .nombre("Sucursal CABA")
                    .horarioApertura(LocalTime.of(9, 0))
                    .horarioCierre(LocalTime.of(20, 0))
                    .domicilio(domicilio)
                    .build();

            UnidadMedida unidad = UnidadMedida.builder()
                    .denominacion("Gramos")
                    .build();

            Categoria categoria = Categoria.builder()
                    .denominacion("Panificados")
                    .build();

            ArticuloInsumo insumo = ArticuloInsumo.builder()
                    .denominacion("Harina 000")
                    .precioVenta(150)
                    .precioCompra(90)
                    .stockActual(50)
                    .stockMaximo(200)
                    .esParaElaborar(true)
                    .unidadMedida(unidad)
                    .categoria(categoria)
                    .build();

            ArticuloManufacturado articulo1 = ArticuloManufacturado.builder()
                    .denominacion("Pan")
                    .precioVenta(200)
                    .categoria(categoria)
                    .unidadMedida(unidad)
                    .descripcion("Pan")
                    .tiempoEstimadoMinutos(20)
                    .preparacion("Preparar pan")
                    .categoria(categoria)
                    .build();
            ArticuloManufacturado articulo2 = ArticuloManufacturado.builder()
                    .descripcion("Tortitas")
                    .tiempoEstimadoMinutos(10)
                    .preparacion("Preparar tortitas")
                    .categoria(categoria)
                    .build();
            ArticuloManufacturado articulo3 = ArticuloManufacturado.builder()
                    .descripcion("facturas")
                    .tiempoEstimadoMinutos(30)
                    .preparacion("Preparar facturas")
                    .categoria(categoria)
                    .build();

            Set<Articulo> articulosPromo = new HashSet<>();
            articulosPromo.add(articulo1);
            articulosPromo.add(articulo2);
            articulosPromo.add(articulo3);

            Set<Sucursal> listaSucursales = new HashSet<>();
            listaSucursales.add(sucursal1);
            listaSucursales.add(sucursal2);


            Cliente cliente = Cliente.builder()
                    .id(1)
                    .nombre("Juan")
                    .apellido("Pérez")
                    .email("juan@example.com")
                    .telefono("2611234567")
                    .fechaNacimiento(LocalDate.of(1990, 1, 1))
                    .build();

            Usuario usuario1 = Usuario.builder()
                    .username("juanp")
                    .authOid("2")
                    .cliente(cliente)
                    .build();
            cliente.setUsuario(usuario1);

            Promocion promocion = Promocion.builder()
                    .denominacion("Promocion del dia")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now().plusDays(1))
                    .horaDesde(LocalTime.of(10, 0))
                    .horaHasta(LocalTime.of(15, 0))
                    .descripcionDescuento("Descuento del 10%")
                    .precionPromocinal(100)
                    .tipoPromocion(TipoPromocion.HAPPY_HOUR)
                    .articulos(articulosPromo)
                    .sucursales(listaSucursales)
                    .build();

            Imagen imagen1 = Imagen.builder()
                    .denominacion("imagen")
                    .promocion(promocion)
                    .articulo(articulo1)
                    .cliente(cliente)
                    .build();


            Pedido pedido = Pedido.builder()
                    .total(100.00)
                    .totalCosto(80.00)
                    .estado(Estado.PENDIENTE)
                    .tipoEnvio(TipoEnvio.DELIVERY)
                    .formaPago(FormaPago.EFECTIVO)
                    .fechaPedido(LocalDate.now())
                    .cliente(cliente)
                    .horaEstimadaFinalizacion(LocalTime.now())
                    .build();


            Factura factura = Factura.builder()
                    .total(100.00)
                    .totalCosto(80.00)
                    .estado(Estado.PENDIENTE)
                    .tipoEnvio(TipoEnvio.DELIVERY)
                    .formaPago(FormaPago.EFECTIVO)
                    .fechaPedido(LocalDate.now())
                    .pedido(pedido)
                    .build();

            System.out.println(
                    promocion + "\n===========================================================================\n" +
                            insumo + "\n===========================================================================\n" +
                            pedido + "\n===========================================================================\n" +
                            imagen1 + "\n===========================================================================\n" +
                            factura + "\n===========================================================================\n" +
                            usuario1 + "\n===========================================================================\n" +
                            articulo1
            );





            empresa.agregarSucursal(sucursal1);



            EmpresaDAO empresaDAO = new EmpresaDAO();
            SucursalDAO sucursalDAO = new SucursalDAO();

            Long empresaId = empresaDAO.save(conexion, empresa);



            for (Sucursal sucursal : empresa.getSucursales()) {
                sucursalDAO.save(conexion, sucursal, empresaId);
            }

            System.out.println("🏁 Empresa y sucursales guardadas con éxito.");

        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos.");
            e.printStackTrace();
        }
    }
}
