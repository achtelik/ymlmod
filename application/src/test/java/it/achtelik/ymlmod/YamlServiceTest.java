package it.achtelik.ymlmod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import it.achtelik.ymlmod.dumperoptions.KubernetesDumperOptions;
import it.achtelik.ymlmod.testutils.FileUtils;
import it.achtelik.ymlmod.yamlfilter.KubernetesFilterConfiguration;

class YamlServiceTest {

    @Test
    void clean() throws Exception {
        String yamlInputString = new FileUtils().loadResourceAsString("yaml/k-creator-origin.yml");
        String yamlResultString = new YamlService().clean(yamlInputString, new KubernetesFilterConfiguration(), new KubernetesDumperOptions());
        String result = new FileUtils().loadResourceAsString("yaml/k-creator-origin-result.yml");
        Assertions.assertEquals(result, yamlResultString);
    }
}
