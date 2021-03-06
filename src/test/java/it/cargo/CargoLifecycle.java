package it.cargo;

import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.cargo.container.ContainerType;
import org.codehaus.cargo.container.InstalledLocalContainer;
import org.codehaus.cargo.container.configuration.ConfigurationType;
import org.codehaus.cargo.container.configuration.LocalConfiguration;
import org.codehaus.cargo.container.deployable.WAR;
import org.codehaus.cargo.container.installer.Installer;
import org.codehaus.cargo.container.installer.ZipURLInstaller;
import org.codehaus.cargo.container.property.ServletPropertySet;
import org.codehaus.cargo.container.tomcat.TomcatPropertySet;
import org.codehaus.cargo.generic.DefaultContainerFactory;
import org.codehaus.cargo.generic.configuration.DefaultConfigurationFactory;

public class CargoLifecycle {

	private final String TOMCAT_7_ZIP_LOCATION = "http://archive.apache.org/dist/tomcat/tomcat-7/v7.0.42/bin/apache-tomcat-7.0.42.zip";
	private InstalledLocalContainer container;

	public void start() throws MalformedURLException {
		System.out.println("Starting Tomcat 7");
		final Installer installer = new ZipURLInstaller(new URL(TOMCAT_7_ZIP_LOCATION));
		installer.install();
		final DefaultConfigurationFactory defaultConfigurationFactory = new DefaultConfigurationFactory();
		final LocalConfiguration configuration = (LocalConfiguration) defaultConfigurationFactory.createConfiguration("tomcat7x",
				ContainerType.INSTALLED, ConfigurationType.STANDALONE);
		configuration.setProperty(ServletPropertySet.PORT, "8280");
		configuration.setProperty(TomcatPropertySet.AJP_PORT, "8209");

		final DefaultContainerFactory defaultContainerFactory = new DefaultContainerFactory();
		container = (InstalledLocalContainer) defaultContainerFactory.createContainer("tomcat7x", ContainerType.INSTALLED,
				configuration);
		container.setHome(installer.getHome());

		final WAR deployable = new WAR("./target/vettel.war");
		deployable.setContext("vettel");
		configuration.addDeployable(deployable);

		container.start();

	}

	public void stop() {
		System.out.println("Stopping Tomcat 7");
		container.stop();
	}
}
