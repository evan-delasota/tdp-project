package com.company;

import java.util.*;

public class Main {
    private static final int dataLimit = 100;

    public static void main(String[] args) {
        System.out.println("Enter book data");
        Scanner blockScanner = new Scanner(System.in);
        List<AuthorCatalog> authorList = new ArrayList<>();
        authorList.add(new AuthorCatalog("Steven King", "Horror"));
        authorList.add(new AuthorCatalog("Rudyard Kipling", "Adventure"));
        authorList.add(new AuthorCatalog("Isaac Asimov", "Science Fiction"));
        authorList.add(new AuthorCatalog("Suzanne Collins", "YA Fiction"));
        int indexOfLargestAuthor;
        int blockLength = 0;
        // receives block of data
        while (blockScanner.hasNextLine()) {
            String blockInput = blockScanner.nextLine();
            blockLength += blockInput.split("\n").length;
            if (blockInput.equals("")) {
                break;
            }
            if (blockLength > dataLimit) {
                throw new IllegalArgumentException("Data size is too large to be parsed, ensure block is less than 100 'books' long.\n");
            }
            Scanner lineScanner = new Scanner(blockInput);
            // Scans through input line by line
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
    // Receives book and list of author catalog, splits book data into readable tokens,
    // then adds book to correct author catalog.
    public static void parseBookInput(String book, List<AuthorCatalog> catalog) {
        String[] splitInput = book.split(",");
        if (splitInput.length != 4) {
            throw new IllegalArgumentException("Incorrect book formatting!\n\n");
        }
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
            System.out.println("Author not supported in catalog, please try again\n\n");
        }
    }
    // Returns the index of author with the largest book catalog
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
    // Displays the oldest book of an author using the author's index
    public static void printOldestBook(List<AuthorCatalog> list, int index) {
        System.out.println(list.get(index).getOldestBook().getTitle() + ", written by "
                + list.get(index).getGenre() + " writer "
                + list.get(index).getOldestBook().getAuthor() + " on "
                + list.get(index).getOldestBook().getDate() + " is "
                + list.get(index).getOldestBook().getLength() + " pages long.");
    }

}

