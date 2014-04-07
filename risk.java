import java.util.*;
import java.math.*;

public class risk
{
    public static void main(String args[])
    {
	boolean again = true;
	while (again)
	{
	    Scanner s = new Scanner(System.in);
	    //Read in number of units in attacking country
	    int attack;
	    System.out.println("Attacker number");
	    if (s.hasNextInt())
	    {
		attack = s.nextInt();
		if (attack <= 1)
		{
		    System.out.println("Too low to attack");
		    continue;
		}
	    }
	    else
	    {
		System.out.println("Not a number");
		continue;
	    }

	    //Read in number of units in defending country
	    int defend;
	    System.out.println("Defender number");

	    if (s.hasNextInt())
	    {
		defend = s.nextInt();
		if (defend <= 0)
		{
		    System.out.println("Too low to defend");
		    continue;
		}
	    }
	    else
	    {
		System.out.println("Not a number");
		continue;
	    }

	    boolean cont = true;
	    
	    //Fight!!!
	    while (cont)
	    {
		int att_dice = (attack > 3 ? 3 : (attack == 3 ? 2 : 1));
		int def_dice = (defend > 1 ? 2 : 1);
		int att[] = new int[att_dice];
		int def[] = new int[def_dice];

		//Roll attacker dice.
		for (int i = 0; i < att_dice; i++)
		{
		    int pos = i;
		    int x = (int)(Math.random() * 6) + 1;

		    //Sort rolled die into list of attacker dice
		    for (int j = i - 1; j >= 0; j--)
		    {
			if (x > att[j])
			{
			    att[j + 1] = att[j];
			    pos = j;
			}
		    }

		    att[pos] = x;
		}
		
		//Print attacker dice
		System.out.print("Attacker: ");
		
		for (int i = 0; i < att_dice; i++)
		{
		   System.out.print(att[i] + " "); 
		}

		System.out.println();

		//Roll defender dice
		for (int i = 0; i < def_dice; i++)
		{
		    int pos = i;
		    int x = (int)(Math.random() * 6) + 1;

		    //Sort rolled die into list of defender dice
		    for (int j = i - 1; j >= 0; j--)
		    {
			if (x > def[j])
			{
			    def[j + 1] = def[j];
			    pos = j;
			}
		    }

		    def[pos] = x;
		}

		//Print defender dice
		System.out.print("Defender: ");

		for (int i = 0; i < def_dice; i++)
		{
		   System.out.print(def[i] + " "); 
		}

		System.out.println();

		//Figure out who dies :(
		int a = 0;
		int d = 0;

		for ( int i = 0; i < Math.min(att_dice, def_dice); i++)
		{
		    if (att[i] > def[i])
		    {
			defend--;
			d++;
		    }
		    else
		    {
			attack--;
			a++;
		    }
		}
	    
		System.out.println("Attacker lost " + a + "; Defender lost " + d + ".");
		System.out.println("Attacker has " + attack + "; Defender has " + defend + ".");

		//Can battle continue?
		if (defend == 0)
		{
		    System.out.println("Defender has lost");
		    break;
		}
		else if (attack == 1)
		{
		    System.out.println("Attacker cannot continue");
		    break;
		}
	       
		//Battle can continue!  Will it?
		Scanner s3 = new Scanner(System.in);
		System.out.println("Go again?");
		String s2 = s3.nextLine();
		//if (s2.equals("")) s2 = s.nextLine();
		cont = s2.toLowerCase().equals("yes") || s2.toLowerCase().equals("y") || s2.equals("");
	    }

	    //Battle has ended.  New battle?
	    Scanner s4 = new Scanner(System.in);
	    System.out.println("New battle?");
	    String again2 = s4.nextLine();
	    again = again2.toLowerCase().equals("yes") || again2.toLowerCase().equals("y") || again2.equals("");
	}
    }
}