package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NodeSystemInfo is a set of ids/uuids to uniquely identify the node.
 */
@Value.Immutable
abstract class AbstractNodeSystemInfo {
  /*
   * Machine ID reported by the node.
   */
  @JsonProperty("machineID")
  public abstract String getMachineID();

  /*
   * System UUID reported by the node.
   */
  @JsonProperty("systemUUID")
  public abstract String getSystemUUID();

  /*
   * Boot ID reported by the node.
   */
  @JsonProperty("bootID")
  public abstract String getBootID();

  /*
   * Kernel Version reported by the node from 'uname -r' (e.g. 3.16.0-0.bpo.4-amd64).
   */
  @JsonProperty("kernelVersion")
  public abstract String getKernelVersion();

  /*
   * OS Image reported by the node from /etc/os-release (e.g. Debian GNU/Linux 7 (wheezy)).
   */
  @JsonProperty("osImage")
  public abstract String getOsImage();

  /*
   * ContainerRuntime Version reported by the node through runtime remote API (e.g. docker://1.5.0).
   */
  @JsonProperty("containerRuntimeVersion")
  public abstract String getContainerRuntimeVersion();

  /*
   * Kubelet Version reported by the node.
   */
  @JsonProperty("kubeletVersion")
  public abstract String getKubeletVersion();

  /*
   * KubeProxy Version reported by the node.
   */
  @JsonProperty("kubeProxyVersion")
  public abstract String getKubeProxyVersion();

  /*
   * The Operating System reported by the node
   */
  @JsonProperty("operatingSystem")
  public abstract String getOperatingSystem();

  /*
   * The Architecture reported by the node
   */
  @JsonProperty("architecture")
  public abstract String getArchitecture();

}
