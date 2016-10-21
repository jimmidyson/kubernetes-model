package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext
 * that will be applied to a container.
 */
@Value.Immutable
abstract class AbstractSecurityContextConstraints implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("SecurityContextConstraints", "v1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }


  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Priority influences the sort order of SCCs when evaluating which SCCs to try first for
   * a given pod request based on access in the Users and Groups fields.  The higher the int, the
   * higher priority.  If scores for multiple SCCs are equal they will be sorted by name.
   */
  @JsonProperty("priority")
  public abstract Integer getPriority();

  /*
   * AllowPrivilegedContainer determines if a container can request to be run as privileged.
   */
  @JsonProperty("allowPrivilegedContainer")
  public abstract Boolean isAllowPrivilegedContainer();

  /*
   * DefaultAddCapabilities is the default set of capabilities that will be added to the container
   * unless the pod spec specifically drops the capability.  You may not list a capabiility in both
   * DefaultAddCapabilities and RequiredDropCapabilities.
   */
  @JsonProperty("defaultAddCapabilities")
  public abstract java.util.List<String> getDefaultAddCapabilities();

  /*
   * RequiredDropCapabilities are the capabilities that will be dropped from the container.  These
   * are required to be dropped and cannot be added.
   */
  @JsonProperty("requiredDropCapabilities")
  public abstract java.util.List<String> getRequiredDropCapabilities();

  /*
   * AllowedCapabilities is a list of capabilities that can be requested to add to the container.
   * Capabilities in this field maybe added at the pod author's discretion.
   * You must not list a capability in both AllowedCapabilities and RequiredDropCapabilities.
   */
  @JsonProperty("allowedCapabilities")
  public abstract java.util.List<String> getAllowedCapabilities();

  /*
   * AllowHostDirVolumePlugin determines if the policy allow containers to use the HostDir volume plugin
   * +genconversion=false
   */
  @JsonProperty("allowHostDirVolumePlugin")
  public abstract Boolean isAllowHostDirVolumePlugin();

  /*
   * Volumes is a white list of allowed volume plugins.  FSType corresponds directly with the field names
   * of a VolumeSource (azureFile, configMap, emptyDir).  To allow all volumes you may use '*'.
   */
  @JsonProperty("volumes")
  public abstract java.util.List<String> getVolumes();

  /*
   * AllowHostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
   */
  @JsonProperty("allowHostNetwork")
  public abstract Boolean isAllowHostNetwork();

  /*
   * AllowHostPorts determines if the policy allows host ports in the containers.
   */
  @JsonProperty("allowHostPorts")
  public abstract Boolean isAllowHostPorts();

  /*
   * AllowHostPID determines if the policy allows host pid in the containers.
   */
  @JsonProperty("allowHostPID")
  public abstract Boolean isAllowHostPID();

  /*
   * AllowHostIPC determines if the policy allows host ipc in the containers.
   */
  @JsonProperty("allowHostIPC")
  public abstract Boolean isAllowHostIPC();

  /*
   * SELinuxContext is the strategy that will dictate what labels will be set in the SecurityContext.
   */
  @JsonProperty("seLinuxContext")
  public abstract io.fabric8.kubernetes.types.api.v1.SELinuxContextStrategyOptions getSeLinuxContext();

  /*
   * RunAsUser is the strategy that will dictate what RunAsUser is used in the SecurityContext.
   */
  @JsonProperty("runAsUser")
  public abstract io.fabric8.kubernetes.types.api.v1.RunAsUserStrategyOptions getRunAsUser();

  /*
   * SupplementalGroups is the strategy that will dictate what supplemental groups are used by the SecurityContext.
   */
  @JsonProperty("supplementalGroups")
  public abstract io.fabric8.kubernetes.types.api.v1.SupplementalGroupsStrategyOptions getSupplementalGroups();

  /*
   * FSGroup is the strategy that will dictate what fs group is used by the SecurityContext.
   */
  @JsonProperty("fsGroup")
  public abstract io.fabric8.kubernetes.types.api.v1.FSGroupStrategyOptions getFsGroup();

  /*
   * ReadOnlyRootFilesystem when set to true will force containers to run with a read only root file
   * system.  If the container specifically requests to run with a non-read only root file system
   * the SCC should deny the pod.
   * If set to false the container may run with a read only root file system if it wishes but it
   * will not be forced to.
   */
  @JsonProperty("readOnlyRootFilesystem")
  public abstract Boolean isReadOnlyRootFilesystem();

  /*
   * The users who have permissions to use this security context constraints
   */
  @JsonProperty("users")
  public abstract java.util.List<String> getUsers();

  /*
   * The groups that have permission to use this security context constraints
   */
  @JsonProperty("groups")
  public abstract java.util.List<String> getGroups();

  /*
   * SeccompProfiles lists the allowed profiles that may be set for the pod or
   * container's seccomp annotations.  An unset (nil) or empty value means that no profiles may
   * be specifid by the pod or container.	The wildcard '*' may be used to allow all profiles.  When
   * used to generate a value for a pod the first non-wildcard profile will be used as
   * the default.
   */
  @JsonProperty("seccompProfiles")
  public abstract java.util.List<String> getSeccompProfiles();

}
