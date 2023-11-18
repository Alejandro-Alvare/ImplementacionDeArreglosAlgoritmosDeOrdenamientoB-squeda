import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ActaDeNotas_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String nombreCurso = null;
       String carrera = null;
       int periodoLectivo;
       String modalidad = null;
       int codigoCurso;

        // Datos Generales del curso
        System.out.println("Ingrese los Datos Generales del curso:");
        while (true) {
             System.out.print("Nombre del curso: ");
              String nombreCursos = scanner.nextLine();
               if (contieneSoloLetras(nombreCursos)) {
                nombreCurso = nombreCursos;
            
             break; // Sale del bucle porque la entrada es válida
        } else {
            System.out.println("Error: La cadena debe contener solo letras. Inténtelo nuevamente.");
        
        }
    }
          do{
              System.out.print("Período lectivo: ");
              while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un valor numérico.");
                System.out.print("Período lectivo (entre 2000 y 2023): ");
                scanner.next(); // limpiar el buffer del scanner
            }
            
              periodoLectivo = scanner.nextInt();
              break;
            
         }while (periodoLectivo < 2000 || periodoLectivo > 2023);

       
      
        while (true) {
              System.out.print("Carrera: ");
        String carreras = scanner.nextLine();
        if(contieneSoloLetras(carreras)){
            carrera = carreras;
           break;
        }else{
            System.out.println("Error: La cadena debe solo contener letras. Inténtelo nuevamente");
        }
            
        }
      while (true) {
        System.out.print("Modalidad: ");
        String modalidadd = scanner.nextLine();
        if(contieneSoloLetras(modalidadd)){
            modalidad = modalidadd;
            break;
        }else{
            System.out.println("Error: La cadena debe contener solo letras. Inténtelo nuevamente.");
        }
      }
             System.out.print("Código del curso: ");
              while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un valor numérico.");
                scanner.next();     
        }
          codigoCurso = scanner.nextInt();
          

        System.out.print("Grupo: ");
        String grupo = scanner.nextLine();
         System.out.print("Código de asignatura: ");
         String codigoAsignatura = scanner.nextLine();
        
      
        System.out.print("Código de programa de asignatura: ");
        String codigoProgramaAsignatura = scanner.nextLine();
        int cantidadEstudiantes = 0;

        do{
             System.out.print("Cantidad de estudiantes: ");
              while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un valor numérico.");
                scanner.next();     
        }
             cantidadEstudiantes = scanner.nextInt();
        }while (cantidadEstudiantes <= 0 || cantidadEstudiantes >= 50 ); 
        
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
                       notaFinal= sistematicos + examenPrimeraConvocatoria;
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

        // Muestra el menu de opciones 
          System.out.println("Seleccione las siguientes opciones:");
          System.out.println("1. Ordenar las notas:");
          System.out.println("2. Realizar busqueda de notas:");
          System.out.println("3. Mostrar y graficar los rangos de notas finalees antes de las convocatorias:");
          // ... (Otras opciones del menú)
  
          int opcionSeleccionada;
          while (true) {
              System.out.print("Ingrese el número de la opción: ");
              if (scanner.hasNextInt()) {
                  opcionSeleccionada = scanner.nextInt();
                  break;
              } else {
                  System.out.println("Por favor, ingrese un número válido.");
                  scanner.next(); // Limpia el buffer del scanner
              }
          }
  
          switch (opcionSeleccionada) {
              case 1:
               System.out.println("Seleccione el orden de las notas:");
                  System.out.println("a. Ascendente");
                  System.out.println("b. Descendente");
             

              char tipoOrden = scanner.next().charAt(0);

              switch (tipoOrden) {
                  case 'a':
                   System.out.println("Seleccione el tipo de orden:");
                 System.out.println("a. Por nota final");
                 System.out.println("b. Por nota final de primera convocatoria");
                 System.out.println("c. Por nota final de segundo convocatoria");
  
                  char ordenSeleccionado = scanner.next().charAt(0);
  
                  switch (ordenSeleccionado) {
                      case 'a':
                          ordenarNotas(estudiantes, true);
                          break;
                      case 'b':                        
                          ordenarNotasPrimeraConvocatoria(estudiantes, true);
                          break;
                      case 'c' :
                         
                            break;
                      default:
                          System.out.println("Opción no válida.");
                          break;
                    
                  }
                     break;
                  case 'b':
                   System.out.println("Seleccione el tipo de orden:");
                 System.out.println("a. Por nota final");
                 System.out.println("b. Por nota final de primera convocatoria");
                 System.out.println("c. Por nota final de segundo convocatoria");

                  char ordenSeleccionados = scanner.next().charAt(0);
  
                  switch (ordenSeleccionados) {
                      case 'a':
                          ordenarNotas(estudiantes, false);
                          break;
                      case 'b':                        
                           ordenarNotasPrimeraConvocatoria(estudiantes, false);
                          break;
                     case 'c' :
                          
                      break;
                  default:
                      System.out.println("Opción no válida.");
                      break;
              }
                  break;
             
            }
            case 2:
             System.out.println("Seleccione el tipo de busqueda:");
                 System.out.println("a. Por nota final");
                 System.out.println("b. Por nota final de primera convocatoria");
                 System.out.println("c. Por nota final de segundo convocatoria");

                 char tipodebusqueda = scanner.next().charAt(0);
                 switch (tipodebusqueda) {
                    case 'a':
                    buscarNotas(estudiantes, "Nota final");
                        break;
                        case 'b':
                        buscarNotas(estudiantes, "Nota final de primera convocatoria");
                        break;
                        case 'c':
                        buscarNotas(estudiantes, "Nota final de segunda convocatoria");
                        break;
                 
                    default:
                    System.out.println("Opcion no válida");
                        break;
                 }
             case 3:
             mostrarRangosNotas(estudiantes);
             break;

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
      // Método para ordenar las notas de forma ascendente o descendente
      private static void ordenarNotas(ArrayList<Estudiante> estudiantes, boolean ascendente) {
        if (ascendente) {
            Collections.sort(estudiantes);
            System.out.println("Notas ordenadas de forma ascendente.");
        } else {
            Collections.sort(estudiantes, Collections.reverseOrder());
            System.out.println("Notas ordenadas de forma descendente.");
        }

        // Muestra las notas ordenadas
        System.out.println("Número de carnet | Nombres y Apellidos | Nota Final | ¿Aprobado? | ¿Desaprobado¿");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
     private static void ordenarNotasPrimeraConvocatoria(ArrayList<Estudiante> estudiantes, boolean ascendente) {
    if (ascendente) {
        estudiantes.sort(Comparator.comparing(Estudiante::getNotaFinal));
        System.out.println("Notas de primera convocatoria ordenadas de forma ascendente.");
    } else {
        estudiantes.sort(Comparator.comparing(Estudiante::getNotaFinal).reversed());
        System.out.println("Notas de primera convocatoria ordenadas de forma descendente.");
    }

    // Muestra las notas de primera convocatoria ordenadas
    System.out.println("Número de carnet | Nombres y Apellidos | Nota de Primera Convocatoria | ¿Aprobado? | ¿Desaprobado¿");
    for (Estudiante estudiante : estudiantes) {
        System.out.println(estudiante);
    }
}
    
// Método para buscar las notas según el tipo seleccionado
private static void buscarNotas(ArrayList<Estudiante> estudiantes, String tipoBusqueda) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el valor de la " + tipoBusqueda + " a buscar: ");
    double valorBusqueda = scanner.nextDouble();

    System.out.println("Resultados de la búsqueda por " + tipoBusqueda + ":");
    System.out.println("Número de carnet | Nombres y Apellidos | " + tipoBusqueda + " | ¿Aprobado? | ¿Desaprobado¿");

    // Muestra los estudiantes que cumplen con el criterio de búsqueda
    for (Estudiante estudiante : estudiantes) {
        double valorComparacion = 0.0;

        switch (tipoBusqueda) {
            case "Nota Final":
                valorComparacion = estudiante.getNotaFinal();
                break;
            case "Nota de Primera Convocatoria": 
                valorBusqueda = estudiante.getNotaFinal();
                break;
            case "Nota de Segunda Convocatoria": 
                valorBusqueda = estudiante.getNotaFinal();             
                break;
        }

        if (valorComparacion == valorBusqueda) {
            System.out.println(estudiante);
        }
    }
}
 public static boolean contieneSoloLetras(String texto) {
        // Patrón que coincide con letras de la A a la Z, tanto mayúsculas como minúsculas
        String patron = "^[a-zA-Z]+$";

        // Comprobar si la cadena coincide con el patrón
        return Pattern.matches(patron, texto);
    }
    // Método para mostrar y graficar los rangos de notas finales
private static void mostrarRangosNotas(ArrayList<Estudiante> estudiantes) {
    int reprobados = 0;
    int regulares = 0;
    int buenos = 0;
    int muyBuenos = 0;
    int excelentes = 0;

    // Contar la cantidad de estudiantes en cada rango
    for (Estudiante estudiante : estudiantes) {
        double notaFinal = estudiante.getNotaFinal();

        if (notaFinal >= 0 && notaFinal < 60) {
            reprobados++;
        } else if (notaFinal >= 60 && notaFinal < 70) {
            regulares++;
        } else if (notaFinal >= 70 && notaFinal < 80) {
            buenos++;
        } else if (notaFinal >= 80 && notaFinal < 90) {
            muyBuenos++;
        } else if (notaFinal >= 90 && notaFinal <= 100) {
            excelentes++;
        }
    }
     // Mostrar los resultados
     System.out.println("Rangos de Notas Finales:");
     System.out.println("Reprobados (0-59): " + reprobados);
     System.out.println("Regulares (60-69): " + regulares);
     System.out.println("Buenos (70-79): " + buenos);
     System.out.println("Muy Buenos (80-89): " + muyBuenos);
     System.out.println("Excelentes (90-100): " + excelentes);

    // Graficar los resultados
    System.out.println("\nGráfico de Rangos de Notas Finales:");
    System.out.println("Reprobados (0-59): " + generarGrafico(reprobados));
    System.out.println("Regulares (60-69): " + generarGrafico(regulares));
    System.out.println("Buenos (70-79): " + generarGrafico(buenos));
    System.out.println("Muy Buenos (80-89): " + generarGrafico(muyBuenos));
    System.out.println("Excelentes (90-100): " + generarGrafico(excelentes));
}

// Método para generar el gráfico de barras simple
private static String generarGrafico(int cantidad) {
    StringBuilder grafico = new StringBuilder();
    for (int i = 0; i < cantidad; i++) {
        grafico.append("█");
    }
    return grafico.toString();

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