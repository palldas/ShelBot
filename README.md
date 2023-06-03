# ShelBot
Authors: Pallavi Das, Laksh Bhambhani, Ruchika Dixit

Revision: 5/17/20

## Introduction: ##

Our program is an interface for a program that will teach kids to code, in a fun and educational way that they can see and touch, and practice their knowledge on an interactive robot - the ShelBot. It includes the robot and a simulator (PC Application) used to communicate with the robot. Both serve the function of teaching the user how to code. The program teaches programming based on a specified difficulty level to keep kids busy. They write Java code using block-based programming, provided by the program. After instruction by the program and putting together their own program, users will be able to connect to the robot, deploy code, and watch the robot execute the program. Users can program ShelBot to move, talk and more. 


ShelBot is unique, as while there are many educational programs to teach kids about a variety of topics, including programming, there aren’t really any educational robots on the market. Younger kids especially, the target audience of this program, really need tactile interactions and hands on learning experience. ShelBot and the program bring a new tangible and physical aspect to coding. Parents can use this program as a fun toy for their kids that also keeps them intellectually occupied.


Kids with little or even no coding experience would follow through provided tutorials and write code using text or piecing together blocks. If the program connects to a nearby ShelBot, this code would then be deployed to the ShelBot and be executed. If not, the code would run in the simulator, which is similar to scratch IDE. The user will receive a ShelBot sprite and the code would run on that. Additionally, ShelBot can also act as your child’s companion. ShelBot can talk and interact with the user and possibly even play some games. To best simulate the enriching learning experience of a classroom, ShelBot can also move and act like Mr. Shelby and Mr. Taylor depending on its mode.


## Instructions: ##

When the program first starts; the user will see a loading page. Once it is loaded, the user will be taken to a programming window. In the window, there will be a link to a tutorial, as well as a button that takes the user to more tutorials when clicked, and a close button that closes the tutorial when clicked.

At the top of the window, there are two buttons: file and help. Clicking File will bring up a menu with options Open, Save, About (which opens a popup with information about the program, and Exit. Under help, the button “report a bug” links to a google form.

Under the file and help bar, there are 4 tabs: Code, Sounds, Control, and Tutorial. Clicking each takes the user to a different window.

The program automatically opens to Code, the program window. On the left side of the program, there is a menu containing the options: Motion, Control, Events, Operators, and Sound. Clicking any of these will open to its left a list of commands/blocks under that category. Next to that is a blank screen, which will contain the code, and to the very right, a humanoid. 

The user can drag and drop blocks from the menu onto the blank screen to add the commands of the blocks to the code. To remove a block, drag it to the trash icon under the blocks or to the section you got it from. To clear the code screen of all blocks, click the trash icon. The green flag at the top will run the user’s constructed program, while the red hexagon will stop it and reset the humanoid to its starting state.

In the tab Sound, the center contains several labeled buttons. Each plays a unique sound when pressed. To the right, there are two buttons. The first, Upload, when clicked, will open a finder window that allows the user to upload audio files, which will then show up as a button in the center. The second button, TextToSpeech, opens a pop up with a textbox. The text entered in the box will be converted into audio, again added as a button in the center.

In the Control Tab the user has options to choose between 4 different modes the robot can be controlled in. These are teleop mode in which the user can connect xbox or nintendo joycons to control the robot manually, autonomous mode where the robot will control itself and Shelby and Taylor mode where the robot will act like Mr. Shelby or Mr. Taylor.

The Tutorials tab has buttons that link to tutorial videos when pressed.


## Features List: ##


### Must-have Features: ###


* Block-based programming: The program will have blocks of code (simplified for easy user interaction) corresponding to certain actions that the robot can take. Some examples of blocks include: MathUtils blocks, Raise Hand to this Level block, Move by _ Steps block, Talk block, etc. Users can drag and drop blocks into a window that contains the code the user has written so far. 
* Text to Speech based interaction: The robot would be able to use built-in speakers to play audio files or convert text entered by the user to speech.
* Client Server based interaction: Users would be able to communicate with the robot using a software running on the laptop or on his or her phone. This includes a server running on the robot side that constantly communicates with the user interface.
* Teleop Control: Teleop control will allow for the user to move the robot without having to code the actions. A controller, which would have pre-coded buttons for different actions, would control the certain movements of the robot, such as moving its arms. The user can use this to get to know the different movement aspects of the robot.
* Autonomous[d][e] Mode. This mode will allow for certain things randomly such as sharing general facts from the web, walking around, exploring the environment, etc. 


### Want-to-have Features: ###


* Interactive interface for tutorials. Similar to the tutorials in many professional online tools, there could be a tutorial that walks the user through different tasks (e.g., a highlighted code block in the editor and a text box that says “drag and drop blocks into the program”, or an arrow pointing to the new file button and a text box that says “click here to create a new file”).
* Lower-body movement. Currently ShelBot can move its arms, but cannot move around or move its lower body. We can possibly change the robot so the user can input commands such as, walk, kick, etc. 
* Microphone input. Users can give voice commands to the ShelBot (such as, “say ___”, “move your arms up”, or “open your claw”) that will be recognized and executed by the robot. The robot does not respond with voice in this case.
* Audio interaction with the user. The robot will have full length conversations with the user in this mode. The robot will basically act as a social robot friend.
* Transporting objects from one place to another. The ShelBot has arms and could grab things in its hand/claws, then move them to a different location.


### Stretch Features: ###


* Using CV to interact. Adding a camera to shelbot and using OpenCV to either visualize the surroundings and use SLAM to map out the environment or use it to detect certain objects to visualize gait for a trajectory or recognize and interact with use
* Camera streaming back to the client. Streaming camera back to the client software so the user can control it using just his/her phone while having robots’ eyes.
* Using a camera stream to navigate. Using the camera stream and touching a point to direct ShelBot to walk to that point. ShelBot will generate a path and visualize it’s gait to that point. Similar to controlling Boston Dynamics’ Spot.



## Class List: ##


* Client Side/Simulator Code
   * Main.java - runs/executes the whole program
   * SimulatorWindow.java - graphics interface, where all the other windows are drawn
   * Analyzer.java - Represents a compiler - converts the blocks put together by the user into executable code
   * Blocks (package)
      * Block - represents a draggable block of code
      * BlocksDrawer - draws the blocks imputed from an ArrayList
      * Control - contains the control blocks
      * Daddy - This class models a Daddy (daddy block). It can be used in the ProgrammingWindow to have drag and drop programming with the Processing PApplet. These types of blocks require a block within them in order to perform its operations.
      * Events - contains the events blocks
      * Motion - contains the motion blocks
      * Operators - contains the operator blocks
      * Sound - contains the sound blocks
      * ShadowBlock - This class models a ShadowBlock. It can be used in the ProgrammingWindow to portray a shadow of a Block object using the Processing PApplet.
   * Comms (package)
      * ConnectionVerifier - Pings an ip address. Helps us know about the acknowledgement from the bot once its pinged successfully
      * NetworkTables - NetworkTables act as a database with the server running on the robot and this acting as a client. This way many things can be stored and accessed from the database
   * Controller (package)
      * Joycons - Represent Joycons that can be used to control the shelbot
      * Xbox - Another runnable class for multithreading. Uses and starts xbox listener
      * XboxControl - A class for making Jamepad more easier
      * XboxListener - Transmits data to server over JEditorPane after inputs from xbox
   * Sound (package)
      * Player - Represents a player that can play and stop sounds
      * Recorder - Used to record audio files
      * Sound - Represents a sound
   * Sprite (package)
      * Cat - Represents a cat that could run the code
      * Humanoid - Represents a humanoid that could run the code
      * Sprite -  Represents a sprite or a character on which the code runs
   * Tts
      * TextSpeech - Represents an interface that converts text to audio files
   * Utils (package)
      * Button - This class models a Button. It can be used to switch between different tabs and is drawn using Processing PApplet.
      * ImageButton - Used to make a button with an image in the background that is blurred
      * MathUtils - Contains some math utils
      * Popup - Used to make a popup tab
      * Section - This class models a Section. It is used to display different windows throughout the program using Processing PApplet.
      * SimulatorMenu - responsible for the menu bar on top of the simulator window
      * TabbedPane - The tabbed pane on the top the shelbot simulator
      * VideoButton - This class models a Button. It can be used to switch between different tabs and is drawn using Processing PApplet.
   * Windows (package)
      * AboutWindow - The about panel to tell user what version of the simulator they are using and who built the simulator
      * BlocksCategory - Represents the blocks category window on the left most corner. Used to switch view of the Block Drawer
      * BlocksWindow - Used to draw the blocks. This is where the user gets the new blocks from
      * IntroWindow - The first window that shows up when the program starts. Shows a loading bar.
      * ProgrammingWindow - This class models a Programming Window. In this window, the user can drag and drop blocks, which will then be executed. It is constructed/drawn using the Processing PApplet.
      * SoundList - Represents the Sound List which contains all the sounds
      * Sounds - Contains option to upload or convert text to speech
      * SpriteWindow - This window contains the sprite
      * TeleopList - This represents the teleop list to choose between different ways to control the robot
      * TeleopWindow - Represents a menu with options- Control, Auton, Taylor Mode, Shelby Mode. The menu can also shift to the left or right; Contains a window with a basic control map and used to interact with the robot to send it commands to move based on joystick inputs
      * Tutorials - Represents the tutorial tab


   * Robot Side Code (Server)
   * Uses WPILib (Robotics software library)
   * Commands (package)
      * MoveArm - represents a command to move the robot arm
      * Grab - represents a command to close the robot claw
      * Release - represents a command to open the robot claw
      * Walk - represents a command for the robot to walk
   * DataCollection (package)
      * ComputerVision - Gets data from connected camera
   * Subsystems (package)
      * Leg - represents a robot leg
      * Arm - represents a robot arm 
      * Claw - represents a robot claw
      * ServoSubsystem - The main class responsible for controlling the servo (Each motor used in ShelBot’s joints)
   * Utils (package)
      * MathUtils - Used to calculate various mathematical functions
   * Constants (package)
      * RobotConstants - Contains various constants such as Starting position or Angles required at certain time for a certain position
      * RobotMap - Contains the ports that each Servo is connected to the microprocessor
   * Main.java - run the robot
   * Robot.java - represents the robot, includes its subsystems



## External Credits: ##
   * JoyconLib
      * Library developed to integrate Nintendo Joycons into your project which will be used to control the robot
   * PureJavaHIDApi
      * Used for JoyconLib to work. 
      * Joycon are HID input devices and this library allows us to connect to the joycons and extract their values
   * JamePAD
      * Used to control ShelBot using xbox. Reads and listens to value updates from the xbox controller
   * WPILib
      * Robot software library. Made by WPi
   * MaryTTS - text to speech library used to generate audio.
   * Minim Sound Library
      * Used to play sounds
   * Javazoom
      * Supporting library for Minim
   * NTCore
      * Network Tables Library. Helps us initialize a database on the client to exchange values between the client and the server
   * Tritonus
      * Supporting Library for Minim
