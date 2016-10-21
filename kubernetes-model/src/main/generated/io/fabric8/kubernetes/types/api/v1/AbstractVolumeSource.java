package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents the source of a volume to mount.
 * Only one of its members may be specified.
 */
@Value.Immutable
abstract class AbstractVolumeSource {
  /*
   * HostPath represents a pre-existing file or directory on the host
   * machine that is directly exposed to the container. This is generally
   * used for system agents or other privileged things that are allowed
   * to see the host machine. Most containers will NOT need this.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#hostpath
   * ---
   * TODO(jonesdl) We need to restrict who can use host directory mounts and who can/can not
   * mount host directories as read/write.
   */
  @JsonProperty("hostPath")
  public abstract io.fabric8.kubernetes.types.api.v1.HostPathVolumeSource getHostPath();

  /*
   * EmptyDir represents a temporary directory that shares a pod's lifetime.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#emptydir
   */
  @JsonProperty("emptyDir")
  public abstract io.fabric8.kubernetes.types.api.v1.EmptyDirVolumeSource getEmptyDir();

  /*
   * GCEPersistentDisk represents a GCE Disk resource that is attached to a
   * kubelet's host machine and then exposed to the pod.
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
   * GitRepo represents a git repository at a particular revision.
   */
  @JsonProperty("gitRepo")
  public abstract io.fabric8.kubernetes.types.api.v1.GitRepoVolumeSource getGitRepo();

  /*
   * Secret represents a secret that should populate this volume.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#secrets
   */
  @JsonProperty("secret")
  public abstract io.fabric8.kubernetes.types.api.v1.SecretVolumeSource getSecret();

  /*
   * NFS represents an NFS mount on the host that shares a pod's lifetime
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#nfs
   */
  @JsonProperty("nfs")
  public abstract io.fabric8.kubernetes.types.api.v1.NFSVolumeSource getNfs();

  /*
   * ISCSI represents an ISCSI Disk resource that is attached to a
   * kubelet's host machine and then exposed to the pod.
   * More info: http://releases.k8s.io/release-1.3/examples/iscsi/README.md
   */
  @JsonProperty("iscsi")
  public abstract io.fabric8.kubernetes.types.api.v1.ISCSIVolumeSource getIscsi();

  /*
   * Glusterfs represents a Glusterfs mount on the host that shares a pod's lifetime.
   * More info: http://releases.k8s.io/release-1.3/examples/glusterfs/README.md
   */
  @JsonProperty("glusterfs")
  public abstract io.fabric8.kubernetes.types.api.v1.GlusterfsVolumeSource getGlusterfs();

  /*
   * PersistentVolumeClaimVolumeSource represents a reference to a
   * PersistentVolumeClaim in the same namespace.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#persistentvolumeclaims
   */
  @JsonProperty("persistentVolumeClaim")
  public abstract io.fabric8.kubernetes.types.api.v1.PersistentVolumeClaimVolumeSource getPersistentVolumeClaim();

  /*
   * RBD represents a Rados Block Device mount on the host that shares a pod's lifetime.
   * More info: http://releases.k8s.io/release-1.3/examples/rbd/README.md
   */
  @JsonProperty("rbd")
  public abstract io.fabric8.kubernetes.types.api.v1.RBDVolumeSource getRbd();

  /*
   * FlexVolume represents a generic volume resource that is
   * provisioned/attached using a exec based plugin. This is an
   * alpha feature and may change in future.
   */
  @JsonProperty("flexVolume")
  public abstract io.fabric8.kubernetes.types.api.v1.FlexVolumeSource getFlexVolume();

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
   * Flocker represents a Flocker volume attached to a kubelet's host machine. This depends on the Flocker control service being running
   */
  @JsonProperty("flocker")
  public abstract io.fabric8.kubernetes.types.api.v1.FlockerVolumeSource getFlocker();

  /*
   * DownwardAPI represents downward API about the pod that should populate this volume
   */
  @JsonProperty("downwardAPI")
  public abstract io.fabric8.kubernetes.types.api.v1.DownwardAPIVolumeSource getDownwardAPI();

  /*
   * FC represents a Fibre Channel resource that is attached to a kubelet's host machine and then exposed to the pod.
   */
  @JsonProperty("fc")
  public abstract io.fabric8.kubernetes.types.api.v1.FCVolumeSource getFc();

  /*
   * AzureFile represents an Azure File Service mount on the host and bind mount to the pod.
   */
  @JsonProperty("azureFile")
  public abstract io.fabric8.kubernetes.types.api.v1.AzureFileVolumeSource getAzureFile();

  /*
   * ConfigMap represents a configMap that should populate this volume
   */
  @JsonProperty("configMap")
  public abstract io.fabric8.kubernetes.types.api.v1.ConfigMapVolumeSource getConfigMap();

  /*
   * VsphereVolume represents a vSphere volume attached and mounted on kubelets host machine
   */
  @JsonProperty("vsphereVolume")
  public abstract io.fabric8.kubernetes.types.api.v1.VsphereVirtualDiskVolumeSource getVsphereVolume();

  /*
   * Metadata represents metadata about the pod that should populate this volume
   * Deprecated: Use downwardAPI instead.
   * +genconversion=false
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.DeprecatedDownwardAPIVolumeSource getMetadata();

}
