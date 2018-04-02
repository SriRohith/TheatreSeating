package com.barclays.designprob.theatreseating;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.barclays.designprob.theatreseating.pojos.Patron;
import com.barclays.designprob.theatreseating.pojos.Row;
import com.barclays.designprob.theatreseating.pojos.Section;

public class TheatreSeating {

	public static void main(String[] args) {
		int totalNumOfSeats = 0;

		System.out.println("Enter number of rows for a theatre layout:");
		Scanner scanner = new Scanner(System.in);
		List<Row> rows = new ArrayList<Row>();
		List<Section> sections;
		int numOfRows = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter number of seats in each section seperated by space for each row: ");
		for (int i = 0; i < numOfRows; i++) {
			sections = new ArrayList<Section>();
			Row row = new Row();
			row.setRowid(i + 1);
			String line = scanner.nextLine();
			String[] arrayOfSeatCounts = line.split(" ");
			for (int j = 0; j < arrayOfSeatCounts.length; j++) {
				Section section = new Section();
				section.setSectionid(j + 1);
				section.setNumOfSeats(Integer.parseInt(arrayOfSeatCounts[j]));
				totalNumOfSeats = totalNumOfSeats + Integer.parseInt(arrayOfSeatCounts[j]);
				sections.add(section);

			}

			row.setSections(sections);
			rows.add(row);

		}

		System.out.println("Please enter ticket requests:" + "\n" + "Please type \"end\" when done.");

		List<Patron> patrons = new ArrayList<Patron>();
		while (true) {
			String line1 = scanner.nextLine();
			if (line1.equals("end")) {
				break;
			}
			String[] char1 = line1.split(" ");

			Patron patron = new Patron();
			patron.setCustomerName(char1[0]);
			patron.setRequestedSeats(Integer.parseInt(char1[1]));
			patrons.add(patron);
		}
		scanner.close();

		System.out.println("\nOutput:");
		for (Patron patron : patrons) {
			int count = 0;
			for (Row row : rows) {
				count++;

				for (Section section : row.getSections()) {
					int seats = section.getNumOfSeats();

					if (patron.getRequestedSeats() > 0 && seats == patron.getRequestedSeats() && count <= 2) {

						System.out.println("\n" + patron.getCustomerName() + " Row " + row.getRowid() + " Section "
								+ section.getSectionid());
						section.setNumOfSeats(section.getNumOfSeats() - patron.getRequestedSeats());
						totalNumOfSeats = totalNumOfSeats - patron.getRequestedSeats();
						patron.setRequestedSeats(0);
					}

				}
			}
			for (Row row : rows) {
				for (Section section : row.getSections()) {
					int seats = section.getNumOfSeats();
					if (patron.getRequestedSeats() > 0 && seats >= patron.getRequestedSeats()) {
						System.out.println(patron.getCustomerName() + " Row " + row.getRowid() + " Section "
								+ section.getSectionid());
						section.setNumOfSeats(section.getNumOfSeats() - patron.getRequestedSeats());
						totalNumOfSeats = totalNumOfSeats - patron.getRequestedSeats();
						patron.setRequestedSeats(0);
					}

				}
			}
			if (patron.getRequestedSeats() > 0 && totalNumOfSeats >= patron.getRequestedSeats()) {
				System.out.println(patron.getCustomerName() + " Call to split party.");
			} else if (patron.getRequestedSeats() > 0 && totalNumOfSeats < patron.getRequestedSeats()) {
				System.out.println(patron.getCustomerName() + " Sorry, we can't handle your party.");
			}

		}

	}

}
