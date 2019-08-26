package it.achtelik.ymlmod.yamlfilter;

import it.achtelik.ymlmod.yamlnode.YamlNode;

public interface FilterConfiguration {

    YamlNode filter(YamlNode yamlNode);
}
