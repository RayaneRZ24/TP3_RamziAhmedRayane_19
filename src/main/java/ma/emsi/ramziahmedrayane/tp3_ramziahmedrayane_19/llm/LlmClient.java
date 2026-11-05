package ma.emsi.ramziahmedrayane.tp3_ramziahmedrayane_19.llm;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

import java.io.Serializable;

@Dependent
public class LlmClient implements Serializable {

    private GuideTouristique assistant;
    private ChatMemory chatMemory;

    public LlmClient() {
        String cle = System.getenv("GEMINI_KEY");

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        this.chatMemory = MessageWindowChatMemory.withMaxMessages(20);

        this.assistant = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .chatMemory(this.chatMemory)
                .build();
    }



    public String envoyerRequete(String question) {
        return this.assistant.chat(question);
    }
}