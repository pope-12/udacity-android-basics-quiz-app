# Udacity Android Basics Pope Tech Quiz
Quiz app for android basics course

Contains 4 questions, 2 where a user must select all correct choices, 1 input text, and 1 radio.
User can receive partial credit for checkbox answers.

### What I learned:
* How to use checkboxes, radios, and text editTexts.
* I worked on structuring my code in a cleaner way so that it is easier to follow and debug
* How to use the styles and string resource files

### Questions I have:
I would like to learn how to do something like this quiz with a structure more like a JSON object.
For example, in javascript I would do something like this:

```
[
    {
        "questionName": "Who were the original owners of Pope Tech?",
        "questionId" : "original_owners",
        "questionType" : "radio",
        "answers" : [
            {
                "answerId" : "Larry",
                "text" : "Larry",
                "isCorrect" : true
            }
        ]
    }
]
```
This would enable me to loop through the questions both to generate the views and to grade them, which would be essential if there were more questions than 4.

In order to do this I will need to learn how to create a similar structure with JAVA or figure out how to use a JSON object. 
I will also need to learn how to use the string resources in java in connection with the data structure I use so that I can keep using them. 
In an actual app this would all probably come from a database so I need to figure out how that would work in connection with localization and string resources.