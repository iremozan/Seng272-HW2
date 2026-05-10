ISO 15939 Software Measurement Process Simulator
==================================================
Implementation V1

Student name : Irem Ozan
Student ID   : <fill in>
Course       : Software Project II
Repository   : https://github.com/iremozan/ISO15939_project


WHAT IS IN THIS VERSION (V1)
----------------------------
This is the first version of the project. It contains the basic structure
and the first two steps of the wizard. Steps 3, 4, and 5 are wired in but
show a "Coming soon" message - they will be filled in in V2 and V3.

Working in V1:
  - Step 1: Profile (username, school, session name) with validation
  - Step 2: Define (quality type, mode, scenario) with single-selection
  - Step indicator at the top with active/done/pending states
  - Wizard navigation (Back / Next) with validation

Coming in V2:
  - Step 3: Plan (read-only table of dimensions and metrics)
  - Step 4: Collect (raw values and 1-5 score calculation)

Coming in V3:
  - Step 5: Analyse (weighted averages, radar chart bonus, gap analysis)


REQUIREMENTS
------------
  - Java SE 17 or higher
  - No third-party libraries (only the standard Java SE library)


PROJECT STRUCTURE
-----------------
  src/
    Main.java                    application entry point
    model/
      QualityType.java           enum for product/process
      Mode.java                  enum for health/education
      Metric.java                abstract base class
      MaximizingMetric.java      higher-is-better subclass
      MinimizingMetric.java      lower-is-better subclass
      Dimension.java             group of metrics
      Scenario.java              group of dimensions
      MeasurementSession.java    holds user input
      ScenarioCatalog.java       hard-coded scenario data
      ScoreUtils.java            clamp + round-to-half helpers
    controller/
      StepNavigator.java         interface for navigation
      WizardManager.java         flow + validation
    view/
      StepView.java              interface with onEnter()
      AppFrame.java              JFrame + CardLayout
      StepHeader.java            top step indicator
      ProfilePanel.java          Step 1
      DefinePanel.java           Step 2
      PlaceholderPanel.java      stub for steps 3-5


HOW TO BUILD AND RUN (LINUX / MACOS)
------------------------------------
From the project root:

  mkdir -p build
  javac -d build -encoding UTF-8 src/model/*.java src/controller/*.java src/view/*.java src/Main.java
  java -cp build Main

Or just run the helper script:

  ./build.sh


HOW TO BUILD AND RUN (WINDOWS)
------------------------------
From the project root, in Command Prompt:

  if not exist build mkdir build
  javac -d build -encoding UTF-8 src\model\*.java src\controller\*.java src\view\*.java src\Main.java
  java -cp build Main

Or just run the helper script:

  build.bat


SCENARIO DATA
-------------
HEALTH:
  - Scenario A - Hospital System
  - Scenario B - Patient Portal

EDUCATION:
  - Scenario C - Team Alpha   (matches the PDF example dataset)
  - Scenario D - Team Beta    (lower numbers, useful for V3 gap analysis)


SCORE FORMULA
-------------
  Higher is better:  score = 1 + (value - min) / (max - min) * 4
  Lower is better:   score = 5 - (value - min) / (max - min) * 4

The result is then clamped to [1.0, 5.0] and rounded to the nearest 0.5.
