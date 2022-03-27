MultiThreading

Operating System

- Computer resource manager among competing tasks

Major function of OS

1- Memory Management
2- Disk Management
3- I/O Management
4- Process Management


What is Process?
- A program in execution 

- Multitasking ( one user can execute more than one programs at the same time) more than one processes 

- Mutiprocessing (more than one Cpus)

-   Process Life Cycle

   1-ready   2- Running  3-waiting 4-sleeping  4-terminate 

- Thread
  - A piece of code than can be independently assigned to cpu
 -  By default all process are threads
 - We can divide one process into several threads according to requirement

MultiThreading

- more than one threads
................................................................................................
Concurrent Programming Using Java Threads

Motivation
- Efficiency
    Downloading network data files
- Convenience
      A clock icon
- Multi-client applications
   HTTP Server, SMTP Server

- Caution
     Significantly harder to debug and maintain


How to Imlplement Mutithreading in Java?

1- Separate class (extend thread)
     Make a self-contained subclass of Thread with the behavior  

2- Implement Runnable Interface
    Implement the Runnable interface and put behavior in the run method of that object 


Thread States
Every Thread has a state and a Thread can be in one of these six states.

   1-new   2- Running  3-blocked  4-sleeping  5- waiting     6-terminate

-new. A state in which a thread has not been started.
- runnable. A state in which a thread is executing.
- blocked. A state in which a thread is waiting for a lock to access an object.
- waiting. A state in which a thread is waiting indefinitely for another thread to perform an action.
- terminated. A state in which a thread has exited.
.............................................................................................
creating Threads
Method 1

class Abc extends Thread {
Abc () { start();}
 public void run () {
      // thread code
 }
}
Method 2

class Abc implements Runnable {
Abc () { Thread t = new Thread();
          t.start();}
 public void run () {
      // thread code
 }
}
...........................................................................................
Example : Create two Thread class Objects

class Abc extends Thread {
Abc () { }

public void run () { // 345}

}  
class XYZ extends Thread {
XYZ () { start();}

public void run () { // 78910}

}
class Main{
public static void (String o[]){
 ///  1 2
Abc ob= new Abc();
  ob.start();
XYZ ob2= new XYZ();


}
}
..........................................................
Example By default every java main method runs in a thread

class Test{
 public static void main (String o[]){
    Thread t=Thread.currentThread();
    System.out.println("Thread Info " + t);
    t.setName("UCP");// change Thread name
    t.setPriority(9);// change Thread Priority
    System.out.println("Thread Info " + t);
 }
}
 
Output
Thread Info : Thread[main,5,main]
Thread Info : Thread[UCP,9,main]
..........................................................
Example Creating Thread Class

class MyThread extends Thread{
  String name;
  MyThread(String name) {
     super(name); 
     this.name=name;
       try{
         start();
        }catch (Exception e ) { }
      
  }

 public void run() {
    System.out.println(name + "  Thread starts ");
    try{
    for (int i=0;i<=5;i++){
        System.out.println(name  + " Thread executes " + i);
        Thread.sleep(500);
    }
    }catch(Exception e ) { }
        System.out.println(name + "  Thread stops ");  
 }
}
class Test{
 public static void main (String o[]){
    MyThread t1= new MyThread("printing");
}
}
...................................................................................
Example : Test class as Thread 

class Test extends Thread{
 public void run() {
    System.out.println("Thread name =" + Thread.currentThread());   
 }
 public static void main (String o[]){
    Thread t=Thread.currentThread();
    Test t1= new Test();
    t1.start();
    Test t2= new Test(); 
    t2.start();    
    System.out.println("Thread Info " + t);
    t.setName("UCP");// change Thread name
    t.setPriority(9);// change Thread Priority
    System.out.println("Thread Info " + t);
 }
}
 
output (By default each thread assigns a name as Thread-0, Thread-1....Thread-n)

Thread Info Thread[main,5,main]
Thread name =Thread[Thread-1,5,main]
Thread name =Thread[Thread-0,5,main]
Thread Info Thread[UCP,9,main]
.................................................................................
Method 2 Implementing Runnable

- Put the actions to be performed in the run method of your existing class
   Have class implement Runnable interface
- If your class already extends some other class , why can't it still extend Thread? 
   Because Java does not support multiple inheritance.
- Construct an instance of Thread passing in the existing object (i.e., the Runnable) 
      Thread t = new Thread(theRunnableObject);
- Call that Thread’s start method
       t.start();

.................................................................................

Example  Creating Thread Class (with Runnable Interface)

class MyThread implements Runnable{
  String name;
  Thread t;
  MyThread(String name) {
     t= new Thread(this,name); 
     this.name=name;
     t.start();      
  }
 public void run() {
    System.out.println(name + "  Thread starts ");
    try{
    for (int i=0;i<=5;i++){
        System.out.println(name  + " Thread executes " + i);
        Thread.sleep(500);
    }
    }catch(Exception e ) { }
        System.out.println(name + "  Thread stops ");  
 }
}
class Test{
 public static void main (String o[]){
    MyThread t1= new MyThread("printing");
}
}
.......................................................................
Example Printing Thread vs Main Thread

class MyThread extends Thread{
  String name;
  MyThread(String name) {
     super(name); 
     this.name=name;
       try{
         start();
       }catch (Exception e ) { }      
  }
 public void run() {
    System.out.println(name + "  Thread starts ");
    try{
    for (int i=0;i<=5;i++){
        System.out.println(name  + " Thread executes " + i);
        Thread.sleep(500);
    }
    }catch(Exception e ) { }
        System.out.println(name + "  Thread stops ");  
 }
}
class Test{
 public static void main (String o[]){
    System.out.println(" Main Thread starts ");
    MyThread t1= new MyThread("printing");
    System.out.println(" Main Thread end ");
}
}

.........................................................................
Example Joining Main Thread with Printing Thread (main thread Wait's for the completion of a printing thread)

class MyThread extends Thread{
  String name;
  MyThread(String name) {
     super(name); 
     this.name=name;
       try{
         start();
       }catch (Exception e ) { }      
  }
 public void run() {
    System.out.println(name + "  Thread starts ");
    try{
    for (int i=0;i<=5;i++){
        System.out.println(name  + " Thread executes " + i);
        Thread.sleep(500);
    }
    }catch(Exception e ) { }
        System.out.println(name + "  Thread stops ");  
 }
}
class Test{
 public static void main (String o[])throws Exception{
    System.out.println(" Main Thread starts ");
    MyThread t1= new MyThread("printing");
    t1.join();
   System.out.println(" Main Thread end ");
 }
}
.......................................................................
Example   Creating two Different Threads with Join 

class MyThread extends Thread{
 MyThread(String n,long s) {
   super(n);
   name = n;
   sleep1=s;
   start();  
  }
public void run () {
try {
     for (int i=1; i<=5; i++){
           System.out.println(name + "  thread executed " +i);
           Thread.sleep(sleep1);
}
  } catch (Exception e ) { e.printStackTrace();}
}
String name;
long sleep1;

}
class Test{
 public static void main(String o[]) throws Exception{
  System.out.println("start  of main");
  MyThread t1= new MyThread("SpellChecker",500);
  MyThread t2= new MyThread("AutoSave",2000);
     for (int i=1; i<=5; i++){
           System.out.println(" main  thread executed " +i);
         // Thread.sleep(1000);
    }
  t1.join(); t2.join();   
  System.out.println("End of main");
}
}
........................................................................

Example  waiting threads with join

class NewThread implements Runnable {
  String name; // name of thread

  Thread t;

  NewThread(String threadname) {
    name = threadname;
    t = new Thread(this, name);
    System.out.println("New thread: " + t);
    t.start(); // Start the thread
  }

  public void run() {
    try {
      for (int i = 5; i > 0; i--) {
        System.out.println(name + ": " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println(name + " interrupted.");
    }
    System.out.println(name + " exiting.");
  }
}

class Test {
  public static void main(String args[]) {
    NewThread ob1 = new NewThread("One");
    NewThread ob2 = new NewThread("Two");
    NewThread ob3 = new NewThread("Three");

    System.out.println("Thread One is alive: " + ob1.t.isAlive());
    System.out.println("Thread Two is alive: " + ob2.t.isAlive());
    System.out.println("Thread Three is alive: " + ob3.t.isAlive());
    try {
      System.out.println("Waiting for threads to finish.");
      ob1.t.join();
      ob2.t.join();
      ob3.t.join();
    } catch (InterruptedException e) {
      System.out.println("Main thread Interrupted");
    }

    System.out.println("Thread One is alive: " + ob1.t.isAlive());
    System.out.println("Thread Two is alive: " + ob2.t.isAlive());
    System.out.println("Thread Three is alive: " + ob3.t.isAlive());

    System.out.println("Main thread exiting.");
  }
}
.................................................................................
Deamon Thread

A thread must be marked as a daemon thread before it is started.


Example Stop all threads after expiry of main Thread with setDaemon method

class MyThread extends Thread{
 MyThread(String n,long s) {
   super(n);
   name = n;
   sleep1=s;
   setDaemon(true);
   start();  
  }
public void run () {
try {
     for (int i=1; i<=5; i++){
           System.out.println(name + "  thread executed " +i);
           Thread.sleep(sleep1);
}
  } catch (Exception e ) { e.printStackTrace();}
}
String name;
long sleep1;

}
class Test{
 public static void main(String o[]) throws Exception{
  System.out.println("start  of main");
  MyThread t1= new MyThread("SpellChecker",500);
  MyThread t2= new MyThread("AutoSave",2000);
     for (int i=1; i<=5; i++){
           System.out.println(" main  thread executed " +i);
           Thread.sleep(1000);
    }

  System.out.println("End of main");
}
}

output

start  of main
main  thread executed 1
SpellChecker  thread executed 1
AutoSave  thread executed 1
SpellChecker  thread executed 2
SpellChecker  thread executed 3
 main  thread executed 2
SpellChecker  thread executed 4
SpellChecker  thread executed 5
AutoSave  thread executed 2
 main  thread executed 3
 main  thread executed 4
 main  thread executed 5
AutoSave  thread executed 3
End of main
.......................................................................
Example Auto save Thread. Saves  data from TextArea

import java.awt.*;
import java.io.*;
class AutoSave implements Runnable{
 AutoSave (TextArea ta){
       this.ta=ta;
 }
 public void run () {
   while (flag)
         save();
 }
 void save (){
  try {
      System.out.println(" autosave thread start ");
      file = new FileOutputStream("c:\\java\\autosave.txt");
      String data= ta.getText();
      if (data.endsWith("end"))
          flag =false;  
      file.write(data.getBytes());
      file.close();
      System.out.println(" autosave thread end ");
      Thread.sleep(9000);
   }catch(Exception e ){ e.printStackTrace(); }
 }
 TextArea ta;
 FileOutputStream file;
 public volatile boolean flag=true;
}

class MyNotePad {
   MyNotePad () {
     Frame f = new Frame ("Autosave");
     f.setSize(500,500);
     ta= new TextArea();
     f.add(ta);
     f.setVisible(true);
  }
TextArea ta;
}

class Test{
   public static void main (String o[]) throws Exception{
        System.out.println(" Start of main ");
        MyNotePad pad=new MyNotePad();
        AutoSave as=new AutoSave(pad.ta);
        Thread t = new Thread (as);
        t.start();
        t.join();
        System.out.println(" End of main ");
}
}
...............................................................................
Data/code Sharing

-synchronization

Example : Three students wants to share single glass without synchronization

class Glass {
void drink (String name) {
try {
System.out.println(name + " s turn");
System.out.println(name + " busy in drinking");
System.out.println(name + " s in breathing");
Thread.sleep(1000);
System.out.println(name + " finishes his job");
System.out.println("......glass is Free....");
 } catch (Exception e )
 { e.printStackTrace();}
}
}
class DrinkWater extends Thread {
DrinkWater (Glass gs, String n)
  { name=n; g=gs; start();} 
public void run () {
       g.drink(name);		
}
String name;
Glass g;
}

class Test{
public static void main (String o[]){
   Glass g= new Glass();
   DrinkWater dw1=new DrinkWater(g,"Usman");
   DrinkWater dw2=new DrinkWater(g,"Faizan");
   DrinkWater dw3=new DrinkWater(g,"bilal");
}
}
Output (may be slightly different in your computer)

Usman s turn
Usman busy in drinking
Usman s in breathing
bilal s turn
bilal busy in drinking
Faizan s turn
Faizan busy in drinking
Faizan s in breathing
bilal s in breathing
Faizan finishes his job
......glass is Free....
bilal finishes his job
......glass is Free....
Usman finishes his job
......glass is Free....
.......................................................................................
Example print coure code and their tiles

class PrintCourse {
  void print(String code,String title) {
    System.out.print(code + " ");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
    System.out.println(title);
  }
}

class Course implements Runnable {
  String code;
  String title;
  PrintCourse target;
  Thread t;
  public Course(PrintCourse targ, String code,String title) {
    target = targ;
    this.code=code;
    this.title=title;
    t = new Thread(this);
    t.start();
  }
  public void run() {
    target.print(code,title);
  }
}

class Test {
  public static void main(String args[]) {
    PrintCourse print = new PrintCourse();
    Course ob1 = new Course(print, "CSDB101","Database Systems");
    Course ob2 = new Course(print, "CSSE102","Software Engineering");
    Course ob3 = new Course(print, "CSPF103","Programming Fundamentals");

    try {
      ob1.t.join();
      ob2.t.join();
      ob3.t.join();
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
  }
}

output

CSDB101 CSPF103 CSSE102 Database Systems
Software Engineering
Programming Fundamentals
......................................................................................
Synchronization 


Example : Three students wants to share single glass (with Synchronized method)

class Glass {

synchronized void drink (String name) {
try {
   System.out.println(name + " s turn");
   System.out.println(name + " busy in drinking");
   System.out.println(name + " s in breathing");
   Thread.sleep(1000);
   System.out.println(name + " finishes his job");
   System.out.println("......glass is Free....");
 } catch (Exception e )
 { e.printStackTrace();}
}
}
class DrinkWater extends Thread {
DrinkWater (Glass gs, String n)
  { name=n; g=gs; start();} 
public void run () {
       g.drink(name);		
}
String name;
Glass g;
}

class Test{
public static void main (String o[]){
   Glass g= new Glass();
   DrinkWater dw1=new DrinkWater(g,"Usman");
   DrinkWater dw2=new DrinkWater(g,"Faizan");
   DrinkWater dw3=new DrinkWater(g,"bilal");
}
}

Output (may be slightly different in your computer)

Usman s turn
Usman busy in drinking
Usman s in breathing
Usman finishes his job
......glass is Free....
bilal s turn
bilal busy in drinking
bilal s in breathing
bilal finishes his job
......glass is Free....
Faizan s turn
Faizan busy in drinking
Faizan s in breathing
Faizan finishes his job
......glass is Free....

..........................................................................................
 Example : Three students wants to share single glass (with Synchronized block)

class Glass {
 void drink (String name) {
  try {
   System.out.println(name + " s turn");
   System.out.println(name + " busy in drinking");
   System.out.println(name + " s in breathing");
   Thread.sleep(1000);
   System.out.println(name + " finishes his job");
   System.out.println("......glass is Free....");
  } catch (Exception e ) { e.printStackTrace();}
 }
}
class DrinkWater extends Thread {
   DrinkWater (Glass gs, String n){
       name=n; 
       g=gs; 
       start();
   } 
 public void run () {
      synchronized(g){
         g.drink(name);		
      }
 }
String name;
Glass g;
}

class Test{
 public static void main (String o[]){
   Glass g= new Glass();
   DrinkWater dw1=new DrinkWater(g,"Usman");
   DrinkWater dw2=new DrinkWater(g,"Faizan");
   DrinkWater dw3=new DrinkWater(g,"bilal");
 }
}

Output (may be slightly different in your computer)

Usman s turn
Usman busy in drinking
Usman s in breathing
Usman finishes his job
......glass is Free....
bilal s turn
bilal busy in drinking
bilal s in breathing
bilal finishes his job
......glass is Free....
Faizan s turn
Faizan busy in drinking
Faizan s in breathing
Faizan finishes his job
......glass is Free....

...................................................................................

Deadlock
 - Java by deafault implement locks in order to conrol synchronization 
 - circular wait due to locking will create deadlock

Example : Deadlock

class A {
  synchronized void foo(B b) {
    String name = Thread.currentThread().getName();

    System.out.println(name + " entered A.foo");

    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      System.out.println("A Interrupted");
    }

    System.out.println(name + " trying to call B.last()");
    b.last();
  }

  synchronized void last() {
    System.out.println("Inside A.last");
  }
}

class B {
  synchronized void bar(A a) {
    String name = Thread.currentThread().getName();
    System.out.println(name + " entered B.bar");

    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      System.out.println("B Interrupted");
    }

    System.out.println(name + " trying to call A.last()");
    a.last();
  }

  synchronized void last() {
    System.out.println("Inside B.last");
  }
}

class Deadlock implements Runnable {
  A a = new A();

  B b = new B();

  Deadlock() {
    Thread.currentThread().setName("MainThread");
    Thread t = new Thread(this, "RacingThread");
    t.start();

    a.foo(b); // get lock on a in this thread.
    System.out.println("Back in main thread");
  }

  public void run() {
    b.bar(a); // get lock on b in other thread.
    System.out.println("Back in other thread");
  }

  public static void main(String args[]) {
    new Deadlock();
  }
}

....................................................................................
Example  Two exclusive  objects (Glass, Plate ) shaared by three students

class Glass {
 synchronized void drink (String name) {
try {
System.out.println(name + "s turn on glass");
System.out.println(name + "busy in drinking");
System.out.println(name + "s in breathing");
Thread.sleep(1000);
System.out.println(name + "finishes his job");
System.out.println("......glass is Free from " + name + ".....");
 } catch (Exception e )
 { e.printStackTrace();}
}
}
class Plate {
 synchronized void eat (String name) {
try {
System.out.println(name + "s turn on plate");
System.out.println(name + "busy in eating");
System.out.println(name + "s in breathing");
Thread.sleep(1000);
System.out.println(name + "finishes his job");
System.out.println("......Plate is Free  from "+ name + ".....");
 } catch (Exception e )
 { e.printStackTrace();}
}
}
class Dinner extends Thread {
Dinner (Glass gs, String n)
  { name=n; g=gs; start();} 
Dinner (Plate p, String n)
  { name=n; pl=p; start();} 
public void run () {
      if (g!=null){
	 g.drink(name);
         new Plate().eat(name);
       }      
       else{
          pl.eat(name);
          new Glass().drink(name);
       }
}
String name;
Glass g=null;
Plate pl=null;
}

class Test{
public static void main (String o[]){
   Glass g= new Glass();
   Plate p= new Plate();
   Dinner dw1=new Dinner(g,"Usman");
   Dinner dw2=new Dinner(p,"Faizan");
   Dinner dw3=new Dinner(g,"Umar");
   Dinner dw4=new Dinner(p,"Ahmed");
}

}
......................................................................
ThreadGroup

- A thread group represents a set of threads. 
- A thread group can also include other thread groups.
- The thread groups form a tree in which every thread group except the initial thread group has a parent.
- A thread is allowed to access information about its own thread group, but not to access information about 
  its thread group's parent thread group or any other thread groups.

Constructor Summary

1- ThreadGroup(String name) 
          Constructs a new thread group.

2- ThreadGroup(ThreadGroup parent, String name) 
          Creates a new thread group.


Example 

class NewThread extends Thread {
  boolean suspendFlag;

  NewThread(String threadname, ThreadGroup tgOb) {
    super(tgOb, threadname);
    suspendFlag = false;
    start();
  }

  public void run() {
    try {
      for (int i = 5; i > 0; i--) {
        System.out.println(getName() + ": " + i);
        Thread.sleep(1000);
        synchronized (this) {
          while (suspendFlag) {
            wait();
          }
        }
      }
    } catch (Exception e) {
      System.out.println("Exception in " + getName());
    }
  }

  void mysuspend() {
    suspendFlag = true;
  }

  synchronized void myresume() {
    suspendFlag = false;
    notify();
  }
}

class Test {
  public static void main(String args[]) {
    ThreadGroup groupA = new ThreadGroup("Group A");
    ThreadGroup groupB = new ThreadGroup("Group B");

    NewThread ob1 = new NewThread("One", groupA);
    NewThread ob2 = new NewThread("Two", groupA);
    NewThread ob3 = new NewThread("Three", groupB);
    NewThread ob4 = new NewThread("Four", groupB);
    
    groupA.list();//Prints information about this thread group to the standard output.
    groupB.list();
    
    //activeCount Returns an estimate of the number of active threads in this thread group.
    Thread tga[] = new Thread[groupA.activeCount()];

    //enumerate copies into the specified array every active thread in this thread group and its subgroups.
    groupA.enumerate(tga); 

    for (int i = 0; i < tga.length; i++) {
      ((NewThread) tga[i]).mysuspend(); 
    }

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted.");
    }

    System.out.println("Resuming Group A");
    for (int i = 0; i < tga.length; i++) {
      ((NewThread) tga[i]).myresume(); 
    }

    try {
      ob1.join();
      ob2.join();
      ob3.join();
      ob4.join();
    } catch (Exception e) {
      System.out.println("Exception in Main thread");
    }
  }
}


output

One: 5
Three: 5
java.lang.ThreadGroup[name=Group A,maxpri=10]
    Thread[One,5,Group A]
    Thread[Two,5,Group A]
java.lang.ThreadGroup[name=Group B,maxpri=10]
    Thread[Three,5,Group B]
  Two: 5
  Four: 5
Thread[Four,5,Group B]
Three: 4
Four: 4
Three: 3
Four: 3
Three: 2
Four: 2
Three: 1
Four: 1
Resuming Group A
One: 4
Two: 4
One: 3
Two: 3
One: 2
Two: 2
Two: 1
One: 1
....................................................................
Samaphore

Example : A semaphore based coordination

import java.util.concurrent.Semaphore;

public class Main {
  public static void main(String args[]) throws Exception {
    Semaphore sem = new Semaphore(1, true);
    Thread thrdA = new Thread(new MyThread(sem, "Message 1"));
    Thread thrdB = new Thread(new MyThread(sem, "Message 2"));

    thrdA.start();
    thrdB.start();

    thrdA.join();
    thrdB.join();

  }
}

class MyThread implements Runnable {
  Semaphore sem;
  String msg;
  MyThread(Semaphore s, String m) {
    sem = s;
    msg = m;
  }

  public void run() {
    try {
      sem.acquire();
      System.out.println(msg);
      Thread.sleep(10);
      sem.release();
    } catch (Exception exc) {
      System.out.println("Error Writing File");
    }
  }
}
.............................................................................




