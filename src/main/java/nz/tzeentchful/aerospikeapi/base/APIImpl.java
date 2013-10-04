package nz.tzeentchful.aerospikeapi.base;

import lombok.Getter;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.async.AsyncClient;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;

public class APIImpl implements AeroAPI {

	@Getter
	private AsyncClient asyncClient = null;
	@Getter
	private AerospikeClient syncClient = null;
	@Getter
	private WritePolicy policy = null;

	public APIImpl(String address, int port) {
		try {
			asyncClient = new AsyncClient(address, port);
			syncClient = new AerospikeClient(address, port);
			policy = new WritePolicy();
			policy.timeout = 50;
			policy.recordExistsAction = RecordExistsAction.UPDATE;
		} catch (AerospikeException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		asyncClient.close();
		syncClient.close();
	}
}
