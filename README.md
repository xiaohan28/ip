# Eepy

Eepy is a simple **command-line task manager** that helps you track your tasks, deadlines, and events efficiently. Stay productive and never forget a task again! 🚀

## Setting up in Intellij

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into Intellij as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/eepy/ui/Eepy.java` file, right-click it, and choose `Run Eepy.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
     ______  ______  _____  __     __
    |  ____||  ____||  __ \ \ \   / /
    | |____ | |____ | |__) | \ \_/ /  
    |  ____||  ____||  ___/   \   /  
    | |____ | |____ | |        | |  
    |______||______||_|        |_|  
   
           (\_/)
          ( -.-)  zzZ   
          (")_(")
   
    ~ Sleepy Yet Productive Rabbit ~
   ```

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.
