package it.achtelik.ymlmod.yamlfilter.filter;

import it.achtelik.ymlmod.yamlnode.YamlNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeleteNodeFilter extends AbstractFilter {

    public DeleteNodeFilter(String keyRegex) {
        this(keyRegex, StringUtils.EMPTY);
    }

    public DeleteNodeFilter(String keyRegex, String valueRegex) {
        super(keyRegex, valueRegex);
    }

    @Override
    protected Boolean filterAction(YamlNode yamlNode, String keyRegex, String valueRegex) {
        if (yamlNode.getPath().matches(keyRegex)
                && (StringUtils.isEmpty(valueRegex) || Objects.toString(yamlNode.getValue(), StringUtils.EMPTY).matches(valueRegex))) {
            return true;
        } else {
            List<YamlNode> yamlNodesToDelete = new ArrayList<>();
            yamlNode.getChildren().forEach(childYamlNode -> {
                if (filterAction(childYamlNode, keyRegex, valueRegex)) {
                    yamlNodesToDelete.add(childYamlNode);
                }
            });
            yamlNode.getChildren().removeAll(yamlNodesToDelete);
            return false;
        }
    }
}
