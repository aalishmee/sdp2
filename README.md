# Assignment 2 — Factory Method & Abstract Factory

**Student:** Alish Medina
**Group:** SE-2538
**Submitted commit:** `<paste your short commit hash here>`

---

## Purpose
A Java console application that demonstrates **two creational design patterns working together in one program**:
- **Factory Method** — a delivery system that creates a `Truck` (road) or a `Ship` (sea) transport.
- **Abstract Factory** — a UI system that creates a **matching family** of `Button` and `Checkbox` components for either the **Windows** or the **macOS** platform.
At runtime the user chooses one **delivery mode** and one **UI platform**. All four valid combinations run without editing the code. Invalid input produces a clear error message and stops cleanly — no silent default is ever used.
---
## Package Structure
src/
├── Main.java Entry point: reads args, validates, wires patterns
│
├── app/
│ └── DeliveryApplication.java Client using both patterns via abstractions only
│
├── transport/ FACTORY METHOD
│ ├── Transport.java Product interface (deliver)
│ ├── Truck.java Concrete product — road delivery
│ ├── Ship.java Concrete product — sea delivery
│ ├── Logistics.java Creator: declares createTransport() + shared planDelivery()
│ ├── RoadLogistics.java Concrete creator — returns Truck
│ └── SeaLogistics.java Concrete creator — returns Ship
│
└── ui/ ABSTRACT FACTORY
├── Button.java Abstract product #1
├── Checkbox.java Abstract product #2
├── GUIFactory.java Abstract factory: createButton() + createCheckbox()
├── WindowsButton.java Windows family — button
├── WindowsCheckbox.java Windows family — checkbox
├── WindowsFactory.java Concrete factory — Windows
├── MacOSButton.java macOS family — button
├── MacOSCheckbox.java macOS family — checkbox
└── MacOSFactory.java Concrete factory — macOS

---

## Prerequisites
- **JDK 17** (tested with Temurin 17). Verify with:
java -version
javac -version
Both must print `17.x.x`.
- Any Java IDE (IntelliJ IDEA recommended) **or** a terminal with `javac` on the PATH.

---

## Run
IntelliJ: **Run → Edit Configurations → Main → Program arguments:** `ROAD WINDOWS` → Run ▶
Terminal:
javac -d out (Get-ChildItem -Recurse -Filter *.java src | % FullName)
java -cp out Main ROAD WINDOWS

## Inputs
- Arg 1: `ROAD` or `SEA`
- Arg 2: `WINDOWS` or `MACOS`
Anything else → error message, clean stop.

## Sample Output
Delivery mode: ROAD UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse

## Verification
| # | Input | Result |
|---|---|---|
| 1 | ROAD WINDOWS | Truck + Windows UI |
| 2 | SEA WINDOWS | Ship + Windows UI |
| 3 | ROAD MACOS | Truck + macOS UI |
| 4 | SEA MACOS | Ship + macOS UI |
| 5 | PLANE WINDOWS | Error: unsupported delivery mode |
| 6 | ROAD LINUX | Error: unsupported platform |
| + | (no args) | Error: missing input |

## UML
- [Factory Method](<img width="798" height="1016" alt="package" src="https://github.com/user-attachments/assets/d43c3f1d-f291-49ce-b104-b49d200b6053" />
)
- [Abstract Factory](<img width="840" height="1536" alt="package2" src="https://github.com/user-attachments/assets/7ae8aa3c-387a-492e-9270-d98bd94715c4" />
)

## References
1. Freeman & Robson. *Head First Design Patterns*, Ch. 4.
2. Martin, R. C. *Clean Code*, Ch. 6.
3. Lecture 2 slides, ShP-2216, Astana IT University, 2026–2027.
