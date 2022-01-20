package fr.wilda;

import fr.wilda.controller.HelloWorldReconciler;
import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;

public class HelloWorldRunner {
    public static void main(String[] args) {
      Operator operator = new Operator(DefaultConfigurationService.instance());
      operator.register(new HelloWorldReconciler());

      System.out.println("🚀 Starting HelloWorld operator !!! 🚀");
      operator.start();
    }
  }
