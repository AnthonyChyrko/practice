package com.infongen.selenium.example;

import java.util.ArrayList;
import java.util.List;

interface AListener {
  void doEvent();
}

class A {
  List<AListener> listeners = new ArrayList<>();
  public void addListener(AListener listener) {
    listeners.add(listener);
  }

  public void doSomething(){
    System.out.println("Делаем что-то о чем требуется оповестить всех слушателей");
    for( int i = 0; i < listeners.size(); i++ ) {
      listeners.get(i).doEvent(); //class A не знает кто его слушает
    }
  }
}

class B implements AListener {
  public void doEvent(){
    System.out.println("From B.class");
  }
}

class C implements AListener {
  public void doEvent(){
    System.out.println("From C.class");
  }
}


public class ListenerExample {
  public static void main(String[] args) {
    A a = new A();
    B b = new B();
    C c = new C();

    a.addListener(b);
    a.addListener(c);

    a.doSomething(); //Оба объекта b и c выполняют doEvent
  }
}
