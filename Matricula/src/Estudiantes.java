 public class Estudiantes {
 
 public Estudiantes(String nombre, String apellido, String carnet, String carrera, String planDeEstudio, int numeroDeInscripcion, double numeroDeRecibo, Date fechaDeMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet = carnet;
        this.carrera = carrera;
        this.planDeEstudio = planDeEstudio;
        this.numeroDeInscripcion = numeroDeInscripcion;
        this.numeroDeRecibo = numeroDeRecibo;
        this.fechaDeMatricula = fechaDeMatricula;
    }

    // Getters y setters para todas las variables de instancia
    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getCarnet() {
        return this.carnet;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public String getPlanDeEstudio() {
        return this.planDeEstudio;
    }

    public int getNumeroDeInscripcion() {
        return this.numeroDeInscripcion;
    }

    public double getNumeroDeRecibo() {
        return this.numeroDeRecibo;
    }

    public Date getFechaDeMatricula() {
        return this.fechaDeMatricula;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setPlanDeEstudio(String planDeEstudio) {
        this.planDeEstudio = planDeEstudio;
    }

    public void setNumeroDeInscripcion(int numeroDeInscripcion) {
        this.numeroDeInscripcion = numeroDeInscripcion;
    }

    public void setNumeroDeRecibo(double numeroDeRecibo) {
        this.numeroDeRecibo = numeroDeRecibo;
    }

    public void setFechaDeMatricula(Date fechaDeMatricula) {
        this.fechaDeMatricula = fechaDeMatricula;
    }
}