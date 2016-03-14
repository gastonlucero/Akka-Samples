package git.akka.deployment;

import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.AddressFromURIString;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.remote.RemoteScope;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 *
 * @author gaston
 */
public class DeploymentTest {

	public static void main(String[] args) {

		startLocal(2000);		
		startRemote(3000);
	}
	public static void startLocal(int port){
		Config config = ConfigFactory.parseString(
				"akka.remote.netty.tcp.port=" + port).withFallback(ConfigFactory.load("remote.conf"));
		ActorSystem system = ActorSystem.create("remoteDeploySystem", config);
	}
	
	public static void startRemote(int port){
		Config config = ConfigFactory.parseString(
				"akka.remote.netty.tcp.port=" + port).withFallback(ConfigFactory.load("remote.conf"));
		ActorSystem system = ActorSystem.create("remoteDeploySystem", config);

		system.actorOf(Props.create(RemoteActor.class), "remoteActor");
		Address addr = new Address("akka.tcp", "remoteDeploySystem", "0.0.0.0", 2000);
		system.actorOf(Props.create(RemoteActor.class).withDeploy(new Deploy(new RemoteScope(addr))));
		Address addr2 = AddressFromURIString.parse("akka.tcp://remoteDeploySystem@0.0.0.0:2000");
		system.actorOf(Props.create(RemoteActor.class).withDeploy(new Deploy(new RemoteScope(addr2))));
	}
}
