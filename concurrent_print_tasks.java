import java.util.concurrent.*;
import java.util.*;
// Luis Fernando Monjaraz Briseño

// 1 Clase que implementa Callable<String>
class TareaImpresion implements Callable<String> {
    private final int numeroDocumento;

    public TareaImpresion(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public String call() throws Exception {
        // 2 Simula el tiempo de impresión
        System.out.println("Iniciando impresión del documento " + numeroDocumento + " en " + Thread.currentThread().getName());
        Thread.sleep((long) (Math.random() * 3000 + 1000)); // entre 1 y 4 segundos
        // 3 Retorna el mensaje cuando termina
        return "Documento " + numeroDocumento + " impreso por " + Thread.currentThread().getName();
    }
}

// 4 Clase principal con ExecutorService
public class Main {
    public static void main(String[] args) {
        // Crear un pool de 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 5 Lista de 5 tareas de impresión
        List<TareaImpresion> tareas = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            tareas.add(new TareaImpresion(i));
        }

        // 6 Enviar tareas al executor y guardar los Future
        List<Future<String>> resultados = new ArrayList<>();
        for (TareaImpresion tarea : tareas) {
            resultados.add(executor.submit(tarea));
        }

        // 7 Obtener e imprimir los resultados
        for (Future<String> futuro : resultados) {
            try {
                String resultado = futuro.get(); // Espera a que la tarea termine
                System.out.println(resultado);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 8 Cierre correcto del ExecutorService
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Todas las tareas de impresión han finalizado.");
    }
}