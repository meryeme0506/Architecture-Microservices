create table livres (isbn VARCHAR(100) primary key not null, auteur VARCHAR(100), titre VARCHAR(100), editeur VARCHAR(100), edition VARCHAR(100));
create table lecteurs(id INT PRIMARY KEY NOT NULL, genre VARCHAR(10), nom VARCHAR(100), prenom VARCHAR(100), date_naissance VARCHAR(100), adresse VARCHAR(100));
create table pret (id INT PRIMARY KEY NOT NULL, isbn VARCHAR(100), lecteur int, date_pret VARCHAR(100), date_retour VARCHAR(100), foreign key (isbn) references livres(isbn), foreign key (lecteur) references lecteurs(id));
