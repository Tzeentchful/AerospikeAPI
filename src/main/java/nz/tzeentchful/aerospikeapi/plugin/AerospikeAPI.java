package nz.tzeentchful.aerospikeapi.plugin;

import nz.tzeentchful.aerospikeapi.base.APIImpl;
import nz.tzeentchful.aerospikeapi.base.AeroAPI;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class AerospikeAPI extends JavaPlugin {

	private String aerospikeAddress;
	private int aerospikePort;

	@Override
	public void onEnable() {
		loadConfig();
		AeroAPI api = new APIImpl(aerospikeAddress, aerospikePort);
		getServer().getServicesManager().register(AeroAPI.class, api, this, ServicePriority.Normal);
	}

	public void loadConfig() {
		this.saveDefaultConfig();
		FileConfiguration config = getConfig();

		this.aerospikeAddress = config.getString("Aerospike.Address");
		this.aerospikePort = config.getInt("Aerospike.Port");
	}

	
	@Override
	public void onDisable() {
		getServer().getServicesManager().getRegistration(AeroAPI.class)
		.getProvider().close();
	}


}
