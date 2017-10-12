package com.infongen.selenium.example;

import com.google.common.collect.Lists;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.collections.Maps;

public class ConditionsMethodInterceptor implements IMethodInterceptor {

  private Map<String, List<IMethodInstance>> preconditionMethods = Maps.newHashMap();

  @Override
  public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    LinkedList<IMethodInstance> result = Lists.newLinkedList();

    for (IMethodInstance method : methods) {
      Method testMethod = method.getMethod().getConstructorOrMethod().getMethod();
      System.out.println("testMethod = " + testMethod);
//      if (isPrecondition(testMethod)) {
//        Precondition precondition = testMethod.getAnnotation(Precondition.class);
//        List<IMethodInstance> preconditions = preconditionMethods.get(precondition.methodName());
//        if (precondition == null) {
//          preconditions = Lists.newArrayList();
//        }
//        preconditions.add(method);
//        preconditionMethods.put(precondition.methodName(), preconditions);
//      }
    }

    for (IMethodInstance method : methods) {
      Method testMethod = method.getMethod().getConstructorOrMethod().getMethod();
      if (isPrecondition(testMethod)) {
        continue;
      }
      if (hasPreconditions(testMethod.getName())) {
        result.addAll(preconditionMethods.get(testMethod.getName()));
      }
    }

    return result;
  }

  private boolean isPrecondition(Method testMethod) {
    return testMethod.isAnnotationPresent(AfterMethod.class);
  }

  private boolean hasPreconditions(String methodName) {
    return preconditionMethods.containsKey(methodName);
  }
}
