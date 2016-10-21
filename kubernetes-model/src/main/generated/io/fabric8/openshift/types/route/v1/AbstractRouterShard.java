package io.fabric8.openshift.types.route.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RouterShard has information of a routing shard and is used to
 * generate host names and routing table entries when a routing shard is
 * allocated for a specific route.
 * Caveat: This is WIP and will likely undergo modifications when sharding
 *         support is added.
 */
@Value.Immutable
abstract class AbstractRouterShard {
  /*
   * ShardName uniquely identifies a router shard in the "set" of
   * routers used for routing traffic to the services.
   */
  @JsonProperty("shardName")
  public abstract String getShardName();

  /*
   * DNSSuffix for the shard ala: shard-1.v3.openshift.com
   */
  @JsonProperty("dnsSuffix")
  public abstract String getDnsSuffix();

}
