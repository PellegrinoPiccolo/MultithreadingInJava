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
- **Many to one**: Threads are implemented at the application level, their scheduler runs in user space, and is not part of the OS.
  - Cost-effective scheduling
  - Loss of parallelism
- **One to one**: Threads are handled directly by the O.S. as primitive entities (native threads)
  - Very efficient scheduling
  - High creation and synchronization times
- **Many to many**: l S.O. has a pool of native threads (workers), e.g. each of which is assigned from time to time a Application threads (user threads) to be executed
  - Efficient and inexpensive to create and manage a thread
  - Very flexible
  - Difficult to define the size of the workers and how the two will cooperate Scheduler
## Group of threads
**Objective**: Collect a multiplicity of threadswithin a single group to facilitate management operations (e.g. suspend/ Stop/restart the execution of a set of threads with a single invocation).<br>
In Java, the JVM associates eachthread to a group when the thread. **This association is permanent and cannot be modified**.
```java
ThreadGroup myThreadGroup = new ThreadGroup("My group");
Thread myThread = new Thread(myThreadGroup, "MyThread");
```
**Default choice**: The JVM creates a Thread group called "**main**", which will be the default group.
## Daemon thread
In general, daemons are processes thatPerform an endless loop of waiting for requests and execution of the same.<br>
Java recognizes the importance of daemon threads and It introduces two types of threads:
- **User thread**
- **Daemon thread**

**The only difference**: When JVM termined the last user thread, also ends the deamon thread execution.<br>
## Implementation Policies
- **Native threads**: the JVM uses support for the multithreading provided by the O.S.
- **Green-thread**: the JVM shall take full responsibility for themanagement of threads, ignored by the O.S. that sees the JVM as a single-threaded process.
## Language level
Java provides two ways to implement thread:
1. as a subclass of the `Thread` class
2. as a class that implements the interface `Runnable`
## Thread class VS Runnable interface
- **Thread class**:
  - More immediate and simple mode
  - Lack of flexibility resulting from the need to inherit from the Thread class, which prevents you from inheriting from other classes
- **Runnable interface**:
  - Greater flexibility resulting from being able to be a subclass of any other class, useful to overcome the impossibility of having multiple inheritance in Java
  - Less simple and more cumbersome mode
## Control methods for thread
- `start()`
  - Starts the execution of a thread. The JVM invokes the `run()` method of the newly created thread
- `sleep(long time)`
  - Blocks a thread from executing for the `time` specified in time.
- `join()`
  - Blocks the calling thread while waiting for the thread on which you invoke the method to terminate.
## How to Fix the Critical Section
To solve this problem we can use synchronization with keywork `synchronized`
We can use it on different scope:
- Single Method
- Single Class Method
- Instruction Block
```java
public void NameMethod(){
  synchronized(this){
    //operation with synchronization
  }
}
```
```java
public synchronized void NameMethod(){
  //operation
}
```
## Synchronizing Threads with wait and notify
There are several methods for synchronizing:
- `wait()`
  - Blocks the invoking thread from executing while waiting for another thread to invoke the `notify()` or `notifyAll()` methods for that object.
- `notify()`
  - Wakes up a single thread among those that are waiting. If more than one thread is waiting, the choice is arbitrary.
- `notifyAll()`
  - Exactly like `notify()`, but it wakes up all threads waiting for the object in question.
```java
public synchronized int get(){
  while(avaible == false){
    try{
      wait();
    }catch (InterruptedException e){}
  }
  avaible = false;
  notifyAll();
  //Operion of get method
}
```
```java
public synchronized void push(int value){
  while(avaible == true){
    try{
      wait();
    } catch(InterruptedException e){}
  }
  avaible = true;
  notifyAll();
}
```
