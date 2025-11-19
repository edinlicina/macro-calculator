📘 Macro Calculator – Spring Boot Application

A simple and extensible Java Spring Boot application that calculates:
•	BMR (Basal Metabolic Rate)
•	TDEE (Total Daily Energy Expenditure)
•	Daily calorie target based on goal (lose, maintain, gain)
•	Recommended daily macros (protein, fat, carbs)

This project is built for practicing backend development, REST APIs, and unit testing in Java.
It is structured cleanly so you can easily extend it with daily logs, meals, or even a mobile frontend later.

⸻

✨ Features
•	🧮 Calculate BMR using the Mifflin–St Jeor formula
•	🔥 Calculate TDEE using activity multipliers
•	🎯 Goal-based calorie adjustment (LOSE, MAINTAIN, GAIN)
•	🍗 Macro breakdown (protein, fat, carbs per day)
•	🚀 REST API endpoint for calculations
•	🧪 JUnit tests to validate calculation correctness
•	📦 Ready for expansion (e.g., Daily Logs, Meals, Database)

⸻

📡 API Overview

POST /api/macros/calculate

Calculate BMR, TDEE, and daily macro targets based on a user profile.

example JSON:
{
"age": 24,
"sex": "MALE",
"heightCm": 190,
"weightKg": 160,
"activityLevel": "LIGHT",
"goal": "LOSE"
}

example Response:
{
"bmr": 2672.5,
"tdee": 3674.6875,
"caloriesPerDay": 3174.6875,
"proteinGramsPerDay": 238.1,
"fatGramsPerDay": 88.19,
"carbsGramsPerDay": 357.15
}

🏗️ Tech Stack
•	Java 17+
•	Spring Boot
•	Spring Web
•	Spring Validation
•	JUnit 5

Optional (if enabled):
•	H2 Database
•	Spring Data JPA

⸻

▶️ How to Run

Run via IntelliJ
1.	Open the project
2.	Locate MacroCalculatorApplication
3.	Click the green run button
