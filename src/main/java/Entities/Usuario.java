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

public class Usuario extends Base {
    private String username;
    private String authOid;
    private Cliente cliente;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + authOid +
                ", username='" + username + '\'' +
                ", authOid='" + authOid + '\'' +
                '}';
    }

}
