# OODA_Project3
# Program Title: Project_3_RollStoreSim
# Team Members: Jacob Reynolds, Tyler Devlin, Sheldon Ray
# Run Application Instructions:
## type 'javac *.java in folder to compile code
## run 'java StoreSim \<number>' to execute code (number should be 30,45, or 60 and represents max inventory size)
## Language Used: JAVA
## Environment Used: Git Bash (I assume code works with IDEs such as Eclipse and Intelij as well)
Our design process began with a basic UML diagram, this was our loose foundation. Later on we created a working version of the program and re-created the UML diagram.

The program simulates a store that sells various types of rolls. We designed the program so that that customers are created through a factory design with a pre determined array of what kind of rolls they want. We used a decorator pattern to account for sides and extras when customers purchased rolls. When a roll is purchased by a customer the process is handled by a command pattern, the command patter does other various things as well. The rolls have their own inventory and all are simmilar. A single day is simulated by the StoreSim class, we simulates 30 days in a row. If a roll is sold out one day, then the day following more of that kind of roll is added to the inventory. If a roll is sold out then customers have to order other ones or leave, depending on the customer. We made the rolls priced as follwed, eggRoll = $2, springRoll = $3, pastryRoll = $4, sausageRoll = $5, and JellyRolls = $6. We made extras priced as followed, sauce = $1, filling = $2, topping = $3. We assumed that outputting "any added extras per roll" meant outputting the total number of added extras divided by the total number of rolls in a single order.
## enjoy running our code
##
