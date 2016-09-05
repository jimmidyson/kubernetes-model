/*
* CODE GENERATED AUTOMATICALLY
* THIS FILE SHOULD NOT BE EDITED BY HAND
 */

package main

import (
	"github.com/fabric8io/kubernetes-model/pkg/schemagen"
	github_com_openshift_origin_pkg_authorization_api_v1 "github.com/openshift/origin/pkg/authorization/api/v1"
	github_com_openshift_origin_pkg_build_api_v1 "github.com/openshift/origin/pkg/build/api/v1"
	github_com_openshift_origin_pkg_deploy_api_v1 "github.com/openshift/origin/pkg/deploy/api/v1"
	github_com_openshift_origin_pkg_image_api_v1 "github.com/openshift/origin/pkg/image/api/v1"
	github_com_openshift_origin_pkg_oauth_api_v1 "github.com/openshift/origin/pkg/oauth/api/v1"
	github_com_openshift_origin_pkg_project_api_v1 "github.com/openshift/origin/pkg/project/api/v1"
	github_com_openshift_origin_pkg_quota_api_v1 "github.com/openshift/origin/pkg/quota/api/v1"
	github_com_openshift_origin_pkg_route_api_v1 "github.com/openshift/origin/pkg/route/api/v1"
	github_com_openshift_origin_pkg_sdn_api_v1 "github.com/openshift/origin/pkg/sdn/api/v1"
	github_com_openshift_origin_pkg_security_api_v1 "github.com/openshift/origin/pkg/security/api/v1"
	github_com_openshift_origin_pkg_template_api_v1 "github.com/openshift/origin/pkg/template/api/v1"
	github_com_openshift_origin_pkg_user_api_v1 "github.com/openshift/origin/pkg/user/api/v1"
	k8s_io_kubernetes_pkg_api_resource "k8s.io/kubernetes/pkg/api/resource"
	k8s_io_kubernetes_pkg_api_unversioned "k8s.io/kubernetes/pkg/api/unversioned"
	k8s_io_kubernetes_pkg_api_v1 "k8s.io/kubernetes/pkg/api/v1"
	k8s_io_kubernetes_pkg_apis_apps_v1alpha1 "k8s.io/kubernetes/pkg/apis/apps/v1alpha1"
	k8s_io_kubernetes_pkg_apis_authentication_v1beta1 "k8s.io/kubernetes/pkg/apis/authentication/v1beta1"
	k8s_io_kubernetes_pkg_apis_authorization_v1beta1 "k8s.io/kubernetes/pkg/apis/authorization/v1beta1"
	k8s_io_kubernetes_pkg_apis_autoscaling_v1 "k8s.io/kubernetes/pkg/apis/autoscaling/v1"
	k8s_io_kubernetes_pkg_apis_batch_v1 "k8s.io/kubernetes/pkg/apis/batch/v1"
	k8s_io_kubernetes_pkg_apis_batch_v2alpha1 "k8s.io/kubernetes/pkg/apis/batch/v2alpha1"
	k8s_io_kubernetes_pkg_apis_extensions_v1beta1 "k8s.io/kubernetes/pkg/apis/extensions/v1beta1"
	k8s_io_kubernetes_pkg_apis_policy_v1alpha1 "k8s.io/kubernetes/pkg/apis/policy/v1alpha1"
	k8s_io_kubernetes_pkg_apis_rbac_v1alpha1 "k8s.io/kubernetes/pkg/apis/rbac/v1alpha1"
	k8s_io_kubernetes_pkg_runtime "k8s.io/kubernetes/pkg/runtime"
	k8s_io_kubernetes_pkg_util_intstr "k8s.io/kubernetes/pkg/util/intstr"
	k8s_io_kubernetes_pkg_watch_versioned "k8s.io/kubernetes/pkg/watch/versioned"
)

var packages = []schemagen.PackageDescriptor{
	{"k8s.io/kubernetes/pkg/api/v1", "io.fabric8.kubernetes.api.model.v1", "kubernetes_api_v1_"},
	{"github.com/openshift/origin/pkg/oauth/api/v1", "io.fabric8.openshift.api.model.oauth.v1", "os_oauth_v1_"},
	{"github.com/openshift/origin/pkg/security/api/v1", "io.fabric8.openshift.api.model.security.v1", "os_security_v1_"},
	{"github.com/openshift/origin/pkg/sdn/api/v1", "io.fabric8.openshift.api.model.sdn.v1", "os_sdn_v1_"},
	{"github.com/openshift/origin/pkg/user/api/v1", "io.fabric8.openshift.api.model.user.v1", "os_user_v1_"},
	{"github.com/openshift/origin/pkg/template/api/v1", "io.fabric8.openshift.api.model.template.v1", "os_template_v1_"},
	{"k8s.io/kubernetes/pkg/runtime", "io.fabric8.kubernetes.api.model.runtime", "kubernetes_runtime_"},
	{"k8s.io/kubernetes/pkg/apis/rbac/v1alpha1", "io.fabric8.kubernetes.api.model.rbac.v1alpha1", "kubernetes_rbac_v1alpha1_"},
	{"k8s.io/kubernetes/pkg/watch/versioned", "io.fabric8.kubernetes.api.model.watch.versioned", "kubernetes_watch_versioned_"},
	{"k8s.io/kubernetes/pkg/apis/batch/v2alpha1", "io.fabric8.kubernetes.api.model.batch.v2alpha1", "kubernetes_batch_v2alpha1_"},
	{"github.com/openshift/origin/pkg/authorization/api/v1", "io.fabric8.openshift.api.model.authorization.v1", "os_authorization_v1_"},
	{"k8s.io/kubernetes/pkg/api/unversioned", "io.fabric8.kubernetes.api.model", "kubernetes_api_unversioned_"},
	{"github.com/openshift/origin/pkg/image/api/v1", "io.fabric8.openshift.api.model.image.v1", "os_image_v1_"},
	{"k8s.io/kubernetes/pkg/util/intstr", "io.fabric8.kubernetes.api.model.util.intstr", "kubernetes_util_intstr_"},
	{"github.com/openshift/origin/pkg/route/api/v1", "io.fabric8.openshift.api.model.route.v1", "os_route_v1_"},
	{"k8s.io/kubernetes/pkg/apis/authentication/v1beta1", "io.fabric8.kubernetes.api.model.authentication.v1beta1", "kubernetes_authentication_v1beta1_"},
	{"k8s.io/kubernetes/pkg/apis/authorization/v1beta1", "io.fabric8.kubernetes.api.model.authorization.v1beta1", "kubernetes_authorization_v1beta1_"},
	{"k8s.io/kubernetes/pkg/api/resource", "io.fabric8.kubernetes.api.model.resource", "kubernetes_api_resource_"},
	{"github.com/openshift/origin/pkg/quota/api/v1", "io.fabric8.openshift.api.model.quota.v1", "os_quota_v1_"},
	{"github.com/openshift/origin/pkg/deploy/api/v1", "io.fabric8.openshift.api.model.deploy.v1", "os_deploy_v1_"},
	{"k8s.io/kubernetes/pkg/apis/policy/v1alpha1", "io.fabric8.kubernetes.api.model.policy.v1alpha1", "kubernetes_policy_v1alpha1_"},
	{"k8s.io/kubernetes/pkg/apis/autoscaling/v1", "io.fabric8.kubernetes.api.model.autoscaling.v1", "kubernetes_autoscaling_v1_"},
	{"k8s.io/kubernetes/pkg/apis/batch/v1", "io.fabric8.kubernetes.api.model.batch.v1", "kubernetes_batch_v1_"},
	{"github.com/openshift/origin/pkg/build/api/v1", "io.fabric8.openshift.api.model.build.v1", "os_build_v1_"},
	{"k8s.io/kubernetes/pkg/apis/apps/v1alpha1", "io.fabric8.kubernetes.api.model.apps.v1alpha1", "kubernetes_apps_v1alpha1_"},
	{"k8s.io/kubernetes/pkg/apis/extensions/v1beta1", "io.fabric8.kubernetes.api.model.extensions.v1beta1", "kubernetes_extensions_v1beta1_"},
	{"github.com/openshift/origin/pkg/project/api/v1", "io.fabric8.openshift.api.model.project.v1", "os_project_v1_"},
}

type Schema struct {
	F0_0    k8s_io_kubernetes_pkg_api_v1.AWSElasticBlockStoreVolumeSource
	F0_2    k8s_io_kubernetes_pkg_api_v1.Affinity
	F0_3    k8s_io_kubernetes_pkg_api_v1.AttachedVolume
	F0_4    k8s_io_kubernetes_pkg_api_v1.AzureFileVolumeSource
	F0_5    k8s_io_kubernetes_pkg_api_v1.Binding
	F0_6    k8s_io_kubernetes_pkg_api_v1.Capabilities
	F0_8    k8s_io_kubernetes_pkg_api_v1.CephFSVolumeSource
	F0_9    k8s_io_kubernetes_pkg_api_v1.CinderVolumeSource
	F0_14   k8s_io_kubernetes_pkg_api_v1.ComponentCondition
	F0_17   k8s_io_kubernetes_pkg_api_v1.ComponentStatus
	F0_18   k8s_io_kubernetes_pkg_api_v1.ComponentStatusList
	F0_23   k8s_io_kubernetes_pkg_api_v1.ConfigMap
	F0_24   k8s_io_kubernetes_pkg_api_v1.ConfigMapKeySelector
	F0_25   k8s_io_kubernetes_pkg_api_v1.ConfigMapList
	F0_26   k8s_io_kubernetes_pkg_api_v1.ConfigMapVolumeSource
	F0_27   k8s_io_kubernetes_pkg_api_v1.Container
	F0_28   k8s_io_kubernetes_pkg_api_v1.ContainerImage
	F0_29   k8s_io_kubernetes_pkg_api_v1.ContainerPort
	F0_30   k8s_io_kubernetes_pkg_api_v1.ContainerState
	F0_31   k8s_io_kubernetes_pkg_api_v1.ContainerStateRunning
	F0_32   k8s_io_kubernetes_pkg_api_v1.ContainerStateTerminated
	F0_33   k8s_io_kubernetes_pkg_api_v1.ContainerStateWaiting
	F0_34   k8s_io_kubernetes_pkg_api_v1.ContainerStatus
	F0_351  k8s_io_kubernetes_pkg_api_v1.DaemonEndpoint
	F0_512  k8s_io_kubernetes_pkg_api_v1.DeleteOptions
	F0_513  k8s_io_kubernetes_pkg_api_v1.DeprecatedDownwardAPIVolumeFile
	F0_514  k8s_io_kubernetes_pkg_api_v1.DeprecatedDownwardAPIVolumeSource
	F0_516  k8s_io_kubernetes_pkg_api_v1.DownwardAPIVolumeFile
	F0_517  k8s_io_kubernetes_pkg_api_v1.DownwardAPIVolumeSource
	F0_518  k8s_io_kubernetes_pkg_api_v1.EmptyDirVolumeSource
	F0_519  k8s_io_kubernetes_pkg_api_v1.EndpointAddress
	F0_520  k8s_io_kubernetes_pkg_api_v1.EndpointPort
	F0_521  k8s_io_kubernetes_pkg_api_v1.EndpointSubset
	F0_522  k8s_io_kubernetes_pkg_api_v1.Endpoints
	F0_523  k8s_io_kubernetes_pkg_api_v1.EndpointsList
	F0_524  k8s_io_kubernetes_pkg_api_v1.EnvVar
	F0_525  k8s_io_kubernetes_pkg_api_v1.EnvVarSource
	F0_528  k8s_io_kubernetes_pkg_api_v1.Event
	F0_529  k8s_io_kubernetes_pkg_api_v1.EventList
	F0_530  k8s_io_kubernetes_pkg_api_v1.EventSource
	F0_533  k8s_io_kubernetes_pkg_api_v1.ExecAction
	F0_534  k8s_io_kubernetes_pkg_api_v1.ExportOptions
	F0_535  k8s_io_kubernetes_pkg_api_v1.FCVolumeSource
	F0_537  k8s_io_kubernetes_pkg_api_v1.FSGroupStrategyOptions
	F0_563  k8s_io_kubernetes_pkg_api_v1.FlexVolumeSource
	F0_564  k8s_io_kubernetes_pkg_api_v1.FlockerVolumeSource
	F0_565  k8s_io_kubernetes_pkg_api_v1.GCEPersistentDiskVolumeSource
	F0_566  k8s_io_kubernetes_pkg_api_v1.GitRepoVolumeSource
	F0_567  k8s_io_kubernetes_pkg_api_v1.GlusterfsVolumeSource
	F0_569  k8s_io_kubernetes_pkg_api_v1.HTTPGetAction
	F0_570  k8s_io_kubernetes_pkg_api_v1.HTTPHeader
	F0_571  k8s_io_kubernetes_pkg_api_v1.Handler
	F0_572  k8s_io_kubernetes_pkg_api_v1.HostPathVolumeSource
	F0_573  k8s_io_kubernetes_pkg_api_v1.IDRange
	F0_574  k8s_io_kubernetes_pkg_api_v1.ISCSIVolumeSource
	F0_575  k8s_io_kubernetes_pkg_api_v1.KeyToPath
	F0_576  k8s_io_kubernetes_pkg_api_v1.Lifecycle
	F0_577  k8s_io_kubernetes_pkg_api_v1.LimitRange
	F0_578  k8s_io_kubernetes_pkg_api_v1.LimitRangeItem
	F0_579  k8s_io_kubernetes_pkg_api_v1.LimitRangeList
	F0_580  k8s_io_kubernetes_pkg_api_v1.LimitRangeSpec
	F0_584  k8s_io_kubernetes_pkg_api_v1.List
	F0_585  k8s_io_kubernetes_pkg_api_v1.ListOptions
	F0_586  k8s_io_kubernetes_pkg_api_v1.LoadBalancerIngress
	F0_587  k8s_io_kubernetes_pkg_api_v1.LoadBalancerStatus
	F0_588  k8s_io_kubernetes_pkg_api_v1.LocalObjectReference
	F0_590  k8s_io_kubernetes_pkg_api_v1.NFSVolumeSource
	F0_591  k8s_io_kubernetes_pkg_api_v1.Namespace
	F0_595  k8s_io_kubernetes_pkg_api_v1.NamespaceList
	F0_597  k8s_io_kubernetes_pkg_api_v1.NamespaceSpec
	F0_598  k8s_io_kubernetes_pkg_api_v1.NamespaceStatus
	F0_600  k8s_io_kubernetes_pkg_api_v1.Node
	F0_601  k8s_io_kubernetes_pkg_api_v1.NodeAddress
	F0_603  k8s_io_kubernetes_pkg_api_v1.NodeAffinity
	F0_604  k8s_io_kubernetes_pkg_api_v1.NodeCondition
	F0_606  k8s_io_kubernetes_pkg_api_v1.NodeDaemonEndpoints
	F0_610  k8s_io_kubernetes_pkg_api_v1.NodeList
	F0_616  k8s_io_kubernetes_pkg_api_v1.NodeProxyOptions
	F0_619  k8s_io_kubernetes_pkg_api_v1.NodeSelector
	F0_627  k8s_io_kubernetes_pkg_api_v1.NodeSelectorRequirement
	F0_628  k8s_io_kubernetes_pkg_api_v1.NodeSelectorTerm
	F0_629  k8s_io_kubernetes_pkg_api_v1.NodeSpec
	F0_630  k8s_io_kubernetes_pkg_api_v1.NodeStatus
	F0_631  k8s_io_kubernetes_pkg_api_v1.NodeSystemInfo
	F0_633  k8s_io_kubernetes_pkg_api_v1.ObjectFieldSelector
	F0_634  k8s_io_kubernetes_pkg_api_v1.ObjectMeta
	F0_635  k8s_io_kubernetes_pkg_api_v1.ObjectReference
	F0_636  k8s_io_kubernetes_pkg_api_v1.OwnerReference
	F0_637  k8s_io_kubernetes_pkg_api_v1.PersistentVolume
	F0_639  k8s_io_kubernetes_pkg_api_v1.PersistentVolumeClaim
	F0_640  k8s_io_kubernetes_pkg_api_v1.PersistentVolumeClaimList
	F0_642  k8s_io_kubernetes_pkg_api_v1.PersistentVolumeClaimSpec
	F0_643  k8s_io_kubernetes_pkg_api_v1.PersistentVolumeClaimStatus
	F0_644  k8s_io_kubernetes_pkg_api_v1.PersistentVolumeClaimVolumeSource
	F0_645  k8s_io_kubernetes_pkg_api_v1.PersistentVolumeList
	F0_651  k8s_io_kubernetes_pkg_api_v1.PersistentVolumeSource
	F0_652  k8s_io_kubernetes_pkg_api_v1.PersistentVolumeSpec
	F0_653  k8s_io_kubernetes_pkg_api_v1.PersistentVolumeStatus
	F0_654  k8s_io_kubernetes_pkg_api_v1.Pod
	F0_655  k8s_io_kubernetes_pkg_api_v1.PodAffinity
	F0_656  k8s_io_kubernetes_pkg_api_v1.PodAffinityTerm
	F0_657  k8s_io_kubernetes_pkg_api_v1.PodAntiAffinity
	F0_658  k8s_io_kubernetes_pkg_api_v1.PodAttachOptions
	F0_659  k8s_io_kubernetes_pkg_api_v1.PodCondition
	F0_661  k8s_io_kubernetes_pkg_api_v1.PodExecOptions
	F0_665  k8s_io_kubernetes_pkg_api_v1.PodList
	F0_666  k8s_io_kubernetes_pkg_api_v1.PodLogOptions
	F0_669  k8s_io_kubernetes_pkg_api_v1.PodProxyOptions
	F0_673  k8s_io_kubernetes_pkg_api_v1.PodSecurityContext
	F0_674  k8s_io_kubernetes_pkg_api_v1.PodSpec
	F0_675  k8s_io_kubernetes_pkg_api_v1.PodStatus
	F0_676  k8s_io_kubernetes_pkg_api_v1.PodStatusResult
	F0_678  k8s_io_kubernetes_pkg_api_v1.PodTemplate
	F0_679  k8s_io_kubernetes_pkg_api_v1.PodTemplateList
	F0_680  k8s_io_kubernetes_pkg_api_v1.PodTemplateSpec
	F0_682  k8s_io_kubernetes_pkg_api_v1.Preconditions
	F0_683  k8s_io_kubernetes_pkg_api_v1.PreferredSchedulingTerm
	F0_684  k8s_io_kubernetes_pkg_api_v1.Probe
	F0_692  k8s_io_kubernetes_pkg_api_v1.RBDVolumeSource
	F0_693  k8s_io_kubernetes_pkg_api_v1.RangeAllocation
	F0_697  k8s_io_kubernetes_pkg_api_v1.ReplicationController
	F0_698  k8s_io_kubernetes_pkg_api_v1.ReplicationControllerList
	F0_699  k8s_io_kubernetes_pkg_api_v1.ReplicationControllerSpec
	F0_700  k8s_io_kubernetes_pkg_api_v1.ReplicationControllerStatus
	F0_703  k8s_io_kubernetes_pkg_api_v1.ResourceFieldSelector
	F0_712  k8s_io_kubernetes_pkg_api_v1.ResourceQuota
	F0_713  k8s_io_kubernetes_pkg_api_v1.ResourceQuotaList
	F0_719  k8s_io_kubernetes_pkg_api_v1.ResourceQuotaSpec
	F0_720  k8s_io_kubernetes_pkg_api_v1.ResourceQuotaStatus
	F0_725  k8s_io_kubernetes_pkg_api_v1.ResourceRequirements
	F0_738  k8s_io_kubernetes_pkg_api_v1.RunAsUserStrategyOptions
	F0_741  k8s_io_kubernetes_pkg_api_v1.SELinuxContextStrategyOptions
	F0_743  k8s_io_kubernetes_pkg_api_v1.SELinuxOptions
	F0_747  k8s_io_kubernetes_pkg_api_v1.Secret
	F0_748  k8s_io_kubernetes_pkg_api_v1.SecretKeySelector
	F0_749  k8s_io_kubernetes_pkg_api_v1.SecretList
	F0_755  k8s_io_kubernetes_pkg_api_v1.SecretVolumeSource
	F0_756  k8s_io_kubernetes_pkg_api_v1.SecurityContext
	F0_757  k8s_io_kubernetes_pkg_api_v1.SecurityContextConstraints
	F0_758  k8s_io_kubernetes_pkg_api_v1.SecurityContextConstraintsList
	F0_759  k8s_io_kubernetes_pkg_api_v1.SerializedReference
	F0_760  k8s_io_kubernetes_pkg_api_v1.Service
	F0_761  k8s_io_kubernetes_pkg_api_v1.ServiceAccount
	F0_763  k8s_io_kubernetes_pkg_api_v1.ServiceAccountList
	F0_772  k8s_io_kubernetes_pkg_api_v1.ServiceList
	F0_773  k8s_io_kubernetes_pkg_api_v1.ServicePort
	F0_774  k8s_io_kubernetes_pkg_api_v1.ServiceProxyOptions
	F0_775  k8s_io_kubernetes_pkg_api_v1.ServiceSpec
	F0_776  k8s_io_kubernetes_pkg_api_v1.ServiceStatus
	F0_812  k8s_io_kubernetes_pkg_api_v1.SupplementalGroupsStrategyOptions
	F0_815  k8s_io_kubernetes_pkg_api_v1.TCPSocketAction
	F0_818  k8s_io_kubernetes_pkg_api_v1.Taint
	F0_823  k8s_io_kubernetes_pkg_api_v1.Toleration
	F0_831  k8s_io_kubernetes_pkg_api_v1.Volume
	F0_835  k8s_io_kubernetes_pkg_api_v1.VolumeMount
	F0_838  k8s_io_kubernetes_pkg_api_v1.VolumeSource
	F0_839  k8s_io_kubernetes_pkg_api_v1.VsphereVirtualDiskVolumeSource
	F0_840  k8s_io_kubernetes_pkg_api_v1.WeightedPodAffinityTerm
	F1_1    github_com_openshift_origin_pkg_oauth_api_v1.ClusterRoleScopeRestriction
	F1_39   github_com_openshift_origin_pkg_oauth_api_v1.OAuthAccessToken
	F1_40   github_com_openshift_origin_pkg_oauth_api_v1.OAuthAccessTokenList
	F1_41   github_com_openshift_origin_pkg_oauth_api_v1.OAuthAuthorizeToken
	F1_42   github_com_openshift_origin_pkg_oauth_api_v1.OAuthAuthorizeTokenList
	F1_43   github_com_openshift_origin_pkg_oauth_api_v1.OAuthClient
	F1_44   github_com_openshift_origin_pkg_oauth_api_v1.OAuthClientAuthorization
	F1_45   github_com_openshift_origin_pkg_oauth_api_v1.OAuthClientAuthorizationList
	F1_46   github_com_openshift_origin_pkg_oauth_api_v1.OAuthClientList
	F1_48   github_com_openshift_origin_pkg_oauth_api_v1.ScopeRestriction
	F2_32   github_com_openshift_origin_pkg_security_api_v1.PodSecurityPolicyReview
	F2_33   github_com_openshift_origin_pkg_security_api_v1.PodSecurityPolicyReviewSpec
	F2_34   github_com_openshift_origin_pkg_security_api_v1.PodSecurityPolicyReviewStatus
	F2_35   github_com_openshift_origin_pkg_security_api_v1.PodSecurityPolicySelfSubjectReview
	F2_36   github_com_openshift_origin_pkg_security_api_v1.PodSecurityPolicySelfSubjectReviewSpec
	F2_37   github_com_openshift_origin_pkg_security_api_v1.PodSecurityPolicySubjectReview
	F2_38   github_com_openshift_origin_pkg_security_api_v1.PodSecurityPolicySubjectReviewSpec
	F2_39   github_com_openshift_origin_pkg_security_api_v1.PodSecurityPolicySubjectReviewStatus
	F2_42   github_com_openshift_origin_pkg_security_api_v1.ServiceAccountPodSecurityPolicyReviewStatus
	F3_1    github_com_openshift_origin_pkg_sdn_api_v1.ClusterNetwork
	F3_3    github_com_openshift_origin_pkg_sdn_api_v1.ClusterNetworkList
	F3_37   github_com_openshift_origin_pkg_sdn_api_v1.EgressNetworkPolicy
	F3_38   github_com_openshift_origin_pkg_sdn_api_v1.EgressNetworkPolicyList
	F3_39   github_com_openshift_origin_pkg_sdn_api_v1.EgressNetworkPolicyPeer
	F3_40   github_com_openshift_origin_pkg_sdn_api_v1.EgressNetworkPolicyRule
	F3_44   github_com_openshift_origin_pkg_sdn_api_v1.EgressNetworkPolicySpec
	F3_48   github_com_openshift_origin_pkg_sdn_api_v1.HostSubnet
	F3_49   github_com_openshift_origin_pkg_sdn_api_v1.HostSubnetList
	F3_50   github_com_openshift_origin_pkg_sdn_api_v1.NetNamespace
	F3_51   github_com_openshift_origin_pkg_sdn_api_v1.NetNamespaceList
	F4_24   github_com_openshift_origin_pkg_user_api_v1.Group
	F4_25   github_com_openshift_origin_pkg_user_api_v1.GroupList
	F4_27   github_com_openshift_origin_pkg_user_api_v1.Identity
	F4_28   github_com_openshift_origin_pkg_user_api_v1.IdentityList
	F4_31   github_com_openshift_origin_pkg_user_api_v1.User
	F4_32   github_com_openshift_origin_pkg_user_api_v1.UserIdentityMapping
	F4_33   github_com_openshift_origin_pkg_user_api_v1.UserList
	F5_13   github_com_openshift_origin_pkg_template_api_v1.Parameter
	F5_15   github_com_openshift_origin_pkg_template_api_v1.Template
	F5_16   github_com_openshift_origin_pkg_template_api_v1.TemplateList
	F6_53   k8s_io_kubernetes_pkg_runtime.NoopDecoder
	F6_54   k8s_io_kubernetes_pkg_runtime.NoopEncoder
	F6_61   k8s_io_kubernetes_pkg_runtime.Pair
	F6_66   k8s_io_kubernetes_pkg_runtime.RawExtension
	F6_68   k8s_io_kubernetes_pkg_runtime.Scheme
	F6_71   k8s_io_kubernetes_pkg_runtime.SerializerInfo
	F6_75   k8s_io_kubernetes_pkg_runtime.StreamSerializerInfo
	F6_76   k8s_io_kubernetes_pkg_runtime.TypeMeta
	F6_77   k8s_io_kubernetes_pkg_runtime.Unknown
	F6_79   k8s_io_kubernetes_pkg_runtime.Unstructured
	F6_81   k8s_io_kubernetes_pkg_runtime.UnstructuredList
	F6_85   k8s_io_kubernetes_pkg_runtime.VersionedObjects
	F7_1    k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.ClusterRole
	F7_2    k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.ClusterRoleBinding
	F7_3    k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.ClusterRoleBindingList
	F7_4    k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.ClusterRoleList
	F7_37   k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.PolicyRule
	F7_38   k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.Role
	F7_39   k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.RoleBinding
	F7_40   k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.RoleBindingList
	F7_41   k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.RoleList
	F7_43   k8s_io_kubernetes_pkg_apis_rbac_v1alpha1.Subject
	F8_5    k8s_io_kubernetes_pkg_watch_versioned.Decoder
	F8_6    k8s_io_kubernetes_pkg_watch_versioned.Encoder
	F8_9    k8s_io_kubernetes_pkg_watch_versioned.Event
	F8_10   k8s_io_kubernetes_pkg_watch_versioned.InternalEvent
	F9_46   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.Job
	F9_48   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.JobCondition
	F9_51   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.JobList
	F9_52   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.JobSpec
	F9_53   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.JobStatus
	F9_54   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.JobTemplate
	F9_55   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.JobTemplateSpec
	F9_56   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.LabelSelector
	F9_62   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.LabelSelectorRequirement
	F9_64   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.ScheduledJob
	F9_65   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.ScheduledJobList
	F9_66   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.ScheduledJobSpec
	F9_67   k8s_io_kubernetes_pkg_apis_batch_v2alpha1.ScheduledJobStatus
	F10_0   github_com_openshift_origin_pkg_authorization_api_v1.Action
	F10_2   github_com_openshift_origin_pkg_authorization_api_v1.ClusterPolicy
	F10_3   github_com_openshift_origin_pkg_authorization_api_v1.ClusterPolicyBinding
	F10_4   github_com_openshift_origin_pkg_authorization_api_v1.ClusterPolicyBindingList
	F10_5   github_com_openshift_origin_pkg_authorization_api_v1.ClusterPolicyList
	F10_6   github_com_openshift_origin_pkg_authorization_api_v1.ClusterRole
	F10_7   github_com_openshift_origin_pkg_authorization_api_v1.ClusterRoleBinding
	F10_8   github_com_openshift_origin_pkg_authorization_api_v1.ClusterRoleBindingList
	F10_9   github_com_openshift_origin_pkg_authorization_api_v1.ClusterRoleList
	F10_109 github_com_openshift_origin_pkg_authorization_api_v1.IsPersonalSubjectAccessReview
	F10_110 github_com_openshift_origin_pkg_authorization_api_v1.LocalResourceAccessReview
	F10_111 github_com_openshift_origin_pkg_authorization_api_v1.LocalSubjectAccessReview
	F10_112 github_com_openshift_origin_pkg_authorization_api_v1.NamedClusterRole
	F10_113 github_com_openshift_origin_pkg_authorization_api_v1.NamedClusterRoleBinding
	F10_116 github_com_openshift_origin_pkg_authorization_api_v1.NamedRole
	F10_117 github_com_openshift_origin_pkg_authorization_api_v1.NamedRoleBinding
	F10_122 github_com_openshift_origin_pkg_authorization_api_v1.Policy
	F10_123 github_com_openshift_origin_pkg_authorization_api_v1.PolicyBinding
	F10_124 github_com_openshift_origin_pkg_authorization_api_v1.PolicyBindingList
	F10_125 github_com_openshift_origin_pkg_authorization_api_v1.PolicyList
	F10_126 github_com_openshift_origin_pkg_authorization_api_v1.PolicyRule
	F10_127 github_com_openshift_origin_pkg_authorization_api_v1.ResourceAccessReview
	F10_128 github_com_openshift_origin_pkg_authorization_api_v1.ResourceAccessReviewResponse
	F10_129 github_com_openshift_origin_pkg_authorization_api_v1.Role
	F10_130 github_com_openshift_origin_pkg_authorization_api_v1.RoleBinding
	F10_131 github_com_openshift_origin_pkg_authorization_api_v1.RoleBindingList
	F10_132 github_com_openshift_origin_pkg_authorization_api_v1.RoleList
	F10_134 github_com_openshift_origin_pkg_authorization_api_v1.SelfSubjectRulesReview
	F10_135 github_com_openshift_origin_pkg_authorization_api_v1.SelfSubjectRulesReviewSpec
	F10_137 github_com_openshift_origin_pkg_authorization_api_v1.SubjectAccessReview
	F10_138 github_com_openshift_origin_pkg_authorization_api_v1.SubjectAccessReviewResponse
	F10_139 github_com_openshift_origin_pkg_authorization_api_v1.SubjectRulesReviewStatus
	F11_0   k8s_io_kubernetes_pkg_api_unversioned.APIGroup
	F11_1   k8s_io_kubernetes_pkg_api_unversioned.APIGroupList
	F11_2   k8s_io_kubernetes_pkg_api_unversioned.APIResource
	F11_3   k8s_io_kubernetes_pkg_api_unversioned.APIResourceList
	F11_4   k8s_io_kubernetes_pkg_api_unversioned.APIVersions
	F11_38  k8s_io_kubernetes_pkg_api_unversioned.Duration
	F11_42  k8s_io_kubernetes_pkg_api_unversioned.ExportOptions
	F11_47  k8s_io_kubernetes_pkg_api_unversioned.GroupKind
	F11_48  k8s_io_kubernetes_pkg_api_unversioned.GroupResource
	F11_49  k8s_io_kubernetes_pkg_api_unversioned.GroupVersion
	F11_50  k8s_io_kubernetes_pkg_api_unversioned.GroupVersionForDiscovery
	F11_51  k8s_io_kubernetes_pkg_api_unversioned.GroupVersionKind
	F11_52  k8s_io_kubernetes_pkg_api_unversioned.GroupVersionResource
	F11_59  k8s_io_kubernetes_pkg_api_unversioned.LabelSelector
	F11_67  k8s_io_kubernetes_pkg_api_unversioned.LabelSelectorRequirement
	F11_71  k8s_io_kubernetes_pkg_api_unversioned.ListMeta
	F11_81  k8s_io_kubernetes_pkg_api_unversioned.RootPaths
	F11_83  k8s_io_kubernetes_pkg_api_unversioned.ServerAddressByClientCIDR
	F11_85  k8s_io_kubernetes_pkg_api_unversioned.Status
	F11_86  k8s_io_kubernetes_pkg_api_unversioned.StatusCause
	F11_87  k8s_io_kubernetes_pkg_api_unversioned.StatusDetails
	F11_106 k8s_io_kubernetes_pkg_api_unversioned.Time
	F11_107 k8s_io_kubernetes_pkg_api_unversioned.Timestamp
	F11_109 k8s_io_kubernetes_pkg_api_unversioned.TypeMeta
	F12_90  github_com_openshift_origin_pkg_image_api_v1.DockerImageReference
	F12_94  github_com_openshift_origin_pkg_image_api_v1.Image
	F12_95  github_com_openshift_origin_pkg_image_api_v1.ImageImportSpec
	F12_96  github_com_openshift_origin_pkg_image_api_v1.ImageImportStatus
	F12_97  github_com_openshift_origin_pkg_image_api_v1.ImageLayer
	F12_98  github_com_openshift_origin_pkg_image_api_v1.ImageList
	F12_99  github_com_openshift_origin_pkg_image_api_v1.ImageSignature
	F12_100 github_com_openshift_origin_pkg_image_api_v1.ImageStream
	F12_101 github_com_openshift_origin_pkg_image_api_v1.ImageStreamImage
	F12_102 github_com_openshift_origin_pkg_image_api_v1.ImageStreamImport
	F12_103 github_com_openshift_origin_pkg_image_api_v1.ImageStreamImportSpec
	F12_104 github_com_openshift_origin_pkg_image_api_v1.ImageStreamImportStatus
	F12_105 github_com_openshift_origin_pkg_image_api_v1.ImageStreamList
	F12_106 github_com_openshift_origin_pkg_image_api_v1.ImageStreamMapping
	F12_107 github_com_openshift_origin_pkg_image_api_v1.ImageStreamSpec
	F12_108 github_com_openshift_origin_pkg_image_api_v1.ImageStreamStatus
	F12_109 github_com_openshift_origin_pkg_image_api_v1.ImageStreamTag
	F12_110 github_com_openshift_origin_pkg_image_api_v1.ImageStreamTagList
	F12_112 github_com_openshift_origin_pkg_image_api_v1.NamedTagEventList
	F12_113 github_com_openshift_origin_pkg_image_api_v1.RepositoryImportSpec
	F12_114 github_com_openshift_origin_pkg_image_api_v1.RepositoryImportStatus
	F12_117 github_com_openshift_origin_pkg_image_api_v1.SignatureCondition
	F12_119 github_com_openshift_origin_pkg_image_api_v1.SignatureGenericEntity
	F12_120 github_com_openshift_origin_pkg_image_api_v1.SignatureIssuer
	F12_121 github_com_openshift_origin_pkg_image_api_v1.SignatureSubject
	F12_122 github_com_openshift_origin_pkg_image_api_v1.TagEvent
	F12_123 github_com_openshift_origin_pkg_image_api_v1.TagEventCondition
	F12_125 github_com_openshift_origin_pkg_image_api_v1.TagImportPolicy
	F12_126 github_com_openshift_origin_pkg_image_api_v1.TagReference
	F13_7   k8s_io_kubernetes_pkg_util_intstr.IntOrString
	F14_35  github_com_openshift_origin_pkg_route_api_v1.Route
	F14_37  github_com_openshift_origin_pkg_route_api_v1.RouteIngress
	F14_38  github_com_openshift_origin_pkg_route_api_v1.RouteIngressCondition
	F14_40  github_com_openshift_origin_pkg_route_api_v1.RouteList
	F14_41  github_com_openshift_origin_pkg_route_api_v1.RoutePort
	F14_42  github_com_openshift_origin_pkg_route_api_v1.RouteSpec
	F14_43  github_com_openshift_origin_pkg_route_api_v1.RouteStatus
	F14_44  github_com_openshift_origin_pkg_route_api_v1.RouteTargetReference
	F14_45  github_com_openshift_origin_pkg_route_api_v1.RouterShard
	F14_49  github_com_openshift_origin_pkg_route_api_v1.TLSConfig
	F15_18  k8s_io_kubernetes_pkg_apis_authentication_v1beta1.TokenReview
	F15_19  k8s_io_kubernetes_pkg_apis_authentication_v1beta1.TokenReviewSpec
	F15_20  k8s_io_kubernetes_pkg_apis_authentication_v1beta1.TokenReviewStatus
	F15_21  k8s_io_kubernetes_pkg_apis_authentication_v1beta1.UserInfo
	F16_26  k8s_io_kubernetes_pkg_apis_authorization_v1beta1.LocalSubjectAccessReview
	F16_27  k8s_io_kubernetes_pkg_apis_authorization_v1beta1.NonResourceAttributes
	F16_28  k8s_io_kubernetes_pkg_apis_authorization_v1beta1.ResourceAttributes
	F16_30  k8s_io_kubernetes_pkg_apis_authorization_v1beta1.SelfSubjectAccessReview
	F16_31  k8s_io_kubernetes_pkg_apis_authorization_v1beta1.SelfSubjectAccessReviewSpec
	F16_32  k8s_io_kubernetes_pkg_apis_authorization_v1beta1.SubjectAccessReview
	F16_33  k8s_io_kubernetes_pkg_apis_authorization_v1beta1.SubjectAccessReviewSpec
	F16_34  k8s_io_kubernetes_pkg_apis_authorization_v1beta1.SubjectAccessReviewStatus
	F17_26  k8s_io_kubernetes_pkg_api_resource.Quantity
	F18_1   github_com_openshift_origin_pkg_quota_api_v1.AppliedClusterResourceQuota
	F18_2   github_com_openshift_origin_pkg_quota_api_v1.AppliedClusterResourceQuotaList
	F18_3   github_com_openshift_origin_pkg_quota_api_v1.ClusterResourceQuota
	F18_4   github_com_openshift_origin_pkg_quota_api_v1.ClusterResourceQuotaList
	F18_5   github_com_openshift_origin_pkg_quota_api_v1.ClusterResourceQuotaSelector
	F18_6   github_com_openshift_origin_pkg_quota_api_v1.ClusterResourceQuotaSpec
	F18_7   github_com_openshift_origin_pkg_quota_api_v1.ClusterResourceQuotaStatus
	F18_37  github_com_openshift_origin_pkg_quota_api_v1.ResourceQuotaStatusByNamespace
	F19_41  github_com_openshift_origin_pkg_deploy_api_v1.CustomDeploymentStrategyParams
	F19_65  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentCause
	F19_66  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentCauseImageTrigger
	F19_67  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentConfig
	F19_70  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentConfigList
	F19_71  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentConfigRollback
	F19_72  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentConfigRollbackSpec
	F19_73  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentConfigSpec
	F19_74  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentConfigStatus
	F19_75  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentDetails
	F19_79  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentLog
	F19_80  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentLogOptions
	F19_91  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentStrategy
	F19_96  github_com_openshift_origin_pkg_deploy_api_v1.DeploymentTriggerImageChangeParams
	F19_100 github_com_openshift_origin_pkg_deploy_api_v1.DeploymentTriggerPolicy
	F19_105 github_com_openshift_origin_pkg_deploy_api_v1.ExecNewPodHook
	F19_107 github_com_openshift_origin_pkg_deploy_api_v1.LifecycleHook
	F19_112 github_com_openshift_origin_pkg_deploy_api_v1.RecreateDeploymentStrategyParams
	F19_113 github_com_openshift_origin_pkg_deploy_api_v1.RollingDeploymentStrategyParams
	F19_120 github_com_openshift_origin_pkg_deploy_api_v1.TagImageHook
	F20_16  k8s_io_kubernetes_pkg_apis_policy_v1alpha1.PodDisruptionBudget
	F20_17  k8s_io_kubernetes_pkg_apis_policy_v1alpha1.PodDisruptionBudgetList
	F20_18  k8s_io_kubernetes_pkg_apis_policy_v1alpha1.PodDisruptionBudgetSpec
	F20_19  k8s_io_kubernetes_pkg_apis_policy_v1alpha1.PodDisruptionBudgetStatus
	F21_17  k8s_io_kubernetes_pkg_apis_autoscaling_v1.CrossVersionObjectReference
	F21_29  k8s_io_kubernetes_pkg_apis_autoscaling_v1.HorizontalPodAutoscaler
	F21_30  k8s_io_kubernetes_pkg_apis_autoscaling_v1.HorizontalPodAutoscalerList
	F21_31  k8s_io_kubernetes_pkg_apis_autoscaling_v1.HorizontalPodAutoscalerSpec
	F21_32  k8s_io_kubernetes_pkg_apis_autoscaling_v1.HorizontalPodAutoscalerStatus
	F21_33  k8s_io_kubernetes_pkg_apis_autoscaling_v1.Scale
	F21_34  k8s_io_kubernetes_pkg_apis_autoscaling_v1.ScaleSpec
	F21_35  k8s_io_kubernetes_pkg_apis_autoscaling_v1.ScaleStatus
	F22_25  k8s_io_kubernetes_pkg_apis_batch_v1.Job
	F22_27  k8s_io_kubernetes_pkg_apis_batch_v1.JobCondition
	F22_30  k8s_io_kubernetes_pkg_apis_batch_v1.JobList
	F22_31  k8s_io_kubernetes_pkg_apis_batch_v1.JobSpec
	F22_32  k8s_io_kubernetes_pkg_apis_batch_v1.JobStatus
	F22_33  k8s_io_kubernetes_pkg_apis_batch_v1.LabelSelector
	F22_39  k8s_io_kubernetes_pkg_apis_batch_v1.LabelSelectorRequirement
	F23_1   github_com_openshift_origin_pkg_build_api_v1.BinaryBuildRequestOptions
	F23_2   github_com_openshift_origin_pkg_build_api_v1.BinaryBuildSource
	F23_3   github_com_openshift_origin_pkg_build_api_v1.Build
	F23_4   github_com_openshift_origin_pkg_build_api_v1.BuildConfig
	F23_5   github_com_openshift_origin_pkg_build_api_v1.BuildConfigList
	F23_6   github_com_openshift_origin_pkg_build_api_v1.BuildConfigSpec
	F23_7   github_com_openshift_origin_pkg_build_api_v1.BuildConfigStatus
	F23_8   github_com_openshift_origin_pkg_build_api_v1.BuildList
	F23_9   github_com_openshift_origin_pkg_build_api_v1.BuildLog
	F23_10  github_com_openshift_origin_pkg_build_api_v1.BuildLogOptions
	F23_11  github_com_openshift_origin_pkg_build_api_v1.BuildOutput
	F23_20  github_com_openshift_origin_pkg_build_api_v1.BuildPostCommitSpec
	F23_21  github_com_openshift_origin_pkg_build_api_v1.BuildRequest
	F23_26  github_com_openshift_origin_pkg_build_api_v1.BuildSource
	F23_33  github_com_openshift_origin_pkg_build_api_v1.BuildSpec
	F23_34  github_com_openshift_origin_pkg_build_api_v1.BuildStatus
	F23_35  github_com_openshift_origin_pkg_build_api_v1.BuildStrategy
	F23_37  github_com_openshift_origin_pkg_build_api_v1.BuildTriggerCause
	F23_38  github_com_openshift_origin_pkg_build_api_v1.BuildTriggerPolicy
	F23_40  github_com_openshift_origin_pkg_build_api_v1.CommonSpec
	F23_118 github_com_openshift_origin_pkg_build_api_v1.CustomBuildStrategy
	F23_159 github_com_openshift_origin_pkg_build_api_v1.DockerBuildStrategy
	F23_165 github_com_openshift_origin_pkg_build_api_v1.GenericWebHookCause
	F23_166 github_com_openshift_origin_pkg_build_api_v1.GenericWebHookEvent
	F23_167 github_com_openshift_origin_pkg_build_api_v1.GitBuildSource
	F23_170 github_com_openshift_origin_pkg_build_api_v1.GitHubWebHookCause
	F23_171 github_com_openshift_origin_pkg_build_api_v1.GitInfo
	F23_172 github_com_openshift_origin_pkg_build_api_v1.GitSourceRevision
	F23_176 github_com_openshift_origin_pkg_build_api_v1.ImageChangeCause
	F23_177 github_com_openshift_origin_pkg_build_api_v1.ImageChangeTrigger
	F23_178 github_com_openshift_origin_pkg_build_api_v1.ImageSource
	F23_179 github_com_openshift_origin_pkg_build_api_v1.ImageSourcePath
	F23_180 github_com_openshift_origin_pkg_build_api_v1.JenkinsPipelineBuildStrategy
	F23_183 github_com_openshift_origin_pkg_build_api_v1.SecretBuildSource
	F23_184 github_com_openshift_origin_pkg_build_api_v1.SecretSpec
	F23_192 github_com_openshift_origin_pkg_build_api_v1.SourceBuildStrategy
	F23_194 github_com_openshift_origin_pkg_build_api_v1.SourceControlUser
	F23_195 github_com_openshift_origin_pkg_build_api_v1.SourceRevision
	F23_197 github_com_openshift_origin_pkg_build_api_v1.WebHookTrigger
	F24_16  k8s_io_kubernetes_pkg_apis_apps_v1alpha1.PetSet
	F24_17  k8s_io_kubernetes_pkg_apis_apps_v1alpha1.PetSetList
	F24_18  k8s_io_kubernetes_pkg_apis_apps_v1alpha1.PetSetSpec
	F24_19  k8s_io_kubernetes_pkg_apis_apps_v1alpha1.PetSetStatus
	F25_0   k8s_io_kubernetes_pkg_apis_extensions_v1beta1.APIVersion
	F25_5   k8s_io_kubernetes_pkg_apis_extensions_v1beta1.CPUTargetUtilization
	F25_141 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.CustomMetricCurrentStatus
	F25_142 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.CustomMetricCurrentStatusList
	F25_143 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.CustomMetricTarget
	F25_144 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.CustomMetricTargetList
	F25_145 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.DaemonSet
	F25_146 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.DaemonSetList
	F25_147 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.DaemonSetSpec
	F25_148 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.DaemonSetStatus
	F25_220 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.Deployment
	F25_221 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.DeploymentList
	F25_222 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.DeploymentRollback
	F25_223 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.DeploymentSpec
	F25_224 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.DeploymentStatus
	F25_225 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.DeploymentStrategy
	F25_231 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ExportOptions
	F25_234 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.FSGroupStrategyOptions
	F25_244 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.HTTPIngressPath
	F25_245 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.HTTPIngressRuleValue
	F25_246 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.HorizontalPodAutoscaler
	F25_247 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.HorizontalPodAutoscalerList
	F25_248 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.HorizontalPodAutoscalerSpec
	F25_249 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.HorizontalPodAutoscalerStatus
	F25_251 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.HostPortRange
	F25_252 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.IDRange
	F25_254 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.Ingress
	F25_255 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.IngressBackend
	F25_256 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.IngressList
	F25_257 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.IngressRule
	F25_258 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.IngressRuleValue
	F25_259 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.IngressSpec
	F25_260 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.IngressStatus
	F25_261 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.IngressTLS
	F25_262 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.Job
	F25_264 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.JobCondition
	F25_267 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.JobList
	F25_268 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.JobSpec
	F25_269 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.JobStatus
	F25_270 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.LabelSelector
	F25_276 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.LabelSelectorRequirement
	F25_277 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ListOptions
	F25_279 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.NetworkPolicy
	F25_280 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.NetworkPolicyIngressRule
	F25_281 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.NetworkPolicyList
	F25_282 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.NetworkPolicyPeer
	F25_283 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.NetworkPolicyPort
	F25_284 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.NetworkPolicySpec
	F25_286 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.PodSecurityPolicy
	F25_287 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.PodSecurityPolicyList
	F25_288 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.PodSecurityPolicySpec
	F25_291 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ReplicaSet
	F25_292 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ReplicaSetList
	F25_293 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ReplicaSetSpec
	F25_294 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ReplicaSetStatus
	F25_295 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ReplicationControllerDummy
	F25_296 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.RollbackConfig
	F25_297 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.RollingUpdateDeployment
	F25_302 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.RunAsUserStrategyOptions
	F25_306 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.SELinuxStrategyOptions
	F25_308 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.Scale
	F25_309 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ScaleSpec
	F25_310 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ScaleStatus
	F25_319 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.SubresourceReference
	F25_321 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.SupplementalGroupsStrategyOptions
	F25_324 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ThirdPartyResource
	F25_325 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ThirdPartyResourceData
	F25_326 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ThirdPartyResourceDataList
	F25_327 k8s_io_kubernetes_pkg_apis_extensions_v1beta1.ThirdPartyResourceList
	F26_20  github_com_openshift_origin_pkg_project_api_v1.Project
	F26_21  github_com_openshift_origin_pkg_project_api_v1.ProjectList
	F26_22  github_com_openshift_origin_pkg_project_api_v1.ProjectRequest
	F26_23  github_com_openshift_origin_pkg_project_api_v1.ProjectSpec
	F26_24  github_com_openshift_origin_pkg_project_api_v1.ProjectStatus
}
