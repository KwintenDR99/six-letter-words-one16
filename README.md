# Six Letter Words API
## _One16 challenge_

This repository contains the six letter words API challenge. The application accepts a text file that contains words with a varying length from 1 to 6 characters and will return all combinations of those words that together form a word of 6 characters and that are also present in the input file.

The application is written in Java using Spring Boot.

## Running the application

You can start the application using the following command that you execute in the root of the project.
```sh
./gradlew bootRun
```

The application will start on port 8080 and you can send the input file and see the result using the following curl-command.
```sh
curl -F file=@"input.txt" http://localhost:8080/api/file
```

You can also execute the following commands with other input files. The first command will send an empty file and the application will return a bad request with an appropriate error message. The second command will send a JSON file and the application will also return a bad request with an appropriate error message.

```sh
curl -F file=@"input_empty.txt" http://localhost:8080/api/file
curl -F file=@"input_json.json" http://localhost:8080/api/file
```

If you want to use Postman to execute the api calls, you can import the 'six-letter-words-one16.postman_collection.json' file that will import a Postman collection. You will have to reselect the appropriate files in the body section of the request.

## Checking the database

All six letter word combinations that are also present in the input file, are stored in an H2 in-memory database. You can access this database by going to the following url http://localhost:8080/h2-console and by entering 'jdbc:h2:mem:sixLetterWord' as the value for the JDBC URL. You can then press the connect button and query the 'WORD_COMBINATIONS' table to see all word combinations that are saved.

Every six letter word combination can only be saved once in the database. If you try to save the same combination multiple times, the application will log the combination with an appropriate message and will continue handling other combinations.

The database is created every time the application starts and dropped when the application ends.