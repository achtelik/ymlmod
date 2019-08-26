package it.achtelik.ymlmod.yamlnode;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class YamlNodeConverter {

    public static YamlNode convert(Map<String, Object> ymlInputObjectMap) {
        YamlNode rootYamlNode = new YamlNode(StringUtils.EMPTY);
        rootYamlNode.setType(YamlNodeType.ROOT);
        rootYamlNode.setChildren(convert(rootYamlNode, ymlInputObjectMap));
        return rootYamlNode;
    }

    protected static List<YamlNode> convert(YamlNode parent, Map<String, Object> ymlInputObjectMap) {
        List<YamlNode> yamlNodes = new LinkedList<>();
        ymlInputObjectMap.keySet().forEach((key) -> {
            YamlNode yamlNode = new YamlNode(key, parent, ymlInputObjectMap.get(key));
            if (yamlNode.getValue() instanceof Collection) {
                yamlNode.setChildren(convertCollection(yamlNode, (Collection) yamlNode.getValue()));
            } else if (yamlNode.getValue() instanceof Map) {
                yamlNode.setChildren(convert(yamlNode, (Map<String, Object>) yamlNode.getValue()));
            }
            yamlNodes.add(yamlNode);
        });
        return yamlNodes;
    }

    protected static List<YamlNode> convertCollection(YamlNode parent, Collection ymlInputObjectMap) {
        parent.setType(YamlNodeType.COLLECTION_PARENT);
        List<YamlNode> yamlNodes = new LinkedList<>();
        ymlInputObjectMap.forEach((value) -> {
            YamlNode yamlNode = new YamlNode(YamlNode.PATH_SEPARATOR_COLLECTION, parent);
            if (value instanceof Collection) {
                yamlNode.setChildren(convertCollection(yamlNode, (Collection) value));
            } else if (value instanceof Map) {
                yamlNode.setChildren(convert(yamlNode, (Map<String, Object>) value));
            } else {
                yamlNode.setValue(value);
            }
            yamlNodes.add(yamlNode);
        });
        return yamlNodes;
    }

    public static Map<String, Object> convert(YamlNode yamlNode) {
        Map<String, Object> resultYamlObjectMap = new LinkedHashMap<>();
        yamlNode.getChildren().forEach(yamlNodeChildren -> {
            if (CollectionUtils.isNotEmpty(yamlNodeChildren.getChildren())) {
                if (YamlNodeType.COLLECTION_PARENT.equals(yamlNodeChildren.getType())) {
                    resultYamlObjectMap.put(yamlNodeChildren.getKey(), convertCollection(yamlNodeChildren));
                } else {
                    resultYamlObjectMap.put(yamlNodeChildren.getKey(), convert(yamlNodeChildren));
                }
            } else {
                resultYamlObjectMap.put(yamlNodeChildren.getKey(), yamlNodeChildren.getValue());
            }
        });
        return resultYamlObjectMap;
    }

    protected static ArrayList<Object> convertCollection(YamlNode yamlNode) {
        ArrayList<Object> resultYamlObjectArray = new ArrayList<>();
        yamlNode.getChildren().forEach(yamlNodeChildren -> {
            if (CollectionUtils.isNotEmpty(yamlNodeChildren.getChildren())) {
                resultYamlObjectArray.add(convert(yamlNodeChildren));
            } else {
                resultYamlObjectArray.add(yamlNodeChildren.getValue());
            }
        });
        return resultYamlObjectArray;
    }
}
