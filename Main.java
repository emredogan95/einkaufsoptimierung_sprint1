package Projekt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
	
	public static double sum(ArrayList<Artikel> list)
	{
		double sum = 0;
		
	    for (int i = 0; i < list.size(); i++) 
	    {
	        sum = sum + list.get(i).preis;
	    }
	    return sum;
	}
		
	// list 1 = Geschäft ; list 2 = einkaufsliste
	public static ArrayList<Artikel> retainAll(ArrayList<Artikel> list1, ArrayList<Artikel> list2)
	{
		ArrayList<Artikel> result = new ArrayList<Artikel>();
		
		for(int i = 0; i < list1.size(); i++)
		{
			for(int j = 0; j < list2.size(); j++)
			{
				if(list1.get(i).name.equals(list2.get(j).name))
				{
					result.add(list1.get(i));
				}
			}
		}
		
		return result;
	}
	
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Wie viele Artikel werden in den Geschäften angeboten?");
		
		int N = sc.nextInt(); // Anzahl der Artikel
		sc.nextLine();
		
		ArrayList<Artikel> ListeArtikel = new ArrayList<Artikel>();
		
		System.out.println("Bitte geben sie die Namen der Artikel in den Geschäften an.");
		
		for(int i = 0; i < N; i++)
		{
			String name = sc.next(); 
			double preis = 0;
			Artikel x = new Artikel(name, preis);
			ListeArtikel.add(x);
			
		}
		
		ArrayList<Artikel> ListeArtikel1 = new ArrayList<Artikel>(Arrays.asList(new Artikel[ListeArtikel.size()]));
		ArrayList<Artikel> ListeArtikel2 = new ArrayList<Artikel>(Arrays.asList(new Artikel[ListeArtikel.size()]));
		
		Collections.copy(ListeArtikel1, ListeArtikel);
		Collections.copy(ListeArtikel2, ListeArtikel);
 		
		
		Geschaeft Lidl = new Geschaeft(ListeArtikel1, "Lidl");
		Geschaeft Aldi = new Geschaeft(ListeArtikel2, "Aldi");
		
		System.out.println("Bitte setzen sie die Preise im Lidl.");
		
		for(int i = 0; i < N; i++)
		{
			double x = sc.nextDouble();
			Lidl.set_preis(x, i);
		}
		
		System.out.println("Bitte setzen sie die Preise im Aldi.");
		
		for(int i = 0; i < N; i++)
		{
			double x = sc.nextDouble();
			Aldi.set_preis(x, i);
		}
		
		
		ArrayList<Artikel> EinkaufsListe = new ArrayList<Artikel>();
		
		System.out.println("Wie viele Artikel möchten sie kaufen?");
		
		int AnzahlArtikel = sc.nextInt();
		
		System.out.println("Was möchten sie einkaufen?");
	
		for(int i = 0; i < AnzahlArtikel; i++)
		{
			String name = sc.next();
			Artikel x = new Artikel(name, 0);
			EinkaufsListe.add(x);
		}
		
		ArrayList<Artikel> LidlListe = retainAll(Lidl.liste, EinkaufsListe);
		
		double sumL = sum(LidlListe);
		
		ArrayList<Artikel> AldiListe = retainAll(Aldi.liste, EinkaufsListe);
		
		double sumA = sum(AldiListe);
		
		if(sumL > sumA)
		{
			System.out.println("Gehen sie zum Aldi");
		}
		else
		{
			System.out.print("Gehen sie zum Lidl");
		}
		
        
    }

}
