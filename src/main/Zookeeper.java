package main;

import main.animals.Animal;
import main.animals.IAirBreather;
import main.animals.IWaterAnimal;
import main.environment.DayOrNight;
import main.strings.ZooStrings;

/**
 * The Zookeeper parses input from the command line, performs commanded actions,
 * and provides feedback to the user.
 */
public final class Zookeeper {

    private Zoo zoo;

    /**
     * Zookeeper contructor.
     * 
     * @param zoo The {@link main.Zoo Zoo} with the {@link main.animals.Animal
     *            Animals} the zookeeper is managing.
     */
    public Zookeeper(Zoo zoo) {
        this.zoo = zoo;
    }

    /**
     * Process the command, perform any required action, and provide feedback to the
     * user.
     * 
     * @param input The unmodified command line input.
     */
    public void processCommand(String input) {
        String[] cmd = input.trim().toLowerCase().split(" ");
        if (cmd.length > 0) {
            if (cmd[0].equals(ZooStrings.FEED_CMD) || cmd[0].equals(ZooStrings.GIVE_WATER_CMD)
                    || cmd[0].equals(ZooStrings.PUT_TO_SLEEP_CMD) || cmd[0].equals(ZooStrings.WAKE_UP_CMD)) {
                if (cmd.length > 1) {
                    String[] args = ZooStrings.getArgs(cmd);
                    if (ZooStrings.areArgumentsValid(args)) {
                        if (ZooStrings.arrayContainsDuplicates(args)) {
                            System.out.println("\n     Duplicate arguments not allowed.\n");
                        } else {
                            processValidatedAnimalCareCommand(cmd[0], args);
                        }
                    } else {
                        System.out.println("\n     Command contains invalid argument.\n");
                    }
                } else {
                    System.out.println("\n     \"" + cmd[0] + "\" command requires at least 1 argument.\n");
                }
            } else if (cmd[0].equals(ZooStrings.REPORT_CMD) || cmd[0].equals(ZooStrings.NEW_CMD)) {
                if (cmd.length > 1) {
                    System.out.println("\n     \"" + cmd[0] + "\" command does not take any arguments.");
                }
                if (cmd[0].equals(ZooStrings.NEW_CMD)) {
                    zoo.generateNewConditions();
                    System.out.println("\nStarting new shift...");
                }
                zoo.printStatusReport();
            } else if (!cmd[0].equals(ZooStrings.EXIT_CMD) && !cmd[0].equals(ZooStrings.QUIT_CMD)) {
                System.out.println("\n     " + cmd[0] + " is not a valid command.\n");
            } else {
                // Exit command or Quit command. Handled in main do-while loop.
            }
        }
    }

    private void processValidatedAnimalCareCommand(String cmd, String[] args) {
        switch (cmd) {
        case ZooStrings.FEED_CMD:
            feedAnimals(args);
            break;
        case ZooStrings.GIVE_WATER_CMD:
            giveWaterToAnimals(args);
            break;
        case ZooStrings.PUT_TO_SLEEP_CMD:
            putAnimalsToSleep(args);
            break;
        case ZooStrings.WAKE_UP_CMD:
            wakeUpAnimals(args);
            break;
        default:
            break;
        }
    }

    private void feedAnimals(String[] animalNames) {
        for (String animalName : animalNames) {
            Animal animal = zoo.getAnimal(animalName);
            if (animal != null) {
                if (animal.sleepWakeState() == Animal.SleepWakeState.Sleeping) {
                    System.out.println("     Cannot feed " + animalName + " while it is sleeping.");
                } else if (animal.isHungry()) {
                    if (animal.feed()) {
                        System.out.println("     " + animalName + " eats the food.");
                    } else {
                        System.out.println("     Error! " + animalName + " should have eaten the food but did not.");
                    }
                } else {
                    System.out.println("     Cannot feed " + animalName + " because it is not hungry");
                }
            }
        }
    }

    private void giveWaterToAnimals(String[] animalNames) {
        for (String animalName : animalNames) {
            Animal animal = zoo.getAnimal(animalName);
            if (animal != null) {
                if (animal instanceof IWaterAnimal) {
                    System.out.println("     Cannot give water to " + animalName + " because it is a water animal.");
                } else if (animal.sleepWakeState() == Animal.SleepWakeState.Sleeping) {
                    System.out.println("     Cannot give water to " + animalName + " while it is sleeping.");
                } else if (animal.isThirsty()) {
                    if (animal.giveWater()) {
                        System.out.println(animalName + " drinks the water.");
                    } else {
                        System.out
                                .println("     Error! " + animalName + " should have drank the water but it did not.");
                    }
                } else {
                    System.out.println("     Cannot give water to " + animalName + " because it is not thirsty.");
                }
            }
        }
    }

    private void putAnimalsToSleep(String[] animalNames) {
        for (String animalName : animalNames) {
            Animal animal = zoo.getAnimal(animalName);
            if (animal != null) {
                if (!(animal instanceof IAirBreather)) {
                    System.out
                            .println("     Cannot put " + animalName + " to sleep because it is not an air breather.");
                } else {
                    boolean canPutAnimalToSleep = true;
                    if (zoo.dayOrNight() == DayOrNight.Day) {
                        System.out.println("     Cannot put " + animalName + " to sleep during the day.");
                        canPutAnimalToSleep = false;
                    }
                    if (animal.sleepWakeState() == Animal.SleepWakeState.Sleeping) {
                        System.out.println("     Cannot put " + animalName + " to sleep when it is already sleeping.");
                        canPutAnimalToSleep = false;
                    }
                    if (canPutAnimalToSleep) {
                        if (((IAirBreather) animal).putToSleep()) {
                            System.out.println("     " + animalName + " goes to sleep.");
                        } else {
                            System.out.println(
                                    "     Error! " + animalName + " should have gone to sleep but it did not.");
                        }
                    }
                }
            }
        }
    }

    private void wakeUpAnimals(String[] animalNames) {
        for (String animalName : animalNames) {
            Animal animal = zoo.getAnimal(animalName);
            if (animal != null) {
                if (!(animal instanceof IAirBreather)) {
                    System.out.println("     Cannot wake up " + animalName + " because it is not an air breather.");
                } else {
                    boolean canWakeAnimal = true;
                    if (animal.sleepWakeState() == Animal.SleepWakeState.Awake) {
                        System.out.println("     Cannot wake up " + animalName + " when it is already awake.");
                        canWakeAnimal = false;
                    }
                    if (canWakeAnimal) {
                        if (((IAirBreather) animal).wakeUp()) {
                            System.out.println("     " + animalName + " wakes up.");
                        } else {
                            System.out.println("     Error! " + animalName + " should have woken up but it did not.");
                        }
                    }
                }
            }
        }
    }
}
