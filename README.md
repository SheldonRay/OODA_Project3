# OODA_Project3
## Program Title: Project 3
# Team Members: Jacob Reynolds, Tyler Devlin, Sheldon Ray
##
# Run Application Instructions:
## type 'javac *.java in folder to compile code
## run 'java StoreSim' to execute code
## Language Used: JAVA
Our design process began with a basic UML diagram, this was our loose foundation. Later on we created a working version of the program and re-created the UML diagram. 

The program simulates a store that sells various types of rolls. We designed the program so that that customers are created through a factory design with a pre determined array of what kind of rolls they want. We used a decorator pattern to account for sides and extras when customers purchased rolls. When a roll is purchased by a customer the process is handled by a command pattern, the command patter does other various things as well. The rolls have their own inventory and all are simmilar. A single day is simulated by the StoreSim class, we simulates 30 days in a row. If a roll is sold out one day, then the day following more of that kind of roll is added to the inventory. If a roll is sold out then customers have to order other ones or leave, depending on the customer.
## enjoy running our code
##
