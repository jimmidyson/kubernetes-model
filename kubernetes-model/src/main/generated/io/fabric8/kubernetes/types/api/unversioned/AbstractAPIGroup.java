package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * APIGroup contains the name, the supported versions, and the preferred version
 * of a group.
 */
@Value.Immutable
abstract class AbstractAPIGroup {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("APIGroup", "unversioned");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * name is the name of the group.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * versions are the versions supported in this group.
   */
  @JsonProperty("versions")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.unversioned.GroupVersionForDiscovery> getVersions();

  /*
   * preferredVersion is the version preferred by the API server, which
   * probably is the storage version.
   */
  @JsonProperty("preferredVersion")
  public abstract io.fabric8.kubernetes.types.api.unversioned.GroupVersionForDiscovery getPreferredVersion();

  /*
   * a map of client CIDR to server address that is serving this group.
   * This is to help clients reach servers in the most network-efficient way possible.
   * Clients can use the appropriate server address as per the CIDR that they match.
   * In case of multiple matches, clients should use the longest matching CIDR.
   * The server returns only those CIDRs that it thinks that the client can match.
   * For example: the master will return an internal IP CIDR only, if the client reaches the server using an internal IP.
   * Server looks at X-Forwarded-For header or X-Real-Ip header or request.RemoteAddr (in that order) to get the client IP.
   */
  @JsonProperty("serverAddressByClientCIDRs")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.unversioned.ServerAddressByClientCIDR> getServerAddressByClientCIDRs();

}
