##Trivia Smack

Welcome to TriviaSmack! A pub quiz style game for you and your friends to play on Alexa.

To begin, tell Alexa to 'start TriviaSmack'. You can then set up your teams with 'game setup' and play by asking her to 'start quiz'.

TriviaSmack is written in Java 8 and hosted on [AWS Lambda](https://aws.amazon.com/lambda/). It is tested using JUnit and makes use of the [Alexa Skills Kit](https://github.com/amzn/alexa-skills-kit-js).

## Game Instructions

* After Installing, say "start trivia smack" to start the game.
* "Game Setup" will setup the team names and scores.
* Say "ask question" to get questions and "the answer is" followed by the answer to answer.
* For each question answered correctly, your team will score 1 point. 
* Once a team reaches 10 points, they win the game.

## Analysis

Working alongside my team, we developed a pub quiz game Alexa Skill in Java. Within two weeks, we had implemented all of the original features we had set out to include - multiple teams, a variety of questions, a time limit, answer verification, a score counter and a winner. 

We decided to use a Amazon Web Services Lambda to host our code and run our servers because it works well with Alexa.This gave us 3 programming languages to choose from and we decided to use Java because the other two options (Python or NodeJS) were very familiar to all of us and we wanted to learn something new. We also used JUnit to test our business logic. 

This was a great project because it was the first application I had built that did not have a visual representation. After focusing on web development for 10 weeks, it was nice to do something different and use a completely different language. The quality of the code is fairly low because of the time restraint we had and I would love to refactor it and encapsulate some of the functions into different classes. Furthermore, our test coverage was not as high as I wanted. 

You can see how the app works below.

![picture](https://asifhafeez.github.io/img/portfolio/alexa-graph.png)



