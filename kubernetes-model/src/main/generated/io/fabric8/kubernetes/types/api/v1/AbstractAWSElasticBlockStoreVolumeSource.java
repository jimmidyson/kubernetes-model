package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a Persistent Disk resource in AWS.
 * 
 * An AWS EBS disk must exist before mounting to a container. The disk
 * must also be in the same AWS zone as the kubelet. An AWS EBS disk
 * can only be mounted as read/write once. AWS EBS volumes support
 * ownership management and SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractAWSElasticBlockStoreVolumeSource {
  /*
   * Unique ID of the persistent disk resource in AWS (Amazon EBS volume).
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#awselasticblockstore
   */
  @JsonProperty("volumeID")
  public abstract String getVolumeID();

  /*
   * Filesystem type of the volume that you want to mount.
   * Tip: Ensure that the filesystem type is supported by the host operating system.
   * Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#awselasticblockstore
   * TODO: how do we prevent errors in the filesystem from compromising the machine
   */
  @JsonProperty("fsType")
  public abstract String getFsType();

  /*
   * The partition in the volume that you want to mount.
   * If omitted, the default is to mount by volume name.
   * Examples: For volume /dev/sda1, you specify the partition as "1".
   * Similarly, the volume partition for /dev/sda is "0" (or you can leave the property empty).
   */
  @JsonProperty("partition")
  public abstract Integer getPartition();

  /*
   * Specify "true" to force and set the ReadOnly property in VolumeMounts to "true".
   * If omitted, the default is "false".
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#awselasticblockstore
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
