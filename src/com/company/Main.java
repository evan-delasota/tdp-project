package com.company;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner blockScanner = new Scanner(System.in);
        List<AuthorCatalog> authorList = new ArrayList<>();
        authorList.add(new AuthorCatalog("Steven King", "Horror"));
        authorList.add(new AuthorCatalog("Rudyard Kipling", "Adventure"));
        authorList.add(new AuthorCatalog("Isaac Asimov", "Science Fiction"));
        authorList.add(new AuthorCatalog("Suzanne Collins", "YA Fiction"));
        int indexOfLargestAuthor;

        while (blockScanner.hasNextLine()) {
            String blockInput = blockScanner.nextLine();
            if (blockInput.equals("")) {
                break;
            }
            Scanner lineScanner = new Scanner(blockInput);

            while (lineScanner.hasNextLine()) {
                String book = lineScanner.nextLine();
                parseBookInput(book, authorList);
            }

            lineScanner.close();

        }
        blockScanner.close();

        indexOfLargestAuthor = findIndexOfLargestAuthor(authorList);
        printOldestBook(authorList, indexOfLargestAuthor);


    }
    public static void parseBookInput(String book, List<AuthorCatalog> catalog) {
        String[] splitInput = book.split(",");
        String title = splitInput[0];
        String date = splitInput[1];
        String author = splitInput[2];
        Integer pages = Integer.parseInt(splitInput[3]);

        if (author.equals("Steven King")) {
            catalog.get(0).addBook(new Book(title, date, author, pages));
        } else if (author.equals("Rudyard Kipling")) {
            catalog.get(1).addBook(new Book(title, date, author, pages));
        } else if (author.equals("Isaac Asimov")) {
            catalog.get(2).addBook(new Book(title, date, author, pages));
        } else if (author.equals("Suzanne Collins")){
            catalog.get(3).addBook(new Book(title, date, author, pages));
        } else {
            System.out.println("Invalid author, try again\n\n");
        }
    }

    public static int findIndexOfLargestAuthor(List<AuthorCatalog> list) {
        int indexOfLargestAuthor = 0;
        for (int i = 1; i < list.size(); ++i) {
            int currentAuthor = list.get(i).getCollectionSize();
            if (list.get(indexOfLargestAuthor).getCollectionSize() < currentAuthor) {
                indexOfLargestAuthor = i;
            }
        }

        return indexOfLargestAuthor;
    }
    public static void printOldestBook(List<AuthorCatalog> list, int index) {
        System.out.println(list.get(index).getOldestBook().getTitle() + ", written by "
                + list.get(index).getGenre() + " writer "
                + list.get(index).getOldestBook().getAuthor() + " on "
                + list.get(index).getOldestBook().getDate() + " is "
                + list.get(index).getOldestBook().getLength() + " pages long.");
    }

}

