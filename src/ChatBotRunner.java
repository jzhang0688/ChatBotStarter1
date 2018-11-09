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
		Scanner in = new Scanner (System.in);
		System.out.println("Hi, I'm Spongebot! A chatbot all about your favorite invertebrate Spongebob Squarepants!");
		System.out.println("If you want to hear about the Krusty Krab, type 1!");
		System.out.println("If you want to know more about me and MY interests, type 2!");
		System.out.println("If you'd like to hear all about my best pal Squidward, type 3!");
		System.out.println("If you ever feel like switching, just type switch!");
		System.out.println("If... you don't want to chat with me at all...then you can just type bye...But I know that we'll have looots of fun together if you don't!");
		String statement = in.nextLine();
		statement = statement.trim();
		while (!statement.equalsIgnoreCase("Bye"))
		{
            if (statement.equals("1"))
            {
                chatbot1.chatLoop(statement);
            }
            else if (statement.equals("2"))
            {
                chatbot2.chatLoop(statement);
            }
            else if (statement.equals("3"))
            {
                chatbot3.chatLoop(statement);
            }
            else if (statement.equals("leave"))
            {
                System.out.println("You've gotta enter a Spongebot before you enter leave!");
            }
            else if ((statement.indexOf("") >= 0) && (statement.length() == 0))
            {
               System.out.println("I'm sorry, what was that?");
            }
            else
            {
                System.out.println("Well, you've gotta type one of the things that I said if you want a response, buddy!");
            }
			statement = in.nextLine();
		}
        System.out.println("Boo-hoo! Well...Have a nice day!");
	}
}
