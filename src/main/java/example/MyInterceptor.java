package com.infongen.selenium.example;

import static java.util.Arrays.asList;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class MyInterceptor implements IInvokedMethodListener, IMethodInterceptor {
  Method afterMethod;
  String className;
  String methodName;

  @Override
  public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {}

  @Override
  public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    try {
      if (shouldIntercept(iTestResult)) {
        if (iTestResult
            .getMethod()
            .getConstructorOrMethod()
            .getMethod()
            .isAnnotationPresent(Postcondition.class)) {
          Class<?> afterMethodClass = Class.forName(className);
          Object afterMethodObj = iTestResult.getInstance();
          Method setNameMethod = afterMethodObj.getClass().getMethod(methodName);
          setNameMethod.invoke(afterMethodObj);
        }
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();

    }
  }

  @Override
  public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext context) {
    className = list.get(0).getInstance().getClass().getName();
    Method[] allMethod = (list.get(0).getInstance().getClass()).getMethods();
    for (Method m : allMethod) {
      if (m.isAnnotationPresent(AfterMethod.class)) {
        afterMethod = m;
        methodName = afterMethod.getName();
      }
    }
    return list;
  }

  private boolean shouldIntercept(ITestResult result) {
    List<String> listeners = result.getTestContext().getCurrentXmlTest().getSuite().getListeners();
    return listeners.contains(this.getClass().getName())
        || shouldIntercept(result.getTestClass().getRealClass(), this.getClass());
  }

  private boolean shouldIntercept(Class testClass, Class annotation) {
    Listeners listenersAnnotation = getListenersAnnotation(testClass);
    return listenersAnnotation != null && asList(listenersAnnotation.value()).contains(annotation);
  }

  private Listeners getListenersAnnotation(Class testClass) {
    Annotation annotation = testClass.getAnnotation(Listeners.class);
    return annotation != null
        ? (Listeners) annotation
        : testClass.getSuperclass() != null
            ? getListenersAnnotation(testClass.getSuperclass())
            : null;
  }
}
