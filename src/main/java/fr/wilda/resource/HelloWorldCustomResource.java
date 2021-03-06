package fr.wilda.resource;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("fr.wilda")
@Version("v1")
@ShortNames("hw")
public class HelloWorldCustomResource extends CustomResource<HelloWorldSpec, Void> implements Namespaced {

}
