# **Eepy - Your Personal To-Do List Manager** ✅

Eepy is a **command-line to-do list tracker** designed to help you manage your tasks efficiently. Stay on top of your deadlines and events while keeping track of your daily tasks in a simple and structured way.

---

## 📥 **Quick Start**
### **Prerequisites**
- Ensure you have **Java 17** or later installed on your system.

### **Steps to Run Eepy**
1. **Download the latest `.jar` file** from the [GitHub releases](#) (https://github.com/xiaohan28/ip/releases/tag/A-Jar).
2. **Open a terminal** and navigate to the directory where the `.jar` file is located.
3. **Run the application** using:
   ```sh
   java -jar eepy.jar
   ```
4. **Start entering commands!** See the features below for available commands.

---

## ⚡ **Features**
Eepy supports the following commands:

| Command        | Description |
|---------------|------------|
| `todo TASK` | Adds a To-Do task |
| `deadline TASK /by DATE` | Adds a Deadline task |
| `event TASK /from START /to END` | Adds an Event task |
| `list` | Displays all tasks |
| `mark INDEX` | Marks a task as completed |
| `unmark INDEX` | Unmarks a completed task |
| `remove INDEX` | Deletes a task |
| `find KEYWORD` | Searches for tasks containing a keyword |
| `bye` | Exits the application |

---

## 🎯 **Usage Examples**

### ➤ **Adding a To-Do Task**
```
todo Finish CS2113 Assignment
```
**Output:**
```
Task added: [T][ ] Finish CS2113 Assignment
Now you have 1 task in the list.
```

### ➤ **Adding a Deadline**
```
deadline Submit Report /by 2025-03-20
```
**Output:**
```
Task added: [D][ ] Submit Report (by: 2025-03-20)
Now you have 2 tasks in the list.
```

### ➤ **Adding an Event**
```
event Project Meeting /from 2025-03-15 /to 2025-03-16
```
**Output:**
```
Task added: [E][ ] Project Meeting (from: 2025-03-15 to: 2025-03-16)
Now you have 3 tasks in the list.
```

### ➤ **Finding a Task**
```
find Report
```
**Output:**
```
Found it! Here are the matching tasks:
1. [D][ ] Submit Report (by: 2025-03-20)
```

### ➤ **Marking a Task as Done**
```
mark 1
```
**Output:**
```
Well done! You've completed the following task:
[T][X] Finish CS2113 Assignment
```

### ➤ **Deleting a Task**
```
remove 2
```
**Output:**
```
  Removed: [T][X] CS2113
Now you have 6 tasks in the list.
```

---

## 🚀 **Setup for the User Guide**

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

---

🚀 **Stay productive with Eepy!** 📝
