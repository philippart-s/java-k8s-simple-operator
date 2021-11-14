package fr.wilda.controller;

import java.io.InputStream;
import fr.wilda.resource.NginxInstallerResource;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.javaoperatorsdk.operator.api.Context;
import io.javaoperatorsdk.operator.api.Controller;
import io.javaoperatorsdk.operator.api.DeleteControl;
import io.javaoperatorsdk.operator.api.ResourceController;
import io.javaoperatorsdk.operator.api.UpdateControl;

@Controller
public class NginxInstallerController implements ResourceController<NginxInstallerResource> {

    private KubernetesClient k8sClient = new DefaultKubernetesClient();

    @Override
    public UpdateControl<NginxInstallerResource> createOrUpdateResource(
            NginxInstallerResource resource, Context<NginxInstallerResource> context) {
        System.out.println("🛠️  Create / update Nginx resource operator ! 🛠️");

        // Load the Nginx deployment
        InputStream is = getClass().getResourceAsStream("/k8s/nginx-deployment.yml");
        Deployment deployment = Serialization.unmarshal(is);
        deployment.getSpec().setReplicas(resource.getSpec().getReplicas());

        // Create the Deployment for Nginx
        k8sClient.apps().deployments().inNamespace(resource.getMetadata().getNamespace())
                .createOrReplace(deployment);

        return UpdateControl.updateCustomResource(resource);
    }

    @Override
    public DeleteControl deleteResource(NginxInstallerResource resource,
            Context<NginxInstallerResource> context) {
        System.out.println("💀 Delete Nginx resource operator ! 💀");

        // Create the Deployment for Nginx
        k8sClient.apps().deployments().inNamespace(resource.getMetadata().getNamespace()).delete();

        return ResourceController.super.deleteResource(resource, context);
    }

}
