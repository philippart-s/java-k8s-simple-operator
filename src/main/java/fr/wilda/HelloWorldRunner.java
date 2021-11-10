package fr.wilda;

import fr.wilda.controller.HelloWorldController;
import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;

public class HelloWorldRunner {
    public static void main(String[] args) {
      Operator operator = new Operator(DefaultConfigurationService.instance());
      operator.register(new HelloWorldController());
    }
  }
