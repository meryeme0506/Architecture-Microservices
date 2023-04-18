# Utiliser une image Java 8 comme image de base
FROM openjdk:17-jdk-alpine

# Copier le fichier JAR dans l'image Docker
COPY out/artifacts/Book_jar/Book.jar Book.jar

# Exposer le port 8000 pour accéder à l'application
EXPOSE 8000

# Démarrer l'application lors du lancement du conteneur
ENTRYPOINT ["java","-jar","/Book.jar"]