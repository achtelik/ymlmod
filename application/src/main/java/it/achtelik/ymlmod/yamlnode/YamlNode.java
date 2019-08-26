package it.achtelik.ymlmod.yamlnode;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class YamlNode implements Serializable {
    public static final String PATH_SEPARATOR_ELEMENT = ":";
    public static final String PATH_SEPARATOR_COLLECTION = "-";

    private String path = StringUtils.EMPTY;
    private YamlNode parent = null;
    private List<YamlNode> children = new ArrayList<>();
    private String key = StringUtils.EMPTY;
    private Object value = null;
    private YamlNodeType type;

    public YamlNode(String key) {
        this(key, null, new ArrayList<>(), StringUtils.EMPTY);
    }

    public YamlNode(String key, YamlNode parent) {
        this(key, parent, new ArrayList<>(), StringUtils.EMPTY);
    }

    public YamlNode(String key, YamlNode parent, Object value) {
        this(key, parent, new ArrayList<>(), value);
    }

    public YamlNode(String key, YamlNode parent, List<YamlNode> children, Object value) {
        this.path = (parent != null && StringUtils.isNotEmpty(parent.getPath()) ? parent.getPath() + PATH_SEPARATOR_ELEMENT + key : key);
        this.parent = parent;
        this.children = children;
        this.key = key;
        this.value = value;
        this.type = (PATH_SEPARATOR_COLLECTION.equals(PATH_SEPARATOR_COLLECTION) ? YamlNodeType.COLLECTION_ITEM : YamlNodeType.ATTRIBUT);
    }

    public String getPath() {
        return path;
    }

    public String getPathWithValue() {
        return path + PATH_SEPARATOR_ELEMENT + value;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public YamlNode getParent() {
        return parent;
    }

    public void setParent(YamlNode parent) {
        this.parent = parent;
    }

    public List<YamlNode> getChildren() {
        return children;
    }

    public void setChildren(List<YamlNode> children) {
        this.children = children;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public YamlNodeType getType() {
        return type;
    }

    public void setType(YamlNodeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return key + PATH_SEPARATOR_ELEMENT + StringUtils.SPACE + value;
    }
}
