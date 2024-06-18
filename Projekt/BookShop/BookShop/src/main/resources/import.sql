INSERT INTO Author (id, name, surname) VALUES (1, 'John', 'Doe');
INSERT INTO Author (id, name, surname) VALUES (2, 'Jane', 'Smith');
INSERT INTO Author (id, name, surname) VALUES (3, 'Mark', 'Twain');
INSERT INTO Author (id, name, surname) VALUES (4, 'Harper', 'Lee');
INSERT INTO Author (id, name, surname) VALUES (5, 'J.K.', 'Rowling');
INSERT INTO Author (id, name, surname) VALUES (6, 'Ernest', 'Hemingway');
INSERT INTO Author (id, name, surname) VALUES (7, 'Leo', 'Tolstoy');
INSERT INTO Author (id, name, surname) VALUES (8, 'Virginia', 'Woolf');

INSERT INTO Book (id, genre, price, pages, available, views, author_id) VALUES (UUID(), 'Fiction', 29.99, 350, 400, 500, 1);
INSERT INTO Book (id, genre, price, pages, available, views, author_id) VALUES (UUID(), 'Science Fiction', 19.95, 280, 500, 200, 2);
INSERT INTO Book (id, genre, price, pages, available, views, author_id) VALUES (UUID(), 'Mystery', 24.99, 400, 800, 300, 3);
INSERT INTO Book (id, genre, price, pages, available, views, author_id) VALUES (UUID(), 'Romance', 14.95, 240, 200, 150, 4);
INSERT INTO Book (id, genre, price, pages, available, views, author_id) VALUES (UUID(), 'Fantasy', 19.99, 320, 150, 180, 5);
INSERT INTO Book (id, genre, price, pages, available, views, author_id) VALUES (UUID(), 'Biography', 29.95, 450, 220, 220, 6);
INSERT INTO Book (id, genre, price, pages, available, views, author_id) VALUES (UUID(), 'Historical Fiction', 22.50, 380, 120, 270, 7);
INSERT INTO Book (id, genre, price, pages, available, views, author_id) VALUES (UUID(), 'Thriller', 26.99, 420, 90, 250, 8);
