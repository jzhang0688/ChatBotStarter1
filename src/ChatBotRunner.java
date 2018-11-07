import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		ChatBot1 chatbot1 = new ChatBot1();
		ChatBot2 chatbot2 = new ChatBot2();
		ChatBot3 chatbot3 = new ChatBot3();
		

		Scanner in = new Scanner (System.in);
		System.out.println("Hi, I'm Spongebot! A chatbot all about your favorite invertebrate Spongebob Squarepants!");
		System.out.println("If you want to hear about the Krusty Krab, type 1!");
		System.out.println("If you want to know more about me and MY interests, type 2!");
		System.out.println("If you'd like to hear all about my best pal Squidward, type 3!");
		System.out.println("If... you don't want to chat with me at all...then you can just type bye...But I know that we'll have looots of fun together if you dont!");
		String statement = in.nextLine();



		while (!statement.equals("Bye"))
		{
			//Use Logic to control which chatbot is handling the conversation\
			//This example has only chatbot1
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
            else if (statement.equals("bye"))
            {
               System.out.println("Boo-hoo! Well...Have a nice day!");
            }
            else
            {
                System.out.println("Well, you've gotta type one of the things that I said if you want a response, buddy!");
            }
			statement = in.nextLine();
		}
	}

}
