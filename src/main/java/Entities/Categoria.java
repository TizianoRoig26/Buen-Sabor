package Entities;

import java.util.HashSet;
import java.util.Set;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Categoria extends Base {

    private String denominacion;
    private Categoria categoriaPadre;
    @Builder.Default
    private Set<Categoria> categoriasHijas = new HashSet<>();
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    public void agregarArticulo(Articulo articulo) {
        this.articulos.add(articulo);
    }
    public void agregarCategoriaHija(Categoria categoria) {
        categoria.setCategoriaPadre(this);
        this.categoriasHijas.add(categoria);
    }

}
