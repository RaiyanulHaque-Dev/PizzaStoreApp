PizzaStoreApp 🍕

Description:
PizzaStoreApp is a Java Swing desktop application simulating a pizza store. Users can register, login, browse pizzas, add items to a cart, and checkout with a receipt display. The app features animated backgrounds, interactive UI cards, and a functional cart system, making it both a practical and visually appealing project.

Features

User Management
Register new users
Login existing users
Simple username/password authentication (stored in UserStore)
Pizza Store
Browse pizza items
Add items to a shopping cart
Remove items or reset cart
Checkout
Generate a receipt with itemized list
Shows total price
Uses JTextArea for formatted receipts
UI/UX
Animated GIF backgrounds
Responsive panels and cards
Modern fonts and colors


Architecture
MVC-inspired structure
ui/ → User Interface
model/ → Cart and CartItem logic
util/ → UserStore
Fully object-oriented design

Project Structure
PizzaStoreApp/
├── src/
│   ├── ui/
│   │   ├── LoginFrame.java
│   │   ├── RegisterFrame.java
│   │   ├── StoreFrame.java
│   │   ├── CheckoutFrame.java
│   │   ├── PizzaCard.java
│   │   ├── AnimatedBackground.java
│   │   └── BackgroundPanel.java
│   ├── model/
│   │   ├── Cart.java
│   │   └── CartItem.java
│   ├── util/
│   │   └── UserStore.java
│   └── Main.java
├── resources/
│   └── backgrounds/
│       └── pizza_bg.gif
└── README.md

Requirements
Java JDK 17+
Swing-compatible environment (desktop GUI)
Terminal or IDE (IntelliJ, Eclipse, VS Code)

How to Compile & Run
Open terminal in project root (PizzaStoreApp folder)
Compile all Java files:
javac -d bin src/Main.java src/ui/*.java src/model/*.java src/util/*.java

Run the application:
java -cp bin Main

Note: Ensure the resources/ folder is in the classpath if using images.

Future Improvements
Password hashing for security
Save users and orders to a database
Export receipt as PDF
Add more pizza categories and images
Refactor into a full MVC design
