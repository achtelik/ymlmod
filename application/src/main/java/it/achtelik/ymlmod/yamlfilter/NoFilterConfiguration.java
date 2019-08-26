package it.achtelik.ymlmod.yamlfilter;

import it.achtelik.ymlmod.yamlnode.YamlNode;

public class NoFilterConfiguration implements FilterConfiguration {

    @Override
    public YamlNode filter(YamlNode yamlNode) {
        return yamlNode;
    }
}
