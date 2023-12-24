# How use Multithreading In Java
## First step: What is a Thread?
A thread is a single sequential flow of control within a process<br><br>
![image](https://github.com/PellegrinoPiccolo/MultithreadingInJava/assets/152791429/385b7cea-5636-4c35-aa01-c4dc7a5ed045)
<br>
## Multithreading
The multithreading is simultaneous execution (or pseudocontemporary) of different threads within the same process 
## Thread Characteristics
1. **Lightweight Process:** Threads are lighter than processes, sharing resources within a process.

2. **Resource Sharing:** Threads share resources like memory and open files within a process.

3. **Multithreading:** Programs can execute multiple threads simultaneously, leveraging multicore architectures.

4. **Independent Scheduling:** Threads can be scheduled and executed independently by the operating system.

5. **Thread States:** Threads can be in various states during their lifecycle, such as ready, running, waiting, and terminated.

6. **Inter-Thread Communication:** Threads communicate through shared variables, semaphores, mutex, and other synchronization mechanisms.

7. **Synchronization:** Synchronization is essential to prevent issues like race conditions and ensure safe access to shared resources.

8. **Main Thread:** Multithreaded applications have at least one main thread, serving as the program's starting point.

9. **Thread Priority:** Threads can have different priorities affecting their execution sequence.

10. **Thread State Implementation:** Threads can be implemented at the user level (without involving the kernel) or the kernel level.

11. **Deadlock and Starvation:** Incorrect thread handling can lead to deadlock and starvation issues.

12. **Thread Pooling:** Thread pooling is used to manage and reuse threads, improving performance and reducing the overhead of creating new threads.

## Model of implementations
Many to one: 
