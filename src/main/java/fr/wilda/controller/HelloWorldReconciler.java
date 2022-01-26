package fr.wilda.controller;

import fr.wilda.resource.HelloWorldCustomResource;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.ControllerConfiguration;
import io.javaoperatorsdk.operator.api.reconciler.DeleteControl;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;

@ControllerConfiguration
public class HelloWorldReconciler implements Reconciler<HelloWorldCustomResource> {

  public static final String KIND = "HelloWorldCustomResource";

  public HelloWorldReconciler() {
  }

  @Override
  public DeleteControl cleanup(HelloWorldCustomResource resource, Context context) {
    System.out.println(String.format("Goodbye %s 😢", resource.getSpec().getName()));
    return DeleteControl.defaultDelete();
  }

  @Override
  public UpdateControl<HelloWorldCustomResource> reconcile(
    HelloWorldCustomResource resource, Context context) {
    System.out.println(String.format("Hello %s 🎉🎉 !!", resource.getSpec().getName()));

    return UpdateControl.updateResource(resource);
  }
}
