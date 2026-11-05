package ma.emsi.ramziahmedrayane.tp3_ramziahmedrayane_19.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.ramziahmedrayane.tp3_ramziahmedrayane_19.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    /**
     * Retourne les informations touristiques produites par le LLM.
     *
     * @param lieu nom de la ville ou du pays
     * @return les informations touristiques au format JSON
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(@PathParam("ville_ou_pays") String lieu) {
        return this.llmClient.envoyerRequete(lieu);
    }
}