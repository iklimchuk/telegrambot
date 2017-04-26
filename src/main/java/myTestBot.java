import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class myTestBot extends TelegramLongPollingBot {
    public String getBotToken() {
        return "345168271:AAHQukcREAoS-xKXFmojW7qI8J6741iWhp4";
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                sendMessage(message); // Call method to send the message
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "myTestBot";
    }
}
