import java.util.*;

public class base4
{
    public static void main(String[] args)
    {

        // initial variables
        Scanner input = new Scanner(System.in);
        String user;
        String number = "";
        boolean invalid = true;

        while (invalid)
        {
            // get user input
            System.out.println("Enter a (base-10) number to be converted to base-4.");
            System.out.println("Note that anything other than a numerical digit will be ignored.");
            user = input.nextLine();
            // if there's any digit in our input
            for (int c = 0; c < user.length(); c++)
            {
                for (char n = 48; n < 58; n++)
                {
                    // add number to string and remove invalid flag
                    if (n == user.charAt(c))
                    {
                        number += user.charAt(c);
                        invalid = false;
                    }
                }
            }
            // if not
            if (invalid)
            {
                System.out.println("\nInvalid input. Try again.\n");
            }
        }

        // convert our number output to a useable double
        int base10 = Integer.parseInt(number);
        int carry = 0;
        int base4 = 0;
        int i = 0;

        System.out.printf("%nbase-10: %d", base10);

        while (base10 > 0)
        {
            carry = base10 % 4;
            base4 += (carry * Math.pow(10, i));
            base10 /= 4;
            i++;
        }

        System.out.printf("%nbase-4: %d", base4);

    }
}
