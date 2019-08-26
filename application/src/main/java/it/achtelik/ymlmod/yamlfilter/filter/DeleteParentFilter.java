package it.achtelik.ymlmod.yamlfilter.filter;

import it.achtelik.ymlmod.yamlnode.YamlNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class DeleteParentFilter extends AbstractFilter {

    public DeleteParentFilter(String keyRegex, String valueRegex) {
        super(keyRegex, valueRegex);
    }

    @Override
    protected Integer filterAction(YamlNode yamlNode, String keyRegex, String valueRegex) {
        if (yamlNode.getPath().matches(keyRegex) && Objects.toString(yamlNode.getValue(), StringUtils.EMPTY).matches(valueRegex)) {
            return 1;
        } else {
            AtomicInteger returnValue = new AtomicInteger(-1);
            List<YamlNode> yamlNodesToDelete = new ArrayList<>();
            yamlNode.getChildren().forEach(childYamlNode -> {
                int childResult = filterAction(childYamlNode, keyRegex, valueRegex);
                if (1 == childResult) {
                    returnValue.set(0);
                } else if (0 == childResult) {
                    yamlNodesToDelete.add(childYamlNode);
                }
            });
            yamlNode.getChildren().removeAll(yamlNodesToDelete);
            return returnValue.get();
        }
    }
}
