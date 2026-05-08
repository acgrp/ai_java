# Simple Calculator

This is a simple Java Swing-based calculator application with basic arithmetic operations (+, -, *, /) and a modern, colorful user interface.

## Features

-   **Basic Arithmetic Operations:** Perform addition, subtraction, multiplication, and division.
-   **Intuitive Input:** Two input fields for numbers and a dedicated display for the result.
-   **Enhanced User Interface:**
    -   **Gradient Background:** The main calculator window features a smooth gradient background for a visually appealing look.
    -   **Colorful Buttons:** Each operation button has a distinct background color (Green for '+', Red for '-', Blue for '*', Yellow for '/') to make the interface vibrant and easy to distinguish.
    -   **Image Integration:** Includes placeholders for a main decorative image and operation-specific images that appear in the result pop-up.
    -   **Result Pop-up:** Calculation results are displayed not only on the main screen but also in a small, modal pop-up window along with a relevant image (if provided).
    -   **Error Handling:** Catches invalid number inputs and division by zero, displaying appropriate messages.
-   **User-Friendly:** Simple and straightforward to use.

## Setup and Installation

To run this application, you need to have a Java Development Kit (JDK) installed on your system.

1.  **Clone the repository (if you haven't already):**
    ```bash
    git clone https://github.com/acgrp/ai_java.git
    cd ai_java
    ```

2.  **Navigate to the project directory:**
    ```bash
    cd C:\Users\student\Desktop\AI프로그램\ai_java
    ```

3.  **Image Assets (Optional but Recommended):**
    For the full visual experience, you'll need to provide image files for the main calculator display and the result pop-ups. Place these files in the `src/test/` directory of your project.
    -   `main_calculator.png`: For the main calculator window.
    -   `add_icon.png`: For addition results.
    -   `sub_icon.png`: For subtraction results.
    -   `mul_icon.png`: For multiplication results.
    -   `div_icon.png`: For division results.
    -   `error_icon.png`: For error messages (e.g., invalid input, division by zero).
    
    If these files are not present or paths are incorrect, the image labels will appear blank.

## How to Compile and Run

1.  **Compile the Java source code:**
    Open your terminal or command prompt, navigate to the project's root directory (`C:\Users\student\Desktop\AI프로그램\ai_java`), and run the following command:
    ```bash
    javac -d . src/test/SimpleCalculator.java
    ```
    This command compiles the `SimpleCalculator.java` file and places the compiled `.class` files in the appropriate package structure.

2.  **Run the application:**
    After successful compilation, execute the application using:
    ```bash
    java test.SimpleCalculator
    ```

## Usage

1.  Enter your first number in the "Number 1:" text field.
2.  Enter your second number in the "Number 2:" text field.
3.  Click on any of the operation buttons (`+`, `-`, `*`, `/`).
4.  The result will be displayed in the "Result:" label on the main window and also in a small pop-up window.
5.  If you enter non-numeric values or attempt to divide by zero, an "Invalid Input" or "Error: Div by 0" message will appear, and an error pop-up will be shown.

Enjoy using your colorful Simple Calculator!
