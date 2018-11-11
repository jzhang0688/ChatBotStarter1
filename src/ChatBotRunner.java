import java.util.Scanner;

public class ChatBotRunner
{
    public static void main(String[] args)
    {
        //Author: Romando Cooper
        ChatBot1 chatbot1 = new ChatBot1();
        //Author: Jie Zhang
        ChatBot2 chatbot2 = new ChatBot2();
        //Author: Raymond Hu
        ChatBot3 chatbot3 = new ChatBot3();
        Scanner in = new Scanner(System.in);
        System.out.println("Hi, I'm Spongebot! A chatbot all about your one and only, Spongebob Squarepants! Before we continue, please tell me your name. If you want to leave, just type 'bye'!");
        String test = in.nextLine();
        test = test.trim();
        String name = test;
        while (!test.equalsIgnoreCase("Bye"))
            if ((test.contains("")) && (test.length() == 0)) {
                System.out.println("ERROR: NO USER NAME INPUT. SPONGEBOT TERMINATED. I'M READY. I'M READY. I'M READY.");
                System.exit(0);
            } else {
                //Here the chatbot remembers the name that the user typed into the console from a previous conversation.
                System.out.println("Nice to meet you, " + name + "! If you want to hear about the Krusty Krab, type '1'! If you want to know more about me and MY interests, type '2'! If you'd like to hear all about my best pal Squidward, type '3'! If... you don't want to chat with me at all...then you can just type 'bye'...but I know that we'll have looots of fun together if you don't type that!");
                String statement = in.nextLine();
                statement = statement.trim();
                while (!statement.equalsIgnoreCase("Bye")) {
                    statement = statement.trim();
                    if (statement.equals("1")) {
                        chatbot1.chatLoop(statement);
                    } else if (statement.equals("2")) {
                        chatbot2.chatLoop(statement);
                    } else if (statement.equals("3")) {
                        chatbot3.chatLoop(statement);
                    } else if ((statement.contains("")) && (statement.length() == 0)) {
                        System.out.println("I'm sorry, what was that?");
                    } else {
                        System.out.println("Well, you've gotta type one of the things that I said if you want a response, buddy!");
                    }
                }
                break;
            }
        System.out.println("Awwwww! Well...have a nice day!");
    }
}
