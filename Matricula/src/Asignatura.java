public class Asignatura {
    private String codigo;
    private String nombre;
    private int creditos;
    private int frecuenciaDeInscripciones;
    private boolean retiroDeAsignatura;

    public Asignatura(String codigo, String nombre, int creditos, int frecuenciaDeInscripciones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.frecuenciaDeInscripciones = frecuenciaDeInscripciones;
        this.retiroDeAsignatura = false;
    }

    // Getters y setters para todas las variables de instancia
// Getters
    public String getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCreditos() {
        return this.creditos;
    }

    public int getFrecuenciaDeInscripciones() {
        return this.frecuenciaDeInscripciones;
    }

    public boolean isRetiroDeAsignatura() {
        return this.retiroDeAsignatura;
    }

    // Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setFrecuenciaDeInscripciones(int frecuenciaDeInscripciones) {
        this.frecuenciaDeInscripciones = frecuenciaDeInscripciones;
    }

    public void setRetiroDeAsignatura(boolean retiroDeAsignatura) {
        this.retiroDeAsignatura = retiroDeAsignatura;
    }

// Método toString para mostrar la información de la asignatura
    @Override
    public String toString() {
        return "Asignatura: " + this.nombre + " (" + this.codigo + ")\n" +
                "Créditos: " + this.creditos + "\n" +
                "Frecuencia de inscripciones: " + this.frecuenciaDeInscripciones + "\n" +
                "Retiro de asignatura: " + (this.retiroDeAsignatura ? "Sí" : "No") + "\n";
    }
}