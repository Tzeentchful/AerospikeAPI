package nz.tzeentchful.aerospikeapi.base;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.async.AsyncClient;
import com.aerospike.client.policy.WritePolicy;

public interface AeroAPI {
	
	public AerospikeClient getSyncClient();
	
	public AsyncClient getAsyncClient();
	
	public WritePolicy getPolicy();
	
	public void close();

}
