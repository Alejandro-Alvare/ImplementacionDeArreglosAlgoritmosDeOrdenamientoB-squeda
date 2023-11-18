import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crea un objeto Estudiante con la información proporcionada por el usuario
        Estudiante estudiante = new Estudiante();
        // ...

        // Crea un objeto Inscripcion para cada asignatura que el estudiante desee inscribir
        List<Inscripcion> inscripciones = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Asignatura asignatura = new Asignatura();
            // ...
            Inscripcion inscripcion = new Inscripcion(estudiante, asignatura, i + 1, "aula" + (i + 1), new Date());
            inscripciones.add(inscripcion);
        }

        // Validar que los créditos totales y la frecuencia de inscripción no se excedan los límites establecidos
        int totalDeCreditos = inscripciones.stream()
                .mapToInt(inscripcion -> inscripcion.getAsignatura().getCreditos())
                .sum();
        boolean créditosExcedidos = totalDeCreditos > 28;
        boolean frecuenciaDeInscripcionesExcedida = inscripciones.stream()
                .mapToInt(inscripcion -> inscripcion.getAsignatura().getFrecuenciaDeInscripciones())
                .max()
                .filter(maxFrecuencia -> maxFrecuencia > 3)
                .isPresent();

        if (créditosExcedidos || frecuenciaDeInscripcionesExcedida) {
            System.out.println("Créditos totales excedidos o frecuencia de inscripción excedida.");
        } else {
            // Mostrar un reporte de matrícula en formato texto
            System.out.println("Reporte de matrícula:");
            for (Inscripcion inscripcion : inscripciones) {
                System.out.println(inscripcion.toString());
            }
        }
    }
}