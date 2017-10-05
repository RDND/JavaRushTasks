package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*а) Вывести в консоль текст полученного сообщения message.
б) Получить из message имя отправителя и текст сообщения. Они разделены «: «.
в) Отправить ответ в зависимости от текста принятого сообщения.*/
public class BotClient extends Client{
    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random()*100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread{

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String name = "";
            String text;
            if (message.contains(": ")) {
                String[] array = message.split(": ");
                name = array[0];
                text = array[1];
            }
            else
                text = message;
            SimpleDateFormat format = null;
            switch (text){
                case "дата":
                    format = new SimpleDateFormat("d.MM.YYYY");
                    break;
                case "день":
                    format = new SimpleDateFormat("d");
                    break;
                case "месяц":
                    format = new SimpleDateFormat("MMMM");
                    break;
                case "год":
                    format = new SimpleDateFormat("YYYY");
                    break;
                case "время":
                    format = new SimpleDateFormat("H:mm:ss");
                    break;
                case "час":
                    format = new SimpleDateFormat("H");
                    break;
                case "минуты":
                    format = new SimpleDateFormat("m");
                    break;
                case "секунды":
                    format = new SimpleDateFormat("s");
                    break;
            }
            if (format != null)
                sendTextMessage("Информация для " + name + ": " + format.format(Calendar.getInstance().getTime()));
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }
    public static void main(String[] args){
        new BotClient().run();
    }
}