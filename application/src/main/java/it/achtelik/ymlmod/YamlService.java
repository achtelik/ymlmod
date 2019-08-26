package it.achtelik.ymlmod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import it.achtelik.ymlmod.yamlfilter.FilterConfiguration;
import it.achtelik.ymlmod.yamlnode.YamlNode;
import it.achtelik.ymlmod.yamlnode.YamlNodeConverter;

import java.util.Map;

public class YamlService {

    private static Logger LOGGER = LoggerFactory.getLogger(YamlService.class);

    public String clean(String inputYamlString, FilterConfiguration filterConfiguration, DumperOptions dumperOptions) {
        String resultYamlString = "";

        Yaml yaml = new Yaml(dumperOptions);
        Map<String, Object> inputObject = yaml.load(inputYamlString);

        YamlNode resultYamlNode = YamlNodeConverter.convert(inputObject);
        resultYamlNode = filterConfiguration.filter(resultYamlNode);
        Map<String, Object> resultObject = YamlNodeConverter.convert(resultYamlNode);

        return yaml.dump(resultObject);
    }
}
