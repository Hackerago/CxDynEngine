/*******************************************************************************
 * Copyright (c) 2017-2019 Checkmarx
 *  
 * This software is licensed for customer's internal use only.
 *  
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 ******************************************************************************/
package com.checkmarx.engine.azure;

import com.checkmarx.engine.domain.EngineSize;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Map;

@Profile("azure")
@Configuration
@ConfigurationProperties(prefix="cx-azure-engine")
@JsonIgnoreProperties("$$beanFactory")
public class AzureEngineConfig {

	private boolean assignPublicIP = false;
	private int cxEngineTimeoutSec=300;
	private String cxVersion;
	//private String iamProfile; todo equivalent?
	private String imageName;
	private String serverAdmin;
	private String serverPassword;
	private String region;
	private String resourceGroup;
	private String networkName;
	private int launchTimeoutSec=60;
	private int monitorPollingIntervalSecs = 10;
	private String securityGroup;
	private String subnetName;
	private boolean terminateOnStop;
	private boolean usePublicUrlForCx = false;
	private boolean usePublicUrlForMonitor = false;

	private String scriptOnLaunch;
	private String scriptOnTerminate;

	/**
	 * Maps EngineSize to Azure instanceType;
	 * 	key=size (M), 
	 * 	value=ec2 instance type (m4.large)
	 */
	private final Map<String, String> engineSizeMap = Maps.newHashMap();
	
	/**
	 * Maps custom Azure tags to values
	 */
	private final Map<String,String> tagMap = Maps.newHashMap();

	public boolean isAssignPublicIP() {
		return assignPublicIP;
	}

	public void setAssignPublicIP(boolean assignPublicIP) {
		this.assignPublicIP = assignPublicIP;
	}

	/**
	 * Timeout for CxEngine response after Azure instance enters Running state
	 */
	public int getCxEngineTimeoutSec() {
		return cxEngineTimeoutSec;
	}

	public void setCxEngineTimeoutSec(int cxEngineTimeoutSec) {
		this.cxEngineTimeoutSec = cxEngineTimeoutSec;
	}

	public String getCxVersion() {
		return cxVersion;
	}

	public void setCxVersion(String cxVersion) {
		this.cxVersion = cxVersion;
	}

	/*
	public String getIamProfile() {
		return iamProfile;
	}

	public void setIamProfile(String iamProfile) {
		this.iamProfile = iamProfile;
	}*/

	public String getImageName() {
		return imageName;
	}

	public void setImageId(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * Polling interval for monitoring instance/engine launch/startup 
	 */
	public int getMonitorPollingIntervalSecs() {
		return monitorPollingIntervalSecs;
	}

	public void setMonitorPollingIntervalSecs(int monitorPollingIntervalSecs) {
		this.monitorPollingIntervalSecs = monitorPollingIntervalSecs;
	}

	public String getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(String securityGroup) {
		this.securityGroup = securityGroup;
	}

	/**
	 * Timeout to wait for Running state after Azure instance launch
	 */
	public int getLaunchTimeoutSec() {
		return launchTimeoutSec;
	}

	public void setLaunchTimeoutSec(int launchTimeoutSec) {
		this.launchTimeoutSec = launchTimeoutSec;
	}

	public String getSubnetName() {
		return subnetName;
	}

	public void setSubnetId(String subnetName) {
		this.subnetName = subnetName;
	}

	public boolean isTerminateOnStop() {
		return terminateOnStop;
	}

	public void setTerminateOnStop(boolean terminateOnStop) {
		this.terminateOnStop = terminateOnStop;
	}

	public boolean isUsePublicUrlForCx() {
		return usePublicUrlForCx;
	}

	public void setUsePublicUrlForCx(boolean usePublicUrlForCx) {
		this.usePublicUrlForCx = usePublicUrlForCx;
	}

	public boolean isUsePublicUrlForMonitor() {
		return usePublicUrlForMonitor;
	}

	public void setUsePublicUrlForMonitor(boolean usePublicUrlForMonitor) {
		this.usePublicUrlForMonitor = usePublicUrlForMonitor;
	}

	/**
	 * @return script file to execute on engine launch
	 */
	public String getScriptOnLaunch() {
		return scriptOnLaunch;
	}

	public void setScriptOnLaunch(String scriptOnLaunch) {
		this.scriptOnLaunch = scriptOnLaunch;
	}

	/**
	 * @return script file to execute on engine termination
	 */
	public String getScriptOnTerminate() {
		return scriptOnTerminate;
	}

	public void setScriptOnTerminate(String scriptOnTerminate) {
		this.scriptOnTerminate = scriptOnTerminate;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getServerAdmin() {
		return serverAdmin;
	}

	public void setServerAdmin(String serverAdmin) {
		this.serverAdmin = serverAdmin;
	}

	public String getServerPassword() {
		return serverPassword;
	}

	public void setServerPassword(String serverPassword) {
		this.serverPassword = serverPassword;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getResourceGroup() {
		return resourceGroup;
	}

	public void setResourceGroup(String resourceGroup) {
		this.resourceGroup = resourceGroup;
	}

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public void setSubnetName(String subnetName) {
		this.subnetName = subnetName;
	}

	/**
	 * Map of EngineSize to Azure instanceType;
	 * key=size (name), 
	 * value=ec2 instance type (e.g. m4.large)
	 * @see EngineSize
	 */
	public Map<String, String> getEngineSizeMap() {
		return engineSizeMap;
	}

	/**
	 * Map of custom Azure tags
	 *  	key=tag name
	 *  	value=tag value 
	 */
	public Map<String, String> getTagMap() {
		return tagMap;
	}

	public String printEngineSizeMap() {
		final StringBuilder sb = new StringBuilder();
		engineSizeMap.forEach((size,instanceType) ->
			sb.append(String.format("%s->%s, ", size,instanceType)) );
		return sb.toString().replaceAll(", $", ""); 
	}

	private String printEngineTagMap() {
		final StringBuilder sb = new StringBuilder();
		tagMap.forEach((name,value) ->
			sb.append(String.format("%s->%s, ", name,value)) );
		return sb.toString().replaceAll(", $", ""); 
	}

	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("assignPublicIP", assignPublicIP)
				.add("cxEngineTimeoutSec", cxEngineTimeoutSec)
				.add("cxVersion", cxVersion)
				//.add("iamProfile", iamProfile)
				.add("imageName", imageName)
				.add("monitorPollingIntervalSecs", monitorPollingIntervalSecs)
				.add("securityGroup", securityGroup)
				.add("launchTimeoutSec", launchTimeoutSec)
				.add("scriptOnLaunch", scriptOnLaunch)
				.add("scriptOnTerminate", scriptOnTerminate)
				.add("terminateOnStop", terminateOnStop)
				.add("usePublicUrlForCx", usePublicUrlForCx)
				.add("usePublicUrlForMonitor", usePublicUrlForMonitor)
				.add("engineSizeMap", "[" + printEngineSizeMap() +"]")
				.add("engineTagMap", "[" + printEngineTagMap() +"]")
				.toString();
	}

}