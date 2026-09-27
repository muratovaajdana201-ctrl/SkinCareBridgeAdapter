# Skin Care Treatment System

## Project Description

This project is a small skin care treatment system created to demonstrate two structural design patterns:

- Bridge
- Adapter

The system is designed around different skin care sessions and different ways of performing treatment.

For example, the system can work with:

- Facial Care
- Hydration Care

The treatment can be performed using:

- Manual Care
- Device Care
- Legacy Skin Care System

The main purpose of the project is to show how the Bridge pattern separates different parts of the system and how the Adapter pattern allows a new system to work with an old system that has a different interface.

---

# Bridge Pattern

The Bridge pattern is used to separate the skin care session from the method used to perform the treatment.

The main abstraction is:

`SkinCareSession`

There are two types of sessions:

- `FacialCareSession`
- `HydrationCareSession`

The implementation interface is:

`TreatmentMethod`

It has different implementations:

- `ManualCareMethod`
- `DeviceCareMethod`
- `LegacySkinCareAdapter`

Because of the Bridge pattern, a skin care session does not need to know exactly which treatment method is used.

For example:

`FacialCareSession` can work with `ManualCareMethod`.

It can also work with `DeviceCareMethod`.

It can also work with `LegacySkinCareAdapter`.

This makes the system easier to extend.

---

# Adapter Pattern

The Adapter pattern is used to connect the new system with the old legacy system.

The new system works with the interface:

`TreatmentMethod`

The interface contains:

`perform()`

However, the old system has another method:

`execute()`

These interfaces are not compatible.

The old system is represented by:

`LegacySkinCareSystem`

This class is the Adaptee.

To connect it with the new system, I created:

`LegacySkinCareAdapter`

The adapter implements:

`TreatmentMethod`

and contains:

`LegacySkinCareSystem`

The adapter receives a request from the new system and converts it into the format required by the legacy system.

---

# How Adapter Works

The client sends a `TreatmentRequest`.

The request contains:

- client ID
- service code
- duration

For example:

`FACIAL_CARE`

The adapter converts the service code into a legacy procedure code:

`FACIAL_CARE -> 101`

For hydration treatment:

`HYDRATION_CARE -> 202`

After that, the adapter calls the legacy system:

`legacySystem.execute()`

The legacy system returns a `LegacyResult`.

The adapter converts this result into:

`TreatmentResult`

The client only works with `TreatmentResult` and does not need to know about the legacy system.

---

# Object Adapter

This project uses the Object Adapter implementation.

The adapter contains an object of the legacy system:

`private final LegacySkinCareSystem legacySystem;`

This means that the adapter uses composition.

The structure is:

`TreatmentMethod`

`LegacySkinCareAdapter`

`LegacySkinCareSystem`

The advantage of this approach is that the legacy class does not have to be changed.

---

# Main Classes

## TreatmentMethod

`TreatmentMethod` is the interface used by the new system.

It defines the common method:

`perform(TreatmentRequest request)`

The result is:

`TreatmentResult`

---

## SkinCareSession

`SkinCareSession` is the main abstraction of the Bridge pattern.

It contains a `TreatmentMethod`.

The session uses the selected treatment method to perform the treatment.

---

## FacialCareSession

`FacialCareSession` represents a facial care session.

It extends `SkinCareSession`.

---

## HydrationCareSession

`HydrationCareSession` represents a hydration care session.

It also extends `SkinCareSession`.

---

## ManualCareMethod

`ManualCareMethod` is one implementation of `TreatmentMethod`.

It represents a treatment performed manually.

---

## DeviceCareMethod

`DeviceCareMethod` is another implementation of `TreatmentMethod`.

It represents a treatment performed using a device.

---

## LegacySkinCareAdapter

`LegacySkinCareAdapter` is the Adapter.

It implements `TreatmentMethod`.

Inside the adapter there is:

`LegacySkinCareSystem`

The adapter translates the request from the new system to the format required by the legacy system.

---

## LegacySkinCareSystem

`LegacySkinCareSystem` is the old system used in the project.

It has an incompatible method:

`execute()`

The legacy system is not changed.

The Adapter is used to make it compatible with the new system.

---

## TreatmentRequest

`TreatmentRequest` contains information about the treatment request.

It contains:

- client ID
- service code
- duration in minutes

---

## TreatmentResult

`TreatmentResult` contains the result of the treatment.

It contains:

- success status
- result message

---

## LegacyResult

`LegacyResult` is the result returned by the legacy system.

The adapter converts `LegacyResult` into `TreatmentResult`.

---

## TreatmentMethodSelector

`TreatmentMethodSelector` is used to select the treatment method.

The available types are:

- `MANUAL`
- `DEVICE`
- `LEGACY`

Depending on the selected type, the selector returns the required implementation.

For example:

`MANUAL -> ManualCareMethod`

`DEVICE -> DeviceCareMethod`

`LEGACY -> LegacySkinCareAdapter`

---

## TreatmentException

`TreatmentException` is used when an incorrect or unknown service code is provided.

For example, if the system receives an unsupported service code, an exception is thrown.

---

# Project Structure

. src
. . main
. . . java
. . . . adapter
. . . . . LegacySkinCareAdapter.java
. . . . bridge
. . . . . TreatmentMethod.java
. . . . . SkinCareSession.java
. . . . . FacialCareSession.java
. . . . . HydrationCareSession.java
. . . . . ManualCareMethod.java
. . . . . DeviceCareMethod.java
. . . . exception
. . . . . TreatmentException.java
. . . . legacy
. . . . . LegacySkinCareSystem.java
. . . . . LegacyResult.java
. . . . model
. . . . . TreatmentRequest.java
. . . . . TreatmentResult.java
. . . . selection
. . . . . TreatmentMethodSelector.java
. . . . . TreatmentMethodType.java
. . . . Main.java
. . test
. . . java
. . . . LegacySkinCareAdapterTest.java
. . . . SkinCareBridgeTest.java
. . . . TreatmentMethodSelectorTest.java
. . . . TreatmentExceptionTest.java
. pom.xml
. SkinCareSystem.puml
. SkinCareSystem_UML.png
. README.md

---

# How the System Works

The general structure of the system is:

`SkinCareSession`

↓

`TreatmentMethod`

↓

`ManualCareMethod / DeviceCareMethod / LegacySkinCareAdapter`

When the legacy method is selected:

`SkinCareSession`

↓

`LegacySkinCareAdapter`

↓

`LegacySkinCareSystem`

The adapter translates the request before sending it to the legacy system.

---

# Example

A client can create a treatment request:

`FACIAL_CARE`

with a duration:

`60 minutes`

If the legacy treatment method is selected, the adapter changes:

`FACIAL_CARE`

into:

`101`

Then the legacy system executes procedure `101`.

The result from the legacy system is returned to the adapter.

The adapter converts it to `TreatmentResult`.

The client receives the result without knowing that the legacy system was used.

---

# Testing

JUnit tests were added to check the main parts of the system.

The tests check:

- Adapter functionality
- Service code translation
- Facial care session
- Hydration care session
- Treatment method selection
- Legacy adapter selection
- Exception handling

The tests were run using:

`Run All Tests`

Result:

`7 tests passed`

All tests passed successfully.

---

# UML Diagram

The project also contains a UML diagram created using PlantUML.

The source file is:

`SkinCareSystem.puml`

The exported image is:

`SkinCareSystem_UML.png`

The UML diagram shows the main classes and relationships between the Bridge and Adapter patterns.

The diagram includes:

- `SkinCareSession`
- `FacialCareSession`
- `HydrationCareSession`
- `TreatmentMethod`
- `ManualCareMethod`
- `DeviceCareMethod`
- `LegacySkinCareAdapter`
- `LegacySkinCareSystem`
- `TreatmentRequest`
- `TreatmentResult`
- `LegacyResult`
- `TreatmentMethodSelector`

---

# Why Bridge is Used

Bridge is used because the system has two different dimensions.

The first dimension is the type of skin care session:

- Facial Care
- Hydration Care

The second dimension is the treatment method:

- Manual
- Device
- Legacy

Without Bridge, many separate classes would be needed for every possible combination.

Bridge allows these parts to be changed independently.

---

# Why Adapter is Used

Adapter is used because the legacy system already exists and has a different interface.

The new system expects:

`perform()`

The legacy system provides:

`execute()`

Changing the legacy class is not necessary.

Instead, `LegacySkinCareAdapter` translates between the two interfaces.

This is the main reason for using Adapter in this project.

---

# Advantages

The Bridge pattern makes the system more flexible because the session type and treatment method can be changed independently.

The Adapter pattern allows the old system to be reused without changing its code.

The interface conversion is located in one class, which makes the code easier to maintain.

The project also uses JUnit tests to check the main functionality.

---

# Disadvantages

The main disadvantage is that the project contains more classes because of the design patterns.

For a very small system, using Bridge and Adapter could make the code more complicated than necessary.

However, in this project the patterns are useful because the system has different treatment types and also needs to work with an incompatible legacy system.

---

# Maven

The project uses Maven.

The main Maven configuration is stored in:

`pom.xml`

The project uses Java 25.

---

# How to Run

Open the project in IntelliJ IDEA.

To run the application:

1. Open `Main.java`.
2. Find the `main()` method.
3. Click Run.

To run the tests:

1. Open `src/test/java`.
2. Right-click the test folder.
3. Select `Run All Tests`.
4. Check that all 7 tests are passed.

---

# Conclusion

This project demonstrates how Bridge and Adapter design patterns can be used together in one system.

Bridge separates the skin care session from the treatment method.

Adapter connects the new system with the existing legacy system.

The legacy system does not need to be changed.

The project also includes Maven configuration, UML documentation, exception handling, dynamic treatment method selection and JUnit tests.

The final test result is:

`7 tests passed`