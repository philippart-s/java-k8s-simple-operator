package fr.wilda.controller;

import fr.wilda.resource.HelloWorldCustomResource;
import io.javaoperatorsdk.operator.api.Context;
import io.javaoperatorsdk.operator.api.Controller;
import io.javaoperatorsdk.operator.api.DeleteControl;
import io.javaoperatorsdk.operator.api.ResourceController;
import io.javaoperatorsdk.operator.api.UpdateControl;

@Controller
public class HelloWorldController implements ResourceController<HelloWorldCustomResource> {

  public static final String KIND = "HelloWorldCustomResource";

  public HelloWorldController() {
  }

  @Override
  public DeleteControl deleteResource(HelloWorldCustomResource resource, Context<HelloWorldCustomResource> context) {
    System.out.println(String.format("Goodbye %s 😢", resource.getSpec().getName()));
    return DeleteControl.DEFAULT_DELETE;
  }

  @Override
  public UpdateControl<HelloWorldCustomResource> createOrUpdateResource(
    HelloWorldCustomResource resource, Context<HelloWorldCustomResource> context) {
    System.out.println(String.format("Hello %s 🎉🎉 !!", resource.getSpec().getName()));

    return UpdateControl.updateCustomResource(resource);
  }
}
