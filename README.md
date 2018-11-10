# Zoo

This project is a programming test from a potential employer to gauge my Java and Object Oriented Programming skills.

## Requirements

The provided requirements for this project are fairly high level and open ended. While I would normally seek clarification and additional detail with requirements like these I believe it falls within the scope of the test to show that I make good assumptions when the information is not provided to me explicitly. The following assumptions will be treated as requirements:

* An animal's thirsty, hungry, and awake/asleep states are independent. An animal can be hungry and/or thirsty while awake or asleep.
* The zookeeper can only feed an animal when it is hungry and awake.
* The zookeeper can only give an animal water when it is thirsty and awake.
* An animal that is hungry will stay hungry until fed by the zookeeper.
* An animal that is thirsty will stay thirsty until given water by the zookeeper.
* An animal's awake/asleep state is independent of the day/night cycle. An animal can be either awake or asleep day or night.
* The zookeeper can only affect the awake/asleep state of AirBreathers. 
* The zookeeper can wake up sleeping AirBreathers day or night.

## Design

An object oriented design for the provided requirements leads to multiple inheritance. Multiple inheritance is typically dealt with in Java using interfaces. The problem with this approach is that each class that implements an interface provides its own implementation. This can lead to code duplication and makes it hard to enforce all classes that implement an interface implementing the same behavior if that is the desired functionality.

## Development Environment

* Windows 10
* Eclipse IDE for Java Developers Version: 2018-09 (4.9.0)

## Author

* **Andrew Neves** - [https://github.com/AndrewNeves](https://github.com/AndrewNeves)


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

