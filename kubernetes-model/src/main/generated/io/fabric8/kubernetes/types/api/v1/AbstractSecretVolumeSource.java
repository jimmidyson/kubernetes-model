package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Adapts a Secret into a volume.
 * 
 * The contents of the target Secret's Data field will be presented in a volume
 * as files using the keys in the Data field as the file names.
 * Secret volumes support ownership management and SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractSecretVolumeSource {
  /*
   * Name of the secret in the pod's namespace to use.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#secrets
   */
  @JsonProperty("secretName")
  public abstract String getSecretName();

  /*
   * If unspecified, each key-value pair in the Data field of the referenced
   * Secret will be projected into the volume as a file whose name is the
   * key and content is the value. If specified, the listed keys will be
   * projected into the specified paths, and unlisted keys will not be
   * present. If a key is specified which is not present in the Secret,
   * the volume setup will error. Paths must be relative and may not contain
   * the '..' path or start with '..'.
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.KeyToPath> getItems();

}
