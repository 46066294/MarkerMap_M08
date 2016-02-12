package mat.markermap;

/**
 * Created by Mat on 12/02/2016.
 */
public class Nota {
    String titulo;
    String descripcion;
    Double longitud;
    Double latitud;

    public Nota() {
    }

    public Nota(String titulo, String descripcion, Double longitud, Double latitud) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String desc) {
        this.descripcion = descripcion;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
}
