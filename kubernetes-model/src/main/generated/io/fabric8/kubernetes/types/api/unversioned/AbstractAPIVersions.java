package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * APIVersions lists the versions that are available, to allow clients to
 * discover the API at /api, which is the root path of the legacy v1 API.
 * 
 * +protobuf.options.(gogoproto.goproto_stringer)=false
 */
@Value.Immutable
abstract class AbstractAPIVersions {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("APIVersions", "unversioned");
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
   * versions are the api versions that are available.
   */
  @JsonProperty("versions")
  public abstract java.util.List<String> getVersions();

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
