package fr.wilda;

import fr.wilda.controller.NginxInstallerController;
import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;

public class NginxInstallerRunner {
    public static void main(String[] args) {
        Operator operator = new Operator(DefaultConfigurationService.instance());
        operator.register(new NginxInstallerController());
  
        System.out.println("🚀 Starting NginxInstaller operator !!! 🚀");
        operator.start();
      }
}
