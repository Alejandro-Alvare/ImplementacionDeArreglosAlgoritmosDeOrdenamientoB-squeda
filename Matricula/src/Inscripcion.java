import java.util.Date;

public class Inscripcion { 
    private Estudiante estudiante;
    private Asignatura asignatura;
    private int grupo;
    private String aula;
    private Date fechaDeInscripcion;

    public Inscripcion(Estudiante estudiante, Asignatura asignatura, int grupo, String aula, Date fechaDeInscripcion) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.grupo = grupo;
        this.aula = aula;
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    // Getters y setters para todas las variables de instancia
// Getters
    public Estudiante getEstudiante() {
        return this.estudiante;
    }

    public Asignatura getAsignatura() {
        return this.asignatura;
    }

    public int getGrupo() {
        return this.grupo;
    }

    public String getAula() {
        return this.aula;
    }

    public Date getFechaDeInscripcion() {
        return this.fechaDeInscripcion;
    }

    // Setters
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setFechaDeInscripcion(Date fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    // Metodo toString para mostrar la informaci贸n de la inscripci贸n
    @Override
    public String toString() { 
        return "Inscripcion: " + this.estudiante.getNombre() + " "  + this.estudiante.getApellido() + " (" + this.estudiante.getNumeroDeCarnet() + ")\n" +
                "Asignatura: " + this.asignatura.getNombre() + " (" + this.asignatura.getCodigo() + ")\n" +
                "Numero de inscripcion: " + this.numeroDeInscripcion + "\n" +
                "Grupo: " + this.grupo + "\n" +
                "Aula: " + this.aula + "\n" +
                "Semestre: " + this.semestre + "\n" +
                "Fecha de inscripcion: " + this.fechaDeInscripcion + "\n" +
                "Retiro de asignatura: " + (this.retiroDeAsignatura ? "Si" : "No") + "\n";
    }

}