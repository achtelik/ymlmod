package it.achtelik.ymlmod.dumperoptions;

import org.yaml.snakeyaml.DumperOptions;

public class KubernetesDumperOptions extends DumperOptions {

    public KubernetesDumperOptions() {
        super();
        setPrettyFlow(true);
        setDefaultFlowStyle(FlowStyle.BLOCK);
    }
}
