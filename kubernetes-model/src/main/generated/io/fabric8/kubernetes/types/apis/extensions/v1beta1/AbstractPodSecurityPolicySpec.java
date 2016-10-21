package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Pod Security Policy Spec defines the policy enforced.
 */
@Value.Immutable
abstract class AbstractPodSecurityPolicySpec {
  /*
   * privileged determines if a pod can request to be run as privileged.
   */
  @JsonProperty("privileged")
  public abstract Boolean isPrivileged();

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
   * Capabilities in this field may be added at the pod author's discretion.
   * You must not list a capability in both AllowedCapabilities and RequiredDropCapabilities.
   */
  @JsonProperty("allowedCapabilities")
  public abstract java.util.List<String> getAllowedCapabilities();

  /*
   * volumes is a white list of allowed volume plugins.  Empty indicates that all plugins
   * may be used.
   */
  @JsonProperty("volumes")
  public abstract java.util.List<String> getVolumes();

  /*
   * hostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
   */
  @JsonProperty("hostNetwork")
  public abstract Boolean isHostNetwork();

  /*
   * hostPorts determines which host port ranges are allowed to be exposed.
   */
  @JsonProperty("hostPorts")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.HostPortRange> getHostPorts();

  /*
   * hostPID determines if the policy allows the use of HostPID in the pod spec.
   */
  @JsonProperty("hostPID")
  public abstract Boolean isHostPID();

  /*
   * hostIPC determines if the policy allows the use of HostIPC in the pod spec.
   */
  @JsonProperty("hostIPC")
  public abstract Boolean isHostIPC();

  /*
   * seLinux is the strategy that will dictate the allowable labels that may be set.
   */
  @JsonProperty("seLinux")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.SELinuxStrategyOptions getSeLinux();

  /*
   * runAsUser is the strategy that will dictate the allowable RunAsUser values that may be set.
   */
  @JsonProperty("runAsUser")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.RunAsUserStrategyOptions getRunAsUser();

  /*
   * SupplementalGroups is the strategy that will dictate what supplemental groups are used by the SecurityContext.
   */
  @JsonProperty("supplementalGroups")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.SupplementalGroupsStrategyOptions getSupplementalGroups();

  /*
   * FSGroup is the strategy that will dictate what fs group is used by the SecurityContext.
   */
  @JsonProperty("fsGroup")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.FSGroupStrategyOptions getFsGroup();

  /*
   * ReadOnlyRootFilesystem when set to true will force containers to run with a read only root file
   * system.  If the container specifically requests to run with a non-read only root file system
   * the PSP should deny the pod.
   * If set to false the container may run with a read only root file system if it wishes but it
   * will not be forced to.
   */
  @JsonProperty("readOnlyRootFilesystem")
  public abstract Boolean isReadOnlyRootFilesystem();

}
