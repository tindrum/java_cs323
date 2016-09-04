import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class PostfixParsing 
{
	public static boolean checkOperator(char c)
	{
		if(c==('+' )|| c==('-') || c==('*') || c==('/') || c==('^') ||c==('$'))
			return true;
		return false;
	}

	public static void main(String[] args)
	{
		Stack<Integer> infixStack=new Stack<>();
		ArrayList<Character> charList =new  ArrayList<>();
		Map<Character, Integer> charMap = new HashMap<>();
		String postFix=null;
		char answer='n';
		Scanner sc = new Scanner(System.in);
		do
		{
			
			System.out.println("Enter the postfix:");
			postFix=sc.next().trim();
			System.out.println("You Entered:"+postFix);
			
			for(int i=0;i<postFix.length();i++)
			{
				char c=postFix.charAt(i);
				if(!checkOperator(c))
				{
					if((!charList.contains(c)))
					{
						charList.add(c);
						System.out.print("Enter the value for "+c+":");
						charMap.put(c, sc.nextInt());
					}		
				}
			}
			for(int i=0;i<postFix.length();i++)
			{
				char c=postFix.charAt(i);
				
				if(c=='$')
				{
					System.out.println("Value: "+infixStack.pop());
					charList.clear();
					charMap.clear();
					System.out.println("Continue(y,n)?");
					answer=sc.next().charAt(0);
					System.out.println(answer);
					break;
				}
				if(!checkOperator(c))
				{
					int value= charMap.get(c);
					infixStack.push(value);
				}
				if(checkOperator(c))
				{
					int inValue;
					int valueA=infixStack.pop();
					int valueB=infixStack.pop();
					
					switch(c)
					{
					case '+':
						inValue=valueA+valueB;
						infixStack.push(inValue);
						break;
					case '-':
						inValue=valueA-valueB;
						infixStack.push(inValue);
						break;
					case '*':
						inValue=valueA*valueB;
						infixStack.push(inValue);
						break;
					case '/':
						inValue=valueA/valueB;
						infixStack.push(inValue);
						break;
					case '^':
						inValue=valueA^valueB;
						infixStack.push(inValue);
						break;
					}
				}
			}	
		}while(answer=='y'||answer=='Y');
		sc.close();
	}		
}
		



