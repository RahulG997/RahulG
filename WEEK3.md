Week #3: Course Materials
  * Java
  * JDBI
  * Maven

The primary objective of week #3 is to complete the Cli fully to list all Menu /Ordering the food/accept/cancel canteenmanagement applications.

We will also start doing standups from this week. https://www.mountaingoatsoftware.com/agile/scrum/meetings/daily-scrum

Each day, as the team does the standup, one from each team notes down briefly the answers to the three questions for each team member and send it to the facilitators.

Here is a rough format (for each team)

Subject: FTP{nn} daily standup – {date}

{team member#1}:

Yesterday:
Completed {blah}, In progress {blah}
Today:
Will complete {blah}, Will start {blah}
Impediments:
{Things like machine issues, network issues etc}
{team member #2:

...
Ideally, the blahs above should include the ticket number FTP{nn}-{jj}

Java (Continued from Week#2)
Junit/JMockit (Continued from Week#2)
Devops/Continuous Integration/Continuous Delivery/Build Automation/Jenkins
Week #3 Sprint Goals:
* Trello Project Board User Story: "As a Cli user of the canteenmanagement application, as a Customer, I should be able to order the food."
* Trello Project Board User Story: "As a Cli user of the canteenmanagement application, as an Customer, I should be able to see all my food orders."
* Trello Project Board User Story: "As a Cli user of the canteenmanagement application, as a Vendor admin, I should be able to see the food order with all status("Placed Order","Order In Process","Delivered").
* Trello  Project Board User Story: "As a Cli user of the canteenmanagement application, as a Vendor admin, I should be able to accept/cancel any placed order in canteenmanagement applications".
* Trello Project Board Task: "Make the mvn package succeed"

Suggested Steps
Before starting the first task
Whiteboard Cli Menu
Whiteboard Java methods for the functionalities
Create skeleton class for Customer,Order,Vendor,factory classes and empty methods for order,view order history,accept/cancel, list all menu items etc.
For the first task + story
One person to add Order class,factory class and then its DAO/Mapper
One Person to change cli
One person to add Vendor class,its factory class and then its DAO/Mapper
One Person to add Customer class,its factory class and its DAO/Mapper
Similarly for the other stories
Simultaneously work on adding unit tests
One person to make mvn package succeed - add Menu tests
Others to add tests for Order etc.
Tests for the cli
Basic tests
Invalid input for the data type
Including for the menu option
Non-existing employee id
Apply wallet balance not sufficient
Order placed <-> Order Processed <-> Order Cancelled three-way state transitions
Advanced tests
Reading material
Must-Read
CI/CD
https://www.atlassian.com/continuous-delivery/continuous-delivery-workflows-with-feature-branching-and-gitflow
https://www.agilealliance.org/glossary/continuous-integration
https://continuousdelivery.com/
https://www.infoq.com/articles/orch-pipelines-jenkins
Nice-To-Read
Go-Deep
