package it.achtelik.ymlmod.yamlfilter.filter;

import it.achtelik.ymlmod.utils.DeepCloneUtils;
import it.achtelik.ymlmod.yamlnode.YamlNode;

public abstract class AbstractFilter {
    protected final String keyRegex;
    protected final String valueRegex;

    public AbstractFilter(String keyRegex, String valueRegex) {
        this.keyRegex = keyRegex;
        this.valueRegex = valueRegex;
    }

    public YamlNode filter(YamlNode yamlNode) {
        YamlNode deepCopy = DeepCloneUtils.deepClone(yamlNode);
        filterAction(deepCopy, keyRegex, valueRegex);
        return deepCopy;
    }

    abstract protected <T> T filterAction(YamlNode yamlNode, String keyRegex, String valueRegex);
}
