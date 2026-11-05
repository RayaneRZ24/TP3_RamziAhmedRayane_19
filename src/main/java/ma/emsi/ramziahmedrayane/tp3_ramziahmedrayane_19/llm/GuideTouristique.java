package ma.emsi.ramziahmedrayane.tp3_ramziahmedrayane_19.llm;

import dev.langchain4j.service.SystemMessage;

public interface GuideTouristique {

    @SystemMessage("""
            Tu es un guide touristique.
            Le message utilisateur indique une ville ou un pays et un nombre
            d'endroits à visiter.
            Donne exactement ce nombre d'endroits et le prix moyen d'un repas
            dans la devise du pays.
            Réponds uniquement en JSON, sans Markdown, avec les propriétés :
            - "ville_ou_pays" : le nom de la ville ou du pays ;
            - "endroits_a_visiter" : un tableau de chaînes contenant exactement
              le nombre d'endroits demandé ;
            - "prix_moyen_repas" : une chaîne au format "<prix> <devise du pays>".
            """)
    String chat(String lieu);
}