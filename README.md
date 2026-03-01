# Concurrent Print Tasks with ExecutorService

## Author
Luis Fernando Monjaraz Briseño

## Description
This Java program demonstrates the use of the ExecutorService framework for managing concurrent tasks. It simulates a printing system where multiple print jobs are processed concurrently by a fixed thread pool.

## Components

### TareaImpresion (PrintTask)
- Implements `Callable<String>` interface
- Simulates document printing with random processing time (1-4 seconds)
- Returns completion message upon successful printing

### Main Class
- Creates a fixed thread pool with 3 worker threads
- Submits 5 print tasks to the executor
- Uses `Future<T>` objects to retrieve results
- Implements proper exception handling

## Features
- **ExecutorService**: Thread pool management and task distribution
- **Callable Tasks**: Tasks that return results via `Future` objects
- **Concurrent Processing**: Multiple documents printed simultaneously
- **Result Retrieval**: Blocking get() calls to wait for task completion
- **Exception Handling**: Proper handling of InterruptedException and ExecutionException

## Key Concepts
- **Thread Pools**: Reusing threads for multiple tasks
- **Callable and Future**: Task execution with return values
- **Concurrency Management**: Controlled parallel execution
- **Task Synchronization**: Waiting for task completion with Future.get()

## How to Compile and Run
```bash
javac concurrent_print_tasks.java
java concurrent_print_tasks
```

## Requirements
- Java 5 or higher (for Executors framework)
- JVM (Java Virtual Machine)

## License
Educational project
