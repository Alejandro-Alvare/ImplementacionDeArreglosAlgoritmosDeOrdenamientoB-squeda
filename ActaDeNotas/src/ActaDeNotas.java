import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ActaDeNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Datos Generales del curso
        System.out.println("Ingrese los Datos Generales del curso:");
        System.out.print("Nombre del curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Período lectivo: ");
        String periodoLectivo = scanner.nextLine();
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();
        System.out.print("Modalidad: ");
        String modalidad = scanner.nextLine();
        System.out.print("Código del curso: ");
        String codigoCurso = scanner.nextLine();
        System.out.print("Grupo: ");
        String grupo = scanner.nextLine();
        System.out.print("Código de asignatura: ");
        String codigoAsignatura = scanner.nextLine();
        System.out.print("Código de programa de asignatura: ");
        String codigoProgramaAsignatura = scanner.nextLine();
        int cantidadEstudiantes = 0;

        try {
            System.out.print("Cantidad de estudiantes: ");
            cantidadEstudiantes = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor numérico para la cantidad de estudiantes.");
            System.exit(1);
        }

    
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("Ingrese los datos del estudiante " + (i + 1) + ":");
            System.out.print("Número de carnet: ");
            int numeroCarnet = 0;

            try {
                numeroCarnet = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico para el número de carnet.");
                System.exit(1);
            }

            scanner.nextLine(); // Limpiar el buffer de entrada
            System.out.print("Nombres y Apellidos: ");
            String nombresApellidos = scanner.nextLine();
            double primerParcial = 0;
            double sistematicos = 0;

            try {
                System.out.print("Primer parcial (máximo 35.00): ");
                primerParcial = scanner.nextDouble();
                System.out.print("Sistemáticos (máximo 30.00): ");
                sistematicos = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico para las notas.");
                System.exit(1);
            }

            double notaFinal;
            boolean aprobado = false;

            if (codigoAsignatura.contains("proyecto")) {
                double notaProyecto = 0;
                try {
                    System.out.print("Nota de Proyecto (máximo 35.00): ");
                    notaProyecto = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un valor numérico para la nota de proyecto.");
                    System.exit(1);
                }
                notaFinal = primerParcial + sistematicos + notaProyecto;
                if (notaFinal >= 60.00) {
                    aprobado = true;
                } else {
                    double examenPrimeraConvocatoria = 0;
                    try {
                        System.out.print("Examen de primera convocatoria (máximo 70.00): ");
                        examenPrimeraConvocatoria = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Ingrese un valor numérico para el examen de primera convocatoria.");
                        System.exit(1);
                    }
                    notaFinal = sistematicos + examenPrimeraConvocatoria;
                    if (notaFinal < 60.00) {
                        double examenSegundaConvocatoria = 0;
                        try {
                            System.out.print("Examen de segunda convocatoria (máximo 100.00): ");
                            examenSegundaConvocatoria = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un valor numérico para el examen de segunda convocatoria.");
                            System.exit(1);
                        }
                        notaFinal = examenSegundaConvocatoria;
                    }
                }
            } else {
                double segundoParcial = 0;
                try {
                    System.out.print("Segundo parcial (máximo 35.00): ");
                    segundoParcial = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un valor numérico para el segundo parcial.");
                    System.exit(1);
                }
                notaFinal = primerParcial + segundoParcial + sistematicos;
                if (notaFinal >= 60.00) {
                    aprobado = true;
                } else {
                    double examenPrimeraConvocatoria = 0;
                    try {
                        System.out.print("Examen de primera convocatoria (máximo 70.00): ");
                        examenPrimeraConvocatoria = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Ingrese un valor numérico para el examen de primera convocatoria.");
                        System.exit(1);
                    }
                    notaFinal = sistematicos + examenPrimeraConvocatoria;
                    if (notaFinal < 60.00) {
                        double examenSegundaConvocatoria = 0;
                        try {
                            System.out.print("Examen de segunda convocatoria (máximo 100.00): ");
                            examenSegundaConvocatoria = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un valor numérico para el examen de segunda convocatoria.");
                            System.exit(1);
                        }
                        notaFinal = examenSegundaConvocatoria;
                    }
                }
            }

            scanner.nextLine(); // Limpiar el buffer de entrada
            System.out.print("¿Desertó el curso? (Sí/No): ");
            String desercion = scanner.nextLine();
            estudiantes.add(new Estudiante(numeroCarnet, nombresApellidos, notaFinal, aprobado, desercion));
        }

        
        Collections.sort(estudiantes);

        // Mostrar acta de notas
        System.out.println("Acta de Notas del Curso: " + nombreCurso);
        System.out.println("Período Lectivo: " + periodoLectivo);
        System.out.println("Carrera: " + carrera);
        System.out.println("Modalidad: " + modalidad);
        System.out.println("Código del Curso: " + codigoCurso);
        System.out.println("Grupo: " + grupo);
        System.out.println("Código de Asignatura: " + codigoAsignatura);
        System.out.println("Código de Programa de Asignatura: " + codigoProgramaAsignatura);
        System.out.println("Cantidad de Estudiantes: " + cantidadEstudiantes);
        System.out.println();

        System.out.println("Número de carnet | Nombres y Apellidos | Nota Final | ¿Aprobado? | ¿Desaprobado¿");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

        // Generar reporte estadístico
        int matriculaInicial = cantidadEstudiantes;
        int matriculaEfectiva = cantidadEstudiantes;
        int deserciones = 0;
        int aprobados = 0;
        int reprobados = 0;
        double notaMinima = 100.00;
        double notaMaxima = 0.00;
        double sumaNotas = 0.00;

        for (Estudiante estudiante : estudiantes) {
            sumaNotas += estudiante.getNotaFinal();
            if (estudiante.isDesertion()) {
                deserciones++;
                matriculaEfectiva--;
            }
            if (estudiante.isAprobado()) {
                aprobados++;
            } else {
                reprobados++;
            }
            if (estudiante.getNotaFinal() < notaMinima) {
                notaMinima = estudiante.getNotaFinal();
            }
            if (estudiante.getNotaFinal() > notaMaxima) {
                notaMaxima = estudiante.getNotaFinal();
            }
        }

        double promedioNotas = sumaNotas / matriculaEfectiva;

        System.out.println("\nReporte Estadístico:");
        System.out.println("Matrícula inicial: " + matriculaInicial);
        System.out.println("Matrícula efectiva: " + matriculaEfectiva);
        System.out.println("Número de deserciones: " + deserciones);
        System.out.println("Cantidad de aprobados: " + aprobados);
        System.out.println("% de aprobados: " + ((double) aprobados / matriculaEfectiva * 100) + "%");
        System.out.println("Cantidad de reprobados: " + reprobados);
        System.out.println("% de reprobados: " + ((double) reprobados / matriculaEfectiva * 100) + "%");
        System.out.println("Nota mínima: " + notaMinima);
        System.out.println("Nota máxima: " + notaMaxima);
        System.out.println("Promedio de notas: " + promedioNotas);

        // Preguntar al usuario si desea utilizar la aplicación nuevamente
        System.out.print("¿Desea utilizar la aplicación nuevamente? (Sí/No): ");
        String respuesta = scanner.next();
        if (respuesta.equalsIgnoreCase("No")) {
            System.out.println("¡Hasta luego!");
        }
    }
}

class Estudiante implements Comparable<Estudiante> {
    private int numeroCarnet;
    private String nombresApellidos;
    private double notaFinal;
    private boolean aprobado;
    private String desercion;

    public Estudiante(int numeroCarnet, String nombresApellidos, double notaFinal, boolean aprobado, String desercion) {
        this.numeroCarnet = numeroCarnet;
        this.nombresApellidos = nombresApellidos;
        this.notaFinal = notaFinal;
        this.aprobado = aprobado;
        this.desercion = desercion;
    }

    public int getNumeroCarnet() {
        return numeroCarnet;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public boolean isDesertion() {
        return desercion.equalsIgnoreCase("Sí");
    }

    @Override
    public String toString() {
        return numeroCarnet + " | " + nombresApellidos + " | " + notaFinal + " | " +
                (aprobado ? "Sí" : "No") + " | " + desercion;
    }

    @Override
    public int compareTo(Estudiante otroEstudiante) {
        return this.nombresApellidos.compareTo(otroEstudiante.nombresApellidos);
    }
}