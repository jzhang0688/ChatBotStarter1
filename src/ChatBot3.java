import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Raymond Hu
 * @version November 2018
 */
public class ChatBot3
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
    int emotion = 0;
    /**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());
		while (!statement.equalsIgnoreCase("Bye"))
		{
			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));
		}
	}
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "So what would you like to know about my pal Squidward?";
	}
	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		statement = statement.trim();
		String response = "";

		if ((statement.indexOf("") >= 0) && (statement.length() == 0))
		{
			response = "I'm sorry, what was that?";
		}
		else if (findKeyword(statement, "leave") >= 0)
		{
			System.exit(0);
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Squidward gets mad when anyone says no to him.";
			emotion--;
		}
		else if (findKeyword(statement, "easter island") >= 0)
		{
		    response = "That is where Squidward bought his house from.";
			emotion++;
		}
		else if (findKeyword(statement, "squidward") >= 0)
		{
			response = "Squidward is the best sea creature ever. Better than a sponge like me!";
			emotion++;
		}
		else if (findKeyword(statement, "jellyfishing") >= 0)
		{
			response = "Squidward looooooves to jellyfish!";
			emotion++;
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Squidward gets mad when anyone says no to him.";
			emotion--;
		}
		else if (findKeyword(statement, "patrick") >= 0)
		{
			response = "Patrick is Squidward's favorite invertebrae! Well, besides me of course.";
			emotion++;
		}
		else if (findKeyword(statement, "summer") >= 0)
		{
			response = "Squidward's favorite season is summer! Not that there are any seasons where we live but whatever.";
			emotion++;
		}
		else if (findKeyword(statement, "season") >= 0)
		{
			response = "Squidward's favorite season is summer! Not that there are any seasons where we live but whatever.";
			emotion++;
		}
		else if (findKeyword(statement, "instrument") >= 0)
		{
			response = "Squidward's favorite instrument is his trusty clarinet!";
			emotion++;
		}
		else if (findKeyword(statement, "clarinet") >= 0)
		{
			response = "Squidward loves clarinets!";
			emotion++;
		}
		else if (findKeyword(statement, "krusty krab") >= 0)
		{
			response = "Squidward works as a cashier at the good ol' Krusty Krab!";
			emotion++;
		}
		else if (findKeyword(statement, "mr krabs") >= 0)
		{
			response = "Squidward gets along with Mr. Krabs so well!";
			emotion++;
		}
		else if (findKeyword(statement, "scrap") >= 0)
		{
			response = getRandomResponse();
			emotion++;
		}
		// Cuss words are a part of the code, so if you'll excuse me....
		else if (statement.indexOf("crap") >= 0)
		{
			response = getRandomCussRes();
			emotion--;
		}
		else if (statement.indexOf("shit") >= 0)
		{
			response = getRandomCussRes();
			emotion--;
		}
		else if (statement.indexOf("fuck") >= 0)
		{
			response = getRandomCussRes();
			emotion--;
		}
		else if (statement.indexOf("bitch") >= 0)
		{
			response = getRandomCussRes();
			emotion--;
		}
		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
			emotion++;
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
			emotion++;
		}
		else if (findKeyword(statement, "I like",0) >= 0)
		{
			response = transformILikeStatement(statement);
			emotion++;
		}
		else if (findKeyword(statement, "I feel",0) >= 0)
		{
			response = transformIFeelStatement(statement);
			emotion++;
		}
		else if ((findKeyword(statement, "I",0) >= 0) && (findKeyword(statement, "you", 0) >= 0))
		{
			response = transformIYouStatement(statement);
			emotion++;
		}
		return response;
	}

	private String transformILikeStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "I like", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Squidward likes " + restOfStatement + " too!" +" I'm sure you two will get along perfectly.";
	}
	/**
	 * Take a statement with "I want to <something>." and transform it into
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "I'm sure Squidward wants to" + restOfStatement + "as well.";
	}
	/**
	 * Take a statement with "I want <something>." and transform it into
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "You and Squidward both want " + restOfStatement + ", how interesting!";
	}

	private String transformIFeelStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if(lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length()-1);
		}
		int psn = findKeyword(statement, "I feel", 0);
		String restOfStatement = statement.substring(psn+6).trim();
		return "You should talk to Squidward, he feels " + restOfStatement + " too.";
	}
	/**
	 * Take a statement with "I <something> you" and transform it into
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Squidward would think the same of you, I'm sure.";
	}
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();
		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);
		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
			}
			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) // before is not a letter
			{
				return psn;
			}
			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);
		}
		return -1;
	}
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}

	private String [] randomNeutralResponses = {"I'm ready! I'm ready! I'm ready!", "Aw, tartar sauce!!!", "You mean what we thought they thought we think and thought they thought?", "You'll never beat me, I'm HYDRODYMAMICALLY DESIGNED!", "SOAP SOAP WHAT IS SOAP?", "More soup for your armpit?", "Are you talking to me? No, you're talking next to me!"};

	private String [] randomAngryResponses = {"Aaaaahhhhhhhhh!!!!", "You knucklehead!!!!", "I ain't listening to you!!!", "You foul-mouthed creature!", "How could you???!!!", "Barnacles! Why are you still here?", "Tartar sauce! Just leave me alone already!!!"};

	private String [] randomHappyResponses = {"F is for friends that .......", "U is for ukulele .......", "N is for anytime and anywhere .......", "Lalalalalalalala", "Awwwwww, just the two of us having a chat. How nice." , "I wish Squidward was here so he can also join this amazing conversation we have so far."};

	private String getRandomCussRes ()
    {   Random r = new Random ();
		return randomCussRes [r.nextInt(randomCussRes.length)];
	}

	private String [] randomCussRes = {"Now I know Squidward would never say something like that! So you shouldn't either!", "I can't believe my ears! You better hope Squidward didn't hear that.", "I said that to Squidward once, he was not happy." , "That is what gets you in trouble with good samaritans like Squidward."};
}
