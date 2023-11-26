## LDTS_l10g05 - Space Invaders
This project is a Java-based application developed using the Gradle build tool and Lanterna library graphical user interface. 
It's a game inspired by the classic **Space Invaders**, where the player controls a spaceship and the objective is to shoot down as many alien invaders as possible without them reaching the bottom end of the screen.
This is the perfect infinite game for someone willing to spend a good time !  

This project was developed by João Maria Correia Rebelo (up202107209@fe.up.pt) and Carlos Filipe Oliveira Sanches Pinto (up202107694@fe.up.pt) and Pedro Afonso Nunes Fernandes (up202207987@fe.up.pt) for LDTS 2023⁄24.

### IMPLEMENTED FEATURES

-**Visuals** - We have already implemented the graphical interface of the menu, aswell as the game arena.

### PLANNED FEATURES
-**Controls** - This feature will allow the player to interact with the game, controlling the spaceship's movements and firing bullets to defeat the alien invaders.
-**Spaceship Upgrades** - This feature will introduce a progression system where players can upgrade their spaceship, enhancing its firepower and speed.
-**Levels** - The game will be structured into different levels, each increasing in difficulty. Each level will introduce new challenges.
-**Highscore** - A highscore system will be implemented to track the player's best scores, fostering a sense of competition and replayability.
-**Sound Effects** -  We will add sound effects for various game events.
-**Boss** - To add more excitement and challenge, we will introduce a Boss enemy at the end of certain levels. The Boss will be tougher to defeat.

### DESIGN PATTERN
This project follows the Model-View-Controller (MVC) design architecture. MVC is a architectural pattern in software development that separates an application into three components: Model, View, and Controller. 
Each component has a specific role and responsibility, contributing to a clean and maintainable source code.
The model is isolated, view is connected to the model, and the controller depends on both.

### CONSEQUENCES
- Each component has a specific responsibility. This makes the code easier to understand, test, and maintain.
- It keeps the code modular, changes in one component won`t affect other components of the MVC. This makes it easier to update or replace components without affecting the rest of the application.
- Components like ArenaModel or PlayerModel can be reused across different parts of the project. 
- Different components can be developed in parallel. For example, one developer can work on the model while another works on the view.

### IMPLEMENTATION
-**Model**

<p>Model UML</p>
The Model is used to encapsulate the data and the logical operations related to it.

-**View**

<p>View UML</p>
The View is responsible for presenting the data to the user. It's the component that defines how the application's data is displayed.

--**UML**

<p>Project UML</p>

#### IMAGES
--**Menu**

<p>Menu.png</p>

--**Game**

<p>Game.png</p>

### SELF-EVALUATION

- Carlos Sanches: 33.4%
- João Rebelo: 33.3%
- Afonso Fernandes: 33.3%
