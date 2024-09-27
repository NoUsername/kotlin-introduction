package com.examplejava;

import com.example.interop.Interop;
import com.example.interop.InteropKt;
import com.example.interop.InteropObject;

public class TestInterop {

  public static void main(String[] args) {
    final var interop = new Interop();

    System.out.println(interop.normalMethod());
    System.out.println(interop.normalMethod());

    System.out.println(interop.getStringProperty());
    System.out.println(interop.getStringProperty());

    System.out.println(interop.getMutableStringProperty());
    interop.setMutableStringProperty("test");
    System.out.println(interop.getMutableStringProperty());

    System.out.println(interop.getLazyString());
    System.out.println(interop.getLazyString());

    System.out.println(Interop.Companion.methodFromCompanion());
    System.out.println(Interop.Companion.methodFromCompanion());

    System.out.println(InteropObject.INSTANCE.methodFromObject());
    System.out.println(InteropObject.INSTANCE.methodFromObject());

    System.out.println(InteropKt.classlessMethod());
    System.out.println(InteropKt.classlessMethod());

    System.out.println(InteropKt.getClasslessVal());
    System.out.println(InteropKt.getClasslessVal());
  }
}
