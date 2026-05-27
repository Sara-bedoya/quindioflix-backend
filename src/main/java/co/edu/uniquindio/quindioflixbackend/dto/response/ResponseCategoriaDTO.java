package co.edu.uniquindio.quindioflixbackend.dto.response;

public class ResponseCategoriaDTO {

    private Long idCategoria;
    private String nombreCategoria;

    public ResponseCategoriaDTO() {
    }

    public ResponseCategoriaDTO(Long idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
