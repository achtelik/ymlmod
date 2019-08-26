package it.achtelik.ymlmod;

import it.achtelik.ymlmod.dumperoptions.KubernetesDumperOptions;
import it.achtelik.ymlmod.yamlfilter.NoFilterConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Base64;

@Path("/api/yml")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class YamlController {

    private static Logger LOGGER = LoggerFactory.getLogger(YamlController.class);

    @POST()
    public YmlPostResultDto post(YmlPostDto body) {
        String result = new YamlService().clean(new String(Base64.getDecoder().decode(body.getYml())), new NoFilterConfiguration(), new KubernetesDumperOptions());
        LOGGER.info(result);
        return new YmlPostResultDto(result);
    }
}
