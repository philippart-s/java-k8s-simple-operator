package fr.wilda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.wilda.resource.HelloWorldCustomResource;
import io.javaoperatorsdk.operator.api.Context;
import io.javaoperatorsdk.operator.api.Controller;
import io.javaoperatorsdk.operator.api.DeleteControl;
import io.javaoperatorsdk.operator.api.ResourceController;
import io.javaoperatorsdk.operator.api.UpdateControl;

@Controller
public class HelloWorldController implements ResourceController<HelloWorldCustomResource> {

  public static final String KIND = "HelloWorldCustomResource";
  private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

  public HelloWorldController() {
  }

  @Override
  public DeleteControl deleteResource(HelloWorldCustomResource resource, Context<HelloWorldCustomResource> context) {
    log.info("Goodbye {} 😢", resource.getMetadata().getName());
    return DeleteControl.DEFAULT_DELETE;
  }

  @Override
  public UpdateControl<HelloWorldCustomResource> createOrUpdateResource(
    HelloWorldCustomResource resource, Context<HelloWorldCustomResource> context) {
    log.info("Hello {} 🎉🎉 !!", resource.getMetadata().getName());

    return UpdateControl.updateCustomResource(resource);
  }
}
