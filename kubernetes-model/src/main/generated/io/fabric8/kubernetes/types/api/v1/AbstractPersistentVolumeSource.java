package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PersistentVolumeSource is similar to VolumeSource but meant for the
 * administrator who creates PVs. Exactly one of its members must be set.
 */
@Value.Immutable
abstract class AbstractPersistentVolumeSource {
  /*
   * GCEPersistentDisk represents a GCE Disk resource that is attached to a
   * kubelet's host machine and then exposed to the pod. Provisioned by an admin.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#gcepersistentdisk
   */
  @JsonProperty("gcePersistentDisk")
  public abstract io.fabric8.kubernetes.types.api.v1.GCEPersistentDiskVolumeSource getGcePersistentDisk();

  /*
   * AWSElasticBlockStore represents an AWS Disk resource that is attached to a
   * kubelet's host machine and then exposed to the pod.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#awselasticblockstore
   */
  @JsonProperty("awsElasticBlockStore")
  public abstract io.fabric8.kubernetes.types.api.v1.AWSElasticBlockStoreVolumeSource getAwsElasticBlockStore();

  /*
   * HostPath represents a directory on the host.
   * Provisioned by a developer or tester.
   * This is useful for single-node development and testing only!
   * On-host storage is not supported in any way and WILL NOT WORK in a multi-node cluster.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#hostpath
   */
  @JsonProperty("hostPath")
  public abstract io.fabric8.kubernetes.types.api.v1.HostPathVolumeSource getHostPath();

  /*
   * Glusterfs represents a Glusterfs volume that is attached to a host and
   * exposed to the pod. Provisioned by an admin.
   * More info: http://releases.k8s.io/release-1.3/examples/glusterfs/README.md
   */
  @JsonProperty("glusterfs")
  public abstract io.fabric8.kubernetes.types.api.v1.GlusterfsVolumeSource getGlusterfs();

  /*
   * NFS represents an NFS mount on the host. Provisioned by an admin.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#nfs
   */
  @JsonProperty("nfs")
  public abstract io.fabric8.kubernetes.types.api.v1.NFSVolumeSource getNfs();

  /*
   * RBD represents a Rados Block Device mount on the host that shares a pod's lifetime.
   * More info: http://releases.k8s.io/release-1.3/examples/rbd/README.md
   */
  @JsonProperty("rbd")
  public abstract io.fabric8.kubernetes.types.api.v1.RBDVolumeSource getRbd();

  /*
   * ISCSI represents an ISCSI Disk resource that is attached to a
   * kubelet's host machine and then exposed to the pod. Provisioned by an admin.
   */
  @JsonProperty("iscsi")
  public abstract io.fabric8.kubernetes.types.api.v1.ISCSIVolumeSource getIscsi();

  /*
   * Cinder represents a cinder volume attached and mounted on kubelets host machine
   * More info: http://releases.k8s.io/release-1.3/examples/mysql-cinder-pd/README.md
   */
  @JsonProperty("cinder")
  public abstract io.fabric8.kubernetes.types.api.v1.CinderVolumeSource getCinder();

  /*
   * CephFS represents a Ceph FS mount on the host that shares a pod's lifetime
   */
  @JsonProperty("cephfs")
  public abstract io.fabric8.kubernetes.types.api.v1.CephFSVolumeSource getCephfs();

  /*
   * FC represents a Fibre Channel resource that is attached to a kubelet's host machine and then exposed to the pod.
   */
  @JsonProperty("fc")
  public abstract io.fabric8.kubernetes.types.api.v1.FCVolumeSource getFc();

  /*
   * Flocker represents a Flocker volume attached to a kubelet's host machine and exposed to the pod for its usage. This depends on the Flocker control service being running
   */
  @JsonProperty("flocker")
  public abstract io.fabric8.kubernetes.types.api.v1.FlockerVolumeSource getFlocker();

  /*
   * FlexVolume represents a generic volume resource that is
   * provisioned/attached using a exec based plugin. This is an
   * alpha feature and may change in future.
   */
  @JsonProperty("flexVolume")
  public abstract io.fabric8.kubernetes.types.api.v1.FlexVolumeSource getFlexVolume();

  /*
   * AzureFile represents an Azure File Service mount on the host and bind mount to the pod.
   */
  @JsonProperty("azureFile")
  public abstract io.fabric8.kubernetes.types.api.v1.AzureFileVolumeSource getAzureFile();

  /*
   * VsphereVolume represents a vSphere volume attached and mounted on kubelets host machine
   */
  @JsonProperty("vsphereVolume")
  public abstract io.fabric8.kubernetes.types.api.v1.VsphereVirtualDiskVolumeSource getVsphereVolume();

}
