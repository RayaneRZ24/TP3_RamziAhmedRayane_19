package ma.emsi.ramziahmedrayane.tp3_ramziahmedrayane_19.llm;

import dev.langchain4j.service.SystemMessage;

public interface GuideTouristique {

    @SystemMessage("""
            Tu es un guide touristique.
            Pour la ville ou le pays indiqué, donne les deux principaux endroits
            à visiter et le prix moyen d'un repas dans la devise du pays.
            Réponds uniquement en JSON, sans Markdown, avec exactement ce format :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["endroit 1", "endroit 2"],
              "prix_moyen_repas": "<prix> <devise du pays>"
            }
            """)
    String chat(String lieu);
}