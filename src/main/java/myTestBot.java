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
            SendMessage message = new SendMessage();
            if (update.getMessage().getText().equals("go!")){
                message.setChatId(update.getMessage().getChatId())
                        .setText("Натааааашенькааааа :) Бусь!");
            } else {
                message.setChatId(update.getMessage().getChatId())
                        .setText("?");
            }
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
