package it.achtelik.ymlmod.yamlfilter;

import it.achtelik.ymlmod.yamlfilter.filter.AbstractFilter;
import it.achtelik.ymlmod.yamlfilter.filter.DeleteNodeFilter;
import it.achtelik.ymlmod.yamlfilter.filter.DeleteParentFilter;
import it.achtelik.ymlmod.yamlnode.YamlNode;

import java.util.ArrayList;
import java.util.List;

public class KubernetesFilterConfiguration implements FilterConfiguration {
    private List<AbstractFilter> filters = new ArrayList<>();

    public KubernetesFilterConfiguration() {
        filters.add(new DeleteNodeFilter(".*metadata:creationTimestamp"));
        filters.add(new DeleteNodeFilter(".*metadata:resourceVersion"));
        filters.add(new DeleteNodeFilter(".*metadata:selfLink"));
        filters.add(new DeleteNodeFilter(".*metadata:uid"));
        filters.add(new DeleteNodeFilter(".*metadata:generation"));
        filters.add(new DeleteNodeFilter(".*metadata:annotations"));
        filters.add(new DeleteNodeFilter(".*spec:type", "ClusterIP"));
        filters.add(new DeleteNodeFilter(".*spec:clusterIP"));
        filters.add(new DeleteNodeFilter(".*status"));
        filters.add(new DeleteNodeFilter(".*tls:caCertificate"));
        filters.add(new DeleteNodeFilter(".*tls:certificate"));
        filters.add(new DeleteNodeFilter(".*tls:key"));


        filters.add(new DeleteParentFilter(".*kind", "ReplicationController"));
        filters.add(new DeleteParentFilter(".*kind", "Pod"));
        filters.add(new DeleteParentFilter(".*kind", "Build"));
    }

    @Override
    public YamlNode filter(YamlNode yamlNode) {
        YamlNode resultYamlNode = yamlNode;
        for (AbstractFilter filter : filters) {
            resultYamlNode = filter.filter(resultYamlNode);
        }
        return resultYamlNode;
    }
}
