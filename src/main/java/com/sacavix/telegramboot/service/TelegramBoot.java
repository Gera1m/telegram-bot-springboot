package com.sacavix.telegramboot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBoot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // Se obtiene el mensaje escrito por el usuario
        final String messageTextReceived = update.getMessage().getText();

        System.out.println("Escribieron en el bot " + messageTextReceived);

        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();

        // Se crea un objeto mensaje
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("¡Hola! Bienvenido a Gerado Bot 🤖\n"
        		+ "\n"
        		+ "Estoy aquí para cualquier cosa que necesites :)");

        try {
            // Se envía el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
 // Se pone el nombre del bot
    @Override
    public String getBotUsername() {
        return "Gerardobot";
    }

 // Se pone el token 
    @Override
    public String getBotToken() {
        return " AQUI DEBES DE PONER TU TOKEN :) ";
    }
}
