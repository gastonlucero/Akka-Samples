package git.akka.deployment;

import akka.actor.UntypedActor;

/**
 *
 * @author gaston
 */
public class RemoteActor extends UntypedActor {

	public RemoteActor() {
		System.out.println("Hola soy el actor deployado remotamente ");
	}

	
	
	@Override
	public void onReceive(Object message) throws Exception {
		
	}

}
