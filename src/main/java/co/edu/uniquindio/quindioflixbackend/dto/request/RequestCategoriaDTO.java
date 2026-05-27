package co.edu.uniquindio.quindioflixbackend.dto.request;

public class RequestCategoriaDTO {

    private String nombreCategoria;

    public RequestCategoriaDTO() {
    }

    public RequestCategoriaDTO(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
