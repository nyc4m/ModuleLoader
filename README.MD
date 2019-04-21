# Chargeur de Module

## It's an old work

This work was made when I was studying for my DUT, it was aiming at providing an infrastructure to make AI play a chess game, **without using a client/server**.
Instead, it was using the relfexion properties of Java to dynamically load classes representing AI.

### What do you mean ?

I mean that this part of the project was "like" a server, but it was not :slightly_smiling_face:

### How does it work ?

When developping an AI, one had to implement the `IIA` interface, in a separate project.
Then, just pack your AI in a jar (containing the `IIA` interface) and place it inside de `MODULE_A_CHARGER` folder,
And the main program will load your IA.

### Yeah ok, but does it work ?

no idea, probably not haha, it's an old work from school.

## Description
Ce projet permet de charger dynamiquement des jar lors de l'execution du programme. Il n'est pas encore fonctionnel, et loin d'etre optimise, mais ca va venir ! ;)

## A faire
* OPTIMISER !
