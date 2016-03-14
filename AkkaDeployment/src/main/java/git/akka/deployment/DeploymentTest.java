package git.akka.deployment;

import akka.actor.ActorSystem;
import akka.actor.Props;
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
		Config config = ConfigFactory.load("remote.conf");
		ActorSystem system = ActorSystem.create("remoteDeploySystem", config);
	}
	
	public static void startRemote(int port){
		Config config = ConfigFactory.load("remote.conf");
		ActorSystem system = ActorSystem.create("remoteDeploySystem", config);

//		Address addr = new Address("akka.tcp", "sys", "host", 1234);
//		addr = AddressFromURIString.parse("akka.tcp://sys@host:1234"); // the same
//		system.actorOf(Props.create(RemoteDeployActor.class).withDeploy(new Deploy(new RemoteScope(addr))));
		system.actorOf(Props.create(RemoteActor.class), "remoteActor");
	}
}
